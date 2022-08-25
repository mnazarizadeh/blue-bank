package com.example.customermng.exception;

import com.example.customermng.util.ExceptionMessage;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class CustomerNotFoundException extends BusinessException {

	public CustomerNotFoundException() {
		this(ExceptionMessage.CUSTOMER_NOT_FOUND);
	}

	public CustomerNotFoundException(String message) {
		super(message);
	}

}
