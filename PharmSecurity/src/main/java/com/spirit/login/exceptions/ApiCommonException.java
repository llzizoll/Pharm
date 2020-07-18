package com.spirit.login.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
*
* @author Zizo
*/

public abstract class ApiCommonException extends Exception{

	
	private static final long serialVersionUID = 1L;

	public ApiCommonException(String message){
    	super(message);
    }
	
	public abstract HttpStatus getStatusCode();
}
