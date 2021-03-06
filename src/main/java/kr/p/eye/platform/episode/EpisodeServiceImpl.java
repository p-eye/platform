package kr.p.eye.platform.episode;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import kr.p.eye.platform.comment.CommentService;
import kr.p.eye.platform.episodeimage.EpisodeImageService;
import kr.p.eye.platform.fileinfo.FileinfoService;
import kr.p.eye.platform.score.ScoreService;

@Service
public class EpisodeServiceImpl implements EpisodeService {

	@Autowired
	EpisodeDao episodeDao;

	@Autowired
	CommentService commentService;

	@Autowired
	FileinfoService fileinfoService;

	@Autowired
	EpisodeImageService episodeImageService;
	
	@Autowired
	ScoreService scoreService;

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
		episodeDetailResponse.setStarScore(scoreService.getAvgStarScore(episodeId));
		episodeDetailResponse.setStarCount(scoreService.getStarCount(episodeId));

		return episodeDetailResponse;
	}

	@Override
	public EpisodeDetailResponse getEpisodeDetailResponseLogin(int memberNo, int productId, int episodeNo,
			int commentPage) {
		EpisodeDetailResponse episodeDetailResponse = episodeDao.getEpisodeDetailResponse(productId, episodeNo);
		int episodeId = episodeDetailResponse.getEpisodeId();
		episodeDetailResponse
				.setCommentList(commentService.getCommentListByDateLogin(memberNo, episodeId, commentPage));

		return episodeDetailResponse;
	}

	@Override
	public int updateViewCnt(int productId, int episodeNo) {
		int episodeId = episodeDao.getEpisodeId(productId, episodeNo);
		return episodeDao.updateViewCount(episodeId);
	}

	@Override
	@Transactional
	public void insertEpisodeAndFile(EpisodeRequest episodeRequest, MultipartFile episodeThumbnail,
			List<MultipartFile> episodeContent) {
		int episodeId = insertEpisode(episodeRequest);
		int thumbnailFileId = fileinfoService.insertThumbnail(episodeThumbnail);
		episodeImageService.insertEpisodeThumbnailImage(thumbnailFileId, episodeId);
		List<Integer> contentFileIdList = fileinfoService.insertContent(episodeContent);
		episodeImageService.insertEpisodeContentImage(contentFileIdList, episodeId);

	}

	public int insertEpisode(EpisodeRequest episodeRequest) {
		return episodeDao.insertEpisode(episodeRequest);
	}

}
