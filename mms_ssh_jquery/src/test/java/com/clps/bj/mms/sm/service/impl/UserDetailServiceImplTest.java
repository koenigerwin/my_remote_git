/**
 * @Description:SpringMVC Spring Hibernate    
 * @Title: UserDetailServiceImplTest.java  
 * @Package com.clps.bj.mms.sm.service.impl   
 * @author erwin.wang     
 * @version V1.0 
 *   
 */
package com.clps.bj.mms.sm.service.impl;


import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.clps.bj.mms.sm.entity.UserDetail;
import com.clps.bj.mms.sm.service.IUserDetailService;

/**
 * @description: UserDetail testing class
 * @className：UserDetailServiceImplTest
 * @author erwin.wang
 * @version V1.0.0
 * 2018年1月22日 下午5:15:45
 */
@RunWith(SpringJUnit4ClassRunner.class)  
@ContextConfiguration(locations = {"classpath*:beans.xml"})
public class UserDetailServiceImplTest {

	private Logger logger = LoggerFactory.getLogger(UserDetailServiceImpl.class);
	@Autowired
	private IUserDetailService iUserDetailService;
	/**
	 * @Description:TODO
	 * @throws java.lang.Exception
	 *
	 */
	@Before
	public void setUp() throws Exception {
	}

	/**
	 * @Description:TODO
	 * @throws java.lang.Exception
	 *
	 */
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Test method for {@link com.clps.bj.mms.sm.service.impl.UserDetailServiceImpl#getUserDetail(java.lang.Integer)}.
	 */
	@Test
	public void testGetUserDetail() {
		Assert.assertNotNull(this.iUserDetailService.getUserDetail(1));
	}

	/**
	 * Test method for {@link com.clps.bj.mms.sm.service.impl.UserDetailServiceImpl#addUserDetail(com.clps.bj.mms.sm.entity.UserDetail)}.
	 */
	@Test
	public void testAddUserDetail() {
		UserDetail ud =new UserDetail();
		ud.setPhoneNumber("111111111");
		ud.setPassword("123456");
		ud.setRegisterTime("1999-12-12");
		ud.setUserId(2);
		this.iUserDetailService.addUserDetail(ud);
	}

	/**
	 * Test method for {@link com.clps.bj.mms.sm.service.impl.UserDetailServiceImpl#deleteUserDetail(java.lang.Integer)}.
	 */
	@Test
	public void testDeleteUserDetail() {
	}

	/**
	 * Test method for {@link com.clps.bj.mms.sm.service.impl.UserDetailServiceImpl#updateUserDetail(com.clps.bj.mms.sm.entity.UserDetail)}.
	 */
	@Test
	public void testUpdateUserDetail() {

	}

	/**
	 * Test method for {@link com.clps.bj.mms.sm.service.impl.UserDetailServiceImpl#getAllUserDetail()}.
	 */
	@Test
	public void testGetAllUserDetail() {
		this.iUserDetailService.getAllUserDetail();
		logger.info("");

	}

}
