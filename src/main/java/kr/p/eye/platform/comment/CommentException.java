package kr.p.eye.platform.comment;

public class CommentException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4095369879678637709L;

	private String message;

	public CommentException() {
		super();
	}

	public CommentException(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
