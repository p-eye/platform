package kr.p.eye.platform.member;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import kr.p.eye.platform.common.error.ErrorResponse;

@ControllerAdvice
public class MemberExceptionHandler {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@ExceptionHandler(MemberException.class)
	public ResponseEntity<Object> handleMemberException(MemberException e, HttpServletRequest request, Model model) {

		String errorMsg = e.getMessage();
		logger.error(errorMsg);

		ErrorResponse error = new ErrorResponse(400, errorMsg);

		return new ResponseEntity(error, HttpStatus.BAD_REQUEST);

	}
}