package com.example.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {
	
	private String exceptionDetail;
	private Object fieldValue;
	 
	public ResourceNotFoundException( String exceptionDetail, Long fieldValue) {
        super(exceptionDetail+" - "+fieldValue);
        this.exceptionDetail = exceptionDetail;
        this.fieldValue = fieldValue;
    }
	
	public String getExceptionDetail() {
		return exceptionDetail;
	}

	public Object getFieldValue() {
		return fieldValue;
	}
	    
	 
}
