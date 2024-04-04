package com.kh.set.practice;

import java.util.Objects;

public class Member {
	// 필드
	// -memberId: int
	// -memberName: String
	
	private int memberId;
	private String memberName;
	
	// 생성자
	// +Member(memberId:int, memberName:String)
	public Member(int memberId, String memberName) {
		// 매개변수가 있는 경우 대게 초기화 작업을 수행
		this.memberId=memberId;
		this.memberName=memberName;
	}


	
	// 메소드
	// getter/setter	
	// +hashCode():int					// memberId를 기준값으로 정의
	// +equals(obj:object):boolean		// 현재 객체와 전달된 객체의 memberId가 동일하면 true, 그렇지 않으면 false
	// +toString():String				// 현재 객체의 필드 정보를 출력. 포맷: "[memberId] memberName"
	
	public int getMemberId() {
		return memberId;
	}

	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	
	@Override
	public int hashCode() {
		return memberId;
		// memberName이 기준값이라면 return memberName.hashCode();
		// 정수 데이터가 아닌 경우는 .hashCode() 메소드를 통해 해시값을 반환.
	}



	@Override
	public boolean equals(Object obj) {
		// 전달된 객체가 Member 타입인지 확인 : instanceof
		if(obj instanceof Member) {	// 발생 가능한 예외를 처리하기 위해 사용.
			// 전달된 객체와 현재 객체의 memberId 값이 같은 경우 true 반환(리턴)
			if(this.memberId == ((Member)obj).getMemberId()) {
				return true;
			}
		}
		// 전달된 객체와 현재 객체의 memberId 값이 다르거나,
		// 전달된 객체가 Member 타입이 아닌 경우 false 반환(리턴)
		return false;
//		if (this.memberId == ((Member)obj).memberId) {
//			return true;
//		} else {
//			return false;
//		}

	}
	
	@Override
	public String toString() {
		return "[" + memberId+ "] " + memberName;
	}
	
}
