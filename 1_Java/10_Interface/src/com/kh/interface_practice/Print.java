package com.kh.interface_practice;

// �߻�Ŭ���� Print 
//	: �̿ϼ� Ŭ����(���赵) -> �߻� �޼ҵ带 �����ϰ� ����(�ƴ� ��쵵 ���� �� �ִ�. - abstract Ű���常 ���)
public abstract class Print implements Printable, TestIf1, TestIf2{

	// �޼ҵ�
	// 	colorPrint() �߻�޼ҵ�
	// 	* ǥ���� : [����������] abstract ��ȯŸ�� �޼ҵ��([�Ű�����]);
	//public abstract void colorPrint();
	
	protected abstract void printTest();
	
	abstract void printTest2();			// ���������ڸ� default�� ����
	
	// �Ϲ����� �޼ҵ嵵 ���� ����.
	public void printTest3() {
		
		System.out.println("����Ʈ �׽�Ʈ ��...");
		
	}
	
}
