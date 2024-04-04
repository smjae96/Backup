package variablepractice;

import java.util.Scanner;

public class VariablePractice1plus {

	public void example1() { 
		Scanner sc = new Scanner(System.in);
		System.out.print("이름을 입력하세요: ");
		String name = sc.nextLine(); // nextLine : 문자열을 입력받는 메소드
		System.out.print("성별을 입력하세요(남/여): ");
		// '남' , '여'
		// "남자" -> '남' , '자'
		// "남", "여" -> '남', '여'
		String strGender = sc.nextLine(); // next : 문자열을 입력받는 메소드, 공백 전까지
		char gender = strGender.charAt(0); // charAt(index) : 문자열에서 index 위치의 값을 문자형으로 가지고 오는 메소드
		//sc.next().charAt(0); 으로 써도 된다.
		System.out.print("나이를 입력하세요: ");
		String str = sc.nextLine();
		int age = Integer.parseInt(str); 
		
		System.out.print("키를 입력하세요(cm): ");
		String str2 = sc.nextLine();
		double height = Double.parseDouble(str2);
		System.out.println("키 " + height + "cm인 " + age + "살 " + gender + "자 " + name + "님 반갑습니다^^");
	}
}
