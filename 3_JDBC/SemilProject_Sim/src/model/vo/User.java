package model.vo;

import java.sql.Date;

public class User {

	private int userNo;
	private String userId;
	private String userPw;
	private String userName;
	private String nickName;
	private String email;
	private String phone;
	private String ssn;
	private String address;
	private String interest;
	private Date enrollDate;
	
	
	public User() {
		
	}
	
	public User(String userId, String userPw, String nickName, String phone, String email, String address,
			String interest) {
		super();
		this.userId = userId;
		this.userPw = userPw;
		this.nickName = nickName;
		this.phone = phone;
		this.email = email;
		this.address = address;
		this.interest = interest;
	}

	public User(int userNo, String userId, String userPw, String userName, String nickName, String email, String phone,
			String ssn, String address, String interest, Date enrollDate) {
		super();
		this.userNo = userNo;
		this.userId = userId;
		this.userPw = userPw;
		this.userName = userName;
		this.nickName = nickName;
		this.email = email;
		this.phone = phone;
		this.ssn = ssn;
		this.address = address;
		this.interest = interest;
		this.enrollDate = enrollDate;
	}
	

	public User(String userId, String userPw, String userName, String nickName, String email, String phone, String ssn,
			String address, String interest) {
		super();
		this.userId = userId;
		this.userPw = userPw;
		this.userName = userName;
		this.nickName = nickName;
		this.email = email;
		this.phone = phone;
		this.ssn = ssn;
		this.address = address;
		this.interest = interest;
	}

	public int getUserNo() {
		return userNo;
	}

	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserPw() {
		return userPw;
	}

	public void setUserPw(String userPw) {
		this.userPw = userPw;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getSsn() {
		return ssn;
	}

	public void setSsn(String ssn) {
		this.ssn = ssn;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getInterest() {
		return interest;
	}

	public void setInterest(String interest) {
		this.interest = interest;
	}

	public Date getEnrollDate() {
		return enrollDate;
	}

	public void setEnrollDate(Date enrollDate) {
		this.enrollDate = enrollDate;
	}

	@Override
	public String toString() {
		return "Users [userNo=" + userNo + ", userId=" + userId + ", userPw=" + userPw + ", userName=" + userName
				+ ", nickName=" + nickName + ", email=" + email + ", phone=" + phone + ", ssn=" + ssn + ", address="
				+ address + ", interest=" + interest + ", enrollDate=" + enrollDate + "]";
	}
	
	
	
	
}
