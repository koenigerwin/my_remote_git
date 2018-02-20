/**   
* @Title: DeviceCategoryServiceImplTest.java 
* @Package com.clps.bj.mms.bm.service.impl 
* @Description: (用一句话描述该文件做什么) 
* @author userdwt  
* @date 2018年1月23日 下午4:59:29 
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

import com.clps.bj.mms.bm.service.IDeviceCategoryService;
import com.clps.bj.mms.bm.vo.EasyUITreeNode;

/** 
* @ClassName: DeviceCategoryServiceImplTest 
* @Description: (这里用一句话描述这个类的作用) 
* @author userdwt
* @date 2018年1月23日 下午4:59:29 
*  
*/
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"classpath:beans.xml"})
public class DeviceCategoryServiceImplTest {
	
	private Logger logger=LoggerFactory.getLogger(DeviceCategoryServiceImplTest.class);
	
	@Autowired
	private IDeviceCategoryService iDeviceCategoryService;
	
	
	@Test
	public void test1() {
		
		//findDeviceCatsByParentId
		List<EasyUITreeNode> list=iDeviceCategoryService.findDeviceCatsByParentId(1);
		
		logger.info("info:   findDeviceCatsByParentId "+list);
	}

}
