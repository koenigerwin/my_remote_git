package com.clps.bj.mms.sm.dao.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.clps.bj.mms.common.util.data.CompareEmptyUtil;
import com.clps.bj.mms.constant.DepartmentConstant;
import com.clps.bj.mms.constant.TimeFormatConstant;
import com.clps.bj.mms.sm.dao.DepartmentDao;
import com.clps.bj.mms.sm.entity.Department;

/**
 * @description：部门实体功能实现
 * @className：DepartmentDaoImpl
 * @author Kyoma.yu
 * @version V1.0.0 2018年1月23日 下午4:59:11
 * 
 */
@Repository
public class DepartmentDaoImpl implements DepartmentDao {
	@Resource
	private SessionFactory sessionFactory;

	private static final String Hql_queryDeptById = "from Department where deptId = ?";
	private static final String Hql_queryParentAndChildrenId = "select d.deptId from Department d where d.deptSortId like?";
	private static final String Hql_queryDeptsByName = "from Department where deptName like ?";
	private static final String Hql_queryParents = "from Department where deptNlevel = ?";
	private static final String Hql_queryChildDept = "from Department where deptParentId=?";
	private static final String Hql_updateChild = "update Department set deptSortId=?,deptNlevel=?,"
			+ "deptUpdatedDatetime=?,deptUpdatedName=? where deptId=?";
	private static final String Hql_deleteDept = "delete Department where deptId = ?";
	private static final String Hql_updateDept = "update Department set deptName = ?,deptParentId=?,deptAb=?,"
			+ "deptSortId=?,deptNlevel=?,deptUpdatedDatetime=?,deptUpdatedName=?,deptDefault1 = ?where deptId=?";
	private static final String Hql_queryAllDepts = "from Department";
	private static final String Hql_queryDeptByName = "from Department where deptName = ?";
	boolean flag = false;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.clps.bj.mms.sm.dao.DepartmentDao#getDepartmentById(java.lang.Integer)
	 */
	@Override
	public Department getDepartmentById(Integer id) throws Exception {
		return (Department) sessionFactory.getCurrentSession().createQuery(Hql_queryDeptById).setParameter(0, id)
				.uniqueResult();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.clps.bj.mms.sm.dao.DepartmentDao#getDepartment(java.lang.String)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Department> getDepartmentsByName(String name) throws Exception {
		return (List<Department>) sessionFactory.getCurrentSession().createQuery(Hql_queryDeptsByName)
				.setParameter(0, "%" + name + "%").list();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.clps.bj.mms.sm.dao.DepartmentDao#getParents()
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Department> getParents() throws Exception {
		return (List<Department>) sessionFactory.getCurrentSession().createQuery(Hql_queryParents)
				.setParameter(0, DepartmentConstant.topLevel).list();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.clps.bj.mms.sm.dao.DepartmentDao#getChildDepartment(java.lang.
	 * Integer)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Department> getChildDepartment(Integer id) throws Exception {
		return (List<Department>) sessionFactory.getCurrentSession().createQuery(Hql_queryChildDept).setParameter(0, id)
				.list();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.clps.bj.mms.sm.dao.DepartmentDao#addDepartment(com.clps.bj.mms.sm.
	 * entity.Department)
	 */
	@Override
	public boolean addDepartment(Department dept) throws Exception {
		String dept_created_datetime = new SimpleDateFormat(TimeFormatConstant.YYYY_MM_DD).format(new Date())
				.toString();
		dept.setDeptCreatedDatetime(dept_created_datetime);
		// 从session取id
		dept.setDeptCreatedName(1);
		String dept_updated_datetime = new SimpleDateFormat(TimeFormatConstant.YYYY_MM_DD).format(new Date())
				.toString();
		dept.setDeptUpdatedDatetime(dept_updated_datetime);
		// 从session取id
		dept.setDeptUpdatedName(1);
		Integer id = (Integer) sessionFactory.getCurrentSession().save(dept);
		dept.setDeptSortId((String) getSortIdAndLevel(dept).get(DepartmentConstant.sortId));
		dept.setDeptNlevel((Integer) getSortIdAndLevel(dept).get(DepartmentConstant.level));
		return id > 0;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.clps.bj.mms.sm.dao.DepartmentDao#updateDepartment(com.clps.bj.mms.sm.
	 * entity.Department)
	 */
	@Override
	public boolean updateDepartment(Department dept) throws Exception {

		flag = false;
		flag = !getParentAndChildrenDepartmentId(dept.getDeptId()).contains(dept.getDeptParentId());
		if (flag != true) {
			return flag;
		} else {
			String dept_updated_datetime = new SimpleDateFormat(TimeFormatConstant.YYYY_MM_DD).format(new Date())
					.toString();
			Query query = sessionFactory.getCurrentSession().createQuery(Hql_updateDept);
			query.setParameter(0, dept.getDeptName());
			query.setParameter(1, dept.getDeptParentId());
			query.setParameter(2, dept.getDeptAb());
			query.setParameter(3, getSortIdAndLevel(dept).get(DepartmentConstant.sortId));
			query.setParameter(4, getSortIdAndLevel(dept).get(DepartmentConstant.level));
			query.setParameter(5, dept_updated_datetime);
			// 从session中获取dept_updated_name
			query.setParameter(6, 1);
			query.setParameter(7, dept.getDeptDefault1());
			query.setParameter(8, dept.getDeptId());
			flag = query.executeUpdate() > 0;
		}
		return flag;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.clps.bj.mms.sm.dao.DepartmentDao#updateChildDepartment(com.clps.bj.
	 * mms.sm.entity.Department)
	 */
	@Override
	public boolean updateChildDepartment(Department dept) throws Exception {
		flag = false;
		String dept_updated_datetime = new SimpleDateFormat(TimeFormatConstant.Y_M_D_H_M_S).format(new Date())
				.toString();
		Query query = sessionFactory.getCurrentSession().createQuery(Hql_updateChild);
		sessionFactory.getCurrentSession().clear();
		query.setParameter(0, getSortIdAndLevel(dept).get(DepartmentConstant.sortId));
		query.setParameter(1, getSortIdAndLevel(dept).get(DepartmentConstant.level));
		query.setParameter(2, dept_updated_datetime);
		// 从session中获取dept_updated_name
		query.setParameter(3, 1);
		query.setParameter(4, dept.getDeptId());
		flag = query.executeUpdate() > 0;
		if (flag != true)
			return flag;
		List<Department> depts = getChildDepartment(dept.getDeptId());
		if (CompareEmptyUtil.isNotEmpty(depts)) {
			for (Department d : depts) {
				flag = updateChildDepartment(d);
				if (flag != true)
					return flag;
			}
		}
		return flag;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.clps.bj.mms.sm.dao.DepartmentDao#deleteDepartment(java.lang.Integer)
	 */
	@Override
	public boolean deleteDepartment(Integer id) throws Exception {
		flag = false;
		flag = sessionFactory.getCurrentSession().createQuery(Hql_deleteDept).setParameter(0, id).executeUpdate() > 0;
		if (flag != true) {
			return flag;
		}
		return flag;
	}

	/**
	 * 获取排序id和深度
	 * 
	 * @param department
	 *            要获取排序号的部门对象
	 * @return Map<String,Integer>
	 */
	public Map<String, Object> getSortIdAndLevel(Department department) {
		Integer levle = null;
		String sortId = "";
		Map<String, Object> map = new HashMap<>();
		Integer tempPid = department.getDeptParentId();
		try {
			if(tempPid == null || tempPid == 0){
				sortId ="0," + department.getDeptId();
				levle = 1;
			}else{
				Department parentDept = null;
				parentDept = getDepartmentById(tempPid);
				sortId = parentDept.getDeptSortId() + "," + department.getDeptId();
				levle = parentDept.getDeptNlevel() + 1;
			}
			map.put(DepartmentConstant.sortId, sortId);
			map.put(DepartmentConstant.level, levle);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.clps.bj.mms.sm.dao.DepartmentDao#getParentAndChildrenDepartmentId(
	 * java.lang.Integer)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Integer> getParentAndChildrenDepartmentId(Integer id) throws Exception {
		List<Integer> list = new ArrayList<>();
		Department dept = getDepartmentById(id);
		if (CompareEmptyUtil.isNotEmpty(dept)) {
			list = sessionFactory.getCurrentSession().createQuery(Hql_queryParentAndChildrenId)
					.setParameter(0, dept.getDeptSortId() + "%").list();
		}
		return list;
	}

	/* (non-Javadoc)
	 * @see com.clps.bj.mms.sm.dao.DepartmentDao#getAllDepts()
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Department> getAllDepts() throws Exception {
		return sessionFactory.getCurrentSession().createQuery(Hql_queryAllDepts).list();
	}

	/* (non-Javadoc)
	 * @see com.clps.bj.mms.sm.dao.DepartmentDao#getDepartmentById(java.lang.String)
	 */
	@Override
	public Department getDepartmentByName(String name) throws Exception {
		return (Department) sessionFactory.getCurrentSession().createQuery(Hql_queryDeptByName).setParameter(0, name).uniqueResult();
	}

}
