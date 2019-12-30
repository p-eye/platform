package kr.p.eye.platform.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/products")
@CrossOrigin
public class ProductApiController {

	@Autowired
	ProductService productService;

	
	
	@GetMapping(path = "/date")
	public ProductResponse getProducListByDate(
			@RequestParam(name = "categoryId", required = false, defaultValue = "1") int categoryId,
			@RequestParam(name = "start", required = false, defaultValue = "0") int start) {

		return productService.getProductListByDate(categoryId, start);
	}
	
	@GetMapping(path = "/viewCnt")
	public ProductResponse getProducListByViewCnt(
			@RequestParam(name = "categoryId", required = false, defaultValue = "1") int categoryId,
			@RequestParam(name = "start", required = false, defaultValue = "0") int start) {

		return productService.getProductListByViewCnt(categoryId, start);
	}
	
	@GetMapping(path = "/{writer}")
	public ProductResponse getProductListByWriter(@PathVariable String writer) {
		return productService.getProductListByWriter(writer);
		
	}
}
