package com.clps.bj.mms.sm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import com.clps.bj.mms.sm.dao.UserDetailDao;
import com.clps.bj.mms.sm.entity.UserDetail;
import com.clps.bj.mms.sm.service.IUserDetailService;

/**
 * 
 * @description：服务层用户详情实现
 * @className：UserDetailServiceImpl
 * @author erwin.wang
 * @version V1.0.0
 * 2018年1月19日 下午4:32:58
 */
@Scope
@Service
public class UserDetailServiceImpl implements IUserDetailService{

    @Autowired
    private UserDetailDao userDetailDao;

    @Override
    public UserDetail getUserDetail(Integer userId) {
        return userDetailDao.queryUserDetail(userId);
    }

    @Override
    public void addUserDetail(UserDetail userDetail) {
        userDetailDao.addUserDetail(userDetail);
    }

    @Override
    public boolean deleteUserDetail(Integer userId) {
        return userDetailDao.deleteUserDetail(userId);
    }

    @Override
    public boolean updateUserDetail(UserDetail userDetail) {
        return userDetailDao.updateUserDetail(userDetail);
    }

    @Override
    public List<UserDetail> getAllUserDetail() {
        return userDetailDao.queryAllUserDetails();
    }
}
