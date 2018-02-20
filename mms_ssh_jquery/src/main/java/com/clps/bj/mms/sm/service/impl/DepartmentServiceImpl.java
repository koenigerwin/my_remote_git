/** 
 * Project Name:mms_ssh(springmvc+spring+hibernate) 
 * File Name:DepartmentServiceImpl.java 
 * Package Name:com.clps.bj.mms.sm.service.impl 
 * Date:2018年1月24日 上午11:13:57 
 * Copyright (c) 2018, erwin.wang@clpsglobal.com All Rights Reserved. 
 * 
 */
package com.clps.bj.mms.sm.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clps.bj.mms.common.util.data.CompareEmptyUtil;
import com.clps.bj.mms.sm.dao.DepartmentDao;
import com.clps.bj.mms.sm.entity.Department;
import com.clps.bj.mms.sm.service.IDepartmentService;
import com.clps.bj.mms.sm.vo.DeptInfo;
import com.clps.bj.mms.sm.vo.UserInfoVo;

/** 
 * ClassName: DepartmentServiceImpl
*  date:2018年1月24日 上午11:13:57 
*  
*  @author Kyoma.yu
*  @version 0.0.1V 
*  @since JDK 1.8 
* 
*/
@Service
public class DepartmentServiceImpl implements IDepartmentService {
	
	@Autowired
	private DepartmentDao departmentDao;
	private boolean flag;
	private List<Department> list;
	
	
	/* (non-Javadoc)
	 * @see com.clps.bj.mms.sm.service.IDepartmentService#getDepartment(java.lang.String)
	 */
	@Override
	public List<Department> getDepartment(String name) {
		list = null;
		try {
			list = departmentDao.getDepartmentsByName(name);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	/* (non-Javadoc)
	 * @see com.clps.bj.mms.sm.service.IDepartmentService#getParents()
	 */
	@Override
	public List<Department> getParents() {
		list = null;
		try {
			list = departmentDao.getParents();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	/* (non-Javadoc)
	 * @see com.clps.bj.mms.sm.service.IDepartmentService#getChildDepartment(java.lang.Integer)
	 */
	@Override
	public List<Department> getChildDepartment(Integer id) {
		list = null;
		try {
			list = departmentDao.getChildDepartment(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	/* (non-Javadoc)
	 * @see com.clps.bj.mms.sm.service.IDepartmentService#addDepartment(com.clps.bj.mms.sm.entity.Department)
	 */
	@Override
	public boolean addDepartment(Department dept) {
		flag = false;
		try {
			flag = departmentDao.addDepartment(dept);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}

	/* (non-Javadoc)
	 * @see com.clps.bj.mms.sm.service.IDepartmentService#updateDepartment(com.clps.bj.mms.sm.entity.Department)
	 */
	@Override
	public boolean updateDepartment(Department dept) {
		flag = false;
		try {
			flag = departmentDao.updateDepartment(dept);
			List<Department> list = departmentDao.getChildDepartment(dept.getDeptId());
			if(!CompareEmptyUtil.isEmpty(list)){
				for(Department temp : list){
					flag = departmentDao.updateChildDepartment(temp);
					if (flag != true)
						return flag;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}

	/* (non-Javadoc)
	 * @see com.clps.bj.mms.sm.service.IDepartmentService#deleteDepartment(java.lang.Integer)
	 */
	@Override
	public boolean deleteDepartment(Integer id) {
		flag = false;
		try {
			List<Integer> list = departmentDao.getParentAndChildrenDepartmentId(id);
			if(CompareEmptyUtil.isNotEmpty(list)){
				for(Integer i : list){
					flag = departmentDao.deleteDepartment(i);
					if(flag != true){
						return flag;
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}

	/* (non-Javadoc)
	 * @see com.clps.bj.mms.sm.service.IDepartmentService#getDeptByVo()
	 */
	@Override
	public List<DeptInfo> getDeptByVo() {
		List<DeptInfo> myinfos = new ArrayList<>();
		try {
			list = departmentDao.getAllDepts();
			DeptInfo myInfo = null;
			for(Department dept:list){
				myInfo = new DeptInfo();
				myInfo.setId(dept.getDeptId());
				myInfo.setName(dept.getDeptName());
				myInfo.setAb(dept.getDeptAb());
				myInfo.setCreateName(dept.getDeptCreatedName());
				myInfo.setDate(dept.getDeptCreatedDatetime());
				myInfo.setManager(dept.getDeptDefault1());
				myInfo.setPid(dept.getDeptParentId());
				myinfos.add(myInfo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return myinfos;
	}

	/* (non-Javadoc)
	 * @see com.clps.bj.mms.sm.service.IDepartmentService#getDeptNameById(java.lang.Integer)
	 */
	@Override
	public Department getDeptById(Integer id) {
		try {
			Department dept =  departmentDao.getDepartmentById(id);
			if(dept != null){
				return dept;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/* (non-Javadoc)
	 * @see com.clps.bj.mms.sm.service.IDepartmentService#getDeptByCombo()
	 */
	@Override
	public List<DeptInfo> getDeptByCombo() {
		List<DeptInfo> myinfos = new ArrayList<>();
		try {
			list = departmentDao.getAllDepts();
			DeptInfo myInfo = null;
			for(Department dept:list){
				myInfo = new DeptInfo();
				myInfo.setId(dept.getDeptId());
				myInfo.setName(dept.getDeptName());
				myInfo.setPid(dept.getDeptParentId());
				myinfos.add(myInfo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return myinfos;
	}

	/* (non-Javadoc)
	 * @see com.clps.bj.mms.sm.service.IDepartmentService#infoToDept(com.clps.bj.mms.sm.vo.DeptInfo)
	 */
	@Override
	public Department infoToDept(DeptInfo deptInfo) {
		Department dept = new Department();
		dept.setDeptId(deptInfo.getId());
		dept.setDeptAb(deptInfo.getAb());
		dept.setDeptDefault1(deptInfo.getManager());
		dept.setDeptName(deptInfo.getName());
		dept.setDeptParentId(deptInfo.getPid());
		return dept;
	}

	/* (non-Javadoc)
	 * @see com.clps.bj.mms.sm.service.IDepartmentService#getParentAndChildrenDepartmentId(java.lang.Integer)
	 */
	@Override
	public List<Integer> getParentAndChildrenDepartmentId(Integer id) {
		List<Integer> list = new ArrayList<>();
		try {
			list = departmentDao.getParentAndChildrenDepartmentId(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	/* (non-Javadoc)
	 * @see com.clps.bj.mms.sm.service.IDepartmentService#getParentAndChildrenDepartmentId(java.util.List, java.util.List)
	 */
	@Override
	public List<UserInfoVo> getUserInfo(List<Integer> id, List<UserInfoVo> list) {
		List<UserInfoVo> userInfoVo = new ArrayList<>();
		for(UserInfoVo vo : list){
			for(Integer deptId : id){
				if(deptId == vo.getDeptId()){
					userInfoVo.add(vo);
					break;
				}
			}
		}
		return userInfoVo;
	}

}
 