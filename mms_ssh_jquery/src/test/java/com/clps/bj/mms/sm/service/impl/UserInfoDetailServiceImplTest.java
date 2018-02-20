package com.clps.bj.mms.sm.service.impl;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.clps.bj.mms.sm.entity.UserInfoDetail;

import com.clps.bj.mms.sm.constant.Gender;

import com.clps.bj.mms.sm.service.IUserInfoDetailService;

/**
 * 
 * @Description: 用户详细表服务层测试类
 * 
 * @className：UserInfoDetailServiceImplTest
 * @author jiangying
 * @version V1.0.0 2018年1月25日下午6:07:49
 */
// 唯一性的values在测试中用断言
// 状态 constance

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:beans.xml" })
// @Transactional
public class UserInfoDetailServiceImplTest {

	
	private Logger logger = LoggerFactory.getLogger(UserInfoDetailServiceImpl.class);

	@Autowired
	private IUserInfoDetailService iUserInfoDetailservice;

	@Test
	public void test() {

	}

	/**
	 * 通过输入用户id查询用户 Test method for
	 * {@link com.clps.bj.mms.sm.service.impl.UserInfoMainServiceImpl#getUserById(java.lang.Integer)}.
	 */

	@Test
	public void testGetUserDetail() {

		// Assert.assertNotNull(this.iUserInfoMainService.getUserInfoMain(1));
		System.out.println("********************************");
		System.out.println(this.iUserInfoDetailservice.getUserInfoDetail(1).toString());
		System.out.println("***********************************");
		logger.info(this.iUserInfoDetailservice.getUserInfoDetail(1).toString());

	}

	/**
	 * 修改的用户详细信息 Test method for
	 * {@link com.clps.bj.mms.sm.service.impl.UserInfoDetailServiceImpl#updateUserDetail(com.clps.bj.mms.sm.entity.UserInfoDetail)}.
	 */
	@Test
	public void testUpdateUserDetail() {

		UserInfoDetail user = new UserInfoDetail();

		user.setUserBirth("1995");
		user.setUserDescritpion("123");
		user.setUserGender(Gender.male);
		user.setUserIcon("f/");
		user.setUserLevel("1");
		user.setUserPhone("158");
		user.setUserMobile("12533");

		user.setUserWeixin("180345");
		user.setUserUpdatedName(1);
		user.setUserUpdatedDateTime("2018-01-29");

		user.setUserId(1);
		;
		Boolean flag = this.iUserInfoDetailservice.updateUserInfoDetail(user);

		logger.info(String.valueOf(flag));
	}

	/**
	 * 添加新的用户详细信息 Test method for
	 * {@link com.clps.bj.mms.sm.service.impl.UserInfoDetailServiceImpl#addUserDetail(com.clps.bj.mms.sm.entity.UserInfoDetail)}.
	 */
	@Test
	public void testAddUserDetail() {

		UserInfoDetail user = new UserInfoDetail();
		user.setUserId(2);
		user.setUserWeixin("123");
		user.setUserUpdatedName(1);
		user.setUserUpdatedDateTime("2018-01-23");
		user.setUserPhone("156");
		// user.setUserPassword("111");
		user.setUserMobile("123456");
		user.setUserLevel("1");
		user.setUserIcon("f/");
		user.setUserDescritpion("123");
		user.setUserGender(Gender.female);
		user.setUserBirth("2018-01-23");
		user.setUserDefault1("userDefault1");
		user.setUserDefault2("userDefault2");
		System.out.println(user);
		Boolean flag = this.iUserInfoDetailservice.addUserInfoDetail(user);

		logger.info(String.valueOf(flag));
	}

}
