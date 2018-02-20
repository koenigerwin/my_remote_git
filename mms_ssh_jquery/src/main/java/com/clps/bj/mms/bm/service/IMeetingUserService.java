package com.clps.bj.mms.bm.service;

import java.util.List;
import java.util.Map;

import com.clps.bj.mms.bm.entity.MeetingUser;
import com.clps.bj.mms.bm.vo.MeetingUserVo;

/**
 *@Description: 会议用户中间表的业务层接口
 * @author candy
 * IMeetingUserService
 * 2018年2月2日 上午9:06:31
 *@version V1.0
 */
public interface IMeetingUserService {
	/**
	 * Decription:根据会议的id查询会议参与者
	 * meetingUserList
	 * 2018年2月2日 下午2:16:19
	 * @param meetingId
	 * @return Map<String,String>  key存userids,value存usernames
	 */
	Map<String,String> meetingUserList(Integer meetingId);
	/**
	 * Decription:添加会议参与者
	 * addMeetingUser
	 * 2018年2月6日 上午11:26:32
	 * @param meetinguser
	 * @return boolean
	 */
	boolean addMeetingUser(MeetingUser meetinguser);
	/**
	 * Decription:删除会议参与者
	 * delMeetingUser
	 * 2018年2月6日 上午11:34:51
	 * @param meetinguser
	 * @return boolean
	 */
	boolean delMeetingUser(MeetingUser meetinguser);
	/**
	 * Decription:根据会议的id删除会议参与者
	 * delMeetingUser
	 * 2018年2月7日 下午1:55:35
	 * @param meetingId
	 * @return boolean
	 */
	boolean delMeetingUser(Integer meetingId);
}
