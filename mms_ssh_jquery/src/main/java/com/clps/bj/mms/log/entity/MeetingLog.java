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
 * @description：会议日志记录模型
 * @className：MeetingInfoLog
 * @author LiuLong.Mr
 * @version V1.0.0
 * 2018年1月22日上午11:40:41
 */
@Entity
@Table(name="meeting_log")
public class MeetingLog implements InfoLog,Serializable {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -738625405630358956L;
	private String meetingLogId;				//日志编号	null 插入自增，查询显示时也没有多大意义
	private String meetingLogContent;			//日志内容	数据参数
	private String meetingLogOperator; 		//操作人名      	id+user.getName
	private Date meetingLogOperatorDatetime;	//操作时间	currentTime();
	private String meetingLogOperation;		//动作名称	业务名称
	
	/**
	 * 无参构造
	 */
	public MeetingLog() {}
	/**
	 * 有参构造
	 * @param meetingLogContent	日志内容
	 * @param meetingLogOperator	操作人名
	 * @param meetingLogOperatorDatetime	操作时间
	 * @param meetingLogOperation	动作名称
	 */
	public MeetingLog(String meetingLogContent, String meetingLogOperator, Date meetingLogOperatorDatetime,
			String meetingLogOperation) {
		super();
		this.meetingLogContent = meetingLogContent;
		this.meetingLogOperator = meetingLogOperator;
		this.meetingLogOperatorDatetime = meetingLogOperatorDatetime;
		this.meetingLogOperation = meetingLogOperation;
	}
	
	/**
	 * 
	 * @return String the meetingLogId
	 */
	@Id
	@GenericGenerator(name="generator", strategy="uuid")
	@GeneratedValue(generator="generator")
	@Column(name="MEETING_LOG_ID",nullable=false,unique=true,length=32)
	public String getMeetingLogId() {
		return meetingLogId;
	}
	/**
	 * 
	 * @param meetingLogId the meetingLogId to set
	 */
	public void setMeetingLogId(String meetingLogId) {
		this.meetingLogId = meetingLogId;
	}
	/**
	 * 
	 * @return String the meetingLogContent
	 */
	@Column(name="MEETING_LOG_CONTENT",nullable=false,length=1000)
	public String getMeetingLogContent() {
		return meetingLogContent;
	}
	/**
	 * 
	 * @param meetingLogContent the meetingLogContent to set
	 */
	public void setMeetingLogContent(String meetingLogContent) {
		this.meetingLogContent = meetingLogContent;
	}
	/**
	 * 
	 * @return String the meetingLogOperator
	 */
	@Column(name="MEETING_LOG_OPERATOR",nullable=false,length=50)
	public String getMeetingLogOperator() {
		return meetingLogOperator;
	}
	/**
	 * 
	 * @param meetingLogOperator the meetingLogOperator to set 
	 */
	public void setMeetingLogOperator(String meetingLogOperator) {
		this.meetingLogOperator = meetingLogOperator;
	}
	/**
	 * 
	 * @return Date the meetingLogOperatorDatetime
	 */
	@Column(name="MEETING_LOG_OPERATOR_DATETIME",nullable=false)
	public Date getMeetingLogOperatorDatetime() {
		return meetingLogOperatorDatetime;
	}
	/**
	 * 
	 * @param meetingLogOperatorDatetime the meetingLogOperatorDatetime to set
	 */
	public void setMeetingLogOperatorDatetime(Date meetingLogOperatorDatetime) {
		this.meetingLogOperatorDatetime = meetingLogOperatorDatetime;
	}
	/**
	 * 
	 * @return String the meetingLogOperation
	 */
	@Column(name="MEETING_LOG_OPERATION",nullable=false,length=50)
	public String getMeetingLogOperation() {
		return meetingLogOperation;
	}
	/**
	 * 
	 * @param meetingLogOperation the meetingLogOperation to set
	 */
	public void setMeetingLogOperation(String meetingLogOperation) {
		this.meetingLogOperation = meetingLogOperation;
	}
	/** 
	 * @return	String
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "MeetingInfoLog [meetingLogId=" + meetingLogId + ", meetingLogContent=" + meetingLogContent + ", meetingLogOperator="
				+ meetingLogOperator + ", meetingLogOperatorDatetime=" + meetingLogOperatorDatetime + ", meetingLogOperation="
				+ meetingLogOperation + "]";
	}
	
	

}
