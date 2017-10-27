package com.sh.utils;

import java.util.UUID;

/**
 * @author Amaze_lee
 * @date 2017年10月27日 下午5:56:28 
 * @version V1.0  
 * @Description: 
 */
public class CommonsUtils {
	//生成uuid方法
	public static String getUUID(){
		return UUID.randomUUID().toString();
	}
}
