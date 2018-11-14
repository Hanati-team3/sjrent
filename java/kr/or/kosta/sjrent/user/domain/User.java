package kr.or.kosta.sjrent.user.domain;

import java.util.Date;

public class User {
	// 유저 sequence
	private int seq;
	// 유저 아이디
	private String id;
	// 유저 이름
	private String name;
	// 유저 이메일
	private String email;
	// 유저 비밀번호
	private String password;
	// 유저 생일
	private String birthday;
	// 유저 성별
	private int gender;
	// 유저 포인트
	private int point;
	// 유저 전화번호
	private String cellphone;
	// 유저 유저 여부(0 false 비회원, 1 true 회원)
	private int isUser;
	// 유저 등록 날짜
	private String regdate;
	
	
	public User() {
		super();
	}


	public int getSeq() {
		return seq;
	}


	public void setSeq(int seq) {
		this.seq = seq;
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getBirthday() {
		return birthday;
	}


	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}


	public int getGender() {
		return gender;
	}


	public void setGender(int gender) {
		this.gender = gender;
	}


	public int getPoint() {
		return point;
	}


	public void setPoint(int point) {
		this.point = point;
	}


	public String getCellphone() {
		return cellphone;
	}


	public void setCellphone(String cellphone) {
		this.cellphone = cellphone;
	}


	public int getIsUser() {
		return isUser;
	}


	public void setIsUser(int isUser) {
		this.isUser = isUser;
	}


	public String getRegdate() {
		return regdate;
	}


	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}


	@Override
	public String toString() {
		return "User [seq=" + seq + ", id=" + id + ", name=" + name + ", email=" + email + ", password="
				+ password + ", birthday=" + birthday + ", gender=" + gender + ", point=" + point + ", cellphone="
				+ cellphone + ", isUser=" + isUser + ", regdate=" + regdate + "]";
	}

	
}
