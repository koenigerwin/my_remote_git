package com.clps.bj.mms.bm.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.clps.bj.mms.bm.entity.Meeting;
import com.clps.bj.mms.bm.entity.MeetingUser;
import com.clps.bj.mms.bm.entity.Room;
import com.clps.bj.mms.bm.service.IMeetingService;
import com.clps.bj.mms.bm.service.IMeetingUserService;
import com.clps.bj.mms.bm.vo.LigeruiPager;
import com.clps.bj.mms.bm.vo.MeetingVo;
import com.clps.bj.mms.sm.entity.UserInfoMain;

/**
 * @Description:会议的控制层
 * @author candy
 *  MeetinController 
 *  2018年1月30日 上午11:31:43
 * @version V1.0
 */
@Controller
@RequestMapping("bm/meeting")
public class MeetingController {
	Logger logger = Logger.getLogger(MeetingController.class);
	@Autowired
	IMeetingService meetingService;
	@Autowired
	IMeetingUserService meetingUserService;

	/**
	 * Decription:跳转到meetingInfo.jsp页面
	 *  meetingInfo 
	 *  2018年2月6日 上午11:14:24
	 * @param request
	 * void
	 */
	@RequestMapping("meetingInfo")
	public void meetingInfo(HttpServletRequest request) {
		List<Room> roomList = meetingService.getRoomList();
		request.setAttribute("roomList", roomList);
		List<UserInfoMain> userList = meetingService.getUserList();
		request.setAttribute("userList", userList);
	}

	/**
	 * Decription:跳转到meetingall.jsp页面 
	 * meetingAll 
	 * 2018年2月6日 上午11:13:54
	 * @param request
	 * @param meetingTitle
	 * @return String
	 */
	@RequestMapping("meetingall")
	public String meetingAll(HttpServletRequest request, String meetingTitle) {
		List<Room> roomList = meetingService.getRoomList();
		request.setAttribute("roomList", roomList);
		List<UserInfoMain> userList = meetingService.getUserList();
		request.setAttribute("userList", userList);
		request.setAttribute("meetingTitle", meetingTitle);
		return "/bm/meeting/meetingall";
	}

	/**
	 * Decription:响应meetingvo的json对象到页面 
	 * meetingList 
	 * 2018年2月6日 上午11:15:04
	 * @param meetingvo
	 * @param request
	 * @param response
	 *   void
	 */
	@RequestMapping(value = "meetingList")
	public void meetingList(MeetingVo meetingvo, HttpServletRequest request, HttpServletResponse response) {
		logger.info("=======================" + meetingvo.toString());
		LigeruiPager<MeetingVo> lm = new LigeruiPager<>();
		PrintWriter out = null;
		try {
			out = response.getWriter();
			List<MeetingVo> meetingList = meetingService.getMeeting(meetingvo);
			for (MeetingVo mv : meetingList) {
				Map<String, String> map = meetingUserService.meetingUserList(mv.getMeetingId());
				String meetingUserIds = "";
				String meetingUserNames = "";
				for (Entry<String, String> entry : map.entrySet()) {
					meetingUserIds = entry.getKey();
					meetingUserNames = entry.getValue();
				}
				mv.setMeetingUserIds(meetingUserIds);
				mv.setMeetingUserNames(meetingUserNames);
			}
			lm.setRows(meetingList);
			lm.setTotal(meetingService.getMeetingCount(meetingvo));
			out.print(JSON.toJSONString(lm));
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (out != null) {
				out.close();
			}
		}
	}

	/**
	 * Decription:得到UserInfoMain对象
	 *  getUser 
	 *  2018年2月6日 上午11:16:19
	 * @param meetingCreateName
	 * @return UserInfoMain
	 */
	@RequestMapping("getUser")
	public UserInfoMain getUser(Integer meetingCreateName) {
		UserInfoMain user = meetingService.getUserInfoMainById(meetingCreateName);
		return user;
	}

