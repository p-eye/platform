package kr.p.eye.platform.product;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ProductController {

	@GetMapping(path = "/list")
	public String getList(@RequestParam(name = "productId", required = true) int productId) {
		return "list";
	}

}