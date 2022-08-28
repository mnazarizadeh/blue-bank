package com.example.transactionmng.handler.transaction.impl;

import com.example.transactionmng.domain.constant.TransactionType;
import com.example.transactionmng.handler.transaction.TransactionStrategy;
import com.example.transactionmng.handler.transaction.model.TransactionHandlerModel;
import com.example.transactionmng.handler.transaction.model.TransactionHandlerResult;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class DepositTransactionStrategyImpl implements TransactionStrategy {

	@Override
	public TransactionType getType() {
		return TransactionType.DEPOSIT;
	}

	@Override
	public TransactionHandlerResult handle(TransactionHandlerModel model) {
		return null;
	}

}
