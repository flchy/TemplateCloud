package com.flchy.cloud.response;


import com.flchy.cloud.enums.EWarning;
import io.swagger.annotations.ApiModel;

/**
 * @author nieqs
 */
@ApiModel(description = "统一返回")
public class ResponseResult<T> {
	private String message="success";
	private int code=0;
	private T data;
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public T getData() {
		return data;
	}

	public ResponseResult() {
	}

	public ResponseResult(T data) {
		this.data = data;
	}

	public ResponseResult(T data, String message) {
		this.data = data;
		this.message = message;
	}

	public ResponseResult(EWarning warning) {
		this.setMessage(warning.getName());
		this.setCode(warning.getValue());
	}

	public ResponseResult(EWarning warning, String message) {
		this.setMessage(message);
		this.setCode(warning.getValue());
	}
	
	public void setData(T data) {
		this.data = data;
	}
	@Override
	public String toString() {
		return "ResponseResultDto [message=" + message + ", code=" + code + ", data=" + data + "]";
	}

	public boolean getIsSuccess() {
		return this.code==0;
	}
}
