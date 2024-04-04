package com.kh.practice.array;

import java.util.Arrays;
import java.util.Scanner;

public class ArrayPractice {
	/*
	 * [배열 선언]
	 * 			자료형[] 변수명 = new 자료형[데이터 길이];
	 */
	Scanner sc = new Scanner(System.in);
	
	
	public void practice1() {
		// 길이가 10인 정수형(1~10까지의 값을 저장) 배열을 선언
		int[] arr = new int[10];
		
		/*
		 *  반복문을 사용하지 않을 경우
		 */
		arr[0] = 1; // arr 배열의 첫번째 위치에 1을 대입
		arr[1] = 2; // arr 배열의 두번째 위치에 2를 대입
		arr[2] = 3; // arr 배열의 세번째 위치에 3을 대입
		// .....
		arr[9] = 10; // arr 배열의 마지막 위치(10번째) 10을 대입
		
		// 반복문을 사용해서 첫번째부터 마지막까지 1부터 차례대로 대입
		// 배열 길이 : [참조변수명].length
		for(int i=0; i<arr.length; i++) {
			arr[i] = i+1;		//배열의 값 대입
			//System.out.print(arr[i] + " ");
		}
		for(int i=0; i<arr.length; i++) {
			System.out.printf("%d ", arr[i]);
		}
	}
	public void practice2() {
		// 길이가 10인 정수형 배열 선언
		int[] arr = new int[10];
		// arr.length : 10
		arr[0] = 10;	// arr.length - index = 10 -0
		arr[1] = 9;		// arr.length - index = 10 -1
		arr[2] = 8;		// arr.length - index = 10 -2
		// ...
		arr[9] = 1;
		for(int i=0; i<arr.length; i++) {
			arr[i] = arr.length-i; 
		}
		for(int i=0; i<arr.length; i++) {
			System.out.printf("%d ", arr[i]);
		}
	}
	
	public void practice3() {
		Scanner sc = new Scanner(System.in);
		while(true) {
			System.out.print("양의 정수: ");
		
			int num = sc.nextInt();
			if(num<0) {
				System.out.println("잘못 입력했습니다.");
				break;
			}
			int[] arr = new int[num];
		
			for(int i=0; i<arr.length; i++) {
					arr[i] = i+1;
					System.out.print(arr[i] + " ");
			} break;
		}
	}
	
	public void practice4() {
		String[] fruit = { "사과", "귤", "포도", "복숭아", "참외"};
		
		System.out.println(fruit[1]);
	}
	
	public void practice5() {
		System.out.print("문자열 : ");
		String str = sc.next();
		System.out.print("문자 : ");
		char ch = sc.next().charAt(0);
		
		//입력받은 문자열을 배열에 문자 하나하나 넣음 => 문자형 배열
		// 문자열 길이 : [문자열 변수 또는 값].length()
		// 배열 길이 : [배열 변수 또는 값].length
		char[] arr = new char[str.length()];
		
		for(int i=0; i<str.length(); i++) {
			arr[i] = str.charAt(i);
		}
		// 배열 데이터 출력 ([값1, 값2, 값3, ...] 형식) : Arrays.toString([참조변수명])
		System.out.println(Arrays.toString(arr));
		
		// 입력받은 문자가 문자열에 몇 개가 있는지 카운트
		int count = 0; // 입력한 문자의 개수를 구하기 위해 count변수 선언.
		System.out.print(str+ "에 " +ch+"가 존재하는 위치(인덱스) : ");
		for(int i=0; i<arr.length; i++) {
			if(arr[i] == ch) {
				count++;
				// 인덱스 위치를 알 수 있음..
				System.out.print(i + " ");
			}
		}
		System.out.println();
		System.out.print(ch + " 개수 : " +count);
		
	
		
	}
	
	public void practice6() {
		String[] day = new String[] { "월", "화", "수", "목", "금", "토", "일" };
		System.out.print("0 ~ 6 사이 숫자 입력 : ");
		int num = sc.nextInt();
		
		 if(num<7 && num>=0) {
			 System.out.println(day[num] + "요일");
		 }
		 else {
			 System.out.println("잘못 입력하셨습니다.");
		 }
	
		
	}
	
