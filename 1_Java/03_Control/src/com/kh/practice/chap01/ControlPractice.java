package com.kh.practice.chap01;

import java.util.Scanner;

public class ControlPractice {
	Scanner sc = new Scanner(System.in);
	public void practice1() {
		//�Ʒ� ���ÿ� ���� �޴��� ����ϰ� �޴� ��ȣ�� ������ "OO�޴��Դϴ�."��,
		//���� ��ȣ�� ������ "���α׷��� ����˴ϴ�."�� ����ϼ���.
		
		/*
		 * ex.
		 * 1. �Է�
		 * 2. ����
		 * 3. ��ȸ
		 * 4. ����
		 * 7. ����
		 * �޴� ��ȣ�� �Է��ϼ��� : 3
		 * ��ȸ �޴��Դϴ�.
		 */
		
		Scanner sc = new Scanner(System.in);
		//�޴��� ȭ�鿡 ���
		System.out.println("1. �Է�");
		System.out.println("2. ����");
		System.out.println("3. ��ȸ");
		System.out.println("4. ����");
		System.out.println("7. ����");
		//"�޴� ��ȣ�� �Է��ϼ��� : " ȭ�鿡 ���
		System.out.print("�޴� ��ȣ�� �Է��ϼ��� : ");
		int menuNum = sc.nextInt();
		
		switch(menuNum) {
		case 1: 
			System.out.println("�Է� �޴��Դϴ�.");
			break;
		case 2:
			System.out.println("���� �޴��Դϴ�.");
			break;
		case 3:
			System.out.println("��ȸ �޴��Դϴ�.");
			break;
		case 4: 
			System.out.println("���� �޴��Դϴ�.");
			break;
		case 7:
			System.out.println("���� �޴��Դϴ�.");
			break;
		default:
			System.out.println("�ش� �޴��� �����ϴ�.");
		}
	}
	
	public void practice2() {
		//Ű����� ������ �Է� ���� ������ ����̸鼭 ¦���� ���� "¦����"�� ����ϰ�
		//¦���� �ƴϸ� "Ȧ����"�� ����ϼ���.
		//����� �ƴϸ� "����� �Է����ּ���."�� ����ϼ���.
		
		/*ex.
		 * ���ڸ� �� �� �Է��ϼ��� : -8
		 * ����� �Է����ּ���.
		 */
		Scanner sc = new Scanner(System.in);
		System.out.print("���ڸ� �� �� �Է��ϼ��� : ");
		int num = sc.nextInt();
		
		if(num>0) {
			if(num%2==0) {
				System.out.println("¦����");
			}
			else { 
				System.out.println("Ȧ����");
			}
		}
		else {
			System.out.println("����� �Է����ּ���.");
		}
	}
	
	public void practice3() {
		/*���� ���� ���� �� ������ ������ Ű����� �Է� �ް� �հ�� ����� ����ϰ�
		 * �հ�� ����� �̿��Ͽ� �հ� / ���հ� ó���ϴ� ����� �����ϼ���.
		 * (�հ� ���� : �� ������ ������ ���� 40�� �̻��̸鼭 ����� 60�� �̻��� ���)
		 * �հ� ���� ��� ���� �� ������ �հ�, ���, "�����մϴ�,�հ��Դϴ�!"�� ����ϰ�
		 * ���հ��� ��쿡�� "���հ��Դϴ�."�� ����ϼ���.
		 */
		
		Scanner sc = new Scanner(System.in);
		System.out.print("�������� : ");
		int scoreK = sc.nextInt();
		System.out.print("�������� : ");
		int scoreM = sc.nextInt();
		System.out.print("�������� : ");
		int scoreE = sc.nextInt();
		
		//����
		int total = scoreK + scoreM + scoreE;
		//���
		double average = (double)total/3;
		
		if(scoreK>=40 && scoreM>=40 && scoreE>=40) {
			if(average>=60) {
				System.out.println("���� : " +scoreK);
				System.out.println("���� : "+scoreM);
				System.out.println("���� : "+scoreE);
				System.out.println("�հ� : "+total);
				System.out.println("��� : "+average);
				System.out.println("�����մϴ�, �հ��Դϴ�!");
			}
			else {
				System.out.println("���հ��Դϴ�");
			}
		}
		else { 
			System.out.println("���հ��Դϴ�");
		}
	}
	
