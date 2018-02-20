package com.clps.bj.mms.constant;

/**
 * 
 * @description：TODO
 * @className：MethodType
 * @author erwin.wang
 * @version V1.0.0
 * 2018年1月22日 上午9:22:24
 */
public enum MethodType {

	QUERY(1), DELETE(2), MODIFY(3), ADD(4);

	private int id;

	private MethodType() {
		// TODO Auto-generated constructor stub
	}

	private MethodType(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
