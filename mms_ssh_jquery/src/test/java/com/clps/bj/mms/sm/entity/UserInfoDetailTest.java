package com.clps.bj.mms.sm.entity;

import static org.junit.Assert.*;

import org.hibernate.Session;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import com.clps.bj.mms.sm.constant.Gender;
import com.clps.bj.mms.util.hibernate.HibernateUtil;

public class UserInfoDetailTest {


	private Session session = null;
	
	@Before
	public void setUp() throws Exception {
		//打开session 
	   //开启事物
	   this.session = HibernateUtil.openSession();
	   session.getTransaction().begin();
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
       
	  
	  UserInfoDetail user = new UserInfoDetail();	 
	  user.setUserWeixin("123");
	  user.setUserUpdatedName(1);
	  user.setUserUpdatedDateTime("2018-01-23");
	  user.setUserPhone("156");
	  user.setUserMobile("123");
      user.setUserLevel("1");
      user.setUserIcon("f/");
      user.setUserDescritpion("123"); 
      user.setUserGender(Gender.female);
      user.setUserId(1);
      session.save(user);    
      session.getTransaction().commit();

	}
  }
