package com.buba.dao;

import org.apache.ibatis.annotations.Insert;

import com.buba.entity.Log;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/*
 * 日志
 */
@Mapper
public interface LogDao {
	@Insert("INSERT INTO \"t_log\" VALUES (#{logId,jdbcType=VARCHAR},#{user_id,jdbcType=VARCHAR},#{user_name,jdbcType=VARCHAR},#{log_module,jdbcType=VARCHAR},#{log_name,jdbcType=VARCHAR},#{method,jdbcType=VARCHAR},#{ip_addr,jdbcType=VARCHAR},#{create_time,jdbcType=DATE},#{result,jdbcType=VARCHAR},#{exceptioncode,jdbcType=VARCHAR},#{exceptiondetail,jdbcType=VARCHAR})")
	public void addLog(Log log);
}
