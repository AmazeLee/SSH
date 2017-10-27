package com.sh.service.impl;

import java.util.List;

import com.sh.dao.CategoryDao;
import com.sh.domain.Category;
import com.sh.service.CategoryService;

/**
 * @author Amaze_lee
 * @date 2017年10月26日 下午8:59:33 
 * @version V1.0  
 * @Description: 
 */
public class CategoryServieImpl implements CategoryService {
	
	private CategoryDao cd;
	
	@Override
	public List<Category> getCategoryList() {
		List<Category> categoryList = cd.getCategoryList();
		return categoryList;
	}

	public void setCd(CategoryDao cd) {
		this.cd = cd;
	}
	
}
