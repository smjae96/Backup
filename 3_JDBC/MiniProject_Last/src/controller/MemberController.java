package controller;



import model.service.MemberService;
import model.view.FoodMenu;
import model.view.MemberMenu;
import model.vo.Member;

public class MemberController {

	public void insertMember(String userId, String userPw, String userName, String gender, String ssn, int age, double height, double weight) {
		Member m = new Member(userId, userPw, userName, gender, ssn, age, height, weight);
		
		int result = new MemberService().insertMember(m);
		
		if (result > 0) {	// 회원 추가 성공
			new MemberMenu().displaySuccess(m.getUserName() + "회원 가입에 성공했습니다.");
		} else {			// 회원 추가 실패
			new MemberMenu().displayFailed(m.getUserName() + "회원 가입에 실패했습니다.");
		}
	}
	
	public String checkId(String userId) {
		Member m = new MemberService().searchId(userId);
		if(m == null) {
			return "";
		} else {
		return m.getUserId();
		} 
	}
	
	public String checkPw(String userId) {
		Member m = new MemberService().searchId(userId);
		if(m == null) {
			return "";
		} else {
		return m.getUserPw();
		} 
	}
	
	public void logIn() {
		FoodMenu.mainMenu();
		
		
	}
	
	public void deleteMember(String userId, String userPw) {
		Member m = new Member();
		m.setUserId(userId);
		m.setUserPw(userPw);
		int result = new MemberService().deleteMember(m);
		
		if (result > 0) {	// 회원 탈퇴 성공
			new MemberMenu().displaySuccess(m.getUserId() + "님의 회원 탈퇴에 성공했습니다.");
		} else {			// 회원 탈퇴 실패
			new MemberMenu().displayFailed(m.getUserId() + "님의 회원 탈퇴에 실패했습니다.");
		}
	}
}
