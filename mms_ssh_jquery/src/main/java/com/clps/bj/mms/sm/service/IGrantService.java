package com.clps.bj.mms.sm.service;
import java.util.List;
import com.clps.bj.mms.sm.vo.MenuPermissionInfo;
import com.clps.bj.mms.sm.vo.MyInfo;
import com.clps.bj.mms.sm.vo.PermissionInfo;
import com.clps.bj.mms.sm.vo.RoleMenuPermissionInfo;

/**   
 * @ClassName:  IGrantService   
 * @Description:权限逻辑层接口
 * @author:     snow.y
 * @date:       2018年1月23日 上午10:34:18 
 * @version     V 1.0.2
 */
public interface IGrantService {
	/**
	 * 
	 * @Description 				增加权限
	 * @param permossion 	    	权限的vo对象  
	 * @return boolean 				返回true添加成功;返回false添加失败  
	 */
	public boolean addPermission(PermissionInfo permissionInfo);
    /**
     * 
     * @Description 				删除权限
     * @param  permission			权限的vo对象      
     * @return boolean 				返回true删除成功;返回false删除失败
     */
	public boolean deletePermission(PermissionInfo permissionInfo);
    /**
     * 
     * @Description 				修改权限
     * @param permission			权限的vo对象    
     * @return boolean				返回true修改成功;返回false修改失败
     */
	public boolean updatePermission(PermissionInfo permissionInfo);
	/**
	 * 
	 * @Description 				查询一个权限信息
	 * @param id                    权限的vo对象
	 * @return Permission           返回角色菜单权限信息的vo对象
	 */
	public PermissionInfo getPermissionByID(PermissionInfo permissionInfo);
    /**
     * 
     * @Description                  查询所有角色的权限信息
     * @return List<PermissionInfo>  返回所有角色菜单权限vo的列表
     */
	public List<PermissionInfo> getAllPermission();
	/**
	 * 
	 * @Description 				模糊查询
	 * @param permissionInfo		权限vo对象
	 * @return List<PermissionInfo> 权限列表      
	 *
	 */
	public List<PermissionInfo> getSearchPermission(PermissionInfo permissionInfo);
	/**
	 * 
	 * @Description 				查询条数
	 * @return int                  统计条数
	 *
	 */
	public Long getPermissionTotal();
	/**
	 * 
	 * @Description 				   判断是否存在这个权限
	 * @param permossion             权限的vo对象
	 * @return boolean               返回true存在;返回false不存在
	 *
	 */
	public boolean iscontainsPermission(PermissionInfo permissionInfo);
	/**
	 * 
	 * @Description 			             刷新权限缓存
	 *
	 */
	public void flushPermissionCache();
	/**
	 * 
	 * @Description 								增加角色菜单权限关系
	 * @param roleMenuPermissionInfo           		RoleMenuPermissionInfo的vo对象
	 * @return boolean 								返回true添加成功;返回false添加失败     
	 */
	public boolean addRoleMenuPermission(RoleMenuPermissionInfo roleMenuPermissionInfo);
	 /**
	  * 
	  * @Description 								删除角色的菜单权限
	  * @param  roleMenuPermissionInfo  			RoleMenuPermissionInfo的vo对象
	  * @return boolean 							返回true删除成功;返回false删除失败
	  */
	public boolean deleteRoleMenuPermission(RoleMenuPermissionInfo roleMenuPermissionInfo);
	/**
	 * 
	 * @Description 								查询一个菜单的所有权限
	 * @param menuId								菜单id
	 * @param listMp								菜单权限关系列表
	 * @return List<PermissionInfo>       			这个菜单的全部权限
	 *
	 */
	public List<PermissionInfo> getMenuPermissionInfo(Object[] pmsn,Object menuId,List<MenuPermissionInfo> listMp);
      /**
       * 
       * @Description 								修改角色菜单权限
       * @param rmp									RoleMenuPermissionInfo的vo对象
       * @return boolean							返回true修改成功;返回false修改失败
       */
	public boolean updateRoleMenuPermission(RoleMenuPermissionInfo roleMenuPermissionInfo);
	   /**
	    * 
	    * @Description 				   				获取一个角色的所有菜单权限信息
	    * @param roleMenuPermissionInfo	 		    RoleMenuPermissionInfo的vo对象      
	    * @return List<RoleMenuPermissionInfo> 		返归角色菜单权限关系vo对象列表
	    */
	public List<RoleMenuPermissionInfo> getRoleMenuPermissionByRoleId(RoleMenuPermissionInfo roleMenuPermissionInfo);
	   /**
	    * 
	    * @Description 				     			查询所有角色的菜单权限信息s 
	    * @return List<RoleMenuPermissionInfo> 		返回所有角色菜单权限列表
	    */
	public List<RoleMenuPermissionInfo> getAllRoleMenuPermission();
	/**
	 * 
	 * @Description 								查询出角色的所有菜单及其权限
	 * @param roleMenuPermissionInfo				RoleMenuPermissionInfo的vo对象   
	 * @return MyInfo       						封装菜单和权限的对象
	 *
	 */
	public MyInfo getRoleMenusAndPermissions(RoleMenuPermissionInfo roleMenuPermissionInfo);
	public MyInfo getCheckMenu(RoleMenuPermissionInfo roleMenuPermissionInfo);
	
