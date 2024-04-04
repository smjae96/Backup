package com.kh.practice;

public class StringTest {

	public static void main(String[] args) {
		
		
		// 문자열(String) 관련 메소드
		// - String.format("문자열 형식, 지시어(%)", 변수1, 변수2, ...); // 포맷에 맞게 문자열 반환
		// - 문자열.charAt(index)			// 문자열에서 index 위치의 문자 반환
		// - 문자열.length()				// 문자열 길이..
		// - 문자열.equals(문자열A)			// 문자열과 문자열A가 같은지 비교
		
		String str = "Hello";
		
		System.out.println(str.charAt(0));
		System.out.println(str.indexOf("e")); // indexOf()메소드의 매개변수 자리에 오는 문자 or 문자열이 몇번 째 위치에서 처음 나오는지 확인
		System.out.println(str.contains("He"));	// contains()메소드의 매개변수 자리에 오는 문자열이 들어있는지 없는지 true/false
		System.out.println(str.substring(0, 3)); // 해당 문자열의 0번째 문자부터 (3-1)번째 문자까지 출력
		System.out.println(str.replace("l", "p")); // 해당 문자열에 들어 있는 문자열을 임의로 선택해서, 다른 문자열로 변경.
		String[] strArr = str.split("l",2);
		System.out.println(strArr[0]);	// regex : 기준(l) l을 기준으로 나눠서 길이 2짜리 문자열 배열로.
		System.out.println(str.trim()); 	// trim() : 공백 제거
	}
	
	
	
	public void test2() {
		// String 클래스 : 문자열 값이 변하지 않는다. ( => 값이 변경되면 메모리에 새로운 공간 할당)
		
		
		String str1 = "apple";
		String str2 = "apple";
		
		// str1 == str2 : 문자열 값을 비교하는 게 아니라, str1과 str2가 저장한 주소값을 비교
		System.out.println(str1 == str2); 		// 결과? true
												// 문자열 값 자체를 대입하면 상수풀이라는 공간에 값이 저장되어
												// 같은 곳을 가리키게 됨(주소값이 동일)
		
		System.out.println(str1 == "apple");	// 결과? true
												// str1이 가리키는 주소와 "apple" 값 자체가 저장된 주소를 비교
												// str1, "apple" 모두 상수풀의 같은 곳에 저장되어 있어 true (주소값이 동일)		
		
		String str3 = new String("apple");
		String str4 = new String("apple");
		System.out.println(str3 == str4); 		// 결과? false
												// 문자열 객체를 생성해서 값을 대입하면 메모리에 새로운 영역을 할당하므로
												// 각각 할당된 영역을 가리키게됨 (주소값이 다름)
		
		System.out.println(str3 == "apple");	// 결과? false	
												// str3가 가리키는 주소와 "apple" 값 자체가 저장된 주소를 비교
												// str3는 새로운 메모리 공간 할당 후 "apple" 값을 저장
												// "apple" 값 자체는 상수풀에 저장이 되어 서로 다른 곳을 가리킴(주소값이 다름)
		
		// (문자열 변수나 값).equals(문자열 변수나 값) => true/false : true(동일), false(다름)
		System.out.println(str3.equals("apple"));	// 결과? true
													// .equals() 메소드를 사용하여 값 자체를 비교
		
		System.out.println("======================================");
		
		String str5 = "Hello";
		String str6 = "World";
		System.out.println(str5);			// 문자열 변수 출력: Hello
											// 출력함수에 객체타입의 변수 입력 시 => 변수.toString()
		System.out.println(str5.toString());		// String 클래스에서 toString 메소드가 오버라이딩됨.
		
		// System.idntityHashCode: System 클래스 내 해쉬값(주소값)을 확인하는 메소드
		int hash = System.identityHashCode(str5);	// str5 변수의 해쉬값(주소값)
		System.out.println("변경 전 str5 : " + hash);
		
		// 앞부분에 위치할 문자열.concat(뒤에 붙일 문자열) : String 클래스 내 문자열을 합해주는(더해주는) 메소드
		//											결과 값으로 문자열들을 합쳐서 반환
		str5 = str5.concat(str6);			// "HelloWorld"
		
		System.out.println(str5);
		int hash2 = System.identityHashCode(str5);
		System.out.println(str5.hashCode());
		System.out.println("변경 후 str5 : " + hash2);	
	}

	

}
