package com.spirit.login.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
*
* @author Zizo
*/

// entend mn ApiCommonException 
public class ResourceNotFoundException extends ApiCommonException{

	
	private static final long serialVersionUID = 1L;

	public ResourceNotFoundException(String message){
    	super(message);
    }

	@Override

	public HttpStatus getStatusCode() {
		// TODO Auto-generated method stub
		return  HttpStatus.NOT_FOUND;
	}
}
