package com.clps.bj.mms.sm.service.impl;
/**
 * 
 * @description：职位业务逻辑测试类
 * @className：PositionServiceTest
 * @author gg Yang
 * @version V1.0.0
 * @date 2018年1月25日上午11:15:44
 */

import java.util.List;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.clps.bj.mms.sm.entity.Position;
import com.clps.bj.mms.sm.service.IPositionService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:/beans.xml"})
public class PositionServiceTest {
	private Logger logger = null;       //日志对象
	@Autowired
	private IPositionService positionService;          //职位业务逻辑类
	@Before
	public void init(){
		logger = Logger.getLogger(PositionServiceTest.class);
		
	}
	
	@Test
	public void testAddPosition(){
		Position position = new Position();
		position.setPositionName("hr2");
		position.setPositionCreatedId(1);
		position.setPositionUpdatedId(1);
		try {
			boolean isSuc = positionService.addPosition(position);
			logger.info(isSuc);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}
	
	@Test
	public void testGetById(){
		try {
			Position position = positionService.queryPositionById(1);
			logger.info("                       ");
			logger.info(position.getPositionName());
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}
	
	@Test
	public void testGetByName(){
		try {
			Position position = positionService.queryPositionByName("hr");
			logger.info("                       ");
			logger.info(position.getPositionName());
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}
	
	@Test
	public void queryAllpositions(){
		try {
			
			List<Position> positions = positionService.queryAllpositions();
			logger.info("                       ");
			for(Position p:positions){
				
				logger.info(p.getPositionName());
			}
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}
	
	@Test
	public void updatepositionById(){
		try {
			
			Position position = new Position();
			position.setPositionId(1);
			position.setPositionName("ge");
			position.setPositionLocation("ee");
			position.setPositionUpdatedId(2);
			boolean isSuc = positionService.updatepositionById(position);
			logger.info("              ");
			logger.info(isSuc);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}
	
	
	@Test
	public void upDeletepositionById(){
		try {
			
			
			boolean isSuc = positionService.deletePositionById(1);
			logger.info("              ");
			logger.info(isSuc);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}
	
	@After
	public void after(){
		
	}
	
}
