package com.kh.practice.dimension;

import java.util.Arrays;
import java.util.Scanner;

public class DimensionPractice {
	Scanner sc = new Scanner(System.in);
	
	public void practice1() {
		// 3행 3열짜리 문자열 배열을 선언 및 할당(생성)
		// 자료형[][] 참조변수명 = new 자료형[행 크기][열 크기];
		int r = 3;
		int c = 3;
		String[][] arr =  new String[3][3];
		
		// 0행 0열부터 2행 2열까지 "(0, 0)"과 같은 형식으로 저장 후 출력
		for(int i=0; i<arr.length; i++) {	// 바깥쪽 for문: 행 인덱스 처리
			// i: 0 1 2
			for(int j=0; j<arr[i].length; j++) {	// 안쪽 for문: 열 인덱스 처리
				// j: 0 1 2
				// arr[0][0] / arr[0][1] / arr[0][2]
				// arr[1][0] / arr[1][1] / arr[1][2]
				// arr[2][0] / arr[2][1] / arr[2][2]
				arr[i][j] = "(" + i + ", " + j + ")";
				
				System.out.print(arr[i][j]);
			}
			System.out.println();
		}
	}
	
	public void practice2() {
		// 4행 4열짜리 정수형 배열을 선언 및 할당(생성)
		int[][] arr = new int[4][4];
		// (1) 대입할 값을 변수로 저장하여 처리
		int num = 0;
		// 1 ~ 16까지 값을 차례대로 저장.
		for(int i=0; i<arr.length; i++ ) {
			for(int j=0; j<arr[i].length; j++) {
				arr[i][j] = ++num;
				
				//System.out.print(arr[i][j] +" ");
				System.out.printf("%3d" , arr[i][j]);	// %3d : 공간 3칸 마련하여 오른쪽 정렬하여 출력
			}
			System.out.println();
		}
		//----------------------------------------------
		// [2] 방법
		// 1 ~ 16까지 값을 차례대로 저장
//		for(int i=0; i<arr.length; i++ ) {
//			for(int j=0; j<arr[i].length; j++) {
//				// 1 2 3 4 => j: 0 1 2 3 => j+1: 1 2 3 4
//				// 5 6 7 8 => (4+1) (4+2) (4+3) (4+4)
//				// 9 10 11 12 => (8+1) (8+2) (8+3) (8+4)
//				// 13 14 15 16 => (12+1) (12+2) (12+3) (12+4)
//				arr[i][j] = (i*4) + (j+1);
//				System.out.print(arr[i][j] + " ");
//			}
//			System.out.println();
//		}
	}
	
	public void practice3() {
		// 4행 4열짜리 정수형 배열 선언 및 할당(생성)
		int[][] arr = new int[4][4];
		int num = 16;
		// 16~1까지 거꾸로 값을 저장.
		for(int i=0; i<arr.length; i++) {
			for(int j=0; j<arr[i].length; j++) {
				arr[i][j] = num--;
				System.out.printf("%3d" , arr[i][j]);
			}
			System.out.println();
		}
	}
	
	public void practice4() {
		// 4행 4열 2차원 배열을 생성하여 0행 0열부터 2행 2열까지는 1~10까지의 임의의 정수 값 저장
		// 3행 0열에는 0열 값들의 합, 3행 1열에는 1열 값들의 합, 3행 2열에는 2열 값들의 합, 0행 3열에는 0행 값들의 합
		// 0행 3열에는 0행 값들의 합, 1행 3열에는 1행 값들의 합, 2행 3열에는 2행 값들의 합, 3행 3열에는 가로 세로 합
		
		int[][] arr = new int[4][4];
		int sum1 = 0;
		
		for(int i=0; i<arr.length; i++) {
			for(int j=0; j<arr[i].length; j++) {
				if(i<=2 && j<=2) {
					arr[i][j] = (int)(Math.random()*10+1);
				}
				else if(i==3 && j!=3) {
					 
					arr[i][j] = arr[0][j] + arr[1][j] + arr[2][j]; 
				}
				else if(j==3 && i!=3) {
					arr[i][j] = arr[i][0] + arr[i][1] + arr[i][2];
				}
				else if(j==3 && i ==3){
					arr[i][j] = arr[0][3] + arr[1][3] + arr[2][3] + arr[3][0] + arr[3][1] + arr[3][2];
				}
				System.out.printf("%4d" , arr[i][j]);
			}
			System.out.println();
		}
	}
	
