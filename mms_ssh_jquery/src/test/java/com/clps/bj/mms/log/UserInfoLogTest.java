package com.clps.bj.mms.log;

import static org.junit.Assert.*;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.ManyToOne;

import org.hibernate.Session;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.clps.bj.mms.log.entity.DeviceLog;
import com.clps.bj.mms.log.entity.MeetingLog;
import com.clps.bj.mms.log.entity.MenuLog;
import com.clps.bj.mms.log.entity.RoleLog;
import com.clps.bj.mms.log.entity.RoomLog;
import com.clps.bj.mms.log.entity.UserInfoLog;
import com.clps.bj.mms.util.hibernate.HibernateUtil;

import junit.framework.Assert;
/**
 * ClassName: UserInfoLogTest
 * @author LiuLong.Mr
 * @version 0.0.1V 
 * @since JDK 1.8 
 * 2018年1月22日下午2:35:41
 */

public class UserInfoLogTest {
	private Session session = null;
	@Before
	public void setUp() throws Exception {
		this.session = HibernateUtil.openSession();
		session.beginTransaction();
	}

	@After
	public void tearDown() throws Exception {
		HibernateUtil.close(this.session);
//		if(session!=null){ session.getTransaction().rollback(); }
//		HibernateUtil.close(session);
	}

	@Test
	public void testAddForUserInfoLog() throws Exception{
		UserInfoLog userInfoLog = new UserInfoLog();
		userInfoLog.setUserLogContent("insert UserInfoLog{userName:xx1,gender:xx2,...}");;
		userInfoLog.setUserLogOperator("刘龙龙");
		userInfoLog.setUserLogOperation("新增用户");
		userInfoLog.setUserLogOperatorDatetime(new Date());
		session.save(userInfoLog);
		session.getTransaction().commit();
	}
	@SuppressWarnings("deprecation")
	@Test
	public void testSelectOneForUserInfoLog() throws Exception{
		UserInfoLog userInfoLog = (UserInfoLog) session.load(UserInfoLog.class, "4028818b612dce0601612dce216c0000");
		Assert.assertEquals("刘龙龙", userInfoLog.getUserLogOperator());
	}
	
	@Test
	public void testUpdateForUserInfoLog() throws Exception{
		UserInfoLog userInfoLog = (UserInfoLog) session.load(UserInfoLog.class, "4028818b612dce0601612dce216c0000");
		userInfoLog.setUserLogOperator("理查德");
		session.update(userInfoLog);
		session.getTransaction().commit();
		Assert.assertEquals("刘龙龙", userInfoLog.getUserLogOperator());
	}
	@Test
	public void testDeleteForUserInfoLog() throws Exception{
		UserInfoLog userInfoLog = (UserInfoLog) session.load(UserInfoLog.class, "402883a6612c685e01612c6870e60000");
		session.delete(userInfoLog);
		session.getTransaction().commit();
		Assert.assertEquals(userInfoLog,session.load(UserInfoLog.class, "4028818b612dce0601612dce216c0000"));;
	}
	
	
	@Test
	public void testAddForRoom() throws Exception{
		RoomLog roomInfoLog = new RoomLog();
		roomInfoLog.setRoomLogContent("insert RoomInfoLog{userName:xx1,gender:xx2,...}");;
		roomInfoLog.setRoomLogOperator("刘龙龙");
		roomInfoLog.setRoomLogOperation("新增房间");
		roomInfoLog.setRoomLogOperatorDatetime(new Date());
		session.save(roomInfoLog);
		session.getTransaction().commit();
	}
	@Test
	public void testAddForMeeting() throws Exception{
		MeetingLog roomInfoLog = new MeetingLog();
		roomInfoLog.setMeetingLogContent("insert RoomInfoLog{userName:xx1,gender:xx2,...}");;
		roomInfoLog.setMeetingLogOperator("刘龙龙");
		roomInfoLog.setMeetingLogOperation("新增会议");
		roomInfoLog.setMeetingLogOperatorDatetime(new Date());
		session.save(roomInfoLog);
		session.getTransaction().commit();
	}
	@Test
	public void testAddForDevice() throws Exception{
		DeviceLog roomInfoLog = new DeviceLog();
		roomInfoLog.setDeviceLogContent("insert RoomInfoLog{userName:xx1,gender:xx2,...}");;
		roomInfoLog.setDeviceLogOperator("刘龙龙");
		roomInfoLog.setDeviceLogOperation("新增设备");
		roomInfoLog.setDeviceLogOperatorDatetime(new Date());
		session.save(roomInfoLog);
		session.getTransaction().commit();
	}
	@Test
	public void testAddForMenu() throws Exception{
		MenuLog roomInfoLog = new MenuLog();
		roomInfoLog.setMenuLogContent("insert RoomInfoLog{userName:xx1,gender:xx2,...}");;
		roomInfoLog.setMenuLogOperator("刘龙龙");
		roomInfoLog.setMenuLogOperation("新增菜单");
		roomInfoLog.setMenuLogOperatorDatetime(new Date());
		session.save(roomInfoLog);
		session.getTransaction().commit();
	}
	@Test
	public void testAddForRole() throws Exception{
		RoleLog roomInfoLog = new RoleLog();
		roomInfoLog.setRoleLogContent("insert RoomInfoLog{userName:xx1,gender:xx2,...}");;
		roomInfoLog.setRoleLogOperator("刘龙龙");
		roomInfoLog.setRoleLogOperation("新增菜单");
		roomInfoLog.setRoleLogOperatorDatetime(new Date());
		session.save(roomInfoLog);
		session.getTransaction().commit();
	}
}
