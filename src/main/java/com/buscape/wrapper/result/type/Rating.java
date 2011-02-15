package com.buscape.wrapper.result.type;


public class Rating {

	private RatingEntry eBitRating;
	private RatingEntry userAverageRating;

	public RatingEntry geteBitRating() {
		return eBitRating;
	}

	public void seteBitRating(RatingEntry eBitRating) {
		this.eBitRating = eBitRating;
	}

	public RatingEntry getUserAverageRating() {
		return userAverageRating;
	}

	public void setUserAverageRating(RatingEntry userAverageRating) {
		this.userAverageRating = userAverageRating;
	}

}
