package br.com.pan.address.exception;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

import br.com.pan.address.constants.ErrorCodes;
import lombok.Getter;

@Getter
public class ExceptionResponse implements Serializable {

	private static final long serialVersionUID = -5093963228709317399L;

	private String code;
	private String message;
	private List<String> details;
	
	public ExceptionResponse(final ErrorCodes error, String details) {
		this.code = error.getCode();
		this.message = error.getMessage();
		this.details = Arrays.asList(details);
	}
	
	public ExceptionResponse(final ErrorCodes error, List<String> details) {
		this.code = error.getCode();
		this.message = error.getMessage();
		this.details = details;
	}
}
