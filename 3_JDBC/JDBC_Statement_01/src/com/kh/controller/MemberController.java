package com.kh.controller;

import java.util.ArrayList;

import com.kh.model.dao.MemberDao;
import com.kh.model.vo.Member;
import com.kh.view.MemberMenu;

/*
 *  Controller : View를 통해서 사용자가 요청한 기능을 처리하는 담당
 *  			해당 메소드로 전달된 데이터 가공 처리 후 DAO로 전달하여 호출
 *  			DAO로부터 반환받은 결과에 따라서 성공인지 실패인지 판단 후 응답화면 결정 (view 메소드 호출)
 */
public class MemberController {
	/**
	 * 회원 추가요청을 처리해주는 메소드
	 * 
	 * 전달받은 데이터들
	 * @param userId ~ hobby : 사용자가 입력했던 정보들이 담겨있는 매개변수
	 */
	public void insertMember(String userId, String userPw, String userName, String gender,
							int age, String email, String phone, String address, String hobby) {
		
		// view로부터 전달받은 값을 바로 dao쪽으로 전달 x
		// 어딘가(Member 객체(vo))에 담아서 전달
		
		// [1] 기본생성자로 생성하여 각 필드에 setter 메소드를 통해 하나하나 담는 방법
		// [2] 매개변수 생성자로 생성과 동시에 담는 방법
		Member m = new Member(userId, userPw, userName, gender, age, email, phone, address, hobby);
		
		/*
		 MemberDao md = new MemberDao();
		 md.insertMember(m);
		 */
		int result = new MemberDao().insertMember(m);
		
		if (result > 0) {	// 회원 추가 성공
			new MemberMenu().displaySuccess(m.getUserName() + "회원 추가에 성공했습니다.");
		} else {			// 회원 추가 실패
			new MemberMenu().displayFailed(m.getUserName() + "회원 추가에 실패했습니다.");
		}
	}
	
	/**
	 * 회원 전체 조회에 대한 기능을 처리해주는 메소드 
	 */
	public void selectAllList() {
		// list 객체에 회원 전체 목록을 담기
		ArrayList<Member> list = new MemberDao().selectAllList();
		
		// view 쪽에 결과를 전달하여 출력
		// list.size() > 0 : 목록을 출력
		// list.size() = 0 : "데이터가 업습니다." 출력
		// list.isEmpty() : 리스트가 비어있는 지 여부 메소드도 사용 가능!
		if (list.size() > 0 ) {		// 회원 목록 출력
			new MemberMenu().displayList(list);
		} else {					// 데이터가 없음. 해당 내용 출력
			new MemberMenu().displayNoData("조회된 회원 목록 없음");
		}
	}
	/**
	 * 사용자가 입력한 아이디로 회원 정보를 조회
	 * @param userId : 검색할 아이디
	 */
	public void searchId(String userId) {
		Member m = new MemberDao().searchId(userId);
		
		if (m != null) {
			new MemberMenu().displayId(m);
		} else {
			new MemberMenu().displayNoData(userId +"에 해당하는 회원이 없습니다.");
		}
	}
	
	public String checkId(String userId) {
		Member m = new MemberDao().searchId(userId);
		if(m == null) {
			return "";
		} else {
		return m.getUserId();
		} 
	}
	
	public String checkPw(String userId) {
		Member m = new MemberDao().searchId(userId);
		if(m == null) {
			return "";
		} else {
		return m.getUserPw();
		} 
	}
	
	public void searchByName(String userKeyWord) {
		ArrayList<Member> list = new MemberDao().searchByName(userKeyWord);
		
		if (list.isEmpty()) {
			new MemberMenu().displayNoData(userKeyWord + "에 해당하는 회원이 없습니다.");
		} else {
			new MemberMenu().displayList(list);
		}
	}
	/**
	 * 사용자가 입력한 회원ID 기준으로 회원 정보 수정
	 * @param userId ~ address : 회원ID 및 수정할 데이터
	 */
	public void updateMember(String userId, String newPw, String email, String phone, String address) {
		Member m = new Member(userId, newPw,  email, phone, address);
		/*
		 * Member m = new Member();
		 * 
		 * m.setUserId(userId);
		 * m.setUserPw(userPw);
		 * m.setEmail(email);
		 * m.setPhone(phone);
		 * m.setAddress(address);
		 */
		int result = new MemberDao().updateMember(m);
		
		if (result > 0) {	// 회원 정보 변경 성공
			new MemberMenu().displaySuccess(m.getUserId() + "님의 회원 정보 변경에 성공했습니다.");
		} else {			// 회원 정보 변경 실패
			new MemberMenu().displayFailed(m.getUserId() + "님의 회원 정보 변경에 실패했습니다.");
		}
	}
	
	public void deleteMember(String userId, String userPw) {
		Member m = new Member();
		m.setUserId(userId);
		m.setUserPw(userPw);
		int result = new MemberDao().deleteMember(m);
		
		if (result > 0) {	// 회원 탈퇴 성공
			new MemberMenu().displaySuccess(m.getUserId() + "님의 회원 탈퇴에 성공했습니다.");
		} else {			// 회원 탈퇴 실패
			new MemberMenu().displayFailed(m.getUserId() + "님의 회원 탈퇴에 실패했습니다.");
		}
	}
}
