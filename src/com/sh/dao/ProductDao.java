package com.sh.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.sh.domain.Product;

/**
 * @author Amaze_lee
 * @date 2017年10月26日 上午11:50:26 
 * @version V1.0  
 * @Description: 
 */
public interface ProductDao {

	/**
	 * @param dc
	 * @return
	 */
	Integer getTotalCount(DetachedCriteria dc);

	/**
	 * @param dc
	 * @param start
	 * @param pageSize
	 * @return
	 */
	List<Product> getPageList(DetachedCriteria dc, int start, Integer pageSize);

}
