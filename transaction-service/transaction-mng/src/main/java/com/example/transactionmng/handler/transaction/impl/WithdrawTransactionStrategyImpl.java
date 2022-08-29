package com.example.transactionmng.handler.transaction.impl;

import com.example.common.exception.BusinessException;
import com.example.common.exception.ClientException;
import com.example.common.util.TrackingCodeProvider;
import com.example.transactionmng.client.account.AccountClient;
import com.example.transactionmng.domain.constant.TransactionStatus;
import com.example.transactionmng.domain.constant.TransactionType;
import com.example.transactionmng.exception.InsufficientBalanceException;
import com.example.transactionmng.handler.transaction.TransactionStrategy;
import com.example.transactionmng.handler.transaction.mapper.TransactionStrategyMapper;
import com.example.transactionmng.handler.transaction.model.TransactionHandlerModel;
import com.example.transactionmng.handler.transaction.model.TransactionHandlerResult;
import com.example.transactionmng.repository.TransactionRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class WithdrawTransactionStrategyImpl implements TransactionStrategy {

	private final TransactionRepository repository;

	private final TransactionStrategyMapper mapper;

	private final AccountClient client;

	@Override
	public TransactionType getType() {
		return TransactionType.WITHDRAW;
	}

	@Override
	public TransactionHandlerResult handle(TransactionHandlerModel model) throws BusinessException {
		log.debug("gonna withdraw from the account: [{}]", model);

		var trackingCode = TrackingCodeProvider.generate();
		var transaction = mapper.toTransaction(trackingCode, model, getType());

		try {
			checkBalance(model);
			model.setAmount(-model.getAmount());
			var response = client.updateBalance(mapper.toUpdateBalanceRequest(model));
			transaction.setStatus(TransactionStatus.PAID);
			transaction.setFinalBalance(response.getBalance());
		} catch (ClientException | InsufficientBalanceException exception) {
			transaction.setStatus(TransactionStatus.FAILED);
			throw exception;
		} finally {
			repository.save(transaction);
		}
		return mapper.toTransactionHandlerResult(transaction);
	}

	private void checkBalance(TransactionHandlerModel model) throws BusinessException {
		var balanceResponse = client.getBalance(model.getAccountIdentifier());
		if (balanceResponse.getBalance() < model.getAmount()) {
			throw new InsufficientBalanceException(
					"insufficient account balance to withdraw from account: " + model.getAccountIdentifier());
		}
	}

}
