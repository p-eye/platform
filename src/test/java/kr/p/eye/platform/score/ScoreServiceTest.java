package kr.p.eye.platform.score;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import kr.p.eye.platform.common.config.ApplicationConfig;

public class ScoreServiceTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext ac = new AnnotationConfigApplicationContext(ApplicationConfig.class);

		ScoreService scoreService = ac.getBean(ScoreService.class);

		scoreService.getAvgStarScore(94);
		
	}

}
