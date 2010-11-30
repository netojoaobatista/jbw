package com.buscape.wrapper.http;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class URLRequest implements HTTPRequest {
	private HttpURLConnection conn;
	private URLRequestMethod requestMethod = URLRequestMethod.GET;

	public URLRequest(){
	}

	public URLRequest( String spec ) throws MalformedURLException, IOException {
		setURL( spec );
	}

	public URLRequest( String spec , URLRequestMethod method ) throws MalformedURLException, IOException {
		this( spec );
		requestMethod = method;
	}

	public URLRequest( URLRequestMethod method ){
		requestMethod = method;
	}

	@Override
	public void close() {
		conn.disconnect();
	}

	@Override
	public String getResponse() throws IOException, NullPointerException {
		if ( conn != null ){
			final BufferedReader br = new BufferedReader( new InputStreamReader( conn.getInputStream() ) );
			final StringBuilder sb = new StringBuilder();
			String line = null;

			while ( ( line = br.readLine() ) != null ){
				sb.append( line + '\n' );
			}

			return sb.toString();
		} else {
			throw new NullPointerException( "O objeto de conexão não foi especificado" );
		}
	}

	@Override
	public int getResponseCode() throws IOException {
		return conn.getResponseCode();
	}

	@Override
	public void setURL( String spec ) throws MalformedURLException, IOException {
		final URL url = new URL( spec );

		conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod( requestMethod.toString() );
		conn.setDoOutput( true );
		conn.connect();
	}
}
