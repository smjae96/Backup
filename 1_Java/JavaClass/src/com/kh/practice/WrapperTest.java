package com.kh.practice;

public class WrapperTest {
	
	
	// Wrapper class : �⺻�ڷ����� ��üȭ�� Ŭ����
	//	- �⺻�ڷ��� : byte, short, int, long, double, char, boolean
	//	- Wrapper C: Byte, Short, Integer, Long, Double, Character, Boolean
	
	// * ���ڿ��� �� �ڷ����� ������ ��ȯ ex) "10" -> 10
	// 	 - ������ �ڷ������� ���� : Integer.parseInt("10"); // 10
	//	 - �Ǽ��� �ڷ������� ���� : Double.parseDouble("3.14"); // 3.14
	
	public static void main(String[] args) {
		
		// �⺻�ڷ��� �� => ���ڿ� ��
		//	ex) 1000 ���� ���ڿ��� ���� (wrapper class ���)
		System.out.println(Integer.valueOf(1000).toString() + 10);
		
		// ex) float Ÿ���� 0.59 ���� ���ڿ��� ����
		String result;
		float a = 0.59f;
		System.out.println(Float.toString(a));
		result = Float.valueOf(0.59f).toString();
		System.out.println(result + 0.1);
		
		// ex) long Ÿ���� 6789 ���� ���ڿ��� ���� => 6789l�� �Է����� �ʾƵ� �ڵ�����ȯ �Ǿ� ������ ���� �� ��.
		System.out.println(Long.valueOf(6789l).toString() +100L);
		
	}
	
	public void parseTest() {
		String ten = "10";
		System.out.println("10" +1);			// ���ڿ� + ���� => ���ڿ� "10" + 1 => "10" + "1" => "101"
		System.out.println(Integer.parseInt("10") +1);	// ���ڿ��� ������ ��ȯ + ���� => ����
		
		System.out.println(Double.parseDouble(ten));	// 10�̶�� ���� �Ǽ������� �ڵ�����ȯ�Ǿ� 10.0 �� ��µ�.
		
//		System.out.println(Integer.parseInt("10.0"));	// �Ǽ��� ���� ������ ������ ��ȯ�Ϸ� �ؼ� ������ �߻�
														// �������� �ƴ� �ٸ� �ڷ��� ���� �͵� ���������� ���� �߻�
	
//		System.out.println(Integer.parseInt("a"));		// �����ϳ��� �Է��ص� ���ڿ��̹Ƿ� ���������� ��ȯ���� ����
		
		System.out.println(Boolean.parseBoolean("true") ? "��" : "����"); // ��
		// ���ڿ� (String) -> ������ (char) : .charAt(index)
		System.out.println("A".charAt(0));
	}
}
