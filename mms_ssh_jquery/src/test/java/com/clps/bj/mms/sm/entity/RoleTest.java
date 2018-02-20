package com.clps.bj.mms.sm.entity;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.clps.bj.mms.util.hibernate.HibernateUtil;

/**
 * @description：role实体测试类
 * @className：RoleTest
 * @author bai
 * @version v1.0
 * @date 2018年1月22日 下午5:59:17
 */
public class RoleTest {

	private Session session = null;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		this.session = HibernateUtil.openSession();
		// 开启事务
		session.beginTransaction();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		session.getTransaction().commit();
		HibernateUtil.close(this.session);
	}

	/**
	 * 
	 */
	@SuppressWarnings("unchecked")
	@Test
	public void testAddRole() {
			Role role = new Role();
			role.setRoleName("bex");
			List<Role> list = session.createQuery("from Role").list();
			for(Role roles:list) {
				Assert.assertNotEquals(roles.getRoleName(), "bex");
		}
			role.setRoleIcon("F://");
			role.setRoleCreatedDatetime("1");
			role.setRoleCreatedUserId(1);
			role.setRoleUpdatedDatetime("1");
			role.setRoleUpdatedUserId(1);
			session.save(role);
	}
	@Test
	public void testDeleteRole() {
			session.delete(session.load(Role.class,1));
	}
	@Test
	public void testUpdateRole() {
			Role role = new Role();
			role.setRoleId(7);
			role.setRoleName("yggg");
			role.setRoleIcon("d://");
			role.setRoleCreatedDatetime("2222222");
			role.setRoleCreatedUserId(2);
			role.setRoleUpdatedDatetime("12222222");
			role.setRoleUpdatedUserId(2);
			session.update(role);
	}
	@Test
	public void testQueryRole() {
			Role role = (Role)session.load(Role.class,3);
			Assert.assertEquals("用户", role.getRoleName());
	}
}
