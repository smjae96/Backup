package wrongpractice;

import java.util.Scanner;

public class VariablePractice0 {

	public void example06() {
		// Scanner 생성
		Scanner sc = new Scanner(System.in);
		
		//키 설정
		System.out.print("원하는 키를 입력하십시오: ");
		//사용자로부터 입력받은 값을 height 변수에 대입
		double height = sc.nextDouble();
		//몸무게 설정
		System.out.print("원하는 몸무게를 입력하십시오: ");
		//사용자로부터 입력받은 값을 weight 변수에 대입
		int weight = sc.nextInt();
		//출력 예시) 내가 원하는 키는 168.8cm이고, 원하는 몸무게는 60kg입니다.
		System.out.println("내가 원하는 키는 " +height+ "이고, 원하는 몸무게는 " +weight+ "kg입니다." );
		
		
	}
}
