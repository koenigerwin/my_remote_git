package com.clps.bj.mms.sm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 
 * @description：TODO
 * @className：CommonController
 * @author gg Yang
 * @version V1.0.0
 * @date 2018年1月28日下午3:18:48
 */
@Controller
@RequestMapping(value="/user")
public class CommonController {
	@RequestMapping(value="/userMain")
	public String forwardMain(){
		return "user_main";
	}
}
