package com.kh.practice;

public class StringTest {

	public static void main(String[] args) {
		
		
		// ���ڿ�(String) ���� �޼ҵ�
		// - String.format("���ڿ� ����, ���þ�(%)", ����1, ����2, ...); // ���˿� �°� ���ڿ� ��ȯ
		// - ���ڿ�.charAt(index)			// ���ڿ����� index ��ġ�� ���� ��ȯ
		// - ���ڿ�.length()				// ���ڿ� ����..
		// - ���ڿ�.equals(���ڿ�A)			// ���ڿ��� ���ڿ�A�� ������ ��
		
		String str = "Hello";
		
		System.out.println(str.charAt(0));
		System.out.println(str.indexOf("e")); // indexOf()�޼ҵ��� �Ű����� �ڸ��� ���� ���� or ���ڿ��� ��� ° ��ġ���� ó�� �������� Ȯ��
		System.out.println(str.contains("He"));	// contains()�޼ҵ��� �Ű����� �ڸ��� ���� ���ڿ��� ����ִ��� ������ true/false
		System.out.println(str.substring(0, 3)); // �ش� ���ڿ��� 0��° ���ں��� (3-1)��° ���ڱ��� ���
		System.out.println(str.replace("l", "p")); // �ش� ���ڿ��� ��� �ִ� ���ڿ��� ���Ƿ� �����ؼ�, �ٸ� ���ڿ��� ����.
		String[] strArr = str.split("l",2);
		System.out.println(strArr[0]);	// regex : ����(l) l�� �������� ������ ���� 2¥�� ���ڿ� �迭��.
		System.out.println(str.trim()); 	// trim() : ���� ����
	}
	
	
	
	public void test2() {
		// String Ŭ���� : ���ڿ� ���� ������ �ʴ´�. ( => ���� ����Ǹ� �޸𸮿� ���ο� ���� �Ҵ�)
		
		
		String str1 = "apple";
		String str2 = "apple";
		
		// str1 == str2 : ���ڿ� ���� ���ϴ� �� �ƴ϶�, str1�� str2�� ������ �ּҰ��� ��
		System.out.println(str1 == str2); 		// ���? true
												// ���ڿ� �� ��ü�� �����ϸ� ���Ǯ�̶�� ������ ���� ����Ǿ�
												// ���� ���� ����Ű�� ��(�ּҰ��� ����)
		
		System.out.println(str1 == "apple");	// ���? true
												// str1�� ����Ű�� �ּҿ� "apple" �� ��ü�� ����� �ּҸ� ��
												// str1, "apple" ��� ���Ǯ�� ���� ���� ����Ǿ� �־� true (�ּҰ��� ����)		
		
		String str3 = new String("apple");
		String str4 = new String("apple");
		System.out.println(str3 == str4); 		// ���? false
												// ���ڿ� ��ü�� �����ؼ� ���� �����ϸ� �޸𸮿� ���ο� ������ �Ҵ��ϹǷ�
												// ���� �Ҵ�� ������ ����Ű�Ե� (�ּҰ��� �ٸ�)
		
		System.out.println(str3 == "apple");	// ���? false	
												// str3�� ����Ű�� �ּҿ� "apple" �� ��ü�� ����� �ּҸ� ��
												// str3�� ���ο� �޸� ���� �Ҵ� �� "apple" ���� ����
												// "apple" �� ��ü�� ���Ǯ�� ������ �Ǿ� ���� �ٸ� ���� ����Ŵ(�ּҰ��� �ٸ�)
		
		// (���ڿ� ������ ��).equals(���ڿ� ������ ��) => true/false : true(����), false(�ٸ�)
		System.out.println(str3.equals("apple"));	// ���? true
													// .equals() �޼ҵ带 ����Ͽ� �� ��ü�� ��
		
		System.out.println("======================================");
		
		String str5 = "Hello";
		String str6 = "World";
		System.out.println(str5);			// ���ڿ� ���� ���: Hello
											// ����Լ��� ��üŸ���� ���� �Է� �� => ����.toString()
		System.out.println(str5.toString());		// String Ŭ�������� toString �޼ҵ尡 �������̵���.
		
		// System.idntityHashCode: System Ŭ���� �� �ؽ���(�ּҰ�)�� Ȯ���ϴ� �޼ҵ�
		int hash = System.identityHashCode(str5);	// str5 ������ �ؽ���(�ּҰ�)
		System.out.println("���� �� str5 : " + hash);
		
		// �պκп� ��ġ�� ���ڿ�.concat(�ڿ� ���� ���ڿ�) : String Ŭ���� �� ���ڿ��� �����ִ�(�����ִ�) �޼ҵ�
		//											��� ������ ���ڿ����� ���ļ� ��ȯ
		str5 = str5.concat(str6);			// "HelloWorld"
		
		System.out.println(str5);
		int hash2 = System.identityHashCode(str5);
		System.out.println(str5.hashCode());
		System.out.println("���� �� str5 : " + hash2);	
	}

	

}
