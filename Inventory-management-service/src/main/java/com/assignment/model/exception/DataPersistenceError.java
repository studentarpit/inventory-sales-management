package com.assignment.model.exception;

import lombok.Getter;
import lombok.Setter;

import static com.assignment.constants.ExceptionConstants.DATA_PERSISTENCE_ERROR;

@Getter
@Setter
public class DataPersistenceError extends BaseException {

	private static final long serialVersionUID = 1L;
	
	public DataPersistenceError(String message, String technicalError){
		super(DATA_PERSISTENCE_ERROR, message, technicalError);
	}
}
