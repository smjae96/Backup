package com.kh.example.practice1.run;

import com.kh.example.practice1.model.vo.Member;

public class Run {
	
	
	//�޼ҵ��
	public static void main(String[] args) {
		// Member Ŭ���� ���� �� �ν��Ͻ� ����
		Member member1 = new Member();	// �⺻ ������: Ŭ������()
		// changeName()�� �̿��� ���� ����
		member1.changeName("ȫ�浿");
		// printNAme()�� �̿��� ���
		member1.printName();
		
	}

}
