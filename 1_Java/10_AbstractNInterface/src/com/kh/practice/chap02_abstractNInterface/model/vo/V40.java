package com.kh.practice.chap02_abstractNInterface.model.vo;

public class V40 extends SmartPhone implements NotePen{

	public V40() {
		super.setMaker("LG");
		//this.setMaker("LG"); // �θ𿡰� ��ӹ��� maker �ʵ带 "LG"�� �ʱ�ȭ
		
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
		return "1200, 1600�� ȭ�� Ʈ���� ī�޶�";
	}

	@Override
	public String charge() {
		return "�������, ��� ���� ����";
	}

	@Override
	public String touch() {
		return "������";
	}

	@Override
	public boolean bluetoothPen() {
		return !this.PEN_BUTTON;	// ���� false �Է��ϴ� ��� 
									//��� PEN_BUTTON�� �ʱ�ȭ�� �� true�� �����Ͽ� false �������� ��.
	}

	@Override
	public String printInformation() {
		return String.format("V40�� "  +getMaker()+ "���� ��������� ������ ������ ����. \n" 
				+ this.makeCall() + "\n" + this.takeCall() + "\n" + this.picture() + "\n" +
				this.charge() + "\n" + this.touch() + "\n" + "������� �� ž�� ���� : " +this.bluetoothPen());
	
		// this.�� Ư�� ��Ȳ���� ��ð� �ʿ��ϴٰ� �ǴܵǴ� ��쿡 �ٿ��ִ� ���� ����. 
		// �Ϲ����� ��Ȳ������ this.���� �޼ҵ� ȣ��.
		
		// ���ڿ� Ÿ�� ���� info�� ������ �� �� �ȿ� ���� �Է��ϰ� ���� ������ �ְ�, return���� info�� ��ȯ�ϵ��� �ص� ��.
		/* String info = "V40�� "  +getMaker()+ "���� ��������� ������ ������ ����. \n" 
		+ this.makeCall() + "\n" + this.takeCall() + "\n" + this.picture() + "\n" +
		this.charge() + "\n" + this.touch() + "\n" + "������� �� ž�� ���� : " +this.bluetoothPen()*/
		
		// return info;
	}
}
