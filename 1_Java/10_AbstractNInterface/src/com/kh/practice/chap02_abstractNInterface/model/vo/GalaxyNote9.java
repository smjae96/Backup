package com.kh.practice.chap02_abstractNInterface.model.vo;

public class GalaxyNote9 extends SmartPhone implements NotePen{

	// 필드부 : 없음
	// - 상속으로 Phone 인터페이스의 NUMBERPAD 상수
	// 		 	NotePen 인터페이스의 PEN_BUTTON 상수
	//			SmartPhone 클래스의 maker 변수는 사용(접근)
	
	// 생성자부
	public GalaxyNote9() {
		// 부모에게 상속받은 maker 필드를 "삼성"으로 초기화
		setMaker("삼성");
		// this.setMaker("삼성");
		// super.setMaker("삼성");
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
		return "1200만 듀얼 카메라";
	}

	@Override
	public String charge() {
		return "고속충전, 고속 무선 충전";
	}

	@Override
	public String touch() {
		return "정전식, 와콤펜 지원";
	}

	@Override
	public boolean bluetoothPen() {
		return this.PEN_BUTTON;	// NotePen 인터페이스에 정의된 상수(초기값: true)
	}

	@Override
	public String printInformation() {
		return String.format("갤럭시 노트9은 " +getMaker()+"에서 만들어졌고 제원은 다음과 같다. \n" 
				+ makeCall() + "\n" + takeCall() + "\n" + picture() + "\n" +
				charge() + "\n" + touch() + "\n" + "블루투스 펜 탑재 여부 : " +bluetoothPen());
		
		// this.은 특정 상황에서 명확한 구분이 필요하다고 판단되는 경우에 붙여주는 것이 좋다. 
		// 일반적인 상황에서는 this. 없이 메소드 호출.
	}


}
