package com.example.transactionmng.service.transaction;

import com.example.common.exception.BusinessException;
import com.example.transactionmng.service.transaction.model.TransactionDetailListResult;
import com.example.transactionmng.service.transaction.model.TransactionInitiationModel;
import com.example.transactionmng.service.transaction.model.TransactionBriefResult;

public interface TransactionService {

	TransactionBriefResult initiateTransaction(TransactionInitiationModel model) throws BusinessException;

	TransactionBriefResult verifyTransaction(String trackingCode) throws BusinessException;

	TransactionDetailListResult getAccountTransactions(String accountIdentifier);

}
