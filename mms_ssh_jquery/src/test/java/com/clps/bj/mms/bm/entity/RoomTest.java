
package com.clps.bj.mms.bm.entity;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.clps.bj.mms.sm.entity.Position;
import com.clps.bj.mms.sm.entity.UserInfoMain;
import com.clps.bj.mms.util.hibernate.HibernateUtil;

/**
 * s
 * 
 * @description:Room测试类
 * @className:RoomTest.java
 * @author:Ian
 * @version:V1.0.0
 * @date:2018年1月24日下午3:53:47
 */

public class RoomTest {
	private static Session session = null;

	@BeforeClass
	public static void setUp() throws Exception {
		// open session
		// 开启食物
		RoomTest.session = HibernateUtil.openSession();
		session.getTransaction().begin();
	}

	@After
	public void tearDown() throws Exception {
		HibernateUtil.close(RoomTest.session);
		if (session != null)
			session.getTransaction().rollback();
		HibernateUtil.close(session);
	}

	@Test
	public void testAdd(){
		  Room roomTest = new Room();

		  roomTest.setroomId(066001);
		  roomTest.setroomIsEnable("0");
		  roomTest.setroomSize(20);
		  roomTest.setroomName("Aligator");
		  roomTest.setroomDescription("Test Room");
		  roomTest.setroomCreateName("Luci");
		  roomTest.setroomCreateTime("2018-1-23");
	      session.save(roomTest);
	      session.getTransaction().commit();
	      
	  }

}
