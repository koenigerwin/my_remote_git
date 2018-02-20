/**
 * 
 */
package com.clps.bj.mms.sm.dao;

/**
 * 
 * @description：TODO
 * @className：PositionHql.java
 * @author ygg
 * @version V1.0.0
 * 2018年1月22日
 */
public interface PositionHql {
	// 通过id查询所有信息
	public String queryPositionById = "FROM Position where positionId = ?";

	// 查询菜单个数
	public String countSizeSql = "SELECT COUNT(*) FROM position";

	// 查询所有的菜单
	public String queryAllPositions = " FROM Position";

	// 查询对应name的菜单
	public String queryPositionByName = "FROM Position where positionName = ?";

}
