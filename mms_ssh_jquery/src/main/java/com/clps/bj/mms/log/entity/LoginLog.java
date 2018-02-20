package com.clps.bj.mms.log.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * 
 * @description：登录日志记录模型
 * @className：LoginLog
 * @author LiuLong.Mr
 * @version V1.0.0
 * 2018年1月29日上午9:15:35
 */

@Entity
@Table(name="login_log")
public class LoginLog implements InfoLog,Serializable {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -738625405630358956L;
	private String loginLogId;				//登录日志编号	UUID
	private String loginLogMacIp;			//访问IP	mac
	private String loginLogSessionId ;		//session id 据说与时间相关的一个值
	private String loginLogUserLogon; 		//登录名      	
	private String loginLogUserName;	//用户真实名
	private Date logonLogOperatorDatetime;		//登入时间
	private Date logoutLogOperatorDatetime;		//登出时间
	/**
	 * 无参构造
	 */
	public LoginLog() {}
	
	/**
	 * 有参构造
	 * @param loginLogMacIp	访问IP	mac
	 * @param loginLogSessionId   session id 
	 * @param loginLogUserLogon	登录名      
	 * @param loginLogUserName	用户真实名
	 * @param logonLogOperatorDatetime	登入时间
	 */
	public LoginLog(String loginLogMacIp, String loginLogSessionId, String loginLogUserLogon, String loginLogUserName,
			Date logonLogOperatorDatetime) {
		super();
		this.loginLogMacIp = loginLogMacIp;
		this.loginLogSessionId = loginLogSessionId;
		this.loginLogUserLogon = loginLogUserLogon;
		this.loginLogUserName = loginLogUserName;
		this.logonLogOperatorDatetime = logonLogOperatorDatetime;
	}
	/**
	 * 
	 * @return the loginLogId
	 */
	@Id
	@GenericGenerator(name="generator", strategy="uuid")
	@GeneratedValue(generator="generator")
	@Column(name="LOGIN_LOG_ID",nullable=false,unique=true,length=32)
	public String getLoginLogId() {
		return loginLogId;
	}
	
	/**
	 * 
	 * @param loginLogId the loginLogId to set
	 */
	public void setLoginLogId(String loginLogId) {
		this.loginLogId = loginLogId;
	}
	/**
	 * 
	 * @return the loginLogMacIp
	 */
	@Column(name="LOGIN_LOG_MAC_IP",nullable=false,length=50)
	public String getLoginLogMacIp() {
		return loginLogMacIp;
	}
	
	/**
	 * 
	 * @return the loginLogSessionId
	 */
	@Column(name="LOGIN_LOG_SESSION_ID",nullable=false,unique=true,length=32)
	public String getLoginLogSessionId() {
		return loginLogSessionId;
	}
	/**
	 * 
	 * @param loginLogSessionId the  loginLogSessionId to set
	 */
	public void setLoginLogSessionId(String loginLogSessionId) {
		this.loginLogSessionId = loginLogSessionId;
	}

	/**
	 * 
	 * @param loginLogMacIp the loginLogMacIp to set 
	 */
	public void setLoginLogMacIp(String loginLogMacIp) {
		this.loginLogMacIp = loginLogMacIp;
	}
	/**
	 * 
	 * @return the loginLogUserLogon
	 */
	@Column(name="LOGIN_LOG_USER_LOGON",nullable=false,length=30)
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
	@Column(name="LOGIN_LOG_USER_NAME",nullable=false,length=50)
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
	 * @return the logonLogOperatorDatetime
	 */
	@Column(name="LOGON_LOG_OPERATOR_DATETIME",nullable=false)
	public Date getLogonLogOperatorDatetime() {
		return logonLogOperatorDatetime;
	}
	/**
	 * 
	 * @param logonLogOperatorDatetime the logonLogOperatorDatetime to set
	 */
	public void setLogonLogOperatorDatetime(Date logonLogOperatorDatetime) {
		this.logonLogOperatorDatetime = logonLogOperatorDatetime;
	}
	/**
	 * 
	 * @return the logoutLogOperatorDatetime
	 */
	@Column(name="LOGOUT_LOG_OPERATOR_DATETIME")
	public Date getLogoutLogOperatorDatetime() {
		return logoutLogOperatorDatetime;
	}
	/**
	 * 
	 * @param logoutLogOperatorDatetime the logoutLogOperatorDatetime to set 
	 */
	public void setLogoutLogOperatorDatetime(Date logoutLogOperatorDatetime) {
		this.logoutLogOperatorDatetime = logoutLogOperatorDatetime;
	}
	/**
	 * @return	String
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "LoginLog [loginLogId=" + loginLogId + ", loginLogMacIp=" + loginLogMacIp + ", loginLogSessionId="
				+ loginLogSessionId + ", loginLogUserLogon=" + loginLogUserLogon + ", loginLogUserName="
				+ loginLogUserName + ", logonLogOperatorDatetime=" + logonLogOperatorDatetime
				+ ", logoutLogOperatorDatetime=" + logoutLogOperatorDatetime + "]";
	}
}
