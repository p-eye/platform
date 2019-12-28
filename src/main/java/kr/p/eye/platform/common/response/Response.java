package kr.p.eye.platform.common.response;

import java.util.HashMap;

public class Response<T> {

	private HashMap<String, ?> result;
	private String message;

	public Response() {
	}

	public Response(HashMap<String, ?> result, String message) {
		this.result = result;
		this.message = message;
	}

	public HashMap<String, ?> getResult() {
		return result;
	}

	public void setResult(HashMap<String, ?> result) {
		this.result = result;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "Response [result=" + result + ", message=" + message + "]";
	}

}
