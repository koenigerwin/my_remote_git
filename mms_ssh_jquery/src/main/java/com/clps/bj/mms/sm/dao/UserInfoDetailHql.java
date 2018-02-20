package com.clps.bj.mms.sm.dao;

/**
 * 
 * @Description: 用户主表的Hql语句
 * 
 * @className：UserInfoDetailHql
 * @author jiangying
 * @version V1.0.0 2018年1月25日
 */
public interface UserInfoDetailHql {

	// 通过用户id查询用户信息
	public static final String Hql_queryUserInfoDetailById = " FROM UserInfoDetail WHERE userId = ? ";

	// 通过用户id修改用户信息
	public static final String Hql_updateUserInfoDetailById = " UPDATE UserInfoDetail SET userBirth = ?,userDescritpion = ?,userGender = ?,"
			+ "userIcon = ?,userLevel = ?,userMobile = ?,userPhone = ?,userUpdatedName = ?,userUpdatedDateTime = ?,userWeixin = ? WHERE userId = ?";

	// 查询所有用户
	public static final String Hql_queryallUserInfoDetail = " FROM UserInfoDetail ";

}
