package telran.b7a.puzzle.controller;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import telran.b7a.puzzle.exceptions.NotFoundException;
import telran.b7a.puzzle.exceptions.ValidationException;

import static java.time.LocalDateTime.now;

@RestControllerAdvice
public class ControllerAdvisor {
	
	@ExceptionHandler(ValidationException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ErrorResponse handleValidationException(ValidationException validationException) {
		return ErrorResponse.builder()
				.message(validationException.getMessage())
				.status(HttpStatus.BAD_REQUEST)
				.timestamp(now())
				.build();	
	}
	
	@ExceptionHandler(NotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public ErrorResponse handleNotFoundException(NotFoundException notFoundException) {
		return ErrorResponse.builder()
				.message(notFoundException.getMessage())
				.status(HttpStatus.NOT_FOUND)
				.timestamp(now())
				.build();
		
	}
}
