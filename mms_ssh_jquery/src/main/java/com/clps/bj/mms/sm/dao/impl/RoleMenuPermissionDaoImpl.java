/**
 * 
 */
package com.clps.bj.mms.sm.dao.impl;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.clps.bj.mms.sm.dao.RoleMenuPermissionDao;
import com.clps.bj.mms.sm.entity.Role;
import com.clps.bj.mms.sm.entity.RoleMenuPermission;

/**
 * 
 * @ClassName: RoleMenuPermissionImpl
 * @Description:角色菜单权限关系的接口实现类
 * @author: snow_y
 * @date: 2018年1月25日 上午10:11:18
 * @version V 1.0.3
 */
@Repository
public class RoleMenuPermissionDaoImpl implements RoleMenuPermissionDao {
	@Autowired
	private SessionFactory factory;//hibernate会话工厂
	private List<RoleMenuPermission> list;//角色菜单权限关系集合
	private Query query;//query对象
	private String rmp_Id;// 自增id,主键
	private Role rmpRole;// Role对象
	private Integer menuPermission;// MenuPermission对象
	private Integer rmpUim_Id;// 操作人id
	private String rmpUdateTime;// 修改时间
	private int i = 0;//判断标志

	/*
	 * @param rmp
	 * 
	 * @return
	 * 
	 * @see
	 * com.clps.bj.mms.sm.dao.RoleMenuPermissionDAO#addRoleMenuPermission(com.
	 * clps.bj.mms.sm.entity.RoleMenuPermission)
	 */
	@Override
	public boolean addRoleMenuPermission(RoleMenuPermission rmp) {
		factory.getCurrentSession().save(rmp);
		return true;
	}

	/*
	 * @param rmp
	 * 
	 * @return
	 * 
	 * @see
	 * com.clps.bj.mms.sm.dao.RoleMenuPermissionDAO#deleteRoleMenuPermission(
	 * java.lang.Integer, java.lang.Integer, java.lang.Integer)
	 */
	@Override
	public boolean deleteRoleMenuPermission(RoleMenuPermission rmp) {
		rmp_Id = rmp.getRmpId();
		System.out.println(rmp_Id);
		rmpRole = rmp.getRole();
		// 设置参数
		//删除角色所有权限
		if(rmp_Id == null ){
			query = factory.getCurrentSession().createQuery(hqlDeleteByRole);
			query.setParameter(role, rmpRole);
			
			
		}
		//删除指定id权限
		else{
			query = factory.getCurrentSession().createQuery(hqlDeleteById);
			query.setParameter(rmpId, rmp_Id);
		}
		i = query.executeUpdate();
		return i > 0;
	}

	/*
	 * @param rmp
	 * 
	 * @return
	 * 
	 * @see
	 * com.clps.bj.mms.sm.dao.RoleMenuPermissionDAO#updateRoleMenuPermission(com
	 * .clps.bj.mms.sm.entity.RoleMenuPermission)
	 */
	@Override
	public boolean updateRoleMenuPermission(RoleMenuPermission rmp) {
		// 得到相关id
		rmpRole = rmp.getRole();
		rmpUim_Id = rmp.getRmpUimId();
		rmp_Id = rmp.getRmpId();
		rmpUdateTime = rmp.getRmpUpdatetime();
		menuPermission = rmp.getMenuPermission().getMpId();
		query = factory.getCurrentSession().createQuery(hqlUpdate);
		// 设置参数
		query.setParameter(mpId, menuPermission);
		query.setParameter(role, rmpRole);
		query.setParameter(rmpUimId, rmpUim_Id);
		query.setParameter(rmpUpdatetime, rmpUdateTime);
		query.setParameter(rmpId, rmp_Id);
		i = query.executeUpdate();
		return i > 0;
	}

	/*
	 * @param role_id
	 * 
	 * @return
	 * 
	 * @see
	 * com.clps.bj.mms.sm.dao.RoleMenuPermissionDAO#getRoleMenuPermissionById(
	 * java.lang.Integer)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<RoleMenuPermission> getRoleMenuPermissionByRoleId(RoleMenuPermission rmp) {
		query = factory.getCurrentSession().createQuery(hqlGetById);
		int rmpRole = rmp.getRole().getRoleId();
		query.setParameter(role, rmpRole);
		list = query.list();
		return list;
	}

	/*
	 * @return
	 * 
	 * @see
	 * com.clps.bj.mms.sm.dao.RoleMenuPermissionDAO#getAllRoleMenuPermission()
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<RoleMenuPermission> getAllRoleMenuPermission() {
		query = factory.getCurrentSession().createQuery(hqlGetAll);
		list = query.list();
		return list;
	}
}
