/**  
 * @Title:  MenuPermissionInfo.java   
 * @Package com.clps.bj.mms.sm.vo   
 * @Description:    MenuPermission实体类封装的vo
 * @author: snow.y     
 * @date:   2018年2月1日 上午12:47:09   
 * @version V1.0 
 * @Copyright: 2018 clps.com Inc. All rights reserved. 
 */  
package com.clps.bj.mms.sm.vo;
import java.io.Serializable;
/**   
 * @ClassName:  MenuPermissionInfo   
 * @Description:MenuPermission实体类的vo
 * @author:     snow.y
 * @date:       2018年2月1日 上午12:47:09 
 * @version  
 */
public class MenuPermissionInfo implements Serializable{

	/**
	 */
	private static final long serialVersionUID = 1L;
	private Integer mpId;// 自增主键
	private Integer mpCreateId;// 创建人id
	private String mpCreateDatetime;// 创建日期
	private Integer mpUpdateUid;// 修改人id
	private String mpUpdateTime;// 修改日期
	private Integer menuId;// 菜单id
	private String menuName;//菜单名
	private String permissionId;// 权限id
	private String permissionName;//权限名
	private String permissionUrl;//url
	public final String getPermissionUrl() {
		return permissionUrl;
	}
	public final void setPermissionUrl(String permissionUrl) {
		this.permissionUrl = permissionUrl;
	}
	public final Integer getMpId() {
		return mpId;
	}
	public final void setMpId(Integer mpId) {
		this.mpId = mpId;
	}
	public final Integer getMpCreateId() {
		return mpCreateId;
	}
	public final void setMpCreateId(Integer mpCreateId) {
		this.mpCreateId = mpCreateId;
	}
	public final String getMpCreateDatetime() {
		return mpCreateDatetime;
	}
	public final void setMpCreateDatetime(String mpCreateDatetime) {
		this.mpCreateDatetime = mpCreateDatetime;
	}
	public final Integer getMpUpdateUid() {
		return mpUpdateUid;
	}
	public final void setMpUpdateUid(Integer mpUpdateUid) {
		this.mpUpdateUid = mpUpdateUid;
	}
	public final String getMpUpdateTime() {
		return mpUpdateTime;
	}
	public final void setMpUpdateTime(String mpUpdateTime) {
		this.mpUpdateTime = mpUpdateTime;
	}
	public final Integer getMenuId() {
		return menuId;
	}
	public final void setMenuId(Integer menuId) {
		this.menuId = menuId;
	}
	public final String getMenuName() {
		return menuName;
	}
	public final void setMenuName(String menuName) {
		this.menuName = menuName;
	}
	public final String getPermissionId() {
		return permissionId;
	}
	public final void setPermissionId(String permissionId) {
		this.permissionId = permissionId;
	}
	public final String getPermissionName() {
		return permissionName;
	}
	public final void setPermissionName(String permissionName) {
		this.permissionName = permissionName;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((menuId == null) ? 0 : menuId.hashCode());
		result = prime * result + ((permissionId == null) ? 0 : permissionId.hashCode());
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
		MenuPermissionInfo other = (MenuPermissionInfo) obj;
		if (menuId == null) {
			if (other.menuId != null)
				return false;
		} else if (!menuId.equals(other.menuId))
			return false;
		if (permissionId == null) {
			if (other.permissionId != null)
				return false;
		} else if (!permissionId.equals(other.permissionId))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "MenuPermissionInfo [mpId=" + mpId + ", mpCreateId=" + mpCreateId + ", mpCreateDatetime="
				+ mpCreateDatetime + ", mpUpdateUid=" + mpUpdateUid + ", mpUpdateTime=" + mpUpdateTime + ", menuId="
				+ menuId + ", menuName=" + menuName + ", permissionId=" + permissionId + ", permissionName="
				+ permissionName + "]";
	}
	
	


}
