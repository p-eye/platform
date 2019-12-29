package kr.p.eye.platform.comment;

import java.util.List;

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
		 
		 
		List<Comment> commentList = commentService.getCommentListByDateLogin(13, 94, 0);
		
		for (Comment comment : commentList) {
			System.out.println(comment);
		}
		
		
		
			
	}

}
