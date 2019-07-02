package com.buba.service;

import com.buba.entity.Customer;

public interface CustomerService {
	
	public Customer findCustomerByUserAndPwd(String userName, String password);
}
