package com.ibm.aaspire.poc.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Address {

	@Id
	@GeneratedValue
	private String id;

	private String line1;

	private String line2;

	private String suburb;

	@Enumerated(EnumType.STRING)
	private State state;

	@Column(name="post_code")
	private String postCode;

	private String country;

	public Address(String line1, String line2, String suburb, State state, String postCode, String country) {
		setLine1(line1);
		setLine2(line2);
		setSuburb(suburb);
		setState(state);
		setPostCode(postCode);
		setCountry(country);
	}

	public Address() {
	}
	
	public String getLine1() {
		return line1;
	}

	public void setLine1(String line1) {
		this.line1 = line1;
	}

	public String getLine2() {
		return line2;
	}

	public void setLine2(String line2) {
		this.line2 = line2;
	}

	public String getSuburb() {
		return suburb;
	}

	public void setSuburb(String suburb) {
		this.suburb = suburb;
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

	public String getPostCode() {
		return postCode;
	}

	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

}
