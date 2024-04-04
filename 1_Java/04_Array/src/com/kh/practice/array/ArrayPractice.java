package com.kh.practice.array;

import java.util.Arrays;
import java.util.Scanner;

public class ArrayPractice {
	/*
	 * [�迭 ����]
	 * 			�ڷ���[] ������ = new �ڷ���[������ ����];
	 */
	Scanner sc = new Scanner(System.in);
	
	
	public void practice1() {
		// ���̰� 10�� ������(1~10������ ���� ����) �迭�� ����
		int[] arr = new int[10];
		
		/*
		 *  �ݺ����� ������� ���� ���
		 */
		arr[0] = 1; // arr �迭�� ù��° ��ġ�� 1�� ����
		arr[1] = 2; // arr �迭�� �ι�° ��ġ�� 2�� ����
		arr[2] = 3; // arr �迭�� ����° ��ġ�� 3�� ����
		// .....
		arr[9] = 10; // arr �迭�� ������ ��ġ(10��°) 10�� ����
		
		// �ݺ����� ����ؼ� ù��°���� ���������� 1���� ���ʴ�� ����
		// �迭 ���� : [����������].length
		for(int i=0; i<arr.length; i++) {
			arr[i] = i+1;		//�迭�� �� ����
			//System.out.print(arr[i] + " ");
		}
		for(int i=0; i<arr.length; i++) {
			System.out.printf("%d ", arr[i]);
		}
	}
	public void practice2() {
		// ���̰� 10�� ������ �迭 ����
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
			System.out.print("���� ����: ");
		
			int num = sc.nextInt();
			if(num<0) {
				System.out.println("�߸� �Է��߽��ϴ�.");
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
		String[] fruit = { "���", "��", "����", "������", "����"};
		
		System.out.println(fruit[1]);
	}
	
	public void practice5() {
		System.out.print("���ڿ� : ");
		String str = sc.next();
		System.out.print("���� : ");
		char ch = sc.next().charAt(0);
		
		//�Է¹��� ���ڿ��� �迭�� ���� �ϳ��ϳ� ���� => ������ �迭
		// ���ڿ� ���� : [���ڿ� ���� �Ǵ� ��].length()
		// �迭 ���� : [�迭 ���� �Ǵ� ��].length
		char[] arr = new char[str.length()];
		
		for(int i=0; i<str.length(); i++) {
			arr[i] = str.charAt(i);
		}
		// �迭 ������ ��� ([��1, ��2, ��3, ...] ����) : Arrays.toString([����������])
		System.out.println(Arrays.toString(arr));
		
		// �Է¹��� ���ڰ� ���ڿ��� �� ���� �ִ��� ī��Ʈ
		int count = 0; // �Է��� ������ ������ ���ϱ� ���� count���� ����.
		System.out.print(str+ "�� " +ch+"�� �����ϴ� ��ġ(�ε���) : ");
		for(int i=0; i<arr.length; i++) {
			if(arr[i] == ch) {
				count++;
				// �ε��� ��ġ�� �� �� ����..
				System.out.print(i + " ");
			}
		}
		System.out.println();
		System.out.print(ch + " ���� : " +count);
		
	
		
	}
	
	public void practice6() {
		String[] day = new String[] { "��", "ȭ", "��", "��", "��", "��", "��" };
		System.out.print("0 ~ 6 ���� ���� �Է� : ");
		int num = sc.nextInt();
		
		 if(num<7 && num>=0) {
			 System.out.println(day[num] + "����");
		 }
		 else {
			 System.out.println("�߸� �Է��ϼ̽��ϴ�.");
		 }
	
		
	}
	
	public void practice7() {
		System.out.print("���� : ");
		int num = sc.nextInt();
		int[] arr = new int[num];
		
		for(int i=0; i<num; i++) {
			System.out.print("�迭 "+i+"��° �ε����� ���� ��: ");
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
		System.out.println("�� �� : " +sum);	
		
	}
	
	public void practice8() {
		while(true) {
			System.out.print("���� : ");
			int num = sc.nextInt();
			int count = 0; // �迭 �ε��� ���� 1���� ������Ű�� ���� ������ ����
			
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
				System.out.println("�ٽ� �Է��ϼ���.");
			}
		}
	}
	public void practice9() {
		String[] str = { "���", "�Ķ��̵�", "����" };
		System.out.print("ġŲ �̸��� �Է��ϼ��� : ");
		String chic = sc.next();
		boolean yes = false;
		for(int i=0; i<str.length; i++) {
			if(str[i].equals(chic)) {
				yes = true;
			}
		}
		if(yes==false) {
			System.out.println(chic + "ġŲ�� ���� �޴��Դϴ�.");
		} else {
			System.out.println(chic + "ġŲ ��� ����");
		}
	}
	
	public void practice10() {
//		System.out.print("�ֹε�Ϲ�ȣ(-����) : ");
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
		
		System.out.print("�ֹε�Ϲ�ȣ(-����) : ");
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
		// 10���� ���� ������ �� �ִ� ������ �迭 ���� �� �Ҵ�(����)
			int[] numbers = new int[10];
			
		//	System.out.println(numbers); // ���������� ��� �� �ּҰ� Ȯ��
			
			// 1 ~ 10 ������ ����(���� ��)�� �߻����� �迭�� �ʱ�ȭ
			// Math.random() => 0.0 ~ 0.9999 ( 0 <= n < 1)
			for(int i=0; i<numbers.length; i++) {
				numbers[i] = (int)(Math.random()*10+1);
				System.out.print(numbers[i] + " ");
			}
			
			// �迭 ������ �� �ִ밪�� �ּҰ��� ���
			//System.out.println(Arrays.toString(numbers));
			
			//(1) �ϳ��ϳ� ���Ͽ� ã��
			int max = 0; // �ִ밪�� ���ϱ� ���� max��� ���� ���� �� �ʱ�ȭ
			int min = 10; // �ּҰ��� ���ϱ� ���� min��� ���� ���� �� �ʱ�ȭ
			
			for(int i=0; i<numbers.length; i++) {
				if(max<numbers[i]) {
					max = numbers[i];
				}
				if(min>numbers[i]) {
					min = numbers[i];
				}
			}
			System.out.println();
			System.out.println("�ִ밪: " +max);
			System.out.println("�ּҰ�: " +min);
			
			System.out.println("==================================");
			
			//(2) �迭�� ������������ �����Ͽ� ã��
			//	�迭 �������� ���� : Arrays.sort([����������]);
			//	�迭 �������� ���� : Arrays.sort([����������], Collections.reverseOrder());
			Arrays.sort(numbers);
			System.out.println(Arrays.toString(numbers));
			// �迭�� ������ ��ġ(�ε���): �迭����-1
			System.out.println("�ִ밪: " +numbers[numbers.length-1]);
			System.out.println("�ּҰ�: " +numbers[0]);
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
		// ��÷ ��ȣ : 3 20 28 38 40 43 +4
		// ��÷ ��ȣ�� �ش��ϴ� �迭�� ���� �� ����
		int[] lottoS = { 3, 20, 28, 38, 40, 43, 4};
		// ���ʽ� ������ ���� ������ ����
//		int[] lottoS = { 3, 20, 28, 38, 40, 43};
//		int bonus =4
		
		
		
		// �ζ� ��ȣ : 1 ~45
		// �ζ� ��ȣ 6�ڸ��� ������ �迭 ���� �� ����
		int[] lotto = new int[6];
		
		// �ݺ��� �����鼭 ���� ���� �迭�� �ʱ�ȭ
		// �ٱ��� for��: �迭�� �����͸� ����
		for(int i=0; i<lotto.length; i++) {
			// 0 <= n < 1
			lotto[i] = (int)(Math.random()*45+1);
			
			//���� for��: �ߺ����� Ȯ���ϱ� ���� ù��° ��ġ���� �ٽ� �о��.
			for(int j=0; j<i; j++) {
				if(lotto[j] == lotto[i]) {
					// i��° �����Ϳ� j��° �����Ͱ� �����ϴ� (�ߺ������� �ִ�.)
					i--;
					break; // �迭�� ���̰� ����� ��� �ݺ��� ���� �� ȿ���� ����.
				}
			}
		}
		// �迭 �����͸� �������� ����
		Arrays.sort(lotto);
		
		// �ζ� ��ȣ ����ϱ�
		System.out.print("�ζ� ��ȣ : ");
		for(int i=0; i<lotto.length; i++) {
			System.out.print(lotto[i] + " ");
		}
		System.out.println();
		
		// ��÷ ��ȣ ����ϱ�
		System.out.print("��÷ ��ȣ : ");
		for(int i=0; i<lottoS.length; i++) {
			System.out.print(lottoS[i] + " ");
		}
		System.out.println();
		//System.out.println(Arrays.toString(lottoS));  // ��÷ ��ȣ �迭�� ����
		

		
		//��÷ ���θ� üũ
		int count =0;
		boolean bBonus = false;
		// �ٱ��� for��: �������� ������ �迭�� �����͸� ��ȸ (i: lotto�� �ε���)
		for(int i=0; i<lotto.length; i++) {
			
			// ���� for��: ��÷��ȣ�� ������ �迭�� �����͸� ��ȸ (j: lottoS�� �ε���)
			for(int j=0; j<lottoS.length; j++ ) {
				if(lotto[i] == lottoS[j]) {
					count++;
					if(j == lottoS.length -1) {
						// lotto �迭�� i��° �����Ϳ� lottoS �迭�� j��° �����Ͱ� �����ϰ�
						// j�� ���� lottoS �迭�� ������ ��ġ�� ��� ����
						bBonus = true;
					}
				}
			}
		}
		switch(count) {
		case 6: 
			// 2�� ? 1�� ?
			if(bBonus)	{ // bBonus(boolean) : true/false
				System.out.println("2�� ��÷�Դϴ�.");
			} else {	
				System.out.println("1�� ��÷�Դϴ�.");
			}
			break;
		case 5: 
			System.out.println("3�� ��÷�Դϴ�.");
			break;
		case 4:	
			System.out.println("4�� ��÷�Դϴ�.");
			break;
		case 3:
			System.out.println("5�� ��÷�Դϴ�.");
			break;
		default:
			System.out.println("��÷�� �ȵƽ��ϴ�.");
		}
		// ��÷ ���θ� ����� ��� : "1�� ��÷�Դϴ�."
		// 1��) 6�� ��ȣ ��ġ
		// 2��) 5�� ��ȣ ��ġ + ���ʽ� ��ȣ ��ġ
		// 3��) 5�� ��ȣ ��ġ
		// 4��) 4�� ��ȣ ��ġ
		// 5��) 3�� ��ȣ ��ġ
		
	}
	
	public void practice15() {
		System.out.print("���ڿ� : ");
		String str = sc.next();
		char[] arr = new char[str.length()];
		int count =0;
		System.out.print("���ڿ��� �ִ� ���� : ");
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
		System.out.println("���� ���� : " +count);
		
	}
	
	public void practice16() {
		System.out.print("�迭�� ũ�⸦ �Է��ϼ��� : ");
		int size = sc.nextInt();
		String[] str = new String[size];
		sc.nextLine();
		int count = 0;
		while(true) {	
			for(int i=count; i<str.length; i++) {
				System.out.print(i+1 +"��° ���ڿ� : ");
				str[i] = sc.nextLine();
			}
			count = str.length;
		
			System.out.print("�� ���� �Է��Ͻðڽ��ϱ�?(Y/N) : ");
			char ch = sc.nextLine().charAt(0);
			if(ch == 'y' || ch == 'Y') {
				System.out.print("�� �Է��ϰ� ���� ���� : ");
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
