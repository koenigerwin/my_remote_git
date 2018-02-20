package com.clps.bj.mms.sm.service.impl;

import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.clps.bj.mms.common.util.exception.UserInfoServiceException;
import com.clps.bj.mms.sm.entity.UserInfoMain;

import com.clps.bj.mms.sm.service.IUserInfoMainService;
import com.clps.bj.mms.sm.vo.UserInfoVo;

/**
 * 
 * @Description: 用户主表服务层测试类
 * 
 * @className：UserInfoMainServiceImplTest
 * @author jiangying
 * @version V1.0.0 2018年1月25日下午6:07:49
 */
// 唯一性的values在测试中用断言
// 状态 constance

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:beans.xml" })
// @Transactional
public class UserInfoMainServiceImplTest {

	
	private Logger logger = LoggerFactory.getLogger(UserInfoMainServiceImpl.class);

	@Autowired
	private IUserInfoMainService iUserInfoMainService;

	@Test
	public void test() {

	}

	/**
	 * 通过输入用户id查询用户 Test method for
	 * {@link com.clps.bj.mms.sm.service.impl.UserInfoMainServiceImpl#getUserById(java.lang.Integer)}.
	 */

	@Test
	public void testGetUser() {

		// Assert.assertNotNull(this.iUserInfoMainService.getUserInfoMain(1));

		logger.info(this.iUserInfoMainService.getUserInfoMain(1).toString());

	}

	/**
	 * 通过输入用户名称查询用户 Test method for
	 * {@link com.clps.bj.mms.sm.service.impl.UserInfoMainServiceImpl#getUserByName(java.lang.Integer)}.
	 */

	@Test
	public void testGetUserByName() {

		logger.info(this.iUserInfoMainService.getUserInfoMainByName("JY").toString());

	}

	/**
	 * 添加新的用户 Test method for
	 * {@link com.clps.bj.mms.sm.service.impl.UserInfoMainServiceImpl#addUserMain(com.clps.bj.mms.sm.entity.User)}.
	 */
	@Test
	public void testAddUser() {

		// session = HibernateUtil.openSession();
		// session.beginTransaction();

		UserInfoMain user = new UserInfoMain();
		// Position position =
		// (Position)session.load(Position.class,1);//从数据库中取出已经存在的职位id
		// Department dept =
		// (Department)session.load(Department.class,1);//从数据库中取出已经存在的部门id
		// Role role = (Role)session.load(Role.class,1);//从数据库中取出已经存在的角色id
		user.setUserLogon("liu");
		user.setUserPassword("11111");
		user.setUserName("Li");
		user.setUserEmail("132118669@qq.com");
		user.setUserIsEnable("1");
		user.setUserStatus(1);
		user.setUserCreatedDatetime("2018-11-26");
		user.setUserCreatedName(1);
		// user.setPositionId();
		// user.setDeptId(dept);
		// user.setRoleId(role);

		Boolean flag = this.iUserInfoMainService.addUserMain(user);

		logger.info(String.valueOf(flag));
	}

	/**
	 * 通过id号删除指定用户信息 Test method for
	 * {@link com.clps.bj.mms.sm.service.impl.UserInfoMainServiceImpl#deleteUserMain(java.lang.Integer)}.
	 */
	@Test
	public void testDeleteUser() {
		this.iUserInfoMainService.deleteUserMain(2);
	}

	/**
	 * 通过部门id查询用户信息
	 * 
	 * Test method for
	 * {@link com.clps.bj.mms.sm.service.impl.UserInfoDetailServiceImpl#getUserInfoMainByDeptId(com.clps.bj.mms.sm.entity.UserInfoDetail)}.
	 * 
	 */
	@Test
	public void testQueryUserByDeptId() {
		Assert.assertNotNull(this.iUserInfoMainService.getUserInfoMainByDeptId(1));
	}

	/**
	 * 通过角色id查询用户信息
	 * 
	 * Test method for
	 * {@link com.clps.bj.mms.sm.service.impl.UserInfoDetailServiceImpl#updateUserDetail(com.clps.bj.mms.sm.entity.UserInfoDetail)}.
	 * 
	 */
	@Test
	public void testQueryUserByRoleId() {
		Assert.assertNotNull(this.iUserInfoMainService.getUserInfoMainByRoleId(null));
		logger.info("************************" + this.iUserInfoMainService.getUserInfoMainByRoleId(null).toString());
	}

