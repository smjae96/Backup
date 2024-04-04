package com.kh.condition;

/*
 * ���ǹ� switch
 *  - ����� �� ���� ���
 *  
 *  - ǥ����
 *  
 *  		switch(���ǽ�-�񱳴��) {
 *  			case ��1: 
 *  				// �񱳴�� == ��1�� ��� ������ �ڵ�
 *  				break;
 *  			case ��2:
 *  				// �񱳴�� == ��2�� ��� ������ �ڵ�
 *  				break;
 *  			default: 
 *  				// ���� case�� ������ ��� �ش���� �ʴ� ��� ������ �ڵ�
 *  				// ���� ����.
 *  		}
 */
public class B_Switch {

	public static void main(String[] args) {
		
		// month ���� ���� ǥ��
		// 	- �ܿ�: 12, 1, 2
		//	- ��: 3, 4, 5
		// 	- ����: 6, 7, 8
		// 	- ����: 9, 10, 11
		int month = 12;
		
		
		switch(month) {
		case 12, 1, 2:
			System.out.println("�ܿ�");
			break;
		case 3, 4, 5:
			System.out.println("��");
			break;
		case 6, 7, 8:
			System.out.println("����");
			break;
		case 9, 10, 11:
			System.out.println("����");
			break;
			default:
			System.out.println("���� ������ �� �� ����.");
		}
	}

}
