package kr.p.eye.platform.comment;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import kr.p.eye.platform.common.config.ApplicationConfig;

public class CommentDaoTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext ac = new AnnotationConfigApplicationContext(ApplicationConfig.class);

		CommentDao commentDao = ac.getBean(CommentDao.class);

		/* getCommentList */
		System.out.println(commentDao.getComment(94, 0, 10));

	}

}
