package kr.p.eye.platform.product;

import org.springframework.stereotype.Service;

@Service
public interface ProductService {

	public final int PRODUCT_PER_PAGE = 6;

	public ProductResponse getProductListByDate(int categoryId, int start);

	public ProductResponse getProductListByViewCnt(int categoryId, int start);

}
