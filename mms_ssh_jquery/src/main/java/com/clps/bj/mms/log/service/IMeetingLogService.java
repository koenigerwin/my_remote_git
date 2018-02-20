package com.clps.bj.mms.log.service;

import com.clps.bj.mms.common.util.pagination.model.PageBean;
import com.clps.bj.mms.log.entity.MeetingLog;
import com.clps.bj.mms.log.vo.InfoLogDto;
/**
 * 
 * @description：会议日志服务层接口
 * @className：IMeetingLogService
 * @author LiuLong.Mr
 * @version V1.0.0
 * 2018年1月26日上午12:47:28
 */
public interface IMeetingLogService {
	/**
	 * 
	 * @param model		输入信息数据传输模型
	 * @param currentPage		当前页
	 * @param pageSize		页长
	 * @return		PageBean<RoleLog>	日志分页对象
	 */
	PageBean<MeetingLog> getLogList(InfoLogDto model,int currentPage,int pageSize);
}
