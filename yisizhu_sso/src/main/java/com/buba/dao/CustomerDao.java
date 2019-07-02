package com.buba.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import com.buba.entity.Customer;
@Mapper
public interface CustomerDao {
	
	//查询Customer的方法
	@Select("select * from t_web_customer where (userName = #{userName} and userpass = #{password}) or (PHONE = #{userName} and userpass = #{password}) or (QQNUM = #{userName} and userpass = #{password})")
	public Customer findCustomerByUserAndPwd(@Param("userName") String userName, @Param("password") String password);
}
