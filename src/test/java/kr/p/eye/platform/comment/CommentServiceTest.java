package kr.p.eye.platform.comment;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import kr.p.eye.platform.common.config.ApplicationConfig;

public class CommentServiceTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext ac = new AnnotationConfigApplicationContext(ApplicationConfig.class);

		CommentService commentService = ac.getBean(CommentService.class);

		 /*countCommentList*/
		 System.out.println(commentService.countCommentList(94));
		 
		 
		System.out.println(commentService.getCommentListByDateLogin(17, 94, 0));
		System.out.println(commentService.countCommentList(94));
			
			
	}

}
