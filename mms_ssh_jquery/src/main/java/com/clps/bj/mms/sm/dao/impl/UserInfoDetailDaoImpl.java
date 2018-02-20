package com.clps.bj.mms.sm.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.clps.bj.mms.sm.dao.UserInfoDetailDao;
import com.clps.bj.mms.sm.dao.UserInfoDetailHql;
import com.clps.bj.mms.sm.entity.UserInfoDetail;

@Repository
public class UserInfoDetailDaoImpl implements UserInfoDetailDao, UserInfoDetailHql {

	@Resource
	private SessionFactory sessionFactory;

	/**
	 * 
	 * @Description:添加用户
	 * @param user
	 *            用户
	 * @return boolean true 添加成功 false 添加失败
	 *
	 */

	@Override
	public boolean addUserInfoDetail(UserInfoDetail user) {
		Integer id = (Integer) sessionFactory.getCurrentSession().save(user);

		return id > 0;
	}

	/**
	 * @Description:根据用户编号获取对应用户信息
	 * @param userId
	 *            int 用户编号
	 * @return UserInfoDetail 用户
	 */

	@Override
	public UserInfoDetail queryUserInfoDetail(int userId) {
		Query query = sessionFactory.getCurrentSession().createQuery(Hql_queryUserInfoDetailById);
		query.setParameter(0, userId);
		return (UserInfoDetail) query.uniqueResult();
	}

	/**
	 * 
	 * @Description:根据ID更新用户信息
	 * @param UserInfoDetail
	 * @return boolean
	 *
	 */

	@Override
	public boolean updateUserInfoDetailById(UserInfoDetail user) {
		Query query = sessionFactory.getCurrentSession().createQuery(Hql_updateUserInfoDetailById);
		query.setParameter(0, user.getUserBirth());
		query.setParameter(1, user.getUserDescritpion());
		query.setParameter(2, user.getUserGender());
		query.setParameter(3, user.getUserIcon());
		query.setParameter(4, user.getUserLevel());
		query.setParameter(5, user.getUserMobile());
		query.setParameter(6, user.getUserPhone());
		query.setParameter(7, user.getUserUpdatedName());
		query.setParameter(8, user.getUserUpdatedDateTime());
		query.setParameter(9, user.getUserWeixin());
		query.setParameter(10, user.getUserId());

		return query.executeUpdate() > 0;
	}

	/**
	 * 
	 * @Description:查询所有用户信息并分页
	 *
	 * @return 查询结果List<UserInfoDetail>
	 * 
	 */

	@SuppressWarnings("unchecked")
	@Override
	public List<UserInfoDetail> queryAllUserInfoDetail() {
		Query query = sessionFactory.getCurrentSession().createQuery(Hql_queryallUserInfoDetail);
		
		return query.list();
	}


}
