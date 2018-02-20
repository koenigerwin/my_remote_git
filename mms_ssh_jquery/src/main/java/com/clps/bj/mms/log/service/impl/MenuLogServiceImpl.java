package com.clps.bj.mms.log.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clps.bj.mms.common.util.pagination.model.PageBean;
import com.clps.bj.mms.log.dao.impl.MenuLogDaoImpl;
import com.clps.bj.mms.log.entity.MenuLog;
import com.clps.bj.mms.log.service.IMenuLogService;
import com.clps.bj.mms.log.vo.InfoLogDto;
/**
 * 
 * @description：菜单日志服务层实现类
 * @className：MenuLogServiceImpl
 * @author LiuLong.Mr
 * @version V1.0.0
 * 2018年1月26日上午12:00:15
 */
@Service
public class MenuLogServiceImpl implements IMenuLogService {

	private MenuLogDaoImpl menuLogDao;

	public MenuLogDaoImpl getMenuLogDao() {
		return menuLogDao;
	}

	@Autowired
	public void setMenuLogDao(MenuLogDaoImpl menuLogDao) {
		this.menuLogDao = menuLogDao;
	}

	@Override
	public PageBean<MenuLog> getLogList(InfoLogDto model, int currentPage, int pageSize) {
		return menuLogDao.query(model, currentPage, pageSize);
	}

}
