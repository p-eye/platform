package kr.p.eye.platform.episode;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class EpisodeController {

	@GetMapping(path = "/detail")
	public String getSignup(@RequestParam(name = "productId", required = true) int productId,
			@RequestParam(name = "no", required = true) int no) {

		return "detail";
	}
}