	/**
	 * 
	 * @Description 					  增加菜单权限
	 * @param menuPermissionInfo		  菜单权限关系vo对象
	 * @return boolean       			  返回true,添加成功;返回false,添加失败
	 *
	 */
	public boolean addMenuPermission(MenuPermissionInfo menuPermissionInfo);
	/**
	 * 
	 * @Description 					  删除菜单权限	
	 * @param menuPermissionInfo		  菜单权限关系vo对象
	 * @return boolean       			  返回true,删除成功;返回false,删除失败
	 *
	 */
	public boolean deleteMenuPermission(MenuPermissionInfo menuPermissionInfo);
	/**
	 * 
	 * @Description 					   修改菜单权限
	 * @param menuPermissionInfo		   菜单权限关系vo对象
	 * @return boolean                   返回true,修改成功;返回false,修改失败
	 *
	 */
	public boolean updateMenuPermission(MenuPermissionInfo menuPermissionInfo);
	/**
	 * 
	 * @Description 					    根据主键获取对应菜单权限
	 * @param menuPermissionInfo    	     菜单权限关系vo对象
	 * @return MenuPermissionInfo   	     菜单权限关系vo对象    
	 *
	 */
	public MenuPermissionInfo getMenuPermissionById(MenuPermissionInfo menuPermission);
	/**
	 * 
	 * @Description 					     查询指定菜单的所有权限
	 * @param menuPermissionInfo   		     菜单权限关系vo对象
	 * @return List<PermissionInfo>       权限的vo列表
	 *
	 */
	public List<PermissionInfo> getMenuPermissionByMenuId(MenuPermissionInfo menuPermissionInfo);
	/**
	 * 
	 * @Description 					              查询所有的菜单及其权限
	 * @return Map<Integer,List<PermissionInfo>> 以key为菜单id value为权限vo列表       
	 *
	 */
	public List<MenuPermissionInfo> getAllMenuPermission();
	/**
	 * 
	 * @Description 								查询菜单权限的id
	 * @param menuPermissionInfo					菜单权限vo实体类对象
	 * @return MenuPermissionInfo       			菜单权限vo实体类对象
	 *
	 */
	public MenuPermissionInfo getSearchMenuPmsn(MenuPermissionInfo menuPermissionInfo);
	/**
	 * 
	 * @Description 					判断是否存在菜单权限
	 * @param menuPermissionInfo		菜单权限关系vo对象
	 * @return boolean                  返回true,已存在关系;返回false,不存在这个关系   
	 *
	 */
	public boolean iscontainsMenuPermission(MenuPermissionInfo menuPermissionInfo);
	/**
	 * 
	 * @Description 					刷新菜单权限缓存     
	 *
	 */
	public void flushMenuPermissionCache();
	
}
