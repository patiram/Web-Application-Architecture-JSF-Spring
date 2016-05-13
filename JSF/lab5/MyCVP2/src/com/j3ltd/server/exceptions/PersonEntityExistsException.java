package com.j3ltd.server.exceptions;

/**
* Currently the javadocs on EntityExistsException do not exist
* in the JEE5 beta sdk docs. When it appears, this exception 
* will be removed, and all references replaced by 
* EntityExistsException.
*/
public class PersonEntityExistsException extends Exception {
	public PersonEntityExistsException(String message) {
		super(message);
	}
}
