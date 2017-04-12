package com.ibm.aaspire.poc.entities;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "IDENTITYINFO")
@JsonIgnoreProperties(value = {"owner"}) //We don't want this to be returned to the UI
public class IdentityInfo {

	public IdentityInfo() {
		super();

	}

	public IdentityInfo(Member member, String type, String documentNumber, String issuingParty, Date dateofIssue,
			Date expiryIssue) {
		this.owner = member;
		this.type = type;
		this.documentNumber = documentNumber;
		this.issuer = issuingParty;
		this.issueDate = dateofIssue;
		this.expiryDate = expiryIssue;
	}

	@Id
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	private String id;

	private String type; // Could be License/Passport

	@Column(name = "document_number")
	private String documentNumber; // Could be License/Passport

	private String issuer; // Could be state/country

	@Column(name = "issue_date")
	private Date issueDate;

	@Column(name = "expiry_date")
	private Date expiryDate;

	@ManyToOne
	@JoinColumn(name = "member_id")
	private Member owner;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getDocumentNumber() {
		return documentNumber;
	}

	public void setDocumentNumber(String documentNumber) {
		this.documentNumber = documentNumber;
	}

	public String getIssuer() {
		return issuer;
	}

	public void setIssuer(String issuer) {
		this.issuer = issuer;
	}

	public Date getIssueDate() {
		return issueDate;
	}

	public void setIssueDate(Date issueDate) {
		this.issueDate = issueDate;
	}

	public Date getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}

	public Member getOwner() {
		return owner;
	}

	public void setOwner(Member owner) {
		this.owner = owner;
	}

}
