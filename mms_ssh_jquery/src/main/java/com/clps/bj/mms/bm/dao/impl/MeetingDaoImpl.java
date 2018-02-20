package com.clps.bj.mms.bm.dao.impl;

import java.util.ArrayList;

import java.util.List;

import javax.annotation.Resource;
import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import com.clps.bj.mms.bm.dao.MeetingDao;
import com.clps.bj.mms.bm.entity.Meeting;
import com.clps.bj.mms.bm.entity.Room;
import com.clps.bj.mms.bm.vo.MeetingVo;
import com.clps.bj.mms.sm.entity.UserInfoMain;



/**
 * 
 *@Description:MeetingDao的实现类 
 *@author candy
 *MeetingDaoImpl
 *2018年1月24日 上午10:09:51
 *@version V1.0
 */
@Repository
public class MeetingDaoImpl implements MeetingDao {

	private static final String updateHql = "update Meeting m set m.meetingTitle=?,"
			+ "m.meetingContent=?,m.meetingBegintime=?,m.meetingEndtime=?,"
			+ "m.userinfo.userId=?,m.room.roomId=?,m.meetingCreateDatetime=?,"
			+ "m.meetingCreateName=? where m.meetingId=?";
	private static final String deleteHql = "delete from Meeting where meetingId = ?";
	private static final String getHql = "select m.meetingId,m.meetingTitle,"
			+ "m.meetingBegintime,m.meetingEndtime,m.meetingContent,"
			+ "m.meetingCreateDatetime,m.meetingCreateName,m.meetingStatus,"
			+ "r.roomId,r.roomName,r.roomIsEnable,u.userId,u.userName  from Meeting m "
			+ " left  join  m.userinfo u  left join  m.room  r "
			+ " where 1=1 ";
	@SuppressWarnings("unused")
	private static final String getMySql="select m.meetingId,m.meetingTitle,m.meetingContent,"
			+ "m.meetingBegintime,m.meetingEndtime,m.meetingStatus,"
			+ "m.meetingCreateDatetime,m.meetingCreateName,u.userId,u.userName, "
			+ "r.roomId,r.roomName,r.roomIsEnable  from Meeting m "
			+ " left join fetch m.userinfo u left join fetch m.room r "			
			+ "  where m.meetingId in(select mu.meeting.)";
	private static final String getEndTimeHql="select meetingEndtime from Meeting"; 
    private static final String getRoomListHql="select r.roomId,r.roomName from Room r"
    		+ " where r.roomIsEnable='1'";
    private static final String getUserListHql="select u.userId,u.userName from UserInfoMain u";
    private static final String getCountHql="select count(*)  from Meeting m "
			+ " left  join  m.userinfo u  left join  m.room  r "
			+ " where 1=1 ";		
  	private static final String getMeetingByMonthHql="select m.meetingId,m.meetingTitle,"
			+ "m.meetingBegintime,m.meetingEndtime,m.meetingContent,"
			+ "m.meetingCreateDatetime,m.meetingCreateName,m.meetingStatus,"
			+ "r.roomId,r.roomName,r.roomIsEnable,u.userId,u.userName "
  			+ " from Meeting m left  join  m.userinfo u  left join  m.room  r "
  			+ "where m.meetingBegintime like ?";
	Logger logger = Logger.getLogger(MeetingDaoImpl.class);

	@Resource
	private SessionFactory sessionFactory;

	/**
	 * Decription:返回Session
	 * session
	 * 2018年2月2日 上午9:25:15
	 * @return Session
	 */
	public Session session(){
		return sessionFactory.getCurrentSession();
	}
	@Override
	public boolean addMeeting(Meeting meeting) {
		int b=(int) session().save(meeting);
		return b>0;
	}

	@Override
	public boolean updateMeeting(Meeting meeting) {
		Query query = session().createQuery(updateHql);
		query.setParameter(0, meeting.getMeetingTitle());
		query.setParameter(1, meeting.getMeetingContent());
		query.setParameter(2, meeting.getMeetingBegintime());
		query.setParameter(3, meeting.getMeetingEndtime());
		query.setParameter(4, meeting.getUserinfo().getUserId());
		query.setParameter(5, meeting.getRoom().getroomId());
		query.setParameter(6, meeting.getMeetingCreateDatetime());
		query.setParameter(7, meeting.getMeetingCreateName());
		query.setParameter(8, meeting.getMeetingId());
		int t = query.executeUpdate();
		return t > 0;
	}

