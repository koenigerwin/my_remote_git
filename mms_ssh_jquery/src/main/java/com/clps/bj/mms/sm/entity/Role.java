package com.clps.bj.mms.sm.entity;


import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

/**
 *@description：role实体类
 *@className：Role
 *@author bai
 *@version v1.0
 *@date 2018年1月22日 下午3:33:39
 */
@Entity
@Table(name="role")
public class Role implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6320224282597819088L;   //序列化
	private Integer roleId; // 角色编号
	private String roleName; // 角色名称
	private String roleDescription; // 角色描述
	private String roleIcon; // 角色图标
	private String roleCreatedDatetime;// 创建时间
	private Integer roleCreatedUserId;   //创建人编号
	private String roleUpdatedDatetime;// 以上一次的修改时间为准
	private Integer roleUpdatedUserId;		//修改人编号
	private String roleDefault1;     //默认字段一
	private String roleDefault2;	//默认字段二
	private Set<RoleMenuPermission> roleMenus  = new HashSet<>();
	private Set<UserInfoMain> userInfos = new HashSet<>();
	/**
	 * 
	 */
	public Role() {
		super();
	}
	/**
	 * @param roleId
	 * @param roleName
	 * @param roleDescription
	 * @param roleIcon
	 * @param roleIsEnable
	 * @param roleCreatedDatetime
	 * @param roleCreatedName
	 * @param roleUpdatedDatetime
	 * @param roleUpdatedName
	 * @param roleDefault1
	 * @param roleDefault2
	 */
	public Role(Integer roleId, String roleName, String roleDescription, String roleIcon, String roleIsEnable,
			String roleCreatedDatetime, Integer roleCreatedUserId, String roleUpdatedDatetime, Integer roleUpdatedUserId,
			String roleDefault1, String roleDefault2) {
		super();
		this.roleId = roleId;
		this.roleName = roleName;
		this.roleDescription = roleDescription;
		this.roleIcon = roleIcon;
		this.roleCreatedDatetime = roleCreatedDatetime;
		this.roleCreatedUserId = roleCreatedUserId;
		this.roleUpdatedDatetime = roleUpdatedDatetime;
		this.roleUpdatedUserId = roleUpdatedUserId;
		this.roleDefault1 = roleDefault1;
		this.roleDefault2 = roleDefault2;
	}
	/**
	 * @return the roleId
	 */
	 @Id
	 @GenericGenerator(name = "generator", strategy = "increment") //设置主键自增
	 @GeneratedValue(generator = "generator")
	 @Column(name="ROLE_ID",length=11)
	public Integer getRoleId() {
		return roleId;
	}
	/**
	 * @param roleId the roleId to set
	 */
	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}
	/**
	 * @return the roleName
	 */
	@Column(name="ROLE_NAME",nullable=false,length=30,unique=true)
	public String getRoleName() {
		return roleName;
	}
	/**
	 * @param roleName the roleName to set
	 */
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	/**
	 * @return the roleDescription
	 */
	@Column(name="ROLE_DESCRIPTION",length=200,nullable=true)
	public String getRoleDescription() {
		return roleDescription;
	}
	/**
	 * @param roleDescription the roleDescription to set
	 */
	public void setRoleDescription(String roleDescription) {
		this.roleDescription = roleDescription;
	}
	/**
	 * @return the roleIcon
	 */
	@Column(name="ROLE_ICON",nullable=false,length=200)
	public String getRoleIcon() {
		return roleIcon;
	}
	/**
	 * @param roleIcon the roleIcon to set
	 */
	public void setRoleIcon(String roleIcon) {
		this.roleIcon = roleIcon;
	}
	/**
	 * @return the roleCreatedDatetime
	 */
	@Column(name="ROLE_CREATED_DATETIME",nullable=false,length=50)
	public String getRoleCreatedDatetime() {
		return roleCreatedDatetime;
	}
	/**
	 * @param roleCreatedDatetime the roleCreatedDatetime to set
	 */
	public void setRoleCreatedDatetime(String roleCreatedDatetime) {
		this.roleCreatedDatetime = roleCreatedDatetime;
	}
	/**
	 * @return the roleCreatedName
	 */
	@Column(name="ROLE_CREATED_USERID",nullable=false,length=11)
	public Integer getRoleCreatedUserId() {
		return roleCreatedUserId;
	}
	/**
	 * @param roleCreatedName the roleCreatedName to set
	 */
	public void setRoleCreatedUserId(Integer roleCreatedUserId) {
		this.roleCreatedUserId = roleCreatedUserId;
	}
	/**
	 * @return the roleUpdatedDatetime
	 */
	@Column(name="ROLE_UPDATED_DATETIME",nullable=false,length=50)
	public String getRoleUpdatedDatetime() {
		return roleUpdatedDatetime;
	}
	/**
	 * @param roleUpdatedDatetime the roleUpdatedDatetime to set
	 */
	public void setRoleUpdatedDatetime(String roleUpdatedDatetime) {
		this.roleUpdatedDatetime = roleUpdatedDatetime;
	}
	/**
	 * @return the roleUpdatedName
	 */
	@Column(name="ROLE_UPDATED_USERID",nullable=false,length=11)
	public Integer getRoleUpdatedUserId() {
		return roleUpdatedUserId;
	}
	/**
	 * @param roleUpdatedName the roleUpdatedName to set
	 */
	public void setRoleUpdatedUserId(Integer roleUpdatedUserId) {
		this.roleUpdatedUserId = roleUpdatedUserId;
	}
	/**
	 * @return the roleDefault1
	 */
	@Column(name="ROLE_DEFAULT1")
	public String getRoleDefault1() {
		return roleDefault1;
	}
	/**
	 * @param roleDefault1 the roleDefault1 to set
	 */
	public void setRoleDefault1(String roleDefault1) {
		this.roleDefault1 = roleDefault1;
	}
	/**
	 * @return the roleDefault2
	 */
	@Column(name="ROLE_DEFAULT2")
	public String getRoleDefault2() {
		return roleDefault2;
	}
	/**
	 * @param roleDefault2 the roleDefault2 to set
	 */
	public void setRoleDefault2(String roleDefault2) {
		this.roleDefault2 = roleDefault2;
	}
	/**
	 * @return the roleMenu
	 */
	@OneToMany(mappedBy="role",targetEntity=RoleMenuPermission.class,cascade=CascadeType.ALL)
	@LazyCollection(LazyCollectionOption.EXTRA)
	@Transient
	public Set<RoleMenuPermission> getRoleMenus() {
		return roleMenus;
	}
	/**
	 * @param roleMenu the roleMenu to set
	 */
	public void setRoleMenus(Set<RoleMenuPermission> roleMenus) {
		this.roleMenus=roleMenus;
	}

	@OneToMany(mappedBy="roleId",targetEntity=UserInfoMain.class)
	public Set<UserInfoMain> getUserInfos() {
		return userInfos;
	}
	
	public void setUserInfos(Set<UserInfoMain> userInfos) {
		this.userInfos = userInfos;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((roleId == null) ? 0 : roleId.hashCode());
		return result;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Role other = (Role) obj;
		if (roleId == null) {
			if (other.roleId != null)
				return false;
		} else if (!roleId.equals(other.roleId))
			return false;
		return true;
	}
	
}

