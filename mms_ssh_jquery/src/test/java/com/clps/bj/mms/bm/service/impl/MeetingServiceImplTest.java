package com.clps.bj.mms.bm.service.impl;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import com.clps.bj.mms.bm.entity.Meeting;
import com.clps.bj.mms.bm.entity.MeetingUser;
import com.clps.bj.mms.bm.entity.Room;
import com.clps.bj.mms.bm.service.IMeetingService;
import com.clps.bj.mms.bm.service.IMeetingUserService;
import com.clps.bj.mms.bm.vo.MeetingVo;

import com.clps.bj.mms.sm.entity.UserInfoMain;
@RunWith(SpringJUnit4ClassRunner.class)  
@ContextConfiguration(locations = {"classpath*:beans.xml"})
//@Transactional 加上的话事务将会回滚 数据库库中的数据将保持修改前的状态。
/**
 *@Description: MeetingServiceImpl的测试类
 * @author candy
 * MeetingServiceImplTest
 * 2018年1月26日 上午9:18:41
 *@version V1.0
 */

public class MeetingServiceImplTest {
	Logger logger = Logger.getLogger(MeetingServiceImplTest.class);
	@Autowired
	IMeetingService meetingservice;
    @Autowired
    IMeetingUserService meetinguserservice;
	public final void setMeetingservice(IMeetingService meetingservice) {
		this.meetingservice = meetingservice;
	}

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}
	/**
	 * Decription:添加会议的测试
	 * testAddMeeting
	 * 2018年1月26日 上午11:13:45 void
	 */
	@Test
	public void testAddMeeting() {
		Room room=new Room();
		room.setroomId(1);
		UserInfoMain userinfo=new UserInfoMain();
		userinfo.setUserId(2);
		Meeting meeting=new Meeting();
		meeting.setMeetingTitle("年会lcd");
		meeting.setMeetingBegintime("2017-12-23 23:34:12");
		meeting.setMeetingContent("年会.....");
		meeting.setMeetingEndtime("2017-12-23 23:34:12");
		meeting.setMeetingCreateName(1);		
		meeting.setUserinfo(userinfo);	
		meeting.setRoom(room);
		meeting.setMeetingCreateDatetime(new Date().toString());
	    meeting.setMeetingCreateName(1);	    
		boolean b=meetingservice.addMeeting(meeting);	
	      String[] meetinguserid={"1","2"};
			if(b){		
				for(String userid:meetinguserid){
					MeetingUser meetinguser=new MeetingUser();
					UserInfoMain users=new UserInfoMain();
					users.setUserId(Integer.parseInt(userid));
					meetinguser.setMeeting(meeting);
					meetinguser.setUserinfo(users);
					meetinguserservice.addMeetingUser(meetinguser);
				}
	}
	}
	/**
	 * Decription:修改会议的测试
	 * testUpdateMeeting
	 * 2018年1月26日 上午11:13:25 void
	 */
	@Test
	public void testUpdateMeeting() {
		Meeting meeting=new Meeting();
		meeting.setMeetingId(73);
		meeting.setMeetingTitle("腊八八");
		meeting.setMeetingBegintime("2017-12-23 23:34:12");
		meeting.setMeetingContent("11111.....");
		meeting.setMeetingEndtime("2017-12-23 23:34:12");
		meeting.setMeetingCreateName(1);
		UserInfoMain userinfo=new UserInfoMain();
		userinfo.setUserId(2);
		meeting.setUserinfo(userinfo);
		Room room=new Room();
		room.setroomId(1);
		meeting.setRoom(room);		
		meeting.setMeetingCreateDatetime(new Date().toString());
		Boolean b=meetingservice.updateMeeting(meeting);
		if(b){
		logger.info("修改成功"+b);	
		}		
	}
	/**
	 * Decription:删除会议的测试
	 * testDeleteMeeting
	 * 2018年1月26日 上午11:12:59 void
	 */
	@Test
	public void testDeleteMeeting() {
		Meeting meeting=meetingservice.getMeetingByID(79);
		Boolean b=meetingservice.deleteMeeting(meeting);
		if(b){
			logger.info("删除成功"+b);	
		}		
	}
	/**
	 * Decription:按条件查询会议的测试类
	 * testgetMeeting
	 * 2018年1月26日 上午11:12:26 void
	 */
	@Test
	public void testgetMeeting(){		
	
		MeetingVo meetingvo=new MeetingVo();
		meetingvo.setMeetingTitle("年会");
		meetingvo.setUserId(1);
		//meetingvo.setMeetingBegintime("1");
		//meetingvo.setMeetingEndtime("1");
		//meetingvo.setRoomId(1);
				System.out.println("======================");
		List<MeetingVo> meetingList=meetingservice.getMeeting(meetingvo);
	
		for(MeetingVo m:meetingList){
			logger.info(m.getRoomId()+"rid");
			logger.info(m.getRoomName()+"rname");
			logger.info(m.getUserId()+"uidd");
			logger.info(m.getRoomIsEnable()+"risenable");
			logger.info(m.getUserName()+"uname");
			logger.info(m.getMeetingContent()+"mcontent");
	}
		
  }
	@Test
	public void testgetEndTime(){
		List<String> list=meetingservice.listEndTime();
		for(String e:list){
			logger.info(e+"==========");
		}
	}
	
	@Test
	public void testgetRoomList(){
		List<Room> roomList=meetingservice.getRoomList();
		for(Room r:roomList){
			logger.info(r.getroomName()+"====");
			logger.info(r.getroomId()+"====");
		}
	}
	@Test
	public void testgetUserList(){
		List<UserInfoMain> userList=meetingservice.getUserList();
		for(UserInfoMain u:userList){
			
			System.out.println(u.getUserName()+u.getUserId()+"=======");
			logger.info(u.getUserName()+u.getUserId()+"=======");
		}
	}
	}
	