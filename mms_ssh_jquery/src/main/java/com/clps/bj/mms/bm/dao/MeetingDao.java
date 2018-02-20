package com.clps.bj.mms.bm.dao;

import java.util.List;

import com.clps.bj.mms.bm.entity.Meeting;
import com.clps.bj.mms.bm.entity.MeetingUser;
import com.clps.bj.mms.bm.entity.Room;
import com.clps.bj.mms.bm.vo.MeetingUserVo;
import com.clps.bj.mms.bm.vo.MeetingVo;
import com.clps.bj.mms.sm.entity.UserInfoMain;



	/**
	 * 
	 *@Description: 
	 * @author candy
	 * MeetingDao
	 * 2018年1月24日 上午10:08:27
	 *@version V1.0
	 */
public interface MeetingDao {
	/**
	 * Decription:添加会议
	 * addMeeting
	 * 2018年1月24日 上午10:08:00
	 * @param meeting void
	 */
	boolean addMeeting(Meeting meeting);
	/**
	 * Decription:根据会议的id删除会议
	 * deleteMeeting
	 * 2018年1月24日 上午10:07:28
	 * @param meeting
	 * @return boolean
	 */
	boolean deleteMeeting(Meeting meeting);

	/**
	 * decription:根据会议标题，会议负责人，会议开始时间到结束时间，所在会议室，是否预定成功，是否结束状态模糊查找 查询所有的预定会议
	 * getMeeting
	 * 2018年1月24日 上午9:51:13
	 * @param meeting
	 * @return  List<Meeting>
	 */
	List<MeetingVo> getMeeting(Meeting meeting);
	/**
	 * Decription:查询会议数量
	 * getMeetingCount
	 * 2018年2月1日 上午11:37:19
	 * @param meeting
	 * @return int
	 */
    Long getMeetingCount(Meeting meeting);
	/**
	 * decription:查询我的会议的方法
	 * getMyMeeting  
	 * 2018年1月17日 下午4:08:44
	 * @param meeting_user_ids
	 * @ return List<Meeting>
	 */
	List<Meeting> getMyMeeting(String nowuser);
	/**
	 * decription:根据会议id修改会议信息
	 * updateMeeting
	 * @ return boolean
	 * 2018年1月24日 上午10:00:19
	 * @param meeting
	 * @return
	 */
	boolean updateMeeting(Meeting meeting);
	/**
	 * Decription:取到会议的结束时间
	 * getEndTime
	 * 2018年1月28日 上午8:33:44
	 * @return List<String>
	 */
	List<String> getEndTime();
	/**
	 * Decription:返回Meeting对象
	 * getMeetingByID
	 * 2018年2月2日 上午9:39:13
	 * @param meetingId
	 * @return Meeting
	 */
	Meeting getMeetingByID(Integer meetingId);

	/**
	 * Decription:根据会议日期(年-月)查询会议信息
	 * getMeetingByMonth
	 * 2018年2月5日 上午9:42:07
	 * @param YearMonth
	 * @return List<Meeting>
	 */
	List<MeetingVo> getMeetingByMonth(String yearMonth,Integer userId);
	/**
	 * Decription:根据roomId查询Room的信息
	 * getRoomById
	 * 2018年1月29日 下午12:04:57
	 * @param roomId
	 * @return Room
	 */
	
	Room getRoomById(Integer roomId);
	/**
	 * Decription:根据userId查询UserInfoMain的信息
	 * getUserInfoMainById
	 * 2018年1月29日 下午12:06:22
	 * @param userId
	 * @return UserInfoMain
	 */
	UserInfoMain getUserInfoMainById(Integer userId);
	/**
	 * Decription:查询所有状态为可用会议室的名称与id
	 * getRoomList
	 * 2018年1月30日 上午11:36:54
	 * @return List<Room>
	 */
	List<Room> getRoomList();
	/**
	 * Decription:查询所有负责人
	 * getUserList
	 * 2018年1月30日 上午11:47:57
	 * @return List<UserInfoMain>
	 */
	List<UserInfoMain> getUserList();
	
}
