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
	private Double principal;
	@Column(name="rate")
	private Double rate;
	@Column(name="years")
	private Double years;
	@Column(name="interestamt")
	private Double interestAmt;
	
	
	public Interest( Double principal, Double rate, Double years, Double interestAmt) {
	
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
	public Double getPrincipal() {
		return principal;
	}
	public void setPrincipal(Double principal) {
		this.principal = principal;
	}
	public Double getRate() {
		return rate;
	}
	public void setRate(Double rate) {
		this.rate = rate;
	}
	public Double getYears() {
		return years;
	}
	public void setYears(Double years) {
		this.years = years;
	}
	public Double getInterestAmt() {
		return interestAmt;
	}
	public void setInterestAmt(Double interestAmt) {
		this.interestAmt = interestAmt;
	}

	
	
}
