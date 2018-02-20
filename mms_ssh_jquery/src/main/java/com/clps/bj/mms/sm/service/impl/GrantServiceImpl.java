/**  
 * All rights Reserved, Designed By www.tydic.com
 * @Title:  GrantService.java   
 * @Package com.clps.bj.mms.sm.service.impl   
 * @Description:    权限逻辑层
 * @author: snow     
 * @date:   2018年1月23日 上午10:45:11   
 * @version V1.0 
 * @Copyright: 2018 clps.com Inc. All rights reserved. 
 */
package com.clps.bj.mms.sm.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clps.bj.mms.common.util.data.GrantVOHelper;
import com.clps.bj.mms.common.util.data.MyJson;
import com.clps.bj.mms.common.util.factory.UtilFactory;
import com.clps.bj.mms.sm.dao.MenuPermissionDao;
import com.clps.bj.mms.sm.dao.PermissionDao;
import com.clps.bj.mms.sm.dao.RoleMenuPermissionDao;
import com.clps.bj.mms.sm.entity.MenuPermission;
import com.clps.bj.mms.sm.entity.Permission;
import com.clps.bj.mms.sm.entity.RoleMenuPermission;
/*import com.clps.bj.mms.sm.entity.UserInfoMain;*/
import com.clps.bj.mms.sm.service.IGrantService;
import com.clps.bj.mms.sm.service.IMenuService;
import com.clps.bj.mms.sm.vo.MenuPermissionInfo;
import com.clps.bj.mms.sm.vo.MyInfo;
import com.clps.bj.mms.sm.vo.PermissionInfo;
import com.clps.bj.mms.sm.vo.RoleMenuPermissionInfo;

/**
 * @ClassName: GrantService
 * @Description:权限逻辑层
 * @author: snow.y
 * @date: 2018年1月25日 下午16:45:11
 * @version V 1.0.5
 */
@Service
public class GrantServiceImpl implements IGrantService {
	@Autowired
	private RoleMenuPermissionDao rmpI;// RoleMenuPermission接口实现层
	@Resource
	private PermissionDao pdI;// PermissionDao接口实现层
	@Autowired
	private MenuPermissionDao mpd;// MenuPermissionDao接口实现层
	@Autowired
	IMenuService ims;//菜单业务层
/*	@Autowired
	private UserInfoMainServiceImpl umi;*/
	
	private Map<String, List<PermissionInfo>> permissionCache;// 权限缓存
	private Map<Integer, List<RoleMenuPermissionInfo>> roleMenuPermissionCache;// 角色菜单权限关系的缓存
	private Map<Integer, List<PermissionInfo>> menuPermissionCache;// 菜单权限关系的缓存
	private volatile Boolean flag;// 判断标志
	private GrantVOHelper grantVOHelper = UtilFactory.getInstanceOfGrantVOHelper();// 实体类封装vo工具类
	private Logger log = Logger.getLogger(GrantServiceImpl.class);// 日志
	private Permission permission = null;// permission对象
	private MenuPermission menuPermission = null;// 菜单权限实体类对象
	private RoleMenuPermission roleMenuPermission = null;// 角色菜单权限实体类对象
	private List<PermissionInfo> listPmsnInfo = null;// 权限vo列表
	private List<MenuPermissionInfo> listMenuPmsnInfo = null;// 菜单权限vo列表
	private List<RoleMenuPermissionInfo> listRoleMenuPermissionInfo = null;// 角色菜单权限vo列表
	/**
	 * @Title: GrantService
	 * @Description:初始化缓存
	 */
	@PostConstruct
	public void Init() {
		permissionCache = allPermission();
		roleMenuPermissionCache = allRoleMenuPermission();
		menuPermissionCache = allMenuPermission();
	}

