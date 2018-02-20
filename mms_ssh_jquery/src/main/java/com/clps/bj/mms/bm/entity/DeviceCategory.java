
package com.clps.bj.mms.bm.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * 
 * @ClassName: DeviceCategory
 * @Description: 设备分类
 * @author userdwt
 * @date 2018年1月8日 上午11:00:15
 *
 */
@Entity
@Table(name = "device_category")
public class DeviceCategory implements Serializable {
	/**
	 * @Fields serialVersionUID : (用一句话描述这个变量表示什么)
	 */
	private static final long serialVersionUID = 6133590101464758304L;

	private Integer deviceCategoryId;				//设备类目id

	private Integer deviceCategoryParentId;			//设备的父类目id
	
	private String deviceCategoryName;				//设备类目名称
	
	private Integer deviceCategoryStatus;			//设备类目状态
	
	private Integer deviceCategorySortOrder;		//设备类目排列序号
	
	private Short deviceCategoryIsParent;			//该类目是否为父类目
	
	private Date deviceCategoryCreated;				//设备类目创建时间
	
	private Date deviceCategoryUpdated;				//设备类目修改时间
	
	private Integer deviceCategoryCreatedUserId;	//设备类目创建人id
	
	private Integer deviceCategoryUpdatedUserId;	//设备类目修改人id
	
