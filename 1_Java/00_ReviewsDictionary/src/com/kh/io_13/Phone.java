package com.kh.io_13;

import java.io.Serializable;
// ����� �� ����� ��ü => "����ȭ" ���� �ʿ�.
//	* ����ȭ : Serializable �������̽��� ����
public class Phone implements Serializable{
	String kind;
	int price;
	
	public Phone(String kind, int price) {
		this.kind = kind;
		this.price = price;
	}
}
