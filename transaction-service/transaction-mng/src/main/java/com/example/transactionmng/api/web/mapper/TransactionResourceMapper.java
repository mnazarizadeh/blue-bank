package com.example.transactionmng.api.web.mapper;

import com.example.transactionmng.service.transaction.model.TransactionBriefResult;
import com.example.transactionmng.service.transaction.model.TransactionInitiationModel;
import com.example.transactionmng.spec.request.TransactionRequest;
import com.example.transactionmng.spec.response.TransactionBriefResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TransactionResourceMapper {

	TransactionInitiationModel toTransactionInitiationModel(TransactionRequest request);

	TransactionBriefResponse toTransactionBriefResponse(TransactionBriefResult result);

}