	public void practice5() {
		System.out.print("행 크기 : ");
		int row = sc.nextInt();
		System.out.print("열 크기 : ");
		int col = sc.nextInt();
		//입력받은 행의 크기와 열의 크기로 2차원 배열 선언 및 할당
		char[][] arr = new char[row][col];
		while(true) {
			// 1 ~ 10 사이의 숫자가 입력되지 않았을 경우 메시지 출려 후 다시 입력하도록
			// [1] ((row<1 || row>10) || (col<1 || col>10)) // row 또는 col의 범위가 1 ~ 10을 벗어남
			// [2] (!(row>=1 && row<=10) || !(col>=1 && col<=10))
			if((row<1 || row>10) || (col<1 || col>10)) {
				System.out.println("반드시 1~10 사이의 정수를 입력해야 합니다.");
				continue; // 반복문 돌 때 효율성 위해, 조건문이 만족할 경우 continue 아래쪽 실행 x
			}
			
			for(int i=0; i<arr.length; i++) {
				for(int j=0; j<arr[i].length; j++) {
					// 배열 안에 영어 대문자를 랜덤으로 대입
					// A: 65
					// 0 <= n < 1
					// Math.random() * (필요한 개수) + (시작번호)
					arr[i][j] = (char)(Math.random()*26+65);
					System.out.print(arr[i][j]+ " ");
				}
				System.out.println();
			}
			break; // while문을 break해서 빠져나가야함.
		}	
	}
	
	public void practice6() {
		String[][] strArr = new String[][] {{"이", "까", "왔", "앞", "힘"}, {"차", "지", "습", "으", "냅"}, {"원" ,
		"열", "니", "로", "시"}, {"배", "심", "다", "좀", "다"}, {"열", "히", "! ", "더", "!! "}};	
		
		for(int i=0; i<strArr.length; i++) {
			for(int j=0; j<strArr[i].length; j++) {
				System.out.print(strArr[j][i] +" ");
			}
			System.out.println();
		}
	}
	
