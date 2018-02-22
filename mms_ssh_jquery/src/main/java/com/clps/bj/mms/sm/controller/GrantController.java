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
import java.util.HashSet;
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
import com.clps.bj.mms.sm.vo.MenuPermissionInfo;
import com.clps.bj.mms.sm.vo.MyInfo;
import com.clps.bj.mms.sm.vo.PermissionInfo;
import com.clps.bj.mms.sm.vo.RoleMenuPermissionInfo;

/**
 * @ClassName: GrantController
 * @Description:权限管理模块 数据控制层 REST风格
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
	 * @Description 所有角色列表
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
			map.put("url", "/clps_mms/sm/grantview/showMenuPemsn/" + role.getRoleId());
			item.add(map);

		}
		return new ResponseEntity<List<Map<String, Object>>>(item, HttpStatus.OK);
	}

	/**
	 * 
	 * @Description 所有权限列表
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
	 * @Description 根据id获取权限
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
	 * @Description 搜索权限
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
	 * @Description 增加权限
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
	 * @Description 修改权限
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
	 * @Description 删除权限
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
	 * @Description 					   查询 角色菜单权限tree
	 * @param roleId					   角色id
	 * @return ResponseEntity<String>    json字符串   
	 *
	 */
	@PostMapping(value = "/getMenuPmsn/{roleId}", produces = "text/html;charset=utf-8")
	public ResponseEntity<String> getMenuPermissionByRoleId(@PathVariable("roleId") Integer roleId) {
		RoleMenuPermissionInfo roleMenuPermissionInfo = new RoleMenuPermissionInfo();
		roleMenuPermissionInfo.setRoleId(roleId);
		MyInfo father = igs.getCheckMenu(roleMenuPermissionInfo);
		String str = JSON.toJSONString(father);
		String s = str.replaceAll("nodes", "children");
		String st = s.replaceAll("name", "text");
		String f = "[" + st + "]";
		System.out.println(f);
		return new ResponseEntity<String>(f, HttpStatus.OK);

	}
	/**
	 * 
	 * @Description 					获取角色已有菜单的权限
	 * @param roleId					角色id
	 * @param menuId					菜单id
	 * @return ResponseEntity<String>   json字符串    
	 *
	 */
	@PostMapping(value = "/getMenuPermission/{roleId}/{menuId}", produces = "text/html;charset=utf-8")
	public ResponseEntity<String> getMenuPermissionByMenuId(@PathVariable("roleId") Integer roleId,
			@PathVariable("menuId") Integer menuId) {
		MenuPermissionInfo mp = new MenuPermissionInfo();
		mp.setMenuId(menuId);
		//根据菜单id获取权限
		List<PermissionInfo> list = igs.getMenuPermissionByMenuId(mp);
		MenuPermissionInfo mp2 = null;
		HashSet<Integer> mpId = new HashSet<>();
		//查询这个菜单权限id
		for (int i = 0; i < list.size(); i++) {
			mp2 = new MenuPermissionInfo();
			mp2.setMenuId(menuId);
			mp2.setPermissionId(list.get(i).getPmsnId());
			mpId.add(igs.getSearchMenuPmsn(mp2).getMpId());
		}

		RoleMenuPermissionInfo roleMenuPermissionInfo = new RoleMenuPermissionInfo();
		roleMenuPermissionInfo.setRoleId(roleId);
		List<Integer> item = new ArrayList<>();
		//查出角色已有的菜单权限id
		List<RoleMenuPermissionInfo> mpInfo = igs.getRoleMenuPermissionByRoleId(roleMenuPermissionInfo);
		for (RoleMenuPermissionInfo roleMenuPermissionInfo2 : mpInfo) {
			if (mpId.contains(roleMenuPermissionInfo2.getMenuPermissionId())) {
				item.add(roleMenuPermissionInfo2.getMenuPermissionId());
			}
		}
		//已存在的权限id
		HashSet<String> pmsnId = new HashSet<>();
		for (Integer id : item) {
			mp2 = new MenuPermissionInfo();
			mp2.setMpId(id);
			pmsnId.add(igs.getMenuPermissionById(mp2).getPermissionId());
		}
		String pmsnid = null;
		List<PermissionInfo> check = new ArrayList<>();
		//勾选已拥有的权限
		PermissionInfo pi = null;
		for (int i = 0; i < list.size(); i++) {
			pmsnid = list.get(i).getPmsnId();
			pi = list.get(i);
			if (pmsnId.contains(pmsnid)) {
				pi.setIschecked(true);
			}
			check.add(pi);
		}
		//转成ligerUI tree所需字段
		String str = JSON.toJSONString(check);
		String s = str.replaceAll("pmsnName", "text");
		String st = s.replaceAll("pmsnUrl", "url");
		return new ResponseEntity<String>(st, HttpStatus.OK);
	}

	//保存角色菜单权限
	@PostMapping(value = "/updataRoleMenuPmsn/{roleId}")
	public ResponseEntity<Map<String, Object>> updateRoleMenuPermissionByRoleId(@PathVariable("roleId") Integer roleId,
			Integer menuId, String pmsnId) {
		String time = UtilFactory.getInstanceOfNowTimeFormat().getNowTime();
		RoleMenuPermissionInfo roleMenuPermissionInfo = new RoleMenuPermissionInfo();
		roleMenuPermissionInfo.setRoleId(roleId);
		roleMenuPermissionInfo.setRmpCreateDatetime(time);
		//从session获取
		roleMenuPermissionInfo.setRmpCreateUid(1);
		//从session获取
		roleMenuPermissionInfo.setRmpUimId(1);
		roleMenuPermissionInfo.setRmpUpdatetime(time);
		MenuPermissionInfo mp = new MenuPermissionInfo();
		mp.setMenuId(menuId);
		mp.setPermissionId(pmsnId);
		MenuPermissionInfo mpInfo = igs.getSearchMenuPmsn(mp);
		roleMenuPermissionInfo.setMenuPermissionId(mpInfo.getMpId());
		igs.addRoleMenuPermission(roleMenuPermissionInfo);
		Map<String, Object> map = new HashMap<>();
		map.put("msg", "修改成功");
		return new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);

	}
	/**
	 * 
	 * @Description 				删除角色的所有权限
	 * @param roleId				角色id
	 * @return ResponseEntity<Map<String,Object>>       
	 *
	 */
	@PostMapping(value = "/deleteRoleMenuPmsn/{roleId}")
	public ResponseEntity<Map<String, Object>> updateRoleMenuPermissionByRoleId(
			@PathVariable("roleId") Integer roleId) {
		RoleMenuPermissionInfo roleMenuPermissionInfo = new RoleMenuPermissionInfo();
		roleMenuPermissionInfo.setRoleId(roleId);
		igs.deleteRoleMenuPermission(roleMenuPermissionInfo);
		Map<String, Object> map = new HashMap<>();
		map.put("msg", "修改成功");
		return new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
	}
}