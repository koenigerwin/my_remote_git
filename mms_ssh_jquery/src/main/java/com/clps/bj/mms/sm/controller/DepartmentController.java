/** 
 * Project Name:mms_ssh(springmvc+spring+hibernate) 
 * File Name:UserController.java 
 * Package Name:com.clps.bj.mms.sm.controller 
 * Date:2018年1月29日 下午3:44:33 
 * Copyright (c) 2018, erwin.wang@clpsglobal.com All Rights Reserved. 
 * 
 */
package com.clps.bj.mms.sm.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.clps.bj.mms.common.util.data.MyJson;
import com.clps.bj.mms.constant.DepartmentConstant;
import com.clps.bj.mms.sm.entity.Department;
import com.clps.bj.mms.sm.service.IDepartmentService;
import com.clps.bj.mms.sm.service.IUserInfoMainService;
import com.clps.bj.mms.sm.vo.DeptInfo;
import com.clps.bj.mms.sm.vo.IdText;
import com.clps.bj.mms.sm.vo.UserInfoVo;

/** 
 * ClassName: DepartmentController <br/> 
 * date: 2018年1月29日 下午3:44:33  <br/> 
 * 
 * @author Kyoma.yu
 * @version 0.0.1V 
 * @since JDK 1.8 
 */
@Controller
@RequestMapping(value="/sm/dept")
public class DepartmentController {
	@Resource
	private IDepartmentService departmentService;
	@Resource
	private IUserInfoMainService userInfoMainService;
	@Resource
	private  HttpServletRequest req;
	@Resource
	private  HttpServletResponse rep;
	
	/**
	 * 进入dept页面
	 */
	@RequestMapping(value="/deptMain")
	public String deptMain(){
		return "dept_main";
	}
	
	/**
	 * 进入dept_add页面
	 */
	@RequestMapping(value="/deptAddMain")
	public ModelAndView deptAddMain(){
		ModelAndView mad = new ModelAndView("dept_add");
		List<UserInfoVo> list = userInfoMainService.getAllLeadingPerVo(DepartmentConstant.manager);
		List<IdText> voList = new ArrayList<>();
		for(UserInfoVo vo : list){
			IdText info = new IdText(vo.getUserId(),vo.getUserName());
			voList.add(info);
		}
		String str = JSON.toJSONString(voList);
		mad.addObject("manager",str);
		return mad;
	}
	
	@RequestMapping(value="/findAll")
	public ModelAndView findAll(){
		ModelAndView mad = new ModelAndView("dept_main");
		String deptInfos = "";
		List<DeptInfo> depts = new ArrayList<>();
		depts = departmentService.getDeptByVo();
		MyJson json = new MyJson();
		deptInfos = json.getGridString2(depts);
		String res = "{\"Rows\":["+deptInfos.replace("nodes", "children").replace(",\"children\":[]", "")+"]}";
		List<UserInfoVo> vo = userInfoMainService.getAllUserInfoMainVo();
		String str1 = "{\"Rows\":"+JSON.toJSONString(vo)+"}";
		mad.addObject("dept", res);
		mad.addObject("user", str1);
		return mad;
	}
	
	/**
	 * 弹出添加部门页面
	 */
	@RequestMapping(value="/addDept",produces ="application/json; charset=utf-8")
	public @ResponseBody String addDept(){
		String deptInfos = "";
		List<DeptInfo> depts = new ArrayList<>();
		depts = departmentService.getDeptByCombo();
		MyJson json = new MyJson();
		deptInfos = json.getComboString(depts);
		String res = "["+deptInfos.replace(",\"children\":[]", "")+"]";
		return res;
	}
	
	/**
	 * 弹出修改部门页面
	 */
	@RequestMapping(value="/getUpdateDeptInfo")
	public ModelAndView updateDeptInfo(@RequestParam("id") String id){
		ModelAndView modelAndView = new ModelAndView("dept_update");
		Department dept = departmentService.getDeptById(Integer.parseInt(id));
		Department Pdept = departmentService.getDeptById(dept.getDeptParentId());
		modelAndView.addObject("pid",Pdept.getDeptId());
		modelAndView.addObject("pname","\""+Pdept.getDeptName()+"\"");
		modelAndView.addObject("id",dept.getDeptId());
		modelAndView.addObject("name","\""+dept.getDeptName()+"\"");
		modelAndView.addObject("ab","\""+dept.getDeptAb()+"\"");
		List<UserInfoVo> list = userInfoMainService.getAllLeadingPerVo(DepartmentConstant.manager);
		List<IdText> voList = new ArrayList<>();
		for(UserInfoVo vo : list){
			IdText info = new IdText(vo.getUserId(),vo.getUserName());
			voList.add(info);
			if(vo.getUserId() == Integer.parseInt(dept.getDeptDefault1())){
				modelAndView.addObject("managerName","\""+vo.getUserName()+"\"");
			}
		}
		String str = JSON.toJSONString(voList);
		modelAndView.addObject("hr",str);
		modelAndView.addObject("managerId","\""+Integer.parseInt(dept.getDeptDefault1())+"\"");
		return modelAndView;
	}
	
	/**
	 * 弹出修改部门页面
	 */
	@RequestMapping(value="/getupdateDeptTree",produces ="application/json; charset=utf-8")
	public @ResponseBody String getupdateDeptTree(){
		String deptInfos = "";
		List<DeptInfo> depts = new ArrayList<>();
		depts = departmentService.getDeptByCombo();
		MyJson json = new MyJson();
		deptInfos = json.getComboString(depts);
		String res = "["+deptInfos.replace(",\"children\":[]", "")+"]";
		return res;
	}
	
	/*
	 * 返回下拉框树形数据
	 * */
	@RequestMapping(value="/findCombo")
	public void findCombo(){
		String deptInfos = "";
		List<DeptInfo> depts = new ArrayList<>();
		depts = departmentService.getDeptByCombo();
		MyJson json = new MyJson();
		deptInfos = json.getComboString(depts);
		String res = deptInfos.replace(",\"children\":[]", "");
		PrintWriter out;
		try {
			out = rep.getWriter();
			out.println(res);
			out.flush();
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	/**
	 * 添加部门
	 */
	@RequestMapping(value="/subDept",method=RequestMethod.POST)
	public @ResponseBody boolean subDept(DeptInfo deptInfo){
		Department dept = departmentService.infoToDept(deptInfo);
		return departmentService.addDepartment(dept);
		
	}
	/**
	 * 修改部门
	 */
	@RequestMapping(value="/updateDept",method=RequestMethod.POST)
	public @ResponseBody boolean  updateDept(DeptInfo deptInfo){
		Department dept = departmentService.infoToDept(deptInfo);
		return departmentService.updateDepartment(dept);
	}
	
	/**
	 * 删除部门
	 */
	@RequestMapping(value="/deleteDept",method=RequestMethod.POST)
	public String deleteDept(String id){
		departmentService.deleteDepartment(Integer.parseInt(id));
		return "redirect:findAll";
	}
	
	/**
	 * 获取部门和其子部门的id
	 */
	@RequestMapping(value="/findParentAndChildrenDeptId",method=RequestMethod.POST)
	public @ResponseBody List<Integer> findParentAndChildrenDeptId(String deptId){
		return departmentService.getParentAndChildrenDepartmentId(Integer.parseInt(deptId));
	}

	/**
	 * 获取负责人名单
	 */
	@RequestMapping(value="/getManager",method=RequestMethod.POST)
	public @ResponseBody String getManager(){
		userInfoMainService.getAllLeadingPerVo("");
		return null;
	}
}
 