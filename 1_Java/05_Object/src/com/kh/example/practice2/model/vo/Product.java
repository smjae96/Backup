package com.kh.example.practice2.model.vo;

public class Product {

	private String pName;
	private int price;
	private String brand;
	
	public Product() {
		
	}
	
	public void information() {
		System.out.printf("��ǰ��: %s, ����: %d, �귣��: %s " , pName, price, brand);
	}
}
