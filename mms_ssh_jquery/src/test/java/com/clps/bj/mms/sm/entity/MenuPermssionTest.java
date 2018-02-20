/**  
 * @Title:  MenuPermssionTest.java   
 * @Package com.clps.bj.mms.sm.entity   
 * @Description:    测试MenuPermssion
 * @author: snow     
 * @date:   2018年1月26日 下午1:00:29   
 * @version V1.0 
 * @Copyright: 2018 clps.com Inc. All rights reserved. 
 */  
package com.clps.bj.mms.sm.entity;

import static org.junit.Assert.*;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;

import com.clps.bj.mms.common.util.factory.UtilFactory;
import com.clps.bj.mms.util.hibernate.HibernateUtil;

/**   
 * @ClassName:  MenuPermssionTest   
 * @Description:MenuPermssion测试类
 * @author:     snow.y
 * @date:       2018年1月26日 下午1:00:29 
 * @version     V 1.0.0
 */
public class MenuPermssionTest {
	private Session session = null;
	Logger log =Logger.getLogger(PermissionTest.class);

	@Before
	public void setUpBeforeClass() throws Exception {
		this.session = HibernateUtil.openSession();
		session.beginTransaction();
	}


	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}


	@After
	public void tearDown() throws Exception {
/*		if(session!=null){
			session.getTransaction().rollback();
			HibernateUtil.close(session);
		}*/
	}

	@Test
	public void test() {
		fail("Not yet implemented");
	}
	@Test
	public void testAdd(){
		String time = UtilFactory.getInstanceOfNowTimeFormat().getNowTime();
		MenuPermission mp = new MenuPermission();
		Permission p = new Permission();
		p.setPmsnId("40283481613ff56e01613ff5730e0000");
		Menu m = new Menu();
		m.setMenuId(1);
		mp.setMpUpdateTime(time);
		mp.setMpCreateId(1);
		mp.setMpUpdateUid(2);
		mp.setMpCreateDatetime(time);
		mp.setMenu(m);
		mp.setPermission(p);
		session.save(mp);
		session.getTransaction().commit();
	}
	@Test
	public void testDelete(){
		MenuPermission mp = (MenuPermission)session.load(MenuPermission.class,6);
		session.delete(mp);
		session.getTransaction().commit();
	}
	@Test
	public void testUpdate(){
		String time = UtilFactory.getInstanceOfNowTimeFormat().getNowTime();
		MenuPermission mp = (MenuPermission)session.load(MenuPermission.class,1);
		System.out.println(mp);
		mp.setMpUpdateTime(time);
		mp.setMpUpdateUid(222);
		session.update(mp);
		session.getTransaction().commit();
	}
	@Test
	public void testGetone(){
		String hql ="update RoleMenuPermission r set "
			+ "r.menuPermission.mpId=:menuPermission,r.rmpUpdatetime=:rmpUpdatetime,"
			+ "r.rmpUimId=:rmpUimId where r.rmpId=:rmpId";
		Query query =session.createQuery(hql);
	/*	Role r = new Role();
		r.setRoleId(7);
	     query.setParameter("role", r);*/
	    /*MenuPermission mp = new MenuPermission();
	     * mp.setMpId(3);
	    mp.setMpUpdateTime(time);*/
		String time = UtilFactory.getInstanceOfNowTimeFormat().getNowTime();
	    query.setParameter("menuPermission", 2);
	    query.setParameter("rmpUpdatetime", time);
	    query.setParameter("rmpUimId", 77);
	    query.setParameter("rmpId", 20);
	     query.executeUpdate();
	   session.getTransaction().commit();
	
	}
	@Test
	public void getAll(){
		String hql = "from MenuPermission";
		@SuppressWarnings("unchecked")
		List<MenuPermission> list = session.createQuery(hql).list();
		for (MenuPermission roleMenuPermission : list) {
			log.info(roleMenuPermission.toString());
		}
		
	}
}
