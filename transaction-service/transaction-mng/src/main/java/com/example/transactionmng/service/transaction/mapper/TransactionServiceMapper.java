package com.example.transactionmng.service.transaction.mapper;

import com.example.transactionmng.domain.Transaction;
import com.example.transactionmng.handler.transaction.model.TransactionHandlerModel;
import com.example.transactionmng.service.transaction.model.TransactionBriefResult;
import com.example.transactionmng.service.transaction.model.TransactionDetail;
import com.example.transactionmng.service.transaction.model.TransactionInitiationModel;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TransactionServiceMapper {

	TransactionHandlerModel toTransactionHandlerModel(TransactionInitiationModel model);

	TransactionBriefResult toTransactionBriefResult(Transaction transaction);

	TransactionDetail toTransActionDetail(Transaction transaction);

}
