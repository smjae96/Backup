package com.kh.hw.person.model.vo;

public class Person {

	private String name;
	private int age;
	private double height;
	private double weight;
	
	// 생성자부
	public Person() {
		
	}

	public Person(String name, int age, double height, double weight) {
		// 매개변수 값으로 초기화
		this.name = name;
		this.age = age;
		this.height = height;
		this.weight = weight;
	}

	// 메소드부
	// * getter/setter : private 변수들에 대한 조회/설정(대입) 메소드
	
	// * toString : 각 필드의 값 반환
	// getter&setter 메소드 단축키 : alt + shift + s
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}
	
	public String toString() {
		return String.format("%s, %d, %.1f, %.1f", name, age, height, weight);
	}
	
	
}
