package com.kh.practice.chap02_abstractNInterface.controller;

import com.kh.practice.chap02_abstractNInterface.model.vo.GalaxyNote9;
import com.kh.practice.chap02_abstractNInterface.model.vo.Phone;
import com.kh.practice.chap02_abstractNInterface.model.vo.V40;

public class PhoneController {
	private String[] result = new String[2];
//	Phone gn9 = new GalaxyNote9();
//	Phone v40 = new V40();

	public String[] method() {
		Phone[] p = new Phone[2];
		
		// 다형성: 부모 클래스 타입의 참조변수에
		//		상속받은 자식 클래스로 인스턴스 생성하여 주소 값 저장 가능
		p[0] = new GalaxyNote9();	// 배열의 첫번째 위치에
									// GalaxyNote9 클래스로 객체 생성
		p[1] = new V40();			// 배열의 두번째 위치에
									// v40 클래스로 객체 생성
		int rIndex = 0;
		for(int i=0; i<p.length; i++) {
			// instanceof : i번째 위치에 있는 참조변수가
			//					어떤 객체를 참조하고 있는지 확인
			if(p[i] instanceof GalaxyNote9) {
				// i번째 위치의 참조변수가 GalaxyNote9 클래스 객체를 참조하고 있을 때
				result[rIndex] = ((GalaxyNote9)p[i]).printInformation();
				// (GalaxyNote9)p[i] : Phone 타입의 p[i] 참조변수를 GalaxyNote9 클래스 타입으로 형 변환(다운캐스팅)
			}
			else if(p[i] instanceof V40) {
				// i번째 위치의 참조변수(p[i])가 V40 클ㄹ래스 객체를 참조하고 있을 때
				result[rIndex] = ((V40)p[i]).printInformation();
			}
			rIndex++;
//			if(i==0) {
//				str[i] = ((GalaxyNote9)p[i]).printInformation();
//			}
//			else if(i==1) {
//				str[i] = ((V40)p[i]).printInformation();
//			}
		}
		return result;
	}
	
//	public String[] method() {
//		Phone[] p = {gn9, v40};
//		String[] str =  new String[2];
//		
//		for(int i=0; i<p.length; i++) {
//			if(i==0) {
//				str[i] = (GalaxyNote9)gn9.printInformation();
//			}
//			else if(i==1) {
//				str[i] = (V40)v40.printInformation();
//			}
//		}
//		return str;
//	}
	
	
}
