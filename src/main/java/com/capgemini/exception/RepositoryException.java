package com.capgemini.exception;

public class RepositoryException extends Exception {
	public ExceptionType type;
	
	public enum ExceptionType {
		USER_NOT_FOUND("User not present in the repository");

		private String exceptionMessage;

		ExceptionType(String exceptionMessage) {
			this.exceptionMessage = exceptionMessage;
		}
		public String getExceptionMessage() {
			return exceptionMessage;
		}
	}
	
	public RepositoryException(ExceptionType type) {
		super(type.getExceptionMessage());
		this.type = type;
	}
}
