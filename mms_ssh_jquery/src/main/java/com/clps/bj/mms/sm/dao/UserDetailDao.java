package com.clps.bj.mms.sm.dao;

import java.util.List;
import com.clps.bj.mms.sm.entity.UserDetail;
/**
 * 
 * @description：实体层用户详情接口
 * @className：UserDetailDao
 * @author erwin.wang
 * @version V1.0.0
 * 2018年1月19日 下午3:03:44
 */
public interface UserDetailDao {
	
	/**
	 * 
	 * @Description:根据用户ID 获取用户详情对象信息
	 * @param userId
	 * @return Integer
	 *
	 */
    public UserDetail queryUserDetail(Integer id);
    /**
     * 
     * @Description:新增用户详情
     * @param userDetail
     * @return boolean
     *
     */
    public boolean addUserDetail(UserDetail userDetail);
    /**
     * 
     * @Description:根据ID删除用户详情
     * @param id
     * @return boolean
     *
     */
    public boolean deleteUserDetail(Integer id);
    /**
     * 
     * @Description:根据用户详情更新其信息
     * @param userDetail
     * @return boolean
     *
     */
    public boolean updateUserDetail(UserDetail userDetail);
    /**
     * 
     * @Description:查询所有的用户详情
     * @return List<UserDetail>
     *
     */
    public List<UserDetail> queryAllUserDetails();
}
