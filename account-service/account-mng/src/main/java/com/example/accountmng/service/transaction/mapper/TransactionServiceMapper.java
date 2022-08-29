package com.example.accountmng.service.transaction.mapper;

import com.example.accountmng.service.transaction.model.TransactionModel;
import com.example.transactionmng.spec.request.TransactionRequest;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TransactionServiceMapper {

	TransactionRequest toTransactionRequest(TransactionModel model);

}
