package com.clps.bj.mms.log.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clps.bj.mms.common.util.pagination.model.PageBean;
import com.clps.bj.mms.log.dao.impl.MeetingLogDaoImpl;
import com.clps.bj.mms.log.entity.MeetingLog;
import com.clps.bj.mms.log.service.IMeetingLogService;
import com.clps.bj.mms.log.vo.InfoLogDto;
@Service
public class MeetingLogServiceImpl implements IMeetingLogService {
	private MeetingLogDaoImpl meetingLogDao;
	public MeetingLogDaoImpl getMeetingLogDao() {
		return meetingLogDao;
	}
	@Autowired 
	public void setMeetingLogDao(MeetingLogDaoImpl meetingLogDao) {
		this.meetingLogDao = meetingLogDao;
	}
	@Override
	public PageBean<MeetingLog> getLogList(InfoLogDto model, int currentPage, int pageSize) {
		return meetingLogDao.query(model, currentPage, pageSize);
	}

}
