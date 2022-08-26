package com.example.customermng.exception;

import com.example.common.constant.ResponseCode;
import com.example.common.constant.ResponseMessage;
import com.example.common.exception.BusinessException;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class CustomerNotFoundException extends BusinessException {

	public CustomerNotFoundException() {
		this(ResponseMessage.CUSTOMER_NOT_FOUND);
	}

	public CustomerNotFoundException(String message) {
		super(ResponseCode.CUSTOMER_NOT_FOUND, message);
	}

}
