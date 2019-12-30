package kr.p.eye.platform.fileinfo;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public interface FileinfoService {
	
	public int insertThumbnail(MultipartFile episodeThumbnail);
	
	public List<Integer> insertContent(List<MultipartFile> episodeContent);

}
