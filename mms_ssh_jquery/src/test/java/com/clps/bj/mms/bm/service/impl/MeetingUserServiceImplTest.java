package com.clps.bj.mms.bm.service.impl;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.clps.bj.mms.bm.service.IMeetingUserService;

@RunWith(SpringJUnit4ClassRunner.class)  
@ContextConfiguration(locations = {"classpath*:beans.xml"})

public class MeetingUserServiceImplTest {
	Logger logger = Logger.getLogger(MeetingServiceImplTest.class);
	@Autowired
	IMeetingUserService meetingUserService;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testMeetingUserList() {
	Map<String,String> meetingUserMap=meetingUserService.meetingUserList(8);//key存userids,value存usernames
	for (Entry<String, String> entry : meetingUserMap.entrySet()) {
		logger.info(entry.getKey()+"userids=======");
		logger.info(entry.getValue()+"usernames===================");
	}
	}

}
