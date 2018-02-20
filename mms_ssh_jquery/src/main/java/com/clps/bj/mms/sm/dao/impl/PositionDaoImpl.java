package com.clps.bj.mms.sm.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.clps.bj.mms.common.util.data.MyDate;
import com.clps.bj.mms.common.util.factory.UtilFactory;
import com.clps.bj.mms.sm.dao.PositionDao;
import com.clps.bj.mms.sm.dao.PositionHql;
import com.clps.bj.mms.sm.entity.Position;
import com.clps.bj.mms.sm.entity.UserInfoMain;

/**
 * 
 * @description：职位dao实现层
 * @className：PositionDaoImpl
 * @author ygg
 * @version V1.0.0
 * 2018年1月23日 上午11:54:07
 */
@Repository
public class PositionDaoImpl implements PositionDao,PositionHql {
	
	private SessionFactory sessionFactory;   //会话工厂
	private Session session;                 //会话
	private Query query;                     //查询器
	private Object[] args;                   //填充参数
	private MyDate myDate;                   //时间工具类
	private String format = "YYYY-MM-dd hh:mm:ss";    //日期格式
	
	
	public PositionDaoImpl(){
		this.myDate = UtilFactory.getInstanceOfDate();
	}
	
	
	/**
	 * @return the sessionFactory
	 */
	public final SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	
	/**
	 * @param sessionFactory the sessionFactory to set
	 */
	@Autowired
	public final void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	/**
	 * 获取session
	 * @return Session
	 * @throws Exception 
	 */
	private Session getSession() throws Exception{
		if(sessionFactory == null){
			throw new Exception("SessionFactory 获取失败");
		}else{
			return sessionFactory.openSession();
		}
	}
	
	/**
	 * 获取hql查询器
	 * @param sessionTemp 要查询的session
	 * @param sql 查询sql
	 * @param args 要填充的对象
	 * @return Query
	 */
	public Query getQuery(Session sessionTemp,String sql,Object[] args){
		Query query = sessionTemp.createQuery(sql);
		for(int i=0,length = args.length;i<length;i++){
			query.setParameter(i, args[i]);
		}
		return query;
	}
	
	@Override
	public Position queryPositionById(Integer positionId) throws Exception {
		Position position = null;
		session = getSession();
		args = new Object[]{positionId};
		if(session == null ){
			throw new Exception("session获取失败");
		}
		query = getQuery(session, queryPositionById, args);
		
		position = (Position) query.uniqueResult();
		session.close();
		return position;
	}

	@Override
	public Position queryPositionByName(String name) {
		Position position = null;
		args = new Object[]{name};
		try {
			session = getSession();
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		Query query = getQuery(session, queryPositionByName, args);
		position = (Position) query.uniqueResult();
		session.close();
		return position;
	}

	@Override
	public boolean addPosition(Position position) throws Exception {
		boolean isSuc = false;
		session = getSession();
		session.beginTransaction();
		position.setPositionCreatedDatetime(myDate.getNowStr(format ));
		position.setPositionUpdatedDatetime(myDate.getNowStr(format));
		
		session.save(position);
		session.getTransaction().commit();
		
		isSuc = true;
		return isSuc;
	}

	@Override
	public boolean deletePositionById(Integer positionId) throws Exception {
		Position deletePosition = queryPositionById(positionId);      //查询要删除的职位
		boolean isSuc = false;
		session = getSession();
		
		session.beginTransaction();                                       //删除职位
		session.delete(deletePosition);
		session.getTransaction().commit();
		session.close();
		isSuc = true;
		return isSuc;
	}

	@Override
	public boolean updatepositionById(Position position) throws Exception {
		boolean isSuc = false;
		
		
		Position positionTemp = queryPositionById(position.getPositionId());
		
		
		positionTemp.setPositionDescription(position.getPositionDescription());
		positionTemp.setPositionUpdatedDatetime(myDate.getNowStr(format));
		positionTemp.setPositionLocation(position.getPositionLocation());
		positionTemp.setPositionName(position.getPositionName());
		positionTemp.setPositionUpdatedId(position.getPositionUpdatedId());
		session = getSession();
		session.beginTransaction();
		session.update(positionTemp);
		session.getTransaction().commit();
		isSuc = true;
		session.close();
		return isSuc;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Position> queryAllpositions() throws Exception  {
		List<Position> positions = null;
		session = getSession();
		args = new Object[]{};
		query = getQuery(session, queryAllPositions, args);
		positions = query.list();
		session.close();
		return positions;
	}

}
