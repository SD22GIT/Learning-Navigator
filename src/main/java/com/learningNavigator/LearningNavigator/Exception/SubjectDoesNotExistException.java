package com.learningNavigator.LearningNavigator.Exception;

public class SubjectDoesNotExistException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1384856505945697286L;
	private String message;

	public SubjectDoesNotExistException() {
	}

	public SubjectDoesNotExistException(String msg) {
		super(msg);
		this.message = msg;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
