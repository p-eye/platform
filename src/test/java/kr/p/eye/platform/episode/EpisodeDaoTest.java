package kr.p.eye.platform.episode;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import kr.p.eye.platform.common.config.ApplicationConfig;

public class EpisodeDaoTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext ac = new AnnotationConfigApplicationContext(ApplicationConfig.class);

		EpisodeDao episodeDao = ac.getBean(EpisodeDao.class);

		/* getEpisodeList */
		/*
		List<Episode> episodeList = episodeDao.getEpisodeList(1,0,5);
		
		for(Episode episode: episodeList) {
			System.out.println(episode);
		}
		*/
		
		/*getEpisodeResponse*/
//		System.out.println(episodeDao.getEpisodeResponse(1));
		
		/*getEpisodeDetailResponse*/
//		System.out.println(episodeDao.getEpisodeDetailResponse(1, 51));
		
	
		/*getEpisodeId*/
		System.out.println(episodeDao.getEpisodeId(1, 52));
	}

}
