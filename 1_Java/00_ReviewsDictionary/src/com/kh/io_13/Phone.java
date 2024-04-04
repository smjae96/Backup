package com.kh.io_13;

import java.io.Serializable;
// 입출력 시 사용할 객체 => "직렬화" 적용 필요.
//	* 직렬화 : Serializable 인터페이스를 구현
public class Phone implements Serializable{
	String kind;
	int price;
	
	public Phone(String kind, int price) {
		this.kind = kind;
		this.price = price;
	}
}
