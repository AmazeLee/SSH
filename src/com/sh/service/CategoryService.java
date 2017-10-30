package com.sh.service;

import java.util.List;

import com.sh.domain.Category;

/**
 * @author Amaze_lee
 * @date 2017年10月26日 下午8:57:30 
 * @version V1.0  
 * @Description: 
 */
public interface CategoryService {

	/**
	 * @return
	 */
	List<Category> getCategoryList();

	Category getById(String cid);

	void update(Category category);

}
