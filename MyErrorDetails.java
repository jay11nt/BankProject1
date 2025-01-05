package in.bank.exception;

import java.time.LocalDateTime;

public class MyErrorDetails 
{
	private LocalDateTime timeStamp; 
	private String details;
	private String message;
	
	
	public MyErrorDetails() {		//default constructor
		super();
		
	}


	public MyErrorDetails(LocalDateTime timeStamp, String details, String message) {		//parameterized constructor
		super();
		this.timeStamp = timeStamp;
		this.details = details;
		this.message = message;
	}

	//getter setters
	public LocalDateTime getTimeStamp() {
		return timeStamp;
	}


	public void setTimeStamp(LocalDateTime timeStamp) {
		this.timeStamp = timeStamp;
	}


	public String getDetails() {
		return details;
	}


	public void setDetails(String details) {
		this.details = details;
	}


	public String getMessage() {
		return message;
	}


	public void setMessage(String message) {
		this.message = message;
	}

	//to-string method
	@Override
	public String toString() {
		return "MyErrorDetails [timeStamp=" + timeStamp + ", details=" + details + ", message=" + message + "]";
	}
	
	
	
}