	/**
	 * 通过职位id查询用户信息
	 * 
	 * Test method for
	 * {@link com.clps.bj.mms.sm.service.impl.UserInfoDetailServiceImpl#getUserInfoMainByPosId(com.clps.bj.mms.sm.entity.UserInfoDetail)}.
	 * 
	 */
	@Test
	public void testQueryUserByPosId() {
		Assert.assertNotNull(this.iUserInfoMainService.getUserInfoMainByPosId(1));
		logger.info("************************" + this.iUserInfoMainService.getUserInfoMainByPosId(1).toString());
	}

	/**
	 * 修改的用户详细信息 Test method for
	 * {@link com.clps.bj.mms.sm.service.impl.UserInfoDetailServiceImpl#updateUserDetail(com.clps.bj.mms.sm.entity.UserInfoDetail)}.
	 */
	@Test
	public void testUpdateUserInfo() {
		// 打开session
		// 开启事物
		// this.session = HibernateUtil.openSession();
		// session.beginTransaction();

		// Position position =
		// (Position)session.load(Position.class,1);//从数据库中取出已经存在的职位id
		// Department dept =
		// (Department)session.load(Department.class,1);//从数据库中取出已经存在的部门id
		// Role role = (Role)session.load(Role.class,1);//从数据库中取出已经存在的角色id

		UserInfoMain user = new UserInfoMain();

		user.setUserEmail("Mr.Jiang@clpsglobal.com");
		user.setUserIsEnable("1");
		user.setUserStatus(0);
		user.setUserCreatedDatetime("2018-11-24");
		user.setUserCreatedName(1);

		// user.setPositionId(position);
		// user.setDeptId(dept);
		// user.setRoleId(role);

		user.setUserId(2);
		;
		Boolean flag = this.iUserInfoMainService.updateUserMain(user);

		logger.info(String.valueOf(flag));
	}

	/**
	 * 通过用户id/用户名查询 用户信息 Test method for
	 * {@link com.clps.bj.mms.sm.service.impl.UserServiceImpl#getUserInfoMainByTerm()}.
	 */
	/*@Test
	public void getUserInfoMainByTerm() {
		UserInfoMain user = new UserInfoMain();
		user.setUserId(1);
		UserInfoVo s = this.iUserInfoMainService.getUserInfoMainByTerm(user);
		logger.info("********************" + s.toString());
	}*/
	/**
	 * 查询VO
	 * {@link com.clps.bj.mms.sm.service.impl.UserServiceImpl#getAllUserInfoMainVo()}.
	 */
	@Test
	public void getAllUserInfoMainVo(){
		List<UserInfoVo> list = this.iUserInfoMainService.getAllUserInfoMainVo();
		for(UserInfoVo uservo:list){
			logger.info("************"+uservo.toString());
		}
	}

	/**
	 * 检验用户登录 Test method for
	 * {@link com.clps.bj.mms.sm.service.impl.UserServiceImpl#logon()}.
	 * @throws UserInfoServiceException 
	 */
	/*@Test
	public void logon() throws UserInfoServiceException {
		
		this.iUserInfoMainService.login("liu", "11111");

	}*/

	/**
	 * 查询所有用户 Test method for
	 * {@link com.clps.bj.mms.sm.service.impl.UserServiceImpl#getAllUserInfoMain}.
	 */
	@Test
	public void getAllUserInfoMain() {
		List<UserInfoMain> list = this.iUserInfoMainService.getAllUserInfoMain();
		for (UserInfoMain user : list) {
			logger.info("*********************" + user.toString());
		}
	}		
		/**
	 * {@link com.clps.bj.mms.sm.service.impl.UserServiceImpl#queryAllUserInfoMainByMap}.
		 */
	   @Test
		public void queryAllUserInfoMainByMap(){
			Map<Integer,UserInfoMain> map = this.iUserInfoMainService.getAllUserInfoMainByMap();
			logger.info("queryAllUserInfoMainByMap"+map.get(1));
	}
	   
	   @Test
	   public void testupdateuserrole() {
		   this.iUserInfoMainService.updateuserrole(2, 1);
	   }
	   @Test
	   public void testGetAllLeadingPerVo() {
		   List<UserInfoVo> infos = this.iUserInfoMainService.getAllLeadingPerVo("343");
		   for(UserInfoVo vo:infos){
			   System.err.println(vo.getUserName());
		   }
	   }

}