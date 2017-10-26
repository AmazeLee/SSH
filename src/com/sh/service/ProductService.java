package com.sh.service;

import org.hibernate.criterion.DetachedCriteria;

import com.sh.utils.PageBean;

/**
 * @author Amaze_lee
 * @date 2017年10月26日 上午10:30:51 
 * @version V1.0  
 * @Description: 
 */
public interface ProductService {

	/**
	 * 分页业务方法
	 * @param dc
	 * @param currentPage
	 * @param pageSize
	 * @return
	 */
	PageBean getPageBean(DetachedCriteria dc, Integer currentPage, Integer pageSize);

}
