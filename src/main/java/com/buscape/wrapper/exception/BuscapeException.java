package com.buscape.wrapper.exception;

public class BuscapeException extends Exception {
	private static final long serialVersionUID = -4749034515436513686L;

	public BuscapeException( String message ) {
		super( message );
	}

	public BuscapeException( Throwable cause ) {
		super( cause );
	}
}