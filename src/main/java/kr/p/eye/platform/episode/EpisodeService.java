package kr.p.eye.platform.episode;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Service
public interface EpisodeService {

	public static final Integer EPISODE_PER_PAGE = 5;
	public static final Integer PAGE_RANGE = 6;
	
	public EpisodeResponse getEpisodeResponse(int productId, int page);

	public EpisodeDetailResponse getEpisodeDetailResponse(int productId, int episodeNo, int commentPage);
	
	public EpisodeDetailResponse getEpisodeDetailResponseLogin(int memberNo, int productId, int episodeNo, int commentPage);

	public int updateViewCnt(int productId, int episodeNo);
	
	public void insertEpisodeAndFile(EpisodeRequest episodeRequest, MultipartFile episodeThumbnail, List<MultipartFile> episodeContent);
}
