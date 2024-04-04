package com.kh.abstract_10;

abstract class Printer {
	// -ERROR:int = -999_999_999 (����)
	public static final int ERROR = -999_999_999;		// ����: static, �빮��: final(���)

//	// ERROR �ʵ��� getter/setter
//	public static int getError() {
//		return ERROR;
//	}
	
	// setter...? : ���޹��� ������ �ʵ��� ���� ����(����)
	// ERROR �ʵ�� ����� setter ��� �Ұ�!
	
	// +colorPrint(int rgb):void (�����)
	public abstract void colorPrint(int rgb);

	public static int getError() {
		return ERROR;
	}
}

// Printer Ŭ������ ����ϰ��� �Ѵٸ�? �߻�޼ҵ带 ������ Ŭ������ ���� (Printer Ŭ������ ���)

class LGPrinter extends Printer {	// �߻�޼ҵ� �������� ���� ��� ���� �߻�!

	@Override
	public void colorPrint(int rgb) {
		System.out.println(rgb+ "���� ����Ʈ �� ...");
	}
	
}

public class AbstractPractice {
	/*
	 * �߻� (abstract)	: �̿ϼ�, �������� ���� ����	
	 * 	- �߻� Ŭ����	=> �ν��Ͻ� ���� �� �� ����!
	 * 		[ǥ����]
	 * 				[����������] abstract class Ŭ������ { } 
	 * 	
	 * 	- �߻� �޼ҵ�
	 * 		[ǥ����]
	 * 				[����������] abstract ��ȯŸ�� �޼ҵ��([�Ű�����]);	// �߻� �޼ҵ��� ���� �����ݷ�(;)!
	 */
	
	public static void main(String[] args) {
	//	Printer printer = new Printer();	// �߻�Ŭ������ �ν��Ͻ� ���� �Ұ�!
		
		Printer printer2 = new LGPrinter();
		printer2.colorPrint(666);		// ���� �� ����� ? 666���� ����Ʈ �� ...
									// ���� ���ε� ( Dynamic Binding)
									// : �������� ����� ���������� ���� �޼ҵ� ���� �� �ڽ�Ŭ�������� �����ǵ� �޼ҵ尡 ����Ǵ� Ư¡
	}
}
