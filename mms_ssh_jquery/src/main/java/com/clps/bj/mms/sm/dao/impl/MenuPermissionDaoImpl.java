/**  
 * @Title:  MenuPermissionDaoImpl.java   
 * @Package com.clps.bj.mms.sm.dao.impl   
 * @Description:    MenuPermissionDao接口实现类
 * @author: snow.y     
 * @date:   2018年1月26日 下午2:38:55   
 * @version V1.0 
 * @Copyright: 2018 clps.com Inc. All rights reserved. 
 */
package com.clps.bj.mms.sm.dao.impl;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.clps.bj.mms.sm.dao.MenuPermissionDao;
import com.clps.bj.mms.sm.entity.MenuPermission;
import com.clps.bj.mms.sm.entity.Permission;

/**
 * @ClassName: MenuPermissionDaoImpl
 * @Description:MenuPermissionDao接口实现类
 * @author: snow.y
 * @date: 2018年1月26日 下午2:38:55
 * @version V 1.0.0
 */
@Repository
public class MenuPermissionDaoImpl implements MenuPermissionDao {
	@Autowired
	private SessionFactory factory;//hibernate会话工厂
	private int i = 0;//判断标志
	private Query query;//query对象
	private Integer id;//主键id
	private Integer updateUid;//修改人id
	private String updateTime;//修改时间
	private Integer menuId;//菜单id
	private String permissionId;//权限id
	private List<MenuPermission> list;//菜单权限关系集合

	/*
	 * @param menuPermission
	 * 
	 * @return
	 * 
	 * @see
	 * com.clps.bj.mms.sm.dao.MenuPermissionDao#addMenuPermission(com.clps.bj.
	 * mms.sm.dao.MenuPermissionDao)
	 */
	@Override
	public boolean addMenuPermission(MenuPermission menuPermission) {
		i = (int) factory.getCurrentSession().save(menuPermission);
		return i > 0;
	}

	/*
	 * @param menuPermission
	 * 
	 * @return
	 * 
	 * @see
	 * com.clps.bj.mms.sm.dao.MenuPermissionDao#deleteMenuPermission(com.clps.bj
	 * .mms.sm.dao.MenuPermissionDao)
	 */
	@Override
	public boolean deleteMenuPermission(MenuPermission menuPermission) {
		/*Session s = factory.getCurrentSession();
		MenuPermissionDao mpd = (MenuPermissionDao) s.load(MenuPermission.class, menuPermission.getMpId());
		s.delete(mpd);*/
		String delete = hqlDelete;
		String pmsnId = menuPermission.getPermission().getPmsnId();
		int menuId = menuPermission.getMenu().getMenuId();
		if(pmsnId != null){
			delete+=" and mp.permission.pmsnId=:pmsnId";
			query = factory.getCurrentSession().createQuery(delete);
			query.setParameter(mpPmsnId, pmsnId);
		}
		else{
			query = factory.getCurrentSession().createQuery(delete);
		}
		query.setParameter(mpMenuId, menuId);
		 i = query.executeUpdate();
		return i>0;
	}

	/*
	 * @param menuPermission
	 * 
	 * @return
	 * 
	 * @see
	 * com.clps.bj.mms.sm.dao.MenuPermissionDao#updateMenuPermission(com.clps.bj
	 * .mms.sm.dao.MenuPermissionDao)
	 */
	@Override
	public boolean updateMenuPermission(MenuPermission menuPermission) {
		query = factory.getCurrentSession().createQuery(hqlUpdate);
		id = menuPermission.getMpId();
		updateUid = menuPermission.getMpUpdateUid();
		updateTime = menuPermission.getMpUpdateTime();
		menuId = menuPermission.getMenu().getMenuId();
		permissionId = menuPermission.getPermission().getPmsnId();
		query.setParameter(mpId, id);
		query.setParameter(mpUpdateTime, updateTime);
		query.setParameter(mpUpdateUid, updateUid);
		query.setParameter(mpPmsnId, permissionId);
		query.setParameter(mpMenuId, menuId);
		i = query.executeUpdate();
		return i > 0;
	}

	/*
	 * @param menuPermission
	 * 
	 * @return
	 * 
	 * @see
	 * com.clps.bj.mms.sm.dao.MenuPermissionDao#getMenuPermissionByMenuId(com.
	 * clps.bj.mms.sm.dao.MenuPermissionDao)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Permission> getMenuPermissionByMenuId(MenuPermission menuPermission) {
		query = factory.getCurrentSession().createQuery(hqlQueryByMId);
		menuId = menuPermission.getMenu().getMenuId();
		query.setParameter(mpMenuId, menuId);
		list = query.list();
		List<Permission> item = new ArrayList<>();
		for (MenuPermission menuPermission2 : list) {
			item.add(menuPermission2.getPermission());
		}
		return item;
	}

	/*
	 * @return
	 * 
	 * @see com.clps.bj.mms.sm.dao.MenuPermissionDao#getAllMenuPermission()
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<MenuPermission> getAllMenuPermission() {
		query = factory.getCurrentSession().createQuery(hqlQueryAll);
		list = query.list();
		return list;
	}

	/* 
	 * @param menuPermission
	 * @return      
	 * @see com.clps.bj.mms.sm.dao.MenuPermissionDao#getMenuPermissionById(com.clps.bj.mms.sm.entity.MenuPermission)
	 */

	@SuppressWarnings("unchecked")
	@Override
	public MenuPermission getMenuPermissionById(MenuPermission menuPermission) {
		id = menuPermission.getMpId();
		query = factory.getCurrentSession().createQuery(hqlQueryById);
		query.setParameter("mpId", id);
		list = query.list();
		return list.size()>0?list.get(0):null;
	}

}
