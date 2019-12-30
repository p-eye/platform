package kr.p.eye.platform.episode;

public class EpisodeDaoSqls {
	
	public static final String GET_EPISODE_ID = 
			"SELECT v.id "
			+"FROM "
			+"(SELECT e.id, "
			+"@rownum :=@rownum+1 AS episode_no "
			+"FROM episode_info e, "
			+"(SELECT @rownum := 0) r " 
			+"WHERE e.product_id = 1 ) v "
			+"WHERE v.episode_no = :episodeNo";
	
	public static final String UPDATE_VIEWCNT = 
			"UPDATE episode_info e "
			+"SET e.view_cnt  = e.view_cnt +1 "
			+"WHERE e.id = :episodeId";
	
	public static final String GET_EPISODE_LIST = 
			"SELECT e.product_id, "
			+"e.id AS episode_id, "
			+"@rownum := @rownum +1 AS episode_no, "
			+"e.episode_name, "
			+"e.create_date "
			+"FROM episode_info e, "
			+"(SELECT @rownum := 0) r "
			+"WHERE e.product_id = :productId "
			+"ORDER BY episode_no DESC "
			+"limit :page, :limit";
	
	public static final String GET_EPISODE_RESPONSE = 
			"SELECT count(e.id) AS total_count, "
			+"p.title, "
			+"p.content, "
			+"p.writer, "
			+"f.save_file_name AS product_image_url "
			+"FROM episode_info e "
			+"INNER JOIN product p "
			+"ON p.id = e.product_id "
			+"INNER JOIN product_image pi "
			+"ON pi.product_id = p.id "
			+"INNER JOIN file_info f "
			+"ON pi.file_id = f.id "
			+"WHERE e.product_id = :productId "
			+"GROUP BY f.save_file_name";
	
	public static final String COUNT_EPISODES =
			"SELECT count(e.id) "
			+"FROM episode_info e "
			+"WHERE e.product_id = :productId";
	
	public static final String GET_EPISODE_DETAIL_RESPONSE = 
			"SELECT "
	                +"V.*, "
					+"count(c.id) AS comment_count "
	                +"FROM "
	                +"( "
						+"SELECT "
						+"e.product_id, "
						+"e.id AS episode_id, "
						+"@rownum :=@rownum+1 AS episode_no, "
						+"p.title, "
						+"p.content, " 
						+"p.writer, "
						+"e.episode_name, "
						+"e.create_date "
						+"FROM episode_info e "
						+"INNER JOIN product p  "
						+"ON p.id = e.product_id , "
						+"(SELECT @rownum := 0) r "
						+"WHERE e.product_id = :productId "
					+") V "
					+"LEFT JOIN episode_comment c "
					+"ON v.episode_id = c.episode_id "
					+"WHERE episode_no = :episodeNo "
					+"GROUP BY v.episode_id";
}
