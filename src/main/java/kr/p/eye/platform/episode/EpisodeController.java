package kr.p.eye.platform.episode;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

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
	
	
	@PostMapping(path = "/upload")
	public ModelAndView insertEpisode(EpisodeRequest episodeRequest,
			@RequestParam MultipartFile episodeThumbnail,@RequestParam List<MultipartFile> episodeContent) {
		
		episodeRequest.setWriter("작가1");
		episodeService.insertEpisodeAndFile(episodeRequest, episodeThumbnail, episodeContent);

		return new ModelAndView("redirect:list?productId="+episodeRequest.getProductId());
	}
	

	@GetMapping(path = "/upload")
	public String getUpload() {
		return "upload";
	}
	
}