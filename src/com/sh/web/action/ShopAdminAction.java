package com.sh.web.action;

import org.omg.CORBA.PRIVATE_MEMBER;

import com.opensymphony.xwork2.ActionSupport;
import com.sh.service.ShopAdminService;

/**
 * @author Amaze_lee
 * @date 2017年10月25日 下午4:30:44 
 * @version V1.0  
 * @Description: 
 */
public class ShopAdminAction extends ActionSupport{
	
	private ShopAdminService shopAdminService;

	

	public void setShopAdminService(ShopAdminService shopAdminService) {
		this.shopAdminService = shopAdminService;
	}



	public String login() throws Exception {
		System.out.println(shopAdminService);
		return super.execute();
	}
	
	
}
