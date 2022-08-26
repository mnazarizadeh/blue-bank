package com.example.common.exception;

import com.example.common.constant.ResponseCode;

public class ClientException extends BusinessException {

	public ClientException(String message) {
		this(ResponseCode.FAILURE, message);
	}

	public ClientException(String responseCode, String message) {
		super(responseCode, message);
	}

}