	/*
	 * @param permossion
	 * 
	 * @return
	 * 
	 * @see
	 * com.clps.bj.mms.sm.service.IGrantService#addPermission(com.clps.bj.mms.sm
	 * .entity.Permission)
	 */
	@Override
	public boolean addPermission(PermissionInfo permissionInfo) {
		// 判断缓存中是否存在这个权限
		flag = iscontainsPermission(permissionInfo);
		if (flag) {
			// 存在权限的名字 返回false
			log.info("权限的名字已存在,添加失败");
			return false;
		}
		// 将vo转换成实体类
		permission = grantVOHelper.permissionInfoToPermission(permissionInfo);
		// 不存在则添加
		flag = pdI.addPermission(permission);
		if (flag)
			// 将缓存和数据库同步
			flushPermissionCache();
		return flag;
	}

	/*
	 * @param permossion
	 * 
	 * @return
	 * 
	 * @see com.clps.bj.mms.sm.service.IGrantService#deletePermission(java.lang.
	 * Integer)
	 */
	@Override
	public boolean deletePermission(PermissionInfo permissionInfo) {
	
		// 将vo转换成实体类
		permission = grantVOHelper.permissionInfoToPermission(permissionInfo);
		// 存在则删除
		flag = pdI.deletePermission(permission);
		if (flag)
			// 将缓存和数据库同步
			flushPermissionCache();
		return flag;
	}

	/*
	 * @param permission
	 * 
	 * @return
	 * 
	 * @see
	 * com.clps.bj.mms.sm.service.IGrantService#updatePermission(com.clps.bj.mms
	 * .sm.entity.Permission)
	 */
	@Override
	public boolean updatePermission(PermissionInfo permissionInfo) {
		// 将vo转换成实体类
		permission = grantVOHelper.permissionInfoToPermission(permissionInfo);
		// 不存在则进行修改
		flag = pdI.updatePermission(permission);
		if (flag)
			// 将缓存和数据库同步
			flushPermissionCache();
		return flag;
	}

	/*
	 * @return
	 * 
	 * @see com.clps.bj.mms.sm.service.IGrantService#getAllPermission()
	 */
	@Override
	public List<PermissionInfo> getAllPermission() {
		List<Permission> list = pdI.getAllPermission();
		listPmsnInfo = new ArrayList<>();
		PermissionInfo permissionInfo = null;
		for (Permission permission : list) {
			// 调用VO实体类,set需要的参数
			permissionInfo = grantVOHelper.permissionToPermissionInfo(permission);
		/*	Map<Integer,UserInfoMain> map = umi.getAllUserInfoMainByMap();*/
		/*	permissionInfo.setPmsnCreateName(map.get(permissionInfo.getPmsnCreateId()).getUserName());
			permissionInfo.setPmsnUimName(map.get(permissionInfo.getPmsnUimId()).getUserName());*/
			listPmsnInfo.add(permissionInfo);
		}
		return listPmsnInfo;
	}

	/**
	 * 
	 * @Description 权限缓存类
	 * @return Map<String,Permission>
	 *
	 */
	public Map<String, List<PermissionInfo>> allPermission() {
		// 查询出所有的权限
		listPmsnInfo = getAllPermission();
		Map<String, List<PermissionInfo>> map = new HashMap<>();
		List<PermissionInfo> list =null;
		String pmsnName = null;
		for (PermissionInfo permissionInfo : listPmsnInfo) {
			// 将权限信息放入map k为权限名 v为权限实体类对象
			pmsnName = permissionInfo.getPmsnName();
			if(map.containsKey(pmsnName)){
				list = map.get(pmsnName);
				list.add(permissionInfo);
			}
			else{
				list = new ArrayList<>();
				list.add(permissionInfo);
			}
			map.put(pmsnName, list);
		}
		log.info(map.toString());
		return map;
	}

