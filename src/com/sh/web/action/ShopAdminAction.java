package com.sh.web.action;

import org.omg.CORBA.PRIVATE_MEMBER;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.sh.domain.ShopAdmin;
import com.sh.service.ShopAdminService;
import com.sun.org.apache.bcel.internal.generic.NEW;

/**
 * @author Amaze_lee
 * @date 2017年10月25日 下午4:30:44 
 * @version V1.0  
 * @Description: 
 */
public class ShopAdminAction extends ActionSupport implements ModelDriven<ShopAdmin>{
	
	private ShopAdmin shopAdmin = new ShopAdmin();
	private ShopAdminService shopAdminService;

	

	public void setShopAdminService(ShopAdminService shopAdminService) {
		this.shopAdminService = shopAdminService;
	}



	public String login() throws Exception {
		
		//1.调用service执行登录逻辑
		ShopAdmin sa = shopAdminService.getShopAdminByCodePassword(shopAdmin);
		//2.将返回的ShopAdmin对象放入session域
		ActionContext.getContext().getSession().put("shopAdmin",sa);
		//重定向到后台首页
		return "toHome";
	}

	@Override
	public ShopAdmin getModel() {
		return shopAdmin;
	}
	
	
}
