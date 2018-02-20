package com.clps.bj.mms.log.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clps.bj.mms.common.util.pagination.model.PageBean;
import com.clps.bj.mms.log.dao.impl.LoginLogDaoImpl;
import com.clps.bj.mms.log.entity.LoginLog;
import com.clps.bj.mms.log.service.ILoginLogService;
import com.clps.bj.mms.log.vo.LoginDto;
/**
 * 
 * @description：登录日志服务层实现类
 * @className：LoginLogServiceImpl
 * @author LiuLong.Mr
 * @version V1.0.0
 * 2018年1月29日上午9:23:15
 */
@Service
public class LoginLogServiceImpl implements ILoginLogService {
	
	private LoginLogDaoImpl loginLogDao;
	public LoginLogDaoImpl getLoginLogDao() {
		return loginLogDao;
	}
	@Autowired
	public void setLoginLogDao(LoginLogDaoImpl loginLogDao) {
		this.loginLogDao = loginLogDao;
	}

	
	
	
	@Override
	public Boolean saveLogon(String ip,String sessionId, String userLogon, String userName) {
		LoginLog loginLog = new LoginLog(ip, sessionId,userLogon,userName, new Date());
		return loginLogDao.addLog(loginLog);
	}

	@Override
	public Boolean updateLogout(String sessionId) {	
		return loginLogDao.updateLog(sessionId);
	}

	@Override
	public PageBean<LoginLog> getLogList(LoginDto model, int currentPage, int pageSize) {
		return loginLogDao.query(model, currentPage, pageSize);
	}

	@Override
	public int getCountsByName(String userLogon) {
		return loginLogDao.queryCountsByName(userLogon);
	}
	
	

}
