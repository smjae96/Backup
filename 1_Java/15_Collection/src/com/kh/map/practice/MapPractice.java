package com.kh.map.practice;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import com.kh.set.practice.Member;

public class MapPractice {
	/*
	 *  Map<K, V>의 특징
	 *  : Key-Value 형식으로 데이터를 저장.
	 *    Key에 해당하는 데이터는 중복 허용되지 않음. (Set 방식)
	 *    Value에 해당하는 데이터는 Key값이 중복되지 않으면 중복이 허용 (List 방식)
	 *    
	 * - 메소드
	 * 	 (1) 데이터 추가 : put(K key, V value) - 매개변수로 (키에 해당하는 값, 데이터에 해당하는 값)
	 * 	 (2) 데이터 삭제 : remove(Object key) - 매개변수로 (키에 해당하는 값)
	 * 	 (3) 데이터 조회 : get(Object key) - 매개변수로 (키에 해당하는 값)
	 * 	 (4) 키 목록 조회 : keySet() - 모든 키를 Set 객체에 담아서 리턴, 리턴타입이 Set<K>
	 * 	 (5) 데이터 길이 조회 : size()
	 */
	public static void main(String[] args) {
		MemberHashMap mhm = new MemberHashMap();
		mhm.addMember(new Member(1000, "홍길동"));		// 메소드 호출 시 Member 인스턴스를 전달해야 함.
		mhm.addMember(new Member(2000, "아무개"));
		mhm.addMember(new Member(3000, "아이유"));
		
		mhm.showAllMember();
		
		mhm.removeMember(2000);
		
		System.out.println("*".repeat(20));
		
		mhm.showAllMember();
		
	}
	
	public static void hashMapTest() {	
		// HashMap 콜렉션을 사용하여 데이터를 처리	=> 인스턴스 생성
		//	Key : 정수형 데이터, Value : 문자열 데이터
		Map<Integer,String> map = new HashMap<>();
		
		// Map 구조에 데이터 추가 : put(key, value)
		map.put(3000, "SSG");	// 인천
		map.put(3001, "키움");	// 서울
		map.put(3002, "롯데");	// 부산
		
		// 키 목록 조회 후 Map에 저장된 데이터를 출력
		Set<Integer> keyList = map.keySet();
		
		for(Integer k : keyList) {	// keyList(키 목록)에서 k(키 값)라는 값을 하나씩 사용
			// 데이터 조회
			System.out.println(k + ":" + map.get(k));
		}
		
		// "키움" 데이터를 제거
		map.remove(3001);
		
		System.out.println("*".repeat(20));
		keyList = map.keySet();
		Iterator<Integer> iterator = keyList.iterator();
		while(iterator.hasNext()) {
			Integer key = iterator.next();
			System.out.println(key + ": " +map.get(key));		// iterator.next() : 키 값을 하나씩 조회
																// map.get(key) : key 값 기준으로 map에서 데이터 조회
		}
		//
		
	}

}
