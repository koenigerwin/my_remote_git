package com.clps.bj.mms.sm.dao;

import com.clps.bj.mms.constant.DataRecordType;
import com.clps.bj.mms.sm.constant.Gender;

/**
 * 
 * @Description: 用户主表的Hql语句
 * 
 * @className：UserInfoMainHql
 * @author jiangying
 * @version V1.0.0 2018年1月25日上午11:37:53
 */
public interface UserInfoMainHql {

	// 通过id查询单个用户信息(但当查询的属性有null时就会报NullPointException空指针异常)

	public static final String Hql_queryUserMainById = "SELECT new UserInfoMain(u.userId,u.userName,u.userEmail,u.userCreatedDatetime,u.userCreatedName,p,r,d) FROM UserInfoMain as u"
			+ " left join u.positionId p" + " left join u.roleId r" + " left join u.deptId d"
			+ " WHERE u.userId = ? AND u.userIsEnable = ? AND u.userStatus = ?";

	// 通过id删除用户(逻辑删除 userIsEnable = '0'表示数据已删除)
	public static final String Hql_deleteUserMainById = "UPDATE UserInfoMain SET userIsEnable = '0' WHERE userId = ? ";

	// 通过用户id修改用户信息
	public static final String Hql_updateUserMainById = "UPDATE UserInfoMain u SET u.userCreatedDatetime = ?,u.userCreatedName = ?,u.userEmail = ?,u.userStatus = ? ,u.positionId.positionId = ?, u.roleId.roleId = ? ,u.deptId.deptId = ? WHERE u.userId = ?";

	// 通过用户姓名查询用户信息
	public static final String Hql_queryUserMainByName = "FROM UserInfoMain as u"
			+ " WHERE u.userName = ? AND u.userIsEnable = ? AND u.userStatus = ?";

	public static final String Hql_queryAllUserMain = "SELECT new UserInfoMain(u.userId,u.userName,u.userEmail,u.userCreatedDatetime,u.userCreatedName,p,r,d) FROM UserInfoMain as u"
			+ " left join u.positionId p" + " left join u.roleId r" + " left join u.deptId d"
			+ " WHERE u.userIsEnable = ? AND u.userStatus = ?";

	public static final String hql_queryAllUser = "From UserInfoMain u where  u.userIsEnable = ? AND u.userStatus = ?";

	// 通过部门查用户组
	public static final String Hql_queryUserByDept = "FROM UserInfoMain WHERE deptId.deptId = ? AND userStatus = ?";

	/***************************************************************************/
	// 用过用户id/用户name 查询出用户信息，角色id，角色名，部门id，部门名，职位id,职位名

	/* 1111111111111111111111111111111111111111111111111111111111111111 */
	/*
	 * public static String Hql_getUserInfoMain =
	 * "select new com.clps.bj.mms.sm.vo.UserInfoVo(u,r.roleId,r.roleName," +
	 * "d.deptId,d.deptName,p.positionId,p.positionName) from UserInfoMain u " +
	 * "left join  u.roleId r  " + "left join  u.deptId  d" +
	 * " left join  u.positionId p" + " where u.userIsEnable = '" +
	 * DataRecordType.ENABLE.getId() + "'" + " and ";
	 */

	// 通过用户id查询用户的信息
	// public static final String getUser_ByUserId = " u.userId = ?";
	// 通过 用户名 模糊查询用户的信息
	// public static final String getUser_ByUserName = " u.userName Like
	// concat('%',?,'%')";

	/***************************************************************************/
	// 通过 部门/角色 /职位 id查询单个用户信息
	public static final String Hql_queryUserMain = "SELECT new UserInfoMain(u.userId,u.userName,u.userLogon,u.userStatus,u.userEmail,u.userCreatedDatetime,u.userCreatedName) FROM UserInfoMain as u"
			+ " WHERE u.userIsEnable = ? AND u.userStatus = ? ";

	// 通过部门id查询用户信息
	public static final String Hql_queryUserMainByDeptId = Hql_queryUserMain + " and  u.deptId.deptId = ?";

	// 通过角色id查询用户信息
	public static final String Hql_queryUserMainByRoleId = Hql_queryUserMain + " and u.roleId.roleId = ?";
	// 查出角色为null的用户
	public static final String Hql_queryUserMainByNullRoleId = Hql_queryUserMain + " and u.roleId.roleId is null";

	// 通过职位id查询用户信息
	public static final String Hql_queryUserMainByPosId = Hql_queryUserMain + " and u.positionId.positionId = ?";
	/*******************************************************************/

	// 通过传入登录名查询用户 (和密码) 判断 验证用户是否可以登录
	public static String Hql_userLogon = " From UserInfoMain where userLogon = ? AND userIsEnable = ? AND userStatus = ?";

	// 通过传入用户id 查出用户主表及从表的信息
	public static String Hql_userInfomationById = "select u1.userId,u1.userLogon,u1.userName,u2.userGender,u2.userMobile,u1.userEmail,u2.userWeiXin,u1.userStatus,u1.userCreatedDatetime,u1.userCreatedName,u2.userUpdatedDateTime,u2.userUpdatedName from UserInfoMain u1  left join UserInfoDetail u2 on u1.userId = u2.userId where u1.userId = ?";

	// 查出用户主表及从表的所有信息
	public static String Hql_AlluserInfoion = "select u1.userId,u1.userLogon,u1.userName,u2.userGender,u2.userMobile,u1.userEmail,u2.userWeiXin,u1.userStatus,u1.userCreatedDatetime,u1.userCreatedName,u2.userUpdatedDateTime,u2.userUpdatedName from UserInfoMain u1  left join UserInfoDetail u2 where u1.userId = u2.userId";
	// 通过角色id 修改用户 角色
	public static String updateuserroleHQL = "update UserInfoMain set roleId.roleId=? where userId=? and  userIsEnable = ? AND userStatus = ?";
	
	
	//查询指定职位id外的所有人员
	public static String getAllLeadingPerHQL = "FROM UserInfoMain u WHERE u.positionId.positionId != ? order by CONVERT(u.userName USING gbk) ";
	
	//查询指定职位id外的所有人员
	public static String getAllLeadingPerSQL = "SELECT * FROM userinfo_main u WHERE user_per_id != ? order by CONVERT(u.user_name USING gbk) ";
	
	
		
}
