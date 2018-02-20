package com.clps.bj.mms.sm.dao;
/**
 *@description：role模块查询语句
 *@className：RoleHql
 *@author bai
 *@version v1.0
 *@date 2018年1月22日 下午3:56:47
*/
public interface RoleHql {
	public static final String queryRoleNameHql = "FROM Role WHERE ROLE_ID=? ORDER BY ROLE_NAME";;
	public static final String updateRoleHql="UPDATE Role SET ROLE_NAME=?,ROLE_ICON=?,ROLE_DESCRIPTION=?,ROLE_UPDATED_DATETIME=?,ROLE_UPDATED_USERID=? WHERE ROLE_ID=?";
	public static final String queryRoleForPageHql="FROM Role ORDER BY ROLE_NAME";
	public static final String queryRoleByNameSql="FROM Role WHERE  ROLE_NAME LIKE :NAME ORDER BY ROLE_NAME";
}
