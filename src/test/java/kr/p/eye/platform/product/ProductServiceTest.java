package kr.p.eye.platform.product;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import kr.p.eye.platform.common.config.ApplicationConfig;

public class ProductServiceTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext ac = new AnnotationConfigApplicationContext(ApplicationConfig.class);

		ProductService productService = ac.getBean(ProductService.class);
		
		System.out.println(productService.getProductListByDate(1, 0));
		
	}

}
