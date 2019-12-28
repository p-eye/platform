package kr.p.eye.platform.comment;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import kr.p.eye.platform.commentupdwn.CommentUpDao;
import kr.p.eye.platform.common.config.ApplicationConfig;

public class CommentDaoTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext ac = new AnnotationConfigApplicationContext(ApplicationConfig.class);

		CommentDao commentDao = ac.getBean(CommentDao.class);

		/* getCommentList */
		//System.out.println(commentDao.getCommentListByDate(94, 0, 10));

		 /*isMemberThumbsUp*/
		 System.out.println(commentDao.isMemberThumbsUp(5, 17));
		 
		 
		 /*
		 CommentUpDao commentUpDao = ac.getBean(CommentUpDao.class);
		 
		 commentUpDao.insertCommentUp(5, 17);
		 */
		 
		 /*getCommentResponse*/
		 System.out.println(commentDao.getCommentResponse(3));
		 
		 /*countCommentList*/
		 System.out.println(commentDao.countCommentList(94));
		 
	}

}
