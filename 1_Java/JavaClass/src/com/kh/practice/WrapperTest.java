package com.kh.practice;

public class WrapperTest {
	
	
	// Wrapper class : 기본자료형을 개체화한 클래스
	//	- 기본자료형 : byte, short, int, long, double, char, boolean
	//	- Wrapper C: Byte, Short, Integer, Long, Double, Character, Boolean
	
	// * 문자열을 각 자료형의 값으로 변환 ex) "10" -> 10
	// 	 - 정수형 자료형으로 변경 : Integer.parseInt("10"); // 10
	//	 - 실수형 자료형으로 변경 : Double.parseDouble("3.14"); // 3.14
	
	public static void main(String[] args) {
		
		// 기본자료형 값 => 문자열 값
		//	ex) 1000 값을 문자열로 변경 (wrapper class 사용)
		System.out.println(Integer.valueOf(1000).toString() + 10);
		
		// ex) float 타입의 0.59 값을 문자열로 변경
		String result;
		float a = 0.59f;
		System.out.println(Float.toString(a));
		result = Float.valueOf(0.59f).toString();
		System.out.println(result + 0.1);
		
		// ex) long 타입의 6789 값을 문자열로 변경 => 6789l로 입력하지 않아도 자동형변환 되어 컴파일 오류 안 남.
		System.out.println(Long.valueOf(6789l).toString() +100L);
		
	}
	
	public void parseTest() {
		String ten = "10";
		System.out.println("10" +1);			// 문자열 + 정수 => 문자열 "10" + 1 => "10" + "1" => "101"
		System.out.println(Integer.parseInt("10") +1);	// 문자열을 정수로 변환 + 정수 => 정수
		
		System.out.println(Double.parseDouble(ten));	// 10이라는 값이 실수형으로 자동형변환되어 10.0 이 출력됨.
		
//		System.out.println(Integer.parseInt("10.0"));	// 실수형 값을 정수형 값으로 변환하려 해서 오류가 발생
														// 정수형이 아닌 다른 자료형 값이 와도 마찬가지로 오류 발생
	
//		System.out.println(Integer.parseInt("a"));		// 문자하나만 입력해도 문자열이므로 정수형으로 변환되지 않음
		
		System.out.println(Boolean.parseBoolean("true") ? "참" : "거짓"); // 참
		// 문자열 (String) -> 문자형 (char) : .charAt(index)
		System.out.println("A".charAt(0));
	}
}
