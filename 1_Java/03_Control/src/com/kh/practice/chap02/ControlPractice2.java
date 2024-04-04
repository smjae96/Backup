package com.kh.practice.chap02;

public class ControlPractice2 {
	public static void main(String[] args) {
		//gugudan();
		//breaker();
		continue1();
	}
	
	public static void gugudan() {
		// 바깥쪽 for문 : X단
		// 안쪽 for문  : 곱해지는 값
		// for(초기식;조건식;증감식) {}
//		for(int i=2; i<10; i++) {
//			// i : 2, 3, 4, ..., 9 - 2단부터 9단
//			for(int j=1; j<10; j++) {
//				// j : 1, 2, 3, ..., 9 - 곱해지는 값
//				System.out.printf("%d x %d = %d\n" , i, j, (i*j));
//			}
//			System.out.println();
//		}
		
		//가로로 구구단 출력하기
		for(int i=1; i<10; i++) { // 바깥쪽 for문: 곱해지는 값
			for(int j=2; j<10; j++) { // 안쪽 for문: x단
				System.out.printf("%d x %d = %d \t",j,i,j*i);
				//System.out.printf("%d x %d = %2d", j,i,j*i); // %2d하면 살짝 공간 띄워짐.
				//System.out.print(j+" x "+ i + " = " + j*i);
				//System.out.print("\t");
			}
			System.out.println();
		}
	}
	public static void breaker() {
		for(int i=1; ; i++) {
			System.out.println(i + "출력");
			if(i>=10) {
				break;
			}
		}
	}
	public static void continue1() {
		for(int i=1; i<=10; i++) {
			if(i%2==0) {
				continue;
			}
			System.out.println(i + "출력");
		}
	}
}
