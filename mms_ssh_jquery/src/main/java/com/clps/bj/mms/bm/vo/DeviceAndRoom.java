/**   
* @Title: DeviceAndRoom.java 
* @Package com.clps.bj.mms.bm.vo 
* @Description: (用一句话描述该文件做什么) 
* @author userdwt  
* @date 2018年2月4日 下午4:55:30 
* @version V1.0   
*/
package com.clps.bj.mms.bm.vo;

import java.io.Serializable;

/** 
* @ClassName: DeviceAndRoom 
* @Description: (这里用一句话描述这个类的作用) 
* @author userdwt
* @date 2018年2月4日 下午4:55:30 
*  
*/
public class DeviceAndRoom implements Serializable {
	
	/** 
	* @Fields serialVersionUID : 
	*/ 
	private static final long serialVersionUID = 7753567748715359747L;

	private String userName; // '用户真实姓名'
	
	private String roomName; 		// 会议室名字

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getRoomName() {
		return roomName;
	}

	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}

	@Override
	public String toString() {
		return "DeviceAndRoom [userName=" + userName + ", roomName=" + roomName + "]";
	}
	
	

}
