package kr.p.eye.platform.member;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import kr.p.eye.platform.common.config.ApplicationConfig;
import kr.p.eye.platform.member.MemberDao;

public class MemberDaoTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 ApplicationContext ac = new AnnotationConfigApplicationContext(ApplicationConfig.class);

		 MemberDao memberDao = ac.getBean(MemberDao.class);
		 
		/*getmember*/
		 System.out.println(memberDao.getMember("test1"));
		 System.out.println(memberDao.getMember("tasdfsafdsadf"));
	}
	

}
