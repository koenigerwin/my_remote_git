package com.clps.bj.mms.sm.service.impl;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clps.bj.mms.common.util.exception.UserInfoServiceException;
import com.clps.bj.mms.constant.DataRecordType;
import com.clps.bj.mms.sm.dao.UserInfoDetailDao;
import com.clps.bj.mms.sm.dao.UserInfoMainDao;
import com.clps.bj.mms.sm.entity.Position;
import com.clps.bj.mms.sm.entity.UserInfoDetail;
import com.clps.bj.mms.sm.entity.UserInfoMain;
import com.clps.bj.mms.sm.service.IUserInfoDetailService;
import com.clps.bj.mms.sm.service.IUserInfoMainService;
import com.clps.bj.mms.sm.vo.UserInfoVo;
import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;



/**
 * 
 * @Description: 实现用户服务层接口
 * 
 * @className：User
 * @author jiangying
 * @version V1.0.0 2018年1月25日下午5:26:00
 */

@Service

public class UserInfoMainServiceImpl implements IUserInfoMainService {

	@Autowired
	private UserInfoMainDao userMainDao;
	
	@Autowired
	private UserInfoDetailDao userDetailDao;
	
	@Autowired
	private RoleServiceImpl roleService;
	
	@Autowired
	private DepartmentServiceImpl deptService;
	
	@Autowired
	private PositionServiceImpl positionService;
	
	@Autowired
	private IUserInfoDetailService userinfodetailService;
	
	 private Logger logger =Logger.getLogger("console");

	private boolean flag = false;

	/**
	 * 
	 * @Description:新增用户对象数据
	 * @param UserInfoMain
	 * @return true添加成功 false添加失败
	 *
	 */
	@Override
	public boolean addUserMain(UserInfoMain user) {
		flag = this.userMainDao.addUserMain(user);
		return flag;
	}

	/**
	 * 
	 * @Description:通过id查询用户对象数据
	 * @param UserInfoMain
	 * @return UserInfoMain
	 *
	 */
	@Override
	public UserInfoMain getUserInfoMain(Integer userId) {
		return this.userMainDao.queryUserInfoMain(userId, DataRecordType.ENABLE.getId().toString(),
				DataRecordType.ENABLE.getId());

	}

	/**
	 * @Description:可以根据用户名称获取对应用户信息
	 * @param userName
	 *            String 用户名称
	 * @return UserInfoMain 用户
	 */
	public UserInfoMain getUserInfoMainByName(String userName) {
		return this.userMainDao.queryUserInfoMainByName(userName, DataRecordType.ENABLE.getId().toString(),
				DataRecordType.ENABLE.getId());

	}

	/**
	 * @Description:查询所有用户
	 * 
	 * @return List
	 */
	@Override
	public List<UserInfoMain> getAllUserInfoMain() {

		return this.userMainDao.queryAllUserInfoMain(DataRecordType.ENABLE.getId().toString(),
				DataRecordType.ENABLE.getId());

	}

	/**
	 * @Description:查询所有用户
	 * @param currentPage
	 *            当前页
	 * @Param pageSize 总记录数
	 * @return List
	 */
	public List<UserInfoMain> getAllUserInfoMainByPage(int currentPage, int pageSize) {
		return this.userMainDao.queryAllUserInfoMainByPage(currentPage, pageSize,
				DataRecordType.ENABLE.getId().toString(), DataRecordType.ENABLE.getId());

	}
	
	
	/**
	 * @Description:通过map查询所有用户
	 * 
	 * @return map
	 */
	public Map<Integer,UserInfoMain> getAllUserInfoMainByMap(){
		return this.userMainDao.queryAllUserInfoMainByMap(DataRecordType.ENABLE.getId().toString(), DataRecordType.ENABLE.getId());
	}

	/**
	 * 
	 * @Description:根据ID删除用户信息
	 * @param userId
	 *            用户编号
	 * @return boolean true 删除成功 false 删除失败
	 *
	 */
	@Override
	public boolean deleteUserMain(Integer userId) {

		return this.userMainDao.deleteUserMainById(userId);
	}

	/**
	 * 
	 * @Description:根据ID更新用户信息
	 * @param user
	 * @return boolean
	 *
	 */
	@Override
	public boolean updateUserMain(UserInfoMain user) {

		return this.userMainDao.updateUserInfoMainById(user);
	}

	/**
	 * 
	 * @Description:根据部门id查询对应用户并分页
	 * @param deptId
	 * @param currentPage
	 *            当前页
	 * @param pageSize
	 *            页长
	 * @param UserInfoMain
	 * 
	 * @return List<UserInfoMain>
	 *
	 */

