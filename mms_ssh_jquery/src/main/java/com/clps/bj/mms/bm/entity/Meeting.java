package com.clps.bj.mms.bm.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import com.clps.bj.mms.bm.constant.MeetingStatusType;
import com.clps.bj.mms.sm.entity.UserInfoMain;

/**
 * @Description: Meeting实体类
 * @author candy 
 * Meeting 
 * 2018年1月23日 下午12:05:39
 * @version V1.0
 */

@SuppressWarnings("serial")
@Entity
@Table(name = "meeting")
public class Meeting implements Serializable {
	private Integer meetingId;// 会议id
	private String meetingTitle;// 会议标题
	private Set<MeetingUser> mu = new HashSet<>();// 会议参与者
	private String meetingContent;// 会议内容
	private String meetingBegintime;// 会议开始时间
	private String meetingEndtime;// 会议结束时间
	private UserInfoMain userinfo;// 会议负责人
	private Room room;// 所在会议室
	private Integer meetingStatus;// 会议状态(0--已结束 1--未结束，默认1)常量
	private MeetingStatusType meetingStatusType;// 会议状态(0--已结束 1--未结束，默认1)
	private String meetingCreateDatetime;// 创建时间
	private Integer meetingCreateName;// 创建人名,取到的是session中用户的id
	private String meetingUpdateDatetime;// 修改时间
	private String meetingUpdateName;// 修改人名

	public Meeting() {
		super();
	}
	public Meeting(Object[] obj) {
		this.meetingId = (Integer) obj[0];
		this.meetingTitle =(String) obj[1];		
		this.meetingBegintime = (String) obj[2];
		this.meetingEndtime = (String) obj[3];
		this.meetingContent = (String) obj[4];
		this.meetingCreateDatetime = (String) obj[5];
		this.meetingCreateName = (Integer) obj[6];
		this.meetingStatus = (Integer) obj[7];
	}

	public Meeting(Integer meetingId, String meetingTitle, Set<MeetingUser> mu, String meetingContent,
			String meetingBegintime, String meetingEndtime, UserInfoMain userinfo, Room room, 
			Integer meetingStatus,  MeetingStatusType meetingStatusType,
			String meetingCreateDatetime, Integer meetingCreateName, String meetingUpdateDatetime,
			String meetingUpdateName) {
		super();
		this.meetingId = meetingId;
		this.meetingTitle = meetingTitle;
		this.mu = mu;
		this.meetingContent = meetingContent;
		this.meetingBegintime = meetingBegintime;
		this.meetingEndtime = meetingEndtime;
		this.userinfo = userinfo;
		this.room = room;	
		this.meetingStatus = meetingStatus;
		this.meetingStatusType = meetingStatusType;
		this.meetingCreateDatetime = meetingCreateDatetime;
		this.meetingCreateName = meetingCreateName;
		this.meetingUpdateDatetime = meetingUpdateDatetime;
		this.meetingUpdateName = meetingUpdateName;
	}


	/**
	 * @return Integer
	 */
	@Id
	@GenericGenerator(name = "generator", strategy = "increment") // 设置主键自增
	@GeneratedValue(generator = "generator")
	@Column(name = "meeting_id",length=11,nullable=false)
	public Integer getMeetingId() {
		return meetingId;
	}
	/**
	 * @param meetingId void
	 */
	public void setMeetingId(Integer meetingId) {
		this.meetingId = meetingId;
	}
	/**
	 * @return String
	 */
	@Column(name = "meeting_title",length=50,nullable=false)
	public String getMeetingTitle() {
		return meetingTitle;
	}
	/**
	 * @param meetingTitle void
	 */
	public void setMeetingTitle(String meetingTitle) {
		this.meetingTitle = meetingTitle;
	}
	/**
	 * @return String
	 */
	@Column(name = "meeting_content",length=1000,nullable=true)
	public String getMeetingContent() {
		return meetingContent;
	}
	/**
	 * @param meetingContent void
	 */
	public void setMeetingContent(String meetingContent) {
		this.meetingContent = meetingContent;
	}
	/**
	 * @return String
	 */
	@Column(name = "meeting_begintime",length=50,nullable=false)
	public String getMeetingBegintime() {
		return meetingBegintime;
	}
	/**
	 * @param meetingBegintime void
	 */
	public void setMeetingBegintime(String meetingBegintime) {
		this.meetingBegintime = meetingBegintime;
	}
	/**
	 * @return String
	 */
	@Column(name = "meeting_endtime",length=50,nullable=false)
	public String getMeetingEndtime() {
		return meetingEndtime;
	}
	/**
	 * @param meetingEndtime void
	 */
	public void setMeetingEndtime(String meetingEndtime) {
		this.meetingEndtime = meetingEndtime;
	}
	/**
	 * @return UserInfoMain
	 */
	@ManyToOne(targetEntity = UserInfoMain.class, fetch = FetchType.LAZY)
	@JoinColumn(name = "meeting_user_id",nullable=false)
	public UserInfoMain getUserinfo() {
		return userinfo;
	}
	/**
	 * @param userinfo void
	 */
	public void setUserinfo(UserInfoMain userinfo) {
		this.userinfo = userinfo;
	}
	/**
	 * @return Room
	 */
	@ManyToOne(targetEntity = Room.class,fetch = FetchType.LAZY)
	@JoinColumn(name = "meeting_room_id",nullable=false)
	public Room getRoom() {
		return room;
	}
	/**
	 * @return String
	 */
	
