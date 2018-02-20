/**  
 * @Title:  Permission.java   
 * @Package com.clps.bj.mms.sm.entity   
 * @Description:    测试类
 * @author: snow     
 * @date:   2018年1月24日 下午12:03:39   
 * @version V1.0 
 * @Copyright: 2018 clps.com Inc. All rights reserved. 
 */  
package com.clps.bj.mms.sm.entity;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import com.clps.bj.mms.common.util.factory.UtilFactory;
import com.clps.bj.mms.util.hibernate.HibernateUtil;

/**   
 * @ClassName:  Permission   
 * @Description:权限dao的测试类
 * @author:     snow.y
 * @date:       2018年1月26日 上午10:23:22 
 * @version     V 1.0.4
 */
public class PermissionTest {
private Session session = null;
Logger log =Logger.getLogger(PermissionTest.class);
	/**     
	 * @throws java.lang.Exception void       
	 *        
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
	}

	/**     
	 * @throws java.lang.Exception void       
	 *        
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	/**     
	 * @throws java.lang.Exception void       
	 *        
	 */
	@Before
	public void setUp() throws Exception {
		this.session = HibernateUtil.openSession();
		   
	}

	/**     
	 * @throws java.lang.Exception void       
	 *        
	 */
	@After
	public void tearDown() throws Exception {
		if(session!=null){
			session.getTransaction().rollback();
			HibernateUtil.close(session);
		}
	}

	/**
	 * Test method for {@link com.clps.bj.mms.sm.dao.impl.PermissionDaoImpl#addPermission(com.clps.bj.mms.sm.entity.Permission)}.
	 */
	@Test
	public void testAddPermission() {
		////获取当前时间
		session.getTransaction().begin();
		String time = UtilFactory.getInstanceOfNowTimeFormat().getNowTime();
			System.out.println("默认格式化: " + time);
			System.out.println("自定义格式化: " + time);
			Permission p = new Permission();
			p.setPmsnCreateId(1);
			p.setPmsnName("查询权限");//必填
			p.setPmsnDescription("这是一条测试数据");
			p.setPmsnUimId(9);//必填
			p.setPmsnCreateDatetime(time);//必填
			p.setPmsnUpdateTime(time);
			log.info(session.save(p));
			session.getTransaction().commit();
 	}

	/**
	 * Test method for {@link com.clps.bj.mms.sm.dao.impl.PermissionDaoImpl#deletePermission(com.clps.bj.mms.sm.entity.Permission)}.
	 */
	@Test
	public void testDeletePermission() {
		session.getTransaction().begin();
	    Permission p = (Permission)session.load(Permission.class, "40283481613ff0d201613ff1629b0000");
	    session.delete(p);
	    session.getTransaction().commit();
	    
	}

	/**
	 * Test method for {@link com.clps.bj.mms.sm.dao.impl.PermissionDaoImpl#updatePermission(com.clps.bj.mms.sm.entity.Permission)}.
	 */
	@Test
	public void testUpdatePermission() {
		session.getTransaction().begin();
		Permission p = (Permission)session.load(Permission.class, "40283481613ff56e01613ff5730e0000");//必填
		//获取当前时间
		String time = UtilFactory.getInstanceOfNowTimeFormat().getNowTime();
		p.setPmsnDescription("测试修改");
		p.setPmsnName("测试修改333");//必填
		p.setPmsnUimId(2);//必填
		p.setPmsnUrl("www");
		p.setPmsnUpdateTime(time);//必填
		session.update(p);
		 session.getTransaction().commit();
	}

	/**
	 * Test method for {@link com.clps.bj.mms.sm.dao.impl.PermissionDaoImpl#getPermissionByID(com.clps.bj.mms.sm.entity.Permission)}.
	 */
	@Test
	public void testGetPermissionByID() {
		Permission p = (Permission)session.get(Permission.class, "40283481613ff56e01613ff5730e0000");
		log.info(p);
		
	}

	
}
