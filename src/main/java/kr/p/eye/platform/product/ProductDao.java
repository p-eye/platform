package kr.p.eye.platform.product;

import static kr.p.eye.platform.product.ProductDaoSqls.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class ProductDao {

	private NamedParameterJdbcTemplate jdbc;

	public ProductDao(DataSource dataSource) {
		this.jdbc = new NamedParameterJdbcTemplate(dataSource);
	}

	public List<Product> getProductListByDate(int categoryId, int start, int limit) {
		Map<String, Integer> params = new HashMap<>();
		params.put("categoryId", categoryId);
		params.put("start", start);
		params.put("limit", limit);
		
		return jdbc.query(SELECT_PRODUCTS_BY_DATE, params, new ProductMapper());
	}
	
	public List<Product> getProductListByViewCnt(int categoryId, int start, int limit) {
		Map<String, Integer> params = new HashMap<>();
		params.put("categoryId", categoryId);
		params.put("start", start);
		params.put("limit", limit);
		
		return jdbc.query(SELECT_PRODUCTS_BY_VIEWCNT, params, new ProductMapper());
	}
	
	public int countProductList(int categoryId) {
		Map<String, Integer> params = new HashMap<>();
		params.put("categoryId", categoryId);
		
		return jdbc.queryForObject(SELECT_COUNT_PRODUCTS, params, Integer.class);
	}
}