	@Override
	public List<UserInfoMain> getUserInfoMainByDeptIdByPage(Integer deptId, int currentPage, int pageSize) {
		return this.userMainDao.queryUserByDeptIdByPage(deptId, currentPage, pageSize,
				DataRecordType.ENABLE.getId().toString(), DataRecordType.ENABLE.getId());
	}

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
	@Override
	public List<UserInfoMain> getUserInfoMainByRoleIdByPage(Integer roleId, int currentPage, int pageSize) {
		return this.userMainDao.queryUserByRoleIdByPage(roleId, currentPage, pageSize,
				DataRecordType.ENABLE.getId().toString(), DataRecordType.ENABLE.getId());
	}

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
	@Override
	public List<UserInfoMain> getUserInfoMainByPosIdByPage(Integer positionId, int currentPage, int pageSize) {
		return this.userMainDao.queryUserByPosIdByPage(positionId, currentPage, pageSize,
				DataRecordType.ENABLE.getId().toString(), DataRecordType.ENABLE.getId());
	}

	/**
	 * 查询对应的用户信息的方法(通过用户id/用户名称)
	 * 
	 * @param user
	 * @return
	 */
	/*111111111111111111111111111111111111111111111111*/
	/*@Override
	public UserInfoVo getUserInfoMainByTerm(UserInfoMain user) {
		return this.userMainDao.queryUserInfoMainByTerm(user);
	}*/

	
	
	/**
	 * 用户登录 验证核实用户
	 * 
	 * @param name
	 * @param password
	 * @return
	 * @throws UserInfoServiceException 
	 */
	@Override
	public UserInfoMain login(HttpServletRequest request,String name, String password) throws UserInfoServiceException{
		if(name!=null&&name.trim().length()!=0){
								
		UserInfoMain logonUser = userMainDao.queryLoginUserInfoByName(name, DataRecordType.ENABLE.getId().toString(), DataRecordType.ENABLE.getId()) ;
		try {
		if(logonUser!=null){
				if(logonUser.getUserPassword().equals(password)){
					logger.info("登录成功");
					return logonUser;
				}else{
					logger.error(UserInfoServiceException.WRONG_PWD);
					throw new UserInfoServiceException(UserInfoServiceException.WRONG_PWD);
				}
		}else{
					logger.error(UserInfoServiceException.USERINFO_NOT_EXIST);
					throw new UserInfoServiceException(UserInfoServiceException.USERINFO_NOT_EXIST);
				}
	    	} catch (Exception e) {
	    		
				e.printStackTrace();			
		        return null;
	    	} }else{
	    	throw new UserInfoServiceException(UserInfoServiceException.USERINFO_NOT_EXIST);
	    }
	  }
	
	/****************************************/
	
	/**
	 * 
	 * @Description:根据部门id查询对应用户
	 * @param deptId
	 * @param UserInfoMain
	 * 
	 * @return List<UserInfoMain>
	 *
	 */

	@Override
	public List<UserInfoMain> getUserInfoMainByDeptId(Integer deptId) {
		return this.userMainDao.queryUserByDeptId(deptId,
				DataRecordType.ENABLE.getId().toString(), DataRecordType.ENABLE.getId());
	}

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
	@Override
	public List<UserInfoMain> getUserInfoMainByRoleId(Integer roleId) {
		return this.userMainDao.queryUserByRoleId(roleId,
				DataRecordType.ENABLE.getId().toString(), DataRecordType.ENABLE.getId());
	}

