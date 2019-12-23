package kr.p.eye.platform.category;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	CategoryDao categoryDao;

	@Override
	public CategoryResponse getCategoryResponse() {
		return new CategoryResponse(getCategoryList());
	}

	public List<Category> getCategoryList() {
		return categoryDao.getCategoryList();
	}

}
