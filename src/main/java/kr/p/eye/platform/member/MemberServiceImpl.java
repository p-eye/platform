package kr.p.eye.platform.member;

import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberServiceImpl implements MemberService {

	@Autowired
	MemberDao memberDao;

	@Override
	public void isIdPassed(String memberId) {

		if (!isIdValid(memberId)) {
			// 아이디 유효성 검사
			throw new MemberException("올바른 아이디를 입력해주세요");
		}

		if (!isIdNew(memberId)) {
			// 아이디 중복 검사
			throw new MemberException("이미 등록된 이메일입니다");
		}

	}

	public boolean isIdValid(String memberId) {
		final String ID_EXP = "^[a-z0-9_-]{5,20}$";
		return Pattern.matches(ID_EXP, memberId);
	}

	public boolean isIdNew(String memberId) {
		if (memberDao.getMember(memberId) == null) {
			return true;
		} else
			return false;
	}
}
