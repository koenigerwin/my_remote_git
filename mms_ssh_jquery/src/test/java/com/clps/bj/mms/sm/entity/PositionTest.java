package com.clps.bj.mms.sm.entity;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import com.clps.bj.mms.util.hibernate.HibernateUtil;
/**
 * 
 * @description：职位测试类
 * @className：PositionTest
 * @author gg Yang
 * @version V1.0.0
 * @date 2018年1月23日下午5:19:48
 */
public class PositionTest {
	
	private Logger logger;                  //日志对象
	private Session session;                //会话对象
	@Before
	public void init(){
		logger = Logger.getLogger(PositionTest.class);
		 this.session = HibernateUtil.openSession();
		   session.getTransaction().begin();
	}
	@Test
	public void add(){
		Position p1 = new Position();
		p1.setPositionName("前端工程师2");
		p1.setPositionLocation("北京");
		p1.setPositionCreatedDatetime("2018-01-23 20:30:10");
		p1.setPositionCreatedId(1);
		Position p = (Position) session.load(Position.class, 7);
		
		Assert.assertTrue(p.getPositionId()==7);
		
		p1.setPositionId(7);
		p1.setPositionUpdatedDatetime("2018-01-23 20:30:10");
		p1.setPositionUpdatedId(1);
		session.save(p1);
	}
	
	@After
	public void after(){
		session.getTransaction().commit();
	}
}
