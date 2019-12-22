package kr.p.eye.platform.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberServiceImpl implements MemberService {

	@Autowired
	MemberDao memberDao;

	@Override
	public boolean isIdNew(String memberId) {

		System.out.println("id : "+memberId);
		System.out.println("test: "+memberDao.getMember(memberId));
		if (memberDao.getMember(memberId) == null) {

			return true;
		} else
			return false;
	}

}
