package com.clps.bj.mms.bm.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.clps.bj.mms.bm.constant.MeetingStatusType;
import com.clps.bj.mms.bm.vo.MeetingVo;
import com.clps.bj.mms.constant.DataRecordType;
import com.clps.bj.mms.sm.entity.UserInfoMain;
import com.clps.bj.mms.util.hibernate.HibernateUtil;

/**
 *@Description: 实体类的测试类
 * @author candy
 * MeetingTest
 * 2018年1月26日 上午11:18:35
 *@version V1.0
 */

public class MeetingTest {
	Logger logger=Logger.getLogger(MeetingTest.class);
	private Session session = null;
	/**
	 * setUp
	 * @throws Exception void
	 */
	@Before
	public void setUp() throws Exception {
		// 打开session
		// 开启事物
		this.session = HibernateUtil.openSession();
		session.getTransaction().begin();
	}
	/**
	 * tearDown
	 * @throws Exception void
	 */
	@After
	public void tearDown() throws Exception {

		if (session == null)
			session.getTransaction().rollback();
		HibernateUtil.close(session);
	}
	/**
	 * Decription:会议实体类的添加测试
	 * testAdd
	 * 2018年1月26日 下午5:23:35 void
	 */
	@Test
	public void testAdd() {
		Room room = new Room();
		room.setroomId(1);
		UserInfoMain userinfo = new UserInfoMain();
		userinfo.setUserId(2);
		Meeting meeting = new Meeting();
		meeting.setMeetingTitle("年会lcd");
		meeting.setMeetingBegintime("2017-12-23 23:34:12");
		meeting.setMeetingContent("年会.....");
		meeting.setMeetingEndtime("2017-12-23 23:34:12");
		meeting.setMeetingCreateName(1);
		meeting.setUserinfo(userinfo);
		meeting.setRoom(room);
		meeting.setMeetingCreateDatetime(new Date().toString());
		Integer status=MeetingStatusType.NOEND.getId();
		logger.info(status+"==========sss===");
	
		
		meeting.setMeetingStatus(status);
		session.save(meeting);
		logger.info("插入成功！！");
		session.getTransaction().commit();
	}
	/**
	 * Decription:会议实体类的修改测试
	 * testUpdate
	 * 2018年1月26日 下午5:24:01 void
	 */
	@Test
	public void testUpdate() {
		Meeting meeting = (Meeting) session.load(Meeting.class, 60);
		Room room = new Room();
		room.setroomId(2);
		meeting.setRoom(room);
		session.update(meeting);
		logger.info("修改成功！！");
		session.getTransaction().commit();
	}
	/**
	 * Decription:会议实体类的删除测试
	 * testDelete
	 * 2018年1月26日 下午5:24:30 void
	 */
	@Test
	public void testDelete() {
		Meeting meeting = (Meeting) session.load(Meeting.class, 59);
		session.delete(meeting);
		session.getTransaction().commit();
	}
	/**
	 * Decription:会议实体类的查询测试
	 * testGetMeeting
	 * 2018年1月26日 下午5:25:20 void
	 */
	@SuppressWarnings("unchecked")
	@Test
	public void testGetMeeting(){
		String sql="select m.meetingId,m.meetingTitle,"
				+ "m.meetingBegintime,m.meetingEndtime,m.meetingContent,"
				+ "m.meetingCreateDatetime,m.meetingCreateName,m.meetingStatus,"
				+ "r.roomId,r.roomName,r.roomIsEnable,u.userId,u.userName  from Meeting m "
				+ " left  join  m.userinfo u  left join  m.room  r ";
			
		Query query = session.createQuery(sql);
		List<Object[]> list = query.list();
		List<MeetingVo> meetingList = new ArrayList<>();
		for (Object[] obj : list) {
			MeetingVo meetingVo = new MeetingVo(obj);
			meetingList.add(meetingVo);
		}
		for (MeetingVo m : meetingList) {
			logger.info(m.getMeetingId());
			logger.info(m.getRoomName());
			logger.info(m.getMeetingStatus());
			logger.info(m.getUserName());
			logger.info("============");
		}
	}
}
