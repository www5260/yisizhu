package com.buba.entity;

import java.util.Date;

public class Customer {
	private String csid;           	//会员编号,主键UUID
	private String nickName;		//昵称
	private String userName;		//用户名
	private String phone;			//手机
	private String qqnum;			//QQ号
	private String userPass;		//密码
	private String email;			//邮箱
	private Integer power;			//权限
	private String license;			//营业执照
	private String company;			//公司
	private String duty;			//职务
	private Integer coltdCode;		//企业码
	private Integer stall;			//商户码
	private Integer privacy;		//隐私码
	private Integer state;			//状态码
	private String portrait;		//头像
	private String remark;			//描述
	private String question;		//密保问题
	private String answer;			//密保答案
	private Date generTime;			//生成时间
	public String getCsid() {
		return csid;
	}
	public void setCsid(String csid) {
		this.csid = csid;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getQqnum() {
		return qqnum;
	}
	public void setQqnum(String qqnum) {
		this.qqnum = qqnum;
	}
	public String getUserPass() {
		return userPass;
	}
	public void setUserPass(String userPass) {
		this.userPass = userPass;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Integer getPower() {
		return power;
	}
	public void setPower(Integer power) {
		this.power = power;
	}
	public String getLicense() {
		return license;
	}
	public void setLicense(String license) {
		this.license = license;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getDuty() {
		return duty;
	}
	public void setDuty(String duty) {
		this.duty = duty;
	}
	public Integer getColtdCode() {
		return coltdCode;
	}
	public void setColtdCode(Integer coltdCode) {
		this.coltdCode = coltdCode;
	}
	public Integer getStall() {
		return stall;
	}
	public void setStall(Integer stall) {
		this.stall = stall;
	}
	public Integer getPrivacy() {
		return privacy;
	}
	public void setPrivacy(Integer privacy) {
		this.privacy = privacy;
	}
	public Integer getState() {
		return state;
	}
	public void setState(Integer state) {
		this.state = state;
	}
	public String getPortrait() {
		return portrait;
	}
	public void setPortrait(String portrait) {
		this.portrait = portrait;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	public Date getGenerTime() {
		return generTime;
	}
	public void setGenerTime(Date generTime) {
		this.generTime = generTime;
	}
	
	//tostring方法
	@Override
	public String toString() {
		return "Customer [csid=" + csid + ", nickName=" + nickName + ", userName=" + userName + ", phone=" + phone
				+ ", qqnum=" + qqnum + ", userPass=" + userPass + ", email=" + email + ", power=" + power + ", license="
				+ license + ", company=" + company + ", duty=" + duty + ", coltdCode=" + coltdCode + ", stall=" + stall
				+ ", privacy=" + privacy + ", state=" + state + ", portrait=" + portrait + ", remark=" + remark
				+ ", question=" + question + ", answer=" + answer + ", generTime=" + generTime + "]";
	}
	
	//构造方法
	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Customer(String csid, String nickName, String userName, String phone, String qqnum, String userPass,
			String email, Integer power, String license, String company, String duty, Integer coltdCode, Integer stall,
			Integer privacy, Integer state, String portrait, String remark, String question, String answer,
			Date generTime) {
		super();
		this.csid = csid;
		this.nickName = nickName;
		this.userName = userName;
		this.phone = phone;
		this.qqnum = qqnum;
		this.userPass = userPass;
		this.email = email;
		this.power = power;
		this.license = license;
		this.company = company;
		this.duty = duty;
		this.coltdCode = coltdCode;
		this.stall = stall;
		this.privacy = privacy;
		this.state = state;
		this.portrait = portrait;
		this.remark = remark;
		this.question = question;
		this.answer = answer;
		this.generTime = generTime;
	}
	
	
}
