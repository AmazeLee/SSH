package com.sh.service;
import com.sh.domain.ShopAdmin;

/**
 * @author Amaze_lee
 * @date 2017年10月25日 下午4:46:54 
 * @version V1.0  
 * @Description: 
 */
public interface ShopAdminService {
	
	ShopAdmin getShopAdminByCodePassword(ShopAdmin admin);
	
	void saveShopAdmin(ShopAdmin sa);
}
