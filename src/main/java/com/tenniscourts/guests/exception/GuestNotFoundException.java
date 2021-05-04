package com.tenniscourts.guests.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class GuestNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6079029663184291829L;

	public GuestNotFoundException(String message) {
		super(message);
	}

}
