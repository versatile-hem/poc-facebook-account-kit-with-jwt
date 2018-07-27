package com.wolftechnica.fb.accountkit.service;

public enum FacebookExceptionCodes {

	UNABLE_TO_CONNECT(10001, "unable to connect to faceboook.")

	;

	private FacebookExceptionCodes(Integer code, String description) {
		this.code = code;
		this.description = description;
	}

	/** The exception code. */
	private final Integer code;

	/** The exception description. */
	private final String description;

	public Integer getCode() {
		return code;
	}

	public String getDescription() {
		return description;
	}

}
