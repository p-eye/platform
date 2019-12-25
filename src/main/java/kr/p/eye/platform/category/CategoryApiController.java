package kr.p.eye.platform.category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/categories")
@CrossOrigin
public class CategoryApiController {

	@Autowired
	CategoryService categoryService;

	@GetMapping
	public CategoryResponse getCategoryResponse() {
		return categoryService.getCategoryResponse();
	}
}
