package com.buba.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import com.buba.entity.Customer;
@Mapper
public interface CustomerDao {
	
	//查询Customer的方法
	@Select("select * from CUSTOMER where (USERNAME = #{userName} and USERPASS = #{password}) or (PHONE = #{userName} and USERPASS = #{password}) or (QQNUM = #{userName} and USERPASS = #{password})")
	public Customer findCustomerByUserAndPwd(@Param("userName") String userName, @Param("password") String password);
}
