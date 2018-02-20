/**
 * 
 */
package com.clps.bj.mms.sm.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.clps.bj.mms.common.util.factory.UtilFactory;
import com.clps.bj.mms.sm.constant.Gender;
import com.clps.bj.mms.sm.entity.Department;
import com.clps.bj.mms.sm.entity.Position;
import com.clps.bj.mms.sm.entity.Role;
import com.clps.bj.mms.sm.entity.UserInfoDetail;
import com.clps.bj.mms.sm.entity.UserInfoMain;
import com.clps.bj.mms.sm.service.IDepartmentService;
import com.clps.bj.mms.sm.service.IPositionService;
import com.clps.bj.mms.sm.service.IRoleService;
import com.clps.bj.mms.sm.service.IUserInfoDetailService;
import com.clps.bj.mms.sm.service.IUserInfoMainService;
import com.clps.bj.mms.sm.vo.IdText;
import com.clps.bj.mms.sm.vo.UserInfoVo;


/**
 * @Description
 * @author jiangying
 * @Since V1.0.0
 * 2018年2月4日下午2:26:04
 */
@Controller
@RequestMapping("sm/userinfo")
public class UserInfoController {
	@Autowired
	private IUserInfoMainService userMainService;
	@Autowired
	private IUserInfoDetailService userInfoDetailService;
	@Autowired
	private IRoleService roleService;
	@Autowired
	private IPositionService postionService;
	@Autowired
	private IDepartmentService deptService;
	
	
	@RequestMapping("/showusers")
	public ModelAndView showAllUsers(){
		List<UserInfoVo> uservo = userMainService.getAllUserInfoMainVo();
		String userjson = JSON.toJSONString(uservo);
		String userStr="{Rows:"+userjson+"}";
		ModelAndView mad=new ModelAndView("user_list");
		mad.addObject("users", userStr);
		return mad;
	}
	
