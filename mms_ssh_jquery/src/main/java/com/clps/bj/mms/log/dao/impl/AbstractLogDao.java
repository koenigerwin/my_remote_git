package com.clps.bj.mms.log.dao.impl;

import java.math.BigInteger;

import javax.annotation.Resource;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.clps.bj.mms.common.util.factory.UtilFactory;
import com.clps.bj.mms.common.util.pagination.dao.PaginationDao;
import com.clps.bj.mms.common.util.pagination.model.PageBean;
import com.clps.bj.mms.log.entity.InfoLog;


/**
 * 
 * @description：Dao层抽象类，公共代码
 * @className：AbstractLogDao
 * @author LiuLong.Mr
 * @version V1.0.0 2018年1月26日上午9:19:20
 */
public class AbstractLogDao {

	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	@Resource
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	private Boolean flag = false;

	/**
	 * 用户日志记录添加
	 * 
	 * @param userInfoLog
	 *            用户日志记录模型对象
	 * @return boolean 添加是否成功
	 */
	public final boolean addLog(InfoLog InfoLog) {
		try {
			Session session = sessionFactory.getCurrentSession();
			session.save(InfoLog);
			return !flag;
		} catch (HibernateException e) {
			e.printStackTrace();
			return flag;
		}
	}

	/**
	 * 日志表记录 查询
	 * 
	 * @param args
	 *            查询条件对应实参
	 * @param sql
	 *            查询SQL
	 * @param sqlOfCounts
	 *            查询总记录数的sql
	 * @param currentPage
	 *            当前页
	 * @param pageSize
	 *            页长
	 * @param voMapper
	 *            前台返回值封装类
	 * @return PageBean<InfoLog> 分页对象
	 */

	@SuppressWarnings({ "unchecked", "rawtypes" })
	// protected final List<InfoLog> query(Object[] args,String sql,String
	// sqlCounts){
	// Session session = sessionFactory.getCurrentSession();
	// Query query = session.createSQLQuery(sql);
	// int length = args.length;
	// for(int i=0;i<length ;i++){
	// query.setParameter(i, args[i]);
	// }
	// return query.list();
	//
	// }
	protected final PageBean query(Object[] args, String sql, String sqlCounts, String[] orderField, int currentPage,
			int pageSize, Class<?> voMapper) {
		Session session = sessionFactory.getCurrentSession();
		PageBean pageBean = new PageBean<>(currentPage, pageSize, queryAllCounts(session, sqlCounts, args));
		PaginationDao pageDao = UtilFactory.getInstanceOfPageInationDao();
		pageDao.getQueryByHibernateSQL(session, sql, orderField, args, pageBean, voMapper);
		System.out.println("****-------*******"+pageBean.toString());
		return pageBean;

	}
	/**
	 * 
	 * @param session	hibernate session
	 * @param sqlCounts	sql查询总记录数
	 * @param args	实参	
	 * @return	int	总记录数
	 */
	private int queryAllCounts(Session session, String sqlCounts, Object[] args) {
		Query query = session.createSQLQuery(sqlCounts);
		int length = args.length;
		for (int i = 0; i < length; i++) {
			query.setParameter(i, args[i]);
		}
		BigInteger counts =(BigInteger)query.uniqueResult();
		return counts.intValue();

	}
}
