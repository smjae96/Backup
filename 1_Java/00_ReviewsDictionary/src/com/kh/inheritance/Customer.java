package com.kh.inheritance;

public class Customer {
	String name;
	String addr;
	String contact;
	double salesPer;
	VIPCustomer vipCust = new VIPCustomer();	// �θ� Ŭ������ �ڽ� ��ü �����ϸ� �ȵ�.
	
	public void initSalesPer() {
		salesPer = 0.1;
	}
	
}
