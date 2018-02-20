package com.clps.bj.mms.log.vo;

import java.util.Date;

public class InfoLogDto {
	
	private String userLogContent;			//前台日志内容	数据参数
	private String userLogOperator; 		//操作人名      	id+user.getName
	private String userLogOperation;		//动作名称	业务名称
	private Date start;		 	//起始时间
	private Date end;			//截止时间
	
	protected InfoLogDto(){}
	
	public InfoLogDto(String userLogContent, String userLogOperator, String userLogOperation) {
		this(userLogContent,userLogOperator,userLogOperation,null,null);
	}

	public InfoLogDto(String userLogContent, String userLogOperator, String userLogOperation, Date start, Date end) {
		super();
		this.userLogContent = userLogContent;
		this.userLogOperator = userLogOperator;
		this.userLogOperation = userLogOperation;
		this.start = start;
		this.end = end;
	}
	public String getUserLogContent() {
		return userLogContent;
	}
	public void setUserLogContent(String userLogContent) {
		this.userLogContent = userLogContent;
	}
	public String getUserLogOperator() {
		return userLogOperator;
	}
	public void setUserLogOperator(String userLogOperator) {
		this.userLogOperator = userLogOperator;
	}
	public String getUserLogOperation() {
		return userLogOperation;
	}
	public void setUserLogOperation(String userLogOperation) {
		this.userLogOperation = userLogOperation;
	}
	public Date getStart() {
		return start;
	}
	public void setStart(Date start) {
		this.start = start;
	}
	public Date getEnd() {
		return end;
	}
	public void setEnd(Date end) {
		this.end = end;
	}
	
}
