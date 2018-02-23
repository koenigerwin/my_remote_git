package com.clps.bj.mms.sm.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.clps.bj.mms.common.util.factory.UtilFactory;
import com.clps.bj.mms.constant.TimeFormatConstant;
import com.clps.bj.mms.sm.entity.Role;
import com.clps.bj.mms.sm.entity.UserInfoMain;
import com.clps.bj.mms.sm.service.IRoleService;
import com.clps.bj.mms.sm.service.IUserInfoMainService;
import com.clps.bj.mms.sm.vo.IdText;
import com.clps.bj.mms.sm.vo.RoleVo;
import com.clps.bj.mms.sm.vo.UserInfoVo;

/**
 *@Description：role控制层    数据合法性在页面判定  减轻服务端压力
 *@className：RoleController
 *@author bai
 *@version v1.0
 *@date 2018年1月26日 下午4:09:39
*/
@Controller
@RequestMapping("sm/role")
public class RoleController{
	
	@Autowired
	private IRoleService service;
	@Autowired
	private IUserInfoMainService userservice;
	private UserInfoMain user;
	
	/**
	 *查询所有角色并跳转到角色列表界面
	 */
	@RequestMapping("/role_list")
	public ModelAndView queryRoleName() {
		List<Role> rolelist = service.queryAllRoleName();
		List<RoleVo> rolevolist = service.putRoleToVo(rolelist);
		List<UserInfoVo> userlist = userservice.getAllUserInfoMainVo();
		String rolejson = JSON.toJSONString(rolevolist);
		String userjson = JSON.toJSONString(userlist);
		String roleStr="{Rows:"+rolejson+"}";
		String userStr="{Rows:"+userjson+"}";
		ModelAndView mad=new ModelAndView("role_list");
		mad.addObject("roles", roleStr);
		mad.addObject("users", userStr);
		return mad;
	}
	/**
	 *跳转到添加角色界面
	 */
	@RequestMapping("/goaddrole")
	public String goaddRole() {
		return "role_add";
	}
	/**
	 *添加角色
	 */
	@RequestMapping("/role_add")
	public void addRole(HttpServletRequest request,HttpServletResponse response,String roleName,String roleIcon,String roleDescription) {
		Boolean result=false;
		
		Role role=new Role();
		role.setRoleCreatedUserId(user.getUserId());
		role.setRoleCreatedDatetime(UtilFactory.getInstanceOfDate().getNowStr(TimeFormatConstant.Y_M_D_H_M_S));
		role.setRoleUpdatedDatetime(UtilFactory.getInstanceOfDate().getNowStr(TimeFormatConstant.Y_M_D_H_M_S));
		role.setRoleUpdatedUserId(user.getUserId());
		role.setRoleName(roleName);
		role.setRoleIcon(roleIcon);
		role.setRoleDescription(roleDescription);
		try{
			 result = service.addRole(role);
		}catch (Exception e) {
			try {
				response.getWriter().write("新增失败");
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
		if(result) {
			try {
				response.getWriter().write("新增成功");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}else {
			try {
				response.getWriter().write("新增失败");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	/**
	 *删除角色
	 */
	@RequestMapping("/role_delete")
	public void deleterole(HttpServletResponse response,int roleId) {
		boolean result=false;
		result = service.deleteRole(roleId);
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
	 *修改角色
	 */
	@RequestMapping("/role_update")
	public void updateRole(HttpServletRequest request,HttpServletResponse response,Role role) {
		boolean result=false;
		user=(UserInfoMain)request.getSession().getAttribute("user");
		role.setRoleUpdatedDatetime(UtilFactory.getInstanceOfDate().getNowStr(TimeFormatConstant.Y_M_D_H_M_S));
		role.setRoleUpdatedUserId(user.getUserId());
		System.out.println(role.getRoleUpdatedDatetime());
		try{
			result = service.updateRole(role,role.getRoleId());
		}catch (Exception e) {
			try {
				response.getWriter().write("修改失败");
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
		if(result) {
			try {
				response.getWriter().write("修改成功");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}else {
			try {
				response.getWriter().write("修改失败");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	/**
	 *跳转到修改角色界面
	 */
	@RequestMapping("/goupdaterole")
	public ModelAndView goupdaterole(int roleId) {
		ModelAndView mad=new ModelAndView("role_update");
		Role role = service.queryRoleName(roleId);
		String jsonString = JSON.toJSONString(role);
		mad.addObject("roleStr", jsonString);
		return mad;
	}
	/**
	 *跳转到批量添加角色界面
	 */
	@RequestMapping("/gorolelistadd")
	public ModelAndView gorolelistadd() {
		ModelAndView mad=new ModelAndView("role_list_add");
		List<Role> rolelist = service.queryAllRoleName();
		String jsonString = JSON.toJSONString(rolelist).replace("\"roleName\"", "text").replace("\"roleId\"", "id");
		mad.addObject("rolejson", jsonString);
		
		
		List<UserInfoMain> noroleusers = userservice.getUserInfoMainByRoleId(null);
		
		JSONArray jsonArray = new JSONArray();
		for(UserInfoMain userinfomain:noroleusers) {
		     JSONObject obj = new JSONObject();
		     //listbox对应的数据格式要有text、id字段
		     obj.put("id",userinfomain.getUserId());
		     obj.put("text",userinfomain.getUserName());
		     jsonArray.add(obj);
		   }
		mad.addObject("userjson", jsonArray);
		return mad;
	}
	/**
	 *显示对应角色用户列表
	 */
	@RequestMapping("/showusers")
	@ResponseBody
	public JSONArray showusers(HttpServletResponse response,int roleId) {
		List<UserInfoMain> userstring = userservice.getUserInfoMainByRoleId(roleId);
		JSONArray jsonArray = new JSONArray();
			for(UserInfoMain userinfomain:userstring) {
			     JSONObject obj = new JSONObject();
			     //listbox对应的数据格式要有text、id字段
			     obj.put("id",userinfomain.getUserId());
			     obj.put("text",userinfomain.getUserName());
			     jsonArray.add(obj);
			   }
			return jsonArray;
	}	
	@RequestMapping("/updateuserrole")
	public void updateuserrole(HttpServletResponse response,Integer roleId,String selected,String noselected) {
		ArrayList<IdText> selectedlist = JSON.parseObject(selected, new TypeReference<ArrayList<IdText>>(){});  
		ArrayList<IdText> noselectedlist = JSON.parseObject(noselected, new TypeReference<ArrayList<IdText>>(){});
		for(IdText i:selectedlist) {
			userservice.updateuserrole(roleId, i.getId());
		}
		for(IdText i:noselectedlist) {
			userservice.updateuserrole(null, i.getId());
		}
		try {
			response.getWriter().write("操作成功");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	@RequestMapping("/validate")
	public void validate(HttpServletResponse response,String roleName) {
		List<Role> list = service.queryAllRoleName();
		for(Role role:list) {
			if(role.getRoleName().equals(roleName)) {
				try {
					response.getWriter().write("角色名已存在，请重新输入");
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
