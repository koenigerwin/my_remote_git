package com.clps.bj.mms.sm.entity;


import org.hibernate.Session;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.clps.bj.mms.sm.constant.Gender;

import com.clps.bj.mms.util.hibernate.HibernateUtil;

public class UserInfoMainTest {

	private Session session;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	   
	    
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		   //打开session 
		   //开启事物
		   this.session = HibernateUtil.openSession();
		   session.beginTransaction();
	}

	@After
	public void tearDown() throws Exception {
	   /*HibernateUtil.close(session);
	   if(session!=null){
		   session.getTransaction().rollback();
		   HibernateUtil.close(session);
	   }*/
	}

	@Test
	public void test() {
		
	}
	
	
	@Test
	public void testAdd(){
		  UserInfoMain user = new UserInfoMain();
		  UserInfoDetail userDetail = new UserInfoDetail();
		  
//		  Position position = (Position)session.load(Position.class,1);//从数据库中取出已经存在的职位id
//	      Department dept = (Department)session.load(Department.class,1);//从数据库中取出已经存在的部门id
//	      Role role = (Role)session.load(Role.class,1);//从数据库中取出已经存在的角色id	      
		  user.setUserLogon("李i");
		  user.setUserPassword("1011");
		  user.setUserName("Mr.i");
		  user.setUserEmail("wr.i@clpsglobal.com");
		  user.setUserIsEnable("1");
		  user.setUserStatus(0);
		  user.setUserCreatedDatetime("2018-02-02");
		  user.setUserCreatedName(1);
		  user.setPositionId(null);
	      user.setDeptId(null);
	      user.setRoleId(null);
	      				
		  userDetail.setUserWeixin("112022");
		  userDetail.setUserUpdatedName(1);
		  userDetail.setUserUpdatedDateTime("2018-02-02");
		  userDetail.setUserPhone("800082");
		  userDetail.setUserMobile("332023");
		  userDetail.setUserLevel("1");
		  userDetail.setUserIcon("f/");
		  userDetail.setUserDescritpion("123"); 
		  userDetail.setUserGender(Gender.male);
		  
//		  user.setUserInfoDetail(userDetail);
//		  userDetail.setUserInfoMain(user);
//		  session.save(userDetail);
		
		  session.save(user);
		 
	      session.getTransaction().commit();
			
	  }
	@Test
	public void testLoad() {
		Session session = null;
		try {
			session = HibernateUtil.openSession();
			UserInfoMain u = (UserInfoMain)session.load(UserInfoMain.class,2);
			System.out.println(u);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			HibernateUtil.close(session);
		}
	}
	
	/*@Test
	public void testUpdate() {
		Session session = null;
		try {
			session = HibernateUtil.openSession();
			session.beginTransaction();
			UserInfoMain u = (UserInfoMain)session.load(UserInfoMain.class,1);
			u.setUserEmail("123123");
			session.update(u);
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			if(session!=null) session.getTransaction().rollback();
		} finally {
			HibernateUtil.close(session);
		}
	}*/
	@Test
	public void testDelete() {
		Session session = null;
		try {
			session = HibernateUtil.openSession();
			session.beginTransaction();
			UserInfoMain u = new UserInfoMain();
			u.setUserId(1);
			u.setUserLogon("水1");
			u.setUserName("白水1");
			u.setUserEmail("111");
			u.setUserIsEnable("1");
			u.setUserStatus(1);
			u.setUserCreatedDatetime("2018-1-23");
			u.setUserCreatedName(1);
			session.delete(u);
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			if(session!=null) session.getTransaction().rollback();
		} finally {
			HibernateUtil.close(session);
		}
	} 
	

}
