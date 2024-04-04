package com.kh.practice.chap02_abstractNInterface.model.vo;

public class GalaxyNote9 extends SmartPhone implements NotePen{

	// �ʵ�� : ����
	// - ������� Phone �������̽��� NUMBERPAD ���
	// 		 	NotePen �������̽��� PEN_BUTTON ���
	//			SmartPhone Ŭ������ maker ������ ���(����)
	
	// �����ں�
	public GalaxyNote9() {
		// �θ𿡰� ��ӹ��� maker �ʵ带 "�Ｚ"���� �ʱ�ȭ
		setMaker("�Ｚ");
		// this.setMaker("�Ｚ");
		// super.setMaker("�Ｚ");
	}
	
	@Override
	public String makeCall() {
		return "��ȣ�� ������ ��ȭ��ư�� ����";
	}
	
	@Override
	public String takeCall() {
		return "��ȭ�ޱ� ��ư�� ����";
	}
	
	@Override
	public String picture() {
		return "1200�� ��� ī�޶�";
	}

	@Override
	public String charge() {
		return "�������, ��� ���� ����";
	}

	@Override
	public String touch() {
		return "������, ������ ����";
	}

	@Override
	public boolean bluetoothPen() {
		return this.PEN_BUTTON;	// NotePen �������̽��� ���ǵ� ���(�ʱⰪ: true)
	}

	@Override
	public String printInformation() {
		return String.format("������ ��Ʈ9�� " +getMaker()+"���� ��������� ������ ������ ����. \n" 
				+ makeCall() + "\n" + takeCall() + "\n" + picture() + "\n" +
				charge() + "\n" + touch() + "\n" + "������� �� ž�� ���� : " +bluetoothPen());
		
		// this.�� Ư�� ��Ȳ���� ��Ȯ�� ������ �ʿ��ϴٰ� �ǴܵǴ� ��쿡 �ٿ��ִ� ���� ����. 
		// �Ϲ����� ��Ȳ������ this. ���� �޼ҵ� ȣ��.
	}


}
