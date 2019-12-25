package kr.p.eye.platform.product;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class ProductMapper implements RowMapper<Product> {

	@Override
	public Product mapRow(ResultSet rs, int rowNum) throws SQLException {

		Product product = new Product();
		
		product.setProductId(rs.getInt(1));
		product.setCategoryId(rs.getInt(2));
		product.setTitle(rs.getString(3));
		product.setWriter(rs.getString(4));
		product.setEpisodeName(rs.getString(5));
		product.setViewCnt(rs.getInt(6));
		product.setStarScore(rs.getDouble(7));
		product.setStarScoreCount(rs.getInt(8));
		
		return product;
	}

}
