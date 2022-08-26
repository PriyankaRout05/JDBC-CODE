package com.village.survey.core.util;

import org.springframework.http.HttpStatus;

public class CustomException extends RuntimeException {

	private static final long serialVersionUID = 7130805616061501980L;
	private HttpStatus httpStatus = HttpStatus.OK;

	public CustomException(String message) {
		super(message);
	}

	public CustomException(String message, HttpStatus httpStatus) {
		super(message);
		this.httpStatus = httpStatus;
	}

	public HttpStatus getHttpStatus() {
		return httpStatus;
	}

	@Override
	public String getMessage() {
		return super.getMessage();
	}
}
