//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vJAXB 2.1.10 in JDK 6 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2011.02.15 at 02:57:18 PM BRST 
//

package com.buscape.wrapper.result.type;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import com.google.gson.annotations.SerializedName;

/**
 * <p>
 * Java class for UserRatingType complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="UserRatingType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="numComments" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="rating" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="links" type="{urn:buscape}LinksType"/>
 *         &lt;element name="specification" type="{urn:buscape}SpecificationType"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "UserRatingType", propOrder = { "numComments", "rating", "links", "specification" })
public class UserRatingType implements Serializable {

	private final static long serialVersionUID = 1L;
	
	@SerializedName("numcomments")
	protected int numComments;
	
	@XmlElement(required = true)
	@SerializedName("rating")
	protected String rating;
	
	@XmlElement(required = true)
	@SerializedName("links")
	protected LinksType links;
	
	@XmlElement(required = true)
	@SerializedName("specification")
	protected SpecificationType specification;

	/**
	 * Gets the value of the numComments property.
	 * 
	 */
	public int getNumComments() {
		return numComments;
	}

	/**
	 * Sets the value of the numComments property.
	 * 
	 */
	public void setNumComments(int value) {
		this.numComments = value;
	}

	/**
	 * Gets the value of the rating property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getRating() {
		return rating;
	}

	/**
	 * Sets the value of the rating property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setRating(String value) {
		this.rating = value;
	}

	/**
	 * Gets the value of the links property.
	 * 
	 * @return possible object is {@link LinksType }
	 * 
	 */
	public LinksType getLinks() {
		return links;
	}

	/**
	 * Sets the value of the links property.
	 * 
	 * @param value
	 *            allowed object is {@link LinksType }
	 * 
	 */
	public void setLinks(LinksType value) {
		this.links = value;
	}

	/**
	 * Gets the value of the specification property.
	 * 
	 * @return possible object is {@link SpecificationType }
	 * 
	 */
	public SpecificationType getSpecification() {
		return specification;
	}

	/**
	 * Sets the value of the specification property.
	 * 
	 * @param value
	 *            allowed object is {@link SpecificationType }
	 * 
	 */
	public void setSpecification(SpecificationType value) {
		this.specification = value;
	}

}
