package com.kh.practice.chap02_abstractNInterface.model.vo;

public class V40 extends SmartPhone implements NotePen{

	public V40() {
		super.setMaker("LG");
		//this.setMaker("LG"); // 부모에게 상속받은 maker 필드를 "LG"로 초기화
		
	}
	

	@Override
	public String makeCall() {
		return "번호를 누르고 통화버튼을 누름";
	}
	
	@Override
	public String takeCall() {
		return "전화받기 버튼을 누름";
	}
	
	@Override
	public String picture() {
		return "1200, 1600만 화소 트리플 카메라";
	}

	@Override
	public String charge() {
		return "고속충전, 고속 무선 충전";
	}

	@Override
	public String touch() {
		return "정전식";
	}

	@Override
	public boolean bluetoothPen() {
		return !this.PEN_BUTTON;	// 직접 false 입력하는 대신 
									//상수 PEN_BUTTON에 초기화된 값 true를 부정하여 false 나오도록 함.
	}

	@Override
	public String printInformation() {
		return String.format("V40은 "  +getMaker()+ "에서 만들어졌고 제원은 다음과 같다. \n" 
				+ this.makeCall() + "\n" + this.takeCall() + "\n" + this.picture() + "\n" +
				this.charge() + "\n" + this.touch() + "\n" + "블루투스 펜 탑재 여부 : " +this.bluetoothPen());
	
		// this.은 특정 상황에서 명시가 필요하다고 판단되는 경우에 붙여주는 것이 좋다. 
		// 일반적인 상황에서는 this.없이 메소드 호출.
		
		// 문자열 타입 변수 info를 선언한 뒤 그 안에 내가 입력하고 싶은 정보를 넣고, return으로 info를 반환하도록 해도 됨.
		/* String info = "V40은 "  +getMaker()+ "에서 만들어졌고 제원은 다음과 같다. \n" 
		+ this.makeCall() + "\n" + this.takeCall() + "\n" + this.picture() + "\n" +
		this.charge() + "\n" + this.touch() + "\n" + "블루투스 펜 탑재 여부 : " +this.bluetoothPen()*/
		
		// return info;
	}
}
