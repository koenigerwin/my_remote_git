package com.clps.bj.mms.sm.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * 
 * @ClassName: RoleMenuPermission
 * @Description:角色菜单权限关系的 实体类
 * @author: snow.y
 * @date: 2018年1月23日 下午5:17:23
 * @version V1.0.3
 */
@Entity
@Table(name = "role_menu_pmsn")
public class RoleMenuPermission implements Serializable {
	/**
	 * @Fields serialVersionUID
	 */
	private static final long serialVersionUID = 1L;
	private String rmpId;// 自增编号
	private Role role;// 角色对象
	private MenuPermission menuPermission;//菜单权限关系
	private Integer rmpCreateUid;//创建人id
	private String rmpCreateDatetime;// 创建日期
	private Integer rmpUimId;//修改人id
	private String rmpUpdatetime;// 修改日期
	@ManyToOne(fetch = FetchType.EAGER,targetEntity = Role.class)
	@JoinColumn(name = "rmp_role_id",nullable = false)
	public final Role getRole() {
		return role;
	}

	public final void setRole(Role role) {
		this.role = role;
	}
	@ManyToOne(fetch = FetchType.EAGER,targetEntity = MenuPermission.class)
	@JoinColumn(name = "rmp_mp_id",nullable = false)
	public final MenuPermission getMenuPermission() {
		return menuPermission;
	}

	public final void setMenuPermission(MenuPermission menuPermission) {
		this.menuPermission = menuPermission;
	}

	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid")
	@Column(name = "rmp_id",length = 32,nullable = false,unique = true)
	public final String getRmpId() {
		return rmpId;
	}

	public final void setRmpId(String rmpId) {
		this.rmpId = rmpId;
	}

	@Column(name = "rmp_create_datetime",length = 50,nullable = false)
	public final String getRmpCreateDatetime() {
		return rmpCreateDatetime;
	}

	public final void setRmpCreateDatetime(String rmpCreateDatetime) {
		this.rmpCreateDatetime = rmpCreateDatetime;
	}

	@Column(name = "rmp_uim_id",length = 11,nullable = false)
	public final Integer getRmpUimId() {
		return rmpUimId;
	}

	public final void setRmpUimId(Integer rmpUimId) {
		this.rmpUimId = rmpUimId;
	}

	@Column(name = "rmp_updatetime",length = 50,nullable = false)
	public final String getRmpUpdatetime() {
		return rmpUpdatetime;
	}

	public final void setRmpUpdatetime(String rmpUpdatetime) {
		this.rmpUpdatetime = rmpUpdatetime;
	}
	@Column(name = "rmp_create_uid",length = 11,nullable = false)
	public final Integer getRmpCreateUid() {
		return rmpCreateUid;
	}

	public final void setRmpCreateUid(Integer rmpCreateUid) {
		this.rmpCreateUid = rmpCreateUid;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((menuPermission == null) ? 0 : menuPermission.hashCode());
		result = prime * result + ((role == null) ? 0 : role.hashCode());
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
		RoleMenuPermission other = (RoleMenuPermission) obj;
		if (menuPermission.getMpId() == null) {
			if (other.menuPermission.getMpId() != null)
				return false;
		} else if (!(menuPermission.getMpId() == other.menuPermission.getMpId()))
			return false;
		if (role.getRoleId() == null) {
			if (other.role.getRoleId() != null)
				return false;
		} else if (!(role.getRoleId()==other.getRole().getRoleId()))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "RoleMenuPermission [rmpId=" + rmpId + ", role=" + role + ", menuPermssion=" + menuPermission
				+ ", rmpCreateUid=" + rmpCreateUid + ", rmpCreateDatetime=" + rmpCreateDatetime + ", rmpUimId="
				+ rmpUimId + ", rmpUpdatetime=" + rmpUpdatetime + "]";
	}

}
