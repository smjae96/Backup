package com.kh.generic.practice1;
// class 복사하는 법. 복사 할 클래스 선택한 뒤 ctrl+c, 복사 될 패키지 선택한 뒤 ctrl+v하면 클래스 이름 변경하면서 복사 가능.
// 제네릭 클래스
public class ThreeDPrinterG<T> {		// <T> : 타입매개변수
	// 필드
	// 어떤 클래스의 타입이든 인스턴스 생성
	private T material;		// T: 타입매개변수

	//getter/setter
	public T getMaterial() {
		return material;
	}

	public void setMaterial(T material) {
		this.material = material;
	}
	
}
