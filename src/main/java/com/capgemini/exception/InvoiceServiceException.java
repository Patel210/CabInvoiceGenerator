package com.capgemini.exception;

public class InvoiceServiceException extends Exception {

	public ExceptionType type;

	public enum ExceptionType {
		NO_RIDE_TAKEN("Atleast 1 ride required for generating summary"), USER_NOT_FOUND("User not present in the repository");

		private String exceptionMessage;

		ExceptionType(String exceptionMessage) {
			this.exceptionMessage = exceptionMessage;
		}
		public String getExceptionMessage() {
			return exceptionMessage;
		}
	}

	public InvoiceServiceException(ExceptionType type) {
		super(type.getExceptionMessage());
		this.type = type;
	}
}
