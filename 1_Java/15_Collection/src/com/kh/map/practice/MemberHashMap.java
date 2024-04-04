package com.kh.map.practice;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

import com.kh.set.practice.Member;
// HashMap 구조로 Member 객체 데이터를 관리하기 위한 클래스
public class MemberHashMap {
	// 필드
	// -hashMap : HashMap<Integer,Member>
	private HashMap<Integer,Member> hashMap;
	// 생성자
	// +MemberHashMap()	// hashMap 필드를 초기화(인스턴스 생성)
	public MemberHashMap() {
		hashMap = new HashMap<>();
	}
	// 메소드
	// +addMember(member:Member) : void			// HashMap에 데이터 추가(k: memberId, v: Member)
	// +removeMember(memberId:int): boolean		// 제거 성공 : true, 실패: false(제거된 것이 없는 경우)
	// 											// 해당 데이터가 있는 지 확인 후 있으면 제거. 없으면 제거x		
	// +showAllMember() : void					// Iterator 사용하여 저장된 데이터를 출력
	
	public void addMember(Member member) {
		// 전달된 Member 객체의 정보 중 memberId 값을 키로 사용, 데이터는 member 객체 정보 그 자체를 사용.
		hashMap.put(member.getMemberId(), member);
	}
	
	public boolean removeMember(int memberId) {
		// memberId : Map 에서 키(key)값으로 사용됨.
		if(hashMap.containsKey(memberId)) {		// containsKey(키값) : Map 내에 키값에 해당하는 데이터가 있는 지 여부.
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
		// (1) Iterator 객체 생성
		Set<Integer> set = hashMap.keySet();
		Iterator<Integer> iterator = set.iterator();
		//Iterator<Integer> iterator = hashMap.keySet().iterator();
		
		// (2) 반복문 돌리면서, 데이터 유/무 체크하고 조회
		while(iterator.hasNext()) {
//			Integer key = iterator.next();		// 키 값을 조회
//			Member m = hashMap.get(key);		// 키 값을 기준으로 Map에서 데이터 조회
//			System.out.println(m);				// 해당 Member 데이터를 출력
			System.out.println(hashMap.get(iterator.next()));
		}
	}
}
