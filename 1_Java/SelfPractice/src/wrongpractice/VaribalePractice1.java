package wrongpractice;

import java.util.Scanner;

public class VaribalePractice1 {

	// 이름, 성별, 나이, 키를 사용자에게 입력 받아 각각의 값을 변수에 담고 출력하세요.
	//ex. 이름을 입력하세요: 아무개
	//	  성별을 입력하세요(남/여): 남
	// 	  나이를 입력하세요: 20
	// 	  키를 입력하세요(cm): 180.5
	
	public void example1() {
		Scanner sc = new Scanner(System.in);
		System.out.print("이름을 입력하세요: " );
		String name = sc.nextLine();
		System.out.print("성별을 입력하세요(남/여): " );
		char gender = sc.nextLine().charAt(0);
		// String str = sc.nextLine();
		// char gender = str.charAt(0);
		System.out.print("나이를 입력하세요: ");
		String str2 = sc.nextLine();
		int age = Integer.parseInt(str2);
		System.out.print("키를 입력하세요(cm): ");
		String str3 = sc.nextLine();
		double height = Double.parseDouble(str3);
		System.out.println("이름은 " + name + "이고, 성별은 " +gender+ "자이며, 나이는 " + age + "살이고, 키는 " + height + "cm이다." );
	}
}
