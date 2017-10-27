package com.sh.service.impl;

import java.util.List;

import javax.crypto.interfaces.PBEKey;

import org.hibernate.criterion.DetachedCriteria;

import com.sh.dao.ProductDao;
import com.sh.domain.Product;
import com.sh.service.ProductService;
import com.sh.utils.PageBean;
import com.sun.xml.internal.ws.util.xml.CDATA;

/**
 * @author Amaze_lee
 * @date 2017年10月26日 上午10:32:25 
 * @version V1.0  
 * @Description: 
 */
public class ProductServiceImpl implements ProductService{

	private ProductDao pd;
	
	@Override
	public PageBean getPageBean(DetachedCriteria dc, Integer currentPage, Integer pageSize) {
		//调用dao查询总记录数
		Integer totalCount = pd.getTotalCount(dc);
		//创建pageBean对象
		PageBean pb = new PageBean(currentPage, totalCount, pageSize);
		//调用Dao查询分页列表数据
		List<Product> list = pd.getPageList(dc,pb.getStart(),pb.getPageSize());
		//列表数据放入pageBean中，并返回
		pb.setList(list);
		return pb;
	}

	public void setPd(ProductDao pd) {
		this.pd = pd;
	}

	//保存商品
	@Override
	public void save(Product product) {
		System.out.println("service"+product);
		pd.save(product);
	}
}
