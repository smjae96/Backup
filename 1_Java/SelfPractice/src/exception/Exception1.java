package exception;

import java.util.Scanner;

public class Exception1 {
	private static Scanner sc = new Scanner(System.in);


	
	public static void main(String[] args)  {
		// 		arrayTest();
	
		try {
			arrayTest();	// 예외 발생 위치!
		} catch(ArrayIndexOutOfBoundsException e) {	//인덱스 범위 예외를 감지하겠다.
			System.out.println("잘못 입력했습니다. 인덱스 범위오류");
		} catch(NegativeArraySizeException e) {
			System.out.println("음수값 입력되어 예외 발생!");
		}
		catch(Exception e) {	// 인덱스 예외 외의 다른 예외 발생시 여기서 감지.
			System.out.println("잘못 입력했습니다.");
			System.out.println(e);
		} finally {
			System.out.println("프로그램 종료");
		}
	
	}
	
	public static void arrayTest() throws Exception{
		arrayTest2();
	}
	public static void arrayTest2() throws Exception{	// throws 키워드 사용하여 예외를 전달 (직접 처리x)
		System.out.print("값을 입력하세요: ");
		int length = sc.nextInt();
		// 사용자에게 입력받은 크기만큼 정수형 배열 생성
		// 반복문으로 인덱스 값을 대입
		// try ~catch문 사용
		// ArrayIndexOutOfBoundsException 발생 시
		//				"잘못 입력했습니다." 출력
		// Exception 발생 시 " 잘못 입력했습니다" 출력
		// 정상적인 값 입력 시 배열 생성
		
//		try {
		int[] arr = new int[length]; // 사용자에게 입력받은 크기(length)만큼 정수형 배열 생성
		for(int i=0; i<=arr.length; i++) {
			arr[i] = i;	// 반복문을 돌며 인덱스 값을 배열에 대입
			System.out.println(arr[i] + " ");
		}
		
			// catch문에 작성하는 예외는 위쪽이 더 좁은 범위, 아래쪽이 더 넓은 범위의 예외가 되도록 작성.	
//		} catch(ArrayIndexOutOfBoundsException e) {	//인덱스 범위 예외를 감지하겠다.
//			System.out.println("잘못 입력했습니다. 인덱스 범위오류");
//		} catch(NegativeArraySizeException e) {
//			System.out.println("음수값 입력되어 예외 발생!");
//		}
//		catch(Exception e) {	// 인덱스 예외 외의 다른 예외 발생시 여기서 감ㅅ지.
//			System.out.println("잘못 입력했습니다.");
//			System.out.println(e);
//		}
//		finally {}
	}

	
}
