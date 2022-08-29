package com.example.transactionmng.handler.transaction.mapper;

import com.example.accountmng.spec.request.UpdateBalanceRequest;
import com.example.transactionmng.domain.Transaction;
import com.example.transactionmng.domain.constant.TransactionType;
import com.example.transactionmng.handler.transaction.model.TransactionHandlerModel;
import com.example.transactionmng.handler.transaction.model.TransactionHandlerResult;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface TransactionStrategyMapper {

	UpdateBalanceRequest toUpdateBalanceRequest(TransactionHandlerModel model);

	@Mapping(target = "trackingCode", source = "trackingCode")
	@Mapping(target = "accountIdentifier", source = "model.accountIdentifier")
	@Mapping(target = "amount", source = "model.amount")
	@Mapping(target = "type", source = "type")
	Transaction toTransaction(String trackingCode, TransactionHandlerModel model, TransactionType type);

	TransactionHandlerResult toTransactionHandlerResult(Transaction transaction);
}
