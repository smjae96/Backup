package com.kh.generic.practice1;

// Material Ŭ���� ���
public class Powder extends Material{
	// �߻�޼ҵ� ���� �ʿ�..
	
	// Material �߻�Ŭ���� �� �߻�޼ҵ� �������̵�
	@Override
	public void doPrinting() {
		System.out.println("Powder ��� ���");
	}

	// Object Ŭ���� �� toString �޼ҵ� �������̵�
	@Override
	public String toString() {
		return "��� : powder";
	}
	

}
