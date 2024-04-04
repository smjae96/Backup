package exception;

import java.util.Scanner;

public class Exception1 {
	private static Scanner sc = new Scanner(System.in);


	
	public static void main(String[] args)  {
		// 		arrayTest();
	
		try {
			arrayTest();	// ���� �߻� ��ġ!
		} catch(ArrayIndexOutOfBoundsException e) {	//�ε��� ���� ���ܸ� �����ϰڴ�.
			System.out.println("�߸� �Է��߽��ϴ�. �ε��� ��������");
		} catch(NegativeArraySizeException e) {
			System.out.println("������ �ԷµǾ� ���� �߻�!");
		}
		catch(Exception e) {	// �ε��� ���� ���� �ٸ� ���� �߻��� ���⼭ ����.
			System.out.println("�߸� �Է��߽��ϴ�.");
			System.out.println(e);
		} finally {
			System.out.println("���α׷� ����");
		}
	
	}
	
	public static void arrayTest() throws Exception{
		arrayTest2();
	}
	public static void arrayTest2() throws Exception{	// throws Ű���� ����Ͽ� ���ܸ� ���� (���� ó��x)
		System.out.print("���� �Է��ϼ���: ");
		int length = sc.nextInt();
		// ����ڿ��� �Է¹��� ũ�⸸ŭ ������ �迭 ����
		// �ݺ������� �ε��� ���� ����
		// try ~catch�� ���
		// ArrayIndexOutOfBoundsException �߻� ��
		//				"�߸� �Է��߽��ϴ�." ���
		// Exception �߻� �� " �߸� �Է��߽��ϴ�" ���
		// �������� �� �Է� �� �迭 ����
		
//		try {
		int[] arr = new int[length]; // ����ڿ��� �Է¹��� ũ��(length)��ŭ ������ �迭 ����
		for(int i=0; i<=arr.length; i++) {
			arr[i] = i;	// �ݺ����� ���� �ε��� ���� �迭�� ����
			System.out.println(arr[i] + " ");
		}
		
			// catch���� �ۼ��ϴ� ���ܴ� ������ �� ���� ����, �Ʒ����� �� ���� ������ ���ܰ� �ǵ��� �ۼ�.	
//		} catch(ArrayIndexOutOfBoundsException e) {	//�ε��� ���� ���ܸ� �����ϰڴ�.
//			System.out.println("�߸� �Է��߽��ϴ�. �ε��� ��������");
//		} catch(NegativeArraySizeException e) {
//			System.out.println("������ �ԷµǾ� ���� �߻�!");
//		}
//		catch(Exception e) {	// �ε��� ���� ���� �ٸ� ���� �߻��� ���⼭ ������.
//			System.out.println("�߸� �Է��߽��ϴ�.");
//			System.out.println(e);
//		}
//		finally {}
	}

	
}
