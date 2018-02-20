/**  
 * @Title:  GrantServiceTest.java   
 * @Package com.clps.bj.mms.sm.service.impl   
 * @Description:   权限功能测试类
 * @author: snow     
 * @date:   2018年1月25日 上午12:07:03   
 * @version V1.0 
 * @Copyright: 2018 clps.com Inc. All rights reserved. 
 */  
package com.clps.bj.mms.sm.service.impl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSON;
import com.clps.bj.mms.common.util.factory.UtilFactory;
import com.clps.bj.mms.sm.vo.MenuPermissionInfo;
import com.clps.bj.mms.sm.vo.PermissionInfo;
import com.clps.bj.mms.sm.vo.RoleMenuPermissionInfo;

/**   
 * @ClassName:  GrantServiceTest   
 * @Description:GrantService测试类
 * @author:     snow.y
 * @date:       2018年1月25日 上午12:07:03 
 * @version     V 1.0.0
 */
@RunWith(SpringJUnit4ClassRunner.class)  
@ContextConfiguration(locations = {"classpath*:beans.xml"})
public class GrantServiceTest {
@Autowired
private GrantServiceImpl igs;
Logger log =Logger.getLogger(GrantServiceTest.class);
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void tearBefore(){
	}
	@After
	
	public void tearDown() throws Exception {
	}

	/**
	 * Test method for {@link com.clps.bj.mms.sm.service.impl.GrantServiceImpl#addPermission(com.clps.bj.mms.sm.entity.Permission)}.
	 */
	@Test
	public void testAddPermission() {
		String time = UtilFactory.getInstanceOfNowTimeFormat().getNowTime();
		PermissionInfo p = new PermissionInfo();
		//均为必填项
		p.setPmsnCreateId(2);
		p.setPmsnCreateDatetime(time);
		p.setPmsnUpdateTime(time);
		p.setPmsnName("测试44");
		p.setPmsnUimId(2);
		log.info(igs.addPermission(p));
	}

	/**
	 * Test method for {@link com.clps.bj.mms.sm.service.impl.GrantServiceImpl#deletePermission(com.clps.bj.mms.sm.entity.Permission)}.
	 */
	@Test
	public void testDeletePermission() {
		PermissionInfo p = new PermissionInfo();
		p.setPmsnId("40283481613ff56e01613ff5730e0000");
		log.info(igs.deletePermission(p));
	}

	/**
	 * Test method for {@link com.clps.bj.mms.sm.service.impl.GrantServiceImpl#updatePermission(com.clps.bj.mms.sm.entity.Permission)}.
	 */
	@Test
	public void testUpdatePermission() {
		String time = UtilFactory.getInstanceOfNowTimeFormat().getNowTime();
		PermissionInfo p = new PermissionInfo();
		p.setPmsnId("40283481613ff56e01613ff5730e0000");
		p.setPmsnUpdateTime(time);
		p.setPmsnName("测试22");
		p.setPmsnUimId(33);
		log.info(igs.updatePermission(p));
	}

	/**
	 * Test method for {@link com.clps.bj.mms.sm.service.impl.GrantServiceImpl#getAllPermission()}.
	 */
	@Test
	public void testGetAllPermission() {
		List<PermissionInfo> map = igs.getAllPermission();
	/*	Map<Class<?>, Set<String>> includeMap = new HashMap<Class<?>, Set<String>>();
		Set<String> set = new HashSet<String>();
		set.add("rmpSet");
		includeMap.put(Permission.class, set);
		SerializeWriter json =  JsonHelpler.toJSON(map, includeMap);
		String str = json.toString();*/
		log.info(map.toString());
	}

	/**
	 * Test method for {@link com.clps.bj.mms.sm.service.impl.GrantServiceImpl#getPermissionByID(com.clps.bj.mms.sm.entity.Permission)}.
	 */
	@Test
	public void testGetPermissionByID() {
		PermissionInfo p = new PermissionInfo();
		p.setPmsnId("40283481613ff56e01613ff5730e0000");
		log.info(igs.getPermissionByID(p));
 	}

