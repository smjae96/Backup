package com.kh.map.practice;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import com.kh.set.practice.Member;

public class MapPractice {
	/*
	 *  Map<K, V>�� Ư¡
	 *  : Key-Value �������� �����͸� ����.
	 *    Key�� �ش��ϴ� �����ʹ� �ߺ� ������ ����. (Set ���)
	 *    Value�� �ش��ϴ� �����ʹ� Key���� �ߺ����� ������ �ߺ��� ��� (List ���)
	 *    
	 * - �޼ҵ�
	 * 	 (1) ������ �߰� : put(K key, V value) - �Ű������� (Ű�� �ش��ϴ� ��, �����Ϳ� �ش��ϴ� ��)
	 * 	 (2) ������ ���� : remove(Object key) - �Ű������� (Ű�� �ش��ϴ� ��)
	 * 	 (3) ������ ��ȸ : get(Object key) - �Ű������� (Ű�� �ش��ϴ� ��)
	 * 	 (4) Ű ��� ��ȸ : keySet() - ��� Ű�� Set ��ü�� ��Ƽ� ����, ����Ÿ���� Set<K>
	 * 	 (5) ������ ���� ��ȸ : size()
	 */
	public static void main(String[] args) {
		MemberHashMap mhm = new MemberHashMap();
		mhm.addMember(new Member(1000, "ȫ�浿"));		// �޼ҵ� ȣ�� �� Member �ν��Ͻ��� �����ؾ� ��.
		mhm.addMember(new Member(2000, "�ƹ���"));
		mhm.addMember(new Member(3000, "������"));
		
		mhm.showAllMember();
		
		mhm.removeMember(2000);
		
		System.out.println("*".repeat(20));
		
		mhm.showAllMember();
		
	}
	
	public static void hashMapTest() {	
		// HashMap �ݷ����� ����Ͽ� �����͸� ó��	=> �ν��Ͻ� ����
		//	Key : ������ ������, Value : ���ڿ� ������
		Map<Integer,String> map = new HashMap<>();
		
		// Map ������ ������ �߰� : put(key, value)
		map.put(3000, "SSG");	// ��õ
		map.put(3001, "Ű��");	// ����
		map.put(3002, "�Ե�");	// �λ�
		
		// Ű ��� ��ȸ �� Map�� ����� �����͸� ���
		Set<Integer> keyList = map.keySet();
		
		for(Integer k : keyList) {	// keyList(Ű ���)���� k(Ű ��)��� ���� �ϳ��� ���
			// ������ ��ȸ
			System.out.println(k + ":" + map.get(k));
		}
		
		// "Ű��" �����͸� ����
		map.remove(3001);
		
		System.out.println("*".repeat(20));
		keyList = map.keySet();
		Iterator<Integer> iterator = keyList.iterator();
		while(iterator.hasNext()) {
			Integer key = iterator.next();
			System.out.println(key + ": " +map.get(key));		// iterator.next() : Ű ���� �ϳ��� ��ȸ
																// map.get(key) : key �� �������� map���� ������ ��ȸ
		}
		//
		
	}

}
