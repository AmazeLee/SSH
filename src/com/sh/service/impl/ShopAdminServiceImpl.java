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
		//根据登录名称查询登录用户
		ShopAdmin sa = sad.getByShopAdminCode(admin.getName());
		//判断用户是否存在，不存在=>抛出异常，提示用户名不存在
		if(sa==null) {
			throw new RuntimeException("用户名不存在");
		}
		//判断用户密码是否正确，不正确抛出异常，提示密码错误
		if(!sa.getPassword().equals(admin.getPassword())) {
			throw new RuntimeException("密码错误");
		}
		return sa;
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
