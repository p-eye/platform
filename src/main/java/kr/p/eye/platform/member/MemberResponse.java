package kr.p.eye.platform.member;

public class MemberResponse {

	private String memberId;
	private String memberGender;
	private String memberPhone;
	private String memberBirthDay;
	private String memberCreateDate;

	public MemberResponse() {
	}

	public MemberResponse(String memberId, String memberGender, String memberPhone, String memberBirthDay,
			String memberCreateDate) {
		this.memberId = memberId;
		this.memberGender = memberGender;
		this.memberPhone = memberPhone;
		this.memberBirthDay = memberBirthDay;
		this.memberCreateDate = memberCreateDate;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
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

	public String getMemberBirthDay() {
		return memberBirthDay;
	}

	public void setMemberBirthDay(String memberBirthDay) {
		this.memberBirthDay = memberBirthDay;
	}

	public String getMemberCreateDate() {
		return memberCreateDate;
	}

	public void setMemberCreateDate(String memberCreateDate) {
		this.memberCreateDate = memberCreateDate;
	}

	@Override
	public String toString() {
		return "MemberResponse [memberId=" + memberId + ", memberGender=" + memberGender + ", memberPhone="
				+ memberPhone + ", memberBirthDay=" + memberBirthDay + ", memberCreateDate=" + memberCreateDate + "]";
	}

}
