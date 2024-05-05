package com.learningNavigator.LearningNavigator.Exception;

public class StudentDoesNotExistException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3058367369272666517L;
	private String message;

	public StudentDoesNotExistException() {
	}

	public StudentDoesNotExistException(String msg) {
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
