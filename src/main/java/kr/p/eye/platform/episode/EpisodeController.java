package kr.p.eye.platform.episode;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
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
}