package com.clps.bj.mms.log.service;

import com.clps.bj.mms.common.util.pagination.model.PageBean;
import com.clps.bj.mms.log.entity.LoginLog;
import com.clps.bj.mms.log.vo.LoginDto;
/**
 * 
 * @description：登录日志服务层接口
 * @className：ILoginLogService
 * @author LiuLong.Mr
 * @version V1.0.0
 * 2018年1月29日上午9:17:33
 */
public interface ILoginLogService {
	
	/**
	 *  
	 * @param ip	访问IP
	 * @param operator	登录名
	 * @param userName	真实名
	 * @param sessionId sessionId
	 * @return	Boolean
	 */
	Boolean saveLogon(String ip,String sessionId,String userLogon,String userName);
	/**
	 * 
	 * @param sessionId
	 * @return	Boolean
	 */
	Boolean updateLogout(String sessionId);
	/**
	 * 
	 * @param model		查询条件输入模型
	 * @param currentPage	当前页	
	 * @param pageSize		页长
	 * @return	PageBean<LoginLog> 
	 */
	PageBean<LoginLog> getLogList(LoginDto model,int currentPage,int pageSize);
	/**
	 * 
	 * @param userLogon	登录名
	 * @return	int	日志记录数目
	 */
	int getCountsByName(String userLogon);
}
