package com.sh.dao.impl;

import java.util.List;


import com.sh.dao.CategoryDao;
import com.sh.domain.Category;

/**
 * @author Amaze_lee
 * @date 2017年10月26日 下午5:55:13
 * @version V1.0
 * @Description:
 */
public class CategoryDaoImpl extends BaseDaoImpl<Category> implements CategoryDao {

	@SuppressWarnings("unchecked")
	@Override
	public List<Category> getCategoryList() {
		
	/*	List<Category> list = (List<Category>) getHibernateTemplate().find("from Category");*/
	return (List<Category>) this.getHibernateTemplate().find("from Category");	
	}
}