	/*
	 * @param permossion
	 * 
	 * @return
	 * 
	 * @see
	 * com.clps.bj.mms.sm.service.IGrantService#getPermissionByID(com.clps.bj.
	 * mms.sm.entity.Permission)
	 */
	@Override
	public PermissionInfo getPermissionByID(PermissionInfo permissionInfo) {

		PermissionInfo pInfo = null;
		
			// 将vo转换成实体类
			permission = grantVOHelper.permissionInfoToPermission(permissionInfo);
			// 缓存中不存在,从数据库中查找
			Permission per = pdI.getPermissionByID(permission);
			pInfo = grantVOHelper.permissionToPermissionInfo(per);
			// 更新缓存
			flushPermissionCache();
		
		log.info(pInfo.toString());
		return pInfo;
	}
	/* 
	 * @param permissionInfo
	 * @return      
	 * @see com.clps.bj.mms.sm.service.IGrantService#searchPermission(com.clps.bj.mms.sm.vo.PermissionInfo)
	 */
	@Override
	public List<PermissionInfo> getSearchPermission(PermissionInfo permissionInfo) {
		PermissionInfo pInfo = null;
			// 将vo转换成实体类
		Permission permission2 = grantVOHelper.permissionInfoToPermission(permissionInfo);
		System.out.println(permission2.toString());
		// 缓存中不存在,从数据库中查找
		List<Permission> list = pdI.getSearchPermission(permission2);
		List<PermissionInfo > item = new ArrayList<>();
		for (Permission permission : list) {
			pInfo = grantVOHelper.permissionToPermissionInfo(permission);
			item.add(pInfo);
		}
		// 更新缓存
		flushPermissionCache();
	log.info(item.toString());
	return item;
	}
	/*
	 * @param rmp
	 * 
	 * @return
	 * 
	 * @see
	 * com.clps.bj.mms.sm.service.IGrantService#addRoleMenuPermission(com.clps.
	 * bj.mms.sm.entity.RoleMenuPermission)
	 */
	@Override
	public boolean addRoleMenuPermission(RoleMenuPermissionInfo roleMenuPermissionInfo) {
		// 判断是否存在这个角色权限关系
		flag = iscontainsRoleMenuPermission(roleMenuPermissionInfo);
		if (flag) {
			log.info("该角色已存在该权限,添加失败!");
			return false;
		}
		// 将vo转换成实体类
		roleMenuPermission = grantVOHelper.roleMenuPermissionInfoToRoleMenuPermission(roleMenuPermissionInfo);
		// 不存在则添加
		flag = rmpI.addRoleMenuPermission(roleMenuPermission);
		if (flag)
			// 更新缓存
			flushRoleMenuPermissionCache();
		return flag;
	}

	/*
	 * @param rmp
	 * 
	 * @return
	 * 
	 * @see
	 * com.clps.bj.mms.sm.service.IGrantService#deleteRoleMenuPermission(com.
	 * clps.bj.mms.sm.entity.RoleMenuPermission)
	 */
	@Override
	public boolean deleteRoleMenuPermission(RoleMenuPermissionInfo roleMenuPermissionInfo) {
		// 判断是否存在这个角色权限关系
		flag = iscontainsRoleMenuPermission(roleMenuPermissionInfo);
		if (!flag) {
			log.info("不存在这个角色权限关系,删除失败!");
			return false;
		}
		// 将vo转换成实体类
		roleMenuPermission = grantVOHelper.roleMenuPermissionInfoToRoleMenuPermission(roleMenuPermissionInfo);
		// 存在则删除
		flag = rmpI.deleteRoleMenuPermission(roleMenuPermission);
		if (flag)
			// 更新缓存
			flushRoleMenuPermissionCache();
		return flag;
	}

	/*
	 * @param rmp
	 * 
	 * @return
	 * 
	 * @see
	 * com.clps.bj.mms.sm.service.IGrantService#updateRoleMenuPermission(com.
	 * clps.bj.mms.sm.entity.RoleMenuPermission)
	 */
	@Override
	public boolean updateRoleMenuPermission(RoleMenuPermissionInfo roleMenuPermissionInfo) {
		// 判断是否存在这个新的角色权限关系
		flag = iscontainsRoleMenuPermission(roleMenuPermissionInfo);
		if (flag) {
			log.info("该角色已存在这个菜单权限,修改失败");
			return false;
		}
		// 将vo转换成实体类
		roleMenuPermission = grantVOHelper.roleMenuPermissionInfoToRoleMenuPermission(roleMenuPermissionInfo);
		// 不存在则修改
		flag = rmpI.updateRoleMenuPermission(roleMenuPermission);
		if (flag)
			// 更新缓存
			flushRoleMenuPermissionCache();
		return flag;
	}

