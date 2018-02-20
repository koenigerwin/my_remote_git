package com.clps.bj.mms.log.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.clps.bj.mms.common.util.pagination.model.PageBean;
import com.clps.bj.mms.log.entity.MenuLog;
import com.clps.bj.mms.log.vo.InfoLogDto;
/**
 * 
 * @description：菜单日志dao层实现类
 * @className：MenuLogDaoImpl
 * @author LiuLong.Mr
 * @version V1.0.0
 * 2018年1月26日上午12:01:05
 */
@Repository 
public class MenuLogDaoImpl extends AbstractLogDao{
	private StringBuffer sql ;
	private StringBuffer sqlAndPart;
	private StringBuffer sqlOfCounts;

	/**
    * 日志表记录 查询
    * @param model  日志传输对象
    * @param currentPage	当前页
    * @param pageSize		页长
    * @return PageBean<MenuLog> 分页对象
    */
	@SuppressWarnings("unchecked")
	public PageBean<MenuLog> query(InfoLogDto model,int currentPage, int pageSize){
		sqlAndPart = new StringBuffer();
    	List<Object> argsList = new ArrayList<>();
    	if(model.getUserLogOperator()!=null){
    		sqlAndPart.append(ILogSqlConstant.SQLBYUSERNAMEFORMENU);
    		argsList.add(model.getUserLogOperator());
    	}
    	if(model.getUserLogOperation()!=null){
    		sqlAndPart.append(ILogSqlConstant.SQLBYTYPEFORMENU);
    		argsList.add(model.getUserLogOperation());
    	}
    	if(model.getUserLogContent()!=null){
    		sqlAndPart.append(ILogSqlConstant.SQLBYCONTENTFORMENU);
    		argsList.add(model.getUserLogContent());
    	}
		if(model.getStart()!=null){
			if(model.getEnd()!=null){
				sqlAndPart.append(ILogSqlConstant.SQLBYTIMEFORMENU);
				argsList.add(model.getStart());
				argsList.add(model.getEnd());
			}else{
				//throw 数据异常
			}
			
		}
		sql = new StringBuffer(ILogSqlConstant.SQLBYALLFORMENU);
		sql.append(sqlAndPart);
		sqlOfCounts = new StringBuffer(ILogSqlConstant.SQLBYCOUNTSFORMENU);
		sqlOfCounts.append(sqlAndPart);
		return (PageBean<MenuLog>)query(argsList.toArray(),sql.toString(),sqlOfCounts.toString(),new String[]{"MENU_LOG_OPERATOR_DATETIME DESC"},currentPage,pageSize,MenuLog.class);
	}
}
