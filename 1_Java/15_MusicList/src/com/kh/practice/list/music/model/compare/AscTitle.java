package com.kh.practice.list.music.model.compare;

import java.util.Comparator;

import com.kh.practice.list.music.model.vo.Music;

// ����Ʈ ���� ���� Ŭ����
//	[1] Comparator �������̽� ���� ����
//	[2] compare �޼ҵ带 ������
public class AscTitle implements Comparator{
	// �������̵� �ڵ� �ϼ� ����Ű : Alt + Shift + S / V
	@Override
	public int compare(Object o1, Object o2) {
		// Object o1 = new Music();
		
		// ((Music)o1).getTitle()

		return ((Music)o2).getTitle().compareTo(((Music)o1).getTitle());
				
		
		

		//  Title�� ������������ ����
		//	����/�Ǽ�
		//	* �������� : o1- o2
		//	* �������� : o2 - o1
		
		//	���ڿ��� ��� : 
		//	* �������� : o1.getTitle().compareTo(o2.getTitle())
		//	* �������� : o2.getTitle().compareTo(o1.getTitle())
	}

}