	/**
	 * Decription:查询当前月份的所有会议信息
	 *  getMeetingByMonth 
	 *  2018年2月6日 上午11:16:46
	 * @param date
	 * @param request
	 * @return List<Meeting>
	 */
	@RequestMapping(value = "getMeetingByMonth")
	@ResponseBody
	public List<MeetingVo> getMeetingByMonth(String date, HttpServletRequest request) {
		logger.info(date);		
		List<MeetingVo> meetingList = meetingService.getMeetingByMonth(date, 2);//日期和当前用户id
		for(MeetingVo meetingvo:meetingList){
			Integer meetingId=meetingvo.getMeetingId();
			Map<String, String> muMap=meetingUserService.meetingUserList(meetingId);
			for(Entry<String, String> entry : muMap.entrySet()){
				meetingvo.setMeetingUserIds(entry.getKey());
				meetingvo.setMeetingUserNames(entry.getValue());
			}
		}
		return meetingList;
	}

	/**
	 * Decription:增加会议和修改会议
	 * addMeeting 
	 * 2018年2月6日 下午5:31:05
	 * @param meetingvo
	 * @return boolean
	 */
	@RequestMapping("addMeeting")
	public String addMeeting(MeetingVo meetingvo) {
		logger.info(meetingvo);
		Meeting meeting = new Meeting();
		meeting.setMeetingTitle(meetingvo.getMeetingTitle());
		meeting.setMeetingBegintime(meetingvo.getMeetingBegintime());
		meeting.setMeetingEndtime(meetingvo.getMeetingEndtime());
		meeting.setMeetingId(meetingvo.getMeetingId());
		meeting.setMeetingCreateName(1);// =====当前session
		meeting.setMeetingCreateDatetime(new Date().toString());
		meeting.setMeetingContent(meetingvo.getMeetingContent());
		Room room = new Room();
		room.setroomId(meetingvo.getRoomId());
		meeting.setRoom(room);
		UserInfoMain userinfo = new UserInfoMain();
		userinfo.setUserId(meetingvo.getUserId());
		meeting.setUserinfo(userinfo);
		String[] meetinguserid = meetingvo.getMeetingUserIds().split(";");
		if (meetingvo.getMeetingId() == null) {// 添加
			if (meetingService.addMeeting(meeting)) {
				for (String userid : meetinguserid) {
					MeetingUser meetinguser = new MeetingUser();
					UserInfoMain users = new UserInfoMain();
					users.setUserId(Integer.parseInt(userid));
					meetinguser.setMeeting(meeting);
					System.err.println("meeitng添加成功之后" + meeting.getMeetingId());
					meetinguser.setUserinfo(users);
					meetingUserService.addMeetingUser(meetinguser);
				}
				return "redirect:/bm/meeting/meetingInfo";
			}
		} else {// 修改
			if (meetingService.updateMeeting(meeting)) {
				meetingUserService.delMeetingUser(meeting.getMeetingId());
				for (String userid : meetinguserid) {
					MeetingUser meetinguser = new MeetingUser();
					UserInfoMain users = new UserInfoMain();
					users.setUserId(Integer.parseInt(userid));
					meetinguser.setMeeting(meeting);
					meetinguser.setUserinfo(users);
					meetingUserService.addMeetingUser(meetinguser);
				}
				return "redirect:/bm/meeting/meetingInfo";
			}
		}
		return "redirect:/error.jsp";
	}

	/**
	 * Decription:删除会议
	 * deleteMeeting
	 * 2018年2月7日 下午4:16:48
	 * @param meeting
	 * @return String
	 */
	@RequestMapping("/deleteMeeting")
	public String deleteMeeting(Meeting meeting) {
		logger.info(meeting);
		meeting = meetingService.getMeetingByID(meeting.getMeetingId());// 级联删除
		boolean b = meetingService.deleteMeeting(meeting);
		if (b) {
			return "redirect:/bm/meeting/meetingInfo";
		}
		return "redirect:/error.jsp";
	}
}
