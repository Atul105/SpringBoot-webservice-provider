package magar.atul.webservice.exception;

public class ProductAlreadyExist extends RuntimeException{

	private static final long serialVersionUID = 1L;

	ProductAlreadyExist(String message){
		super(message);
	}
}
