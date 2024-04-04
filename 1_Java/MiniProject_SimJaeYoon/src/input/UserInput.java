package input;

import java.util.Scanner;

public class UserInput {

	private static Scanner sc = new Scanner(System.in);
	
	public static String getUserName() {
		System.out.print("이름을 입력하세요: ");
		return sc.nextLine();
	}
	
	public static char getGender() {
		while(true) {
			System.out.print("성별을 입력하세요(M/F): ");
			char gender = sc.nextLine().charAt(0);
			if(Character.toUpperCase(gender) == 'M' || Character.toUpperCase(gender) == 'F') {
				return Character.toUpperCase(gender);
			} else {
				System.out.println("성별을 잘못입력하셨습니다. 다시 입력하세요.");
			}
		}	
	}
}
