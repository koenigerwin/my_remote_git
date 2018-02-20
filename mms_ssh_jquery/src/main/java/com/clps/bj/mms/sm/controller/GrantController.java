/**  
 * @Title:  GrantController.java   
 * @Package com.clps.bj.mms.sm.controller   
 * @Description: 权限管理模块控制层
 * @author: snow.y     
 * @date:   2018年2月1日 下午4:54:12   
 * @version V1.0 
 * @Copyright: 2018 clps.com Inc. All rights reserved. 
 */
package com.clps.bj.mms.sm.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.clps.bj.mms.common.util.factory.UtilFactory;
import com.clps.bj.mms.sm.entity.Role;
import com.clps.bj.mms.sm.service.IGrantService;
import com.clps.bj.mms.sm.service.IMenuService;
import com.clps.bj.mms.sm.service.IRoleService;
import com.clps.bj.mms.sm.vo.MyInfo;
import com.clps.bj.mms.sm.vo.PermissionInfo;
import com.clps.bj.mms.sm.vo.RoleMenuPermissionInfo;

/**
 * @ClassName: GrantController
 * @Description:权限管理模块控制层
 * @author: snow.y
 * @date: 2018年2月1日 下午4:54:12
 * @version V 1.0.0
 */
@RestController
@RequestMapping("/sm/grant")
public class GrantController {
	@Autowired
	IRoleService irs;
	@Autowired
	IGrantService igs;
	@Autowired
	IMenuService ims;
    /**
     * 
     * @Description 						所有角色列表
     * @return ResponseEntity<List<Map<String,Object>>>       
     */
	@PostMapping("/listRole")
	public ResponseEntity<List<Map<String, Object>>> listAllRole() {
		List<Role> list = irs.queryAllRoleName();
		Map<String, Object> map = null;
		List<Map<String, Object>> item = new ArrayList<>();
		for (Role role : list) {
			map = new HashMap<>();
			map.put("text", role.getRoleName());
			map.put("url", "../grantview/showMenuPemsn/" + role.getRoleId());
			/*
			 * map.put("roleId",role.getRoleId());
			 * map.put("roleName",role.getRoleName());
			 */
			item.add(map);
		}
		return new ResponseEntity<List<Map<String, Object>>>(item, HttpStatus.OK);
	}
      /**
       * 
       * @Description 								所有权限列表
       * @return ResponseEntity<Map<String,Object>>       
       */
	@GetMapping("/listAllPmsn")
	public ResponseEntity<Map<String, Object>> listAllPermission() {
		Map<String, Object> mapJson = new HashMap<>();
		List<PermissionInfo> map = igs.getAllPermission();
	   Long count = igs.getPermissionTotal();
		mapJson.put("Rows", map);
		mapJson.put("Total", count);
		return new ResponseEntity<Map<String, Object>>(mapJson, HttpStatus.OK);
	}
	  /**
	   * 
	   * @Description 								根据id获取权限
 	   * @param permissionInfo
	   * @return ResponseEntity<PermissionInfo>       
	   */
	@GetMapping("/getPmsnById")
	public ResponseEntity<PermissionInfo> getPermissionById(PermissionInfo permissionInfo) {
		System.out.println(permissionInfo);
		PermissionInfo pInfo = igs.getPermissionByID(permissionInfo);
		return new ResponseEntity<PermissionInfo>(pInfo, HttpStatus.OK);
	}
	/**
	 * 
	 * @Description 								搜索权限		
	 * @param permissionInfo
	 * @return ResponseEntity<Map<String,Object>>       
	 */
	@PostMapping("/searchPmsn")
	public ResponseEntity<Map<String, Object>> searchPermissionByParse(PermissionInfo permissionInfo) {
		System.out.println(permissionInfo.toString());
		Map<String, Object> mapJson = new HashMap<>();
		List<PermissionInfo> map = igs.getSearchPermission(permissionInfo);
		int count = map.size();
		mapJson.put("Rows", map);
		mapJson.put("Total", count);
		return new ResponseEntity<Map<String, Object>>(mapJson, HttpStatus.OK);
	}
/**
 * 
 * @Description 									增加权限
 * @param permissionInfo
 * @return ResponseEntity<Map<String,String>>       
 */
	@PostMapping("/addPmsn")
	public ResponseEntity<Map<String, String>> addPermission(PermissionInfo permissionInfo) {
		System.out.println(permissionInfo);
		String time = UtilFactory.getInstanceOfNowTimeFormat().getNowTime();
		permissionInfo.setPmsnCreateDatetime(time);
		permissionInfo.setPmsnCreateId(1);
		permissionInfo.setPmsnUimId(1);
		permissionInfo.setPmsnUpdateTime(time);
		System.out.println(permissionInfo);
		boolean flag = igs.addPermission(permissionInfo);
		Map<String, String> map = new HashMap<>();
		if (flag) {
			map.put("msg", "添加成功");
		} else {
			map.put("msg", "添加失败");
		}
		return new ResponseEntity<Map<String, String>>(map, HttpStatus.OK);
	}
	/**
	 * 
	 * @Description 								修改权限
	 * @param permissionInfo
	 * @return ResponseEntity<Map<String,String>>       
	 */
	@PostMapping("/updatePmsn")
	public ResponseEntity<Map<String, String>> updatePermission(PermissionInfo permissionInfo) {
		String time = UtilFactory.getInstanceOfNowTimeFormat().getNowTime();
		permissionInfo.setPmsnUimId(1);
		permissionInfo.setPmsnUpdateTime(time);
		System.out.println(permissionInfo);
		boolean flag = igs.updatePermission(permissionInfo);
		Map<String, String> map = new HashMap<>();
		if (flag) {
			map.put("msg", "修改成功");
		} else {
			map.put("msg", "修改失败");
		}
		return new ResponseEntity<Map<String, String>>(map, HttpStatus.OK);
	}
		/**
		 * 
		 * @Description 							删除权限
		 * @param permissionInfo
		 * @return ResponseEntity<Map<String,String>>       
		 */
	@PostMapping("/deletePmsn")
	public ResponseEntity<Map<String, String>> deletePermission(PermissionInfo permissionInfo) {
		boolean flag = igs.deletePermission(permissionInfo);
		Map<String, String> map = new HashMap<>();
		if (flag) {
			map.put("msg", "删除成功");
		} else {
			map.put("msg", "删除失败");
		}
		return new ResponseEntity<Map<String, String>>(map, HttpStatus.OK);
	}
/**
 * 
 * @Description 								查询角色的菜单和权限
 * @param roleId
 * @return ResponseEntity<List<MenuPermissionInfo>>       
 */
	/*@PostMapping("/getMenuPmsn/{roleId}")
	public ResponseEntity<MyInfo> getMenuPermissionByRoleId(@PathVariable("roleId") Integer roleId) {
		
		RoleMenuPermissionInfo roleMenuPermissionInfo = new RoleMenuPermissionInfo();
		roleMenuPermissionInfo.setRoleId(roleId);
	    MyInfo father = igs.getRoleMenusAndPermissions(roleMenuPermissionInfo);
	    
		return new ResponseEntity<MyInfo>(father, HttpStatus.OK);
	}*/
	@PostMapping(value="/getMenuPmsn2/{roleId}",produces="text/html;charset=utf-8")
	public ResponseEntity<String> getMenuPermissionByRoleId2(@PathVariable("roleId") Integer roleId) {
		RoleMenuPermissionInfo roleMenuPermissionInfo = new RoleMenuPermissionInfo();
		roleMenuPermissionInfo.setRoleId(roleId);
	    MyInfo father = igs.getRoleMenusAndPermissions(roleMenuPermissionInfo);
		String str = JSON.toJSONString(father);
	    String s = str.replaceAll("nodes", "children");
	    String st = s.replaceAll("name", "text");
	    String f="["+st+"]";
		System.out.println(f);
		return new ResponseEntity<String>(f,HttpStatus.OK);
	
}
}