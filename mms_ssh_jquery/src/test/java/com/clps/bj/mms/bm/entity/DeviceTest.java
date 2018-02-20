/**   
* @Title: DeviceTest.java 
* @Package com.clps.bj.mms.bm.entity 
* @Description: (用一句话描述该文件做什么) 
* @author userdwt  
* @date 2018年1月22日 下午5:39:01 
* @version V1.0   
*/
package com.clps.bj.mms.bm.entity;


import static org.junit.Assert.assertNotNull;

import org.hibernate.Session;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import com.clps.bj.mms.util.hibernate.HibernateUtil;

/** 
* @ClassName: DeviceTest 
* @Description: 测试Device 
* @author userdwt
* @date 2018年1月22日 下午5:39:01 
*  
*/
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"classpath*:beans.xml"})
public class DeviceTest {

	
	private Session session;
	
	
	
	@Before
	public void beforeTest() {
		session=HibernateUtil.openSession();
		session.beginTransaction();
	}
	@After
	public void afterTest(){
		session.getTransaction().commit();
		HibernateUtil.close(session);
	}
	
	/**
	 * 
	* @Title: testadd 
	* @Description: 添加设备
	* @param      
	* @return void    返回类型 
	* @throws
	 */
	@Test
	public void testadd() {
		Device device=new Device();
		device.setDeviceName("aa1");
		session.save(device);
	}
	
	
	/**
	 * 
	* @Title: testAddCategory 
	* @Description: 添加设备分类 
	* @param      
	* @return void    返回类型 
	* @throws
	 */
	@Test
	public void testAddCategory() {
		
		DeviceCategory category=new DeviceCategory();
		category.setDeviceCategoryName("devicecategory");
		category.setDeviceCategoryIsParent((short)1);
		category.setDeviceCategoryParentId(1);
		session.save(category);
		
		DeviceCategory category2=(DeviceCategory) session.get(DeviceCategory.class, 2);
		assertNotNull(category2);
		
	}
	
	
	
}
