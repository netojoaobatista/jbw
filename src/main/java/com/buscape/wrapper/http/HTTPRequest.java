package com.buscape.wrapper.http;

public interface HTTPRequest {
	public void close();

	public String getResponse() throws Throwable;

	public int getResponseCode() throws Throwable;

	public void setURL( String spec ) throws Throwable;
}