	/*
	 * @param rmp
	 * 
	 * @return
	 * 
	 * @see
	 * com.clps.bj.mms.sm.service.IGrantService#getRoleMenuPermissionById(com.
	 * clps.bj.mms.sm.entity.RoleMenuPermission)
	 */
	@Override
	public List<RoleMenuPermissionInfo> getRoleMenuPermissionByRoleId(RoleMenuPermissionInfo roleMenuPermissionInfo) {
		int rmoRoleId = roleMenuPermissionInfo.getRoleId();
		listRoleMenuPermissionInfo = null;
		// 从缓存中读取
		if (roleMenuPermissionCache.containsKey(rmoRoleId)) {
			// 实体类转vo
			listRoleMenuPermissionInfo = roleMenuPermissionCache.get(rmoRoleId);
		} else {
			// 将vo转换成实体类
			roleMenuPermission = grantVOHelper.roleMenuPermissionInfoToRoleMenuPermission(roleMenuPermissionInfo);
			// 获取所有实体类列表
			List<RoleMenuPermission> item = rmpI.getRoleMenuPermissionByRoleId(roleMenuPermission);
			listRoleMenuPermissionInfo = new ArrayList<>();
			for (RoleMenuPermission roleMenuPermission : item) {
				// 实体类转vo
				roleMenuPermissionInfo = grantVOHelper.roleMenuPermissionToRoleMenuPermissionInfo(roleMenuPermission);
				listRoleMenuPermissionInfo.add(roleMenuPermissionInfo);
			}
			// 缓存中不存在则从数据库中读取
			flushRoleMenuPermissionCache();
		}
		log.info(listRoleMenuPermissionInfo.toString());
		return listRoleMenuPermissionInfo;
	}

	/*
	 * @return
	 * 
	 * @see com.clps.bj.mms.sm.service.IGrantService#getAllRoleMenuPermission()
	 */
	@Override
	public List<RoleMenuPermissionInfo> getAllRoleMenuPermission() {
		// 获取所有实体类列表
		List<RoleMenuPermission> list = rmpI.getAllRoleMenuPermission();
		listRoleMenuPermissionInfo = new ArrayList<>();
		RoleMenuPermissionInfo roleMenuPermissionInfo = null;
		for (RoleMenuPermission roleMenuPermission : list) {
			// 实体类转vo
			roleMenuPermissionInfo = grantVOHelper.roleMenuPermissionToRoleMenuPermissionInfo(roleMenuPermission);
			listRoleMenuPermissionInfo.add(roleMenuPermissionInfo);
		}
		return listRoleMenuPermissionInfo;
	}

	/**
	 * 
	 * @Description 角色菜单权限缓存
	 * @return Map<Integer,List<RoleMenuPermission>>
	 *
	 */
	public Map<Integer, List<RoleMenuPermissionInfo>> allRoleMenuPermission() {
		// 以map存储角色菜单权限关系,k是角色id,v为角色菜单权限关系
		Map<Integer, List<RoleMenuPermissionInfo>> map = new HashMap<>();
		// 查询出全部的角色菜单权限关系
		List<RoleMenuPermissionInfo> list = getAllRoleMenuPermission();
		List<RoleMenuPermissionInfo> item = null;
		int rmpRoleId = 0;
		// 遍历全部关系
		for (RoleMenuPermissionInfo roleMenuPermissionInfo : list) {
			rmpRoleId = roleMenuPermissionInfo.getRoleId();
			// 当map中已存在这角色id时
			if (map.containsKey(rmpRoleId)) {
				// 得到这个key的value
				item = map.get(rmpRoleId);
				item.add(roleMenuPermissionInfo);
				map.put(rmpRoleId, item);
			}
			// 当角色id没在map中时
			else {
				// 将关系放到list中
				item = new ArrayList<>();
				item.add(roleMenuPermissionInfo);
				map.put(rmpRoleId, item);
			}

		}
		log.info(map.toString());
		return map;
	}

