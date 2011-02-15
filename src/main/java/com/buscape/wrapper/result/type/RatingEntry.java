package com.buscape.wrapper.result.type;

import java.util.List;

import com.buscape.wrapper.util.Messages;
import com.google.gson.annotations.SerializedName;

public class RatingEntry {

	public enum RatingKind {
		USER, EBIT;
		
		public static RatingKind fromString(String key) {
			if(Messages.getString("RatingKind.ebit").equals(key)) { //$NON-NLS-1$
				return EBIT;
			} else if(Messages.getString("RatingKind.user").equals(key)) { //$NON-NLS-1$
				return USER;
			} else {
				return null;
			}
		}
		
	}

	private RatingKind king;

	private String rating;
	@SerializedName("numcomments")
	private int numComments;
	@SerializedName("links")
	private List<Link> linkList;

	public RatingKind getKing() {
		return king;
	}

	public void setKing(RatingKind king) {
		this.king = king;
	}

	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	public int getNumComments() {
		return numComments;
	}

	public void setNumComments(int numComments) {
		this.numComments = numComments;
	}

	public List<Link> getLinkList() {
		return linkList;
	}

	public void setLinkList(List<Link> linkList) {
		this.linkList = linkList;
	}
	
}
