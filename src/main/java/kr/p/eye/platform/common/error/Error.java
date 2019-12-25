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

	public String getField() {
		return field;
	}

	public void setField(String field) {
		this.field = field;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	@Override
	public String toString() {
		return "Error [field=" + field + ", value=" + value + ", reason=" + reason + "]";
	}

}
