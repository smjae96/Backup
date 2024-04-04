package com.kh.example.practice2.model.vo;

public class Product {

	private String pName;
	private int price;
	private String brand;
	
	public Product() {
		
	}
	
	public void information() {
		System.out.printf("제품명: %s, 가격: %d, 브랜드: %s " , pName, price, brand);
	}
}
