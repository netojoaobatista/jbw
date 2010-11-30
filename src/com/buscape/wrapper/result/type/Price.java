package com.buscape.wrapper.result.type;

public class Price {
	private double value;
	private Parcel parcel;

	public Price() {
	}

	public Price( double value ) {
		this.value = value;
		parcel = new Parcel();
	}

	public Price( double value , Parcel parcel ) {
		this.value = value;
		this.parcel = parcel;
	}

	public final Parcel getParcel() {
		return parcel;
	}

	public final double getValue() {
		return value;
	}

	public final void setParcel( Parcel parcel ) {
		this.parcel = parcel;
	}

	public final void setValue( double value ) {
		this.value = value;
	}
}