package package3.controller;

import java.util.Scanner;

import package3.model.vo.Animal;
import package3.model.vo.Cat;
import package3.model.vo.Dog;

public class AnimalManager {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Animal[] animal = new Animal[5];
		while(true) {
			
			for(int i=0; i<animal.length; i++) {
				int a = (int)(Math.random()*2)+1;
				if(a == 1) {
					System.out.print("�������� �̸��� �Է� : ");
					String dogN = sc.next();
					System.out.print("�������� ���� �Է� : ");
					String dogT = sc.next();
					System.out.print("�������� �����Ը� �Է� : ");
					int dogW = sc.nextInt();
					animal[i] = new Dog(dogN, dogT, dogW);
					
				}
				else  {
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

			}
			break;
		}

	}

}
