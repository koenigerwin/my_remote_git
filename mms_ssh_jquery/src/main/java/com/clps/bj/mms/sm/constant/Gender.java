package com.clps.bj.mms.sm.constant;

/**
 * 
 * @Description: 枚举类 表示用户的性别
 * 
 * @className：User
 * @author jiangying
 * @version V1.0.0 2018年1月23日上午11:42:45
 */
public enum Gender {

	// '0 女 1 男 2 其它 3 保密'

	female(0), male(1), other(2), unknown(3);

	public final static String Doc = "0:female; 1: male; 2: other; 3:unknown ";
	private final int value;

	private Gender(int value) {
		this.value = value;
	}

	public int getValue() {
		return this.value;
	}
	
}
