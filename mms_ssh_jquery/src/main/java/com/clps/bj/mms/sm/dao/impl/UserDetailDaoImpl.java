package com.clps.bj.mms.sm.dao.impl;

import java.util.List;
import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import com.clps.bj.mms.sm.dao.UserDetailDao;
import com.clps.bj.mms.sm.entity.UserDetail;
/**
 * 
 * @description：实体层用户详情实现
 * @className：UserDetailDaoImpl
 * @author erwin.wang
 * @version V1.0.0
 * 2018年1月19日 下午3:51:05
 */
@Repository
public class UserDetailDaoImpl implements UserDetailDao{


	@Resource
	private SessionFactory sessionFactory;
	private static final String Hql_queryUserDetailById="from UserDetail where id=?";
	private static final String Hql_deleteUserDetailById="delete UserDetail where id=?";
	private static final String Hql_updateUserDetailById="update UserDetail "
			+ "set password=?,phoneNumber=?,sex=?,birthday=?,postNumber=?,address=? "
			+ "where id=?";
	private static final String Hql_queryAllUserDetails ="from UserDetail";


	/* 
	 * @param userId
	 * @return UserDetail
	 * @see com.clps.bj.mms.sm.dao.UserDetailDao#getUserDetail(java.lang.Integer)
	 */
	@Override
	public UserDetail queryUserDetail(Integer userId) {
		Query query = sessionFactory.getCurrentSession().createQuery(Hql_queryUserDetailById);
		query.setParameter(0, userId);
		return (UserDetail)query.uniqueResult();
	}
	/*
	 * 
	 * @param userDetail
	 * @see com.clps.bj.mms.sm.dao.UserDetailDao#addUserDetail(com.clps.bj.mms.sm.entity.UserDetail)
	 */
	@Override
	public boolean addUserDetail(UserDetail userDetail) {
		int id =(Integer)sessionFactory.getCurrentSession().save(userDetail);
		return id>0;
	}

	@Override
	public boolean deleteUserDetail(Integer id) {
		Query query = sessionFactory.getCurrentSession().createQuery(Hql_deleteUserDetailById);
		query.setParameter(0, id);
		return query.executeUpdate() > 0;
	}

	@Override
	public boolean updateUserDetail(UserDetail userDetail) {
		Query query = sessionFactory.getCurrentSession().createQuery(Hql_updateUserDetailById);
		query.setParameter(0,userDetail.getPassword());
		query.setParameter(1,userDetail.getPhoneNumber());
		query.setParameter(2,userDetail.getSex());
		query.setParameter(3,userDetail.getBirthday());
		query.setParameter(4,userDetail.getPostNumber());
		query.setParameter(5,userDetail.getAddress());
		query.setParameter(6,userDetail.getUserId());
		return query.executeUpdate() > 0;
	}

	@Override
	public List<UserDetail> queryAllUserDetails() {
		Query query = sessionFactory.getCurrentSession().createQuery(Hql_queryAllUserDetails);
		return query.list();
	}


}
