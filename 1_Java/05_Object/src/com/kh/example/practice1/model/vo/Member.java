package com.kh.example.practice1.model.vo;

public class Member {
	// �ʵ�� : ������ ����, ����
	private String memberld;	// ���̵�
	private String memberPwd;	// ��й�ȣ
	private String memberName;	// �̸�
	private int age;			// ����
	private char gender;		// ����
	private String phone;		// ����ó
	private String email;		// �̸���
	
	// �����ں�
	public Member() {
		
	}
	

	// �޼ҵ�� : ��� ����
	// changeName : setName �� ����
	public void changeName(String name) {
		memberName = name;
	}
	// printName : �̸�(memberName)�� ���� ���
	public void printName() {
		System.out.println(memberName);
	}
	
	
}
