package com.spirit.login.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
*
* @author Zizo
*/

public class ResourceBadRequestException extends ApiCommonException{

	
	private static final long serialVersionUID = 1L;

	public ResourceBadRequestException(String message){
    	super(message);
    }

	@Override
	public HttpStatus getStatusCode() {
		// TODO Auto-generated method stub
		return HttpStatus.BAD_REQUEST;
	}
}