	/**
	 * Test method for {@link com.clps.bj.mms.sm.service.impl.GrantServiceImpl#addRoleMenuPermission(com.clps.bj.mms.sm.entity.RoleMenuPermission)}.
	 */
	@Test
	public void testAddRoleMenuPermission() {
		String time = UtilFactory.getInstanceOfNowTimeFormat().getNowTime();
		
		RoleMenuPermissionInfo rmp = new RoleMenuPermissionInfo();
		rmp.setMenuPermissionId(2);
		rmp.setRmpCreateUid(2);
		rmp.setRoleId(1);
		rmp.setRmpCreateDatetime(time);
		rmp.setRmpUpdatetime(time);
		rmp.setRmpUimId(99);
		log.info(igs.addRoleMenuPermission(rmp));
	}

	/**
	 * Test method for {@link com.clps.bj.mms.sm.service.impl.GrantServiceImpl#deleteRoleMenuPermission(com.clps.bj.mms.sm.entity.RoleMenuPermission)}.
	 */
	@Test
	public void testDeleteRoleMenuPermission() {
		RoleMenuPermissionInfo rmp = new RoleMenuPermissionInfo();
		rmp.setRoleId(1);
		rmp.setRmpId("40283481615085390161508544db0000");
		log.info(igs.deleteRoleMenuPermission(rmp));
	}

	/**
	 * Test method for {@link com.clps.bj.mms.sm.service.impl.GrantServiceImpl#updateRoleMenuPermission(com.clps.bj.mms.sm.entity.RoleMenuPermission)}.
	 */
	@Test
	public void testUpdateRoleMenuPermission() {
		String time = UtilFactory.getInstanceOfNowTimeFormat().getNowTime();
		RoleMenuPermissionInfo rmp = new RoleMenuPermissionInfo();
		rmp.setRmpId("3");
		rmp.setRmpCreateDatetime(time);
		rmp.setMenuPermissionId(2);
		rmp.setRmpUpdatetime(time);
		igs.updateRoleMenuPermission(rmp);
		
	}

	/**
	 * Test method for {@link com.clps.bj.mms.sm.service.impl.GrantServiceImpl#getRoleMenuPermissionByRoleId(com.clps.bj.mms.sm.entity.RoleMenuPermission)}.
	 */
	@Test
	public void testGetRoleMenuPermissionByRoleId() {
		RoleMenuPermissionInfo rmp = new RoleMenuPermissionInfo();
		rmp.setRoleId(1);
		log.info(igs.getRoleMenuPermissionByRoleId(rmp).toString());
	}

	/**
	 * Test method for {@link com.clps.bj.mms.sm.service.impl.GrantServiceImpl#getAllRoleMenuPermission()}.
	 */
	@Test
	public void testGetAllRoleMenuPermission() {
          log.info(igs.getAllRoleMenuPermission().toString());
	}

	/**
	 * Test method for {@link com.clps.bj.mms.sm.service.impl.GrantServiceImpl#iscontainsPermission(com.clps.bj.mms.sm.entity.Permission)}.
	 */
	@Test
	public void testIscontainsPermission() {
		PermissionInfo p = new PermissionInfo();
		p.setPmsnName("测试");
		log.info(igs.iscontainsPermission(p));
	}

	/**
	 * Test method for {@link com.clps.bj.mms.sm.service.impl.GrantServiceImpl#iscontainsRoleMenuPermission(com.clps.bj.mms.sm.entity.RoleMenuPermission)}.
	 */
	@Test
	public void testIscontainsRoleMenuPermission() {
		RoleMenuPermissionInfo rmp = new RoleMenuPermissionInfo();
		rmp.setMenuPermissionId(1);
		rmp.setRoleId(1);
		log.info(igs.iscontainsRoleMenuPermission(rmp));
	}

