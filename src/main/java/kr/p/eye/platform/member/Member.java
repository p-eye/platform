package kr.p.eye.platform.member;

import java.util.Date;

public class Member {

	private int memberNo;
	private String memberId;
	private String memberPw;
	private String memberName;
	private String memberGender;
	private String memberPhone;
	private String memberEmail;
	private String memberBirthday;
	private String memberCreateDate;
	private String memberLoginDate;

	public Member() {
	}

	public Member(int memberNo, String memberId, String memberPw, String memberName, String memberGender,
			String memberPhone, String memberEmail, String memberBirthday, String memberCreateDate,
			String memberLoginDate) {
		this.memberNo = memberNo;
		this.memberId = memberId;
		this.memberPw = memberPw;
		this.memberName = memberName;
		this.memberGender = memberGender;
		this.memberPhone = memberPhone;
		this.memberEmail = memberEmail;
		this.memberBirthday = memberBirthday;
		this.memberCreateDate = memberCreateDate;
		this.memberLoginDate = memberLoginDate;
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

	public String getMemberEmail() {
		return memberEmail;
	}

	public void setMemberEmail(String memberEmail) {
		this.memberEmail = memberEmail;
	}

	public String getMemberBirthday() {
		return memberBirthday;
	}

	public void setMemberBirthday(String memberBirthday) {
		this.memberBirthday = memberBirthday;
	}

	public String getMemberCreateDate() {
		return memberCreateDate;
	}

	public void setMemberCreateDate(String memberCreateDate) {
		this.memberCreateDate = memberCreateDate;
	}

	public String getMemberLoginDate() {
		return memberLoginDate;
	}

	public void setMemberLoginDate(String memberLoginDate) {
		this.memberLoginDate = memberLoginDate;
	}

	@Override
	public String toString() {
		return "Member [memberNo=" + memberNo + ", memberId=" + memberId + ", memberPw=" + memberPw + ", memberName="
				+ memberName + ", memberGender=" + memberGender + ", memberPhone=" + memberPhone + ", memberEmail="
				+ memberEmail + ", memberBirthday=" + memberBirthday + ", memberCreateDate=" + memberCreateDate
				+ ", memberLoginDate=" + memberLoginDate + "]";
	}

}
