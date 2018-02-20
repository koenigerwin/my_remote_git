package com.clps.bj.mms.log.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.clps.bj.mms.common.util.pagination.model.PageBean;
import com.clps.bj.mms.log.entity.RoomLog;
import com.clps.bj.mms.log.vo.InfoLogDto;
/**
 * 
 * @description：会议室Dao层实现类
 * @className：RoomLogDaoImpl
 * @author LiuLong.Mr
 * @version V1.0.0
 * 2018年1月26日上午12:59:21
 */
@Repository
public class RoomLogDaoImpl extends AbstractLogDao {
	private StringBuffer sql ;
	private StringBuffer sqlAndPart;
	private StringBuffer sqlOfCounts;

	/**
    * 日志表记录 查询
    * @param model  日志传输对象
    * @param currentPage	当前页
    * @param pageSize		页长
    * @return PageBean<RoomLog> 分页对象
    */
	@SuppressWarnings("unchecked")
	public PageBean<RoomLog> query(InfoLogDto model,int currentPage, int pageSize){
		sqlAndPart = new StringBuffer();
    	List<Object> argsList = new ArrayList<>();
    	if(model.getUserLogOperator()!=null){
    		sqlAndPart.append(ILogSqlConstant.SQLBYUSERNAMEFORROOM);
    		argsList.add(model.getUserLogOperator());
    	}
    	if(model.getUserLogOperation()!=null){
    		sqlAndPart.append(ILogSqlConstant.SQLBYTYPEFORROOM);
    		argsList.add(model.getUserLogOperation());
    	}
    	if(model.getUserLogContent()!=null){
    		sqlAndPart.append(ILogSqlConstant.SQLBYCONTENTFORROOM);
    		argsList.add(model.getUserLogContent());
    	}
		if(model.getStart()!=null){
			if(model.getEnd()!=null){
				sqlAndPart.append(ILogSqlConstant.SQLBYTIMEFORROOM);
				argsList.add(model.getStart());
				argsList.add(model.getEnd());
			}else{
				//throw 数据异常
			}
			
		}
		sql = new StringBuffer(ILogSqlConstant.SQLBYALLFORROOM);
		sql.append(sqlAndPart);
		sqlOfCounts = new StringBuffer(ILogSqlConstant.SQLBYCOUNTSFORROOM);
		sqlOfCounts.append(sqlAndPart);
		return (PageBean<RoomLog>)query(argsList.toArray(),sql.toString(),sqlOfCounts.toString(),new String[]{"ROOM_LOG_OPERATOR_DATETIME DESC"},currentPage,pageSize,RoomLog.class);
	}
}
