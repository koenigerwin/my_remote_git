package com.clps.bj.mms.sm.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clps.bj.mms.sm.dao.RoleDao;
import com.clps.bj.mms.sm.entity.Role;
import com.clps.bj.mms.sm.service.IRoleService;
import com.clps.bj.mms.sm.vo.RoleVo;

/**
 * @description：提供role表的一系列操作
 * @className:RoleService
 * @author bai 
 * @version v1.0
 * 2017年12月22日 下午4:59:54
 */
@Service
public class RoleServiceImpl implements IRoleService{
	@Autowired
	private RoleDao rd;
	
	private Boolean flag;
	private List<Role> list;
	/**
	 * 根据角色编号获取角色名称
	 * @param roleId 角色编号
	 * @return 角色名称
	 */
	/**
	 * 初始化
	 */
	public RoleServiceImpl() {
		super();
	}
	
	public Role queryRoleName(int roleId) {
		Role role=null;
		try {
			role = rd.queryRoleName(roleId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return role;
	}


	/**
	 * 新增新的角色
	 * 
	 * @param role 要插入的角色对象
	 * @return 是否插入成功 true 插入 成功 false 插入失败
	 */
	public Boolean addRole(Role role) {
		flag=false;
		try {
			flag= rd.addRole(role);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}

	/**
	 * 删除角色
	 * 
	 * @param roleId 要删除角色的角色编号
	 * @return true 删除成功 false 删除失败
	 */
	@Override
	public boolean deleteRole(int roleId) {
		flag=false;
		try {
			flag= rd.deleteRole(roleId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}
	/**
	 * 查询所有的角色名称并分页
	 * @param currentPage 当前页
	 * @param pageSize 页长
	 * @return  查询结果List<Role>
	 */
	public List<Role> queryAllRoleName() {
		list=null;
		try {
			list=rd.queryAllRoleName();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	/**
	 * 修改角色表中信息
	 * @param role  要修改的role对象
	 * @param roleId   对应的roleID
	 * @return  是否修改成功
	 */
	public boolean updateRole(Role role, int roleId) {
		flag=false;
		try {
			flag=rd.updateRole(role, roleId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}
	/**
	 * 模糊查询角色名称
	 * @param rolename   输入的角色名称
	 * @return  查询结果List<Role>
	 */
	public List<Role> queryRoleByName(String rolename) {
		list=null;
		try {
			list=rd.queryRoleByName(rolename);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<RoleVo> putRoleToVo(List<Role> list) {
		List<Role> rolelist = queryAllRoleName();
		List<RoleVo> volist=new ArrayList<RoleVo>();
		for(Role role:rolelist) {
			RoleVo rv=new RoleVo();
			rv.setRoleId(role.getRoleId());
			rv.setRoleName(role.getRoleName());
			rv.setRoleIcon(role.getRoleIcon());
			rv.setRoleDescription(role.getRoleDescription());
			rv.setRoleUpdatedDatetime(role.getRoleUpdatedDatetime());
			rv.setRoleUpdatedUserId(role.getRoleUpdatedUserId());
			volist.add(rv);
		}
		return volist;
	}
}
