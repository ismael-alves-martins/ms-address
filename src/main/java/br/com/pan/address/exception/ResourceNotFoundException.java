package br.com.pan.address.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class ResourceNotFoundException extends RuntimeException {

	private static final long serialVersionUID = -3546293172079710270L;

	private final String code;
	private final String message;
	

	public ResourceNotFoundException(String code, String message) {
		super();
		this.code = code;
		this.message = message;
	}
}
