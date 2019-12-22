package kr.p.eye.platform.member;

import java.time.LocalDateTime;

public class MemberRequest {
	
	private int memberNo;
	
	private String memberId;
	
	private String memberPw;
	
	private String memberPw2;
	
	private String memberName;
	

	private String memberGender;

	private String memberPhone;

	
	private String memberBirthday;
	
	private LocalDateTime memberCreateDate;

	public MemberRequest() {
		memberCreateDate = LocalDateTime.now();
	}

	public MemberRequest(int memberNo, String memberId, String memberPw, String memberPw2, String memberName,
			String memberGender, String memberPhone, String memberBirthday,
			LocalDateTime memberCreateDate) {
		this.memberNo = memberNo;
		this.memberId = memberId;
		this.memberPw = memberPw;
		this.memberPw2 = memberPw2;
		this.memberName = memberName;
		this.memberGender = memberGender;
		this.memberPhone = memberPhone;
		this.memberBirthday = memberBirthday;
		this.memberCreateDate = memberCreateDate;
	}

	public int getMemberNo() {
		return memberNo;
	}

	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getMemberPw() {
		return memberPw;
	}

	public void setMemberPw(String memberPw) {
		this.memberPw = memberPw;
	}

	public String getMemberPw2() {
		return memberPw2;
	}

	public void setMemberPw2(String memberPw2) {
		this.memberPw2 = memberPw2;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public String getMemberGender() {
		return memberGender;
	}

	public void setMemberGender(String memberGender) {
		this.memberGender = memberGender;
	}

	public String getMemberPhone() {
		return memberPhone;
	}

	public void setMemberPhone(String memberPhone) {
		this.memberPhone = memberPhone;
	}


	public String getMemberBirthday() {
		return memberBirthday;
	}

	public void setMemberBirthday(String memberBirthday) {
		this.memberBirthday = memberBirthday;
	}

	public LocalDateTime getMemberCreateDate() {
		return memberCreateDate;
	}

	public void setMemberCreatedDate(LocalDateTime memberCreateDate) {
		this.memberCreateDate = memberCreateDate;
	}

	@Override
	public String toString() {
		return "MemberRequest [memberNo=" + memberNo + ", memberId=" + memberId + ", memberPw=" + memberPw
				+ ", memberPw2=" + memberPw2 + ", memberName=" + memberName + ", memberGender=" + memberGender
				+ ", memberPhone=" + memberPhone + ", memberBirthday=" + memberBirthday
				+ ", memberCreateDate=" + memberCreateDate + "]";
	}

}