    public void setRoom(Room room) {
		this.room = room;
	}
	
	@Column(name = "meeting_status",length=2,nullable=false)
	public Integer getMeetingStatus() {
		return meetingStatus;
	}
	/**
	 * @param meetingStatus void
	 */
	public void setMeetingStatus(Integer meetingStatus) {
		this.meetingStatus = meetingStatus;
	}
	
	public MeetingStatusType getMeetingStatusType() {
		return meetingStatusType;
	}

	public void setMeetingStatusType(MeetingStatusType meetingStatusType) {
		this.meetingStatusType = meetingStatusType;
	}

	/**
	 * @return String
	 */
	@Column(name = "meeting_create_datetime",length=50,nullable=false)
	public String getMeetingCreateDatetime() {
		return meetingCreateDatetime;
	}


	/**
	 * @param meetingCreateDatetime void
	 */
	public void setMeetingCreateDatetime(String meetingCreateDatetime) {
		this.meetingCreateDatetime = meetingCreateDatetime;
	}
	/**
	 * @return Integer
	 */
	@Column(name = "meeting_create_name",length=50,nullable=false)
	public Integer getMeetingCreateName() {
		return meetingCreateName;
	}
	/**
	 * @param meetingCreateName void
	 */
	public void setMeetingCreateName(Integer meetingCreateName) {
		this.meetingCreateName = meetingCreateName;
	}
	/**
	 * @return String
	 */
	@Column(name = "meeting_update_datetime",length=50,nullable=true)
	public String getMeetingUpdateDatetime() {
		return meetingUpdateDatetime;
	}
	/**
	 * @param meetingUpdateDatetime void
	 */
	public void setMeetingUpdateDatetime(String meetingUpdateDatetime) {
		this.meetingUpdateDatetime = meetingUpdateDatetime;
	}
	/**
	 * @return String
	 */
	@Column(name = "meeting_update_name",length=50,nullable=true)
	public String getMeetingUpdateName() {
		return meetingUpdateName;
	}
	/**
	 * @param meetingUpdateName void
	 */
	public void setMeetingUpdateName(String meetingUpdateName) {
		this.meetingUpdateName = meetingUpdateName;
	}
	/**n
	 * @return Set<MeetingUser>
	 */
	@OneToMany(mappedBy = "meeting",cascade=CascadeType.ALL)//级联
	@LazyCollection(LazyCollectionOption.EXTRA)
	public Set<MeetingUser> getMu() {
		return mu;
	}
	/**
	 * @param mu void
	 */
	public void setMu(Set<MeetingUser> mu) {
		this.mu = mu;
	}

	@Override
	public String toString() {
		return "Meeting [meetingId=" + meetingId + ", meetingTitle=" + meetingTitle + ", mu=" + mu + ", meetingContent="
				+ meetingContent + ", meetingBegintime=" + meetingBegintime + ", meetingEndtime=" + meetingEndtime
				+ ", userinfo=" + userinfo + ", room=" + room
				+ ", meetingStatusType=" + meetingStatusType + ", meetingCreateDatetime=" + meetingCreateDatetime
				+ ", meetingCreateName=" + meetingCreateName + ", meetingUpdateDatetime=" + meetingUpdateDatetime
				+ ", meetingUpdateName=" + meetingUpdateName + "]";
	}

	
	
}