	/**
	 *跳转到添加用户界面
	 */
	@RequestMapping("/goadduser")
	public ModelAndView goaddUser() {
		/***********************返回角色列表********************************/
		List<Role> roles = roleService.queryAllRoleName();
		ModelAndView mad=new ModelAndView("user_add");
		JSONArray jsonArray1 = new JSONArray();
		for(Role role:roles) {
		     JSONObject obj = new JSONObject();
		     //listbox对应的数据格式要有text、id字段
		     obj.put("id",role.getRoleId());
		     obj.put("text",role.getRoleName());
		     jsonArray1.add(obj);
		   }
		mad.addObject("rolejson", jsonArray1);
		/***********************返回职位列表********************************/
		try {
			List<Position> postions = postionService.queryAllpositions();
			
			JSONArray jsonArray2 = new JSONArray();
			for(Position position:postions) {
			     JSONObject obj = new JSONObject();
			     //listbox对应的数据格式要有text、id字段
			     obj.put("id",position.getPositionId());
			     obj.put("text",position.getPositionName());
			     jsonArray2.add(obj);
			   }
			mad.addObject("positionjson", jsonArray2);
			
		} catch (Exception e) {
		
			e.printStackTrace();
		}
		/************************返回部门列表*****************************/
		List<Department> depts = deptService.getParents();
		JSONArray jsonArray3 = new JSONArray();
		for(Department dept:depts) {
		     JSONObject obj = new JSONObject();
		     //listbox对应的数据格式要有text、id字段
		     obj.put("id",dept.getDeptId());
		     obj.put("text",dept.getDeptName());
		     jsonArray3.add(obj);
		   }
		mad.addObject("deptjson", jsonArray3);
		
		return mad;
	}
	
		
	/**
	 *添加用户
	 */
	/**
	 * @param request
	 * @param response
	 * @param userName
	 * @param userLogon
	 * @param userPassword
	 * @param userEmail
	 * @param userGender
	 * @param userMobile
	 * @param userPhone
	 * @param userLevel
	 * @param userDescritpion
	 * @param userBirth
	 * @param userWeixin
	 * @param userIcon
	 * @param deptId
	 * @param positionId
	 * @param roleId
	 */
	@RequestMapping(value="/user_add",method=RequestMethod.POST)
	//String userName,String userLogon,String userPassword,String userEmail,Gender userGender,String userMobile,String userPhone,String userLevel,String userDescritpion,String userBirth,String userWeixin,String userIcon,Integer userCreatedName,Department deptId,Position positionId,Role roleId
	public @ResponseBody boolean addRole(UserInfoVo user) {
		
		Integer deptId = user.getDeptId();
		Integer positionId = user.getPostionId();
		Integer roleId = user.getRoleId();
		String userBirth = user.getUserBirth();
		String userCreatedDateTime = user.getUserCreatedDatetime();
		Integer userCreatedName = user.getUserCreatedName();
		String userDescription = user.getUserDescription();
		String userEmail = user.getUserEmail();
		Gender userGender = user.getUserGender();
		String userIcon = user.getUserIcon();
		
		String userLogon = user.getUserLogon();
		String userMobile = user.getUserMobile();
		String userName = user.getUserName();
		String userPassword = user.getUserPassWord();
		String userPhone = user.getUserPhone();
		String userWeixin = user.getUserWeiXin();
		
		
	
		
		UserInfoMain userMain=new UserInfoMain();
		/*Integer userId = userMain.getUserId();*/
		UserInfoDetail userdetail = new UserInfoDetail();
		/*userdetail.setUserId(userId);*/
				
		userMain.setUserStatus(0);
		userMain.setUserName(userName);
		userMain.setUserLogon(userLogon);
		userMain.setUserPassword(userPassword);
		userMain.setUserEmail(userEmail);
		
		userdetail.setUserGender(userGender);
		userdetail.setUserMobile(userMobile);
		userdetail.setUserPhone(userPhone);
		
		userdetail.setUserDescritpion(userDescription);
		userdetail.setUserBirth(userBirth);
		userdetail.setUserIcon(userIcon);
		userdetail.setUserWeixin(userWeixin);
		userMain.setUserCreatedDatetime(UtilFactory.getInstanceOfDate().getNowStr());		
		userMain.setUserCreatedName(1);
		userMain.setUserLogon(userLogon);
		userMain.setUserEmail(userEmail);
		userMain.setUserPassword(userPassword);
		
		Role role = roleService.queryRoleName(roleId);
		Department dept = deptService.getDeptById(deptId);
		Position position;
		try {
			position = postionService.queryPositionById(positionId);
			userMain.setDeptId(dept);
			userMain.setPositionId(position);
			userMain.setRoleId(role);
			
		
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		Integer userId = userMainService.addUserInfoMainReturnId(userMain);
		userdetail.setUserId(userId);
		Boolean result2 = userInfoDetailService.addUserInfoDetail(userdetail);
		
		return result2;
		
	}
	
	/**
	 *删除角色
	 */
	@RequestMapping("/user_delete")
	public void deleterole(HttpServletResponse response,int userId) {
		boolean result = userMainService.deleteUserMain(userId);
		if(result) {
			try {
				response.getWriter().write("删除成功");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}else {
			try {
				response.getWriter().write("删除失败");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	/**
	 *修改用户
	 */
	@RequestMapping("/userinfo_update")
	public void updateUserInfo(HttpServletRequest request,HttpServletResponse response,UserInfoMain user) {
		user.setUserCreatedDatetime(UtilFactory.getInstanceOfDate().getNowStr());
		user.setUserCreatedName(1);
		boolean result = userMainService.updateUserMain(user);
		if(result) {
			try { 
				response.getWriter().write("1");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}else {
			try {
				response.getWriter().write("2");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	/**
	 *跳转到修改用户界面
	 */
	@RequestMapping("/goupdateuserinfo")
	public ModelAndView goupdaterole(HttpServletResponse response,int userId) {
		ModelAndView mad=new ModelAndView("userinfo_update");
		UserInfoMain user= userMainService.getUserInfoMain(userId);
		String jsonString = JSON.toJSONString(user);
		mad.addObject("userStr", jsonString);
		return mad;
	}
	
}
