package com.kh.map.practice;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

import com.kh.set.practice.Member;
// HashMap ������ Member ��ü �����͸� �����ϱ� ���� Ŭ����
public class MemberHashMap {
	// �ʵ�
	// -hashMap : HashMap<Integer,Member>
	private HashMap<Integer,Member> hashMap;
	// ������
	// +MemberHashMap()	// hashMap �ʵ带 �ʱ�ȭ(�ν��Ͻ� ����)
	public MemberHashMap() {
		hashMap = new HashMap<>();
	}
	// �޼ҵ�
	// +addMember(member:Member) : void			// HashMap�� ������ �߰�(k: memberId, v: Member)
	// +removeMember(memberId:int): boolean		// ���� ���� : true, ����: false(���ŵ� ���� ���� ���)
	// 											// �ش� �����Ͱ� �ִ� �� Ȯ�� �� ������ ����. ������ ����x		
	// +showAllMember() : void					// Iterator ����Ͽ� ����� �����͸� ���
	
	public void addMember(Member member) {
		// ���޵� Member ��ü�� ���� �� memberId ���� Ű�� ���, �����ʹ� member ��ü ���� �� ��ü�� ���.
		hashMap.put(member.getMemberId(), member);
	}
	
	public boolean removeMember(int memberId) {
		// memberId : Map ���� Ű(key)������ ����.
		if(hashMap.containsKey(memberId)) {		// containsKey(Ű��) : Map ���� Ű���� �ش��ϴ� �����Ͱ� �ִ� �� ����.
			hashMap.remove(memberId);
			return true;
		}
		return false;
		
//		if(hashMap.remove(memberId) != null) {
//			hashMap.remove(memberId);
//			return true;
//		} else {
//			return false;
//		}
	}
	
	public void showAllMember() {
		// (1) Iterator ��ü ����
		Set<Integer> set = hashMap.keySet();
		Iterator<Integer> iterator = set.iterator();
		//Iterator<Integer> iterator = hashMap.keySet().iterator();
		
		// (2) �ݺ��� �����鼭, ������ ��/�� üũ�ϰ� ��ȸ
		while(iterator.hasNext()) {
//			Integer key = iterator.next();		// Ű ���� ��ȸ
//			Member m = hashMap.get(key);		// Ű ���� �������� Map���� ������ ��ȸ
//			System.out.println(m);				// �ش� Member �����͸� ���
			System.out.println(hashMap.get(iterator.next()));
		}
	}
}
