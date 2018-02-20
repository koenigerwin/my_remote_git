package com.clps.bj.mms.common.util.pagination.constant;

/**
 * 
 * @description：分页模型对象的导航页码设置
 * @className：StartEndDefaultMaxNum.java
 * @author LiuLong.Mr
 * @version V1.0.0
 * 2018年1月29日下午2:54:43
 */
public interface StartEndDefaultMaxNum {
	/**
	 * 当前页的前置页码数目默认值
	 */
	int PRENUM = 4;		
	/**
	 * 当前页的后置页码数目默认值
	 */
	int AFTERNUM = 3;
	/**
	 * 默认导航页码跨度
	 * STARTENDMAXNUM = PRENUM + AFTERNUM + 1;
	 */
	int STARTENDMAXNUM = 8;
}
