package kr.p.eye.platform.comment;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import kr.p.eye.platform.common.error.Error;
import kr.p.eye.platform.common.error.ErrorResponse;

@ControllerAdvice
public class CommentExceptionHandler {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@ExceptionHandler(CommentException.class)
	public ResponseEntity<Object> handleMemberException(CommentException e) {

		String errorMsg = e.getMessage();
		logger.error("{}", errorMsg);

		List<Error> errors = new ArrayList<>();
		errors.add(new Error(errorMsg));

		return new ResponseEntity<>(new ErrorResponse(errorMsg, 400, errors), HttpStatus.BAD_REQUEST);

	}

}