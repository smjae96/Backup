package com.kh.practice.charCheck.controller;

import com.kh.practice.charCheck.exception.CharCheckException;

public class CharacterController {
	
	public CharacterController() {}
	
	public int countAlpha(String s) throws CharCheckException {
		int count = 0;
		for(int i=0; i<s.length(); i++) {
			if(s.charAt(i)>64 && s.charAt(i)<91) {
				//System.out.println(i);
				count++;
				
			}else if(s.charAt(i)>96 && s.charAt(i)<123) {
				count++;
			}
			else if(s.charAt(i) == ' ') {
				throw new CharCheckException("체크할 문자열 안에 공백이 포함되어 있습니다.");
			}
		}
		return count;
	}
}
