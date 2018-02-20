package com.clps.bj.mms.sm.dao;

import java.util.List;
import java.util.Map;

import com.clps.bj.mms.sm.entity.UserInfoDetail;
import com.clps.bj.mms.sm.entity.UserInfoMain;
import com.clps.bj.mms.sm.vo.UserInfoVo;

/**
 * 
 * @Description: 用户主表的实体层接口
 * 
 * @className：UserInfoMainDao
 * @author jiangying
 * @version V1.0.0 2018年1月25日下午2:03:19
 */
public interface UserInfoMainDao {

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
	 *            Integer 用户编号
	 * @param userIsEnable是否是有效数据
	 * @param userStatus是否被激活
	 * @return UserInfoMain 用户
	 */
	public UserInfoMain queryUserInfoMain(Integer userId, String userIsEnable, Integer userStatus);

	/**
	 * @Description:可以根据用户名称获取对应用户信息
	 * @param userName
	 *            String 用户名称
	 * @param userIsEnable是否是有效数据
	 * @param userStatus是否被激活
	 * @return UserInfoMain 用户
	 */
	public UserInfoMain queryUserInfoMainByName(String userName, String userIsEnable, Integer userStatus);

	/**
	 * 
	 * @Description:根据ID删除用户信息(逻辑删除)
	 * @param userId
	 *            用户编号
	 * @return boolean true 删除成功 false 删除失败
	 *
	 */
	public boolean deleteUserMainById(Integer userId);

	/**
	 * 
	 * @Description:根据ID更新用户信息
	 * @param user
	 * @return boolean
	 *
	 */
	public boolean updateUserInfoMainById(UserInfoMain user);

	/**
	 * 
	 * @Description:查询所有用户并分页
	 * @param currentPage
	 *            当前页
	 * @param pageSize
	 *            页长
	 * @return List<UserInfoMain>
	 *
	 */
	public List<UserInfoMain> queryAllUserInfoMainByPage(int currentPage, int pageSize, String userIsEnable,
			Integer userStatus);

	

	/**
	 * @Description:通过map查询所有用户
	 * 
	 * @return map
	 */
	public Map<Integer,UserInfoMain> queryAllUserInfoMainByMap(String userIsEnable,Integer userStatus);
		
	
	/**
	 * 
	 * @Description:查询所有用户
	 * @return List<UserInfoMain>
	 *
	 */

	public List<UserInfoMain> queryAllUserInfoMain(String userIsEnable, Integer userStatus);

	/**
	 * 查询对应的用户组信息的方法(通过角色id/部门id/职位id)
	 * 
	 * @param user用户
	 *            currentPage当前页 pageSize每页显示记录数 userIsEnable是否有效 userStatus
	 * @return
	 */
	// public List<UserInfoMain> getUserInfoMainList(UserInfoMain user,int
	// currentPage,int pageSize,String userIsEnable,Integer userStatus);

	/**
	 * 
	 * @Description:根据部门id查询所有用户并分页
	 * @param currentPage
	 *            当前页
	 * @param pageSize
	 *            页长
	 * @param deptId
	 *            部门编号
	 * @param userIsEnable
	 *            是否有效
	 * @param userStatus
	 *            是否被激活
	 * @return List<UserInfoMain>
	 *
	 */
	public List<UserInfoMain> queryUserByDeptIdByPage(Integer deptId, int currentPage, int pageSize, String userIsEnable,
			Integer userStatus);

	/**
	 * 
	 * @Description:根据角色id查询所有用户并分页
	 * @param currentPage
	 *            当前页
	 * @param pageSize
	 *            页长
	 * @param roleId
	 *            角色编号
	 * @param userIsEnable
	 *            是否有效
	 * @param userStatus
	 *            是否被激活
	 * @return List<UserInfoMain>
	 *
	 */
	public List<UserInfoMain> queryUserByRoleIdByPage(Integer roleId, int currentPage, int pageSize, String userIsEnable,
			Integer userStatus);

	/**
	 * 
	 * @Description:根据职位id查询所有用户并分页
	 * @param currentPage
	 *            当前页
	 * @param pageSize
	 *            页长
	 * @param positionId
	 *            职位编号
	 * @param userIsEnable
	 *            是否有效
	 * @param userStatus
	 *            是否被激活
	 * @return List<UserInfoMain>
	 *
	 */
	public List<UserInfoMain> queryUserByPosIdByPage(Integer positionId, int currentPage, int pageSize, String userIsEnable,
			Integer userStatus);

	/**
	 * 查询对应的用户信息的方法(通过用户id/用户名称)
	 * 
	 * @param user
	 * @return
	 */
	
	/*1111111111111111111111111111111111111111111111111*/
	//public UserInfoVo queryUserInfoMainByTerm(UserInfoMain user);

	/**
	 * 
	 * queryLoginUserInfoByName:查询用户登录信息. 
	 * @param name
	 * @return UserInfo
	 * @throws DataAccessException
	 */
	public UserInfoMain queryLoginUserInfoByName(String name, String userIsEnable, Integer userStatus)  ;

	
	
	/***********************************************************************/
	/**
	 * 
	 * @Description:根据部门id查询所有用户
	 * @param deptId
	 *            部门编号
	 * @param userIsEnable
	 *            是否有效
	 * @param userStatus
	 *            是否被激活
	 * @return List<UserInfoMain>
	 *
	 */
	public List<UserInfoMain> queryUserByDeptId(Integer deptId, String userIsEnable,
			Integer userStatus);

	/**
	 * 
	 * @Description:根据角色id查询所有用户
	 * @param roleId
	 *            角色编号
	 * @param userIsEnable
	 *            是否有效
	 * @param userStatus
	 *            是否被激活
	 * @return List<UserInfoMain>
	 *
	 */
	public List<UserInfoMain> queryUserByRoleId(Integer roleId, String userIsEnable,Integer userStatus);

	/**
	 * 
	 * @Description:根据职位id查询所有用户
	 * @param positionId
	 *            职位编号
	 * @param userIsEnable
	 *            是否有效
	 * @param userStatus
	 *            是否被激活
	 * @return List<UserInfoMain>
	 *
	 */
	public List<UserInfoMain> queryUserByPosId(Integer positionId, String userIsEnable,
			Integer userStatus);

	/**
	 * 修改指定用户的角色
	 * @return true  修改成功  false 修改失败
	 * @param roleId  角色编号
	 * @param userId 用户编号
	 */
	public Boolean updateuserrole(Integer roleId,Integer userId, String userIsEnable, Integer userStatus);
	
	
	/**
	 * 获取所有的指定职位外的人员
	 * @param positionId
	 */
	public List<UserInfoMain> getAllLeadingPer(Integer positionId);

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
