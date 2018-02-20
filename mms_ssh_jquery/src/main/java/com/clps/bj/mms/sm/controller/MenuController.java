package com.clps.bj.mms.sm.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.TypeReference;
import com.clps.bj.mms.common.util.data.MyDate;
import com.clps.bj.mms.common.util.data.MyJson;
import com.clps.bj.mms.common.util.factory.UtilFactory;
import com.clps.bj.mms.constant.TimeFormatConstant;
import com.clps.bj.mms.sm.entity.Menu;
import com.clps.bj.mms.sm.entity.MenuPermission;
import com.clps.bj.mms.sm.service.IGrantService;
import com.clps.bj.mms.sm.service.IMenuService;
import com.clps.bj.mms.sm.service.impl.MenuServiceImpl;
import com.clps.bj.mms.sm.vo.UUIdText;
import com.clps.bj.mms.sm.vo.MenuPermissionInfo;
import com.clps.bj.mms.sm.vo.MyInfo;
import com.clps.bj.mms.sm.vo.MyInfoDetail;
import com.clps.bj.mms.sm.vo.PermissionInfo;

/**
 * 
 * @description：TODO
 * @className：ControllerTest
 * @author gg Yang
 * @version V1.0.0
 * @date 2018年1月26日下午4:09:12
 */
@Controller
@RequestMapping(value="/menu")
public class MenuController {
	@Autowired
	private IMenuService menuService ;
	
	@Autowired
	private IGrantService grantService;
	
