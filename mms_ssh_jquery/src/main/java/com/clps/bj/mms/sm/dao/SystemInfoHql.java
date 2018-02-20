package com.clps.bj.mms.sm.dao;
/**
 *@Description：SystemInfoDao相关hql语句
 *@className：SystemInfoHql
 *@author bai
 *@version v1.0
 *@date 2018年1月23日 下午10:21:07
*/
public interface SystemInfoHql {
	public static final String queryHql= "FROM SystemInfo";
	public static final String updateHql= "UPDATE SystemInfo SET SYSTEMINFO_NAME=?,SYSTEMINFO_ICON=?,"
			+ "SYSTEMINFO_VERSION=?,SYSTEMINFO_DESCRIPTION=?,SYSTEMINFO_PIC_ID=?,SYSTEMINFO_COPYRIGHT=?,"
			+ "SYS_TIME=?,SYS_DB_USERNAME=?,SYS_DB_PASSWORD=?,SYS_PATH=?,SYS_CREATED_DATETIME=?,"
			+ "SYS_CREATED_USERID=?,SYS_UPDATED_DATETIME=?,SYS_UPDATED_USERID=?";
}
