package kr.p.eye.platform.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	ProductDao productDao;

	@Override
	public ProductResponse getProductListByDate(int categoryId, int start) {
		ProductResponse productResponse = new ProductResponse();
		List<Product> productList = productDao.getProductListByDate(categoryId, start, PRODUCT_PER_PAGE);
		productResponse.setItems(productList);
		productResponse.setTotalCount(countProducts(categoryId));

		return productResponse;
	}

	@Override
	public ProductResponse getProductListByViewCnt(int categoryId, int start) {
		ProductResponse productResponse = new ProductResponse();
		List<Product> productList = productDao.getProductListByViewCnt(categoryId, start, PRODUCT_PER_PAGE);
		productResponse.setItems(productList);
		productResponse.setTotalCount(countProducts(categoryId));

		return productResponse;
	}

	public int countProducts(int categoryId) {
		return productDao.countProductList(categoryId);
	}

	@Override
	public ProductResponse getProductListByWriter(String writer) {
		ProductResponse productResponse = new ProductResponse();
		List<Product> productList = productDao.getProductList(writer);
		productResponse.setItems(productList);
		
		return productResponse;
	}

	
}
