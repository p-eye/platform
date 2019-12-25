package kr.p.eye.platform.category;

import java.util.Collections;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class CategoryDao {

	private NamedParameterJdbcTemplate jdbc;

	public CategoryDao(DataSource dataSource) {
		this.jdbc = new NamedParameterJdbcTemplate(dataSource);
	}

	public List<Category> getCategoryList() {
		String sql = "SELECT c.category_id, "
				+"c.category_name, "
				+"count(p.id) "
				+"FROM category c "
				+"INNER JOIN product p "
				+"ON c.category_id = p.category_id "
				+"GROUP BY c.category_id";
		return jdbc.query(sql, Collections.emptyMap(), new CategoryMapper());
	}
}
