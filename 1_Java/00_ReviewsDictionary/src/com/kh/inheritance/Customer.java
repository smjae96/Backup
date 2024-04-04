package com.kh.inheritance;

public class Customer {
	String name;
	String addr;
	String contact;
	double salesPer;
	VIPCustomer vipCust = new VIPCustomer();	// 부모 클래스에 자식 객체 생성하면 안됨.
	
	public void initSalesPer() {
		salesPer = 0.1;
	}
	
}
