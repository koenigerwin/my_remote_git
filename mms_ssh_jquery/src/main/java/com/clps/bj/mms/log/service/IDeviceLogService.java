package com.clps.bj.mms.log.service;

import com.clps.bj.mms.common.util.pagination.model.PageBean;
import com.clps.bj.mms.log.entity.DeviceLog;
import com.clps.bj.mms.log.vo.InfoLogDto;
/**
 * 
 * @description：设备日志服务层接口
 * @className：IDeviceLogService
 * @author LiuLong.Mr
 * @version V1.0.0
 * 2018年1月26日上午1:03:37
 */
public interface IDeviceLogService {
	/**
	 * 
	 * @param model		输入信息数据传输模型
	 * @param currentPage		当前页
	 * @param pageSize		页长
	 * @return		PageBean<DeviceLog>	日志分页对象
	 */
	PageBean<DeviceLog> getLogList(InfoLogDto model,int currentPage,int pageSize);

}
