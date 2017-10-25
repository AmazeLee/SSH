package com.sh.service.impl;

import com.sh.dao.ShopAdminDao;
import com.sh.domain.ShopAdmin;
import com.sh.service.ShopAdminService;

/**
 * @author Amaze_lee
 * @date 2017年10月25日 下午4:49:59 
 * @version V1.0  
 * @Description: 
 */
/*@Transactional(isolation=Isolation.REPEATABLE_READ,propagation=Propagation.REQUIRED,readOnly=true)*/
public class ShopAdminServiceImpl implements ShopAdminService{
	
	private ShopAdminDao sad;
	
	@Override
	public ShopAdmin getShopAdminByCodePassword(ShopAdmin admin) {
		System.out.println("getShopAdminByCodePassword");
		return null;
	}

	@Override
	/*@Transactional(isolation=Isolation.REPEATABLE_READ,propagation=Propagation.REQUIRED,readOnly=false)*/
	public void saveShopAdmin(ShopAdmin sa) {
		System.out.println(sa);
		sad.save(sa);
		
	}

	public void setSad(ShopAdminDao sad) {
		this.sad = sad;
	}

}
