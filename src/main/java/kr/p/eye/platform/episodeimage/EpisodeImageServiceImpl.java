package kr.p.eye.platform.episodeimage;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EpisodeImageServiceImpl implements EpisodeImageService {

	@Autowired
	EpisodeImageDao episodeImageDao;

	@Override
	public int insertEpisodeThumbnailImage(int fileId, int episodeInfoId) {

		EpisodeImage episodeImage = new EpisodeImage();
		episodeImage.setEpisodeInfoId(episodeInfoId);
		episodeImage.setFileId(fileId);
		episodeImage.setType("th");
		return episodeImageDao.insertEpisodeImage(episodeImage);

	}

	@Override
	public int insertEpisodeContentImage(List<Integer> fileIdList, int episodeInfoId) {

		for (int fileId : fileIdList) {
			EpisodeImage episodeImage = new EpisodeImage();
			episodeImage.setEpisodeInfoId(episodeInfoId);
			episodeImage.setFileId(fileId);
			episodeImage.setType("co");
			episodeImageDao.insertEpisodeImage(episodeImage);
		}
		return 0;
	}

}
