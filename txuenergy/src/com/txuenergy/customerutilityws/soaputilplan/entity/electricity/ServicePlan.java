package com.txuenergy.customerutilityws.soaputilplan.entity.electricity;

public class ServicePlan {
	
	private int sId;
	private String sName;
	private float sAmount;
	
	public int getsId() {
		return sId;
	}
	public void setsId(int sId) {
		this.sId = sId;
	}
	public String getsName() {
		return sName;
	}
	public void setsName(String sName) {
		this.sName = sName;
	}
	public float getsAmount() {
		return sAmount;
	}
	public void setsAmount(float sAmount) {
		this.sAmount = sAmount;
	}
}
