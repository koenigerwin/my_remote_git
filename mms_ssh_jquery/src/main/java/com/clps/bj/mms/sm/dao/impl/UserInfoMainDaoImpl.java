package com.clps.bj.mms.sm.dao.impl;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.clps.bj.mms.common.util.encrypt.EncryptFactory;
import com.clps.bj.mms.sm.dao.UserInfoMainDao;
import com.clps.bj.mms.sm.dao.UserInfoMainHql;
import com.clps.bj.mms.sm.entity.UserInfoMain;
import com.clps.bj.mms.sm.vo.UserInfoVo;

@Repository
public class UserInfoMainDaoImpl implements UserInfoMainDao, UserInfoMainHql {

	@Resource
	private SessionFactory sessionFactory;
	private StringBuffer sqlAndParts;
	Logger logger = Logger.getLogger(UserInfoMainDaoImpl.class);
	private EncryptFactory encryFactory = new EncryptFactory();

	/**
	 * 
	 * @Description:添加用户
	 * @param user
	 *            用户
	 * @return boolean true 添加成功 false 添加失败
	 *
	 */
	@Override
	public boolean addUserMain(UserInfoMain user) {

		// user.setUserCreatedDatetime(dateFactory.getNowStr(format));//添加用户的时间
		// user.setUserStatus(0);//用户在最初添加时的状态
		String passWord = user.getUserPassword();
		Integer id = 0;

		try {
			String encryPassWord = encryFactory.getEncry().EncoderByMd5(passWord);
			id = (Integer) sessionFactory.getCurrentSession().save(user);
			user.setUserPassword(encryPassWord);// 新增用户时对密码进行加密存chu
			return id > 0;
		} catch (NoSuchAlgorithmException e) {

			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {

			e.printStackTrace();
		}

		return id > 0;

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
	public boolean deleteUserMainById(Integer userId) {
		Query query = sessionFactory.getCurrentSession().createQuery(Hql_deleteUserMainById);
		query.setParameter(0, userId);
		return query.executeUpdate() > 0;

	}

	/**
	 * @Description:根据用户编号获取对应用户信息
	 * @param userId
	 *            int 用户编号
	 * @return UserInfoMain 用户
	 */
	@Override
	public UserInfoMain queryUserInfoMain(Integer userId, String userIsEnable, Integer userStatus) {

		Query query = sessionFactory.getCurrentSession().createQuery(Hql_queryUserMainById);
		query.setParameter(0, userId);
		query.setParameter(1, userIsEnable);
		query.setParameter(2, userStatus);

		return (UserInfoMain) query.uniqueResult();
	}

	/**
	 * @Description:可以根据用户名称获取对应用户信息
	 * @param userName
	 *            String 用户名称
	 * @param userIsEnable是否是有效数据
	 * @param userStatus是否被激活
	 * @return UserInfoMain 用户
	 */
	public UserInfoMain queryUserInfoMainByName(String userName, String userIsEnable, Integer userStatus) {

		Query query = sessionFactory.getCurrentSession().createQuery(Hql_queryUserMainByName);
		query.setParameter(0, userName);
		query.setParameter(1, userIsEnable);
		query.setParameter(2, userStatus);

		return (UserInfoMain) query.uniqueResult();
	}

	/**
	 * 
	 * @Description:根据ID更新用户信息
	 * @param user
	 * @return boolean
	 *
	 */
	@Override
	public boolean updateUserInfoMainById(UserInfoMain user) {
		Query query = sessionFactory.getCurrentSession().createQuery(Hql_updateUserMainById);
		query.setParameter(0, user.getUserCreatedDatetime());
		query.setParameter(1, user.getUserCreatedName());
		query.setParameter(2, user.getUserEmail());
		query.setParameter(3, user.getUserStatus());
		query.setParameter(4, user.getPositionId().getPositionId());
		query.setParameter(5, user.getRoleId().getRoleId());
		query.setParameter(6, user.getDeptId().getDeptId());
		query.setParameter(7, user.getUserId());

		return query.executeUpdate() > 0;
	}

	/**
	 * 
	 * @Description:查询所有用户信息并分页
	 * @param currentPage
	 *            当前页
	 * @param pageSize
	 *            页长
	 * @return 查询结果List<UserInfoMain>
	 * 
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<UserInfoMain> queryAllUserInfoMainByPage(int currentPage, int pageSize, String userIsEnable,
			Integer userStatus) {
		Query query = sessionFactory.getCurrentSession().createQuery(hql_queryAllUser);
		query.setParameter(0, userIsEnable);
		query.setParameter(1, userStatus);

		query.setFirstResult((currentPage - 1) * pageSize);
		query.setMaxResults(pageSize);
		return query.list();
	}

	/**
	 * 
	 * @Description:查询所有用户信息
	 * @param String
	 *            userIsEnable
	 * @param Integer
	 *            userStatus
	 * @return 查询结果List<UserInfoMain>
	 * 
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<UserInfoMain> queryAllUserInfoMain(String userIsEnable, Integer userStatus) {
		Query query = sessionFactory.getCurrentSession().createQuery(hql_queryAllUser);
		query.setParameter(0, userIsEnable);
		query.setParameter(1, userStatus);

		return query.list();
	}

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
	/**************************/
	@SuppressWarnings("unchecked")
	@Override
	public List<UserInfoMain> queryUserByDeptIdByPage(Integer deptId, int currentPage, int pageSize, String userIsEnable,
			Integer userStatus) {
		Query query = sessionFactory.getCurrentSession().createQuery(Hql_queryUserMainByDeptId);
		query.setParameter(0, userIsEnable);
		query.setParameter(1, userStatus);
		query.setParameter(2, deptId);
		query.setFirstResult((currentPage - 1) * pageSize);
		query.setMaxResults(pageSize);
		return query.list();
	}

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
	@SuppressWarnings("unchecked")
	@Override
	public List<UserInfoMain> queryUserByRoleIdByPage(Integer roleId, int currentPage, int pageSize, String userIsEnable,
			Integer userStatus) {
		Query query = sessionFactory.getCurrentSession().createQuery(Hql_queryUserMainByRoleId);
		query.setParameter(0, userIsEnable);
		query.setParameter(1, userStatus);
		query.setParameter(2, roleId);
		query.setFirstResult((currentPage - 1) * pageSize);
		query.setMaxResults(pageSize);
		return query.list();
	}

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
	@SuppressWarnings("unchecked")
	@Override
	public List<UserInfoMain> queryUserByPosIdByPage(Integer positionId, int currentPage, int pageSize, String userIsEnable,
			Integer userStatus) {
		Query query = sessionFactory.getCurrentSession().createQuery(Hql_queryUserMainByPosId);
		query.setParameter(0, userIsEnable);
		query.setParameter(1, userStatus);
		query.setParameter(2, positionId);
		query.setFirstResult((currentPage - 1) * pageSize);
		query.setMaxResults(pageSize);
		return query.list();
	}

	/**
	 * 查询对应的用户信息的方法(通过用户id/用户名称)
	 * 
	 * @param user
	 * @return
	 */
	
	/*1111111111111111111111111111111111111111111111111111111*/
	
	/*@SuppressWarnings("unchecked")
	@Override
	public UserInfoVo queryUserInfoMainByTerm(UserInfoMain user) {
		sqlAndParts = new StringBuffer();
		List<Object> conditionstr = new ArrayList<>();
		sqlAndParts.append(UserInfoMainHql.Hql_getUserInfoMain);
		if (user.getUserId() != null) {
			sqlAndParts.append(UserInfoMainHql.getUser_ByUserId);
			conditionstr.add(user.getUserId());
		}
		if (user.getUserName() != null) {
			sqlAndParts.append(UserInfoMainHql.getUser_ByUserName);
			conditionstr.add(user.getUserName());
		}
		logger.info(sqlAndParts);
		Query query = sessionFactory.getCurrentSession().createQuery(sqlAndParts.toString());
		if (conditionstr.size() > 0) {
			for (int i = 0; i < conditionstr.size(); i++) {
				query.setParameter(i, conditionstr.get(i));
			}
		}

		List<UserInfoVo> UserList = query.list();

		return (UserInfoVo) UserList.get(0);
	}
 */
	/**
	 * 
	 * queryLoginUserInfoByName:查询用户登录信息. 
	 * @param name
	 * @return UserInfo
	 * @throws DataAccessException
	 */
	@SuppressWarnings("unchecked")
	@Override
	
	public UserInfoMain queryLoginUserInfoByName(String name, String userIsEnable, Integer userStatus) {
		Query query = sessionFactory.getCurrentSession().createQuery(Hql_userLogon);
		query.setParameter(0, name);
		query.setParameter(1, userIsEnable);
		query.setParameter(2, userStatus);
		return (UserInfoMain)query.uniqueResult();
		
	}
	
	/************************************/
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
	/**************************/
	@SuppressWarnings("unchecked")
	@Override
	public List<UserInfoMain> queryUserByDeptId(Integer deptId, String userIsEnable,
			Integer userStatus) {
		Query query = sessionFactory.getCurrentSession().createQuery(Hql_queryUserMainByDeptId);
		query.setParameter(0, userIsEnable);
		query.setParameter(1, userStatus);
		query.setParameter(2, deptId);
		
		return query.list();
	}

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
	@SuppressWarnings("unchecked")
	@Override
	public List<UserInfoMain> queryUserByRoleId(Integer roleId,String userIsEnable,
			Integer userStatus) {
		
		if(roleId!=null){
			Query query = sessionFactory.getCurrentSession().createQuery(Hql_queryUserMainByRoleId);
			query.setParameter(0, userIsEnable);
			query.setParameter(1, userStatus);
			query.setParameter(2, roleId);
			return query.list();
		}else{
			Query query = sessionFactory.getCurrentSession().createQuery(Hql_queryUserMainByNullRoleId);
			query.setParameter(0, userIsEnable);
			query.setParameter(1, userStatus);
			return query.list();
		}
		
	}

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
	@SuppressWarnings("unchecked")
	@Override
	public List<UserInfoMain> queryUserByPosId(Integer positionId,String userIsEnable,
			Integer userStatus) {
		Query query = sessionFactory.getCurrentSession().createQuery(Hql_queryUserMainByPosId);
		query.setParameter(0, userIsEnable);
		query.setParameter(1, userStatus);
		query.setParameter(2, positionId);
	
		return query.list();
	}

	/* (non-Javadoc)
	 * @see com.clps.bj.mms.sm.dao.UserInfoMainDao#queryAllUserInfoMainByMap(java.lang.String, java.lang.Integer)
	 */
	@Override
	public Map<Integer,UserInfoMain> queryAllUserInfoMainByMap(String userIsEnable, Integer userStatus) {
		                                                   
		List<UserInfoMain> list = this.queryAllUserInfoMain(userIsEnable, userStatus);
		Map<Integer,UserInfoMain> map=  new HashMap<Integer,UserInfoMain>();		
		for(UserInfoMain user : list ){
			 map.put(user.getUserId(), user);
			/* int i = 0;
			for(i = 0;i<map.size();i++){
				System.out.println("**********************"+map.get(1));
			}*/
		 }
		 	   
//		System.out.println("^&^&^&^&^&"+list.size());
		return map;
	}


	@Override
	public Boolean updateuserrole(Integer roleId, Integer userId, String userIsEnable, Integer userStatus) {
		Query query = sessionFactory.getCurrentSession().createQuery(updateuserroleHQL);
		query.setParameter(0, roleId);
		query.setParameter(1, userId);
		query.setParameter(2, userIsEnable);
		query.setParameter(3, userStatus);
		return query.executeUpdate()>0;
	}

	@Override
	public List<UserInfoMain> getAllLeadingPer(Integer positionId) {
		/*Query query = sessionFactory.getCurrentSession().createQuery(getAllLeadingPerHQL);
		query.setParameter(0, positionId);*/
		
		SQLQuery sqlQuery = sessionFactory.getCurrentSession().createSQLQuery(getAllLeadingPerSQL);
		sqlQuery.setParameter(0, positionId);
		List<UserInfoMain> infos = sqlQuery.addEntity(UserInfoMain.class).list();
		return infos;
	}

	@Override
	public Integer addUserInfoMainReturnId(UserInfoMain user) {
		String passWord = user.getUserPassword();
		Integer id = 0;
		try {
			String encryPassWord = encryFactory.getEncry().EncoderByMd5(passWord);
			id = (Integer) sessionFactory.getCurrentSession().save(user);
			user.setUserPassword(encryPassWord);// 新增用户时对密码进行加密存chu
			return user.getUserId();
		} catch (NoSuchAlgorithmException e) {

			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {

			e.printStackTrace();
		}
		return null;
	}

}