	/*
	 * @param permossion
	 * 
	 * @return
	 * 
	 * @see
	 * com.clps.bj.mms.sm.service.IGrantService#iscontainsPermission(com.clps.bj
	 * .mms.sm.entity.Permission)
	 */
	@Override
	public boolean iscontainsPermission(PermissionInfo permission) {
		 String name = permission.getPmsnName();
		 if(permissionCache.containsKey(name)){
			List<PermissionInfo> list = permissionCache.get(name);
			for (PermissionInfo permissionInfo : list) {
				if(permissionInfo.getPmsnUrl().equals(permission.getPmsnUrl())){
					return true;
				}
			}
		 }
		return false;

	}

	/*
	 * @param rmp
	 * 
	 * @return
	 * 
	 * @see
	 * com.clps.bj.mms.sm.service.IGrantService#iscontainsRoleMenuPermission(com
	 * .clps.bj.mms.sm.entity.RoleMenuPermission)
	 */
	@Override
	public boolean iscontainsRoleMenuPermission(RoleMenuPermissionInfo roleMenuPermissionInfo) {
		Integer rmpRoleId = roleMenuPermissionInfo.getRoleId();
		// 判断缓存中是否存在
		if (roleMenuPermissionCache.containsKey(rmpRoleId)) {
			List<RoleMenuPermissionInfo> list = roleMenuPermissionCache.get(rmpRoleId);
			Integer rmpMenuPermissionId = roleMenuPermissionInfo.getMenuPermissionId();
			if (rmpMenuPermissionId == null) {
				return true;
			} else {
				for (RoleMenuPermissionInfo roleMenuPermissionInfo2 : list) {
					// 存在这个菜单权限
					if (roleMenuPermissionInfo2.getMenuPermissionId() == rmpMenuPermissionId)
						return true;
				}
			}
		}
		return false;
	}

	/*
	 * @return
	 * 
	 * @see com.clps.bj.mms.sm.service.IGrantService#flushPermissionCache()
	 */
	@Override
	public void flushPermissionCache() {
		// 将新数据放到缓存
		permissionCache = allPermission();
	}

	/*
	 * @return
	 * 
	 * @see
	 * com.clps.bj.mms.sm.service.IGrantService#flushRoleMenuPermissionCache()
	 */
	@Override
	public void flushRoleMenuPermissionCache() {
		// 将新数据放到缓存
		roleMenuPermissionCache = allRoleMenuPermission();
	}

	/*
	 * @param menuPermission
	 * 
	 * @return
	 * 
	 * @see
	 * com.clps.bj.mms.sm.service.IGrantService#addMenuPermission(com.clps.bj.
	 * mms.sm.entity.MenuPermission)
	 */
	@Override
	public boolean addMenuPermission(MenuPermissionInfo menuPermissionInfo) {
		// 判断是否存在这个菜单权限关系
		flag = iscontainsMenuPermission(menuPermissionInfo);
		if (flag) {
			log.info("已存在该菜单权限关系,添加失败!");
			return false;
		}
		// 将vo转换成实体类
		menuPermission = grantVOHelper.menuPermissionInfoToMenuPermission(menuPermissionInfo);
		// 不存在则添加
		flag = mpd.addMenuPermission(menuPermission);
		if (flag)
			// 更新缓存
			flushMenuPermissionCache();
		return flag;
	}

	/*
	 * @param menuPermission
	 * 
	 * @return
	 * 
	 * @see
	 * com.clps.bj.mms.sm.service.IGrantService#deleteMenuPermission(com.clps.bj
	 * .mms.sm.entity.MenuPermission)
	 */
	@Override
	public boolean deleteMenuPermission(MenuPermissionInfo menuPermissionInfo) {

		// 将vo转换成实体类
		menuPermission = grantVOHelper.menuPermissionInfoToMenuPermission(menuPermissionInfo);
		flag = mpd.deleteMenuPermission(menuPermission);
		if (flag)
			// 更新缓存
			flushMenuPermissionCache();
		return flag;
	}

