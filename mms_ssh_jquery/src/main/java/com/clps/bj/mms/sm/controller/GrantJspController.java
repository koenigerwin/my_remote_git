/**  
 * @Title:  GrantJspController.java   
 * @Package com.clps.bj.mms.sm.controller   
 * @Description:    grant jsp转接层
 * @author: snow.y     
 * @date:   2018年2月2日 上午9:16:40   
 * @version V1.0 
 * @Copyright: 2018 clps.com Inc. All rights reserved. 
 */
package com.clps.bj.mms.sm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @ClassName: GrantJspController
 * @Description:权限模块视图控制层
 * @author: snow.y
 * @date: 2018年2月2日 上午9:16:40
 * @version V1.0.0
 */
@Controller
@RequestMapping("/sm/grantview")
public class GrantJspController {
	/**
	 * 
	 * @Description    展示所有权限的jsp
	 * @return String       
	 *
	 */
	@RequestMapping("/showAllPmsn")
	public String allPermission() {
		return "permissionMenu";
	}
	/**
	 * 
	 * @Description    增加权限的jsp   
	 * @return String       
	 *
	 */
	@RequestMapping("/showAddPmsn")
	public String addPermission() {
		return "addPermission";
	}
    /**
     * 
     * @Description		修改权限的jsp
     * @return String       
     *
     */
	@RequestMapping("/showUpdatePmsn")
	public String updatePermission() {
		return "updatePermission";
	}
	/**
	 * 
	 * @Description 	     搜索权限的jsp
	 * @return String       
	 *
	 */
	@RequestMapping("/showSearchPmsn")
	public String searchPermission() {
		return "searchPermission";
	}
	/**
	 * 
	 * @Description 	展示所有角色
	 * @return String       
	 *
	 */
	@RequestMapping("/showRoleMenuPmsn")
	public String allRoleMenuPermission() {
		return "roleMenuPermission";
	}
    /**
     * 
     * @Description 	 展示角色的菜单权限jsp
     * @param roleId	角色id
     * @param model
     * @return String       
     *
     */
	@RequestMapping("/showMenuPemsn/{roleId}")
	public String showMenuPmsnByRole(@PathVariable("roleId") Integer roleId, Model model) {
		model.addAttribute("roleId", roleId);

		return "role_menuPmsn";
	}
}
