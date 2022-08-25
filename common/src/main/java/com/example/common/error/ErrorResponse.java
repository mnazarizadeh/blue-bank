package com.example.common.error;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.example.common.constant.ExceptionMessage;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import org.springframework.http.HttpStatus;

@Data
public class ErrorResponse {

	private HttpStatus status;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss")
	private Date timestamp;

	private String message;

	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	private String debugMessage;

	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	private List<ValidationErrorDto> subErrors = new ArrayList<>();

	private ErrorResponse() {
		timestamp = new Date();
	}

	public ErrorResponse(HttpStatus status) {
		this();
		this.status = status;
	}

	public ErrorResponse(HttpStatus status, String message) {
		this();
		this.status = status;
		this.message = message;
	}

	public ErrorResponse(HttpStatus status, Throwable ex) {
		this();
		this.status = status;
		this.message = ExceptionMessage.UNEXPECTED_ERROR;
		this.debugMessage = ex.getLocalizedMessage();
	}

	public ErrorResponse(HttpStatus status, String message, Throwable ex) {
		this();
		this.status = status;
		this.message = message;
		this.debugMessage = ex.getLocalizedMessage();
	}

	public void addSubError(ValidationErrorDto validationErrorDto) {
		this.subErrors.add(validationErrorDto);
	}

}