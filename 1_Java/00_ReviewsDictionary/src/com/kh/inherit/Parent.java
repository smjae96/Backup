package com.kh.inherit;


// Parent : 부모 역할 클래스
public class Parent {
	// 필드부(변수/필드/멤버 변수)
	private int x;			// 접근 제한을 private으로 정의하는 이유? 클래스 외부에서 직접 접근을 막기 위해
	private int y;			// 								  중요한 정보를 맘대로 바꾸지 못하기 위해
	
	// 생성자부
	public Parent() {}		// 기본 생성자 : 매개변수가 없고, 초기화하는 작업도 없다.
							// 			  정의하지 않을 경우 객체가 메모리에 할당될 때 자동으로 생성됨.
	public Parent(int x, int y) {
		this.x = x;			// this를 사용하여 해당 필드에 매개변수로 받은 값을 초기화(대입)
		this.y = y;
	}
	// 메소드부
	// -private 멤버 변수의 경우 getter/setter 메소드로 캡슐화 작업을 해줘야함.
	//	* getter 메소드: 해당 멤버 변수를 조회할 때 사용하는 메소드
	//				  반환타입이 있음. (멤버 변수의 자료형)
	//				  매개변수는 없음.
	//	* setter 메소드: 해당 멤버 변수에 값을 대입할 때 사용하는 메소드
	//				   반환타입이 없음.
	//				   매개변수는 있음.	(멤버 변수의 자료형과 변수명으로 동일하게 정의)
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
	// 메시지를 출력하는 메소드
	public void printMsg() {
		System.out.println("안녕 나는 부모클래스야.");
	}
	
}
