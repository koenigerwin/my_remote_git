package com.clps.bj.mms.common.util.pagination.dao;

import org.hibernate.Session;

import com.clps.bj.mms.common.util.db.JDBCIMapper;
import com.clps.bj.mms.common.util.pagination.model.PageBean;




/**
 * 
 * 分页查询Dao层接口
 * @author LiuLong.Mr
 *
 * 2017年12月26日下午11:32:06
 */
public interface PaginationDao<T> {

	
	/**
	 * hibernate Hql分页查询方法
	 * @param session	hibernate的session对象
	 * @param sql	不含分页的查询语句
	 * @param orderField	 排序依据属性字段数组,如 {FIELD1 DESC}
	 * @param args		sql参数列表
	 * @param pageBean查询前不含数据集的分页对象
	 * @return void
	 */
	public void getQueryByHibernateHQl(Session session,String sql,String[] orderField,Object[] args,PageBean<T> pageBean);
	
	/**
	 * hibernate sql分页查询方法
	 * @param session	hibernate的session对象
	 * @param sql	不含分页的查询语句
	 * @param orderField	 排序依据属性字段数组,如 {FIELD1 DESC}
	 * @param args	sql参数列表
	 * @param pageBean	pageBean查询前不含数据集的分页对象
	 * @param voMapper	查询返回值封装类
	 * @return void
	 */
	public void getQueryByHibernateSQL(Session session,String sql,String[] orderField,Object[] args,PageBean<T> pageBean,Class<?> voMapper);

}