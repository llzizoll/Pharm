package com.spirit.login.utils;




import java.util.Date;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;





@JsonSerialize
@Component
 public class Response {

	private String code;

	private String status;

	private String message;
	
	private Date timeStamp;

    private Object object;



	public Response(String code, String status, String message,Date timeStamp, Object object) {

		this.code = code;

		this.status = status;

		this.message = message;
		
		this.timeStamp = timeStamp;

		this.object = object;

	}



	public Response() {

	}



	public Response(String code, String status, String message) {



		this.code = code;

		this.status = status;

		this.message = message;

	}



	public String getStatus() {
		return status;
	}



	public void setStatus(String status) {
		this.status = status;
	}





	public Object getObject() {
		return object;
	}



	public void setObject(Object object) {
		this.object = object;
	}



	public String getMessage() {
		return message;
	}



	public void setMessage(String message) {
		this.message = message;
	}



	public Date getTimeStamp() {
		return timeStamp;
	}



	public void setTimeStamp(Date timeStamp) {
		this.timeStamp = timeStamp;
	}





	





}