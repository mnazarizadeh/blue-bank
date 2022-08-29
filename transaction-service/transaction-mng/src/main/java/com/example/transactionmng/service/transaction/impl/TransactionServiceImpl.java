package com.example.transactionmng.service.transaction.impl;

import com.example.common.exception.BusinessException;
import com.example.transactionmng.domain.Transaction;
import com.example.transactionmng.domain.constant.TransactionStatus;
import com.example.transactionmng.exception.TransactionNotFoundException;
import com.example.transactionmng.handler.transaction.TransactionContext;
import com.example.transactionmng.repository.TransactionRepository;
import com.example.transactionmng.service.transaction.TransactionService;
import com.example.transactionmng.service.transaction.mapper.TransactionServiceMapper;
import com.example.transactionmng.service.transaction.model.TransactionBriefResult;
import com.example.transactionmng.service.transaction.model.TransactionInitiationModel;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class TransactionServiceImpl implements TransactionService {

	private final TransactionRepository repository;

	private final TransactionContext context;

	private final TransactionServiceMapper mapper;

	@Override
	public TransactionBriefResult initiateTransaction(TransactionInitiationModel model) throws BusinessException {
		log.debug("gonna initiate a transaction by model -> [{}]", model);

		var result = context.getHandler(model.getTransactionType())
				.handle(mapper.toTransactionHandlerModel(model));
		log.debug("transaction generated: [{}]", result);

		return mapper.toTransactionBriefResult(getTransactionByTrackingCode(result.getTrackingCode()));
	}

	@Override
	public TransactionBriefResult verifyTransaction(String trackingCode) throws BusinessException {
		log.debug("gonna verify transaction by trackingCode -> [{}]", trackingCode);

		var transaction = getTransactionByTrackingCode(trackingCode);
		runtVerificationStateMachine(transaction);

		return mapper.toTransactionBriefResult(transaction);
	}

	private Transaction getTransactionByTrackingCode(String trackingCode) throws BusinessException {
		return repository.findByTrackingCode(trackingCode)
				.orElseThrow(() -> new TransactionNotFoundException("transaction not found by tracking code: " + trackingCode));
	}

	private void runtVerificationStateMachine(Transaction transaction) {
		// TODO: implement verification scenario
		TransactionStatus status = switch(transaction.getStatus()) {
			case PAID -> TransactionStatus.VERIFIED;
			default -> transaction.getStatus();
		};

		transaction.setStatus(status);
		repository.save(transaction);
	}
}
