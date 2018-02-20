package com.clps.bj.mms.common.util.pagination.dao.impl;

import java.util.List;
import java.util.logging.Logger;



import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.transform.Transformers;

import com.clps.bj.mms.common.util.pagination.dao.PaginationDao;
import com.clps.bj.mms.common.util.pagination.model.PageBean;
import com.clps.bj.mms.log.entity.UserInfoLog;
/**
 * 
 * 分页查询Dao层实现类
 * 
 * @author LiuLong.Mr
 *
 * 2017年12月26日下午11:33:14
 */
public class PaginationDaoImpl<T> implements PaginationDao<T>{

	
	@SuppressWarnings("unchecked")
	@Override
	public void getQueryByHibernateHQl(Session session,String sql,String[] orderField,Object[] args, PageBean<T> pageBean) {
		
		StringBuffer sqlQuery = new StringBuffer(sql);
		if (orderField != null) {
			sqlQuery.append(" ORDER BY ");
			int length = orderField.length;
			int i = 0;
			for (; i < length; i++) {
				sqlQuery.append(orderField[i] + ",");
			}
			sqlQuery.deleteCharAt(sqlQuery.length() - 1);
		}
		Query query = session.createQuery(sqlQuery.toString()).setFirstResult(pageBean.getStartIndex()).setMaxResults(pageBean.getPageSize());
		if (args != null) {
			int length = args.length;
			for (int i = 0; i < length; i++) {
				query.setParameter(i, args[i]);
			}
		}
		pageBean.setDataList(query.list());
	}

	@SuppressWarnings("unchecked")
	@Override
	public void getQueryByHibernateSQL(Session session, String sql, String[] orderField, Object[] args,PageBean<T> pageBean,Class<?> t) {
		StringBuffer sqlQuery = new StringBuffer(sql);
		if (orderField != null) {
			sqlQuery.append(" ORDER BY ");
			int length = orderField.length;
			int i = 0;
			for (; i < length; i++) {
				sqlQuery.append(orderField[i] + ",");
			}
			sqlQuery.deleteCharAt(sqlQuery.length() - 1);
		}
		sqlQuery.append(" LIMIT " + pageBean.getStartIndex() + "," + pageBean.getPageSize());
		SQLQuery query = session.createSQLQuery(sqlQuery.toString());
		if (args != null) {
			int length = args.length;
			for (int i = 0; i < length; i++) {
				query.setParameter(i, args[i]);
			}
		}
		//query.setFirstResult(pageBean.getStartIndex()).setMaxResults(pageBean.getPageSize());
		//query.addEntity(UserInfoLog.class);UserInfoLog.class
		query.setResultTransformer(Transformers.aliasToBean(t));
//		query.addScalar("userLogId").addScalar("userLogContent").addScalar("userLogOperator")
//		.addScalar("userLogOperatorDatetime", org.hibernate).addScalar("userLogOperation");
//		List<UserInfoLog> a = query.list();
//		System.out.println(a.size());
//		System.out.println(a.get(1).getClass().getSimpleName());//Object[]
		pageBean.setDataList(query.list());
	}

}