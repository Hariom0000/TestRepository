package com.tavant.hibernate.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class HibernateModel implements Serializable {
	/**
	 * HibernateModel serial id
	 */
	private static final long serialVersionUID = -749404086130206672L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Access(AccessType.PROPERTY)
	private Long testId;
	private String testString;
	private Integer testInteger;
	
	private Date testDate;

	/**
	 * @return the testString
	 */
	public String getTestString() {
		return testString;
	}

	/**
	 * @param testString
	 *            the testString to set
	 */
	public void setTestString(String testString) {
		this.testString = testString;
	}

	/**
	 * @return the testInteger
	 */
	public Integer getTestInteger() {
		return testInteger;
	}

	/**
	 * @param testInteger
	 *            the testInteger to set
	 */
	public void setTestInteger(Integer testInteger) {
		this.testInteger = testInteger;
	}

	/**
	 * @return the testDate
	 */
	public Date getTestDate() {
		return testDate;
	}

	/**
	 * @param testDate
	 *            the testDate to set
	 */
	public void setTestDate(Date testDate) {
		this.testDate = testDate;
	}

}
