package wrongpractice;

import java.util.Scanner;

public class VaribalePractice1 {

	// �̸�, ����, ����, Ű�� ����ڿ��� �Է� �޾� ������ ���� ������ ��� ����ϼ���.
	//ex. �̸��� �Է��ϼ���: �ƹ���
	//	  ������ �Է��ϼ���(��/��): ��
	// 	  ���̸� �Է��ϼ���: 20
	// 	  Ű�� �Է��ϼ���(cm): 180.5
	
	public void example1() {
		Scanner sc = new Scanner(System.in);
		System.out.print("�̸��� �Է��ϼ���: " );
		String name = sc.nextLine();
		System.out.print("������ �Է��ϼ���(��/��): " );
		char gender = sc.nextLine().charAt(0);
		// String str = sc.nextLine();
		// char gender = str.charAt(0);
		System.out.print("���̸� �Է��ϼ���: ");
		String str2 = sc.nextLine();
		int age = Integer.parseInt(str2);
		System.out.print("Ű�� �Է��ϼ���(cm): ");
		String str3 = sc.nextLine();
		double height = Double.parseDouble(str3);
		System.out.println("�̸��� " + name + "�̰�, ������ " +gender+ "���̸�, ���̴� " + age + "���̰�, Ű�� " + height + "cm�̴�." );
	}
}
