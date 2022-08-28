package com.example.accountmng.service.transaction;

import com.example.accountmng.service.transaction.model.TransactionModel;
import com.example.common.exception.BusinessException;

public interface TransactionService {

	void sendTransaction(TransactionModel model) throws BusinessException;

}
