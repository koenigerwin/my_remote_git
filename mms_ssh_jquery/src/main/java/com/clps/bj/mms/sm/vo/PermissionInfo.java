/**  
 * @Title:  PermissionInfo.java   
 * @Package com.clps.bj.mms.sm.vo   
 * @Description: Permission有效字段实体类  
 * @author: snow.y     
 * @date:   2018年1月31日 下午11:47:09   
 * @version V1.0 
 * @Copyright: 2018 clps.com Inc. All rights reserved. 
 */  
package com.clps.bj.mms.sm.vo;

import java.io.Serializable;

/**   
 * @ClassName:  PermissionInfo   
 * @Description:Permission有效字段
 * @author:     snow.y
 * @date:       2018年1月31日 下午11:47:09 
 * @version  
 */
public class PermissionInfo implements  Serializable{

	private static final long serialVersionUID = 1L;
	private String pmsnId; // 权限id
	private String pmsnName;// 权限名,必填 长度
	private String pmsnDescription;// 权限描述
	private String pmsnUrl;// 权限url
	private Integer pmsnCreateId;//创建人id
	private String pmsnCreateName;//创建人名
	private String pmsnCreateDatetime;// 创建日期
	private Integer pmsnUimId;// 修改人id
	private String pmsnUimName;//修改人名
	private String pmsnUpdateTime;// 修改日期

	public PermissionInfo() {
		super();
	}


	public final String getPmsnCreateName() {
		return pmsnCreateName;
	}


	public final void setPmsnCreateName(String pmsnCreateName) {
		this.pmsnCreateName = pmsnCreateName;
	}


	public final String getPmsnUimName() {
		return pmsnUimName;
	}


	public final void setPmsnUimName(String pmsnUimName) {
		this.pmsnUimName = pmsnUimName;
	}


	public final String getPmsnId() {
		return pmsnId;
	}

	public final void setPmsnId(String pmsnId) {
		this.pmsnId = pmsnId;
	}

	public final Integer getPmsnCreateId() {
		return pmsnCreateId;
	}
	public final void setPmsnCreateId(Integer pmsnCreateId) {
		this.pmsnCreateId = pmsnCreateId;
	}

	public final String getPmsnName() {
		return pmsnName;
	}

	public final void setPmsnName(String pmsnName) {
		this.pmsnName = pmsnName;
	}

	public final String getPmsnDescription() {
		return pmsnDescription;
	}

	public final void setPmsnDescription(String pmsnDescription) {
		this.pmsnDescription = pmsnDescription;
	}

	public final String getPmsnUrl() {
		return pmsnUrl;
	}

	public final void setPmsnUrl(String pmsnUrl) {
		this.pmsnUrl = pmsnUrl;
	}

	public final String getPmsnCreateDatetime() {
		return pmsnCreateDatetime;
	}

	public final void setPmsnCreateDatetime(String pmsnCreateDatetime) {
		this.pmsnCreateDatetime = pmsnCreateDatetime;
	}

	public final Integer getPmsnUimId() {
		return pmsnUimId;
	}

	public final void setPmsnUimId(Integer pmsnUimId) {
		this.pmsnUimId = pmsnUimId;
	}

	public final String getPmsnUpdateTime() {
		return pmsnUpdateTime;
	}

	public final void setPmsnUpdateTime(String pmsnUpdateTime) {
		this.pmsnUpdateTime = pmsnUpdateTime;
	}
	@Override
	public int hashCode() {
		return pmsnName.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PermissionInfo other = (PermissionInfo) obj;
		// 增加的情况
		if (this.getPmsnId() == null) {
			if (this.getPmsnName() == null) {
				return true;
			} else {
				if (other.getPmsnName().equals(this.getPmsnName()))
					return true;
				else
					return false;
			}
		}
		// 删除修改查询的情况
		else {
			if (this.pmsnId == other.pmsnId) {
				// 删除、查询的情况
				if (this.getPmsnName() == null) {
					return true;
				}
				// 修改的情况
				else {
					if (other.getPmsnName().equals(this.getPmsnName()))
						return true;
					else
						return false;
				}
			} else
				return false;
		}
	}

	@Override
	public String toString() {
		return "PermissionInfo [pmsnId=" + pmsnId + ", pmsnName=" + pmsnName + ", pmsnDescription=" + pmsnDescription
				+ ", pmsnUrl=" + pmsnUrl + ", pmsnCreateId=" + pmsnCreateId + ", pmsnCreateName=" + pmsnCreateName
				+ ", pmsnCreateDatetime=" + pmsnCreateDatetime + ", pmsnUimId=" + pmsnUimId + ", pmsnUimName="
				+ pmsnUimName + ", pmsnUpdateTime=" + pmsnUpdateTime + "]";
	}


}
