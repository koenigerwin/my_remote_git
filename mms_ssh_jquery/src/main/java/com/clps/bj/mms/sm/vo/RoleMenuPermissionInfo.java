/**  
 * @Title:  RoleMenuPermissionInfo.java   
 * @Package com.clps.bj.mms.sm.vo   
 * @Description:  封装RoleMenuPermission实体类
 * @author: snow.y     
 * @date:   2018年2月1日 上午10:52:35   
 * @version V1.0 
 * @Copyright: 2018 clps.com Inc. All rights reserved. 
 */
package com.clps.bj.mms.sm.vo;

import java.io.Serializable;

/**
 * @ClassName: RoleMenuPermissionInfo
 * @Description:封装RoleMenuPermission实体类
 * @author: snow.y
 * @date: 2018年2月1日 上午10:52:35
 * @version
 */
public class RoleMenuPermissionInfo implements Serializable {
	/**
	 * @Fields serialVersionUID
	 */
	private static final long serialVersionUID = 1L;
	private String rmpId;// 自增编号
	private Integer roleId;// 角色对象
	private String roleName;
	private Integer menuPermissionId;// 菜单权限关系
	private Integer rmpCreateUid;// 创建人id
	private String rmpCreateDatetime;// 创建日期
	private Integer rmpUimId;// 修改人id
	private String rmpUpdatetime;// 修改日期
	
	public RoleMenuPermissionInfo() {
		super();
	}
	public final String getRmpId() {
		return rmpId;
	}
	public final void setRmpId(String rmpId) {
		this.rmpId = rmpId;
	}
	public final Integer getRoleId() {
		return roleId;
	}
	public final void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}
	public final String getRoleName() {
		return roleName;
	}
	public final void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public final Integer getMenuPermissionId() {
		return menuPermissionId;
	}
	public final void setMenuPermissionId(Integer menuPermissionId) {
		this.menuPermissionId = menuPermissionId;
	}
	public final Integer getRmpCreateUid() {
		return rmpCreateUid;
	}
	public final void setRmpCreateUid(Integer rmpCreateUid) {
		this.rmpCreateUid = rmpCreateUid;
	}
	public final String getRmpCreateDatetime() {
		return rmpCreateDatetime;
	}
	public final void setRmpCreateDatetime(String rmpCreateDatetime) {
		this.rmpCreateDatetime = rmpCreateDatetime;
	}
	public final Integer getRmpUimId() {
		return rmpUimId;
	}
	public final void setRmpUimId(Integer rmpUimId) {
		this.rmpUimId = rmpUimId;
	}
	public final String getRmpUpdatetime() {
		return rmpUpdatetime;
	}
	public final void setRmpUpdatetime(String rmpUpdatetime) {
		this.rmpUpdatetime = rmpUpdatetime;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((rmpId == null) ? 0 : rmpId.hashCode());
		result = prime * result + ((roleId == null) ? 0 : roleId.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RoleMenuPermissionInfo other = (RoleMenuPermissionInfo) obj;
		if (rmpId == null) {
			if (other.rmpId != null)
				return false;
		} else if (!rmpId.equals(other.rmpId))
			return false;
		if (roleId == null) {
			if (other.roleId != null)
				return false;
		} else if (!roleId.equals(other.roleId))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "RoleMenuPermissionInfo [rmpId=" + rmpId + ", roleId=" + roleId + ", roleName=" + roleName
				+ ", menuPermissionId=" + menuPermissionId + ", rmpCreateUid=" + rmpCreateUid + ", rmpCreateDatetime="
				+ rmpCreateDatetime + ", rmpUimId=" + rmpUimId + ", rmpUpdatetime=" + rmpUpdatetime + "]";
	}

}
