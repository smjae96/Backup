package controller;



import model.vo.User;
import service.MemberService;
import view.LoginMenu;


public class UserController {

	public void signUp(String userId, String userPw, String userName, String nickName, String email, String phone, String ssn, String address, String interest) {
		User u = new User(userId, userPw, userName, nickName, email, phone, ssn, address, interest);
		
		int result = new MemberService().insertMember(u);
		
		if (result > 0) {	// 회원 추가 성공
			System.out.println(u.getUserName() + "님이 회원 가입에 성공했습니다!");
		} else {			// 회원 추가 실패
			System.out.println(u.getUserName() + "님이 회원 가입에 실패했습니다!!");
		}
	}
	
	public String checkId(String userId) {
		User u = new MemberService().searchId(userId);
		if(u == null) {
			return "";
		} else {
		return u.getUserId();
		} 
	}
	
	public String checkPw(String userId) {
		User u = new MemberService().searchId(userId);
		if(u == null) {
			return "";
		} else {
		return u.getUserPw();
		} 
	}
	
	
	public String checkNickName(String userId) {
		User u = new MemberService().searchId(userId);
		if(u == null) {
			return "";
		} else {
		return u.getNickName();
		} 
	}
	
	public void foundId(String userName, String phone) {
		User u = new MemberService().foundId(userName, phone);
		
		if (u != null) {
			System.out.println("\n"+userName + "님의 아이디는 " + u.getUserId() + "입니다!");
		} else {
			System.out.println("입력하신 회원 정보와 일치하는 아이디가 없습니다!");
		}
	}
	
	public void foundPw(String userId, String email, String ssn) {
		User u = new MemberService().foundPw(userId, email, ssn);
		
		if (u != null) {
			System.out.println("\n"+userId + "님의 이메일로 임시 비밀번호를 발급해드렸습니다. 발급 받으신 임시 비밀번호로 로그인 후 회원 정보 변경을 통해"
					+ "새로운 비밀번호로 변경해 주세요!");
			u.setUserPw(Math.random()*9999 + "@1234");
		} else {
			System.out.println("입력하신 회원 정보와 일치하는 비밀번호가 없습니다!");
		}
	}
	
	
	public void updateMember(String userId, String newPw, String nickName, String phone, String email, String address, String interest) {
		User u = new User(userId, newPw, nickName, phone, email, address, interest);

		int result = new MemberService().updateMember(u);
		
		if (result > 0) {	// 회원 정보 변경 성공
			System.out.println(u.getUserId() + "님의 회원 정보 변경에 성공했습니다.");
		} else {			// 회원 정보 변경 실패
			System.out.println(u.getUserId() + "님의 회원 정보 변경에 실패했습니다.");
		}
	}
	
	public void deleteMember(String userId, String userPw) {
		User u = new User();
		u.setUserId(userId);
		u.setUserPw(userPw);
		int result = new MemberService().deleteMember(u);
		
		if (result > 0) {	// 회원 탈퇴 성공
			System.out.println(u.getUserId() + "님의 회원 탈퇴에 성공했습니다.");
		} else {			// 회원 탈퇴 실패
			System.out.println(u.getUserId() + "님의 회원 탈퇴에 실패했습니다.");
		}	
	}
}
