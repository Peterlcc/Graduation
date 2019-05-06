package com.peter.bean;

public class ServiceResult<T> {
	private String msg;
	private T result;
	
	public ServiceResult() {
	}
	
	
	public ServiceResult(String msg, T result) {
		this.msg = msg;
		this.result = result;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	public T getResult() {
		return result;
	}
	public void setResult(T result) {
		this.result = result;
	}
	@Override
	public String toString() {
		return "ServiceResult [msg=" + msg + ", result=" + result + "]";
	}
	
}
