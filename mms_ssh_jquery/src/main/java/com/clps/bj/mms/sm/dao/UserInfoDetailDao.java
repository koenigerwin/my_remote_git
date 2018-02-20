package com.clps.bj.mms.sm.dao;

import java.util.List;

import com.clps.bj.mms.sm.entity.UserInfoDetail;

/**
 * 
 * @Description: 用户详细表的实体层接口
 * 
 * @className：UserInfoDetailDao
 * @author jiangying
 * @version V1.0.0 2018年1月25日下午2:03:19
 */
public interface UserInfoDetailDao {

	/**
	 * 
	 * @Description:添加用户详细信息
	 * @param UserInfoDetail
	 *            用户
	 * @return boolean true 添加成功 false 添加失败
	 *
	 */
	public boolean addUserInfoDetail(UserInfoDetail user);
	
	/**
	 * @Description:通过该方法可以根据用户编号获取对应用户详细信息
	 * @param userId
	 *            int 用户编号
	 * @return UserInfoDetail 用户
	 */
	public UserInfoDetail queryUserInfoDetail(int userId);

	/**
	 * 
	 * @Description:根据ID更新用户详细信息
	 * @param user
	 * @return boolean
	 *
	 */
	public boolean updateUserInfoDetailById(UserInfoDetail user);

	/**
	 * 
	 * @Description:查询所有用户详细信息
	 * @return List<UserInfoDetail>
	 *
	 */
	public List<UserInfoDetail> queryAllUserInfoDetail();
}
