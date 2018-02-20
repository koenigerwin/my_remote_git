/**
 * 
 */
package com.clps.bj.mms.sm.dao;

/**
 * 
 * @description：sql语句常量接口
 * @className：MenuHql
 * @author ygg
 * @version V1.0.0
 * 2018年1月22日
 */
/**
 * @author ygg
 *
 */
public interface MenuHql {
	// 通过id查询所有信息
	public String queryMenuById = "FROM Menu m where m.menuId=? ORDER BY m.menuSortNum,m.menuSortId" ;
	
	// 通过id查询同级别的菜单信息
	public String queryElevelMenuById = "FROM Menu m where m.menuParent = (SELECT m.menuParent FROM Menu m WHERE  m.menuId = ?  ) "
			+" ORDER BY m.menuSortNum,m.menuSortId" ;
	//查询所有除指定菜单及其子类以外的所有菜单
	public String queryOtherMenu = "FROM Menu m WHERE m.menuSortId not like ? ORDER BY m.menuSortNum,m.menuSortId";
	
	// 查询菜单个数
	public String countSizeSql = "SELECT COUNT(*) FROM menu";

	// 查询对应的name父级以及子菜单的所有信息
	public String queryParenAndChildMenuByName = " FROM Menu m WHERE  m.menuParent "
			+ "in (SELECT menuId FROM Menu where menu_name like ?  "
			+ " ) or( m.menuName like ?  ) ORDER BY m.menuSortNum,m.menuSortId";
	// 查询对应name是否是顶层类
	public String queryParentByName = " FROM Menu m WHERE  m.menuParent "
			+ "is null AND m.menuName = ? ORDER BY m.menuSortNum,m.menuSortId";
	// 查询对应的id查询父级以及子菜单的所有菜单
	public String queryParentAndChildMenuById = "FROM Menu m WHERE  m.menuParent in "
			+ "(SELECT menuId FROM Menu WHERE menuId = ? ) "
			+ "or( m.menuId = ?  ) ORDER BY m.menuSortNum,m.menuSortId";
	// 查询所有的父菜单
	public String queryAllParents = " FROM Menu m WHERE  m.menuParent " + "is null ORDER BY m.menuSortNum,m.menuSortId";

	// 查询对应菜单的所有的子菜单菜单
	public String queryAllChildById = " FROM Menu m WHERE  m.menuParent " + "= ? ORDER BY m.menuSortNum,m.menuSortId";
	// 查询所有的已经激活的菜单
	public String queryAllMenus = " FROM Menu m ORDER BY m.menuSortNum,m.menuSortId";

	// 查询对应name的菜单
	public String queryMenuByName = "FROM Menu m where menuName like ? ORDER BY m.menuSortNum,m.menuSortId ";
	
	

}
