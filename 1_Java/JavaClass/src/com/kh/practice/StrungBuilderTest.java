package com.kh.practice;

public class StrungBuilderTest {

	public static void main(String[] args) {
		// StringBuilder : 문자열 값을 변경할 수 있음 (같은 메모리 공간에서 값을 변경)
		// 					스레드 safe 보장 안됨. (단일 스레드에서만 사용)
		
		String str = "map";
		
		// StringBuilder 객체 생성 시 String 타입의 변수가 필요
		StringBuilder builder = new StringBuilder(str);
		int hash = System.identityHashCode(builder);
		System.out.println(builder.toString());
		System.out.println("변경 전 builder : " +hash);
		
		//	변수명.append(값) : StringBuilder 타입의 변수에 값을 변경
		builder.append(" point");
		builder.append(" tomato");
		builder.append(" orange");
		
		System.out.println(builder.toString());
		System.out.println("변경 후 builder : " +
							System.identityHashCode(builder));
		System.out.println(builder.hashCode());
	}

}
