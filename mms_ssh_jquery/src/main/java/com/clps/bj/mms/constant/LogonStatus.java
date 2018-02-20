package com.clps.bj.mms.constant;
/**
 * 
 * @Description：本类记录了用户的注册流程中的各种状态
 * @ClassName：LogonStatus
 * @Author erwin.wang
 * @Version V1.0.0
 * 2018年1月24日 上午10:51:09
 */
public enum LogonStatus {
	/**
	 * 
	 * @Description: 未激活
	 *
	 */
	USER_INACTIVE,
	/**
	 * @Description: 已激活
	 */
	USER_ACTIVED,
	/**
	 * @Description: 未审核
	 */
	USER_INCHECKED,
	/**
	 * @Description: 审核中
	 */
	USER_CHECKING,
	/**
	 * @Description: 审核后
	 */
	USER_CHECKED;
	/**
	 * 
	 */
	
}

