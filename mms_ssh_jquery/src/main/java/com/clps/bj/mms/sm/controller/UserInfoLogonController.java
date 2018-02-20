/**
 * 
 */
package com.clps.bj.mms.sm.controller;

import java.util.Map;
import java.util.Objects;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.clps.bj.mms.common.util.encrypt.EncryptFactory;
import com.clps.bj.mms.common.util.exception.UserInfoServiceException;
import com.clps.bj.mms.sm.entity.UserInfoMain;
import com.clps.bj.mms.sm.service.IUserInfoMainService;

/**
 * @Description
 * @author Administrator
 * @Since V1.0.0
 * 2018年2月1日上午11:21:52
 */
@Controller
public class UserInfoLogonController {
	
	
	@Autowired
	private IUserInfoMainService service = null;
	//@RequestParam
	//跳转到login 的页面
	@RequestMapping("/login")
	public String login(HttpServletRequest request, String username, String password) {
		System.out.println("登录");
		System.out.println(username);
		if(username!=null&&username.trim().length()!=0){
		try {
			UserInfoMain user = service.login(request,username, EncryptFactory.getEncry().EncoderByMd5(password));
//			System.out.println("111111111111"+user.getUserStatus());
			if(user!=null){
				    user.setUserStatus(1);
					HttpSession session = request.getSession(true);
					session.setAttribute("user", user);	
					return "userInfos_main"; 
				
			}else{
				   return "login";
			}
		} catch(Exception e){
			 return "login";
		}
		
	}else{
		return "login";
	}
  }
}