	public void practice7() {
		System.out.print("정수 : ");
		int num = sc.nextInt();
		int[] arr = new int[num];
		
		for(int i=0; i<num; i++) {
			System.out.print("배열 "+i+"번째 인덱스에 넣을 값: ");
			int num2 = sc.nextInt();
			arr[i] = num2;
		}
		for(int i=0; i<num; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
		int sum =0;
		for(int i=0; i<num; i++) {
			sum += arr[i];
		}
		System.out.println("총 합 : " +sum);	
		
	}
	
	public void practice8() {
		while(true) {
			System.out.print("정수 : ");
			int num = sc.nextInt();
			int count = 0; // 배열 인덱스 값을 1부터 증가시키기 위해 선언한 변수
			
			if(num>=3 && num%2==1) {
				int[] arr = new int[num];
				
				for(int i=0; i<arr.length; i++) {
					if(i<=arr.length/2) {
						arr[i] = ++count;
					} else {
						arr[i] = --count;
					}
				}
				for(int i=0; i<arr.length; i++) {
					System.out.print(arr[i] + " ");
				}
				break;
			} else {
				System.out.println("다시 입력하세요.");
			}
		}
	}
	public void practice9() {
		String[] str = { "양념", "후라이드", "간장" };
		System.out.print("치킨 이름을 입력하세요 : ");
		String chic = sc.next();
		boolean yes = false;
		for(int i=0; i<str.length; i++) {
			if(str[i].equals(chic)) {
				yes = true;
			}
		}
		if(yes==false) {
			System.out.println(chic + "치킨은 없는 메뉴입니다.");
		} else {
			System.out.println(chic + "치킨 배달 가능");
		}
	}
	
	public void practice10() {
//		System.out.print("주민등록번호(-포함) : ");
//		String pNum = sc.next();
//		
//		
//		String[] arr1 = new String[pNum.length()];
//		
//		String[] arr2 = Arrays.copyOf(arr1, pNum.length());
//		
//		for(int i=7; i<arr2.length; i++) {
//			arr2[i] = "*";
//			System.out.print(arr2[i]);
//		}
		
		System.out.print("주민등록번호(-포함) : ");
		String pNum = sc.next();
		
		char[] arr = new char[pNum.length()];
		
		for(int i=0; i<pNum.length(); i++) {
			arr[i] = pNum.charAt(i);
		}
		
		char[] arr2 = Arrays.copyOf(arr, arr.length);
		
		for(int i=8; i<arr2.length; i++) {
			arr2[i] = '*';
		}
		System.out.println(arr2);
	}
	
	public void practice11() {
		int [] arr = new int[10];
		for(int i=0; i<arr.length; i++) {
			arr[i] = (int)(Math.random()*10+1);
			System.out.print(arr[i] + " ");
		}
	}

	
	public void practice12() {
		// 10개의 값을 저장할 수 있는 정수형 배열 선언 및 할당(생성)
			int[] numbers = new int[10];
			
		//	System.out.println(numbers); // 참조변수명 출력 시 주소값 확인
			
			// 1 ~ 10 사이의 난수(랜덤 값)를 발생시켜 배열에 초기화
			// Math.random() => 0.0 ~ 0.9999 ( 0 <= n < 1)
			for(int i=0; i<numbers.length; i++) {
				numbers[i] = (int)(Math.random()*10+1);
				System.out.print(numbers[i] + " ");
			}
			
			// 배열 데이터 중 최대값과 최소값을 출력
			//System.out.println(Arrays.toString(numbers));
			
			//(1) 하나하나 비교하여 찾기
			int max = 0; // 최대값을 구하기 위해 max라는 변수 선언 및 초기화
			int min = 10; // 최소값을 구하기 위해 min라는 변수 선언 및 초기화
			
			for(int i=0; i<numbers.length; i++) {
				if(max<numbers[i]) {
					max = numbers[i];
				}
				if(min>numbers[i]) {
					min = numbers[i];
				}
			}
			System.out.println();
			System.out.println("최대값: " +max);
			System.out.println("최소값: " +min);
			
			System.out.println("==================================");
			
			//(2) 배열을 오름차순으로 정렬하여 찾기
			//	배열 오름차순 정렬 : Arrays.sort([참조변수명]);
			//	배열 내림차순 정렬 : Arrays.sort([참조변수명], Collections.reverseOrder());
			Arrays.sort(numbers);
			System.out.println(Arrays.toString(numbers));
			// 배열의 마지막 위치(인덱스): 배열길이-1
			System.out.println("최대값: " +numbers[numbers.length-1]);
			System.out.println("최소값: " +numbers[0]);
	}
	
	public void practice13() {
		int[] arr = new int[10];
		for(int i=0; i<arr.length; i++) {
			arr[i] = (int)(Math.random()*10+1);
			for(int j=0; j<i; j++) {
				if(arr[i] == arr[j]) {
					i--;
				}
			}
		}
		for(int i=0; i<arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}
	public void practice14() {
		// 당첨 번호 : 3 20 28 38 40 43 +4
		// 당첨 번호에 해당하는 배열을 선언 및 생성
		int[] lottoS = { 3, 20, 28, 38, 40, 43, 4};
		// 보너스 점수를 따로 변수로 저장
//		int[] lottoS = { 3, 20, 28, 38, 40, 43};
//		int bonus =4
		
		
		
		// 로또 번호 : 1 ~45
		// 로또 번호 6자리를 저장할 배열 선언 및 생성
		int[] lotto = new int[6];
		
		// 반복문 돌리면서 랜덤 값을 배열에 초기화
		// 바깥쪽 for문: 배열에 데이터를 대입
		for(int i=0; i<lotto.length; i++) {
			// 0 <= n < 1
			lotto[i] = (int)(Math.random()*45+1);
			
			//안쪽 for문: 중복값을 확인하기 위해 첫번째 위치부터 다시 읽어옴.
			for(int j=0; j<i; j++) {
				if(lotto[j] == lotto[i]) {
					// i번째 데이터와 j번째 데이터가 동일하다 (중복데이터 있다.)
					i--;
					break; // 배열의 길이가 길어질 경우 반복문 돌릴 때 효율성 위해.
				}
			}
		}
		// 배열 데이터를 오름차순 정렬
		Arrays.sort(lotto);
		
		// 로또 번호 출력하기
		System.out.print("로또 번호 : ");
		for(int i=0; i<lotto.length; i++) {
			System.out.print(lotto[i] + " ");
		}
		System.out.println();
		
		// 당첨 번호 출력하기
		System.out.print("당첨 번호 : ");
		for(int i=0; i<lottoS.length; i++) {
			System.out.print(lottoS[i] + " ");
		}
		System.out.println();
		//System.out.println(Arrays.toString(lottoS));  // 당첨 번호 배열로 나열
		

		
		//당첨 여부를 체크
		int count =0;
		boolean bBonus = false;
		// 바깥쪽 for문: 랜덤값을 저장한 배열의 데이터를 조회 (i: lotto의 인덱스)
		for(int i=0; i<lotto.length; i++) {
			
			// 안쪽 for문: 당첨번호를 저장한 배열의 데이터를 조회 (j: lottoS의 인덱스)
			for(int j=0; j<lottoS.length; j++ ) {
				if(lotto[i] == lottoS[j]) {
					count++;
					if(j == lottoS.length -1) {
						// lotto 배열의 i번째 데이터와 lottoS 배열의 j번째 데이터가 동일하고
						// j의 값이 lottoS 배열의 마지막 위치인 경우 수행
						bBonus = true;
					}
				}
			}
		}
		switch(count) {
		case 6: 
			// 2등 ? 1등 ?
			if(bBonus)	{ // bBonus(boolean) : true/false
				System.out.println("2등 당첨입니다.");
			} else {	
				System.out.println("1등 당첨입니다.");
			}
			break;
		case 5: 
			System.out.println("3등 당첨입니다.");
			break;
		case 4:	
			System.out.println("4등 당첨입니다.");
			break;
		case 3:
			System.out.println("5등 당첨입니다.");
			break;
		default:
			System.out.println("당첨이 안됐습니다.");
		}
		// 당첨 여부를 결과로 출력 : "1등 당첨입니다."
		// 1등) 6개 번호 일치
		// 2등) 5개 번호 일치 + 보너스 번호 일치
		// 3등) 5개 번호 일치
		// 4등) 4개 번호 일치
		// 5등) 3개 번호 일치
		
	}
	
	public void practice15() {
		System.out.print("문자열 : ");
		String str = sc.next();
		char[] arr = new char[str.length()];
		int count =0;
		System.out.print("문자열에 있는 문자 : ");
		for(int i=0; i<arr.length; i++) {
			arr[i] = str.charAt(i);
			
			boolean dup = true;
			
			for(int j=0; j<i; j++) {
				if(arr[i] == arr[j]) {
					dup = false;
				}
			}
			if(dup == true) {
				if(i==0) {
					System.out.print(arr[i]);
				}
				else {
					System.out.print(", " +arr[i]);
				}
				count++;
			}
		}
		System.out.println();
		System.out.println("문자 개수 : " +count);
		
	}
	
	public void practice16() {
		System.out.print("배열의 크기를 입력하세요 : ");
		int size = sc.nextInt();
		String[] str = new String[size];
		sc.nextLine();
		int count = 0;
		while(true) {	
			for(int i=count; i<str.length; i++) {
				System.out.print(i+1 +"번째 문자열 : ");
				str[i] = sc.nextLine();
			}
			count = str.length;
		
			System.out.print("더 값을 입력하시겠습니까?(Y/N) : ");
			char ch = sc.nextLine().charAt(0);
			if(ch == 'y' || ch == 'Y') {
				System.out.print("더 입력하고 싶은 개수 : ");
				int num = sc.nextInt();
				String[] str2 = new String[str.length+num];
				sc.nextLine();
				System.arraycopy(str, 0, str2, 0, str.length);
				str = str2;
			}
			else if(ch == 'N' || ch == 'n') {
				System.out.println(Arrays.toString(str));
				break;
			}
		}	
		
		
	}
}
