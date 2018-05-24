package com.cg.training.exception;

public class NullOrNegativeValuesException extends RuntimeException
{
	private static final long serialVersionUID = 1L;

	public NullOrNegativeValuesException(String message) {
		super(message);
	}

}
