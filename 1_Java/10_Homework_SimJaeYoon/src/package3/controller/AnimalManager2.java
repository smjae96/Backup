package package3.controller;

import java.util.Scanner;

import package3.model.vo.Animal;
import package3.model.vo.Cat;
import package3.model.vo.Dog;

public class AnimalManager2 {
	// [추가 응용(선택)]
	/* 사용자로부터 동물 정보를 입력받아 저장
	 * 종류 선택 후 강아지/고양이 정보에 맞게 입력
	 * 
	 * Animal 객체 배열에는 랜덤값(0~4)을 뽑아
	 * 무작위로 추가되도록 함
	 * 
	 * 배열이 모두 꽉 찬 경우 더 이상 추가 못하도록 처리
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Animal[] animal = new Animal[5];
		while(animal[0]==null || animal[1] == null || animal[2] == null || animal[3] == null || animal[4] == null) {
				for(int i=0; i<animal.length; i++) {
					int numR = (int)(Math.random()*5);
					i= numR;
					if(animal[i] != null) {
						System.out.println("이미 동물이 기록된 배열이므로 랜덤 번호를 다시 뽑습니다.");
						break;
					}
					System.out.print("동물의 종류를 선택하세요(강아지/고양이) : ");
					String ani = sc.next();
					System.out.println(i+"번 배열에 적용합니다!");
					if(ani.equals("강아지")) {
						System.out.print("강아지의 이름을 입력 : ");
						String dogN = sc.next();
						System.out.print("강아지의 종을 입력 : ");
						String dogT = sc.next();
						System.out.print("강아지의 몸무게를 입력 : ");
						int dogW = sc.nextInt();
						animal[i] = new Dog(dogN, dogT, dogW);
						
					}
					else if(ani.equals("고양이"))  {
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
		System.out.println("=====출력 종료=====");
	}

}
