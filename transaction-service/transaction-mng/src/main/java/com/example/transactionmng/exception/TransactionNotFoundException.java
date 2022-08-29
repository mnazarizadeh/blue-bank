package com.example.transactionmng.exception;

import com.example.common.constant.ResponseCode;
import com.example.common.constant.ResponseMessage;
import com.example.common.exception.BusinessException;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class TransactionNotFoundException extends BusinessException {

	public TransactionNotFoundException() {
		this(ResponseMessage.TRANSACTION_NOT_FOUND);
	}

	public TransactionNotFoundException(String message) {
		super(ResponseCode.TRANSACTION_NOT_FOUND, message);
	}

}
