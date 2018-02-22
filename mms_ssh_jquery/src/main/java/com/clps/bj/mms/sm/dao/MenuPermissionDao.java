/**  
 * @Title:  MenuPermission.java   
 * @Package com.clps.bj.mms.sm.dao   
 * @Description:    菜单权限关系接口
 * @author: snow.y     
 * @date:   2018年1月26日 下午2:32:12   
 * @version V1.0.0 
 * @Copyright: 2018 clps.com Inc. All rights reserved. 
 */
package com.clps.bj.mms.sm.dao;

import java.util.List;
import com.clps.bj.mms.sm.entity.MenuPermission;
import com.clps.bj.mms.sm.entity.Permission;

/**
 * @ClassName:  MenuPermission
 * @Description:菜单权限关系接口
 * @author: 	snow.y
 * @date: 		2018年1月26日 下午2:32:12
 * @version 	V1.0.0 
 */
public interface MenuPermissionDao {
	public static final String hqlDelete = "delete from MenuPermission mp where mp.menu.menuId=:menuId ";//删除语句
	public static final String hqlUpdate = "update MenuPermission mp set "
			+ "mp.mpUpdateUid=:mpUpdateUid,mp.mpUpdateTime=:mpUpdateTime,mp.menu.menuId=:menuId,"
			+ "mp.permission.pmsnId=:pmsnId where mp.mpId=:mpId";// 修改菜单权限的语句
	public static final String hqlQueryByMId = "from MenuPermission c  where c.menu.menuId=:menuId";// 查询菜单的权限
	public static final String hqlQueryById = "from MenuPermission c  where c.mpId=:mpId";// 根据主键查询菜单的权限
	public static final String hqlQueryMId = "from MenuPermission c  where c.menu.menuId=:menuId";// 查询菜单的权限
	public static final String hqlQueryAll = "from MenuPermission";// 查询所有菜单权限
	public static final String mpUpdateTime = "mpUpdateTime";// 修改时间
	public static final String mpId = "mpId";// 主键id
	public static final String mpMenuId = "menuId";// 菜单id
	public static final String mpPmsnId = "pmsnId";// 权限id
	public static final String mpUpdateUid = "mpUpdateUid";// 修改人id

	/**
	 * 
	 * @Description				 增加菜单权限
	 * @param menuPermission	 菜单权限关系实体类
	 * @return boolean			 返回true,添加成功;返回false,添加失败
	 *
	 */
	public boolean addMenuPermission(MenuPermission menuPermission);
    /**
     * 
     * @Description 			删除菜单权限
     * @param menuPermission	菜单权限关系实体类
     * @return boolean          返回true,删除成功;返回false,删除失败
     *
     */
	public boolean deleteMenuPermission(MenuPermission menuPermission);
    /**
     * 
     * @Description 			修改菜单权限
     * @param menuPermission    菜单权限关系实体类
     * @return boolean          返回true,修改成功;返回false,修改失败
     *
     */
	public boolean updateMenuPermission(MenuPermission menuPermission);
	/**
	 * 
	 * @Description 			根据主键获取对应菜单权限
	 * @param menuPermission    菜单权限关系实体类对象
	 * @return MenuPermission   菜单权限关系实体类对象    
	 *
	 */
	public MenuPermission getMenuPermissionById(MenuPermission menuPermission);
    /**
     * 
     * @Description 			查询某一个菜单的所有权限
     * @param menuPermission    菜单权限关系实体类
     * @return List<Permission> 返回权限的列表      
     *
     */
	public List<Permission> getMenuPermissionByMenuId(MenuPermission menuPermission);
	/**
	 * 
	 * @Description 								查询菜单权限的id
	 * @param menuPermissionInfo					菜单权限vo实体类对象
	 * @return MenuPermissionInfo       			菜单权限vo实体类对象
	 *
	 */
	public MenuPermission getSearchMenuPmsn(MenuPermission menuPermissionInfo);
    /**
     * 
     * @Description 			查询所有的菜单权限
     * @return List<MenuPermission> 返回所有菜单权限的列表     
     *
     */
	public List<MenuPermission> getAllMenuPermission();
}
