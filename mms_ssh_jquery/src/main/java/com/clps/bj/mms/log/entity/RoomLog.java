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
 * @description：会议室日志记录模型
 * @className：RoomInfoLog
 * @author LiuLong.Mr
 * @version V1.0.0
 * 2018年1月22日上午11:40:41
 */
@Entity
@Table(name="room_log")
public class RoomLog implements InfoLog,Serializable {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -738625405630358956L;
	private String roomLogId;				//日志编号	null 插入自增，查询显示时也没有多大意义
	private String roomLogContent;			//日志内容	数据参数
	private String roomLogOperator; 		//操作人名      	id+user.getName
	private Date roomLogOperatorDatetime;	//操作时间	currentTime();
	private String roomLogOperation;		//动作名称	业务名称
	
	/**
	 * 无参构造
	 */
	public RoomLog() {}
	/**
	 * 有参构造
	 * @param roomLogContent	日志内容
	 * @param roomLogOperator	操作人名 
	 * @param roomLogOperatorDatetime 	操作时间
	 * @param roomLogOperation		动作名称
	 */
	public RoomLog(String roomLogContent, String roomLogOperator, Date roomLogOperatorDatetime,
			String roomLogOperation) {
		super();
		this.roomLogContent = roomLogContent;
		this.roomLogOperator = roomLogOperator;
		this.roomLogOperatorDatetime = roomLogOperatorDatetime;
		this.roomLogOperation = roomLogOperation;
	}
	
	/**
	 * 
	 * @return  String the roomLogId
	 */
	@Id
	@GenericGenerator(name="generator", strategy="uuid")
	@GeneratedValue(generator="generator")
	@Column(name="ROOM_LOG_ID",nullable=false,unique=true,length=32)
	public String getRoomLogId() {
		return roomLogId;
	}
	/**
	 * 
	 * @param roomLogId the roomLogId to set
	 */
	public void setRoomLogId(String roomLogId) {
		this.roomLogId = roomLogId;
	}
	/**
	 * 
	 * @return String the roomLogContent
	 */
	@Column(name="ROOM_LOG_CONTENT",nullable=false,length=1000)
	public String getRoomLogContent() {
		return roomLogContent;
	}
	/**
	 * 
	 * @param roomLogContent the roomLogContent to set
	 */
	public void setRoomLogContent(String roomLogContent) {
		this.roomLogContent = roomLogContent;
	}
	/**
	 * 
	 * @return String the roomLogOperator
	 */
	@Column(name="ROOM_LOG_OPERATOR",nullable=false,length=50)
	public String getRoomLogOperator() {
		return roomLogOperator;
	}
	/**
	 * 
	 * @param roomLogOperator the roomLogOperator to set
	 */
	public void setRoomLogOperator(String roomLogOperator) {
		this.roomLogOperator = roomLogOperator;
	}
	/**
	 * 
	 * @return Date the roomLogOperatorDatetime
	 */
	@Column(name="ROOM_LOG_OPERATOR_DATETIME",nullable=false)
	public Date getRoomLogOperatorDatetime() {
		return roomLogOperatorDatetime;
	}
	/**
	 * 
	 * @param roomLogOperatorDatetime the roomLogOperatorDatetime to set
	 */
	public void setRoomLogOperatorDatetime(Date roomLogOperatorDatetime) {
		this.roomLogOperatorDatetime = roomLogOperatorDatetime;
	}
	/**
	 * 
	 * @return	String the roomLogOperation 
	 */
	@Column(name="ROOM_LOG_OPERATION",nullable=false,length=50)
	public String getRoomLogOperation() {
		return roomLogOperation;
	}
	/**
	 * 
	 * @param roomLogOperation the roomLogOperation to set
	 */
	public void setRoomLogOperation(String roomLogOperation) {
		this.roomLogOperation = roomLogOperation;
	}
	/** 
	 * @return	String
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "RoomInfoLog [roomLogId=" + roomLogId + ", roomLogContent=" + roomLogContent + ", roomLogOperator="
				+ roomLogOperator + ", roomLogOperatorDatetime=" + roomLogOperatorDatetime + ", roomLogOperation="
				+ roomLogOperation + "]";
	}
	
	

}
