package magar.atul.webservice.exception.handler;

import java.util.Date;

public class ExceptionResponse {
	
	private String message;
	private String status;
	private String error;
	private Date timestamp;
	
	
	public ExceptionResponse() {}
	
	public ExceptionResponse(String message, String status, String error) {
		super();
		this.message = message;
		this.status = status;
		this.error = error;
		this.timestamp = new Date();
	}
	//getter setter
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getError() {
		return error;
	}
	public void setError(String error) {
		this.error = error;
	}
	public Date getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}
	
	

}
