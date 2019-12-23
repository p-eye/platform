package kr.p.eye.platform.category;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import kr.p.eye.platform.common.config.ApplicationConfig;
import kr.p.eye.platform.member.MemberDao;

public class CategoryDaoTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext ac = new AnnotationConfigApplicationContext(ApplicationConfig.class);

		CategoryDao categoryDao = ac.getBean(CategoryDao.class);

		/* getCategoryList */
		System.out.println(categoryDao.getCategoryList());
	}

}
