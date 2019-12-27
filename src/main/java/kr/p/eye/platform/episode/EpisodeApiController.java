package kr.p.eye.platform.episode;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api")
@CrossOrigin
public class EpisodeApiController {

	@Autowired
	EpisodeService episodeService;

	@GetMapping(path = "/list/{productId}/{page}")
	public EpisodeResponse getEpisodeResponse(@PathVariable(name = "productId", required = true) int productId,
			@PathVariable(name = "page", required = true) int page) {
		return episodeService.getEpisodeResponse(productId, page);
	}

	@GetMapping(path = "detail/{productId}/{no}/{commentPage}")
	public EpisodeDetailResponse getEpisodeDetailResponse(
			@PathVariable(name = "productId", required = true) int productId,
			@PathVariable(name = "no", required = true) int no,
			@PathVariable(name = "commentPage", required = true) int commentPage) {

		return episodeService.getEpisodeDetailResponse(productId, no, commentPage);
	}
}
