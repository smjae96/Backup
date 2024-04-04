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
					System.out.print("강아지의 이름을 입력 : ");
					String dogN = sc.next();
					System.out.print("강아지의 종을 입력 : ");
					String dogT = sc.next();
					System.out.print("강아지의 몸무게를 입력 : ");
					int dogW = sc.nextInt();
					animal[i] = new Dog(dogN, dogT, dogW);
					
				}
				else  {
					System.out.print("고양이의 이름을 입력 : ");
					String catN = sc.next();
					System.out.print("고양이의 종을 입력 : ");
					String catT = sc.next();
					System.out.print("고양이의 장소를 입력 : ");
					String catL = sc.next();
					System.out.print("고양이의 색을 입력 : ");
					String catC = sc.next();
					animal[i] = new Cat(catN, catT, catL, catC);
				}
				animal[i].speak();

			}
			break;
		}

	}

}
