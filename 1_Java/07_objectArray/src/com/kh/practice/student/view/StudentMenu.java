package com.kh.practice.student.view;

import com.kh.practice.student.controller.StudentController;
import com.kh.practice.student.model.vo.Student;

public class StudentMenu {
	// 필드부
	private StudentController ssm = new StudentController();
	// 생성자부
	public StudentMenu() {
		// ========== 학생 정보 출력 ==========
		System.out.println("========== 학생 정보 출력 ==========");
		// StudentController에 printStudent()의 반환 값을 통해 학생 정보 출력.
		Student[] sArr = ssm.printStudent();
		// for(자료형 변수명 : 배열명) {}
		for(int i=0; i<sArr.length; i++) {
			System.out.println(sArr[i].inform());
		}
//		for(Student student : sArr) {
//			System.out.println(student.inform());
//		}
		// ========== 학생 성적 출력 ==========
		System.out.println("========== 학생 성적 출력 ==========");
		// StudentController에 avgScore()를 통해 점수 합계와 평균 출력
		double[] scores = ssm.avgScore();
		System.out.println("학생 점수 합계: " + scores[0]);
		System.out.println("학생 점수 평균: " + scores[1]);
		
		System.out.println("========== 성적 결과 출력 ==========");
		// 학생의 점수가 CUT_LINE 미만이면 재시험 대상, 이상이면 통과 출력
		for(Student student : sArr) {
//			System.out.printf("%s학생은 %s입니다." , student.getName(),
//					(student.getScore() < StudentController.CUT_LINE ?
//							"재시험 대상" : "통과"));
			if(student.getScore() < StudentController.CUT_LINE) {
				System.out.printf("%s학생은 재시험 대상입니다.", student.getName());
			} else {
				System.out.println(student.getName() + "학생은 통과입니다.");
			}
		}
		
		
		

		
		
		
		
		
		//		System.out.println("==========학생 정보 출력==========");
//		ssm.printStudent();	
//		System.out.println();
//		System.out.println("==========학생 성적 출력==========");
//		System.out.println("학생 점수 합계 : " +ssm.sumScore());
//		System.out.println("학생 점수 평균 : " +ssm.avgScore());
//		for(int i=0; i<ssm.avgScore().length; i++) {
//			ssm.avgScore();
//			if(i==0) {
//				System.out.println("학생 점수 합계 : " +ssm.);
//			}
//		}
//		System.out.println();
//		System.out.println("==========성적 결과 출력==========");

		
	}
}
