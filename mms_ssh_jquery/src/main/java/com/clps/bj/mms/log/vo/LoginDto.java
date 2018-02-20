package com.clps.bj.mms.log.vo;

import java.util.Date;
/**
 * 
 * @description：登录查询条件数据传输模型
 * @className：LoginDto
 * @author LiuLong.Mr
 * @version V1.0.0
 * 2018年1月30日下午5:01:49
 */
public class LoginDto {
	private String loginLogUserLogon; // 前台日志内容 数据参数
	private String loginLogUserName; // 操作人名 id+user.getName
	private Boolean isLogon = true; // 是否为登陆时间查询
	private Date start; // 起始时间
	private Date end; // 截止时间
	/**
	 * 无参构造
	 */
	public LoginDto(){}
	/**
	 * 有参构造
	 * @param loginLogUserLogon	登录名
	 * @param loginLogUserName	实名
	 */
	public LoginDto(String loginLogUserLogon, String loginLogUserName){
		this(loginLogUserLogon,loginLogUserName,true,null,null);
	}
	/**
	 * 
	 * @param loginLogUserLogon	登录名
	 * @param loginLogUserName	实名
	 * @param isLogon	是否为登陆时间查询,默认为是
	 * @param start	起始时间
	 * @param end	截止时间
	 */
	public LoginDto(String loginLogUserLogon, String loginLogUserName, boolean isLogon, Date start, Date end) {
		super();
		this.loginLogUserLogon = loginLogUserLogon;
		this.loginLogUserName = loginLogUserName;
		this.isLogon = isLogon;
		this.start = start;
		this.end = end;
	}
	/**
	 * 
	 * @return the loginLogUserLogon
	 */
	public String getLoginLogUserLogon() {
		return loginLogUserLogon;
	}
	/**
	 * 
	 * @param loginLogUserLogon the loginLogUserLogon to set 
	 */
	public void setLoginLogUserLogon(String loginLogUserLogon) {
		this.loginLogUserLogon = loginLogUserLogon;
	}
	/**
	 * 
	 * @return the loginLogUserName
	 */
	public String getLoginLogUserName() {
		return loginLogUserName;
	}
	/**
	 * 
	 * @param loginLogUserName the loginLogUserName to set 
	 */
	public void setLoginLogUserName(String loginLogUserName) {
		this.loginLogUserName = loginLogUserName;
	}
	/**
	 * 
	 * @return the isLogon
	 */
	public boolean isLogon() {
		return isLogon;
	}
	/**
	 * 
	 * @param isLogon the isLogon to set
	 */
	public void setLogon(boolean isLogon) {
		this.isLogon = isLogon;
	}
	/**
	 * 
	 * @return  the start
	 */
	public Date getStart() {
		return start;
	}
	/**
	 * 
	 * @param start the start to set 
	 */
	public void setStart(Date start) {
		this.start = start;
	}
	/**
	 * 
	 * @return the end
	 */
	public Date getEnd() {
		return end;
	}
	/**
	 *  
	 * @param end the end to set
	 */
	public void setEnd(Date end) {
		this.end = end;
	}
	
	
	
	
}
