package com.example.accountmng.exception;

import com.example.common.constant.ResponseCode;
import com.example.common.constant.ResponseMessage;
import com.example.common.exception.BusinessException;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class AccountNotFoundException extends BusinessException {

	public AccountNotFoundException() {
		this(ResponseMessage.ACCOUNT_NOT_FOUND);
	}

	public AccountNotFoundException(String message) {
		super(ResponseCode.ACCOUNT_NOT_FOUND, message);
	}

}
