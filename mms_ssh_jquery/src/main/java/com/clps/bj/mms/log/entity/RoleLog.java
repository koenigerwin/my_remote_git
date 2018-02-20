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
 * @description：角色日志记录模型
 * @className：RoleInfoLog
 * @author LiuLong.Mr
 * @version V1.0.0
 * 2018年1月22日上午11:40:41
 */
@Entity
@Table(name="role_log")
public class RoleLog implements InfoLog,Serializable{
	
	
	private static final long serialVersionUID = -2534018739956943159L;
	private String roleLogId;				//日志编号	null 插入自增，查询显示时也没有多大意义
	private String roleLogContent;			//日志内容	数据参数
	private String roleLogOperator; 		//操作人名      	id+user.getName
	private Date roleLogOperatorDatetime;	//操作时间	currentTime();
	private String roleLogOperation;		//动作名称	业务名称
	
	/**
	 * 无参构造
	 */
	public RoleLog(){}
	/**
	 * 有参构造
	 * @param roleLogContent	日志内容
	 * @param roleLogOperator	操作人名
	 * @param roleLogOperatorDatetime	操作时间
	 * @param roleLogOperation	动作名称
	 */
	public RoleLog(String roleLogContent, String roleLogOperator, Date roleLogOperatorDatetime,
			String roleLogOperation) {
		super();
		this.roleLogContent = roleLogContent;
		this.roleLogOperator = roleLogOperator;
		this.roleLogOperatorDatetime = roleLogOperatorDatetime;
		this.roleLogOperation = roleLogOperation;
	}
	/**
	 * 
	 * @return String the roleLogId
	 */
	@Id
	@GenericGenerator(name="generator", strategy="uuid")
	@GeneratedValue(generator="generator")
	@Column(name="ROLE_LOG_ID",nullable=false,unique=true,length=32)
	public String getRoleLogId() {
		return roleLogId;
	}
	/**
	 * 
	 * @param roleLogId the roleLogId to set
	 */
	public void setRoleLogId(String roleLogId) {
		this.roleLogId = roleLogId;
	}
	/**
	 * 
	 * @return  to the roleLogContent
	 */
	@Column(name="ROLE_LOG_CONTENT",nullable=false,length=1000)
	public String getRoleLogContent() {
		return roleLogContent;
	}
	/**
	 * 
	 * @param roleLogContent the roleLogContent to set
	 */
	public void setRoleLogContent(String roleLogContent) {
		this.roleLogContent = roleLogContent;
	}
	/**
	 * 
	 * @return String the roleLogOperator
	 */
	@Column(name="ROLE_LOG_OPERATOR",nullable=false,length=50)
	public String getRoleLogOperator() {
		return roleLogOperator;
	}
	/**
	 * 
	 * @param roleLogOperator	the roleLogOperator to set
	 */
	public void setRoleLogOperator(String roleLogOperator) {
		this.roleLogOperator = roleLogOperator;
	}
	/**
	 * 
	 * @return Date the roleLogOperatorDatetime
	 */
	@Column(name="ROLE_LOG_OPERATOR_DATETIME",nullable=false)
	public Date getRoleLogOperatorDatetime() {
		return roleLogOperatorDatetime;
	}
	/**
	 * 
	 * @param roleLogOperatorDatetime the roleLogOperatorDatetime to set
	 */
	public void setRoleLogOperatorDatetime(Date roleLogOperatorDatetime) {
		this.roleLogOperatorDatetime = roleLogOperatorDatetime;
	}
	/**
	 * 
	 * @return String the roleLogOperation
	 */
	@Column(name="ROLE_LOG_OPERATION",nullable=false,length=50)
	public String getRoleLogOperation() {
		return roleLogOperation;
	}
	/**
	 * 
	 * @param roleLogOperation the roleLogOperation to set
	 */
	public void setRoleLogOperation(String roleLogOperation) {
		this.roleLogOperation = roleLogOperation;
	}
	/** 
	 * @return	String
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "RoleInfoLog [roleLogId=" + roleLogId + ", roleLogContent=" + roleLogContent + ", roleLogOperator="
				+ roleLogOperator + ", roleLogOperatorDatetime=" + roleLogOperatorDatetime + ", roleLogOperation="
				+ roleLogOperation + "]";
	}
	
	
}
