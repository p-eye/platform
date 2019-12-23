package kr.p.eye.platform.common.error;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ValidExceptionHandler {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Object> handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {

		List<Error> errors = new ArrayList<>();

		for (FieldError filedError : e.getBindingResult().getFieldErrors()) {
			logger.error("{}: {}", filedError.getField(), filedError.getDefaultMessage());
			errors.add(new Error(filedError.getField(), (String) filedError.getRejectedValue(),
					filedError.getDefaultMessage()));
		}

		return new ResponseEntity(new ErrorResponse("Invalid Input Value", 400, errors), HttpStatus.BAD_REQUEST);

	}

	@ExceptionHandler(BindException.class)
	public ResponseEntity<Object> handleBindException(BindException e) {

		List<Error> errors = new ArrayList<>();

		for (FieldError filedError : e.getBindingResult().getFieldErrors()) {
			logger.error("{}: {}", filedError.getField(), filedError.getDefaultMessage());
			errors.add(new Error(filedError.getField(), (String) filedError.getRejectedValue(),
					filedError.getDefaultMessage()));
		}

		return new ResponseEntity(new ErrorResponse("Invalid Input Value", 400, errors), HttpStatus.BAD_REQUEST);

	}

}