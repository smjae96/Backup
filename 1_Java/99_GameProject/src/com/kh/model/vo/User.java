package com.kh.model.vo;

// 사용자 객체(User) 
public class User {
	private String nickName;		// 닉네임
	private int score;				// 점수
	
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
	public String toString() {	// 필드 정보를 문자열로 반환하도록 오버라이딩
		return String.format("%s님의 점수는 %d점입니다." , nickName, score);
	}
}
