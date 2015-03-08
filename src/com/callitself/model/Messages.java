package com.callitself.model;

import java.io.Serializable;

public class Messages implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String message = null;
	private String time = null;

	public Messages() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

}
