package com.example.accountmng.service.transaction.mapper;

import com.example.accountmng.service.transaction.model.TransactionDetailListResult;
import com.example.accountmng.service.transaction.model.TransactionModel;
import com.example.transactionmng.spec.request.TransactionRequest;
import com.example.transactionmng.spec.response.TransactionDetailListResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TransactionServiceMapper {

	TransactionRequest toTransactionRequest(TransactionModel model);

	TransactionDetailListResult toTransactionDetailListResult(TransactionDetailListResponse response);

}
