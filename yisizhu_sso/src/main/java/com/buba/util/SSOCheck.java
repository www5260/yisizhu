package com.buba.util;

import com.buba.entity.Customer;

//检查Cookie

public class SSOCheck {
	
	//校验token
	public static boolean checkToken(String token) {
		boolean flag = false;
		String json = RedisUtils.getJsonByToken(token);
		if (json != null) {
			flag = true;
		}
		return flag;
	}
	//创建令牌token
	public static String setTokenByCustomer(Customer cus) {
		String token = null;
		if (cus != null) {
			String uuid = MD5Util.getUUID();
			token = MD5Util.encodeByMd5(uuid+cus.getUserName()+cus.getPhone()+cus.getQqnum()+cus.getUserPass());
		}
		return token;
	}
	
}
