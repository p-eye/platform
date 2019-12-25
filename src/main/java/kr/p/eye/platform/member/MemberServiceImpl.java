package kr.p.eye.platform.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberServiceImpl implements MemberService {

	@Autowired
	MemberDao memberDao;

	@Override
	public MemberResponse insertMemberRequest(MemberRequest memberRequest) {
		if (!isIdNew(memberRequest.getMemberId()))
			throw new MemberException(memberRequest.getMemberId(), "이미 등록된 아이디입니다");

		int memberNo = insertMember(memberRequest);

		return getMemberResponse(memberNo);

	}

	public int insertMember(MemberRequest memberRequest) {
		return memberDao.insertMember(memberRequest);
	}

	public MemberResponse getMemberResponse(int memberNo) {
		return memberDao.getMemberResponse(memberNo);
	}

	public boolean isIdNew(String memberId) {
		if (memberDao.getMember(memberId) == null) {
			return true;
		} else {
			return false;
		}

	}

}
