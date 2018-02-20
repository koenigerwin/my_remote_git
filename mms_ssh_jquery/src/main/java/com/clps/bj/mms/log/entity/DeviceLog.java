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
 * @description：设备日志记录模型
 * @className：DeviceLog.java
 * @author LiuLong.Mr
 * @version V1.0.0
 * 2018年1月25日下午2:09:51
 */
@Entity
@Table(name="device_log")
public class DeviceLog implements InfoLog,Serializable {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -738625405630358956L;
	private String deviceLogId;				//日志编号	null 插入自增，查询显示时也没有多大意义
	private String deviceLogContent;			//日志内容	数据参数
	private String deviceLogOperator; 		//操作人名      	id+user.getName
	private Date deviceLogOperatorDatetime;	//操作时间	currentTime();
	private String deviceLogOperation;		//动作名称	业务名称
	
	/**
	 * 无参构造
	 */
	public DeviceLog() {}
	/**
	 * 有参构造
	 * @param deviceLogContent	日志内容
	 * @param deviceLogOperator	操作人名
	 * @param deviceLogOperatorDatetime	操作时间
	 * @param deviceLogOperation	动作名称
	 */
	public DeviceLog(String deviceLogContent, String deviceLogOperator, Date deviceLogOperatorDatetime,
			String deviceLogOperation) {
		super();
		this.deviceLogContent = deviceLogContent;
		this.deviceLogOperator = deviceLogOperator;
		this.deviceLogOperatorDatetime = deviceLogOperatorDatetime;
		this.deviceLogOperation = deviceLogOperation;
	}
	
	/**
	 * 
	 * @return the deviceLogId
	 */
	@Id
	@GenericGenerator(name="generator", strategy="uuid")
	@GeneratedValue(generator="generator")
	@Column(name="DEVICE_LOG_ID",nullable=false,unique=true,length=32)
	public String getDeviceLogId() {
		return deviceLogId;
	}
	/**
	 * 
	 * @param deviceLogId the deviceLogId to set
	 */
	public void setDeviceLogId(String deviceLogId) {
		this.deviceLogId = deviceLogId;
	}
	/**
	 * 
	 * @return the deviceLogContent
	 */
	@Column(name="DEVICE_LOG_CONTENT",nullable=false,length=1000)
	public String getDeviceLogContent() {
		return deviceLogContent;
	}
	/**
	 * 
	 * @param deviceLogContent the deviceLogContent to set
	 */
	public void setDeviceLogContent(String deviceLogContent) {
		this.deviceLogContent = deviceLogContent;
	}
	/**
	 * 
	 * @return the deviceLogOperator
	 */
	@Column(name="DEVICE_LOG_OPERATOR",nullable=false,length=50)
	public String getDeviceLogOperator() {
		return deviceLogOperator;
	}
	/**
	 * 
	 * @param deviceLogOperator the deviceLogOperator to set
	 */
	public void setDeviceLogOperator(String deviceLogOperator) {
		this.deviceLogOperator = deviceLogOperator;
	}
	/**
	 * 
	 * @return the deviceLogOperatorDatetime 
	 */
	@Column(name="DEVICE_LOG_OPERATOR_DATETIME",nullable=false)
	public Date getDeviceLogOperatorDatetime() {
		return deviceLogOperatorDatetime;
	}
	/**
	 * 
	 * @param deviceLogOperatorDatetime the deviceLogOperatorDatetime to set
	 */
	public void setDeviceLogOperatorDatetime(Date deviceLogOperatorDatetime) {
		this.deviceLogOperatorDatetime = deviceLogOperatorDatetime;
	}
	/**
	 * 
	 * @return	the deviceLogOperation 
	 */
	@Column(name="DEVICE_LOG_OPERATION",nullable=false,length=50)
	public String getDeviceLogOperation() {
		return deviceLogOperation;
	}
	/**
	 * 
	 * @param deviceLogOperation	the deviceLogOperation to set
	 */
	public void setDeviceLogOperation(String deviceLogOperation) {
		this.deviceLogOperation = deviceLogOperation;
	}
	/** 
	 * @return
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "DeviceInfoLog [deviceLogId=" + deviceLogId + ", deviceLogContent=" + deviceLogContent + ", deviceLogOperator="
				+ deviceLogOperator + ", deviceLogOperatorDatetime=" + deviceLogOperatorDatetime + ", deviceLogOperation="
				+ deviceLogOperation + "]";
	}
	
	

}
