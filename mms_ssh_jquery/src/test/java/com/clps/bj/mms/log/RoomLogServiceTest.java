package com.clps.bj.mms.log;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.clps.bj.mms.log.entity.RoomLog;
import com.clps.bj.mms.log.service.IRoomLogService;
import com.clps.bj.mms.log.vo.InfoLogDto;

@RunWith(SpringJUnit4ClassRunner.class)  
@ContextConfiguration(locations = {"classpath*:beans.xml"})
//@Transactional
public class RoomLogServiceTest {
	@Autowired
	private IRoomLogService roleLogService;

	@Test
	public void testGetLogList() {
		List<RoomLog> list = roleLogService.getLogList(new InfoLogDto(null, "刘龙龙", null), 1, 4).getDataList();
		int length = list.size();
		System.out.println(length);
		System.out.println(list);
		foreach(list);
	}

	private void foreach(List<RoomLog> list){
		if(list==null){
			System.out.println("list 为空");
		}
		
		for(RoomLog temp : list){
			System.out.println(temp.toString());
		}
	}
}
