package com.clps.bj.mms.sm.dao;

import java.util.List;

import com.clps.bj.mms.sm.entity.Department;

/**
 * 
 * @description：部门实体层接口
 * @className：DepartmentDao
 * @author Kyoma.yu
 * @version V1.0.0
 * 2018年1月22日 下午3:01:37 
 */
public interface DepartmentDao {
	
	/**
     * 
     * @Description:根据部门ID查询部门
     * @param id 部门id
     * @return Department
     * @throws Exception 
     */
    public Department getDepartmentById(Integer id) throws Exception;
    
	/**
     * 
     * @Description:根据部门名模糊查询获取部门集合
     * @param name
     * @return List<Department>
     * @throws Exception 
     */
    public List<Department> getDepartmentsByName(String name) throws Exception;
    
    /**
     * 
     * @Description:获取父部门集合
     * @return List<Department>
     * @throws Exception 
     */
    public List<Department> getParents() throws Exception;
    
	/**
	 * @Description:通过id找到该部门的子部门
	 * @param id  部门id
	 * @return  List<Department> 查找到的所有的子类集合
	 * @throws Exception 
	 */
	public List<Department> getChildDepartment(Integer id) throws Exception;
	
	
	/**
	 * @Description:添加部门
	 * @param Department
	 * @return  boolean true 成功 false 失败
	 * @throws Exception 
	 */
	public boolean addDepartment(Department dept) throws Exception;
	
	/**
	 * @Description:根据ID更新部门信息
	 * @param Department
	 * @return  boolean true 成功 false 失败
	 * @throws Exception 
	 */
	public boolean updateDepartment(Department dept) throws Exception;
	
	/**
	 * @Description:更新该部门的全部子孙部门
	 * @param Department
	 * @return  boolean true 成功 false 失败
	 * @throws Exception 
	 */
	public boolean updateChildDepartment(Department dept) throws Exception;
	
	/**
	 * @Description:根据ID删除部门信息
	 * @param id  部门id
	 * @return  boolean true 成功 false 失败
	 * @throws Exception 
	 */
	public boolean deleteDepartment(Integer id) throws Exception;
	
	/**
	 * @Description:根据ID获取该部门及其子孙部门的id
	 * @param id  部门id
	 * @return  List<Integer>
	 * @throws Exception 
	 */
	public List<Integer> getParentAndChildrenDepartmentId(Integer id) throws Exception;
	
	/**
	 * @Description:获取全部部门
	 * @return  List<Department>
	 * @throws Exception 
	 */
	public List<Department> getAllDepts() throws Exception;
	
	/**
     * 
     * @Description:根据部门名查询部门
     * @param name 部门名
     * @return Department
     * @throws Exception 
     */
    public Department getDepartmentByName(String name) throws Exception;
    
   
}
 