	/*
	 * @param menuPermission
	 * 
	 * @return
	 * 
	 * @see
	 * com.clps.bj.mms.sm.service.IGrantService#updateMenuPermission(com.clps.bj
	 * .mms.sm.entity.MenuPermission)
	 */
	@Override
	public boolean updateMenuPermission(MenuPermissionInfo menuPermissionInfo) {
		// 判断是否存在这个新的菜单权限关系
		flag = iscontainsMenuPermission(menuPermissionInfo);
		if (flag) {
			log.info("该菜单权限已存在,修改失败!");
			return false;
		}
		// 将vo转换成实体类
		menuPermission = grantVOHelper.menuPermissionInfoToMenuPermission(menuPermissionInfo);
		// 不存在则修改
		flag = mpd.updateMenuPermission(menuPermission);
		if (flag)
			// 更新缓存
			flushMenuPermissionCache();
		return flag;
	}

	/*
	 * @param menuPermission
	 * 
	 * @return
	 * 
	 * @see
	 * com.clps.bj.mms.sm.service.IGrantService#getMenuPermissionByMenuId(com.
	 * clps.bj.mms.sm.entity.MenuPermission)
	 */
	@Override
	public List<PermissionInfo> getMenuPermissionByMenuId(MenuPermissionInfo menuPermissionInfo) {
		int menId = menuPermissionInfo.getMenuId();
		listPmsnInfo = null;
		/*List<Permission> item = null;*/
		// 从缓存中读取
		if (menuPermissionCache.containsKey(menId)) {
			listPmsnInfo = menuPermissionCache.get(menId);
			System.out.println(menId);
			return listPmsnInfo;
		} else {
			List<PermissionInfo> list = new ArrayList<>();
			System.out.println("不存在时");
			/*// 将vo转换成实体类
			menuPermission = grantVOHelper.menuPermissionInfoToMenuPermission(menuPermissionInfo);
			// 缓存中不存在则从数据库中读取
			item = mpd.getMenuPermissionByMenuId(menuPermission);*/
			PermissionInfo per = new PermissionInfo();
			/*for (Permission permission : item) {*/
				// 将实体类转换成vo
				/*per = grantVOHelper.permissionToPermissionInfo(permission);*/
			/*	per.setPmsnUrl(permission.getPmsnUrl());*/
			list.add(per);
			flushMenuPermissionCache();
			return list;
			}
		/*}*/
		/*log.info(listPmsnInfo.toString());*/
	}

	/*
	 * @param menuPermission
	 * 
	 * @return
	 * 
	 * @see
	 * com.clps.bj.mms.sm.service.IGrantService#getMenuPermissionById(com.clps.
	 * bj.mms.sm.vo.MenuPermissionInfo)
	 */
	@Override
	public MenuPermissionInfo getMenuPermissionById(MenuPermissionInfo menuPermissionInfo) {
		MenuPermission menuPermission = new MenuPermission();
		menuPermission.setMpId(menuPermissionInfo.getMpId());
		// 查询实体类
		menuPermission = mpd.getMenuPermissionById(menuPermission);
		if (menuPermission == null)
			return null;
		// 实体类转vo
		menuPermissionInfo = grantVOHelper.menuPermissionToMenuPermissionInfo(menuPermission);
		return menuPermissionInfo;
	}

	/*
	 * @return
	 * 
	 * @see com.clps.bj.mms.sm.service.IGrantService#getAllMenuPermission()
	 */
	@Override
	public List<MenuPermissionInfo> getAllMenuPermission() {
		// 获取所有实体类列表
		List<MenuPermission> list = mpd.getAllMenuPermission();
		listMenuPmsnInfo = new ArrayList<>();
		MenuPermissionInfo menuPermissionInfo = null;
		for (MenuPermission menuPermission : list) {
			// 将实体类转换成vo
			menuPermissionInfo = grantVOHelper.menuPermissionToMenuPermissionInfo(menuPermission);
			listMenuPmsnInfo.add(menuPermissionInfo);
		}
		return listMenuPmsnInfo;
	}

