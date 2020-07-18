package com.spirit.login.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
*
* @author Zizo
*/
@ResponseStatus(value = HttpStatus.NO_CONTENT)

public class ResourceNoContentException extends ApiCommonException{

	
	private static final long serialVersionUID = 1L;

	public ResourceNoContentException(String message){
    	super(message);
    }

	@Override
	public HttpStatus getStatusCode() {
		// TODO Auto-generated method stub
		return HttpStatus.NO_CONTENT;
	}
}
