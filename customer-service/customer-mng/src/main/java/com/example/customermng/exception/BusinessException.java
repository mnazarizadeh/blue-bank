package com.example.customermng.exception;

public abstract class BusinessException extends Exception {

	public BusinessException(String message) {
		super(message);
	}

}