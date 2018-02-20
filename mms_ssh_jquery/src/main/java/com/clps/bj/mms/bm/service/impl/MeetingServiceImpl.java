package com.clps.bj.mms.bm.service.impl;


import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.clps.bj.mms.bm.constant.MeetingStatusType;
import com.clps.bj.mms.bm.dao.MeetingDao;
import com.clps.bj.mms.bm.entity.Meeting;
import com.clps.bj.mms.bm.entity.MeetingUser;
import com.clps.bj.mms.bm.entity.Room;
import com.clps.bj.mms.bm.service.IMeetingService;
import com.clps.bj.mms.bm.vo.MeetingVo;
import com.clps.bj.mms.sm.entity.UserInfoMain;

/**
 * @Description: meeting业务接口的实现类
 * @author candy 
 * MeetingServiceImpl 
 * 2018年1月22日 下午3:31:58
 * @version V1.0
 */
@Service
public class MeetingServiceImpl implements IMeetingService {
	Logger logger=Logger.getLogger(Meeting.class);
	@Autowired
	MeetingDao meetingdao;

	@Override
	public boolean addMeeting(Meeting meeting) {  
		Room room=meetingdao.getRoomById(meeting.getRoom().getroomId());
		meeting.setRoom(room);
		UserInfoMain userinfo=meetingdao.getUserInfoMainById(meeting.getUserinfo().getUserId());
		meeting.setUserinfo(userinfo);
		if(meeting.getMeetingStatus()==null){
			meeting.setMeetingStatus(MeetingStatusType.NOEND.getId());
		}
	
		if(meeting.getRoom().getroomIsEnable().equals("1")){
			logger.info("添加成功");
			return meetingdao.addMeeting(meeting);	
		}
		logger.info("添加失败");
		return false;
	}

	@Override
	public boolean updateMeeting(Meeting meeting) {
		Room room=meetingdao.getRoomById(meeting.getRoom().getroomId());
		meeting.setRoom(room);
		UserInfoMain userinfo=meetingdao.getUserInfoMainById(meeting.getUserinfo().getUserId());
		meeting.setUserinfo(userinfo);
		if(meeting.getMeetingStatus()==null){
			meeting.setMeetingStatus(MeetingStatusType.NOEND.getId());
		}
		if(room.getroomIsEnable().equals("1")){
			logger.info("修改成功！！");
			return meetingdao.updateMeeting(meeting);
		}
		logger.info("修改失败！！");
		return false;
	}

	@Override
	public boolean deleteMeeting(Meeting meeting) {
		if(meeting!=null){
		if (meeting.getMeetingStatus() == 0) {// 已结束
			logger.info("删除失败！！");
			return false;
		} else {
			logger.info("删除成功！！");
			return meetingdao.deleteMeeting(meeting);
		}
		}
		return false;
	}
	@Override
	public List<MeetingVo> getMeeting(MeetingVo meetingVo) {
		Meeting meeting=new Meeting();
		meeting.setMeetingTitle(meetingVo.getMeetingTitle());
		meeting.setMeetingBegintime(meetingVo.getMeetingBegintime());
		meeting.setMeetingEndtime(meetingVo.getMeetingEndtime());
		meeting.setMeetingContent(meetingVo.getMeetingContent());
		meeting.setMeetingCreateDatetime(meetingVo.getMeetingCreateDatetime());
		meeting.setMeetingCreateName(meetingVo.getMeetingCreateName());
		meeting.setMeetingStatus(meetingVo.getMeetingStatus());
		Room room=new Room();
		room.setroomId(meetingVo.getRoomId());
		room.setroomName(meetingVo.getRoomName());
		meeting.setRoom(room);
		UserInfoMain userinfo=new UserInfoMain();
		userinfo.setUserId(meetingVo.getUserId());
		userinfo.setUserName(meetingVo.getUserName());
		meeting.setUserinfo(userinfo);
		
		List<MeetingVo> meetingList=meetingdao.getMeeting(meeting);
//		for(MeetingVo m:meetingList){
//			List<String> liststr=meetingUserList(m.getMeetingId());
//			m.setMeetingUserIds(liststr.get(0));
//			m.setMeetingUserNames(liststr.get(1));
//		}
		return meetingList;
	}

	@Override
	public Long getMeetingCount(MeetingVo meetingVo) {
		Meeting meeting=new Meeting();
		meeting.setMeetingTitle(meetingVo.getMeetingTitle());
		meeting.setMeetingBegintime(meetingVo.getMeetingContent());
		meeting.setMeetingEndtime(meetingVo.getMeetingEndtime());
		meeting.setMeetingContent(meetingVo.getMeetingContent());
		meeting.setMeetingCreateDatetime(meetingVo.getMeetingCreateDatetime());
		meeting.setMeetingCreateName(meetingVo.getMeetingCreateName());
		meeting.setMeetingStatus(meetingVo.getMeetingStatus());
		Room room=new Room();
		room.setroomId(meetingVo.getRoomId());
		room.setroomName(meetingVo.getRoomName());
		meeting.setRoom(room);
		UserInfoMain userinfo=new UserInfoMain();
		userinfo.setUserId(meetingVo.getUserId());
		userinfo.setUserName(meetingVo.getUserName());
		meeting.setUserinfo(userinfo);
		return meetingdao.getMeetingCount(meeting);
	}
	
	@Override
	public List<Meeting> getMyMeeting(String nowuser) {
		return null;
	}

	@Override
	public List<String> listEndTime() {
	return meetingdao.getEndTime();
	}

	@Override
	public Meeting getMeetingByID(Integer meetingId) {
		return meetingdao.getMeetingByID(meetingId);
	}
	
	@Override
	public List<MeetingVo> getMeetingByMonth(String yearMonth,Integer userId) {		
		return meetingdao.getMeetingByMonth(yearMonth,userId);
	}

	@Override
	public Room getRoomById(Integer roomId) {
		return meetingdao.getRoomById(roomId);
	}

	@Override
	public UserInfoMain getUserInfoMainById(Integer userId) {
		return meetingdao.getUserInfoMainById(userId);
	}

	@Override
	public List<Room> getRoomList() {
		return meetingdao.getRoomList();
	}

	@Override
	public List<UserInfoMain> getUserList() {
		return meetingdao.getUserList();
	}

	
	

	
	

	
}
