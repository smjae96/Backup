package com.kh.set.practice;

import java.util.Objects;

public class Member {
	// �ʵ�
	// -memberId: int
	// -memberName: String
	
	private int memberId;
	private String memberName;
	
	// ������
	// +Member(memberId:int, memberName:String)
	public Member(int memberId, String memberName) {
		// �Ű������� �ִ� ��� ��� �ʱ�ȭ �۾��� ����
		this.memberId=memberId;
		this.memberName=memberName;
	}


	
	// �޼ҵ�
	// getter/setter	
	// +hashCode():int					// memberId�� ���ذ����� ����
	// +equals(obj:object):boolean		// ���� ��ü�� ���޵� ��ü�� memberId�� �����ϸ� true, �׷��� ������ false
	// +toString():String				// ���� ��ü�� �ʵ� ������ ���. ����: "[memberId] memberName"
	
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
		// memberName�� ���ذ��̶�� return memberName.hashCode();
		// ���� �����Ͱ� �ƴ� ���� .hashCode() �޼ҵ带 ���� �ؽð��� ��ȯ.
	}



	@Override
	public boolean equals(Object obj) {
		// ���޵� ��ü�� Member Ÿ������ Ȯ�� : instanceof
		if(obj instanceof Member) {	// �߻� ������ ���ܸ� ó���ϱ� ���� ���.
			// ���޵� ��ü�� ���� ��ü�� memberId ���� ���� ��� true ��ȯ(����)
			if(this.memberId == ((Member)obj).getMemberId()) {
				return true;
			}
		}
		// ���޵� ��ü�� ���� ��ü�� memberId ���� �ٸ��ų�,
		// ���޵� ��ü�� Member Ÿ���� �ƴ� ��� false ��ȯ(����)
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
