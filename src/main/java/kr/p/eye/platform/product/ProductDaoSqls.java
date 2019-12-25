package kr.p.eye.platform.product;

public class ProductDaoSqls {
	
	public static final String SELECT_PRODUCTS_BY_DATE = 
			"SELECT e.product_id, "
			+"p.category_id, "
			+"p.title, "
			+"p.writer, "
			+"e.episode_name, "
			+"e.view_cnt, "
			+"e.star_score, "
			+"e.star_score_count "
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
			+"WHERE p.category_id = :categoryId "
			+"ORDER BY e.create_date DESC "
			+"limit :start, :limit";
	
	public static final String SELECT_PRODUCTS_BY_VIEWCNT = 
			"SELECT e.product_id, "
			+"p.category_id, "
			+"p.title, "
			+"p.writer, "
			+"e.episode_name, "
			+"e.view_cnt, "
			+"e.star_score, "
			+"e.star_score_count "
			+"FROM episode_info e "
			+"INNER JOIN "
			+"(SELECT e.product_id, "
			+"MAX(e.view_cnt) AS MaxViewCnt "
			+"FROM episode_info e "
			+"GROUP BY e.product_id) max "
			+"ON e.product_id = max.product_id "
			+"AND e.view_cnt = max.MaxViewCnt "
			+"INNER JOIN product p "
			+"ON e.product_id = p.id "
			+"WHERE p.category_id = :categoryId "
			+"ORDER BY e.create_date DESC "
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
