package wrongpractice;

import java.util.Scanner;

public class VariablePractice0 {

	public void example06() {
		// Scanner ����
		Scanner sc = new Scanner(System.in);
		
		//Ű ����
		System.out.print("���ϴ� Ű�� �Է��Ͻʽÿ�: ");
		//����ڷκ��� �Է¹��� ���� height ������ ����
		double height = sc.nextDouble();
		//������ ����
		System.out.print("���ϴ� �����Ը� �Է��Ͻʽÿ�: ");
		//����ڷκ��� �Է¹��� ���� weight ������ ����
		int weight = sc.nextInt();
		//��� ����) ���� ���ϴ� Ű�� 168.8cm�̰�, ���ϴ� �����Դ� 60kg�Դϴ�.
		System.out.println("���� ���ϴ� Ű�� " +height+ "�̰�, ���ϴ� �����Դ� " +weight+ "kg�Դϴ�." );
		
		
	}
}
