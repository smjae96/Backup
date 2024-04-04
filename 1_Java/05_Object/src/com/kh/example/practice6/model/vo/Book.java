package com.kh.example.practice6.model.vo;

public class Book {
	// �ʵ��
	private String title;
	private String publisher;
	private String author;
	private int price;
	private double discountRate;
	
	// �����ں� (3) : �����ε�
	// �⺻ ������
	public Book() {
		
	}
	// �Ű����� 3���� �޴� ������
	public Book(String title, String publisher, String author) {
		this.title = title;
		this.publisher = publisher;
		this.author = author;
	}
	// �Ű����� 5���� �޴� ������
	public Book(String title, String publisher, String author, int price, double discountRate) {
//		this.title = title;
//		this.publisher = publisher;
//		this.author = author;
		// this([�Ű�����]) : Ŭ���� ���� �����ڸ� ȣ�� , �ٸ� �޼ҵ忡���� ����� �� ���� ������ �ȿ����� ��� ����!
		this(title, publisher, author); // this()�� �޼ҵ� ���� ��ܿ� �ۼ�! 
		
		this.price = price;
		this.discountRate = discountRate;
	}
	// �޼ҵ�� (1)
	public void inform() {
		System.out.printf("%s, %s, %s, %d, %.2f" , title, publisher, author, price, discountRate);
	}
}
