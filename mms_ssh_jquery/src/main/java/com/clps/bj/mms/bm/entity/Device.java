
package com.clps.bj.mms.bm.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * 
 * @ClassName: Device
 * @Description: 设备管理功能中操作的Java组件
 * @author userdwt
 * @date 2018年1月7日 下午8:38:23
 *
 */
@Entity
@Table(name = "device")
public class Device implements Serializable {

	private static final long serialVersionUID = 1L;

	
	private Integer deviceId;    		//设备id,auto_increment

	private String deviceNumber;		//设备编号

	private String deviceName;			//设备名称

	private Integer deviceStatus;		//设备状态

	private String deviceDescription;	//对设备的描述

	private Integer deviceUserId;		//设备管理人id

	private Integer deviceRoomId;		//会议室编号

	private String deviceCreated;		//设备入库时间

	private Integer deviceCreatedUserId;//创建设备的人员
	
	private String deviceUpdated;		//修改设备时间
	
	private Integer deviceUpdatedUserId;//修改设备的人员
	
	private String deviceDefault1;		//填充字段
	
	private String deviceDefault2;		//填充字段
	
	private DeviceCategory deviceCategory;//所属设备类目

	public Device() {
		super();
	}



	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="device_id")
	public Integer getDeviceId() {
		return deviceId;
	}

	public void setDeviceId(Integer deviceId) {
		this.deviceId = deviceId;
	}

	@Column(name="device_number")
	public String getDeviceNumber() {
		return deviceNumber;
	}

	public void setDeviceNumber(String deviceNumber) {
		this.deviceNumber = deviceNumber;
	}

	@Column(name="device_description")
	public String getDeviceDescription() {
		return deviceDescription;
	}

	public void setDeviceDescription(String deviceDescription) {
		this.deviceDescription = deviceDescription;
	}

	@Column(name="device_name")
	public String getDeviceName() {
		return deviceName;
	}

	public void setDeviceName(String deviceName) {
		this.deviceName = deviceName == null ? null : deviceName.trim();
	}


	@Column(name="device_status")
	public Integer getDeviceStatus() {
		return deviceStatus;
	}

	public void setDeviceStatus(Integer deviceStatus) {
		this.deviceStatus = deviceStatus;
	}

	

	@Column(name="device_user_id")
	public Integer getDeviceUserId() {
		return deviceUserId;
	}

	public void setDeviceUserId(Integer deviceUserId) {
		this.deviceUserId = deviceUserId;
	}

	@Column(name="device_room_id")
	public Integer getDeviceRoomId() {
		return deviceRoomId;
	}

	public void setDeviceRoomId(Integer deviceRoomId) {
		this.deviceRoomId = deviceRoomId;
	}

	@Column(name="device_created")
	public String getDeviceCreated() {
		return deviceCreated;
	}

	public void setDeviceCreated(String deviceCreated) {
		this.deviceCreated = deviceCreated == null ? null : deviceCreated.trim();
	}

	@Column(name="device_created_name")
	public Integer getDeviceCreatedUserId() {
		return deviceCreatedUserId;
	}

	public void setDeviceCreatedUserId(Integer deviceCreatedUserId) {
		this.deviceCreatedUserId = deviceCreatedUserId;
	}

	@Column(name="device_updated")
	public String getDeviceUpdated() {
		return deviceUpdated;
	}

	public void setDeviceUpdated(String deviceUpdated) {
		this.deviceUpdated = deviceUpdated == null ? null : deviceUpdated.trim();
	}

	@Column(name="device_updated_name")
	public Integer getDeviceUpdatedUserId() {
		return deviceUpdatedUserId;
	}

	public void setDeviceUpdatedUserId(Integer deviceUpdatedUserId) {
		this.deviceUpdatedUserId = deviceUpdatedUserId;
	}

	@Column(name="device_default1")
	public String getDeviceDefault1() {
		return deviceDefault1;
	}

	public void setDeviceDefault1(String deviceDefault1) {
		this.deviceDefault1 = deviceDefault1 == null ? null : deviceDefault1.trim();
	}

	@Column(name="device_default2")
	public String getDeviceDefault2() {
		return deviceDefault2;
	}

	public void setDeviceDefault2(String deviceDefault2) {
		this.deviceDefault2 = deviceDefault2 == null ? null : deviceDefault2.trim();
	}

	@ManyToOne(targetEntity=DeviceCategory.class,fetch=FetchType.EAGER )
	@JoinColumn(name="device_cid")
	public DeviceCategory getDeviceCategory() {
		return deviceCategory;
	}

	public void setDeviceCategory(DeviceCategory deviceCategory) {
		this.deviceCategory = deviceCategory;
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((deviceCategory == null) ? 0 : deviceCategory.hashCode());
		result = prime * result + ((deviceCreated == null) ? 0 : deviceCreated.hashCode());
		result = prime * result + ((deviceCreatedUserId == null) ? 0 : deviceCreatedUserId.hashCode());
		result = prime * result + ((deviceDefault1 == null) ? 0 : deviceDefault1.hashCode());
		result = prime * result + ((deviceDefault2 == null) ? 0 : deviceDefault2.hashCode());
		result = prime * result + ((deviceDescription == null) ? 0 : deviceDescription.hashCode());
		result = prime * result + ((deviceId == null) ? 0 : deviceId.hashCode());
		result = prime * result + ((deviceName == null) ? 0 : deviceName.hashCode());
		result = prime * result + ((deviceNumber == null) ? 0 : deviceNumber.hashCode());
		result = prime * result + ((deviceRoomId == null) ? 0 : deviceRoomId.hashCode());
		result = prime * result + ((deviceStatus == null) ? 0 : deviceStatus.hashCode());
		result = prime * result + ((deviceUpdated == null) ? 0 : deviceUpdated.hashCode());
		result = prime * result + ((deviceUpdatedUserId == null) ? 0 : deviceUpdatedUserId.hashCode());
		result = prime * result + ((deviceUserId == null) ? 0 : deviceUserId.hashCode());
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
		Device other = (Device) obj;
		if (deviceCategory == null) {
			if (other.deviceCategory != null)
				return false;
		} else if (!deviceCategory.equals(other.deviceCategory))
			return false;
		if (deviceCreated == null) {
			if (other.deviceCreated != null)
				return false;
		} else if (!deviceCreated.equals(other.deviceCreated))
			return false;
		if (deviceCreatedUserId == null) {
			if (other.deviceCreatedUserId != null)
				return false;
		} else if (!deviceCreatedUserId.equals(other.deviceCreatedUserId))
			return false;
		if (deviceDefault1 == null) {
			if (other.deviceDefault1 != null)
				return false;
		} else if (!deviceDefault1.equals(other.deviceDefault1))
			return false;
		if (deviceDefault2 == null) {
			if (other.deviceDefault2 != null)
				return false;
		} else if (!deviceDefault2.equals(other.deviceDefault2))
			return false;
		if (deviceDescription == null) {
			if (other.deviceDescription != null)
				return false;
		} else if (!deviceDescription.equals(other.deviceDescription))
			return false;
		if (deviceId == null) {
			if (other.deviceId != null)
				return false;
		} else if (!deviceId.equals(other.deviceId))
			return false;
		if (deviceName == null) {
			if (other.deviceName != null)
				return false;
		} else if (!deviceName.equals(other.deviceName))
			return false;
		if (deviceNumber == null) {
			if (other.deviceNumber != null)
				return false;
		} else if (!deviceNumber.equals(other.deviceNumber))
			return false;
		if (deviceRoomId == null) {
			if (other.deviceRoomId != null)
				return false;
		} else if (!deviceRoomId.equals(other.deviceRoomId))
			return false;
		if (deviceStatus == null) {
			if (other.deviceStatus != null)
				return false;
		} else if (!deviceStatus.equals(other.deviceStatus))
			return false;
		if (deviceUpdated == null) {
			if (other.deviceUpdated != null)
				return false;
		} else if (!deviceUpdated.equals(other.deviceUpdated))
			return false;
		if (deviceUpdatedUserId == null) {
			if (other.deviceUpdatedUserId != null)
				return false;
		} else if (!deviceUpdatedUserId.equals(other.deviceUpdatedUserId))
			return false;
		if (deviceUserId == null) {
			if (other.deviceUserId != null)
				return false;
		} else if (!deviceUserId.equals(other.deviceUserId))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Device [deviceId=" + deviceId + ", deviceNumber=" + deviceNumber + ", deviceName=" + deviceName
				+ ", deviceStatus=" + deviceStatus + ", deviceDescription=" + deviceDescription + ", deviceUserId="
				+ deviceUserId + ", deviceRoomId=" + deviceRoomId + ", deviceCreated=" + deviceCreated
				+ ", deviceCreatedUserId=" + deviceCreatedUserId + ", deviceUpdated=" + deviceUpdated
				+ ", deviceUpdatedUserId=" + deviceUpdatedUserId + ", deviceDefault1=" + deviceDefault1
				+ ", deviceDefault2=" + deviceDefault2 + ", deviceCategory=" + deviceCategory + "]";
	}
	

}