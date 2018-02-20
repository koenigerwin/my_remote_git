package com.clps.bj.mms.sm.vo;
/**
 *@Description：RoleVo
 *@className：RoleVo
 *@author bai
 *@version v1.0
 *@date 2018年2月4日 上午10:45:16
*/
public class RoleVo {
	private Integer roleId; // 角色编号
	private String roleName; // 角色名称
	private String roleDescription; // 角色描述
	private String roleIcon; // 角色图标
	private String roleUpdatedDatetime;// 以上一次的修改时间为准
	private Integer roleUpdatedUserId;		//修改人编号
	/**
	 * 
	 */
	public RoleVo() {
		super();
	}
	/**
	 * @param roleId
	 * @param roleName
	 * @param roleDescription
	 * @param roleIcon
	 * @param roleUpdatedDatetime
	 * @param roleUpdatedUserId
	 */
	public RoleVo(Integer roleId, String roleName, String roleDescription, String roleIcon, String roleUpdatedDatetime,
			Integer roleUpdatedUserId) {
		super();
		this.roleId = roleId;
		this.roleName = roleName;
		this.roleDescription = roleDescription;
		this.roleIcon = roleIcon;
		this.roleUpdatedDatetime = roleUpdatedDatetime;
		this.roleUpdatedUserId = roleUpdatedUserId;
	}
	/**
	 * @return the roleId
	 */
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
	 * @return the roleUpdatedDatetime
	 */
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
	 * @return the roleUpdatedUserId
	 */
	public Integer getRoleUpdatedUserId() {
		return roleUpdatedUserId;
	}
	/**
	 * @param roleUpdatedUserId the roleUpdatedUserId to set
	 */
	public void setRoleUpdatedUserId(Integer roleUpdatedUserId) {
		this.roleUpdatedUserId = roleUpdatedUserId;
	}
	
	
}
