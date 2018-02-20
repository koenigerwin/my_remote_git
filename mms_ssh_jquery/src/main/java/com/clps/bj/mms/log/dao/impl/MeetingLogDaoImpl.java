package com.clps.bj.mms.log.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.clps.bj.mms.common.util.pagination.model.PageBean;
import com.clps.bj.mms.log.entity.MeetingLog;
import com.clps.bj.mms.log.vo.InfoLogDto;
@Repository
public class MeetingLogDaoImpl extends AbstractLogDao {
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
	public PageBean<MeetingLog> query(InfoLogDto model,int currentPage, int pageSize){
		sqlAndPart = new StringBuffer();
    	List<Object> argsList = new ArrayList<>();
    	if(model.getUserLogOperator()!=null){
    		sqlAndPart.append(ILogSqlConstant.SQLBYUSERNAMEFORMEETING);
    		argsList.add(model.getUserLogOperator());
    	}
    	if(model.getUserLogOperation()!=null){
    		sqlAndPart.append(ILogSqlConstant.SQLBYTYPEFORMEETING);
    		argsList.add(model.getUserLogOperation());
    	}
    	if(model.getUserLogContent()!=null){
    		sqlAndPart.append(ILogSqlConstant.SQLBYCONTENTFORMEETING);
    		argsList.add(model.getUserLogContent());
    	}
		if(model.getStart()!=null){
			if(model.getEnd()!=null){
				sqlAndPart.append(ILogSqlConstant.SQLBYTIMEFORMEETING);
				argsList.add(model.getStart());
				argsList.add(model.getEnd());
			}else{
				//throw 数据异常
			}
			
		}
		sql = new StringBuffer(ILogSqlConstant.SQLBYALLFORMEETING);
		sql.append(sqlAndPart);
		sqlOfCounts = new StringBuffer(ILogSqlConstant.SQLBYCOUNTSFORMEETING);
		sqlOfCounts.append(sqlAndPart);
		return (PageBean<MeetingLog>)query(argsList.toArray(),sql.toString(),sqlOfCounts.toString(),new String[]{"MEETING_LOG_OPERATOR_DATETIME DESC"},currentPage,pageSize,MeetingLog.class);
	}
}
