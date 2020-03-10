package com.gcalsolaro.kafka.instance.model;

public class Greeting {

	private String msg;
	private String name;
	private boolean result = true;

	public Greeting() {

	}

	public Greeting(String msg, String name) {
		this.msg = msg;
		this.name = name;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return msg + ", " + name + "!";
	}

	public boolean isResult() {
		return result;
	}

	public void setResult(boolean result) {
		this.result = result;
	}

}
