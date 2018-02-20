package com.clps.bj.mms.bm.dao;

import java.util.List;

import com.clps.bj.mms.bm.entity.MeetingUser;
import com.clps.bj.mms.bm.vo.MeetingUserVo;


/**
 *@Description: 会议用户的中间表
 * @author candy
 * MeetingUserDao
 * 2018年2月2日 上午9:03:43
 *@version V1.0
 */
public interface MeetingUserDao {
	/**
	 * Decription:根据会议的id查询会议参与者
	 * meetingUserList
	 * 2018年2月1日 下午4:46:29
	 * @param meetingId
	 * @return List<MeetingUser>
	 */
	List<MeetingUserVo> meetingUserList(Integer meetingId);
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