	@Override
	public boolean deleteMeeting(Meeting meeting) {
		Query query = session().createQuery(deleteHql);
		query.setParameter(0, meeting.getMeetingId());
		return query.executeUpdate() > 0;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public List<MeetingVo> getMeeting(Meeting meeting) {
		String str = getHql;
		List conditionstr = new ArrayList<>();
		if (meeting.getMeetingTitle() != null && meeting.getMeetingTitle().length() != 0) {
			str += " and m.meetingTitle like ? ";
			conditionstr.add("%"+meeting.getMeetingTitle()+"%");
		}
		if(meeting.getUserinfo().getUserId()!=null&&meeting.getUserinfo().getUserId()!=-1){//设请选择为-1
			str+=" and m.userinfo.userId =?";
			 conditionstr.add(meeting.getUserinfo().getUserId());
			 }
		 if(meeting.getMeetingBegintime()!=null&&meeting.getMeetingBegintime().length()!=0){
			 str+=" and m.meetingBegintime like ?";
			 conditionstr.add("%"+meeting.getMeetingBegintime()+"%");
		 }
		 if(meeting.getMeetingEndtime()!=null&&meeting.getMeetingEndtime().length()!=0){
			 str+=" and m.meetingEndtime like ?";
			 conditionstr.add("%"+meeting.getMeetingEndtime()+"%");
		 }
		 if(meeting.getRoom().getroomId()!=null&&meeting.getRoom().getroomId()!=-1){
			 str+=" and m.room.roomId =?";
			 conditionstr.add(meeting.getRoom().getroomId());
			 }
		 if(meeting.getMeetingStatus()!=null&&meeting.getMeetingStatus()!=-1){
			 str+=" and m.meetingStatus =?";
			 conditionstr.add(meeting.getMeetingStatus());
			 }
		 str+=" order by m.meetingBegintime desc";
           logger.info(str);
		Query query = session().createQuery(str);
		if (conditionstr.size() > 0) {
			for (int i = 0; i < conditionstr.size(); i++) {
				query.setParameter(i, conditionstr.get(i));
			}
		}
		List<MeetingVo> meetingList = new ArrayList<>();
		List<Object[]> meetingVoList = query.list();
		for (Object[] obj : meetingVoList) {
			MeetingVo vo = new MeetingVo(obj);
			meetingList.add(vo);
		}
		return meetingList;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public Long getMeetingCount(Meeting meeting) {
	    String count= getCountHql;
		List conditionstr = new ArrayList<>();
		if (meeting.getMeetingTitle() != null && meeting.getMeetingTitle().length() != 0) {
			count += " and m.meetingTitle like ? ";
			conditionstr.add("%"+meeting.getMeetingTitle()+"%");
		}
		 if(meeting.getUserinfo().getUserId()!=null&&meeting.getUserinfo().getUserId()!=-1){//设请选择为-1
			count+=" and m.userinfo.userId =?";
		    conditionstr.add(meeting.getUserinfo().getUserId());
		 }
		 if(meeting.getMeetingBegintime()!=null&&meeting.getMeetingBegintime().length()!=0){
			count+=" and m.meetingBegintime like ?";
		    conditionstr.add("%"+meeting.getMeetingBegintime()+"%");
		 }
		 if(meeting.getMeetingEndtime()!=null&&meeting.getMeetingEndtime().length()!=0){
		    count+=" and m.meetingEndtime like ?";
		    conditionstr.add("%"+meeting.getMeetingEndtime()+"%");
		 }
		 if(meeting.getRoom().getroomId()!=null&&meeting.getRoom().getroomId()!=-1){
		   count+=" and m.room.roomId =?";
		   conditionstr.add(meeting.getRoom().getroomId());
		 }
		 if(meeting.getMeetingStatus()!=null&&meeting.getMeetingStatus()!=-1){
			 count+=" and m.meetingStatus =?";
		     conditionstr.add(meeting.getMeetingStatus());
		 }
           logger.info(count);
		Query query = session().createQuery(count);
		if (conditionstr.size() > 0) {
			for (int i = 0; i < conditionstr.size(); i++) {
				query.setParameter(i, conditionstr.get(i));
			}
		}
		Long count2=(Long) query.uniqueResult();
		return count2;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<MeetingVo> getMeetingByMonth(String yearMonth,Integer userId) {
		Query query=session().createQuery(getMeetingByMonthHql);
		query.setParameter(0,yearMonth+"%");
		List<Object[]> objs=query.list();
		List<MeetingVo> meetingList=new ArrayList<>();
		for(Object[] obj:objs){
			MeetingVo meetingvo=new MeetingVo(obj);
			meetingList.add(meetingvo);
		}	
		return meetingList;
	}
	
	@Override
	public List<Meeting> getMyMeeting(String nowuser) {
	return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<String> getEndTime() {
		Query query=session().createQuery(getEndTimeHql);
		List<String> listEndTime=query.list();
		return listEndTime;
	}

	@Override
	public Meeting getMeetingByID(Integer meetingId) {
     Meeting meeting=(Meeting) session().get(Meeting.class, meetingId);
		return meeting;
	}
	
	@Override
	public Room getRoomById(Integer roomId) {
		Room room = (Room) session().get(Room.class, roomId);
		return room;
	}

	@Override
	public UserInfoMain getUserInfoMainById(Integer userId) {
		UserInfoMain user = (UserInfoMain) session().get(UserInfoMain.class, userId);
		return user;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Room> getRoomList() {
		Query query = session().createQuery(getRoomListHql);
		List<Object[]> objList = query.list();
		List<Room> roomList = new ArrayList<>();
		for (Object[] objs : objList) {
			Room room=new Room(objs);
				roomList.add(room);
			}		

		return roomList;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<UserInfoMain> getUserList() {
		Query query = session().createQuery(getUserListHql);
		List<Object[]> objList = query.list();
		List<UserInfoMain> userList = new ArrayList<>();
		for (Object[] objs : objList) {
			UserInfoMain user=new UserInfoMain(objs);
				userList.add(user);
			}		
		return userList;
	}
	

	

}
