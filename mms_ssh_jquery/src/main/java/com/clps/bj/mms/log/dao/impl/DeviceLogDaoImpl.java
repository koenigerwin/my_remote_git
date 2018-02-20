package com.clps.bj.mms.log.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.clps.bj.mms.common.util.pagination.model.PageBean;
import com.clps.bj.mms.log.entity.DeviceLog;
import com.clps.bj.mms.log.vo.InfoLogDto;
/**
 * 
 * @description：设备日志Dao层实现类
 * @className：DeviceLogDaoImpl
 * @author LiuLong.Mr
 * @version V1.0.0
 * 2018年1月26日上午1:12:40
 */
@Repository
public class DeviceLogDaoImpl extends AbstractLogDao {
	private StringBuffer sql ;
	private StringBuffer sqlAndPart;
	private StringBuffer sqlOfCounts;

	/**
    * 日志表记录 查询
    * @param model  日志传输对象
    * @param currentPage	当前页
    * @param pageSize		页长
    * @return PageBean<DeviceLog> 分页对象
    */
	@SuppressWarnings("unchecked")
	public PageBean<DeviceLog> query(InfoLogDto model,int currentPage, int pageSize){
		sqlAndPart = new StringBuffer();
    	List<Object> argsList = new ArrayList<>();
    	if(model.getUserLogOperator()!=null){
    		sqlAndPart.append(ILogSqlConstant.SQLBYUSERNAMEFORDEVICE);
    		argsList.add(model.getUserLogOperator());
    	}
    	if(model.getUserLogOperation()!=null){
    		sqlAndPart.append(ILogSqlConstant.SQLBYTYPEFORDEVICE);
    		argsList.add(model.getUserLogOperation());
    	}
    	if(model.getUserLogContent()!=null){
    		sqlAndPart.append(ILogSqlConstant.SQLBYCONTENTFORDEVICE);
    		argsList.add(model.getUserLogContent());
    	}
		if(model.getStart()!=null){
			if(model.getEnd()!=null){
				sqlAndPart.append(ILogSqlConstant.SQLBYTIMEFORDEVICE);
				argsList.add(model.getStart());
				argsList.add(model.getEnd());
			}else{
				//throw 数据异常
			}
			
		}
		sql = new StringBuffer(ILogSqlConstant.SQLBYALLFORDEVICE);
		sql.append(sqlAndPart);
		sqlOfCounts = new StringBuffer(ILogSqlConstant.SQLBYCOUNTSFORDEVICE);
		sqlOfCounts.append(sqlAndPart);
		return (PageBean<DeviceLog>)query(argsList.toArray(),sql.toString(),sqlOfCounts.toString(),new String[]{"DEVICE_LOG_OPERATOR_DATETIME DESC"},currentPage,pageSize,DeviceLog.class);
	}
}
