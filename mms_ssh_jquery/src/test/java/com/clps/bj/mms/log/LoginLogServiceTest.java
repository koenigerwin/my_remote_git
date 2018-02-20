package com.clps.bj.mms.log;

import static org.junit.Assert.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.clps.bj.mms.log.entity.InfoLog;
import com.clps.bj.mms.log.entity.LoginLog;
import com.clps.bj.mms.log.entity.MeetingLog;
import com.clps.bj.mms.log.service.ILoginLogService;
import com.clps.bj.mms.log.service.IMeetingLogService;
import com.clps.bj.mms.log.vo.InfoLogDto;
import com.clps.bj.mms.log.vo.LoginDto;
import com.clps.bj.mms.sm.vo.MyInfo;
@RunWith(SpringJUnit4ClassRunner.class)  
@ContextConfiguration(locations = {"classpath*:beans.xml"})
//@Transactional
public class LoginLogServiceTest {
	@Autowired
	private ILoginLogService loginLogService;
	
	@Test
	public void testLogout() {
		loginLogService.updateLogout("402883a6613fcc6c0199402883a6613f");
	}
	@Test
	public void testLogon(){
		loginLogService.saveLogon("192.168.3.3", "402883a6613fcc6c0199402883a6617f", "山里的龙人", "刘龙");
	}
	@Test
	public void testGetLogList() {
		LoginDto model = new LoginDto();
		model.setLoginLogUserName("刘龙");
		List<LoginLog> list = loginLogService.getLogList(model, 1, 3).getDataList();
		foreach(list);
	}
	@Test
	public void testGetCountsByName(){
		
		System.out.println("*******************");
		long i = loginLogService.getCountsByName("刘龙");
		System.out.println(i+"数量");
		System.out.println("*******************");
	}
	private void foreach(List<LoginLog> list){
		if(list==null){
			System.out.println("list 为空");
		}
		
		for(LoginLog temp : list){
			System.out.println(temp.toString());
		}
	}
}
