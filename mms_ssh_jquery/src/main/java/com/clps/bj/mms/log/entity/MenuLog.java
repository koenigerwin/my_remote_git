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
 * @description：菜单日志记录模型
 * @className：MenuInfoLog
 * @author LiuLong.Mr
 * @version V1.0.0
 * 2018年1月22日上午11:40:41
 */
@Entity
@Table(name="menu_log")
public class MenuLog implements InfoLog,Serializable {
	
	private static final long serialVersionUID = -9185413998505447851L;
	private String menuLogId;				//日志编号	null 插入自增，查询显示时也没有多大意义
	private String menuLogContent;			//日志内容	数据参数
	private String menuLogOperator; 		//操作人名      	id+user.getName
	private Date menuLogOperatorDatetime;	//操作时间	currentTime();
	private String menuLogOperation;		//动作名称	业务名称
	
	/**
	 * 无参构造
	 */
	public MenuLog() {}
	/**
	 * 有参构造
	 * @param menuLogContent	日志内容
	 * @param menuLogOperator	操作人名 
	 * @param menuLogOperatorDatetime	操作时间
	 * @param menuLogOperation	动作名称
	 */
	public MenuLog(String menuLogContent, String menuLogOperator, Date menuLogOperatorDatetime,
			String menuLogOperation) {
		super();
		this.menuLogContent = menuLogContent;
		this.menuLogOperator = menuLogOperator;
		this.menuLogOperatorDatetime = menuLogOperatorDatetime;
		this.menuLogOperation = menuLogOperation;
	}
	
	/**
	 * 
	 * @return String the menuLogId
	 */
	@Id
	@GenericGenerator(name="generator", strategy="uuid")
	@GeneratedValue(generator="generator")
	@Column(name="MENU_LOG_ID",nullable=false,unique=true,length=32)
	public String getMenuLogId() {
		return menuLogId;
	}
	/**
	 * 
	 * @param menuLogId	 the menuLogId to set 
	 */
	public void setMenuLogId(String menuLogId) {
		this.menuLogId = menuLogId;
	}
	/**
	 * 
	 * @return String the menuLogContent
	 */
	@Column(name="MENU_LOG_CONTENT",nullable=false,length=1000)
	public String getMenuLogContent() {
		return menuLogContent;
	}
	/**
	 * 
	 * @param menuLogContent	the menuLogContent to set
	 */
	public void setMenuLogContent(String menuLogContent) {
		this.menuLogContent = menuLogContent;
	}
	/**
	 * 
	 * @return String the menuLogOperator
	 */
	@Column(name="MENU_LOG_OPERATOR",nullable=false,length=50)
	public String getMenuLogOperator() {
		return menuLogOperator;
	}
	/**
	 * 
	 * @param menuLogOperator	the menuLogOperator to set
	 */
	public void setMenuLogOperator(String menuLogOperator) {
		this.menuLogOperator = menuLogOperator;
	}
	/**
	 * 
	 * @return	Date the menuLogOperatorDatetime
	 */
	@Column(name="MENU_LOG_OPERATOR_DATETIME",nullable=false)
	public Date getMenuLogOperatorDatetime() {
		return menuLogOperatorDatetime;
	}
	/**
	 * 
	 * @param menuLogOperatorDatetime	 the menuLogOperatorDatetime to set
	 */
	public void setMenuLogOperatorDatetime(Date menuLogOperatorDatetime) {
		this.menuLogOperatorDatetime = menuLogOperatorDatetime;
	}
	/**
	 * 
	 * @return String the menuLogOperation
	 */
	@Column(name="MENU_LOG_OPERATION",nullable=false,length=50)
	public String getMenuLogOperation() {
		return menuLogOperation;
	}
	/**
	 * 
	 * @param menuLogOperation	the menuLogOperation to set
	 */
	public void setMenuLogOperation(String menuLogOperation) {
		this.menuLogOperation = menuLogOperation;
	}
	/** 
	 * @return	String
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "MenuInfoLog [menuLogId=" + menuLogId + ", menuLogContent=" + menuLogContent + ", menuLogOperator="
				+ menuLogOperator + ", menuLogOperatorDatetime=" + menuLogOperatorDatetime + ", menuLogOperation="
				+ menuLogOperation + "]";
	}
	
	

}
