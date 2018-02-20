package com.clps.bj.mms.sm.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.clps.bj.mms.sm.dao.UserInfoDetailDao;
import com.clps.bj.mms.sm.entity.UserInfoDetail;
import com.clps.bj.mms.sm.service.IUserInfoDetailService;

/**
 * 
 * @Description: 服务层用户详细层实现
 * 
 * @className：UserInfoDetailService
 * @author jiangying
 * @version V1.0.0 2018年1月25日下午5:58:21
 */
@Scope
@Service
@Transactional
public class UserInfoDetailServiceImpl implements IUserInfoDetailService {

	@Autowired
	private UserInfoDetailDao userInfoDetailDao;

	/**
	 * 
	 * @Description:添加用户详细信息
	 * @param UserInfoDetail
	 *            用户
	 * @return boolean true 添加成功 false 添加失败
	 *
	 */
	@Override
	public boolean addUserInfoDetail(UserInfoDetail user) {

		return userInfoDetailDao.addUserInfoDetail(user);
	}

	/**
	 * @Description:通过该方法可以根据用户编号获取对应用户详细信息
	 * @param userId
	 *            int 用户编号
	 * @return UserInfoDetail 用户
	 */
	@Override
	public UserInfoDetail getUserInfoDetail(int userId) {

		return userInfoDetailDao.queryUserInfoDetail(userId);
	}

	/**
	 * 
	 * @Description:根据ID更新用户详细信息
	 * @param UserInfoDetail
	 * @return boolean
	 *
	 */

	@Override
	public boolean updateUserInfoDetail(UserInfoDetail user) {

		return userInfoDetailDao.updateUserInfoDetailById(user);
	}

	/**
	 * @Description:查询所有用户详细信息
	 * 
	 * @return List
	 */
	public List<UserInfoDetail> getAllUserInfoDetail() {

		return this.userInfoDetailDao.queryAllUserInfoDetail();
	}

}
