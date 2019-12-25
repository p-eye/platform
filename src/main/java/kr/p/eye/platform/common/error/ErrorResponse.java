package kr.p.eye.platform.common.error;

import java.util.List;

public class ErrorResponse {

	private String message;
	private int status;
	private List<Error> errors;

	public ErrorResponse() {
	}

	public ErrorResponse(String message, int status, List<Error> errors) {
		this.message = message;
		this.status = status;
		this.errors = errors;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public List<Error> getErrors() {
		return errors;
	}

	public void setErrors(List<Error> errors) {
		this.errors = errors;
	}

	@Override
	public String toString() {
		return "ErrorResponse [message=" + message + ", status=" + status + ", errors=" + errors + "]";
	}

}
