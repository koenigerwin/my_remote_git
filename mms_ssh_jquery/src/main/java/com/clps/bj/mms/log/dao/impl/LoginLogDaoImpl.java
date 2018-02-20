package com.clps.bj.mms.log.dao.impl;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.clps.bj.mms.common.util.pagination.model.PageBean;
import com.clps.bj.mms.log.entity.LoginLog;
import com.clps.bj.mms.log.vo.LoginDto;


/**
 * 
 * @description：日志登录实现类
 * @className：LoginLogDaoImpl
 * @author LiuLong.Mr
 * @version V1.0.0
 * 2018年1月29日上午10:28:25
 */
@Repository
public class LoginLogDaoImpl extends AbstractLogDao {
	private StringBuffer sql ;
	private StringBuffer sqlAndPart;
	private StringBuffer sqlOfCounts;
	private boolean flag = false;
	
	public boolean updateLog(String sessionId){
		Session session = this.getSessionFactory().getCurrentSession();	
		Query query =  session.createSQLQuery(ILogSqlConstant.SQLBYSESSIONIDFORLOGINUPDATE);
		//query.setDate(position, date) 设置时间数据库会截断
		query.setParameter(0, new Date());
		query.setString(1,sessionId);
		int updateRows = query.executeUpdate();
		if(updateRows>0){
			return !flag;
		}else{
			return flag;
		}
		 
	}
	
	
	
	/**
    * 日志表记录 查询
    * @param model  日志传输对象
    * @param currentPage	当前页
    * @param pageSize		页长
    * @return PageBean<LoginLog> 分页对象
    */
	@SuppressWarnings("unchecked")
	public PageBean<LoginLog> query(LoginDto model,int currentPage, int pageSize){
		sqlAndPart = new StringBuffer();
    	List<Object> argsList = new ArrayList<>();
    	if(model.getLoginLogUserLogon()!=null){
    		sqlAndPart.append(ILogSqlConstant.SQLBYUSERLOGONFORLOGIN);
    		argsList.add(model.getLoginLogUserLogon());
    	}
    	if(model.getLoginLogUserName()!=null){
    		sqlAndPart.append(ILogSqlConstant.SQLBYUSERNAMEFORLOGIN);
    		argsList.add(model.getLoginLogUserName());
    	}
		if(model.getStart()!=null){
			if(model.getEnd()!=null){
				if(model.isLogon()){
					sqlAndPart.append(ILogSqlConstant.SQLBYLOGONTIMEFORLOGIN);
					argsList.add(model.getStart());
					argsList.add(model.getEnd());
				}else{
					sqlAndPart.append(ILogSqlConstant.SQLBYLOGOUTTIMEFORLOGIN);
					argsList.add(model.getStart());
					argsList.add(model.getEnd());
				}
				
			}else{
				//throw 数据异常
			}
			
		}
		sql = new StringBuffer(ILogSqlConstant.SQLBYALLFORLOGIN);
		sql.append(sqlAndPart);
		sqlOfCounts = new StringBuffer(ILogSqlConstant.SQLBYCOUNTSFORLOGIN);
		sqlOfCounts.append(sqlAndPart);
		return (PageBean<LoginLog>)query(argsList.toArray(),sql.toString(),sqlOfCounts.toString(),new String[]{"LOGON_LOG_OPERATOR_DATETIME DESC"},currentPage,pageSize,LoginLog.class);
	}
	/**
	 * 根据用户登录名查日志记录数
	 * @param operator	访问人（登录名）
	 * @return	int
	 */
	public int queryCountsByName(String operator){
		sqlOfCounts = new StringBuffer(ILogSqlConstant.SQLBYCOUNTSFORLOGIN);
		sqlOfCounts.append(ILogSqlConstant.SQLBYUSERNAMEFORLOGIN);
		Session session = this.getSessionFactory().getCurrentSession();
		Query query = session.createSQLQuery(sqlOfCounts.toString());
		query.setParameter(0, operator);
		BigInteger counts =(BigInteger)query.uniqueResult();
		return   counts.intValue();
	}
}
