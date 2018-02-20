package com.clps.bj.mms.bm.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.clps.bj.mms.sm.entity.UserInfoMain;

/**
 * 
 * @Description: 用户与会议之间的关系表
 * @author candy 
 * MeetingUser 
 * 2018年1月23日 上午10:25:29
 * @version V1.0
 */
@Entity
@Table(name = "meeting_user")
public class MeetingUser {
	private Integer meetingUserId;// 用户会议中间表id
	private Meeting meeting;// 会议外键
	private UserInfoMain userinfo;// 会议室外键

	public MeetingUser() {
		super();
	}
  
	@Id
	@GeneratedValue
	@Column(name="meeting_user_id")
	public Integer getMeetingUserId() {
		return meetingUserId;
	}

	public MeetingUser(Integer meetingUserId, Meeting meeting, UserInfoMain userinfo) {
		super();
		this.meetingUserId = meetingUserId;
		this.meeting = meeting;
		this.userinfo = userinfo;
	}

	public void setMeetingUserId(Integer meetingUserId) {
		this.meetingUserId = meetingUserId;
	}

	@ManyToOne(optional=false)//表示内连接
	@JoinColumn(name = "meeting_id")
	public Meeting getMeeting() {
		return meeting;
	}

	public void setMeeting(Meeting meeting) {
		this.meeting = meeting;
	}

	@ManyToOne
	@JoinColumn(name = "user_id")
	public UserInfoMain getUserinfo() {
		return userinfo;
	}

	public void setUserinfo(UserInfoMain userinfo) {
		this.userinfo = userinfo;
	}

	@Override
	public String toString() {
		return "MeetingUser [meetingUserId=" + meetingUserId + ", meeting=" + meeting + ", userinfo=" + userinfo
				+ "]";
	}

	

}
