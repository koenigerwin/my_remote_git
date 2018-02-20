/**  
 * @Title:  MenuPermssion.java   
 * @Package com.clps.bj.mms.sm.entity   
 * @Description:    菜单权限关系实体类
 * @author: snow.y     
 * @date:   2018年1月26日 上午11:48:22   
 * @version V1.0 
 * @Copyright: 2018 clps.com Inc. All rights reserved. 
 */
package com.clps.bj.mms.sm.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.Cascade;

/**
 * @ClassName: MenuPermssion
 * @Description:菜单权限实体类
 * @author: snow.y
 * @date: 2018年1月26日 上午11:48:22
 * @version V 1.0.3
 */
@Entity
@Table(name = "menu_permission")
public class MenuPermission implements Serializable {
	/**
	 */
	private static final long serialVersionUID = 1L;
	private Integer mpId;// 自增主键
	private Integer mpCreateId;// 创建人id
	private String mpCreateDatetime;// 创建日期
	private Integer mpUpdateUid;// 修改人id
	private String mpUpdateTime;// 修改日期
	private Menu menu;// 菜单对象
	private Permission permission;// 权限对象
	private Set<RoleMenuPermission> mpSet;

	@Id
	@GeneratedValue
	@Column(name = "mp_id", length = 11, nullable = false, unique = true)
	public final Integer getMpId() {
		return mpId;
	}

	public final void setMpId(Integer mpId) {
		this.mpId = mpId;
	}

	@Column(name = "mp_create_id", length = 11, nullable = false)
	public final Integer getMpCreateId() {
		return mpCreateId;
	}

	public final void setMpCreateId(Integer mpCreateId) {
		this.mpCreateId = mpCreateId;
	}

	@Column(name = "mp_create_datetime", length = 50, nullable = false)
	public final String getMpCreateDatetime() {
		return mpCreateDatetime;
	}

	public final void setMpCreateDatetime(String mpCreateDatetime) {
		this.mpCreateDatetime = mpCreateDatetime;
	}

	@Column(name = "mp_update_uid", length = 11, nullable = false)
	public final Integer getMpUpdateUid() {
		return mpUpdateUid;
	}

	public final void setMpUpdateUid(Integer mpUpdateUid) {
		this.mpUpdateUid = mpUpdateUid;
	}

	@Column(name = "mp_updatetime", length = 50, nullable = false)
	public final String getMpUpdateTime() {
		return mpUpdateTime;
	}

	public final void setMpUpdateTime(String mpUpdateTime) {
		this.mpUpdateTime = mpUpdateTime;
	}

	@ManyToOne(fetch = FetchType.EAGER, targetEntity = Menu.class)
	@JoinColumn(name = "mp_menu_id", nullable = false) // 菜单id
	public final Menu getMenu() {
		return menu;
	}

	public final void setMenu(Menu menu) {
		this.menu = menu;
	}

	@ManyToOne(fetch = FetchType.EAGER, targetEntity = Permission.class)
	@JoinColumn(name = "mp_pmsn_id") 
	public final Permission getPermission() {
		return permission;
	}

	public final void setPermission(Permission permission) {
		this.permission = permission;
	}

	@OneToMany(fetch = FetchType.LAZY, targetEntity = RoleMenuPermission.class)
	@Cascade({ org.hibernate.annotations.CascadeType.DELETE})
	@Transient
	public final Set<RoleMenuPermission> getMpSet() {
		return mpSet;
	}

	public final void setMpSet(Set<RoleMenuPermission> mpSet) {
		this.mpSet = mpSet;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((menu == null) ? 0 : menu.hashCode());
		result = prime * result + ((permission == null) ? 0 : permission.hashCode());
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
		MenuPermission other = (MenuPermission) obj;
		if (menu.getMenuId() == null) {
			if (menu.getMenuId() != null)
				return false;
		} else if (!(menu.getMenuId() == other.getMenu().getMenuId()))
			return false;
		if (permission.getPmsnId() == null) {
			if (other.permission.getPmsnId() != null)
				return false;
		} else if (!(permission.getPmsnId() == other.getPermission().getPmsnId()))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "MenuPermssion [mpId=" + mpId + ", mpCreateId=" + mpCreateId + ", mpCreateDatetime=" + mpCreateDatetime
				+ ", mpUpdateUid=" + mpUpdateUid + ", mpUpdateTime=" + mpUpdateTime + ", menu=" + menu + ", permission="
				+ permission + "]";
	}

}