	public void practice4() {
		//���� �ڷ�(7pg)���� if������ �Ǿ��ִ� ��, ����, ����, �ܿ� ������ switch������ �ٲ㼭 ����ϼ���.
		
		System.out.print("1~12 ������ ���� �Է� : ");
		int month = sc.nextInt();
		String season;
		switch(month) {
		case 1,2,12 : 
			System.out.println(month+"���� �ܿ��Դϴ�.");
			break;
		case 3,4,5 :
			System.out.println(month+"���� ���Դϴ�.");
			break;
		case 6,7,8 :
			System.out.println(month+"���� �����Դϴ�.");
			break;
		case 9,10,11 :
			System.out.println(month+"���� �����Դϴ�.");
			break;
		default :
			System.out.println(month+"���� �߸� �Էµ� ���Դϴ�.");
		}
		
	}
	
	public void practice5() {
		/*
		 * - ���̵�: user1
		 * - ��й�ȣ: 1234qwer!!
		 * 
		 *  [���ڿ�].equals([���ڿ�])
		 */
		
		String id = "user1";
		String pw = "1234qwer!!";
		
		System.out.print("���̵�: ");
		String inputID = sc.nextLine();
		System.out.print("��й�ȣ: ");
		String inputPW = sc.nextLine();
		
//		if(id.equals("user01")) {
//			if(pw.equals("1234qwer!!")) {
//				System.out.println("�α��� ����");
//			}
//			else {
//				System.out.println("��й�ȣ�� Ʋ�Ƚ��ϴ�.");
//			}
//		}
//		else { 
//			System.out.println("���̵� Ʋ�Ƚ��ϴ�.");
//		}
		
		if(inputID.equals(id) // equals: inputID ���� id ���� ������ 
			&& inputPW.equals(pw)) {
			System.out.println("�α��� ����!");	
		} else if (!inputID.equals(id)) {
			// id: user01, inputId: qqqq | inputId.equals(id) => false
			//						!(inputId.equals(id)) -> !false -> true
			System.out.println("���̵� Ʋ�Ƚ��ϴ�.");
		} 
		else {
			System.out.println("��й�ȣ�� Ʋ�Ƚ��ϴ�.");
		}
	}	
		
//	
//		// (+) ��й�ȣ : �ּ� 6�ڸ� �̻�, �빮�� + �ҹ��� + Ư������
	/* ����ǥ����: String regExp
	 * 
	 */
	
	public void practice5a() {	
		System.out.print("�н����带 �Է��ϼ���: ");
		String inputPW = sc.next();
		String regExp = "^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$ %^&*-]).{6,}$";
		
		if(inputPW.length()>=6) {
			if(inputPW.matches(regExp)) {
				System.out.println("��й�ȣ�� �½��ϴ�.");
			}
			else {
				System.out.println("��й�ȣ�� ���� �빮��,�ҹ���,Ư������ �� �� �� ���� �ֽ��ϴ�.");
			}
		}
		else {
			System.out.println("��й�ȣ �ڸ� ���� Ʋ���ϴ�.");
		}
		
	}
	
	public void practice6() {
		System.out.print("������ Ȯ���ϰ��� �ϴ� ȸ�� ���: ");
		String grade = sc.nextLine();
		
		switch(grade) {
		case "������": 
			System.out.println("ȸ������, �Խñ� ���� �Խñ� �ۼ�, ��� �ۼ� �Խñ� ��ȸ");
			break;
		case "ȸ��" :
			System.out.println("�Խñ� �ۼ�, �Խñ� ��ȸ, ��� �ۼ�");
			break;
		case "��ȸ��" :
			System.out.println("�Խñ� ��ȸ");
			break;
		default :
			System.out.println("�߸� �Է��ϼ̽��ϴ�.");
		}
	}
	
	public void practice7() {
		System.out.print("Ű(m)�� �Է��� �ּ��� : ");
		double height = sc.nextDouble();
		System.out.print("������(kg)�� �Է��� �ּ��� : ");
		double weight = sc.nextDouble();
		
		double bmi = weight / (height*height);
		System.out.println("BMI ���� : " +bmi );
		
		
		if(bmi<18.5) {
			System.out.println("��ü��");
		}
		else if(18.5<=bmi && bmi<23) {
			System.out.println("����ü��");
		}
		else if(23<=bmi && bmi<25) {
			System.out.println("��ü��");
		}
		else if(25<=bmi && bmi<30) {
			System.out.println("��");
		}
		else if(bmi>=30) {
			System.out.println("�� ��");
		}
		else {
			System.out.println("���� �߸� �Է��ϼ̽��ϴ�.");
		}
	}
	
