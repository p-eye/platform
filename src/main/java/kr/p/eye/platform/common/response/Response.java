package kr.p.eye.platform.common.response;

public class Response<T> {

	private T data;
	private String message;

	public Response() {
	}

	public Response(T data, String message) {
		this.data = data;
		this.message = message;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "Response [data=" + data + ", message=" + message + "]";
	}

}
