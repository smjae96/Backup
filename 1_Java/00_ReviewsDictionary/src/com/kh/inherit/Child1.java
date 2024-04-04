package com.kh.inherit;

// 자식 클래스
//	: Parent 클래스로부터 상속
//	* "상속"	: Parent 클래스의 멤버(변수, 메소드)를 Child1 클래스에서 새로 정의 없이 본인 것처럼 사용이 가능.
public class Child1 extends Parent{			// extends Parent: Parent 클래스로부터 상속을 받는다.
	// 필드부(변수/필드/멤버변수)
	private int n1;
	
	// 생성자부
	public Child1() {
		
	}
	public Child1(int x, int y, int n1) {	// x,y 변수는 부모클래스(Parent)에 있는 멤버 변수
											// n1은 자식클래스(Child1)에 정의된 멤버 변수
		super(x, y);			// 부모클래스(Parent)의 생성자를 호출
		this.n1 = n1;			// 현재 클래스(Child1)의 n1 멤버변수에 매개변수(n1)를 대입(초기화)
	}
	
	// 메소드부
	public int getN1() {
		return n1;
	}
	public void setN1(int n1) {
		this.n1 = n1;
	}
	
	// 오버라이딩 : 부모클래스의 메소드의 내용을 자식클래스에서 변경
	//			 - 동일 조건 : 메소드명, 반환타입, 매개변수(종류/개수/순서)	
	// 메시지를 출력하는 메소드
	@Override				// @xxx : 어노테이션
	public void printMsg() {
		System.out.println("안녕 나는 자식클래스야.");
	}
	
	public void printChild1() {
		System.out.println("나는 자식1입니다.");
	}
}
