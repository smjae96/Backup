package com.kh.exception_12;

class A {}

class B extends A{
	
}
class C extends A {
	
}
public class ExceptionPractice {
	public static void main(String[] args) {
		/*
		 * - 예외란	? 예측 가능한 오류. 수정 가능한 오류.
		 * - 예외 처리 ? 오류를 방지하기 위한 작업.
		 * 				프로그램이 "비정상 종료" 되지 않고, "정상적으로 동작"되도록 하는 작업
		 * 
		 * - 반드시 예외처리를 해야하는 예외 : Checked Exception
		 * 	 : Exception, IOExcepion, FileNotFoundException
		 * 
		 * - 필수는 아니나 예외가 발생할 가능성이 있을 때 예외처리가 필요한 예외 : UncheckedException
		 * 	 : RuntimeException, ArithmeticException, ArrayIndexOutofBounds
		 * 		NullPointerException (객체 생성 전에 접근할 때 발생)
		 * 		ClassCastException (클래스 형변환(다운캐스팅) 시 생성된 인스턴스가 아닌 클래스 타입으로 형변환)
		 * 				* 클래스 형변환(다운캐스팅) : 상속된 자손 클래스로 형변환이 가능. 해당 자손 클래스로 인스턴스 생성되어야 함.
		 * 
		 * - 예외 처리 방법
		 * 	[1] 직접 처리 : try - catch	| try ~ with ~ resource
		 * 		[작성법]
		 * 
		 * 				try {
		 * 						// 예외가 발생할 가능성이 있는 코드
		 * 				}
		 * 				catch (예외 처리 클래스명A 변수명) {
		 * 						// 해당 예외가 발생했을 때 처리할 코드.
		 * 				} catch (예외 처리 클래스명B 변수명) {
		 * 						// 해당 예외가 발생했을 때 처리할 코드.
		 * 				} finally {
		 * 						// 예외 발생 여부 상관없이 처리할 코드.
		 * 				}
		 * 
		 * 				* "예외_처리_클래스명A" 와 "예외_처리_클래스명B" 작성 시 고려 사항
		 * 					- 상속된 예외클래스 간에 예외_처리_클래스A가 예외_처리_클래스B의 자손 클래스여야 함.
		 * 
		 * 				// 예외_클래스를 하나의 catch문으로 처리하고자 할 때 사용
		 * 				try {
		 * 				} catch (예외_처리_클래스A | 예외_처리_클래스B e) {
		 * 					// "예외_처리_클래스A" 또는 "예외_처리_클래스B" 가 발생하면 처리할 코드
		 * 				}	//	* 두 클래스는 상속관계가 아니어야 함! 	
		 * 
		 * 				// try ~ with ~ resource
		 * 				try ( 사용할 자원(스트림) 객체 생성 ) {	// 여러 개의 자원 사용 시 세미콜론(;)으로 구분한다.
		 * 					// 예외가 발생할 가능성이 있는 코드	...
		 * 					// 자원을 사용... 입출력 관련 코드	...
		 * 					// 자원을 반납하지 않아도 자동으로 반납을 해줌.
		 * 				} catch (예외_처리_클래스 변수명) {
		 * 					// 해당 예외 발생 시 처리할 코드
		 * 				}
		 * 
		 * [2] 위임(떠넘기기) : throws
		 * 		- 메소드를 호출한 위치로 발생한 예외를 넘김.
		 * 		- 호출한 위치에서 예외처리가 필요함.
		 * 		[작성법]
		 * 			
		 * 				[접근제한자] [예약어] 반환타입 메소드명([매개변수]) throws 예외클래스명 {
		 * 				}
		 * 
		 * 				* 오버라이딩 시 위임하는 예외클래스의 범위가 같거나 좁은 범위(해당 예외클래스의 자손 클래스)만 사용.
		 * 
		 * [3] 조건문(if)을 사용
		 * 
		 * 			* 산술 연산 관련 : 나누기 연산 시 값의 범위를 조건문으로 제어
		 * 			* 배열 인덱스 관련 : 인덱스로 사용할 값의 범위를 조건문으로 제어
		 * 		
		 */
		A a = new B();
		System.out.println(((C)a).toString());	//=> ClassCastException 발생.
	}
}
