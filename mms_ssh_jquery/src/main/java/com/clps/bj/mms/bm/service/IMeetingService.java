package com.clps.bj.mms.bm.service;

import java.util.List;

import com.clps.bj.mms.bm.entity.Meeting;
import com.clps.bj.mms.bm.entity.Room;

import com.clps.bj.mms.bm.vo.MeetingVo;
import com.clps.bj.mms.sm.entity.UserInfoMain;

/**
 *@Description: meeting的业务接口
 * @author candy
 * MeetingService
 * 2018年1月22日 下午3:30:37
 *@version V1.0
 */
public interface IMeetingService {
	/**
	 * Decription:所有预定会议的添加
	 * addMeeting
	 * 2018年1月24日 上午10:15:22
	 * @param meeting void
	 */
	boolean addMeeting(Meeting meeting);
	/**
	 * Decription:根据会议的id修改会议信息
	 * updateMeeting
	 * 2018年1月24日 上午10:15:45
	 * @param meeting
	 * @return boolean
	 */
	boolean  updateMeeting(Meeting meeting);
	/**
	 * Decription:根据会议的id删除会议
	 * deleteMeeting
	 * 2018年1月24日 上午10:16:28
	 * @param meeting
	 * @return boolean
	 */
	boolean deleteMeeting(Meeting meeting);
	/**
	 * Decription:按条件查询会议信息
	 * getMeeting
	 * 2018年1月24日 上午10:16:56
	 * @param meeting
	 * @return List<Meeting>
	 */
	List<MeetingVo> getMeeting(MeetingVo meetingVo);
	/**
	 * Decription:查询会议数量
	 * getMeetingCount
	 * 2018年2月1日 上午11:37:19
	 * @param meeting
	 * @return int
	 */
    Long getMeetingCount(MeetingVo meetingVo);
	/**
	 * getMyMeeting
	 * @ return List<Meeting>
	 * 2018年1月17日 下午4:08:44
	 * @param meeting_user_ids
	 * 查询我的会议的方法
	 * @return
	 */
	
	List<Meeting> getMyMeeting(String nowuser);
	/**
	 * Decription:查询所有的会议结束时间
	 * listEndTime
	 * 2018年1月28日 上午8:54:06
	 * @return List<String>
	 */
	List<String> listEndTime();
	/**
	 * Decription:返回Meeting对象
	 * getMeetingByID
	 * 2018年2月2日 上午9:39:13
	 * @param meetingId
	 * @return Meeting
	 */
	Meeting getMeetingByID(Integer meetingId);
	/**
	 * Decription:根据会议日期(年-月)和当前用户Id查询会议信息
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


