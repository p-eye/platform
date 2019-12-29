package kr.p.eye.platform.episode;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import kr.p.eye.platform.common.config.ApplicationConfig;

public class EpisodeServiceTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext ac = new AnnotationConfigApplicationContext(ApplicationConfig.class);

		EpisodeService episodeService = ac.getBean(EpisodeService.class);

		/*getEpisodeDetailResponse*/
		System.out.println(episodeService.getEpisodeDetailResponse(1,52,0));
		
		/*updateViewCnt*/
		episodeService.updateViewCnt(1,51);
	}

}
