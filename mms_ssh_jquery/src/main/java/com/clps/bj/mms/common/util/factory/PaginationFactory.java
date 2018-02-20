package com.clps.bj.mms.common.util.factory;

import com.clps.bj.mms.common.util.pagination.dao.PaginationDao;
import com.clps.bj.mms.common.util.pagination.dao.impl.PaginationDaoImpl;



/**
 *   DaoImpl的工厂类
 * @author LiuLong.Mr
 *
 * 2017年12月27日上午9:08:49
 */
public class PaginationFactory<T> {
	
	/**
	 * 获取分页DaoImpl的实例
	 * @return PaginationDao<T>
	 */
	public static <T>  PaginationDao<T> getInstanceOfPagination(){
		return new PaginationDaoImpl<T>();
	}
}
