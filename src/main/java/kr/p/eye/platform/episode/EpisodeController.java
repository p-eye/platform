package kr.p.eye.platform.episode;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class EpisodeController {

	@Autowired
	EpisodeService episodeService;
	
	@GetMapping(path = "/detail")
	public String getDetail(@RequestParam(name = "productId", required = true) int productId,
			@RequestParam(name = "no", required = true) int no) {
		
		System.out.println("test");
		episodeService.updateViewCnt(productId, no);

		return "detail";
	}
	
	
	@PostMapping(path = "/upload")
	public void insertEpisode(EpisodeRequest episodeRequest,
			@RequestParam MultipartFile files) {
		
		episodeRequest.setWriter("작가1");
		System.out.println(episodeRequest);
		System.out.println(files);

	}
}