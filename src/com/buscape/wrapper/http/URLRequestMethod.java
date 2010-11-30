package com.buscape.wrapper.http;

public enum URLRequestMethod {
	DELETE("DELETE"),
	GET("GET"),
	POST("POST");
	
	private String method;
	
	URLRequestMethod( String requestMethod ){
		this.method = requestMethod;
	}
	
	public String toString(){
		return this.method;
	}
}