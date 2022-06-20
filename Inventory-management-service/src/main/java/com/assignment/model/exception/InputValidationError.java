package com.assignment.model.exception;

import com.assignment.constants.ExceptionConstants;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class InputValidationError extends BaseException {

	private static final long serialVersionUID = 1L;
	
	public InputValidationError(String message, String technicalError){
		super(ExceptionConstants.INVALID_INPUT_ERROR, message, technicalError);
	}
}