	/**
	 * Test method for {@link com.clps.bj.mms.sm.service.impl.GrantServiceImpl#addMenuPermission(com.clps.bj.mms.sm.entity.MenuPermission)}.
	 */
	@Test
	public void testAddMenuPermission() {
	String time = UtilFactory.getInstanceOfNowTimeFormat().getNowTime();
	MenuPermissionInfo mp = new MenuPermissionInfo();
	mp.setMenuId(3);
	mp.setMpCreateDatetime(time);
	mp.setMpCreateId(1);
	mp.setMpUpdateTime(time);
	mp.setMpUpdateUid(4);
	mp.setPermissionId("4028348161556e880161556e97d00000");
	log.info(igs.addMenuPermission(mp));
	
	}

	/**
	 * Test method for {@link com.clps.bj.mms.sm.service.impl.GrantServiceImpl#deleteMenuPermission(com.clps.bj.mms.sm.entity.MenuPermission)}.
	 */
	@Test
	public void testDeleteMenuPermission() {
		MenuPermissionInfo mp = new MenuPermissionInfo();
		mp.setMpId(2);
		log.info(igs.deleteMenuPermission(mp));
	}

	/**
	 * Test method for {@link com.clps.bj.mms.sm.service.impl.GrantServiceImpl#updateMenuPermission(com.clps.bj.mms.sm.entity.MenuPermission)}.
	 */
	@Test
	public void testUpdateMenuPermission() {
		String time = UtilFactory.getInstanceOfNowTimeFormat().getNowTime();
		MenuPermissionInfo mp = new MenuPermissionInfo();
		mp.setMenuId(2);
		mp.setMpId(8);
		mp.setPermissionId("40283481614d1c3e01614d1c482a0000");
		mp.setMpUpdateTime(time);
		mp.setMpUpdateUid(2);
		log.info(igs.updateMenuPermission(mp));
	}

	/**
	 * Test method for {@link com.clps.bj.mms.sm.service.impl.GrantServiceImpl#getMenuPermissionByMenuId(com.clps.bj.mms.sm.entity.MenuPermission)}.
	 */
	@Test
	public void testGetMenuPermissionById(){
		MenuPermissionInfo mp = new MenuPermissionInfo();
		mp.setMpId(1);
		log.info(igs.getMenuPermissionById(mp));
	}
	@Test
	public void testGetMenuPermissionByMenuId() {
	/*	MenuPermission mp = new MenuPermission();
		mp.setMpId(3);
		List<Permission> list = igs.getMenuPermissionByMenuId(mp);
		for (Permission permission : list) {
			log.info(permission.toString());
		}*/
	}

	/**
	 * Test method for {@link com.clps.bj.mms.sm.service.impl.GrantServiceImpl#getAllMenuPermission()}.
	 */
	@Test
	public void testGetAllMenuPermission() {
		List<MenuPermissionInfo> map = igs.getAllMenuPermission();
		log.info(map.toString());
		          
	}

	/**
	 * Test method for {@link com.clps.bj.mms.sm.service.impl.GrantServiceImpl#iscontainsMenuPermission(com.clps.bj.mms.sm.entity.MenuPermission)}.
	 */
	@Test
	public void testIscontainsMenuPermission() {
	MenuPermissionInfo mp = new MenuPermissionInfo();
	mp.setMenuId(1);
	mp.setPermissionId(null);
	log.info(igs.iscontainsMenuPermission(mp));
	}
@Test
public void testGetPermissionTotal(){
	log.info(igs.getPermissionTotal());
}
@Test
public void testdd(){
	Map<String,Object> mapJson = new HashMap<>();
	List<PermissionInfo> map = igs.getAllPermission();
	Long count = igs.getPermissionTotal();
	mapJson.put("Rows", map);
	mapJson.put("Total", count);
	System.out.println(JSON.toJSONString(mapJson));
		log.info(JSON.toJSONString(mapJson));
}
}
