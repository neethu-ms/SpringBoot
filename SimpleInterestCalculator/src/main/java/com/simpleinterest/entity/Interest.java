package com.simpleinterest.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;




@Entity
@Table(name = "INTEREST_DETAILS")


public class Interest {
	@Id 
	@Column(name="id", updatable=false,nullable=false)
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="principal")
	Float principal;
	@Column(name="rate")
	Float rate;
	@Column(name="years")
	Float years;
	@Column(name="interestamt")
	Float interestAmt;
	public Interest(Integer id, Float principal, Float rate, Float years, Float interestAmt) {
		super();
		this.id = id;
		this.principal = principal;
		this.rate = rate;
		this.years = years;
		this.interestAmt = interestAmt;
	}
	
	public Interest( Float principal, Float rate, Float years, Float interestAmt) {
	
		this.principal = principal;
		this.rate = rate;
		this.years = years;
		this.interestAmt = interestAmt;
	}
	public Interest() {
		super();
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Float getPrincipal() {
		return principal;
	}
	public void setPrincipal(Float principal) {
		this.principal = principal;
	}
	public Float getRate() {
		return rate;
	}
	public void setRate(Float rate) {
		this.rate = rate;
	}
	public Float getYears() {
		return years;
	}
	public void setYears(Float years) {
		this.years = years;
	}
	public Float getInterestAmt() {
		return interestAmt;
	}
	public void setInterestAmt(Float interestAmt) {
		this.interestAmt = interestAmt;
	}

	
	
}
