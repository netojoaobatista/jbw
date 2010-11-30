package com.buscape.wrapper.request;

import com.buscape.wrapper.http.URLVariables;
import com.buscape.wrapper.shared.Medal;

public class Filter {
	private final URLVariables filterVariables;

	public Filter() {
		filterVariables = new URLVariables();
	}

	public boolean has( String key ) {
		return filterVariables.containsVariable( key );
	}

	public void setMedal( Medal medal ) {
		filterVariables.setVariable( "medal" , medal.toString() );
	}

	public void setPage( int page ) {
		filterVariables.setVariable( "page" , Integer.toString( page ) );
	}

	public void setPriceMax( double priceMax ) {
		filterVariables.setVariable( "priceMax" , Double.toString( priceMax ) );
	}

	public void setPriceMin( double priceMin ) {
		filterVariables.setVariable( "priceMin" , Double.toString( priceMin ) );
	}

	public void setResults( int results ) {
		filterVariables.setVariable( "results" , Integer.toString( results ) );
	}

	public void setSort( Sort sort ){
		filterVariables.setVariable( "sort" , sort.toString() );
	}

	public void setVariable( String key , String value ) {
		filterVariables.setVariable( key , value );
	}

	@Override
	public String toString() {
		return filterVariables.toString();
	}
}