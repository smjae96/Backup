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
		
		// ������: �θ� Ŭ���� Ÿ���� ����������
		//		��ӹ��� �ڽ� Ŭ������ �ν��Ͻ� �����Ͽ� �ּ� �� ���� ����
		p[0] = new GalaxyNote9();	// �迭�� ù��° ��ġ��
									// GalaxyNote9 Ŭ������ ��ü ����
		p[1] = new V40();			// �迭�� �ι�° ��ġ��
									// v40 Ŭ������ ��ü ����
		int rIndex = 0;
		for(int i=0; i<p.length; i++) {
			// instanceof : i��° ��ġ�� �ִ� ����������
			//					� ��ü�� �����ϰ� �ִ��� Ȯ��
			if(p[i] instanceof GalaxyNote9) {
				// i��° ��ġ�� ���������� GalaxyNote9 Ŭ���� ��ü�� �����ϰ� ���� ��
				result[rIndex] = ((GalaxyNote9)p[i]).printInformation();
				// (GalaxyNote9)p[i] : Phone Ÿ���� p[i] ���������� GalaxyNote9 Ŭ���� Ÿ������ �� ��ȯ(�ٿ�ĳ����)
			}
			else if(p[i] instanceof V40) {
				// i��° ��ġ�� ��������(p[i])�� V40 Ŭ������ ��ü�� �����ϰ� ���� ��
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