	/**
	 * 
	 * @Description 菜单权限缓存
	 * @return Map<Integer,List<Permission>>
	 *
	 */
	public Map<Integer, List<PermissionInfo>> allMenuPermission() {
		// 获取所有实体类列表
		listMenuPmsnInfo = getAllMenuPermission();
		Map<Integer, List<PermissionInfo>> map = new HashMap<>();
		listPmsnInfo = null;
		PermissionInfo permissionInfo = null;
		int menuId = 0;
		for (MenuPermissionInfo menuPermissionInfo : listMenuPmsnInfo) {
			menuId = menuPermissionInfo.getMenuId();
			permissionInfo = new PermissionInfo();
			// 当map中已存在这菜单id时
			if (map.containsKey(menuId)) {
				// 得到这个key的value
				listPmsnInfo = map.get(menuId);
				permissionInfo.setPmsnUrl(menuPermissionInfo.getPermissionUrl());
				permissionInfo.setPmsnName(menuPermissionInfo.getPermissionName());
				permissionInfo.setPmsnId(menuPermissionInfo.getPermissionId());
				listPmsnInfo.add(permissionInfo);
				map.put(menuId, listPmsnInfo);
			}
			// 当菜单id没在map中时
			else {
				// 将权限放到list中
				listPmsnInfo = new ArrayList<>();
				permissionInfo.setPmsnId(menuPermissionInfo.getPermissionId());
				permissionInfo.setPmsnName(menuPermissionInfo.getPermissionName());
				permissionInfo.setPmsnUrl(menuPermissionInfo.getPermissionUrl());
				listPmsnInfo.add(permissionInfo);
				map.put(menuId, listPmsnInfo);
			}

		}
		log.info(map.toString());
		return map;
	}

	/*
	 * @param mp
	 * 
	 * @return
	 * 
	 * @see
	 * com.clps.bj.mms.sm.service.IGrantService#iscontainsMenuPermission(com.
	 * clps.bj.mms.sm.entity.MenuPermission)
	 */
	@Override
	public boolean iscontainsMenuPermission(MenuPermissionInfo menuPermissionInfo) {
		int menuId = menuPermissionInfo.getMenuId();

		// 判断缓存中是否存在这个菜单
		if (menuPermissionCache.containsKey(menuId)) {
			listPmsnInfo = menuPermissionCache.get(menuId);
			System.out.println(listPmsnInfo.toString());
			String pmsnId = menuPermissionInfo.getPermissionId();
			for (PermissionInfo permissionInfo : listPmsnInfo) {
				// 判断是否存在这个权限
				if (permissionInfo.getPmsnId() == null) {
					if (pmsnId == null)
						return true;
				} else {
					if (permissionInfo.getPmsnId().equals(pmsnId))
						return true;
				}
			}

		}

		return false;

	}

	/*
	 * 
	 * @see com.clps.bj.mms.sm.service.IGrantService#flushMenuPermissionCache()
	 */
	@Override
	public void flushMenuPermissionCache() {
		menuPermissionCache = allMenuPermission();
	}

	/* 
	 * @return      
	 * @see com.clps.bj.mms.sm.service.IGrantService#getPermissionTotal()
	 */
	@Override
	public Long getPermissionTotal() {
		
		return pdI.getPermissionTotal();
	}

	/* 
	 * @param menuId
	 * @param listMp
	 * @return      
	 * @see com.clps.bj.mms.sm.service.IGrantService#getMenuPermissionInfo(int, java.util.List)
	 */
	@Override
	public List<PermissionInfo> getMenuPermissionInfo(Object[] pmsn,Object menuId, List<MenuPermissionInfo> listMp) {
		//记录一个菜单的所有权限
	PermissionInfo permissionInfo = null;
	List<PermissionInfo> listPmsn = new ArrayList<>();
	boolean flag = false;
	for (int i =0;i<listMp.size();i++) {
	     flag = listMp.get(i).getMenuId()==menuId;
			if(flag){
				permissionInfo = new PermissionInfo();
				permissionInfo.setPmsnId(listMp.get(i).getPermissionId());
				permissionInfo.setPmsnName(listMp.get(i).getPermissionName());
				for (int j = 0; j < pmsn.length; j++) {
					if(listMp.get(i).getPermissionId().equals(pmsn[j])){
						permissionInfo.setPmsnUimId(1);
						break;
					}
					else{
						permissionInfo.setPmsnUimId(0);	
					}
				}
				listPmsn.add(permissionInfo);
			}
			else{
				continue;
			}
	}
	return listPmsn;
	}

