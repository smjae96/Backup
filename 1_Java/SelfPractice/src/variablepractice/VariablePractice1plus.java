package variablepractice;

import java.util.Scanner;

public class VariablePractice1plus {

	public void example1() { 
		Scanner sc = new Scanner(System.in);
		System.out.print("�̸��� �Է��ϼ���: ");
		String name = sc.nextLine(); // nextLine : ���ڿ��� �Է¹޴� �޼ҵ�
		System.out.print("������ �Է��ϼ���(��/��): ");
		// '��' , '��'
		// "����" -> '��' , '��'
		// "��", "��" -> '��', '��'
		String strGender = sc.nextLine(); // next : ���ڿ��� �Է¹޴� �޼ҵ�, ���� ������
		char gender = strGender.charAt(0); // charAt(index) : ���ڿ����� index ��ġ�� ���� ���������� ������ ���� �޼ҵ�
		//sc.next().charAt(0); ���� �ᵵ �ȴ�.
		System.out.print("���̸� �Է��ϼ���: ");
		String str = sc.nextLine();
		int age = Integer.parseInt(str); 
		
		System.out.print("Ű�� �Է��ϼ���(cm): ");
		String str2 = sc.nextLine();
		double height = Double.parseDouble(str2);
		System.out.println("Ű " + height + "cm�� " + age + "�� " + gender + "�� " + name + "�� �ݰ����ϴ�^^");
	}
}