	/**
	 * 用于在树状显示菜单详细信息
	 * @param req
	 * @param rep
	 */
	@RequestMapping(value="/queryMenus")
	public void loadData(HttpServletRequest req,HttpServletResponse rep){
		try {
			PrintWriter out = rep.getWriter();
			MyJson json = new MyJson();
			List<MyInfoDetail> menus= menuService.getMenusByVoDetail();
			String res = "{\"Rows\":"+json.getGridString(menus).replace("nodes", "children").replace(",\"children\":[]", "")+"}";
			System.err.println(res);
			out.println(res);
			out.flush();
			out.close();
		} catch (IOException e) {
			
			e.printStackTrace();
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
	}
	
	/**
	 * 名字模糊查询跳转
	 * @param req request
	 * @param rep response 
	 * @return ModelAndView
	 */
	@RequestMapping(value="/queryLikeForward")
	public String queryMenuLikeForward(@RequestParam("name") String name,HttpServletRequest req){
		req.setAttribute("name", name);
		return "menu_query_like";
	}
	
	
	/**
	 * 名字模糊查询(用于在前台树状显示查询菜单)
	 * @param req request
	 * @param rep response 
	 * @return ModelAndView
	 */
	@RequestMapping(value="/queryLike")
	public void queryMenuLike(@RequestParam("name") String name,HttpServletRequest req,HttpServletResponse rep){
		List<MyInfoDetail> infos = null;
		String res = "";
		try {
			MyJson json = new MyJson();
			if(name==null || name.equals("")){  //没输入关键字
				infos = menuService.getMenusByVoDetail();  //调用获取所有菜单方法
				res = "{\"Rows\":"+json.getGridString(infos).replace("nodes", "children").replace(",\"children\":[]", "")+"}";
			}else{
				//输入关键字
				infos = menuService.getAllParentAndChildMenuByName(name);
				res = "{\"Rows\":"+json.getListRoot(infos).replace("nodes", "children").replace(",\"children\":[]", "")+"}";
			}
			
			
			
			PrintWriter out = rep.getWriter();
			out.println(res);
			out.flush();
			out.close();
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}
	
	/**
	 * 查询所有菜单(用于在前台树状显示所有菜单)
	 * @param req request
	 * @param rep response 
	 * @return ModelAndView
	 */
	@RequestMapping(value="/updateTreeMenuForward")
	public String forwardToUpdateTree(@RequestParam("id") String id,HttpServletRequest req){
		req.setAttribute("id", id);
		return "menu_update_tree";
	}/**
	 * 查询所有菜单(用于在前台树状显示所有菜单)
	 * @param req request
	 * @param rep response 
	 * @return ModelAndView
	 */
	@RequestMapping(value="/queryAll")
	public ModelAndView forwardToMain(HttpServletRequest req,HttpServletResponse rep){
		String menuInfos = "";
		ModelAndView view = new ModelAndView("json");
		List<MyInfoDetail> menus = new ArrayList<>();
		try {
			menus= menuService.getAllChildrenById("0");
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		MyJson json = new MyJson();
		menuInfos = json.toString(0,menus);
		
		view.addObject("menus",menus);
		req.setAttribute("menus", menus);
		
		view.setViewName("menu_query_all");
		return view;
	}
	
	
	/**
	 * 用于删除数据
	 * @param req
	 * @param rep
	 */	
	@RequestMapping(value="/deleteMenu")
	public String deleteMenuOperation(@RequestParam("id") String id,HttpServletRequest req){
		boolean isSuc =false;
		String msg ="删除成功";
		System.err.println("delete "+id);
		try {
			isSuc = menuService.deleteMenu(id);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		if(!isSuc){
			msg = "删除失败";
		}
		req.setAttribute("msg", msg);
		return "menu_query_all";
	}
	
	/**
	 * 用于修改数据
	 * @param req
	 * @param rep
	 */	
	@ResponseBody
	@RequestMapping(value="/updateMenuOpe",produces="text/html;charset=utf-8")
	public String updateMenuOperation(
			@RequestParam("id") String id
			,@RequestParam("pId") String pId
			,@RequestParam("txtName") String menuName
			,@RequestParam("txtIcon") String icon
			,@RequestParam("txtUrl") String url
			,@RequestParam("txtDescription") String description
			,@RequestParam("menuStatus") String menuStatus
			,@RequestParam("sortId") String sortId){
		
			System.err.println("controller sortID"+sortId);
			String msg = "修改成功";
			boolean isSuc = true;
		 	Menu m = new Menu();
		 	m.setMenuId(Integer.parseInt(id));
		 	m.setMenuName(menuName);
		 	m.setMenuIcon(icon+".ico");
		 	m.setMenuUrl(url);
		 	m.setMenuDescription(description);
		 	m.setMenuParent(pId);
		 	m.setMenuStatus(menuStatus);
		 	//修改菜单信息
		 	try {
				isSuc = isSuc && menuService.updateMenuById(id, m);
				
			} catch (Exception e) {
				
				e.printStackTrace();
			}
		 	
		 	
		 	//级联修改菜单排序号
		 	isSuc = isSuc && menuService.updateMenuSortNumDetail(sortId);
		 	
		 	if(!isSuc){
		 		msg = "修改失败";
		 	}
		 	
		 	return msg;
	}
	
	/**
	 * 用于跳转到关联界面
	 * @param req
	 * @param rep
	 */
	@RequestMapping(value="/forwardToRelation")
	public String forwardToRelation(){
		return "menu_relation_permission";
	}
	
	/**
	 * 用于跳转到关联界面
	 * @param req
	 * @param rep
	 */
	@ResponseBody
	@RequestMapping(value="/changeIcon")
	public String changeIcon(){
		return "1.icon";
	}
	
	/**
	 * 用于跳转到树状显示菜单详细信息的弹窗
	 * @param req
	 * @param rep
	 */
	@ResponseBody
	@RequestMapping(value="/addMenuOpe",produces="text/html;charset=utf-8")
	public String addMenuOperation(HttpServletRequest req,HttpServletResponse rep){
		//获取信息
		String name = req.getParameter("txtName");
		String icon = req.getParameter("txtIcon")+".ico";
		String pid = req.getParameter("txtPid");
		String description = req.getParameter("txtDescription");
		String url = req.getParameter("txtUrl");
		String status = req.getParameter("menuStatus");	
		String sortId = req.getParameter("sortId");
		System.err.println("controller "+name);
		//执行添加业务层
		Menu m = new Menu();
		m.setMenuName(name);
		m.setMenuDescription(description);
		m.setMenuParent(pid);
		m.setMenuIcon(icon);
		m.setMenuUrl(url);
		//TODO设置创始人
		m.setMenuCreatedId(1);
		m.setMenuUpdatedId(1);
		m.setMenuStatus(status);
		boolean isSuc = false;
		String msg = "添加成功";
		
		//获取sortID
		
		try {
			 isSuc = menuService.addNewMenu(m,sortId);
			 System.err.println("controller add"+isSuc);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		if(!isSuc){
			msg = "添加失败";
		}
		
		
		System.err.println(msg);
		return msg;
		
	}
	
	/**
	 * 用于跳转到修改菜单的界面弹窗
	 * @param req
	 * @param rep
	 */
	@RequestMapping(value="/menuUpdateLoadForward")
	public String updateMenuShowForward(){
		return "menu_update_show";
	}
	
	/**
	 * 用于跳转到修改菜单的界面弹窗，加载除自己以外的所有对象
	 * @param req
	 * @param rep
	 */
	@RequestMapping(value="/menuUpdateLoad")
	public void updateMenuLoad(@RequestParam("id") String pid,HttpServletResponse rep){
		String res  = null;
		
		System.err.println("ge "+pid);
		try {
			List<MyInfoDetail> details = menuService.getSelectMenu(pid);
			MyJson json = new MyJson();
			
			res = "{\"Rows\":"+json.getListString(details).replace("nodes", "children").replace(",\"children\":[]", "")+"}";
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		try {
			PrintWriter out = rep.getWriter();
			System.err.println("gg"+res);
			out.println(res);
			out.flush();
			out.close();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
	}
	
	
	/**
	 * 用于跳转到修改菜单的界面弹窗
	 * @param req
	 * @param rep
	 */
	@RequestMapping(value="/updateMenuForward")
	public String updateMenuForward(){
		return "menu_update_main";
	}
	
	/**
	 * 通过菜单id获取已有的权限
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/getPermissionByMId",produces="text/html;charset=utf-8")
	public String getExistPermissionByMId(@RequestParam("id") String id){
		MenuPermissionInfo info = new MenuPermissionInfo();
		info.setMenuId(Integer.valueOf(id));
		List<PermissionInfo> infos = grantService.getMenuPermissionByMenuId(info);
		String temp ="";
		for(PermissionInfo p:infos){
			if(p.getPmsnName() != null && !p.getPmsnName().equals("")){
				
				temp = p.getPmsnName();
				if(!temp.contains("-")){
					p.setPmsnName(temp+"-"+p.getPmsnUrl());
					
				}
			}else{
				p.setPmsnName("");
				p.setPmsnUrl("");
			}
			
		}
		String res= JSON.toJSONString(infos).replace("pmsnId", "id")
					.replace("pmsnName", "text")
					.replace(",{\"text\":\"null-null\",\"pmsnUrl\":\"\"}", "")
					.replace("{\"text\":\"null-null\"}", "");
		System.err.println("exist "+res); 
		return res;
	}
	
	/**
	 * 通过菜单id获取没有的权限
	 * @param id 菜单的id
	 * @return String
	 */
	@ResponseBody
	@RequestMapping(value="/loadNoExistPer",produces="text/html;charset=utf-8")
	public String getNoExistPerByMId(@RequestParam("id") String id){
		List<PermissionInfo> infos = grantService.getAllPermission();
		for(PermissionInfo p:infos){
			System.err.println(p.getPmsnUrl());
			p.setPmsnName(p.getPmsnName()+"-"+p.getPmsnUrl());
		}
		String res = JSON.toJSONString(infos).replace("pmsnId", "id")
				.replace("pmsnName", "text").replace(",{\"text\":\"null-null\"}", "");
		System.err.println(res);
		return res;
	}
	
	/**
	 * 通过菜单id获取还没有的权限
	 * @return
	 *//*
	public List<PermissionInfo>  getNoExistPerById(String id){
		MenuPermissionInfo menuPermissionInfo = new MenuPermissionInfo();
		menuPermissionInfo.setMenuId(Integer.valueOf(id));
		List<PermissionInfo> infos = grantService.getAllPermission();
		List<PermissionInfo> existPer = grantService.getMenuPermissionByMenuId(menuPermissionInfo);
		System.err.println("s1 "+infos.size());
		System.err.println("s2 '"+infos.size());
		return infos;
	}
	*/
	
	/**
	 * 用于获取同级别的菜单
	 * @param req
	 * @param rep
	 */
	@RequestMapping(value="/updatePermission",produces = "text/html;charset=utf-8")
	@ResponseBody
	public String updatePermission(@RequestParam("existPers") String existPers,@RequestParam("mId") String mId,@RequestParam("noExistPers")String noExistPers){
		ArrayList<UUIdText> texts = JSON.parseObject(existPers, new TypeReference<ArrayList<UUIdText>>(){}); 
		ArrayList<UUIdText> textNos = JSON.parseObject(noExistPers, new TypeReference<ArrayList<UUIdText>>(){}); 
		String msg= "";
		System.err.println("idwe  "+mId);
		boolean isSuc = menuService.updatePermission(texts, grantService, mId,textNos);
		if(isSuc){
			msg= "授权成功";
			
		}else{
			msg="授权失败";
		}
		return msg;
	}
	
	
	
	/**
	 * 用于获取同级别的菜单
	 * @param req
	 * @param rep
	 */
	@RequestMapping(value="/getELevelMenu",produces = "application/json;charset=utf-8")
	@ResponseBody
	public String getELevelMenu(@RequestParam("id") String id){
		
		System.err.println("   "+id);
		List<MyInfoDetail> infos = menuService.getELevelMenu(id);
		MyJson json = new MyJson();
		String res = json.getListString(infos).replace("nodes", "children").replace(",\"children\":[]", "").replace("name", "text");
		
		System.err.println("获取同等级 "+res);
		return res;
	}
	
	
	/**
	 * 用于跳转到树状显示菜单详细信息的弹窗
	 * @param req
	 * @param rep
	 */
	@RequestMapping(value="/addMenu")
	public String addMenuForward(HttpServletRequest req,HttpServletResponse rep){
		return "menu_add";
	}
}
