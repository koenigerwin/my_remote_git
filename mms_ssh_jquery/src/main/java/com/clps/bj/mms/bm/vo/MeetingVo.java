package com.clps.bj.mms.bm.vo;

/**
 * @Description: 会议的扩展类
 * @author candy 
 * MeetingVo 
 * 2018年1月24日 下午5:12:21
 * @version V1.0
 */
public class MeetingVo {
	private Integer meetingId;
	private String meetingTitle;
	private String meetingBegintime;
	private String meetingEndtime;
	private String meetingContent;
	private String meetingCreateDatetime;
	private Integer meetingCreateName;
	private Integer meetingStatus;
	
	//private Meeting meeting;
	private Integer roomId; // 会议室ID
	private String roomName; // 会议室名字
	// private Integer roomSize; // 会议室容纳人数
	private String roomIsEnable; // 会议室状态
	private Integer userId; // 用户id
	private String userName; // '用户真实姓名'
	private String meetingUserIds;
   

	private String meetingUserNames;
	public MeetingVo() {
		super();
	}

	public MeetingVo(Object[] obj) {
		this.meetingId = (Integer) obj[0];
		this.meetingTitle = (String) obj[1];
		this.meetingBegintime = (String)obj[2];
		this.meetingEndtime = (String) obj[3];
		this.meetingContent = (String) obj[4];
		this.meetingCreateDatetime = (String) obj[5];
		this.meetingCreateName = (Integer) obj[6];
		this.meetingStatus = (Integer) obj[7];	
		this.roomId = (Integer) obj[8];
		this.roomName = (String) obj[9];
		this.roomIsEnable = (String) obj[10];
		this.userId = (Integer) obj[11];
		this.userName = (String) obj[12];
	}

	

	

	

	public MeetingVo(Integer meetingId, String meetingTitle, String meetingBegintime, String meetingEndtime,
			String meetingContent, String meetingCreateDatetime, Integer meetingCreateName, Integer meetingStatus,
			Integer roomId, String roomName, String roomIsEnable, Integer userId, String userName) {
		super();
		this.meetingId = meetingId;
		this.meetingTitle = meetingTitle;
		this.meetingBegintime = meetingBegintime;
		this.meetingEndtime = meetingEndtime;
		this.meetingContent = meetingContent;
		this.meetingCreateDatetime = meetingCreateDatetime;
		this.meetingCreateName = meetingCreateName;
		this.meetingStatus = meetingStatus;
		this.roomId = roomId;
		this.roomName = roomName;
		this.roomIsEnable = roomIsEnable;
		this.userId = userId;
		this.userName = userName;
	}
	
	 public String getMeetingUserIds() {
			return meetingUserIds;
		}

		public void setMeetingUserIds(String meetingUserIds) {
			this.meetingUserIds = meetingUserIds;
		}

		public String getMeetingUserNames() {
			return meetingUserNames;
		}

		public void setMeetingUserNames(String meetingUserNames) {
			this.meetingUserNames = meetingUserNames;
		}
	public Integer getRoomId() {
		return roomId;
	}

	public void setRoomId(Integer roomId) {
		this.roomId = roomId;
	}

	public String getRoomName() {
		return roomName;
	}

	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}

	public String getRoomIsEnable() {
		return roomIsEnable;
	}

	public void setRoomIsEnable(String roomIsEnable) {
		this.roomIsEnable = roomIsEnable;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Integer getMeetingId() {
		return meetingId;
	}

	public void setMeetingId(Integer meetingId) {
		this.meetingId = meetingId;
	}

	public String getMeetingTitle() {
		return meetingTitle;
	}

	public void setMeetingTitle(String meetingTitle) {
		this.meetingTitle = meetingTitle;
	}

	
	public String getMeetingBegintime() {
		return meetingBegintime;
	}

	public void setMeetingBegintime(String meetingBegintime) {
		this.meetingBegintime = meetingBegintime;
	}

	public String getMeetingEndtime() {
		return meetingEndtime;
	}

	public void setMeetingEndtime(String meetingEndtime) {
		this.meetingEndtime = meetingEndtime;
	}

	public String getMeetingCreateDatetime() {
		return meetingCreateDatetime;
	}

	public void setMeetingCreateDatetime(String meetingCreateDatetime) {
		this.meetingCreateDatetime = meetingCreateDatetime;
	}

	public String getMeetingContent() {
		return meetingContent;
	}

	public void setMeetingContent(String meetingContent) {
		this.meetingContent = meetingContent;
	}

	
	public Integer getMeetingCreateName() {
		return meetingCreateName;
	}

	public void setMeetingCreateName(Integer meetingCreateName) {
		this.meetingCreateName = meetingCreateName;
	}

	public Integer getMeetingStatus() {
		return meetingStatus;
	}

	public void setMeetingStatus(Integer meetingStatus) {
		this.meetingStatus = meetingStatus;
	}

	@Override
	public String toString() {
		return "MeetingVo [meetingId=" + meetingId + ", meetingTitle=" + meetingTitle + ", meetingBegintime="
				+ meetingBegintime + ", meetingEndtime=" + meetingEndtime + ", meetingContent=" + meetingContent
				+ ", meetingCreateDatetime=" + meetingCreateDatetime + ", meetingCreateName=" + meetingCreateName
				+ ", meetingStatus=" + meetingStatus + ", roomId=" + roomId + ", roomName=" + roomName
				+ ", roomIsEnable=" + roomIsEnable + ", userId=" + userId + ", userName=" + userName
				+ ", meetingUserIds=" + meetingUserIds + ", meetingUserNames=" + meetingUserNames + "]";
	}

	

	

	
}
