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
 * @ClassName:  GrantJspController   
 * @Description:TODO
 * @author:     snow.y
 * @date:       2018年2月2日 上午9:16:40 
 * @version  
 */
@Controller
@RequestMapping("/sm/grantview")
public class GrantJspController {
@RequestMapping("/showAllPmsn")
public String allPermission(){
	return "permissionMenu";
}
@RequestMapping("/index")
public String test2() {
	return "index";
}
@RequestMapping("/showAddPmsn")
public String addPermission(){
	return "addPermission";
}
@RequestMapping("/showUpdatePmsn")
public String updatePermission(){
	return "updatePermission";
}
@RequestMapping("/showSearchPmsn")
public String searchPermission(){
	return "searchPermission";
}
@RequestMapping("/showRoleMenuPmsn")
public String allRoleMenuPermission(){
	return "roleMenuPermission";
}
@RequestMapping("/showMenuPemsn/{roleId}")
public String showMenuPmsnByRole(@PathVariable("roleId")Integer roleId,Model model){
	model.addAttribute("roleId", roleId);
	
	return "role_menuPmsn";
}
@RequestMapping("/test")
public String showHello(){
	return "hello";
}
}
