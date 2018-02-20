package com.clps.bj.mms.sm.entity;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.clps.bj.mms.util.hibernate.HibernateUtil;

/**
 * 
 * @description：TODO
 * @className：MenuTest
 * @author gg Yang
 * @version V1.0.0
 * @date 2018年1月25日上午10:38:00
 */
public class MenuTest {
	private Logger logger;                  //日志对象
	private Session session;                //会话对象
	@Before
	public void init(){
		logger = Logger.getLogger(PositionTest.class);
		 this.session = HibernateUtil.openSession();
		   session.getTransaction().begin();
	}
	@Test
	public void add(){
		Menu menu = new Menu();
		menu.setMenuCreatedDatetime("2018-01-12 20:30:09");
		menu.setMenuDescription("用户注销");
		menu.setMenuIcon("./aa.jpg");
		menu.setMenuName("用户注销");
		menu.setMenuNlevel(2);
		menu.setMenuParent("1");
		menu.setMenuSortId(",1,6");
		menu.setMenuStatus("1");
		menu.setMenuCreatedId(1);
		menu.setMenuUpdatedDatetime("2018-01-12 20:30:09");
		menu.setMenuUpdatedId(1);
		menu.setMenuUrl("./userlogout.jsp");
		session.save(menu);
	}
	
	@After
	public void after(){
		session.getTransaction().commit();
	}
}
