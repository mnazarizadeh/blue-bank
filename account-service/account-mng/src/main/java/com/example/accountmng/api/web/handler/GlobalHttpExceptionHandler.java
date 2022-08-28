package com.example.accountmng.api.web.handler;

import java.security.InvalidParameterException;

import com.example.common.constant.ResponseCode;
import com.example.common.error.ErrorResponse;
import com.example.common.exception.BusinessException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@Slf4j
@ControllerAdvice
@RequiredArgsConstructor
public class GlobalHttpExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(InvalidParameterException.class)
	public final ResponseEntity<ErrorResponse> handleInvalidParameterException(InvalidParameterException ex) {
		logger.warn("invalid param error", ex);
		return ResponseEntity.badRequest().body(new ErrorResponse(ResponseCode.BAD_REQUEST, ex.getMessage()));
	}

	@ExceptionHandler(BusinessException.class)
	public final ResponseEntity<ErrorResponse> handleBusinessException(BusinessException ex) {
		logger.warn("business error", ex);
		ResponseStatus responseStatus = ex.getClass().getAnnotation(ResponseStatus.class);
		return ResponseEntity.status(responseStatus.code()).body(new ErrorResponse(ex.getResponseCode(), ex.getMessage()));
	}

	@ExceptionHandler(Exception.class)
	public final ResponseEntity<ErrorResponse> handleGeneralException(Exception ex) {
		logger.error("general exception", ex);
		return ResponseEntity.unprocessableEntity().body(new ErrorResponse(ResponseCode.FAILURE, ex.getMessage()));
	}

	@Override
	protected ResponseEntity<Object> handleExceptionInternal(Exception ex, Object body, HttpHeaders headers,
			HttpStatus status, WebRequest request) {
		logger.error("internal exception", ex);
		if (HttpStatus.INTERNAL_SERVER_ERROR.equals(status)) {
			request.setAttribute("javax.servlet.error.exception", ex, 0);
		}
		return new ResponseEntity<>(new ErrorResponse(ResponseCode.INTERNAL_SERVER_ERROR, ex.getMessage()), headers, status);
	}

}