	private Set<Device> devices=new HashSet<>();	//设备类目下对应的设备集合

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "device_category_id")
	public Integer getDeviceCategoryId() {
		return deviceCategoryId;
	}

	public void setDeviceCategoryId(Integer deviceCategoryId) {
		this.deviceCategoryId = deviceCategoryId;
	}

	@Column(name = "device_category_parent_id")
	public Integer getDeviceCategoryParentId() {
		return deviceCategoryParentId;
	}

	public void setDeviceCategoryParentId(Integer deviceCategoryParentId) {
		this.deviceCategoryParentId = deviceCategoryParentId;
	}

	@Column(name = "device_category_name")
	public String getDeviceCategoryName() {
		return deviceCategoryName;
	}

	public void setDeviceCategoryName(String deviceCategoryName) {
		this.deviceCategoryName = deviceCategoryName == null ? null : deviceCategoryName.trim();
	}

	@Column(name = "device_category_status")
	public Integer getDeviceCategoryStatus() {
		return deviceCategoryStatus;
	}

	public void setDeviceCategoryStatus(Integer deviceCategoryStatus) {
		this.deviceCategoryStatus = deviceCategoryStatus;
	}

	@Column(name = "device_category_sort_order")
	public Integer getDeviceCategorySortOrder() {
		return deviceCategorySortOrder;
	}

	public void setDeviceCategorySortOrder(Integer deviceCategorySortOrder) {
		this.deviceCategorySortOrder = deviceCategorySortOrder;
	}

	@Column(name = "device_category_is_parent")
	public Short getDeviceCategoryIsParent() {
		return deviceCategoryIsParent;
	}

	public void setDeviceCategoryIsParent(Short deviceCategoryIsParent) {
		this.deviceCategoryIsParent = deviceCategoryIsParent;
	}

	@Column(name = "device_category_created")
	public Date getDeviceCategoryCreated() {
		return deviceCategoryCreated;
	}

	public void setDeviceCategoryCreated(Date deviceCategoryCreated) {
		this.deviceCategoryCreated = deviceCategoryCreated;
	}

	@Column(name = "device_category_updated")
	public Date getDeviceCategoryUpdated() {
		return deviceCategoryUpdated;
	}

	public void setDeviceCategoryUpdated(Date deviceCategoryUpdated) {
		this.deviceCategoryUpdated = deviceCategoryUpdated;
	}

	@Column(name = "device_category_created_name")
	public Integer getDeviceCategoryCreatedUserId() {
		return deviceCategoryCreatedUserId;
	}

	public void setDeviceCategoryCreatedUserId(Integer deviceCategoryCreatedUserId) {
		this.deviceCategoryCreatedUserId = deviceCategoryCreatedUserId;
	}

	@Column(name = "device_category_updated_name")
	public Integer getDeviceCategoryUpdatedUserId() {
		return deviceCategoryUpdatedUserId;
	}

	public void setDeviceCategoryUpdatedUserId(Integer deviceCategoryUpdatedUserId) {
		this.deviceCategoryUpdatedUserId = deviceCategoryUpdatedUserId;
	}

	@OneToMany(mappedBy="deviceCategory")
	public Set<Device> getDevices() {
		return devices;
	}

	public void setDevices(Set<Device> devices) {
		this.devices = devices;
	}

	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((deviceCategoryCreated == null) ? 0 : deviceCategoryCreated.hashCode());
		result = prime * result + ((deviceCategoryCreatedUserId == null) ? 0 : deviceCategoryCreatedUserId.hashCode());
		result = prime * result + ((deviceCategoryId == null) ? 0 : deviceCategoryId.hashCode());
		result = prime * result + ((deviceCategoryIsParent == null) ? 0 : deviceCategoryIsParent.hashCode());
		result = prime * result + ((deviceCategoryName == null) ? 0 : deviceCategoryName.hashCode());
		result = prime * result + ((deviceCategoryParentId == null) ? 0 : deviceCategoryParentId.hashCode());
		result = prime * result + ((deviceCategorySortOrder == null) ? 0 : deviceCategorySortOrder.hashCode());
		result = prime * result + ((deviceCategoryStatus == null) ? 0 : deviceCategoryStatus.hashCode());
		result = prime * result + ((deviceCategoryUpdated == null) ? 0 : deviceCategoryUpdated.hashCode());
		result = prime * result + ((deviceCategoryUpdatedUserId == null) ? 0 : deviceCategoryUpdatedUserId.hashCode());
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
		DeviceCategory other = (DeviceCategory) obj;
		if (deviceCategoryCreated == null) {
			if (other.deviceCategoryCreated != null)
				return false;
		} else if (!deviceCategoryCreated.equals(other.deviceCategoryCreated))
			return false;
		if (deviceCategoryCreatedUserId == null) {
			if (other.deviceCategoryCreatedUserId != null)
				return false;
		} else if (!deviceCategoryCreatedUserId.equals(other.deviceCategoryCreatedUserId))
			return false;
		if (deviceCategoryId == null) {
			if (other.deviceCategoryId != null)
				return false;
		} else if (!deviceCategoryId.equals(other.deviceCategoryId))
			return false;
		if (deviceCategoryIsParent == null) {
			if (other.deviceCategoryIsParent != null)
				return false;
		} else if (!deviceCategoryIsParent.equals(other.deviceCategoryIsParent))
			return false;
		if (deviceCategoryName == null) {
			if (other.deviceCategoryName != null)
				return false;
		} else if (!deviceCategoryName.equals(other.deviceCategoryName))
			return false;
		if (deviceCategoryParentId == null) {
			if (other.deviceCategoryParentId != null)
				return false;
		} else if (!deviceCategoryParentId.equals(other.deviceCategoryParentId))
			return false;
		if (deviceCategorySortOrder == null) {
			if (other.deviceCategorySortOrder != null)
				return false;
		} else if (!deviceCategorySortOrder.equals(other.deviceCategorySortOrder))
			return false;
		if (deviceCategoryStatus == null) {
			if (other.deviceCategoryStatus != null)
				return false;
		} else if (!deviceCategoryStatus.equals(other.deviceCategoryStatus))
			return false;
		if (deviceCategoryUpdated == null) {
			if (other.deviceCategoryUpdated != null)
				return false;
		} else if (!deviceCategoryUpdated.equals(other.deviceCategoryUpdated))
			return false;
		if (deviceCategoryUpdatedUserId == null) {
			if (other.deviceCategoryUpdatedUserId != null)
				return false;
		} else if (!deviceCategoryUpdatedUserId.equals(other.deviceCategoryUpdatedUserId))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "DeviceCategory [deviceCategoryId=" + deviceCategoryId + ", deviceCategoryParentId="
				+ deviceCategoryParentId + ", deviceCategoryName=" + deviceCategoryName + ", deviceCategoryStatus="
				+ deviceCategoryStatus + ", deviceCategorySortOrder=" + deviceCategorySortOrder
				+ ", deviceCategoryIsParent=" + deviceCategoryIsParent + ", deviceCategoryCreated="
				+ deviceCategoryCreated + ", deviceCategoryUpdated=" + deviceCategoryUpdated
				+ ", deviceCategoryCreatedUserId=" + deviceCategoryCreatedUserId + ", deviceCategoryUpdatedUserId="
				+ deviceCategoryUpdatedUserId + "]";
	}

}