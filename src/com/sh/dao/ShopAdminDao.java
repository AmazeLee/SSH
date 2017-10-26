package com.sh.dao;

import com.sh.domain.ShopAdmin;

/**
 * @author Amaze_lee
 * @date 2017年10月25日 下午5:48:00 
 * @version V1.0  
 * @Description: 
 */
public interface ShopAdminDao extends BaseDao<ShopAdmin>{
	
	//根据登录名查询管理员对象
	ShopAdmin getByShopAdminCode(String admincode);
}
