package com.buscape.wrapper.http;

public enum URLRequestMethod {
	DELETE("DELETE"), //$NON-NLS-1$
	GET("GET"), //$NON-NLS-1$
	POST("POST"); //$NON-NLS-1$
	
	private String method;
	
	URLRequestMethod( String requestMethod ){
		this.method = requestMethod;
	}
	
	public String toString(){
		return this.method;
	}
}