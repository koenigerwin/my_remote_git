package com.clps.bj.mms.sm.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.clps.bj.mms.common.util.data.MyJson;
import com.clps.bj.mms.sm.entity.Menu;
import com.clps.bj.mms.sm.service.IMenuService;
import com.clps.bj.mms.sm.vo.MyInfo;

/**
 * 
 * @description：TODO
 * @className：ControllerTest
 * @author gg Yang
 * @version V1.0.0
 * @date 2018年1月26日下午4:09:12
 */
@Controller
@RequestMapping(value="/menuMain")
public class MenuShowController {
	@Autowired
	private IMenuService menuService ;
	
	@RequestMapping(value="/forward")
	public String forwardToMain(HttpServletRequest req,HttpServletResponse rep){
		return "menu_main";
	}
	
	
	@RequestMapping(value="/getAllDirs")
	public void forward(HttpServletRequest req,HttpServletResponse rep){
		//req.setCharacterEncoding(arg0);
		List<MyInfo> infos = null;
		//System.out.println("seeee");
		try {
			infos = menuService.getMenusByVo();		      //获取所有的菜单
			
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		MyJson myJson = new MyJson();
		String se = "{text:'没有菜单'}";
		if(infos !=null && !infos.isEmpty()){
			se = myJson.getGridString( infos).replace("name","text").replace("nodes", "children").replace(",\"children\":[]", "");			
			/*se ="["+se+"]";*/
/*			se ="[{\"id\":0,\"text\":\"系统管理\",\"pid\":0,\"children\":["+se+"]}]";
*/		}
		
		try {
			PrintWriter out = rep.getWriter();
			
			out.println(se);
			out.flush();
			out.close();
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		//return "menu_main";
	}
}
