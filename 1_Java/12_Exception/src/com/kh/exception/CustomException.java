package com.kh.exception;

// ����� ���� ���� Ŭ����
//	- ���� Ŭ���� ���� : Exception (���)
//	[1] Exception Ŭ������ ��ӹ޴´�.
public class CustomException extends Exception{
	
	// [2] ������ : �Ű����� 1�� (���ڿ� Ÿ��) -> ���� ����
	public CustomException(String msg) {
		//�θ�Ŭ������ ������ ȣ��. ���޹��� ���� �θ�Ŭ���� �����ڿ��� ����.
		super(msg);
	}
	
}
