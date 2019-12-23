package kr.p.eye.platform.member;

public class MemberException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7082810703449252967L;

	private String field;
	private String value;
	private String message;

	public MemberException() {
		super();
	}

	public MemberException(String field, String value, String message) {
		this.field = field;
		this.value = value;
		this.message = message;
	}

	public MemberException(String value, String message) {
		this.value = value;
		this.message = message;
	}

	public String getField() {
		return field;
	}

	public String getValue() {
		return value;
	}

	public String getMessage() {
		return message;
	}

}
