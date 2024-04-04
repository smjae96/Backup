package com.kh.generic.practice1;

public class PrintTest {

	public static void main(String[] args) {
		
		// ThreeDPrinter ��ü ����
		ThreeDPrinter tdp = new ThreeDPrinter();		// L) ThreeDPrinter Ÿ���� �������� ����
														// R) ThreeDPrinter �ν��Ͻ� ���� ( �޸𸮿� �Ҵ�)
		// Powder ��ü ����
		Powder pd1 = new Powder();		
		// ThreeDPrinter �� setMaterial �޼ҵ带 ����Ͽ� Powder ��ü�� ����
		tdp.setMaterial(pd1);			// ==> tdp.setMaterial(new Powder());
										// setMaterial �޼ҵ忡 ���ǵ� �Ű����� : Object
										// �޼ҵ� ȣ�� �� ������ ������ Ÿ�� : Powder
										// ==> ��ĳ���� (�θ�Ŭ���� Ÿ���� ���������� �ڽ�Ŭ���� �ν��Ͻ��� ����ų �� ����)
		
		// �Ǵٸ� Powder ��ü�� ThreeDPrinter �� ������ material �����͸� ������ ����.
		Powder pd2 = (Powder)tdp.getMaterial();		// getMaterial �޼ҵ� ��ȯŸ�� : Object
													// ����� �����ϴ� ���� Ÿ�� : Powder
													// ==> �ٿ�ĳ���� �θ�Ŭ���� Ÿ�Կ��� �ڽ�Ŭ���� Ÿ������ ����ȯ �ʿ�.
		
		
		// (+) ThreeDPrinter ���׸� ���� => ThreeDPrinterG Ŭ���� ����
		//		���� �����ϰ� Powder ��ü�� ������ �� �ٽ� ������ �ٸ� Powder ��ü ����.
		
		// ThreeDPrinterG<Powder> ��ü ����
		ThreeDPrinterG<Powder> tdpG = new ThreeDPrinterG<>();	// ���� Ÿ������ �ν��Ͻ� ���� �� ������ �κп� Ÿ���� ���� ����.
		
		Powder pd3 = new Powder();
		tdpG.setMaterial(pd3);
//		tdpG.setMaterial(new String("Powder"));	// �� ������ ����? ��ü ���� �� Ÿ�� �Ű������� Powder�� �����Ǿ��� ������
												//				�ٸ� Ÿ���� �ν��Ͻ��� ������ �� ����.
		
		Powder pd4 = tdpG.getMaterial();	// �� ����ȯ�� �ʿ� ������? ���� �����ϴ�. getMaterial() �޼ҵ��� ��ȯ Ÿ���� Powder�� ����Ǳ� ������.
	}

}
