package com.country.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="COUNTRY_DETAILS")
public class Country {

	@Id
	@Column(name="country")
	private String name;
	@Column(name="capital")
	private String capital;
	@Column(name="currency")
	private String currency;
	public Country(String name, String capital, String currency) {
		super();
		this.name = name;
		this.capital = capital;
		this.currency = currency;
	}
	public Country() {
		super();
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCapital() {
		return capital;
	}
	public void setCapital(String capital) {
		this.capital = capital;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	
	
}
