package com.buba.entity;

import java.util.Date;

public class Log {
	private String logId;// 主键UUID
	private String user_id;// 操作用户id
	private String user_name;// 操作用户姓名
	private String log_module;// 模块名称
	private String log_name;// 日志操作名
	private String method;// 方法完全限定名
	private String ip_addr;// 操作用户ip地址
	private Date create_time;// 操作时间
	private int result;// 操作结果
	private String exceptioncode;// 异常编号
	private String exceptiondetail;// 异常说明
	public String getLogId() {
		return logId;
	}
	public void setLogId(String logId) {
		this.logId = logId;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getLog_module() {
		return log_module;
	}
	public void setLog_module(String log_module) {
		this.log_module = log_module;
	}
	public String getLog_name() {
		return log_name;
	}
	public void setLog_name(String log_name) {
		this.log_name = log_name;
	}
	public String getMethod() {
		return method;
	}
	public void setMethod(String method) {
		this.method = method;
	}
	public String getIp_addr() {
		return ip_addr;
	}
	public void setIp_addr(String ip_addr) {
		this.ip_addr = ip_addr;
	}
	public Date getCreate_time() {
		return create_time;
	}
	public void setCreate_time(Date create_time) {
		this.create_time = create_time;
	}
	public int getResult() {
		return result;
	}
	public void setResult(int result) {
		this.result = result;
	}
	public String getExceptioncode() {
		return exceptioncode;
	}
	public void setExceptioncode(String exceptioncode) {
		this.exceptioncode = exceptioncode;
	}
	public String getExceptiondetail() {
		return exceptiondetail;
	}
	public void setExceptiondetail(String exceptiondetail) {
		this.exceptiondetail = exceptiondetail;
	}
	public Log() {
		super();
	}
	public Log(String logId, String user_id, String user_name, String log_module, String log_name, String method,
			String ip_addr, Date create_time, int result, String exceptioncode, String exceptiondetail) {
		super();
		this.logId = logId;
		this.user_id = user_id;
		this.user_name = user_name;
		this.log_module = log_module;
		this.log_name = log_name;
		this.method = method;
		this.ip_addr = ip_addr;
		this.create_time = create_time;
		this.result = result;
		this.exceptioncode = exceptioncode;
		this.exceptiondetail = exceptiondetail;
	}
	@Override
	public String toString() {
		return "Log [logId=" + logId + ", user_id=" + user_id + ", user_name=" + user_name + ", log_module="
				+ log_module + ", log_name=" + log_name + ", method=" + method + ", ip_addr=" + ip_addr
				+ ", create_time=" + create_time + ", result=" + result + ", exceptioncode=" + exceptioncode
				+ ", exceptiondetail=" + exceptiondetail + "]";
	}
}
