package com.clps.bj.mms.log.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.stereotype.Component;


/**
 * @description：用户日志记录模型
 * @className：UserInfoLog
 * @author LiuLong.Mr
 * @version V1.0.0
 * 2018年1月22日上午11:40:41
 */

@Entity
@Table(name="userinfo_log")
public class UserInfoLog implements InfoLog,Serializable{
	
	
	
	private static final long serialVersionUID = 782173390667549425L;
	
	private String userLogId;				//日志编号	null 插入自增，查询显示时也没有多大意义
	private String userLogContent;			//日志内容	数据参数
	private String userLogOperator; 		//操作人名      	id+user.getName
	private Date userLogOperatorDatetime;	//操作时间	currentTime();
	private String userLogOperation;		//动作名称	业务名称
	/**
	 * 无参构造
	 */
	public UserInfoLog(){}
	/**
	 * 有参构造
	 * @param userLogContent	日志内容
	 * @param userLogOperator	操作人名 
	 * @param userLogOperatorDatetime	操作时间
	 * @param userLogOperation	动作名称
	 */
	public UserInfoLog(String userLogContent, String userLogOperator, Date userLogOperatorDatetime,
			String userLogOperation) {
		super();
		this.userLogContent = userLogContent;
		this.userLogOperator = userLogOperator;
		this.userLogOperatorDatetime = userLogOperatorDatetime;
		this.userLogOperation = userLogOperation;	
	}
	
	/**
	 * @return  String the userLogId
	 */
	@Id
	@GenericGenerator(name="generator" , strategy="uuid")
	@GeneratedValue(generator="generator")
	@Column(name="USER_LOG_ID",nullable=false,unique=true,length=32)
	public String getUserLogId() {
		return userLogId;
	}
	/**
	 * @param userLogId the userLogId to set
	 */
	public void setUserLogId(String userLogId) {
		this.userLogId = userLogId;
	}
	/**
	 * 
	 * @return String the userLogContent
	 */
	@Column(name="USER_LOG_CONTENT",nullable=false,length=1000)
	public String getUserLogContent() {
		return userLogContent;
	}
	/**
	 * 
	 * @param userLogContent  the userLogContent to set
	 */
	public void setUserLogContent(String userLogContent) {
		this.userLogContent = userLogContent;
	}
	/**
	 * @return	String the	userLogOperator
	 */
	@Column(name="USER_LOG_OPERATOR",nullable=false,length=50)
	public String getUserLogOperator() {
		return userLogOperator;
	}
	/**
	 * @param userLogOperator the userLogOperator to set
	 */
	public void setUserLogOperator(String userLogOperator) {
		this.userLogOperator = userLogOperator;
	}
	/**
	 * 
	 * @return	Date	the userLogOperatorDatetime
	 */
//	@Temporal(value = TemporalType.TIMESTAMP)
	@Column(name="USER_LOG_OPERATOR_DATETIME",nullable=false)
	public Date getUserLogOperatorDatetime() {
		return userLogOperatorDatetime;
	}
	/**
	 * 
	 * @param userLogOperatorDatetime 操作时间
	 */
	public void setUserLogOperatorDatetime(Date userLogOperatorDatetime) {
		this.userLogOperatorDatetime = userLogOperatorDatetime;
	}
	/**
	 * 
	 * @return 	String	the userLogOperation
	 */
	@Column(name="USER_LOG_OPERATION",nullable=false,length=50)
	public String getUserLogOperation() {
		return userLogOperation;
	}
	/**
	 * 
	 * @param userLogOperation   the userLogOperation to set
	 */
	public void setUserLogOperation(String userLogOperation) {
		this.userLogOperation = userLogOperation;
	}
	/** 
	 * @return	String
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "InfoLog {userLogId=" + userLogId + ", userLogContent=" + userLogContent + ", userLogOperator="
				+ userLogOperator + ", userLogOperatorDatetime=" + userLogOperatorDatetime + ", userLogOperation="
				+ userLogOperation + "}";
	}

	
}
