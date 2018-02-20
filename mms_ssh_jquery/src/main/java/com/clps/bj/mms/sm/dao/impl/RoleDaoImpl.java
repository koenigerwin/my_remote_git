package com.clps.bj.mms.sm.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.clps.bj.mms.sm.dao.RoleDao;
import com.clps.bj.mms.sm.dao.RoleHql;
import com.clps.bj.mms.sm.entity.Role;

/**
 * @desciption：roledao接口实现
 * @className：RoleDaoImpl 
 * @author bai 
 * @version v1.0
 * 2017年12月22日 下午4:59:37
 */
@Repository
public class RoleDaoImpl implements RoleDao,RoleHql{
	
	@Autowired
	private SessionFactory sessionFactory;
	/**
	 * 初始化
	 */
	public RoleDaoImpl() {
		super();
	}

	/**
	 * 根据角色编号获取角色名称
	 * 
	 * @param roleId 角色编号
	 * @return Role 角色
	 */
	@Override
	public Role queryRoleName(int roleId) {
		Query query = sessionFactory.getCurrentSession().createQuery(queryRoleNameHql);
		query.setParameter(0, roleId);
		return (Role)query.uniqueResult();
	}

	/**
	 * 新增新的角色
	 * @param roleId 要插入的角色编号
	 * @param roleName 要插入的角色名称
	 * @return 是否插入成功  true 插入 成功  false 插入失败
	 */
	@Override
	public Boolean addRole(Role role) {
		Integer save = (Integer)sessionFactory.getCurrentSession().save(role);
		return save>0;
	}
	/**
	 * 物理删除角色
	 * @param roleId  要删除的角色编号
	 */
	@Override
	public boolean deleteRole(int roleId) {
		Boolean result=false;
		Role role = queryRoleName(roleId);
		sessionFactory.getCurrentSession().delete(role);
		result=true;
		return result;
	}
	/**
	 * 查询所有的角色名称并分页
	 * @param currentPage 当前页
	 * @param pageSize 页长
	 * @return  查询结果List<Role>
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Role> queryAllRoleName() {
		Query query = sessionFactory.getCurrentSession().createQuery(queryRoleForPageHql);

		return query.list();
	}
	/**
	 * 模糊查询角色名称
	 * @param rolename   输入的角色名称
	 * @return  查询结果List<Role>
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Role> queryRoleByName(String rolename) {
		Query query = sessionFactory.getCurrentSession().createQuery(queryRoleByNameSql);
		query.setParameter("NAME", "%"+rolename+"%");
		return (List<Role>)query.list();
	}
	@Override
	/**
	 * 修改角色表中信息
	 * @param role  要修改的role对象
	 * @param roleId   对应的roleID
	 * @return  是否修改成功
	 */
	public boolean updateRole(Role role, int roleId) {
		Query query = sessionFactory.getCurrentSession().createQuery(updateRoleHql);
		query.setParameter(0, role.getRoleName());
		query.setParameter(1, role.getRoleIcon());
		query.setParameter(2, role.getRoleDescription());
		query.setParameter(3, role.getRoleUpdatedDatetime());
		query.setParameter(4, role.getRoleUpdatedUserId());
		query.setParameter(5, roleId);
		return query.executeUpdate() > 0;
	}

	
}
