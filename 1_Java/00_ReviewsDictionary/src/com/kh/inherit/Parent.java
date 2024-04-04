package com.kh.inherit;


// Parent : �θ� ���� Ŭ����
public class Parent {
	// �ʵ��(����/�ʵ�/��� ����)
	private int x;			// ���� ������ private���� �����ϴ� ����? Ŭ���� �ܺο��� ���� ������ ���� ����
	private int y;			// 								  �߿��� ������ ����� �ٲ��� ���ϱ� ����
	
	// �����ں�
	public Parent() {}		// �⺻ ������ : �Ű������� ����, �ʱ�ȭ�ϴ� �۾��� ����.
							// 			  �������� ���� ��� ��ü�� �޸𸮿� �Ҵ�� �� �ڵ����� ������.
	public Parent(int x, int y) {
		this.x = x;			// this�� ����Ͽ� �ش� �ʵ忡 �Ű������� ���� ���� �ʱ�ȭ(����)
		this.y = y;
	}
	// �޼ҵ��
	// -private ��� ������ ��� getter/setter �޼ҵ�� ĸ��ȭ �۾��� �������.
	//	* getter �޼ҵ�: �ش� ��� ������ ��ȸ�� �� ����ϴ� �޼ҵ�
	//				  ��ȯŸ���� ����. (��� ������ �ڷ���)
	//				  �Ű������� ����.
	//	* setter �޼ҵ�: �ش� ��� ������ ���� ������ �� ����ϴ� �޼ҵ�
	//				   ��ȯŸ���� ����.
	//				   �Ű������� ����.	(��� ������ �ڷ����� ���������� �����ϰ� ����)
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	// �޽����� ����ϴ� �޼ҵ�
	public void printMsg() {
		System.out.println("�ȳ� ���� �θ�Ŭ������.");
	}
	
}
