package com.clps.bj.mms.sm.service;

import java.util.List;

import com.clps.bj.mms.sm.entity.UserInfoDetail;

/**
 * @Description: 用户详细信息服务接口层,对外发布的服务
 * 
 * @className：IUserInfoDetailService
 * @author jiangying
 * @version V1.0.0 2018年1月25日下午5:15:24
 */
public interface IUserInfoDetailService {

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
	public UserInfoDetail getUserInfoDetail(int userId);

	/**
	 * 
	 * @Description:根据ID更新用户详细信息
	 * @param UserInfoDetail
	 * @return boolean
	 *
	 */
	public boolean updateUserInfoDetail(UserInfoDetail user);

	/**
	 * @Description:查询所有用户详细信息
	 * 
	 * @return List
	 */
	public List<UserInfoDetail> getAllUserInfoDetail();
}
