package input;

import java.util.Scanner;

public class UserInput {

	private static Scanner sc = new Scanner(System.in);
	
	public static String getUserName() {
		System.out.print("�̸��� �Է��ϼ���: ");
		return sc.nextLine();
	}
	
	public static char getGender() {
		while(true) {
			System.out.print("������ �Է��ϼ���(M/F): ");
			char gender = sc.nextLine().charAt(0);
			if(Character.toUpperCase(gender) == 'M' || Character.toUpperCase(gender) == 'F') {
				return Character.toUpperCase(gender);
			} else {
				System.out.println("������ �߸��Է��ϼ̽��ϴ�. �ٽ� �Է��ϼ���.");
			}
		}	
	}
}
