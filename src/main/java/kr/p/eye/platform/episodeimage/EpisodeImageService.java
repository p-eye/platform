package kr.p.eye.platform.episodeimage;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public interface EpisodeImageService {

	public int insertEpisodeThumbnailImage(int fileId, int episodeId);

	public int insertEpisodeContentImage(List<Integer> fileIdList, int episodeInfoId);
}
