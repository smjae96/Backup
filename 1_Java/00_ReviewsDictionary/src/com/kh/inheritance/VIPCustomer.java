package com.kh.inheritance;

public class VIPCustomer extends Customer {
	
	
	@Override
	public void initSalesPer() {
		salesPer = 0.5;
	}
}
