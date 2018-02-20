package com.clps.bj.mms.bm.dao.impl;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Resource;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import com.clps.bj.mms.bm.dao.MeetingUserDao;
import com.clps.bj.mms.bm.entity.MeetingUser;
import com.clps.bj.mms.bm.vo.MeetingUserVo;
/**
 *@Description:MeetingUserDao的实现类 
 * @author candy
 * MeetingUserDaoImpl
 * 2018年2月2日 上午9:05:16
 *@version V1.0
 */
@Repository
public class MeetingUserDaoImpl implements MeetingUserDao {
	
	private static final String getMUserSql="select u.userId,u.userName "
			+ "from MeetingUser mu left join mu.userinfo u  "
	    		+ " where mu.meeting.meetingId=?";
	private static final String deleteHql = "delete from MeetingUser where meetingUserId = ?";
	private static final String deleteByMeetingIdHql="delete from MeetingUser mu where mu.meeting.meetingId=?";
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
	
	@SuppressWarnings("unchecked")
	@Override
	public List<MeetingUserVo> meetingUserList(Integer meetingId) {
		Query query = session().createQuery(getMUserSql);
		query.setParameter(0, meetingId);
		List<Object[]> objList=query.list();
		List<MeetingUserVo> meetingUserList=new ArrayList<>();		
		for(Object[] obj:objList){
			MeetingUserVo meetingUserVo=new MeetingUserVo(obj);			
			meetingUserList.add(meetingUserVo);
			
		}
		return meetingUserList;
	}
	@Override
	public boolean addMeetingUser(MeetingUser meetinguser) {
		int b=(int) session().save(meetinguser);
		return b>0 ;
	}

	@Override
	public boolean delMeetingUser(MeetingUser meetinguser) {
		Query query = session().createQuery(deleteHql);
		query.setParameter(0, meetinguser.getMeetingUserId());
		return query.executeUpdate() > 0;
	}

	@Override
	public boolean delMeetingUser(Integer meetingId) {
		Query query=session().createQuery(deleteByMeetingIdHql);
		query.setParameter(0, meetingId);
		return query.executeUpdate() > 0;
	}

}
