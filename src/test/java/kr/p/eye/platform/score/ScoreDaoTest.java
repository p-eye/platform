package kr.p.eye.platform.score;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import kr.p.eye.platform.common.config.ApplicationConfig;

public class ScoreDaoTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext ac = new AnnotationConfigApplicationContext(ApplicationConfig.class);

		ScoreDao scoreDao = ac.getBean(ScoreDao.class);

		/*getStarCount*/
		System.out.println(scoreDao.getStarCount(94));
		
		/*getAverageScore*/
		System.out.println(scoreDao.getAvgStarScore(94));
		
		
		/*insertScore*/
		ScoreRequest scoreRequest = new ScoreRequest();
		scoreRequest.setProductId(1);
		scoreRequest.setMemberNo(17);
		scoreRequest.setEpisodeNo(7);
		scoreRequest.setScore(7);
		
		scoreDao.insertScore(scoreRequest);
	}

}
