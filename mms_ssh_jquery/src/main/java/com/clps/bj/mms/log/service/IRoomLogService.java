package com.clps.bj.mms.log.service;

import com.clps.bj.mms.common.util.pagination.model.PageBean;
import com.clps.bj.mms.log.entity.RoomLog;
import com.clps.bj.mms.log.vo.InfoLogDto;
/**
 * 
 * @description：会议室日志服务层接口
 * @className：IRoomLogService
 * @author LiuLong.Mr
 * @version V1.0.0
 * 2018年1月26日上午12:49:22
 */
public interface IRoomLogService {
	/**
	 * 
	 * @param model		输入信息数据传输模型
	 * @param currentPage		当前页
	 * @param pageSize		页长
	 * @return		PageBean<RoomLog>	日志分页对象
	 */
	PageBean<RoomLog> getLogList(InfoLogDto model,int currentPage,int pageSize);
}
