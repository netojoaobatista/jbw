package com.buscape.wrapper.result.type;

public class Parcel {
	/**
	 * Preço da parcela
	 */
	private double value;

	/**
	 * Número de parcelas
	 */
	private int number;

	/**
	 * Taxa de juros
	 */
	private double interest;

	public Parcel() {
		value = 0;
		number = 0;
		interest = 0;
	}

	public Parcel( double value , int number ) {
		this.value = value;
		this.number = number;
	}

	public Parcel( double value , int number , double interest ) {
		this( value , number );
		this.interest = interest;
	}

	public final double getInterest() {
		return interest;
	}

	public final int getNumber() {
		return number;
	}

	public final double getValue() {
		return value;
	}

	public final void setInterest( double interest ) {
		this.interest = interest;
	}

	public final void setNumber( int number ) {
		this.number = number;
	}

	public final void setValue( double value ) {
		this.value = value;
	}
}