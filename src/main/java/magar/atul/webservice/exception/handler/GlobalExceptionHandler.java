package magar.atul.webservice.exception.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import magar.atul.webservice.exception.InvalidProductException;
import magar.atul.webservice.exception.ProductAlreadyExist;
import magar.atul.webservice.exception.ProductNotFound;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	ExceptionResponse response;
	
	//product not found
	@ExceptionHandler(value=ProductNotFound.class)
	public ResponseEntity<ExceptionResponse> notFoundException(ProductNotFound ex){
		response = new ExceptionResponse(ex.getMessage(),
				HttpStatus.NOT_FOUND.name(), ex.getClass().getSimpleName());
		return new ResponseEntity<ExceptionResponse>(response, HttpStatus.NOT_FOUND);
	}
	
	//
	@ExceptionHandler(value=ProductAlreadyExist.class)
	public ResponseEntity<ExceptionResponse> alreadyExistException(ProductAlreadyExist ex){
		response = new ExceptionResponse(ex.getMessage(),
				HttpStatus.BAD_REQUEST.name(), ex.getClass().getSimpleName());
		return new ResponseEntity<ExceptionResponse>(response, HttpStatus.BAD_REQUEST);
	}
	//
	@ExceptionHandler(value=InvalidProductException.class)
	public ResponseEntity<ExceptionResponse> invalidException(InvalidProductException ex){
		response = new ExceptionResponse(ex.getMessage(),
				HttpStatus.BAD_REQUEST.name(), ex.getClass().getSimpleName());
		return new ResponseEntity<ExceptionResponse>(response, HttpStatus.BAD_REQUEST);
	}

}
