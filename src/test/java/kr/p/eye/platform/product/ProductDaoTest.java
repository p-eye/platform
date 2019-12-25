package kr.p.eye.platform.product;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import kr.p.eye.platform.common.config.ApplicationConfig;

public class ProductDaoTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext ac = new AnnotationConfigApplicationContext(ApplicationConfig.class);

		ProductDao productDao = ac.getBean(ProductDao.class);

		/* getEpisodeList */
		List<Product> productList = productDao.getProductListByDate(1,3,4);
		
		for(Product product: productList) {
			System.out.println(product);
		}
		
	}

}
