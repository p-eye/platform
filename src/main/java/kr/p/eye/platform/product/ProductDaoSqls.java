package kr.p.eye.platform.product;

public class ProductDaoSqls {
	
	public static final String SELECT_PRODUCTS_BY_DATE = 
			"SELECT e.product_id, "
			+"p.category_id, "
			+"p.title, "
			+"p.writer, "
			+"f.save_file_name AS product_image_url, "
			+"e.episode_name, "
			+"e.view_cnt, "
			+"e.star_count "
			+"FROM episode_info e "
			+"INNER JOIN "
				+"(SELECT e.product_id, "
				+"MAX(e.create_date) AS MaxDateTime "
				+"FROM episode_info e "
				+"GROUP BY e.product_id) max "
			+"ON e.product_id = max.product_id "
			+"AND e.create_date = max.MaxDateTime "
			+"INNER JOIN product p "
			+"ON e.product_id = p.id "
			+"INNER JOIN product_image pi "
			+"ON e.product_id = pi.product_id "
			+"INNER JOIN file_info f "
			+"ON pi.file_id = f.id "
			+"WHERE p.category_id = :categoryId "
			+"ORDER BY e.create_date DESC "
			+"limit :start, :limit";
	
	public static final String SELECT_PRODUCTS_BY_VIEWCNT = 
			"SELECT e.product_id, "
			+"p.category_id, "
			+"p.title, "
			+"p.writer, "
			+"f.save_file_name AS product_image_url, "
			+"e.episode_name, "
			+"e.view_cnt, "
			+"e.star_count "
			+"FROM episode_info e "
			+"INNER JOIN "
			+"(SELECT e.product_id, "
			+"MAX(e.create_date) AS MaxDateTime "
			+"FROM episode_info e "
			+"GROUP BY e.product_id) max "
			+"ON e.product_id = max.product_id "
			+"AND e.create_date = max.MaxDateTime "
			+"INNER JOIN product p "
			+"ON e.product_id = p.id "
			+"INNER JOIN product_image pi "
			+"ON e.product_id = pi.product_id "
			+"INNER JOIN file_info f "
			+"ON pi.file_id = f.id "
			+"WHERE p.category_id = :categoryId "
			+"ORDER BY e.view_cnt DESC "
			+"limit :start, :limit";
	
	public static final String SELECT_COUNT_PRODUCTS = 
			"SELECT count(*) "
			+"FROM product p "
			+"WHERE p.category_id =:categoryId";
	
	public static final String SELECT_PRODUCT = 
			"SELECT id AS product_id, "
			+ "description AS product_description "
			+ "FROM product "
			+ "WHERE id = :productId";
}
