/**   
* @Title: DeviceServiceImplTest.java 
* @Package com.clps.bj.mms.bm.service.impl 
* @Description: (用一句话描述该文件做什么) 
* @author userdwt  
* @date 2018年1月23日 下午3:33:56 
* @version V1.0   
*/
package com.clps.bj.mms.bm.service.impl;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.clps.bj.mms.bm.entity.Device;
import com.clps.bj.mms.bm.service.IDeviceService;
import com.clps.bj.mms.bm.vo.EasyUIDataGridResult;

/** 
* @ClassName: DeviceServiceImplTest 
* @Description: 测试关于Device的service层的实现 
* @author userdwt
* @date 2018年1月23日 下午3:33:56 
*  
*/
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"classpath:beans.xml"})
public class DeviceServiceImplTest {
	
	private Logger logger=LoggerFactory.getLogger(DeviceServiceImplTest.class);
	
	@Autowired
	private IDeviceService iDeviceService;
	
	/**
	 * 
	* @Title: testMethod 
	* @Description: 测试方法: findDevicesByPageAndConditions
	* @throws
	 */
	@Test
	public void testMethod() {
		
		//findDevicesByPageAndConditions
		
		EasyUIDataGridResult result=iDeviceService.findDevicesByPageAndConditions(null, null, new Device());
		
		logger.info("info:  findDevicesByPageAndConditions"+result+"-->"+result.getRows().size());
		
		
		
	}

	/**
	 * 
	* @Title: test1 
	* @Description: 测试方法deleteByPrimaryKey
	 */
	@Test
	public void test1() {

		boolean b = iDeviceService.deleteByPrimaryKey(1);

		logger.info("info: deleteByPrimaryKey" + b);

	}

	/**
	 * 
	* @Title: test12 
	* @Description: 测试添加设备 
	 */
	@Test
	public void test12() {

		Device device = new Device();
		device.setDeviceName("设备1");
		boolean b2 = iDeviceService.add(device);

		logger.info("info:  add" + b2);

	}
	/**
	 * 
	* @Title: test13 
	* @Description: 测试方法 selectByPrimaryKey
	 */
	@Test
	public void test13() {
		
		Device device2=iDeviceService.selectByPrimaryKey(1);
		
		logger.info("info:  selectByPrimaryKey"+device2);
		
	}

	/**
	 * 
	* @Title: test14 
	* @Description: 测试借用设备(更改设备的状态) 
	 */
	@Test
	public void test14() {

		// 借用设备
		Device borrow = new Device();
		borrow.setDeviceStatus(0);
		borrow.setDeviceRoomId(1);
		borrow.setDeviceId(1);

		boolean b3 = iDeviceService.borrowDeviceByDeviceId(borrow);

		logger.info("info:  getDeviceByDeviceId" + b3);

	}
	/**
	 * 
	* @Title: test15 
	* @Description: 测试归还设备(更改设备的状态)
	 */
	@Test
	public void test15() {
		
		//归还设备
		Device restore=new Device();
		restore.setDeviceStatus(1);
		restore.setDeviceRoomId(null);
		restore.setDeviceId(1);
		
		boolean b4=iDeviceService.restoreDevice(restore);
		
		logger.info("info: restoreDevice"+b4);
		
	}
	/**
	 * 
	* @Title: test16 
	* @Description: 测试查询所有设备
	 */
	@Test
	public void test16() {
		
		//selectAll
		
		List<Device> list=iDeviceService.selectAll();
		
		logger.info("info: selectAll"+list);
		
	}
	/**
	 * 
	* @Title: test17 
	* @Description: 测试方法selectByDeviceCid 
	 */
	@Test
	public void test17() {
		
		//selectByDeviceCid
		
		List<Device> devicesByCid=iDeviceService.selectByDeviceCid(1);
		
		logger.info("info: selectByDeviceCid"+devicesByCid);
		
	}

}
