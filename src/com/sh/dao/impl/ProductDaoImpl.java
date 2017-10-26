package com.sh.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.sh.dao.ProductDao;
import com.sh.domain.Product;

/**
 * @author Amaze_lee
 * @date 2017年10月26日 上午11:52:00 
 * @version V1.0  
 * @Description: 
 */
public class ProductDaoImpl extends HibernateDaoSupport implements ProductDao{

	
	@Override
	public Integer getTotalCount(DetachedCriteria dc) {
		
		//设置查询的聚合函数，总记录数
		dc.setProjection(Projections.rowCount());
		List<Long> list = (List<Long>) getHibernateTemplate().findByCriteria(dc);
		//清空之前设置的聚合函数
		dc.setProjection(null);
		
		if(list!=null&&list.size()>0) {
			Long count = list.get(0);
			return count.intValue();
		}else {
			return null;
		}
	}

	
	@Override
	public List<Product> getPageList(DetachedCriteria dc, int start, Integer pageSize) {
		List<Product> list = (List<Product>) getHibernateTemplate().findByCriteria(dc,start,pageSize);
		return list;
	}

}
