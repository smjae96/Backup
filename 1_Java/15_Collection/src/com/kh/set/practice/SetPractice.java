package com.kh.set.practice;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class SetPractice {
	/*
	 * Set�� Ư¡
	 * : �ߺ� ����� �ȵǰ�, ������ ���� �÷���
	 * 
	 * *HashSet
	 * 	- �ؽ�(Hash) : Ư�� ���ؿ� ���� �����͸� �з��ϴ� ���(�˰���)
	 * 
	 * 	- �ߺ� ������ �Ǵ� : hashCode, equals
	 * 		(1) hashCode : ������ �Ǵ� ��(������)�� ����
	 * 		(2) equals   : hashCode ���� ���� ��� ���� ������ �Ǵ� ���� ����
	 * 
	 * 	- Set �޼ҵ�
	 * 		* ������ �߰� : add(E element)
	 * 		* ������ ���� : remove(Object o)	�ε����� �ƴ� ������ �����͸� �Ű������� ����.
	 * 		* ������ ���� ��ȸ : size()
	 * 		* ������ ��ȸ [2���� ���]
	 * 				(1) Iterator (�ݺ���) ���
	 * 					- ��ü ���� : set������.iterator()
	 * 					- ������ ��/�� �Ǵ� : iterator������.hasNext()
	 * 					- ������ ��ȸ : iterator������.next()
	 * 				(2) for-each��
	 * 					for(�ڷ��� ������ : set������) {
	 * 						// �������� ���� set �� �����ͷ� ����
	 * 					}
	 */
	
	public static void main(String[] args) {
		// Member ��ü �����͸� Set ������ ����
		Set<Member> set = new HashSet<>();
		
		// ������ �߰� => Member Ÿ���� ������ : �ν��Ͻ��� �����Ͽ� �����ϰų�, �ν��Ͻ��� ����Ű�� �������� ������.
		set.add(new Member(1000, "������"));		// �ν��Ͻ� �����ϸ鼭 ����.
		Member m1 = new Member(1001, "���ð�");
		set.add(m1);							// �ν��Ͻ��� ����Ű�� �������� ����.
		
		// ������ ��ȸ
		for(Member member : set) {
			System.out.println(member); 			// member => member.toString()�� ȣ��Ǿ� ��µ�.
		}
		System.out.println("*".repeat(20));
		
		// ������ ����
		set.remove(new Member(1001, "���ð�"));
		
		set.add(new Member(1001, "���Ѻ�"));		// �ߺ��̹Ƿ� �߰� �ȵ�. ������ �ڿ� �߰� �� �߰� ��.
		
		// ������ ��ȸ
		for(Member member : set) {
			System.out.println(member); 			// member => member.toString()�� ȣ��Ǿ� ��µ�.
		}
		
		HashMap<Integer, String> map = new HashMap<>();
		map.put(45, "ȫ�浿");
		map.put(23, "������");
		map.put(37, "��ƾ");
		
		Set<Integer> keySet = map.keySet();
//		for(Integer n : keySet) {
//			System.out.print(n + "\t");
//		}
//		System.out.println();
		Iterator<Integer> iterator = keySet.iterator();
//		while(iterator.hasNext()) {
//			System.out.print(iterator.next() + "\t");
//		}
		
//		for(Integer n : keySet) {
//			System.out.print(map.get(n) + "\t");	// map.get() :Ű�� �ش��ϴ� ��(value)
//		}
		System.out.println();
		while(iterator.hasNext()) {
			System.out.print(map.get(iterator.next()) + "\t");
		}
	}	
	
	
	public static void hashSetTest01() {
		// �����͸� Set ������ �����Ϸ��� HashSet Ŭ���� ��� => ��ü ����(�ν��Ͻ�ȭ)
		Set<String> set = new HashSet<>();
		
		// Set ������ �����͸� �߰�
		set.add("ISTP");
		set.add("ESFP");
		set.add("ISFJ");
		set.add("ISFP");
		
		set.add("INTJ");
		
		set.add("ESFP");	// �ߺ� ������!
		
		// Set�� ����� �����͸� ���
		System.out.println(set);		// ���������� ����Լ��� ������� �� [������, ������, ...] �������� ��µ�.
		
		// Iterator ����Ͽ� ���
		Iterator<String> iterator = set.iterator();		// (1) Iterator ��ü�� ����.
		//for(;iterator.hasNext();) {}					// (2) ���ǽ� ��ġ: ������ ��/�� �Ǵ�
		while(iterator.hasNext()) {
			String data = iterator.next();				// (3) ������ ��ȸ 
			System.out.println(data);
		}
		System.out.println("*".repeat(10));
		
		// ������ ���� : ISFP
		set.remove("ISFP");
		
		// for-each�� ����Ͽ� ���
		for(String data : set) {		// � �����͵��� �������� Ȯ�� �� �ڷ��� �ۼ�
			System.out.println(data);	// data => Set�� ����� ������ �ϳ��ϳ��� ������.
		}
	}
	
}
