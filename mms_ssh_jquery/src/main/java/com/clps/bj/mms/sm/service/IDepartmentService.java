
package com.clps.bj.mms.sm.service;

import java.util.List;

import com.clps.bj.mms.sm.entity.Department;
import com.clps.bj.mms.sm.vo.DeptInfo;
import com.clps.bj.mms.sm.vo.UserInfoVo;

/** 
 * 
 * @description：部门服务层接口
 * @className：IDepartmentService
*  @author Kyoma.yu
*  @version V1.0.0
*  2018年1月24日 上午10:17:55 
* 
*/

public interface IDepartmentService {

    
    /**
     * 
     * @Description:根据部门名模糊查询获取部门集合
     * @param name
     * @return List<Department>
     */
    public List<Department> getDepartment(String name);
    
    /**
     * 
     * @Description:获取父部门集合
     * @return List<Department>
     */
    public List<Department> getParents();
    
	/**
	 * @Description:通过id找到该部门的子部门
	 * @param id  部门id
	 * @return  List<Department> 查找到的所有的子类集合
	 */
	public List<Department> getChildDepartment(Integer id);
	
	/**
	 * @Description:添加部门
	 * @param Department
	 * @return  boolean true 成功 false 失败
	 */
	public boolean addDepartment(Department dept);
	
	/**
	 * @Description:根据ID更新部门信息
	 * @param Department
	 * @return  boolean true 成功 false 失败
	 */
	public boolean updateDepartment(Department dept);
	
	/**
	 * @Description:根据ID删除部门信息
	 * @param id  部门id
	 * @return  boolean true 成功 false 失败
	 */
	public boolean deleteDepartment(Integer id);
	
	/**
	 * @Description:获取部门的vo集合
	 * @return  List<DeptInfo>
	 */
	public List<DeptInfo> getDeptByVo();
	
	/**
	 * @Description:获取部门的vo集合
	 * @return  List<DeptInfo>
	 */
	public List<DeptInfo> getDeptByCombo();
	
	/**
	 * @Description:根据部门id获取部门
	 * @return  Integer id 部门id
	 */
	public Department getDeptById(Integer id);
	
	/**
	 * @Description:将vo转成Department
	 * @return  Department 
	 */
	public Department infoToDept(DeptInfo deptInfo);
	
	/**
	 * @Description:获取该部门及其子部门的id
	 * @return  List<Integer> 
	 */
	public List<Integer> getParentAndChildrenDepartmentId(Integer id);
	
	/**
	 * @Description:根据部门id的集合找出所需的vo集合
	 * @param List<Integer> id,List<UserInfoVo> list
	 * @return  List<UserInfoVo> 
	 */
	public List<UserInfoVo> getUserInfo(List<Integer> id,List<UserInfoVo> list);
	
	
	
}
 