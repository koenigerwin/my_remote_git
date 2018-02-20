/**   
* @Title: DeviceCategoryDaoImpl.java 
* @Package com.clps.dev.mms.bm.device.dao.impl 
* @Description: (用一句话描述该文件做什么) 
* @author userdwt  
* @date 2018年1月18日 上午10:31:29 
* @version V1.0   
*/
package com.clps.bj.mms.bm.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.clps.bj.mms.bm.dao.DeviceCategoryDao;
import com.clps.bj.mms.bm.entity.DeviceCategory;

/**
 * @ClassName: DeviceCategoryDaoImpl
 * @Description: (这里用一句话描述这个类的作用)
 * @author userdwt
 * @date 2018年1月18日 上午10:31:29
 * 
 */
@Repository
public class DeviceCategoryDaoImpl implements DeviceCategoryDao {
	@Resource
	private SessionFactory sessionFactory;

	private static final String selectAllByParentIdSql = " FROM DeviceCategory WHERE deviceCategoryParentId=?";

	public DeviceCategoryDaoImpl() {
		super();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.clps.dev.mms.bm.device.dao.DeviceCategoryDao#selectByParentId(int)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<DeviceCategory> selectByParentId(int parentId) {

		// List<DeviceCategory> list=template.queryAll(selectAllByParentIdSql, this,
		// parentId);
		// if (!list.isEmpty()) {
		// logger.info("查询成功");
		// } else {
		// logger.info("查询失败");
		// }
		// return list;
		Query query = sessionFactory.getCurrentSession().createQuery(selectAllByParentIdSql);

		query.setParameter(0, parentId);
		return query.list();

	}

}
