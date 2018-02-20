package com.clps.bj.mms.bm.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

/**
 * @description:Room实体类
 * @className:Room.java
 * @author:Ian
 * @version:V1.0.0
 * @date:2018年1月23日下午3:29:10
 */
@Entity
@Table(name = "room")
public class Room implements Serializable {

	/**  
	 * serialVersionUID:序列化id
	 * @since JDK 1.9 
	 */
	private static final long serialVersionUID = 1L;
	private Integer roomId;			// 会议室ID
	private String roomName; 		// 会议室名字
	private Integer roomSize;		// 会议室容纳人数
	private String roomIsEnable;	// 会议室状态
	private String roomDescription;	// 会议室描述
	private String roomCreateTime;	// 会议室创建时间
	private String roomCreateName;	// 会议室创建人名
	private String roomUpdateTime;	// 会议室修改时间
	private String roomUpdateName;	// 会议室修改人名
	private String roomLocation;	// 会议室地址
	private String roomDefault1;	// 默认字段1
	private String roomDefault2;	// 默认字段2

	private Set<Meeting> meetings = new HashSet<>();
	/**
	 * 无参构造	
	 */
	public Room() {
		super();
	}

	public Room(Object [] obj) {
		this.roomId=(Integer) obj[0];
		this.roomName=(String) obj[1];
	}

	/**
	 * @return the roomId
	 */
	@Id
	@GeneratedValue
	@Column(name="room_id")
	public Integer getroomId() {
		return roomId;
	}

	/**
	 * @param roomId
	 *            the roomId to set
	 */
	public void setroomId(Integer roomId) {
		this.roomId = roomId;
	}

	/**
	 * @return the roomName
	 */
	@Column(name="room_name")
	public String getroomName() {
		return roomName;
	}

	/**
	 * @param roomName
	 *            the roomName to set
	 */
	public void setroomName(String roomName) {
		this.roomName = roomName;
	}

	/**
	 * @return the roomSize
	 */
	@Column(name="room_size")
	public Integer getroomSize() {
		return roomSize;
	}

	/**
	 * @param roomSize
	 *            the roomSize to set
	 */
	public void setroomSize(Integer roomSize) {
		this.roomSize = roomSize;
	}

	/**
	 * @return the roomIsEnable
	 */
	@Column(name="room_is_enable")
	public String getroomIsEnable() {
		return roomIsEnable;
	}

	/**
	 * @param roomIsEnable
	 *            the roomIsEnable to set
	 */
	public void setroomIsEnable(String roomIsEnable) {
		this.roomIsEnable = roomIsEnable;
	}

	/**
	 * @return the roomDescription
	 */
	@Column(name="room_describtion")
	public String getroomDescription() {
		return roomDescription;
	}

	/**
	 * @param roomDescription
	 *            the roomDescription to set
	 */
	public void setroomDescription(String roomDescription) {
		this.roomDescription = roomDescription;
	}

	/**
	 * @return the roomCreateTime
	 */
	@Column(name="room_create_time")
	public String getroomCreateTime() {
		return roomCreateTime;
	}

	/**
	 * @param roomCreateTime
	 *            the roomCreateTime to set
	 */
	public void setroomCreateTime(String roomCreateTime) {
		this.roomCreateTime = roomCreateTime;
	}

	/**
	 * @return the roomCreateName
	 */
	@Column(name="room_create_name")
	public String getroomCreateName() {
		return roomCreateName;
	}

	/**
	 * @param roomCreateName
	 *            the roomCreateName to set
	 */
	public void setroomCreateName(String roomCreateName) {
		this.roomCreateName = roomCreateName;
	}

	/**
	 * @return the roomUpdateTime
	 */
	@Column(name="room_update_time")
	public String getroomUpdateTime() {
		return roomUpdateTime;
	}

	/**
	 * @param roomUpdateTime
	 *            the roomUpdateTime to set
	 */
	public void setroomUpdateTime(String roomUpdateTime) {
		this.roomUpdateTime = roomUpdateTime;
	}

	/**
	 * @return the roomUpdateName
	 */
	@Column(name="room_update_name")
	public String getroomUpdateName() {
		return roomUpdateName;
	}

	/**
	 * @param roomUpdateName
	 *            the roomUpdateName to set
	 */
	public void setroomUpdateName(String roomUpdateName) {
		this.roomUpdateName = roomUpdateName;
	}

	/**
	 * @return the roomDefault1
	 */
	@Column(name="room_defalut1")
	public String getroomDefault1() {
		return roomDefault1;
	}

	/**
	 * @param roomDefault1
	 *            the roomDefault1 to set
	 */
	public void setroomDefault1(String roomDefault1) {
		this.roomDefault1 = roomDefault1;
	}

	/**
	 * @return the roomDefault2
	 */
	@Column(name="room_defalut2")
	public String getroomDefault2() {
		return roomDefault2;
	}

	/**
	 * @param roomDefault2
	 *            the roomDefault2 to set
	 */
	public void setroomDefault2(String roomDefault2) {
		this.roomDefault2 = roomDefault2;
	}
	
    @OneToMany(mappedBy="room")
	@LazyCollection(LazyCollectionOption.EXTRA)
    
	public Set<Meeting> getMeetings() {
		return meetings;
	}

	public void setMeetings(Set<Meeting> meetings) {
		this.meetings = meetings;
	}

	public Room(Integer roomId, String roomName, Integer roomSize, String roomIsEnable, String roomDescription,
			String roomCreateTime, String roomCreateName, String roomUpdateTime, String roomUpdateName,
			String roomDefault1, String roomDefault2, String roomLocation) {
		super();
		this.roomId = roomId;
		this.roomName = roomName;
		this.roomSize = roomSize;
		this.roomIsEnable = roomIsEnable;
		this.roomDescription = roomDescription;
		this.roomCreateName = roomCreateName;
		this.roomCreateTime = roomCreateTime;
		this.roomUpdateName = roomUpdateName;
		this.roomUpdateTime = roomUpdateTime;
		this.roomDefault1 = roomDefault1;
		this.roomDefault2 = roomDefault2;
		this.roomLocation = roomLocation;
	}


}
