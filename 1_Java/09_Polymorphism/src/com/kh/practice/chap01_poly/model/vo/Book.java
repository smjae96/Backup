package com.kh.practice.chap01_poly.model.vo;

//�θ� Ŭ����
//å
public class Book {
	// �ʵ�� (3)
	private String title;		// ������
	private String author;		// ���ڸ�
	private String publisher;	// ���ǻ�
	
	// ������ (2) : �⺻������, �Ű����� 3���� �޴� ������(title, author, publisher)
	public Book() {
		
	}

	public Book(String title, String author, String publisher) {
		this.title = title;
		this.author = author;
		this.publisher = publisher;
	}
	
	
	// �޼ҵ� (1) : Ŭ���� �� �ʵ� ������ ���ڿ��� ��ȯ (toString())
	@Override
	public String toString() {
		return String.format("[Book [title=%s , author=%s, publisher=%s]",title, author, publisher);
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	
}
