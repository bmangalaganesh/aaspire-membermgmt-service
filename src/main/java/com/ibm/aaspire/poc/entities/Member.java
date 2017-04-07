package com.ibm.aaspire.poc.entities;

import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Member {

	@Id
	private String id;

	private String title;

	@Column(name = "given_name")
	private String givenName;

	private String surname;

	@Column(name = "date_of_birth")
	private Date dateOfBirth;

	@Enumerated(EnumType.STRING)
	private MemberStatus status;

	private String plan;

	private String email;

	@OneToOne(cascade=CascadeType.ALL)
	private Address address;

	@Column(name = "phone_number")
	private String phoneNumber;

	public Member(String id, String title, String givenName, String surname, Date dateOfBirth, MemberStatus status,
			String plan, String email, Address address, String phoneNumber) {
		setId(id);
		setTitle(title);
		setGivenName(givenName);
		setSurname(surname);
		setDateOfBirth(dateOfBirth);
		setStatus(status);
		setPlan(plan);
		setEmail(email);
		setAddress(address);
		setPhoneNumber(phoneNumber);
	}
	
	public Member() {
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getGivenName() {
		return givenName;
	}

	public void setGivenName(String givenName) {
		this.givenName = givenName;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public MemberStatus getStatus() {
		return status;
	}

	public void setStatus(MemberStatus status) {
		this.status = status;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getPlan() {
		return plan;
	}

	public void setPlan(String plan) {
		this.plan = plan;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
}
