package com.kh.model.vo;

// ����� ��ü(User) 
public class User {
	private String nickName;		// �г���
	private int score;				// ����
	
	public User(String nickName) {
		this.nickName = nickName;
	}
	
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	
	public int getScore() {
		return score;
	}
	
	public void setScore(int score) {
		this.score = score;
	}
	
	@Override
	public String toString() {	// �ʵ� ������ ���ڿ��� ��ȯ�ϵ��� �������̵�
		return String.format("%s���� ������ %d���Դϴ�." , nickName, score);
	}
}
