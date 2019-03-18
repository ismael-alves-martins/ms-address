package br.com.pan.address.exception.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import br.com.pan.address.constants.ErrorCodes;
import br.com.pan.address.exception.CustomerNotFoundException;
import br.com.pan.address.exception.ExceptionResponse;
import br.com.pan.address.exception.ResourceNotFoundException;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(CustomerNotFoundException.class)
	public final ResponseEntity<ExceptionResponse> handleCustomerNotFoundException(CustomerNotFoundException ex, WebRequest request) {
		ExceptionResponse exceptionResponse = new ExceptionResponse(ErrorCodes.CUSTOMER_NOT_FOUND, ex.getMessage());
		request.getDescription(false);
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exceptionResponse);
	}
	
	@ExceptionHandler(ResourceNotFoundException.class)
	public final ResponseEntity<ExceptionResponse> handleResourceNotFoundException(ResourceNotFoundException ex, WebRequest request) {
		ExceptionResponse exceptionResponse = new ExceptionResponse(ErrorCodes.RESOURCE_NOT_FOUND, ex.getMessage());
		request.getDescription(false);
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exceptionResponse);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<Object> handleAllException(Exception ex, WebRequest request) {
		ExceptionResponse exceptionResponse = new ExceptionResponse(ErrorCodes.RESOURCE_NOT_FOUND, ex.getMessage());
		request.getDescription(false);
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(exceptionResponse);
	}
}
