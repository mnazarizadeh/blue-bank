package com.example.transactionmng.handler.transaction;

import com.example.transactionmng.domain.constant.TransactionType;
import com.example.transactionmng.handler.transaction.model.TransactionHandlerModel;
import com.example.transactionmng.handler.transaction.model.TransactionHandlerResult;

public interface TransactionStrategy {

	TransactionType getType();

	TransactionHandlerResult handle(TransactionHandlerModel model);

}
