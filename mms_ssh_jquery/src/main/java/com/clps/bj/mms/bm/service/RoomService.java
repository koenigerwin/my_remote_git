
package com.clps.bj.mms.bm.service;

import com.clps.bj.mms.bm.entity.Room;

import antlr.collections.List;

/**
 * @description:
 * @className:RoomService.java
 * @author:Ian
 * @version:V1.0.0
 * @date:2018年1月26日上午11:22:41
 */
public interface RoomService {
	/**
	 * @description 根据ID获得会议室信息
	 * @param roomId
	 * @return Room
	 */
	public Room getRoomById(Integer roomId);
	    /**
	    * @description 新增会议室信息
	    * @param room
	    * @return Room 返回 
		*/
	public void addRoom(Room room);
	public Room deletedRoom(Integer roomId);
	public Room updateRoom(Room room);
	public List getAllRoom();
	
}
