package com.clps.bj.mms.log.service;

import com.clps.bj.mms.common.util.pagination.model.PageBean;
import com.clps.bj.mms.log.entity.MenuLog;
import com.clps.bj.mms.log.vo.InfoLogDto;

/**
 * 
 * @description：菜单日志服务层接口
 * @className：IMenuLogService
 * @author LiuLong.Mr
 * @version V1.0.0
 * 2018年1月25日下午11:14:08
 */
public interface IMenuLogService {
	/**
	 * 
	 * @param model		输入信息数据传输模型
	 * @param currentPage		当前页
	 * @param pageSize		页长
	 * @return		PageBean<MenuLog>	日志分页对象
	 */
	PageBean<MenuLog> getLogList(InfoLogDto model,int currentPage,int pageSize);
}
