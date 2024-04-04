package package3.controller;

import java.util.Scanner;

import package3.model.vo.Animal;
import package3.model.vo.Cat;
import package3.model.vo.Dog;

public class AnimalManager2 {
	// [�߰� ����(����)]
	/* ����ڷκ��� ���� ������ �Է¹޾� ����
	 * ���� ���� �� ������/����� ������ �°� �Է�
	 * 
	 * Animal ��ü �迭���� ������(0~4)�� �̾�
	 * �������� �߰��ǵ��� ��
	 * 
	 * �迭�� ��� �� �� ��� �� �̻� �߰� ���ϵ��� ó��
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Animal[] animal = new Animal[5];
		while(animal[0]==null || animal[1] == null || animal[2] == null || animal[3] == null || animal[4] == null) {
				for(int i=0; i<animal.length; i++) {
					int numR = (int)(Math.random()*5);
					i= numR;
					if(animal[i] != null) {
						System.out.println("�̹� ������ ��ϵ� �迭�̹Ƿ� ���� ��ȣ�� �ٽ� �̽��ϴ�.");
						break;
					}
					System.out.print("������ ������ �����ϼ���(������/�����) : ");
					String ani = sc.next();
					System.out.println(i+"�� �迭�� �����մϴ�!");
					if(ani.equals("������")) {
						System.out.print("�������� �̸��� �Է� : ");
						String dogN = sc.next();
						System.out.print("�������� ���� �Է� : ");
						String dogT = sc.next();
						System.out.print("�������� �����Ը� �Է� : ");
						int dogW = sc.nextInt();
						animal[i] = new Dog(dogN, dogT, dogW);
						
					}
					else if(ani.equals("�����"))  {
						System.out.print("������� �̸��� �Է� : ");
						String catN = sc.next();
						System.out.print("������� ���� �Է� : ");
						String catT = sc.next();
						System.out.print("������� ��Ҹ� �Է� : ");
						String catL = sc.next();
						System.out.print("������� ���� �Է� : ");
						String catC = sc.next();
						animal[i] = new Cat(catN, catT, catL, catC);
					}
					animal[i].speak();
					
					if(animal[i] != null) {
						break;
					}
				
//					if(animal[0] == null | animal[1] == null | animal[2] == null | animal[3] == null | animal[4] == null)
//					{
//						continue;
//					}
				}
		}
		System.out.println();
		System.out.println("=====��� ����=====");
	}

}
