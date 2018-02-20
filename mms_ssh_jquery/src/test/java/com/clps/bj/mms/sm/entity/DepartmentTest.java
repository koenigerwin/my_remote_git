/** 
 * Project Name:mms_ssh(springmvc+spring+hibernate) 
 * File Name:UserTest.java 
 * Package Name:com.clps.bj.mms.sm.entity 
 * Date:2018年1月17日下午4:28:37 
 * Copyright (c) 2018, erwin.wang@clpsglobal.com All Rights Reserved. 
 * 
 */
package com.clps.bj.mms.sm.entity;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.clps.bj.mms.constant.TimeFormatConstant;
import com.clps.bj.mms.util.hibernate.HibernateUtil;

/**
 * ClassName: DepartmentTest 
 * date: 2018年1月22日15:28:35 
 * 
 * @author Kyoma.yu
 * @version 0.0.1V
 * @since JDK 1.8
 */
public class DepartmentTest {

	private Session session = null;
	private Transaction transaction = null;
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		this.session = HibernateUtil.openSession();
		transaction = session.beginTransaction();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		HibernateUtil.close(this.session);
	}

	@Test
	public void testAdd() throws Exception {
		
		try {
			Department dept = new Department();
			dept.setDeptName("财务部");
			dept.setDeptSortId("1");
			dept.setDeptAb("cwb");
			dept.setDeptCreatedDatetime(new SimpleDateFormat(TimeFormatConstant.Y_M_D_H_M_S).format(new Date())
					.toString());
			dept.setDeptCreatedName(1);
			dept.setDeptUpdatedDatetime(new SimpleDateFormat(TimeFormatConstant.Y_M_D_H_M_S).format(new Date())
					.toString());
			dept.setDeptUpdatedName(1);
			session.save(dept);
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			if (session != null)
				transaction.rollback();
		}
	}

	@Test
	public void testLoad() {
		try {
		Department u = (Department) session.load(Department.class, 1);
		System.out.println(u);
		}catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Test
	public void testUpdate() {
		try {
			Department u = (Department) session.load(Department.class, 1);
			u.setDeptAb("cwb2");
			session.update(u);
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			if (session != null)
				transaction.rollback();
		}
	}

	@Test
	public void testDelete() {
		Transaction transaction = session.beginTransaction();
		try {
			Department dept = (Department) session.load(Department.class, 1);
			session.delete(dept);
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			if (session != null)
				transaction.rollback();
		} 
	}

	@Test
	public void testList() {
		try {
			@SuppressWarnings("unchecked")
			List<Department> depts = session.createQuery("from Department").list();
			for (Department u : depts) {
				System.out.println(u);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testPager() {
		Session session = null;
		try {
			session = HibernateUtil.openSession();
			@SuppressWarnings("unchecked")
			List<Department> depts = session.createQuery("from Department").setFirstResult(0).setMaxResults(1).list();
			for (Department u : depts) {
				System.out.println(u);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
