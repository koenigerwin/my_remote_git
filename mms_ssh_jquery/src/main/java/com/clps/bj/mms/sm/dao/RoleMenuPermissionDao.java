package com.clps.bj.mms.sm.dao;

import java.util.List;

import com.clps.bj.mms.sm.entity.RoleMenuPermission;

/**
 * @ClassName: RoleMenuPermissionDAO
 * @Description:角色权限接口
 * @author: snow.y
 * @date: 2018年1月25日 上午10:01:04
 * @version V 1.0.3
 */
public interface RoleMenuPermissionDao {
	public static final String hqlDeleteByRole = "delete from RoleMenuPermission r where r.role=:role";// 删除语句
	public static final String hqlDeleteById = "delete from RoleMenuPermission r where r.rmpId=:rmpId";//根据id删除
	public static final String hqlUpdate = "update RoleMenuPermission r set "
			+ "r.menuPermission.mpId=:mpId,r.rmpUpdatetime=:rmpUpdatetime,"
			+ "r.rmpUimId=:rmpUimId where r.rmpId=:rmpId";;// 修改语句
	public static final String hqlGetById = "from RoleMenuPermission c  where c.role.roleId=:role ";// 单值查询
	public static final String hqlGetAll = "from RoleMenuPermission";// 查询所有
	public static final String role = "role";// 角色id
	public static final String mpId = "mpId";// 菜单权限id
	public static final String rmpUpdatetime = "rmpUpdatetime";//修改时间
	public static final String rmpUimId = "rmpUimId";//修改人id
	public static final String rmpId = "rmpId";//主键uuid

	/**
	 * 
	 * @Description		                       增加角色菜单权限关系
	 * @param rmp			            角色菜单权限关系的实体类对象
	 */
	public boolean addRoleMenuPermission(RoleMenuPermission rmp);

	/**
	 * 
	 * @Description 			删除角色的菜单权限
	 * @param role_id			角色id
	 * @param menu_id			菜单id
	 * @param pmsn_id			权限id
	 * @return boolean		           返回true删除成功;返回false删除失败
	 */
	public boolean deleteRoleMenuPermission(RoleMenuPermission rmp);

	/**
	 * 
	 * @Description 			修改角色菜单权限
	 * @param rmp				角色菜单权限关系的实体类对象
	 * @return boolean			返回true修改成功;返回false修改失败
	 */
	public boolean updateRoleMenuPermission(RoleMenuPermission rmp);

	/**
	 * 
	 * @Description 			获取一个角色的菜单权限信息
	 * @param rmp 				角色菜单权限关系的实体类对象
	 * @return List<RoleMenuPermission> 返回所有角色菜单权限列表
	 */
	public List<RoleMenuPermission> getRoleMenuPermissionByRoleId(RoleMenuPermission rmp);

	/**
	 * 
	 * @Description 查询所有角色的菜单权限信息
	 * @return List<RoleMenuPermission> 返回所有角色菜单权限列表
	 */
	public List<RoleMenuPermission> getAllRoleMenuPermission();
}
