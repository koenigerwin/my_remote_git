package com.clps.bj.mms.log;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.clps.bj.mms.log.entity.MenuLog;
import com.clps.bj.mms.log.entity.UserInfoLog;
import com.clps.bj.mms.log.service.IMenuLogService;
import com.clps.bj.mms.log.vo.InfoLogDto;

@RunWith(SpringJUnit4ClassRunner.class)  
@ContextConfiguration(locations = {"classpath*:beans.xml"})
//@Transactional
public class MenuLogServiceTest {
	@Autowired
	private IMenuLogService menuLogService;

	@Test
	public void testGetLogList() {
		List<MenuLog> list = menuLogService.getLogList(new InfoLogDto(null, "刘龙龙", null), 1, 12).getDataList();
		int length = list.size();
		System.out.println(length);
		System.out.println(list);
		foreach(list);
	}

	private void foreach(List<MenuLog> list){
		if(list==null){
			System.out.println("list 为空");
		}
		
		for(MenuLog temp : list){
			System.out.println(temp.toString());
		}
	}
}
