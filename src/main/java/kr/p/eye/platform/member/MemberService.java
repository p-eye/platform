package kr.p.eye.platform.member;

import org.springframework.stereotype.Service;

@Service
public interface MemberService {

	public MemberResponse insertMemberRequest(MemberRequest memberRequest);

}
