package com.kh.practice.student.view;

import com.kh.practice.student.controller.StudentController;
import com.kh.practice.student.model.vo.Student;

public class StudentMenu {
	// �ʵ��
	private StudentController ssm = new StudentController();
	// �����ں�
	public StudentMenu() {
		// ========== �л� ���� ��� ==========
		System.out.println("========== �л� ���� ��� ==========");
		// StudentController�� printStudent()�� ��ȯ ���� ���� �л� ���� ���.
		Student[] sArr = ssm.printStudent();
		// for(�ڷ��� ������ : �迭��) {}
		for(int i=0; i<sArr.length; i++) {
			System.out.println(sArr[i].inform());
		}
//		for(Student student : sArr) {
//			System.out.println(student.inform());
//		}
		// ========== �л� ���� ��� ==========
		System.out.println("========== �л� ���� ��� ==========");
		// StudentController�� avgScore()�� ���� ���� �հ�� ��� ���
		double[] scores = ssm.avgScore();
		System.out.println("�л� ���� �հ�: " + scores[0]);
		System.out.println("�л� ���� ���: " + scores[1]);
		
		System.out.println("========== ���� ��� ��� ==========");
		// �л��� ������ CUT_LINE �̸��̸� ����� ���, �̻��̸� ��� ���
		for(Student student : sArr) {
//			System.out.printf("%s�л��� %s�Դϴ�." , student.getName(),
//					(student.getScore() < StudentController.CUT_LINE ?
//							"����� ���" : "���"));
			if(student.getScore() < StudentController.CUT_LINE) {
				System.out.printf("%s�л��� ����� ����Դϴ�.", student.getName());
			} else {
				System.out.println(student.getName() + "�л��� ����Դϴ�.");
			}
		}
		
		
		

		
		
		
		
		
		//		System.out.println("==========�л� ���� ���==========");
//		ssm.printStudent();	
//		System.out.println();
//		System.out.println("==========�л� ���� ���==========");
//		System.out.println("�л� ���� �հ� : " +ssm.sumScore());
//		System.out.println("�л� ���� ��� : " +ssm.avgScore());
//		for(int i=0; i<ssm.avgScore().length; i++) {
//			ssm.avgScore();
//			if(i==0) {
//				System.out.println("�л� ���� �հ� : " +ssm.);
//			}
//		}
//		System.out.println();
//		System.out.println("==========���� ��� ���==========");

		
	}
}
