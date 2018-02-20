package com.clps.bj.mms.sm.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.clps.bj.mms.common.util.exception.UserInfoServiceException;
import com.clps.bj.mms.sm.entity.UserInfoMain;
import com.clps.bj.mms.sm.vo.UserInfoVo;


/**
 * @Description: 用户服务接口层,对外发布的服务
 * 
 * @className：IUserInfoMainService
 * @author jiangying
 * @version V1.0.0 2018年1月25日下午5:15:24
 */
public interface IUserInfoMainService {

	/**
	 * @Description:查询所有用户
	 * 
	 * @return List
	 */
	public List<UserInfoMain> getAllUserInfoMain();
	
	/**
	 * @Description:查询所有用户VO
	 * 
	 * @return List
	 */
	public List<UserInfoVo> getAllUserInfoMainVo();


	/**
	 * @Description:通过map查询所有用户
	 * 
	 * @return map
	 */
	public Map<Integer,UserInfoMain> getAllUserInfoMainByMap();
	
	/**
	 * @Description:查询所有用户并分页
	 * @param currentPage
	 *            当前页
	 * @Param pageSize 总记录数
	 * @return List
	 */
	public List<UserInfoMain> getAllUserInfoMainByPage(int currentPage, int pageSize);

	/**
	 * 
	 * @Description:添加用户
	 * @param UserInfoMain
	 *            用户
	 * @return boolean true 添加成功 false 添加失败
	 *
	 */
	public boolean addUserMain(UserInfoMain user);

	/**
	 * @Description:可以根据用户编号获取对应用户信息
	 * @param userId
	 *            int 用户编号
	 * @return UserInfoMain 用户
	 */
	public UserInfoMain getUserInfoMain(Integer userId);

	/**
	 * @Description:可以根据用户名称获取对应用户信息
	 * @param userName
	 *            String 用户名称
	 * @return UserInfoMain 用户
	 */
	public UserInfoMain getUserInfoMainByName(String userName);

	/**
	 * 
	 * @Description:根据ID删除用户信息(逻辑删除)
	 * @param userId
	 *            用户编号
	 * @return boolean true 删除成功 false 删除失败
	 *
	 */
	public boolean deleteUserMain(Integer userId);

	/**
	 * 
	 * @Description:根据ID更新用户信息
	 * @param user
	 * @return boolean
	 *
	 */
	public boolean updateUserMain(UserInfoMain user);

	/**
	 * 
	 * @Description:根据部门id查询对应用户并分页
	 * @param currentPage
	 *            当前页
	 * @param pageSize
	 *            页长
	 * @param UserInfoMain
	 * 
	 * @return List<UserInfoMain>
	 *
	 */

	public List<UserInfoMain> getUserInfoMainByDeptIdByPage(Integer deptId, int currentPage, int pageSize);

	/**
	 * 
	 * @Description:根据角色id查询对应用户并分页
	 * @param roleId
	 * @param currentPage
	 *            当前页
	 * @param pageSize
	 *            页长
	 * @param UserInfoMain
	 * 
	 * @return List<UserInfoMain>
	 *
	 */
	public List<UserInfoMain> getUserInfoMainByRoleIdByPage(Integer roleId, int currentPage, int pageSize);

	/**
	 * 
	 * @Description:根据职位id查询对应用户并分页
	 * @param positionId
	 * @param currentPage
	 *            当前页
	 * @param pageSize
	 *            页长
	 * @param UserInfoMain
	 * 
	 * @return List<UserInfoMain>
	 *
	 */
	public List<UserInfoMain> getUserInfoMainByPosIdByPage(Integer positionId, int currentPage, int pageSize);

	/**
	 * 查询对应的用户信息的方法(通过用户id/用户名称)
	 * 
	 * @param user
	 * @return
	 */
	/*11111111111111111111111111111111111111111*/
	//public UserInfoVo getUserInfoMainByTerm(UserInfoMain user);

	/**
	 * 用户登录 验证核实用户
	 * 
	 * @param name
	 * @param password
	 * @return
	 * @throws UserInfoServiceException 
	 */
	public UserInfoMain login(HttpServletRequest request,String name, String password) throws UserInfoServiceException;
	
	
	
	/******************不带分页**************/
	/**
	 * 
	 * @Description:根据部门id查询对应用户
	 * @param UserInfoMain
	 * 
	 * @return List<UserInfoMain>
	 *
	 */

	public List<UserInfoMain> getUserInfoMainByDeptId(Integer deptId);

	/**
	 * 
	 * @Description:根据角色id查询对应用户
	 * @param roleId
	 * @param UserInfoMain
	 * 
	 * @return List<UserInfoMain>
	 *
	 */
	public List<UserInfoMain> getUserInfoMainByRoleId(Integer roleId);

	/**
	 * 
	 * @Description:根据职位id查询对应用户
	 * @param positionId
	 * @param UserInfoMain
	 * 
	 * @return List<UserInfoMain>
	 *
	 */
	public List<UserInfoMain> getUserInfoMainByPosId(Integer positionId);
	
	/**
	 * 修改指定用户的角色
	 * @return true  修改成功  false 修改失败
	 * @param roleId  角色编号
	 * @param userId 用户编号
	 */
	public Boolean updateuserrole(Integer roleId,Integer userId);
	
	
	/**
	 * 获取所有除指定职位外的所有对象
	 * @param string
	 * @return List<UserInfoVo>
	 */
	public List<UserInfoVo> getAllLeadingPerVo(String string);



	/**
	 * 
	 * @Description:添加用户
	 * @param UserInfoMain
	 *            用户
	 * @return Integer 用户id
	 *
	 */
	public Integer addUserInfoMainReturnId(UserInfoMain user);
	
}
	