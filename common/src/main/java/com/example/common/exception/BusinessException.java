package com.example.common.exception;

import lombok.Getter;

@Getter
public abstract class BusinessException extends Exception {

	private final String responseCode;

	public BusinessException(String responseCode, String message) {
		super(message);
		this.responseCode = responseCode;
	}

	public BusinessException(String responseCode, Throwable cause) {
		super(cause);
		this.responseCode = responseCode;
	}

	public BusinessException(String responseCode, String message, Throwable cause) {
		super(message, cause);
		this.responseCode = responseCode;
	}

}