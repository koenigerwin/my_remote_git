/**  
 * @Title:  RoleMenuPermissionTest.java   
 * @Package com.clps.bj.mms.sm.entity   
 * @Description:    测试类
 * @author: snow     
 * @date:   2018年1月24日 下午4:23:22   
 * @version V1.0 
 * @Copyright: 2018 clps.com Inc. All rights reserved. 
 */
package com.clps.bj.mms.sm.entity;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.clps.bj.mms.common.util.factory.UtilFactory;
import com.clps.bj.mms.constant.TimeFormatConstant;

import com.clps.bj.mms.util.hibernate.HibernateUtil;

/**
 * @ClassName: RoleMenuPermissionTest
 * @Description:RoleMenuPermission测试类
 * @author: snow
 * @date: 2018年1月26日 上午10:23:22
 * @version V 1.0.4
 */
public class RoleMenuPermissionTest {
	private Session session = null;
	Logger log = Logger.getLogger(PermissionTest.class);

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		this.session = HibernateUtil.openSession();
		session.beginTransaction();
	}

	@After
	public void tearDown() throws Exception {

	}

	/**
	 * Test method for
	 * {@link com.clps.bj.mms.sm.dao.impl.RoleMenuPermissionDaoImpl#addRoleMenuPermission(com.clps.bj.mms.sm.entity.RoleMenuPermission)}
	 * .
	 */
	@Test
	public void testAddRoleMenuPermission() {
		String time = UtilFactory.getInstanceOfNowTimeFormat().getNowTime();
		Role r = (Role) session.load(Role.class, 1);
		Menu m = (Menu) session.load(Menu.class, 2);
		Permission p = (Permission) session.load(Permission.class, "40283481613ff56e01613ff5730e0000");
		RoleMenuPermission rmp = new RoleMenuPermission();
		MenuPermission mp = new MenuPermission();
		mp.setMenu(m);
		mp.setPermission(p);
		mp.setMpId(4);
		rmp.setMenuPermission(mp);
		rmp.setRmpUimId(9);// 必填
		rmp.setRole(r);// 必填
		rmp.setRmpCreateDatetime(time);
		rmp.setRmpCreateUid(1);
		rmp.setRmpUpdatetime(time);// 必填
		log.info(session.save(rmp));
		session.getTransaction().commit();
	}

	/**
	 * Test method for
	 * {@link com.clps.bj.mms.sm.dao.impl.RoleMenuPermissionDaoImpl#deleteRoleMenuPermission(com.clps.bj.mms.sm.entity.RoleMenuPermission)}
	 * .
	 */
	@Test
	public void testDeleteRoleMenuPermission() {
		RoleMenuPermission rmp = (RoleMenuPermission) session.load(RoleMenuPermission.class, "40283481613ff56e01613ff5730e0000");
		session.delete(rmp);
		session.getTransaction().commit();
	}

	/**
	 * Test method for
	 * {@link com.clps.bj.mms.sm.dao.impl.RoleMenuPermissionDaoImpl#updateRoleMenuPermission(com.clps.bj.mms.sm.entity.RoleMenuPermission)}
	 * .
	 */
	@Test
	public void testUpdateRoleMenuPermission() {

		String time = UtilFactory.getInstanceOfNowTimeFormat().getNowTime();
		RoleMenuPermission rmp = (RoleMenuPermission) session.load(RoleMenuPermission.class, 13);
		rmp.setRmpUimId(99);// 必填
		rmp.setRmpUpdatetime(time);// 必填
		session.update(rmp);
		session.getTransaction().commit();
	}

	/**
	 * Test method for
	 * {@link com.clps.bj.mms.sm.dao.impl.RoleMenuPermissionDaoImpl#getRoleMenuPermissionByRoleId(com.clps.bj.mms.sm.entity.RoleMenuPermission)}
	 * .
	 */
	@Test
	public void testGetRoleMenuPermissionByRoleId() {
		log.info((RoleMenuPermission) session.load(RoleMenuPermission.class, 3));

	}

	/**
	 * Test method for
	 * {@link com.clps.bj.mms.sm.dao.impl.RoleMenuPermissionDaoImpl#getAllRoleMenuPermission()}
	 * .
	 */
	@Test
	public void testGetAllRoleMenuPermission() {

	}
}
