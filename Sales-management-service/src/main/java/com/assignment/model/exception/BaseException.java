package com.assignment.model.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class BaseException extends RuntimeException{
	private static final long serialVersionUID = 7324687236481L;
	protected String code;
	protected String technicalError;
	protected String message;
}