	public void practice8() {
		System.out.print("�ǿ�����1 �Է� : ");
		int num1 = sc.nextInt();
		System.out.print("�ǿ�����2 �Է� : ");
		int num2 = sc.nextInt();
		System.out.print("�����ڸ� �Է�(+,-,*,/,%) : ");
		String opr = sc.next();
		//����
		double opr1 = (double)(num1+num2);
		double opr2 = (double)(num1-num2);
		double opr3 = (double)num1*num2;
		double opr4 = (double)num1/num2;
		double opr5 = (double)num1%num2;
		
		
		if(num1>0 && num2>0) {
			switch(opr) {
				case "+": 
					System.out.printf("%d + %d = %.6f\n",num1,num2,opr1);
					break;
				case "-" :
					System.out.printf("%d - %d = %.6f\n",num1,num2,opr2);
					break;
				case "*" :
					System.out.printf("%d * %d = %.6f\n",num1,num2,opr3);
					break;
				case "/" :
					System.out.printf("%d / %d = %.6f\n",num1,num2,opr4);
					break;
				case "%" :
					System.out.printf("%d % %d = %.6f\n",num1,num2,opr5);
					break;
				default :
					System.out.println("�߸� �Է��ϼ̽��ϴ�. ���α׷��� �����մϴ�.");
			}
		} 
		else {
			System.out.println("�߸� �Է��ϼ̽��ϴ�. ���α׷��� �����մϴ�.");
		}
				
	}
	
	public void practice9() {
		System.out.print("�߰� ��� ���� : ");
		int midexam = sc.nextInt();
		System.out.print("�⸻ ��� ���� : ");
		int finalexam = sc.nextInt();
		System.out.print("���� ���� : ");
		int assignment = sc.nextInt();
		System.out.print("�⼮ ȸ�� : ");
		int attend = sc.nextInt();
		System.out.println("============���============");
		
		double me = midexam * 0.2;
		double fe = finalexam * 0.3;
		double as = assignment * 0.3;
		// �� ���� Ƚ�� 20ȸ
		int lectures = 20;
		// �⼮����
		double at = (double)attend/lectures*20; 
		
		//����
		double total = me+fe+as+at;
		
//		System.out.println("�߰� ��� ����(20) : " +me);
//		System.out.println("�⸻ ��� ����(30) : " +fe);
//		System.out.println("���� ����      (30) : " +as);
//		System.out.println("�⼮ ����      (20) : " +at);
//		System.out.println("���� : " +total);
		
		if(lectures == 20) {
			if(at<=lectures*0.7) {
				System.out.println("Fail [�⼮ ȸ�� ���� ("+attend+"/20)]");
			}
			else {
				System.out.println("�߰� ��� ����(20) : " +me);
				System.out.println("�⸻ ��� ����(30) : " +fe);
				System.out.println("���� ����      (30) : " +as);
				System.out.println("�⼮ ����      (20) : " +at);
				System.out.println("���� : " +total);
				if(total>=70) {

					System.out.println("PASS");
				}
				else {

					System.out.println("Fail [���� �̴�]");
				}
			}
		}
				
	}
	
	public void practice10() {
		System.out.println("������ ����� �����ϼ���.");
		System.out.println("1. �޴� ���");
		System.out.println("2. ¦��/Ȧ��");
		System.out.println("3. �հ�/���հ�");
		System.out.println("4. ����");
		System.out.println("5. �α���");
		System.out.println("6. ���� Ȯ��");
		System.out.println("7. BMI");
		System.out.println("8. ����");
		System.out.println("9. P/F");
		System.out.print("���� : ");

		int select = sc.nextInt();
		
		switch(select) {
			case 1: 
				practice1();
			break;
			case 2: 
				practice2();
			break;
			case 3: 
				practice3();
			break;
			case 4:
				practice4();
			break;
			case 5: 
				practice5();
			break;
			case 6: 
				practice6();
			break;
			case 7: 
				practice7();
			break;
			case 8: 
				practice8();
			break;
			case 9: 
				practice9();
			break;
			default: System.out.println("�߸� �Է��ϼ̽��ϴ�.");
		}
				
	}
	
	public void practice11() {
		System.out.print("��й�ȣ �Է�(1000~9999) : ");
		String pw = sc.next();
		char fNum = pw.charAt(0); 
		char sNum = pw.charAt(1);
		char tNum = pw.charAt(2);
		char frNum = pw.charAt(3);
				
		
		// 4�ڸ� ������ �Է� �޾� �� �ڸ� ���� �ߺ��Ǵ� ���� ���� ��� '���� ����' , �ߺ� ���� ������ '�ߺ� �� ����'
		// �ڸ����� �� ������ '�ڸ� �� �� ����' ���.
		if('1'<=fNum && fNum<='9') {
			if(pw.length()==4) {
				if(fNum!=sNum && fNum!=tNum && fNum!=frNum && sNum!=tNum && sNum!=frNum && tNum!=frNum) {
					System.out.println("���� ����");
				}
				else {
					System.out.println("�ߺ� �� ����");
				}
			}
			else {
				System.out.println("�ڸ� �� �� ����");
			}

		}
		else {
			System.out.println("����");
		}

	
	}
	
}
