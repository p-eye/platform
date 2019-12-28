package kr.p.eye.platform.episode;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.p.eye.platform.comment.CommentService;

@Service
public class EpisodeServiceImpl implements EpisodeService {

	@Autowired
	EpisodeDao episodeDao;

	@Autowired
	CommentService commentService;

	@Override
	public EpisodeResponse getEpisodeResponse(int productId, int page) {

		EpisodeResponse episodeResponse = createEpisodeResponse(productId);
		episodeResponse.setEpisodes(getEpisodeList(productId, page));

		return episodeResponse;

	}
	

	

	public EpisodeResponse createEpisodeResponse(int productId) {
		return episodeDao.getEpisodeResponse(productId);
	}

	public List<Episode> getEpisodeList(int productId, int page) {
		int lastPage = (int) Math.ceil((double) countEpisodes(productId) / EPISODE_PER_PAGE);

		if (page < 1)
			page = 1;

		else if (page > lastPage)
			page = lastPage;

		page = (page - 1) * EPISODE_PER_PAGE;

		return episodeDao.getEpisodeList(productId, page, EPISODE_PER_PAGE);
	}

	public int countEpisodes(int productId) {
		return episodeDao.countEpisodes(productId);
	}

	@Override
	public EpisodeDetailResponse getEpisodeDetailResponse(int productId, int episodeNo, int commentPage) {
		EpisodeDetailResponse episodeDetailResponse = episodeDao.getEpisodeDetailResponse(productId, episodeNo);
		int episodeId = episodeDetailResponse.getEpisodeId();
		episodeDetailResponse.setCommentList(commentService.getCommentListByDate(episodeId, commentPage));

		return episodeDetailResponse;
	}




	@Override
	public EpisodeDetailResponse getEpisodeDetailResponseLogin(int memberNo, int productId, int episodeNo,
			int commentPage) {
		EpisodeDetailResponse episodeDetailResponse = episodeDao.getEpisodeDetailResponse(productId, episodeNo);
		int episodeId = episodeDetailResponse.getEpisodeId();
		episodeDetailResponse.setCommentList(commentService.getCommentListByDateLogin(memberNo, episodeId, commentPage));

		return episodeDetailResponse;
	}
	

	


}
