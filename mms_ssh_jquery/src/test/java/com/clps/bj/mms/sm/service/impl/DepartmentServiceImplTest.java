/**
 * @Description:SpringMVC Spring Hibernate    
 * @Title: DepartmentServiceImplTest.java  
 * @Package com.clps.bj.mms.sm.service.impl   
 * @author Kyoma.yu     
 * @version V1.0 
 *   
 */
package com.clps.bj.mms.sm.service.impl;


import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.clps.bj.mms.sm.entity.Department;
import com.clps.bj.mms.sm.service.IDepartmentService;

/** 
 * @description: Department testing class
 * @className：DepartmentServiceImplTest
*  @author Kyoma.yu
*  @version V1.0.0
*  2018年1月24日 下午4:57:19 
* 
*/
@RunWith(SpringJUnit4ClassRunner.class)  
@ContextConfiguration(locations = {"classpath*:beans.xml"})
public class DepartmentServiceImplTest {
	
	@Autowired
	private IDepartmentService departmentService;
	private List<Department> list;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		Department dept = null;
		list = new ArrayList<>();
		for(int i = 0; i < 4; i++){
			dept = new Department();
			dept.setDeptAb("dept"+i);
			dept.setDeptName("dept_name"+i);
			list.add(dept);
		}
		list.get(1).setDeptParentId(1);
		list.get(2).setDeptParentId(2);
		list.get(3).setDeptParentId(1);
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testAddDepartment() {
		for(Department dept : list){
			departmentService.addDepartment(dept);
		}
	}
	
	@Test
	public void testUpdateDepartment() {
		Department dept = new Department();
		dept.setDeptId(2);
		dept.setDeptAb("b");
		dept.setDeptName("b");
		dept.setDeptParentId(4);
		departmentService.updateDepartment(dept);
	}
	
	@Test
	public void testDeleteDepartment() {
		departmentService.deleteDepartment(4);
	}
	
	@Test
	public void testFindDepartmentByName() {
		System.out.println(departmentService.getDepartment("t"));
	}
	
	@Test
	public void testGetParents() {
		System.out.println(departmentService.getParents());
	}
	
	@Test
	public void testGetChild(){
		System.out.println(departmentService.getChildDepartment(1));
	}
	

}
 