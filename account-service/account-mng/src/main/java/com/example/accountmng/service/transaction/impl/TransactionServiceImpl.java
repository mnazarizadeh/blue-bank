package com.example.accountmng.service.transaction.impl;

import com.example.accountmng.client.transaction.TransactionClient;
import com.example.accountmng.service.transaction.TransactionService;
import com.example.accountmng.service.transaction.mapper.TransactionServiceMapper;
import com.example.accountmng.service.transaction.model.TransactionDetailListResult;
import com.example.accountmng.service.transaction.model.TransactionModel;
import com.example.common.exception.BusinessException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class TransactionServiceImpl implements TransactionService {

	private final TransactionClient client;

	private final TransactionServiceMapper mapper;

	@Override
	public void sendTransaction(TransactionModel model) throws BusinessException {
		log.debug("gonna send transaction to transaction service of model -> [{}]", model);

		client.initiateTransaction(mapper.toTransactionRequest(model));
	}

	@Override
	public TransactionDetailListResult getAccountTransactions(String accountIdentifier) throws BusinessException {
		log.debug("gonna fetch transactions of account -> [{}]", accountIdentifier);

		return mapper.toTransactionDetailListResult(client.getAccountTransactions(accountIdentifier));
	}

}
