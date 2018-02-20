package com.clps.bj.mms.bm.vo;

import java.io.Serializable;

//为了返回符合easyUI的tree要求的json对象，而定义的实体类
public class EasyUITreeNode implements Serializable {

	/** 
	* @Fields serialVersionUID : (用一句话描述这个变量表示什么) 
	*/ 
	private static final long serialVersionUID = 1L;
	private long id;
	private String text;
	private String state;//closed,open
	
	
	public long getId() {
		return id;
	}
	public String getText() {
		return text;
	}
	public String getState() {
		return state;
	}
	public void setId(long id) {
		this.id = id;
	}
	public void setText(String text) {
		this.text = text;
	}
	public void setState(String state) {
		this.state = state;
	}
	@Override
	public String toString() {
		return "EasyUITreeNode [id=" + id + ", text=" + text + ", state=" + state + "]";
	}
	
	
	
	
}