	/**
	 * 
	 * @Description:根据职位id查询对应用户
	 * @param positionId
	 * @param UserInfoMain
	 * 
	 * @return List<UserInfoMain>
	 *
	 */
	@Override
	public List<UserInfoMain> getUserInfoMainByPosId(Integer positionId) {
		return this.userMainDao.queryUserByPosId(positionId, 
				DataRecordType.ENABLE.getId().toString(), DataRecordType.ENABLE.getId());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.clps.bj.mms.sm.service.IUserInfoMainService#getAllUserInfoMainVo()
	 */
	// 将一些属性封装到VO层
	@Override
	public List<UserInfoVo> getAllUserInfoMainVo() {
		List<UserInfoMain> UserInfolist = getAllUserInfoMain();// 得到所有用户
		List<UserInfoVo> userInfoVolist = new ArrayList<UserInfoVo>();// 创建vo
		Integer userId;
/*********************************************/
		Integer roleId = null;
		Integer deptId = null;
		Integer positionId = null;

		String roleName = null;
		String deptAB = null;
		String deptName = null;
		String positionName = null;
/********************************************/

		// 把用户的所有信息 转成vo
		for (UserInfoMain users : UserInfolist) {			
		
				UserInfoVo userinfovo = new UserInfoVo();				
				userId = users.getUserId();
				
				if(users.getDeptId()!=null){
					deptId = users.getDeptId().getDeptId();

					if (deptId != null) {
						deptName = deptService.getDeptById(deptId).getDeptName();// 部门名称
						deptAB = deptService.getDeptById(deptId).getDeptAb();// 部门简称
					} else {
						deptId = null;
						deptAB = null;
						deptName = null;
					}
				}else{
					  deptId = null;
					  deptAB = null;
					  deptName = null;
				}
				
				if(users.getPositionId()!=null){
					positionId = users.getPositionId().getPositionId();

					if (positionId != null) {
						try {
							positionName = positionService.queryPositionById(positionId).getPositionName();
						} catch (Exception e) {

							e.printStackTrace();
						}
					} else {
						positionId = null;
						positionName = null;
					}

				}else{
						positionId = null;
					    positionName = null;
				}
				
				if(users.getRoleId()!=null){
					System.out.println("-----------"+users.getRoleId());
					roleId = users.getRoleId().getRoleId();										
					if (roleId != null) {
						roleName = roleService.queryRoleName(roleId).getRoleName();
					} else {
						roleId=null;
						roleName = null;
					}
				}else {
					roleId=null;
					roleName = null;
				}
				
				if(userinfodetailService.getUserInfoDetail(userId)!=null){
					UserInfoDetail userinfoDetail = userinfodetailService.getUserInfoDetail(userId);
					
					userinfovo.setUserGender(userinfoDetail.getUserGender());
					userinfovo.setUserMobile(userinfoDetail.getUserMobile());
				
					userinfovo.setUserWeiXin(userinfoDetail.getUserWeixin());
				
					userinfovo.setUserUpdatedName(userinfoDetail.getUserUpdatedName());
					userinfovo.setUserUpdatedDateTime(userinfoDetail.getUserUpdatedDateTime());
					userinfovo.setUserIcon(userinfoDetail.getUserIcon());
					userinfovo.setUserPhone(userinfoDetail.getUserPhone());
					userinfovo.setUserDescription(userinfoDetail.getUserDescritpion());
					userinfovo.setUserBirth(userinfoDetail.getUserBirth());	

				}else{
					userinfovo.setUserGender(null);
					userinfovo.setUserMobile(null);				
					userinfovo.setUserWeiXin(null);				
					userinfovo.setUserUpdatedName(null);
					userinfovo.setUserUpdatedDateTime(null);
					userinfovo.setUserIcon(null);
					userinfovo.setUserPhone(null);
					userinfovo.setUserDescription(null);
					userinfovo.setUserBirth(null);
					
				}
				
				userinfovo.setUserId(userId);
				userinfovo.setUserLogon(users.getUserLogon());
				userinfovo.setUserName(users.getUserName());
				userinfovo.setUserEmail(users.getUserEmail());
				userinfovo.setUserStatus(users.getUserStatus());
				userinfovo.setUserCreatedName(users.getUserCreatedName());
				userinfovo.setUserCreatedDatetime(users.getUserCreatedDatetime());
				userinfovo.setUserPassWord(users.getUserPassword());
				
				
				
				userinfovo.setDeptId(deptId);
				userinfovo.setDeptName(deptName);
				userinfovo.setDeptAB(deptAB);
				userinfovo.setPostionId(positionId);
				userinfovo.setPostionName(positionName);
				userinfovo.setRoleId(roleId);
				userinfovo.setRoleName(roleName);
				

				userInfoVolist.add(userinfovo);
                				
		}
		return userInfoVolist;
		
	  }
	
	@Override
	public Boolean updateuserrole(Integer roleId, Integer userId) {
		
		return userMainDao.updateuserrole(roleId, userId,DataRecordType.ENABLE.getId().toString(),
				DataRecordType.ENABLE.getId());
		}

	@Override
	public List<UserInfoVo> getAllLeadingPerVo(String positonName) {
		Position p =positionService.queryPositionByName(positonName);
		List<UserInfoMain> infos = userMainDao.getAllLeadingPer(p.getPositionId());
		List<UserInfoVo> vos = new ArrayList<>();
		UserInfoVo vo = null; 
		for(UserInfoMain info:infos){
			vo = new UserInfoVo();
			vo.setUserId(info.getUserId());
			vo.setUserName(info.getUserName());
			vos.add(vo);
		}
		return vos;
	}

	@Override
	public Integer addUserInfoMainReturnId(UserInfoMain user) {
		return userMainDao.addUserInfoMainReturnId(user);
	}
}

