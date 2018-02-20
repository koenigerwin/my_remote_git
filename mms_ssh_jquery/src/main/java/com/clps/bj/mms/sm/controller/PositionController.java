package com.clps.bj.mms.sm.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.clps.bj.mms.common.util.data.MyJson;
import com.clps.bj.mms.sm.entity.Position;
import com.clps.bj.mms.sm.service.IPositionService;
import com.clps.bj.mms.sm.service.IUserInfoMainService;
import com.clps.bj.mms.sm.vo.PositionInfo;
import com.clps.bj.mms.sm.vo.UserInfoVo;

/**
 * 
 * @description：职位控制层
 * @className：PositionController
 * @author gg Yang
 * @version V1.0.0
 * @date 2018年2月2日下午4:09:12
 */
@Controller
@RequestMapping(value="/sm/position")
public class PositionController {
	@Autowired
	private IPositionService positionService ;
	
	@Autowired
	private IUserInfoMainService userInfoMainService;
	
	/**
	 * 用于跳转到显示职位主界面
	 * 
	 * 
	 */
	
	@RequestMapping(value="/getPositionsForward")
	public String getPositionForward(){
		return "position_query_all";
	}
	
	/**
	 * 用于在显示职位详细信息
	 * @param req
	 * @param rep
	 */
	@ResponseBody
	@RequestMapping(value="/getPositionsDetail",produces = "text/json;charset=utf-8")
	public String getPositionsDetail(@RequestParam() String pId){
		String res = "";
		List<UserInfoVo> userInfos = new ArrayList<>();
		try {
			
			MyJson json = new MyJson();			
			System.err.println(pId);
			List<UserInfoVo> vo = userInfoMainService.getAllUserInfoMainVo();
			for(UserInfoVo info:vo){
		
				
				if(info.getPostionId().equals(Integer.valueOf(pId))){
					userInfos.add(info);
					
					
				}
			}
			
			res = "{\"Rows\":"+json.getStringExportParamDetail(userInfos)+"}";
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		return res;
	}
	/**
	 * 用于在显示职位详细信息
	 * @param req
	 * @param rep
	 */
	@ResponseBody
	@RequestMapping(value="/getPositions",produces = "text/json;charset=utf-8")
	public String getPositions(){
		String res = "";
		try {
			
			MyJson json = new MyJson();
			List<PositionInfo> positions= positionService.getAllPositionsVo();
			
			res = "{\"Rows\":"+json.getStringExportParam(positions)+"}";
			
		} catch (IOException e) {
			
			e.printStackTrace();
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		return res;
	}
	
	/**
	 * 名字模糊查询跳转
	 * @param req request
	 * @param rep response 
	 * @return ModelAndView
	 *//*
	@RequestMapping(value="/queryLikeForward")
	public String queryMenuLikeForward(@RequestParam("name") String name,HttpServletRequest req){
		req.setAttribute("name", name);
		return "menu_query_like";
	}
	
	
	*//**
	 * 名字模糊查询(用于在前台树状显示查询职位)
	 * @param req request
	 * @param rep response 
	 * @return ModelAndView
	 *//*
	@RequestMapping(value="/queryLike")
	public void queryMenuLike(@RequestParam("name") String name,HttpServletRequest req,HttpServletResponse rep){
		List<MyInfoDetail> infos = null;
		String res = "";
		try {
			MyJson json = new MyJson();
			if(name==null || name.equals("")){  //没输入关键字
				infos = positionService.getMenusByVoDetail();  //调用获取所有职位方法
				res = "{\"Rows\":"+json.getGridString(infos).replace("nodes", "children").replace(",\"children\":[]", "")+"}";
			}else{
				//输入关键字
				infos = positionService.getAllParentAndChildMenuByName(name);
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
	
	*//**
	 * 跳转到添加职位界面
	 * 
	 * 
	 * 
	 */
	@RequestMapping(value="/addPositionForward")
	public String forwardToAddPosition(){
		
		return "position_add";
	}
	
	
	/**
	 * 执行添加职位操作
	 * 
	 * 
	 * 
	 */
	@ResponseBody
	@RequestMapping(value="/addPositionOpe",produces = "text/html;charset=utf-8")
	public String addPositionOpe( Position position,Model model){
		String msg = "添加失败";
		
		//TODO 需要从登录用户查询登录名
		position.setPositionCreatedId(1);
		position.setPositionUpdatedId(1);
		
		
		boolean isSuc = false;
		try {
			isSuc = positionService.addPosition(position);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		if(isSuc){
			msg = "添加成功";
		}
		model.addAttribute("msg",msg);
		return msg;
		
	}
	
	
	
	/**
	 * 用于删除数据
	 * @param req
	 * @param rep
	 */	
	
	@RequestMapping(value="/deletePosition",produces = "text/html;charset=utf-8")
	public String deleteMenuOperation(@RequestParam("id") String id,Model model){
		boolean isSuc =false;
		String msg ="删除失败";
		try {
			isSuc = positionService.deletePositionById(Integer.valueOf(id));
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		if(isSuc){
			msg = "删除成功";
		}
		model.addAttribute("msg",msg);
		
		return "position_query_all";
	}
	
	/**
	 * 用于修改数据
	 * @param req
	 * @param rep
	 */	
	@ResponseBody
	@RequestMapping(value="/updatePositionOpe",produces = "text/html;charset=utf-8")
	public String updateMenuOperation(Position position){
			
			String msg = "修改成功";
			
			//TODO 通过用户id
			position.setPositionUpdatedId(1);
		 	
			boolean b = false;
		 	try {
		 		
				b = positionService.updatepositionById(position);
				
			} catch (Exception e) {
				
				e.printStackTrace();
			}
		 	if(!b){
		 		msg = "修改失败";
		 	}
		 	
		 	return msg;
	}	
	
	/**
	 * 用于跳转到修改职位的界面弹窗
	 * @param req
	 * @param rep
	 */
	@RequestMapping(value="/updatePositionForward")
	public String updateMenuForward(){
		return "position_update_main";
	}
	
}
