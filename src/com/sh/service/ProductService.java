package com.sh.service;

import org.hibernate.criterion.DetachedCriteria;

import com.sh.domain.Product;
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

	/**
	 * 保存商品
	 * @param product
	 */
	void save(Product product);

	/**
	 * 根据id获得商品对象
	 * @param pid
	 * @return
	 */
	Product getById(String pid);

	/**
	 * 修改商品
	 * @param product
	 */
	void update(Product product);

	/**
	 * 删除商品
	 * @param pid
	 */
	void delById(String pid);

}
