package com.learningNavigator.LearningNavigator.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(value = StudentDoesNotExistException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public @ResponseBody ErrorResponse handleUserAlreadyExistsException(StudentDoesNotExistException ex) {
		return new ErrorResponse(HttpStatus.BAD_REQUEST.value(), ex.getMessage());
	}

	@ExceptionHandler(value = SubjectDoesNotExistException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public @ResponseBody ErrorResponse handleUserAlreadyExistsException(SubjectDoesNotExistException ex) {
		return new ErrorResponse(HttpStatus.BAD_REQUEST.value(), ex.getMessage());
	}

}
