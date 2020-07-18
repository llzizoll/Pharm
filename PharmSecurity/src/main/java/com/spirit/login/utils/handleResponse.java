package com.spirit.login.utils;




import java.util.Date;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;





 public class handleResponse {
	/* methods to handle response messages */
	public static Response getResponse(String code, String status, String massage) {

		return new Response(code, status, massage);

	}

	public static  Response getResponse(String code, String status, String massage,Date timeStamp, Object object) {

		return new Response(code, status, massage,timeStamp, object);

	}
	
	
	
	
	




}