	public void practice7() {
		
		// 사용자에게 행의 크기를 입력받고
		System.out.print("행의 크기: ");
		int row = sc.nextInt();
		
		
		// 문자형 가변 배열(2차열)을 선언 및 할당
		char[][] arr = new char[row][];
		
		// 그 값만큼 반복해서 열의 크기도 입력 받아
		for(int i=0; i<arr.length; i++) {
			System.out.print(i+"행의 열 크기 : ");
			int col = sc.nextInt();
			// i:0 arr[0] = new char[col];
			// i:1 arr[1] = new char[col];
			// ...
			arr[i] = new char[col];
		}
		char alp = 'a';
		// (0,0) ~ (row-1, col..) 까지 'a' ~ .. 대입.
		// * 인덱스가 2개 필요 : 행에 대한 인덱스, 열에 대한 인덱스
		for(int i=0; i<arr.length; i++) {	// 2차원 배열(arr)의 길이만큼 == 행의 크기
			for(int j=0; j<arr[i].length; j++) {	// 각 배열의 길이만큼 == 행 별 열의 크기
				// arr[i] -> 1차원 배열
				arr[i][j] = alp++;		// alp = alp + 1;
										//	   = (char)alp + (int)1;
										// 	   = [int](alp+1)
										//	   = (char)[int](alp+1)		// 자동형변환
				
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	public void practice8() {
		// 1차원 배열에 12명의 학생들을 출석부 순으로 초기화.
		// 2열 3행으로 2차원 배열 2개를 이용하여 분단을 나눠
		// 1분단 왼쪽부터 오른쪽, 1행에서 아래 행 순으로 자리 배치.
		String[][] arr1 = {{"강건강", "남나나"} , {"도대담", "류라라"} , {"문미미", "박보배"}};
		String[][] arr2 = {{"송성실", "윤예의"} , {"진재주" , "차천축"} , {"피풍표", "홍하하"}};
		
		System.out.println("== 1분단 ==");
		for(int i=0; i<arr1.length; i++) {
			for(int j=0; j<arr1[i].length; j++) {
				System.out.print(arr1[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println("== 2분단 ==");
		for(int i=0; i<arr2.length; i++) {
			for(int j=0; j<arr2[i].length; j++) {
				System.out.print(arr2[i][j] + " ");
			}
			System.out.println();
		}
		
	}
	public void practice9() {
		String[][] arr1 = {{"강건강", "남나나"} , {"도대담", "류라라"} , {"문미미", "박보배"}};
		String[][] arr2 = {{"송성실", "윤예의"} , {"진재주" , "차천축"} , {"피풍표", "홍하하"}};
		
		System.out.println("== 1분단 ==");
		for(int i=0; i<arr1.length; i++) {
			for(int j=0; j<arr1[i].length; j++) {
				System.out.print(arr1[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println("== 2분단 ==");
		for(int i=0; i<arr2.length; i++) {
			for(int j=0; j<arr2[i].length; j++) {
				System.out.print(arr2[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println("================================");
		System.out.print("검색할 학생 이름을 입력하세요 : ");
		String name = sc.next();
		
		for(int i=0; i<arr1.length; i++) {
			for(int j=0; j<arr1[i].length; j++) {
				if(arr1[i][j].equals(name)) {

					if(j==0) {
						System.out.println("검색하신 "+name+ "학생은 1분단 " +(i+1)+ " 번째 줄 "+ "왼쪽에 있습니다.");
					}
					else {
						System.out.println("검색하신 "+name+ "학생은 1분단 " +(i+1)+ " 번째 줄 "+ "오른쪽에 있습니다.");
					}
				}
			}
		}
		for(int i=0; i<arr2.length; i++) {
			for(int j=0; j<arr2[i].length; j++) {
				if(arr2[i][j].equals(name)) {
					
					if(j==0) {
						System.out.println("검색하신 "+name+ "학생은 2분단 " +(i+1)+ " 번째 줄 " + "왼쪽에 있습니다.");
					}
					else {
						System.out.println("검색하신 "+name+ "학생은 2분단 " +(i+1)+ " 번째 줄 " + "오른쪽에 있습니다.");
					}
				}
			}
		}
	}
	
	public void practice10() {
		String[][] arr = new String[6][6];
		System.out.print("행 인덱스 입력 : ");
		int row = sc.nextInt();
		System.out.print("열 인덱스 입력 : ");
		int col = sc.nextInt();
		for(int i=0; i<arr.length; i++) {
			for(int j=0; j<arr[i].length; j++) {
				if(i==0) {
					switch(j) {
						case 0 : arr[i][j] = "";
						break;
						case 1 : arr[i][j] ="0";
						break;
						case 2 : arr[i][j] ="1";
						break;
						case 3 : arr[i][j] ="2";
						break;
						case 4 : arr[i][j] ="3";
						break;
						case 5 : arr[i][j] ="4";
						break;
					}
				}
				else if(j==0) {
					switch(i) {
						case 0 : arr[i][j] = "";
						break;
						case 1 : arr[i][j] = "0";
						break;
						case 2 : arr[i][j] = "1";
						break;
						case 3 : arr[i][j] = "2";
						break;
						case 4 : arr[i][j] = "3";
						break;
						case 5 : arr[i][j] = "4";
					}
				}
				else if(i==row && j==col) {
					arr[i][j] = "X";
				}
				else { 
					arr[i][j] = "";
				}
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	public void practice11() {
		String[][] arr = new String[6][6];
		int row;
		int col;
		while(true) {
		System.out.print("행 인덱스 입력 : ");
		row = sc.nextInt(); 
		if(row == 99) {
			System.out.println("프로그램 종료");
			break;
		}
		System.out.print("열 인덱스 입력 : ");
		col = sc.nextInt();
		for(int i=0; i<arr.length; i++) {
			for(int j=0; j<arr[i].length; j++) {
				if(i==0) {
					switch(j) {
						case 0 : arr[i][j] = "";
						break;
						case 1 : arr[i][j] ="0";
						break;
						case 2 : arr[i][j] ="1";
						break;
						case 3 : arr[i][j] ="2";
						break;
						case 4 : arr[i][j] ="3";
						break;
						case 5 : arr[i][j] ="4";
						break;
					}
				}
				else if(j==0) {
					switch(i) {
						case 0 : arr[i][j] = "";
						break;
						case 1 : arr[i][j] = "0";
						break;
						case 2 : arr[i][j] = "1";
						break;
						case 3 : arr[i][j] = "2";
						break;
						case 4 : arr[i][j] = "3";
						break;
						case 5 : arr[i][j] = "4";
					}
				}
				else if(i==row && j==col) {
					arr[i][j] = "X";
				}
				else { 
					if(arr[i][j]=="X"){
						arr[i][j] ="X";
					}
					else {
						arr[i][j] = "";
					}
				}
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
		}
	}
}
