package kr.p.eye.platform.member;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;

import kr.p.eye.platform.common.error.Error;
import kr.p.eye.platform.common.error.ErrorResponse;

@ControllerAdvice
public class MemberExceptionHandler {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@ExceptionHandler(MemberException.class)
	public ResponseEntity<Object> handleMemberException(MemberException e) {

		String errorMsg = e.getMessage();
		String errorValue = e.getValue();
		logger.error("{}: {}", errorValue, errorMsg);

		List<Error> errors = new ArrayList<>();
		errors.add(new Error("memberId", errorValue, errorMsg));

		return new ResponseEntity(new ErrorResponse("Your id is already used", 400, errors), HttpStatus.BAD_REQUEST);

	}

	@ExceptionHandler(MySQLIntegrityConstraintViolationException.class)
	public ResponseEntity<Object> handleMySQLIntegrityConstraintViolationException(
			MySQLIntegrityConstraintViolationException e) {

		String errorMsg = e.getMessage();
		logger.error("{}", errorMsg);

		// value 값 가져올 수 ㅇ있낭??

		List<Error> errors = new ArrayList<>();
		errors.add(new Error("memberId", "", errorMsg));

		return new ResponseEntity(new ErrorResponse("Your id is already used", 400, errors), HttpStatus.BAD_REQUEST);
	}
}