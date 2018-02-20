package com.clps.bj.mms.sm.service;



import java.util.List;

import com.clps.bj.mms.sm.entity.UserDetail;
/**
 * 
 * @description：TODO
 * @className：IUserDetailService
 * @author erwin.wang
 * @version V1.0.0
 * 2018年1月19日 下午4:22:52
 */
public interface IUserDetailService {
	
    public UserDetail getUserDetail(Integer userId);

    public void addUserDetail(UserDetail userDetail);

    public boolean deleteUserDetail(Integer userId);

    public boolean updateUserDetail(UserDetail userDetail);

    public List<UserDetail> getAllUserDetail();
}