	/* 
	 * @param roleMenuPermissionInfo
	 * @return      
	 * @see com.clps.bj.mms.sm.service.IGrantService#getRoleMenusAndPermissions(com.clps.bj.mms.sm.vo.RoleMenuPermissionInfo)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public MyInfo getRoleMenusAndPermissions(RoleMenuPermissionInfo roleMenuPermissionInfo) {
		//查询角色的所有菜单和权限
		List<RoleMenuPermissionInfo> list = getRoleMenuPermissionByRoleId(roleMenuPermissionInfo);
		//存菜单id
		HashSet<Integer> set = new HashSet<>();
		//菜单权限关系实体类对象
		MenuPermissionInfo mpi = null;
		//角色具有的菜单权限关系列表
		List<MenuPermissionInfo> listMp = new ArrayList<>();
		HashSet<String> setPmsnId = new HashSet<>();
		//将该角色的所有菜单权限关系查出
    for (RoleMenuPermissionInfo roleMenuPermissionInfo2 : list) {
			MenuPermissionInfo mpi_t = new MenuPermissionInfo();
			mpi_t.setMpId(roleMenuPermissionInfo2.getMenuPermissionId());
			//查询这一条菜单权限关系
			mpi = getMenuPermissionById(mpi_t);
			//将菜单id记录
			setPmsnId.add(mpi.getPermissionId());
		}
		
		listMp = getAllMenuPermission();
		for (MenuPermissionInfo menuPermissionInfo : listMp) {
			set.add(menuPermissionInfo.getMenuId());
		}
		//将菜单id转为数组
		Object[] menuId = set.toArray();
		Object[] pmsnId = setPmsnId.toArray();
		List<PermissionInfo> li = null;
		Map<Object,List<PermissionInfo>> pmsn = new HashMap<>();
		//将每一个菜单对应的权限存储
		for (int j = 0; j < menuId.length; j++) {
			li = getMenuPermissionInfo(pmsnId,menuId[j], listMp);
			pmsn.put(menuId[j], li);
		}
		MyInfo father = null;
		MyJson json = new MyJson();
			try {
				//所有菜单的信息
				father = json.resultTree(0, ims.getMenusByVo());
			} catch (Exception e) {
				e.printStackTrace();
			}
			//所有根节点
			List<MyInfo> roots = father.getNodes();
			//次级结点
			List<MyInfo> son = null;
			//尾端结点
			List<MyInfo> endNode = null;
			List<MyInfo> theEnd = null;
			//菜单id
			Integer tempId = null;
			//菜单最多三层,每个根节点深度最多为3
			for (int i = 0; i < roots.size(); i++) {
				son = roots.get(i).getNodes();
				//判断根节点是否有次级结点
				if(son.size() != 0){
					for (int j = 0; j < son.size(); j++) {
						//判断是否有微端结点
						endNode = son.get(j).getNodes();
						 if(endNode.size()!=0){
							 for (int m = 0; m < endNode.size(); m++) {
								 theEnd = endNode.get(m).getNodes();
								 if(theEnd.size()!=0){
									 for (int k = 0; k < theEnd.size(); k++) {
										 tempId = theEnd.get(k).getId();
										 //判断尾端结点菜单的id是否对应角色有权限的菜单
										 if(pmsn.containsKey(tempId)){
											 theEnd.get(k).setProperties(pmsn.get(tempId));
										 }
									}
									 endNode.get(m).setNodes(theEnd);
								 }
								 else{
									 tempId = endNode.get(m).getId();
									 //判断尾端结点菜单的id是否对应角色有权限的菜单
									 if(pmsn.containsKey(tempId)){
										 endNode.get(m).setProperties(pmsn.get(tempId));
									 }
								
								 }
								 
							 }
							 son.get(j).setNodes(endNode);
						 }
						 else{
							 tempId = son.get(j).getId();
							 //判断次级结点菜单的id是否对应角色有权限的菜单
							 if(pmsn.containsKey(tempId)){
								 son.get(j).setProperties(pmsn.get(tempId));
							 }
						 }
						}
					roots.get(i).setNodes(son);
				}
			}
			father.setNodes(roots);
			return father;
			}

	

}
