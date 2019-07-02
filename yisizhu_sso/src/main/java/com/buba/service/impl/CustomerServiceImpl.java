package com.buba.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.buba.dao.CustomerDao;
import com.buba.entity.Customer;
import com.buba.service.CustomerService;
@Service("cusService")
public class CustomerServiceImpl implements CustomerService{
	@Autowired
	private CustomerDao cusDao;
	
	//查询客户
	@Override
	public Customer findCustomerByUserAndPwd(String userName, String password) {
		System.out.println("进到cusService中的findCustomerByUserAndPwd方法！！！！！！-");
		return cusDao.findCustomerByUserAndPwd(userName, password);
	}
	
}
