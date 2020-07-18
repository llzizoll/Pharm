package com.spirit.login.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
*
* @author Zizo
*/

public class ResourceAlreadyExistException extends ApiCommonException{

	
	private static final long serialVersionUID = 1L;

	public ResourceAlreadyExistException(String message){
    	super(message);
    }

	@Override
	public HttpStatus getStatusCode() {
		// TODO Auto-generated method stub
		return HttpStatus.CONFLICT;
	}
}
