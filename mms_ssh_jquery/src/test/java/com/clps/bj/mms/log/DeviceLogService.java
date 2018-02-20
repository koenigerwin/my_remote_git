package com.clps.bj.mms.log;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.clps.bj.mms.log.entity.RoleLog;
import com.clps.bj.mms.log.service.IRoleLogService;
import com.clps.bj.mms.log.vo.InfoLogDto;

@RunWith(SpringJUnit4ClassRunner.class)  
@ContextConfiguration(locations = {"classpath*:beans.xml"})
//@Transactional
public class DeviceLogService {
	@Autowired
	private IRoleLogService roleLogService;

	@Test
	public void testGetLogList() {
		List<RoleLog> list = roleLogService.getLogList(new InfoLogDto(null, "刘龙龙", null), 1, 12).getDataList();
		int length = list.size();
		System.out.println(length);
		System.out.println(list);
		foreach(list);
	}

	private void foreach(List<RoleLog> list){
		if(list==null){
			System.out.println("list 为空");
		}
		
		for(RoleLog temp : list){
			System.out.println(temp.toString());
		}
	}
}
