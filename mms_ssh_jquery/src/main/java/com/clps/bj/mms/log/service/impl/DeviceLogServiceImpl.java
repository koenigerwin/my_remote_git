package com.clps.bj.mms.log.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clps.bj.mms.common.util.pagination.model.PageBean;
import com.clps.bj.mms.log.dao.impl.DeviceLogDaoImpl;
import com.clps.bj.mms.log.entity.DeviceLog;
import com.clps.bj.mms.log.service.IDeviceLogService;
import com.clps.bj.mms.log.vo.InfoLogDto;
/**
 * 
 * @description：设备日志服务层实现类
 * @className：DeviceLogServiceImpl
 * @author LiuLong.Mr
 * @version V1.0.0
 * 2018年1月26日上午1:11:56
 */
@Service
public class DeviceLogServiceImpl implements IDeviceLogService {
	private DeviceLogDaoImpl deviceLogDao;
	public DeviceLogDaoImpl getDeviceLogDao() {
		return deviceLogDao;
	}
	@Autowired
	public void setDeviceLogDao(DeviceLogDaoImpl deviceLogDao) {
		this.deviceLogDao = deviceLogDao;
	}
	@Override
	public PageBean<DeviceLog> getLogList(InfoLogDto model, int currentPage, int pageSize) {
		return deviceLogDao.query(model, currentPage, pageSize);
	}

}
