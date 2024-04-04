package com.kh.inherit;

// �ڽ� Ŭ����
//	: Parent Ŭ�����κ��� ���
//	* "���"	: Parent Ŭ������ ���(����, �޼ҵ�)�� Child1 Ŭ�������� ���� ���� ���� ���� ��ó�� ����� ����.
public class Child1 extends Parent{			// extends Parent: Parent Ŭ�����κ��� ����� �޴´�.
	// �ʵ��(����/�ʵ�/�������)
	private int n1;
	
	// �����ں�
	public Child1() {
		
	}
	public Child1(int x, int y, int n1) {	// x,y ������ �θ�Ŭ����(Parent)�� �ִ� ��� ����
											// n1�� �ڽ�Ŭ����(Child1)�� ���ǵ� ��� ����
		super(x, y);			// �θ�Ŭ����(Parent)�� �����ڸ� ȣ��
		this.n1 = n1;			// ���� Ŭ����(Child1)�� n1 ��������� �Ű�����(n1)�� ����(�ʱ�ȭ)
	}
	
	// �޼ҵ��
	public int getN1() {
		return n1;
	}
	public void setN1(int n1) {
		this.n1 = n1;
	}
	
	// �������̵� : �θ�Ŭ������ �޼ҵ��� ������ �ڽ�Ŭ�������� ����
	//			 - ���� ���� : �޼ҵ��, ��ȯŸ��, �Ű�����(����/����/����)	
	// �޽����� ����ϴ� �޼ҵ�
	@Override				// @xxx : ������̼�
	public void printMsg() {
		System.out.println("�ȳ� ���� �ڽ�Ŭ������.");
	}
	
	public void printChild1() {
		System.out.println("���� �ڽ�1�Դϴ�.");
	}
}
