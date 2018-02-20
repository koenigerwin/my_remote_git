/**  
 * @Title:  GrantVOHelper.java   
 * @Package com.clps.bj.mms.common.util.data   
 * @Description:    TODO
 * @author: snow.y     
 * @date:   2018年2月1日 上午12:21:34   
 * @version V1.0 
 * @Copyright: 2018 clps.com Inc. All rights reserved. 
 */
package com.clps.bj.mms.common.util.data;

import com.clps.bj.mms.sm.entity.Menu;
import com.clps.bj.mms.sm.entity.MenuPermission;
import com.clps.bj.mms.sm.entity.Permission;
import com.clps.bj.mms.sm.entity.Role;
import com.clps.bj.mms.sm.entity.RoleMenuPermission;
import com.clps.bj.mms.sm.vo.MenuPermissionInfo;
import com.clps.bj.mms.sm.vo.PermissionInfo;
import com.clps.bj.mms.sm.vo.RoleMenuPermissionInfo;

/**
 * @ClassName: GrantVOHelper
 * @Description:权限模块实体类与vo实体类转换
 * @author: snow.y
 * @date: 2018年2月1日 上午12:21:34
 * @version
 */
public class GrantVOHelper {
	private PermissionInfo permissionInfo = null;
	private Permission permission = null;
	private MenuPermissionInfo menuPermissionInfo = null;
	private MenuPermission menuPermission = null;
	private RoleMenuPermission roleMenuPermission = null;
	private RoleMenuPermissionInfo roleMenuPermissionInfo = null;

	/**
	 * 
	 * @Description 将Permission对象封装成vo对象
	 * @param permission
	 * @return PermissionInfo Permission的vo对象
	 *
	 */
	public PermissionInfo permissionToPermissionInfo(Permission permission) {
		permissionInfo = new PermissionInfo();
		permissionInfo.setPmsnId(permission.getPmsnId());
		permissionInfo.setPmsnName(permission.getPmsnName());
		permissionInfo.setPmsnUrl(permission.getPmsnUrl());
		permissionInfo.setPmsnDescription(permission.getPmsnDescription());
		permissionInfo.setPmsnCreateId(permission.getPmsnCreateId());
		permissionInfo.setPmsnCreateDatetime(permission.getPmsnCreateDatetime());
		permissionInfo.setPmsnUimId(permission.getPmsnUimId());
		permissionInfo.setPmsnUpdateTime(permission.getPmsnUpdateTime());
		return permissionInfo;
	}

	public Permission permissionInfoToPermission(PermissionInfo permissionInfo) {
		permission = new Permission();
		permission.setPmsnId(permissionInfo.getPmsnId());
		permission.setPmsnName(permissionInfo.getPmsnName());
		permission.setPmsnUrl(permissionInfo.getPmsnUrl());
		permission.setPmsnDescription(permissionInfo.getPmsnDescription());
		permission.setPmsnCreateId(permissionInfo.getPmsnCreateId());
		permission.setPmsnCreateDatetime(permissionInfo.getPmsnCreateDatetime());
		permission.setPmsnUimId(permissionInfo.getPmsnUimId());
		permission.setPmsnUpdateTime(permissionInfo.getPmsnUpdateTime());
		return permission;
	}

	public MenuPermissionInfo menuPermissionToMenuPermissionInfo(MenuPermission menuPermission) {
		menuPermissionInfo = new MenuPermissionInfo();

		menuPermissionInfo.setMpId(menuPermission.getMpId());
		if (menuPermission.getMenu() != null) {
			menuPermissionInfo.setMenuId(menuPermission.getMenu().getMenuId());
			menuPermissionInfo.setMenuName(menuPermission.getMenu().getMenuName());
		} else {
			menuPermissionInfo.setMenuId(null);
			menuPermissionInfo.setMenuName(null);
		}
		if (menuPermission.getPermission() != null) {
			menuPermissionInfo.setPermissionId(menuPermission.getPermission().getPmsnId());
			menuPermissionInfo.setPermissionName(menuPermission.getPermission().getPmsnName());
			menuPermissionInfo.setPermissionUrl(menuPermission.getPermission().getPmsnUrl());
		} else {
			menuPermissionInfo.setPermissionId(null);
			menuPermissionInfo.setPermissionName(null);
			menuPermissionInfo.setPermissionUrl(null);
		}
		menuPermissionInfo.setMpCreateId(menuPermission.getMpCreateId());
		menuPermissionInfo.setMpCreateDatetime(menuPermission.getMpCreateDatetime());
		menuPermissionInfo.setMpUpdateUid(menuPermission.getMpUpdateUid());
		menuPermissionInfo.setMpUpdateTime(menuPermission.getMpUpdateTime());
		return menuPermissionInfo;
	}

