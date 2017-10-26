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
//一方面 实现接口把方法声明拿过来一方面实现继承通用实现类把实现代码拿过来
public class ProductDaoImpl extends BaseDaoImpl<Product> implements ProductDao{}
