package com.example.transactionmng.exception;

import com.example.common.constant.ResponseCode;
import com.example.common.constant.ResponseMessage;
import com.example.common.exception.BusinessException;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class InsufficientBalanceException extends BusinessException {

	public InsufficientBalanceException() {
		this(ResponseMessage.INSUFFICIENT_BALANCE);
	}

	public InsufficientBalanceException(String message) {
		super(ResponseCode.INSUFFICIENT_BALANCE, message);
	}

}
