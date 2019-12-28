package kr.p.eye.platform.common.error;

public class Error {

	private String field;
	private String value;
	private String reason;

	public Error() {
	}

	public Error(String field, String value, String reason) {
		this.field = field;
		this.value = value;
		this.reason = reason;
	}

	public Error(String value, String reason) {
		this.value = value;
		this.reason = reason;
	}

	public Error(String reason) {
		this.reason = reason;
	}

	@Override
	public String toString() {
		return "Error [field=" + field + ", value=" + value + ", reason=" + reason + "]";
	}

}
