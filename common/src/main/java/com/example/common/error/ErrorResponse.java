package com.example.common.error;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ErrorResponse {

	private String responseCode;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
	private Date timestamp;

	private String message;

	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	private String debugMessage;

	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	private List<ValidationErrorDto> subErrors = new ArrayList<>();

	private ErrorResponse() {
		timestamp = new Date();
	}

	public ErrorResponse(String responseCode) {
		this();
		this.responseCode = responseCode;
	}

	public ErrorResponse(String responseCode, String message) {
		this();
		this.responseCode = responseCode;
		this.message = message;
	}

	public ErrorResponse(String responseCode, String message, Throwable ex) {
		this();
		this.responseCode = responseCode;
		this.message = message;
		this.debugMessage = ex.getLocalizedMessage();
	}

	public void addSubError(ValidationErrorDto validationErrorDto) {
		this.subErrors.add(validationErrorDto);
	}

}