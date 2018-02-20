package com.clps.bj.mms.bm.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clps.bj.mms.bm.dao.MeetingUserDao;
import com.clps.bj.mms.bm.entity.MeetingUser;
import com.clps.bj.mms.bm.service.IMeetingUserService;
import com.clps.bj.mms.bm.vo.MeetingUserVo;
/**
 *@Description:会议用户中间表的业务实现类
 * @author candy
 * MeetingUserService
 * 2018年2月2日 上午9:08:02
 *@version V1.0
 */
@Service
public class MeetingUserServiceImpl implements IMeetingUserService {
@Autowired
MeetingUserDao meetinguserdao;
	@Override
	public Map<String,String> meetingUserList(Integer meetingId) {
		List<MeetingUserVo> mList=meetinguserdao.meetingUserList(meetingId);
		String meetingUserIds="";
		String meetingUserNames="";
		System.out.println(mList.size());
		Map<String,String> meetingUserMap=new HashMap<String,String>();
		for(MeetingUserVo mu:mList){
			meetingUserIds+=mu.getUserId();
			meetingUserIds+=";";
			meetingUserNames+=mu.getUserName();
			meetingUserNames+=";";	
		}
		//key存userids,value存usernames	
		meetingUserMap.put(meetingUserIds, meetingUserNames);
		return meetingUserMap;

	}
	@Override
	public boolean addMeetingUser(MeetingUser meetinguser) {
	return meetinguserdao.addMeetingUser(meetinguser);
	}
	@Override
	public boolean delMeetingUser(MeetingUser meetinguser) {
		return meetinguserdao.delMeetingUser(meetinguser);
	}
	@Override
	public boolean delMeetingUser(Integer meetingId) {	
		return meetinguserdao.delMeetingUser(meetingId);
	}


}
