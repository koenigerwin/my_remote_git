package com.clps.bj.mms.sm.service.impl;

import java.util.List;

import org.hibernate.Hibernate;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.clps.bj.mms.sm.entity.Role;
import com.clps.bj.mms.sm.service.IRoleService;
import com.clps.bj.mms.util.hibernate.HibernateUtil;

/**
 *@description：测试RoleServiceImpl
 *@className：RoleServiceImplTest
 *@author bai
 *@version v1.0
 *@date 2018年1月22日 下午3:55:19
*/
@RunWith(SpringJUnit4ClassRunner.class)  
@ContextConfiguration(locations = {"classpath*:beans.xml"})
//@Transactional
public class RoleServiceImplTest {
	
	@Autowired
	private IRoleService irs;
	
	Role role;
	int roleid;
	String rolename;
	String name;
	int deleteroleid;
	@Before
	public void setUp() throws Exception {
		role=new Role();
		role.setRoleName("擦擦擦");
		role.setRoleDescription("pp");
		role.setRoleIcon("F://");
		role.setRoleCreatedDatetime("2018-01-23");
		role.setRoleUpdatedDatetime("2018-01-23");
		role.setRoleUpdatedUserId(2);
		role.setRoleCreatedUserId(2);
		roleid=1;
		rolename="1";
		name="员";
		deleteroleid=1;
	}

	@After
	public void tearDown() throws Exception {
		
	}

	@Test
	public void testQueryRoleName() {
		Role queryRoleName = irs.queryRoleName(5);
		System.out.println(queryRoleName.getRoleCreatedDatetime());
		Assert.assertEquals("886", queryRoleName.getRoleName());
	}

	@SuppressWarnings("unchecked")
	@Test
	public void testAddRole() {
		List<Role> list = HibernateUtil.openSession().createQuery("from Role").list();
		for(Role roles:list) {
			Assert.assertNotEquals(roles.getRoleName(), "bex");
	}
		irs.addRole(role);
	}

	@Test
	public void testDeleteRole() {
		boolean flag = irs.deleteRole(deleteroleid);
		Assert.assertTrue(flag);
	}

	@Test
	public void testQueryAllRoleNameBySome() {
		List<Role> result = irs.queryAllRoleName();
		Assert.assertNotNull(result);
		for(Role r:result) {
			System.out.println(r.getRoleName());
		}
	}

	@Test
	public void testUpdateRole() {
		boolean flag = irs.updateRole(role, roleid);
		Assert.assertTrue(flag);
	}

	@Test
	public void testQueryRoleByName() {
		List<Role> result = irs.queryRoleByName("x");
		Assert.assertNotNull(result);
		for(Role r:result) {
			System.out.println(r.getRoleName());
		}
	}

}
