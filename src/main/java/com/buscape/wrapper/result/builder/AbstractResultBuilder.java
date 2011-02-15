package com.buscape.wrapper.result.builder;

import com.buscape.wrapper.result.Result;

public abstract class AbstractResultBuilder {
	
	protected final Result result;
	
	public AbstractResultBuilder() {
		this.result = new Result();
	}

	public abstract AbstractResultBuilder buildCategory();

	public abstract AbstractResultBuilder buildOffer();

	public abstract AbstractResultBuilder buildProduct();

	public abstract AbstractResultBuilder buildSubcategory();

	public abstract AbstractResultBuilder buildTop5Category();

	public abstract Result getResult();

}