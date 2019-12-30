package kr.p.eye.platform.fileinfo;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FileinfoServiceImpl implements FileinfoService {

	private static final String ILLEGAL_EXP = "[:\\\\/%*?:|\"<>]";

	private final FileinfoDao fileinfoDao;

	@Autowired
	public FileinfoServiceImpl(FileinfoDao fileinfoDao) {
		this.fileinfoDao = fileinfoDao;
	}

	@Override
	public int insertThumbnail(MultipartFile episodeThumbnail) {

		String fileNameTimeStamped = uploadEpisodeThumbnailFile(episodeThumbnail);

		Fileinfo fileinfo = new Fileinfo();

		fileinfo.setFileName(fileNameTimeStamped);
		fileinfo.setSaveFileName("img/episode/" + fileNameTimeStamped);
		fileinfo.setContentType(episodeThumbnail.getContentType());

		return fileinfoDao.insertFileinfo(fileinfo);
	}

	@Override
	public List<Integer> insertContent(List<MultipartFile> episodeContent) {

		List<Integer> fileinfoIdList = new ArrayList<>();
		for (MultipartFile file : episodeContent) {
			String fileNameTimeStamped = uploadEpisodeThumbnailFile(file);

			Fileinfo fileinfo = new Fileinfo();

			fileinfo.setFileName(fileNameTimeStamped);
			fileinfo.setSaveFileName("img/episode/" + fileNameTimeStamped);
			fileinfo.setContentType(file.getContentType());

			fileinfoIdList.add(fileinfoDao.insertFileinfo(fileinfo));

		}
		return fileinfoIdList;

	}

	private String uploadEpisodeThumbnailFile(MultipartFile episodeThumbnail) {

		/* 파일명 유효성 검사 */
		String fileName = episodeThumbnail.getOriginalFilename();
		if (!isValidFileName(fileName)) {
			fileName = createValidFileName(fileName, "_");
		}

		/* 파일명에 현재시간 timeStamp 붙이기 */
		String fileNameTimeStamped = createTimeStampedFileName(fileName);

		/* 파일 업로드 디렉토리 */
		File dir = new File("c:/tmp/" + "img/episode/");
		if (!dir.exists()) {
			dir.mkdirs();
		}

		/* 파일업로드 */
		try (FileOutputStream fos = new FileOutputStream(dir + "/" + fileNameTimeStamped);
				InputStream is = episodeThumbnail.getInputStream();) {
			int readCount = 0;
			byte[] buffer = new byte[1024];
			while ((readCount = is.read(buffer)) != -1) {
				fos.write(buffer, 0, readCount);
			}
		} catch (Exception ex) {
			throw new RuntimeException("file Save Error");
		}

		return fileNameTimeStamped;
	}

	private String createTimeStampedFileName(String fileName) {
		String _fileName = fileName.substring(0, fileName.lastIndexOf("."));
		String fileType = fileName.substring(fileName.lastIndexOf(".") + 1);
		String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss.SSS").format(System.currentTimeMillis());

		return _fileName + "_" + timeStamp + "." + fileType;
	}

	private static boolean isValidFileName(String fileName) {
		if (fileName == null || fileName.trim().length() == 0)
			return false;

		return !Pattern.compile(ILLEGAL_EXP).matcher(fileName).find();
	}

	private static String createValidFileName(String fileName, String replaceStr) {
		if (fileName == null || fileName.trim().length() == 0 || replaceStr == null)
			return String.valueOf(System.currentTimeMillis());

		return fileName.replaceAll(ILLEGAL_EXP, replaceStr);
	}

}
