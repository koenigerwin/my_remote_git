package com.clps.bj.mms.log.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clps.bj.mms.common.util.pagination.model.PageBean;
import com.clps.bj.mms.log.dao.impl.RoleLogDaoImpl;
import com.clps.bj.mms.log.entity.RoleLog;
import com.clps.bj.mms.log.service.IRoleLogService;
import com.clps.bj.mms.log.vo.InfoLogDto;
/**
 * 
 * @description：角色日志服务层实现类
 * @className：RoleLogServiceImpl
 * @author LiuLong.Mr
 * @version V1.0.0
 * 2018年1月26日上午1:14:42
 */
@Service
public class RoleLogServiceImpl implements IRoleLogService {
	private RoleLogDaoImpl roleLogDao;
	public RoleLogDaoImpl getRoleLogDao() {
		return roleLogDao;
	}
	@Autowired
	public void setRoleLogDao(RoleLogDaoImpl roleLogDao) {
		this.roleLogDao = roleLogDao;
	}
	@Override
	public PageBean<RoleLog> getLogList(InfoLogDto model, int currentPage, int pageSize) {
		return roleLogDao.query(model, currentPage, pageSize);
	}

}
