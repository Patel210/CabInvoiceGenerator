package com.capgemini.exception;

public class InvoiceServiceException extends Exception {

	public ExceptionType type;

	public enum ExceptionType {
		NO_RIDE("Atleast 1 ride required for generating summary");

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
