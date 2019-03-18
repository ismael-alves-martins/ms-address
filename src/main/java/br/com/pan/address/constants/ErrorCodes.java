package br.com.pan.address.constants;

public enum ErrorCodes {

	INTERNAL_SERVER_ERROR("500", "INTERNAL SERVER ERROR"),
	CUSTOMER_NOT_FOUND("404", "CUSTOMER NOT FOUND"),
	RESOURCE_NOT_FOUND("404", "RESOURCE NOT FOUND"),
	BAD_REQUEST("400", "BAD REQUEST");
	
	private final String code;
	private final String message;
	
	private ErrorCodes(String code, String message) {
		this.code = code;
		this.message = message;
	}
	
	public String getCode() {
		return code;
	}
	
	public String getMessage() {
		return message;
	}
}
