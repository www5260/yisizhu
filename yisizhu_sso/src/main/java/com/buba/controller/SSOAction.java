package com.buba.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.buba.entity.Customer;
import com.buba.service.CustomerService;
import com.buba.util.JsonFormatUtil;
import com.buba.util.RedisUtils;
import com.buba.util.SSOCheck;

//单点登录请求类
@CrossOrigin
@Controller
@RequestMapping("/ssoLogin/")
public class SSOAction {
	
	@Autowired
	private CustomerService cusService;
	//登录验证
	@RequestMapping(value="login",produces={"text/json;charset=UTF-8;"})
	@ResponseBody
	public String doLogin(String loginReason,String userName,String password,String gotoURL,HttpServletResponse resp,HttpServletRequest requ) {
		//参数说明  userName(登录用户名、手机号 、qq号) password（自身的密码） gotoURL（起始请求）
		//给定默认值
		System.out.println(gotoURL);
		Customer cus = null;
		String token = "";
		if (!"".equals(userName) && !"".equals(password)) {
			//查出客户
			System.out.println("用户名密码："+userName+"----"+password);
			cus = cusService.findCustomerByUserAndPwd(userName,password);
		}
		Map<String, Object> map = new HashMap<String, Object>();
		if (cus != null) {
			//创建令牌
			token = SSOCheck.setTokenByCustomer(cus);
			//获取json字符串
			String json = JsonFormatUtil.javaToJson(cus);
			//以token为key把userJson保存到redis，并设置过期时间2小时
			RedisUtils.save(token, json,60*60*2);
			map.put("xinxi", "登录成功");
		}else {
			map.put("xinxi", "登录失败");
		}
		map.put("token",token);
		map.put("gotoURL",gotoURL);
		if ("zhudong".equals(loginReason)){
			map.put("loginReason",loginReason);
			map.put("userLogin",cus);
		}
		String json = JsonFormatUtil.javaToJson(map);
		System.out.println(json);
		return json;
	}
	
	//令牌验证
	@RequestMapping(value="checkToken",produces={"text/json;charset=UTF-8;"})
	@ResponseBody
	public String checkToken(String token) { 
		String json = RedisUtils.getJsonByToken(token);
		if (json == null) {
			json="{}";
		}
		
		Map<String,String> map = new HashMap<String,String>();
		map.put("json", json);
		return "["+json+"]";
	}
}
