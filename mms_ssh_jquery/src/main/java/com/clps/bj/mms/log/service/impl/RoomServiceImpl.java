package com.clps.bj.mms.log.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clps.bj.mms.common.util.pagination.model.PageBean;
import com.clps.bj.mms.log.dao.impl.RoomLogDaoImpl;
import com.clps.bj.mms.log.entity.RoomLog;
import com.clps.bj.mms.log.service.IRoomLogService;
import com.clps.bj.mms.log.vo.InfoLogDto;
/**
 * 
 * @description：会议室服务层实现类
 * @className：RoomServiceImpl
 * @author LiuLong.Mr
 * @version V1.0.0
 * 2018年1月26日上午12:58:34
 */
@Service
public class RoomServiceImpl implements IRoomLogService {
	private RoomLogDaoImpl roomLogDao;
	public RoomLogDaoImpl getRoomLogDao() {
		return roomLogDao;
	}
	@Autowired
	public void setRoomLogDao(RoomLogDaoImpl roleLogDao) {
		this.roomLogDao = roleLogDao;
	}
	@Override
	public PageBean<RoomLog> getLogList(InfoLogDto model, int currentPage, int pageSize) {
		return roomLogDao.query(model, currentPage, pageSize);
	}

}