	public MenuPermission menuPermissionInfoToMenuPermission(MenuPermissionInfo menuPermissionInfo) {

		menuPermission = new MenuPermission();
		menuPermission.setMpId(menuPermissionInfo.getMpId());
		Menu menu = new Menu();
		menu.setMenuId(menuPermissionInfo.getMenuId());
		menuPermission.setMenu(menu);
		permission = new Permission();
		permission.setPmsnName(menuPermissionInfo.getPermissionName());
		permission.setPmsnUrl(menuPermissionInfo.getPermissionUrl());
		permission.setPmsnId(menuPermissionInfo.getPermissionId());
		menuPermission.setMenu(menu);
		menuPermission.setPermission(permission);
		menuPermission.setMpCreateId(menuPermissionInfo.getMpCreateId());
		menuPermission.setMpCreateDatetime(menuPermissionInfo.getMpCreateDatetime());
		menuPermission.setMpUpdateUid(menuPermissionInfo.getMpUpdateUid());
		menuPermission.setMpUpdateTime(menuPermissionInfo.getMpUpdateTime());
		return menuPermission;

	}

	public RoleMenuPermissionInfo roleMenuPermissionToRoleMenuPermissionInfo(RoleMenuPermission roleMenuPermission) {
		roleMenuPermissionInfo = new RoleMenuPermissionInfo();
		roleMenuPermissionInfo.setRmpId(roleMenuPermission.getRmpId());
		if (roleMenuPermission.getRole() != null) {
			roleMenuPermissionInfo.setRoleId(roleMenuPermission.getRole().getRoleId());
			roleMenuPermissionInfo.setRoleName(roleMenuPermission.getRole().getRoleName());
		} else {
			roleMenuPermissionInfo.setRoleId(null);
			roleMenuPermissionInfo.setRoleName(null);
		}
		if (roleMenuPermission.getMenuPermission() != null)
			roleMenuPermissionInfo.setMenuPermissionId(roleMenuPermission.getMenuPermission().getMpId());
		else
			roleMenuPermissionInfo.setMenuPermissionId(null);
		roleMenuPermissionInfo.setRmpCreateUid(roleMenuPermission.getRmpCreateUid());
		roleMenuPermissionInfo.setRmpCreateDatetime(roleMenuPermission.getRmpCreateDatetime());
		roleMenuPermissionInfo.setRmpUimId(roleMenuPermission.getRmpUimId());
		roleMenuPermissionInfo.setRmpUpdatetime(roleMenuPermission.getRmpUpdatetime());
		return roleMenuPermissionInfo;
	}

	public RoleMenuPermission roleMenuPermissionInfoToRoleMenuPermission(RoleMenuPermissionInfo roleMenuPermissionInfo) {
		roleMenuPermission = new RoleMenuPermission();
		roleMenuPermission.setRmpId(roleMenuPermissionInfo.getRmpId());
		Role role = new Role();
		role.setRoleId(roleMenuPermissionInfo.getRoleId());
		roleMenuPermission.setRole(role);
		menuPermission = new MenuPermission();
		menuPermission.setMpId(roleMenuPermissionInfo.getMenuPermissionId());
		roleMenuPermission.setMenuPermission(menuPermission);
		roleMenuPermission.setRmpCreateUid(roleMenuPermissionInfo.getRmpCreateUid());
		roleMenuPermission.setRmpCreateDatetime(roleMenuPermissionInfo.getRmpCreateDatetime());
		roleMenuPermission.setRmpUimId(roleMenuPermissionInfo.getRmpUimId());
		roleMenuPermission.setRmpUpdatetime(roleMenuPermissionInfo.getRmpUpdatetime());
		return roleMenuPermission;
	}
}
