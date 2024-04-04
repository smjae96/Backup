package com.kh.array;

class Person {
	String name;
	int age;
	double height;
	
	public Person() {
		name = "홍길동";
		age = 17;
	}

	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}
}

class Hong extends Person {
	// 1) 생성자가 정의되어 있지 않으면, 자동으로 기본생성자가 실행.
	//  public Hong() {}
	// 2) 기본생성자가 실행될 때 부모클래스 기본생성자가 자동으로 호출(실행)
	//	public Hong() {
	//		super();
	//	}
}

class IU extends Person {
	public IU() {
		//부모클래스의 생성자를 호출해서, "아이유", 32 값을 초기화
// 상속받은 필드에 직접 초기화가 가능하지만.. 부모클래스의 생성자를 활용
//		name = "아이유";
//		age = 32;
		super("아이유", 32);
	}
}

public class C_ObjectArray {
	public static void main(String[] args) {
		// Person 객체 배열 생성 : 2명의 사람을 저장할 배열
		Person[] pArr = new Person[2];
		//	* 객체 배열 생성만으로 배열 내에 인스턴스가 생성되는 것은 아님!
		//		=> 따라서, 배열 내에 해당 객체타입으로 인스턴스를 생성해줘야 함.
		pArr[0] = new IU();			// 다형성: 부모클래스 타입의 참조변수는 자식클래스타입의 인스턴스를 생성할 수 있음.
									// 		 여러가지 형태를 갖출 수 있음
		pArr[1] = new Hong();
		
		
		for(Person p : pArr) {
			System.out.printf("이름 : %s, 나이 : %d\n", p.name, p.age);
		}
	}
}
