/**
 * 
 */
package com.clps.bj.mms.sm.dao;


import java.math.BigInteger;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.clps.bj.mms.common.util.pagination.model.PageBean;
import com.clps.bj.mms.sm.entity.Menu;


/**
 * Name:MenuDAO
 * Function: 对menu模块进行操作. 
 * Reason:	 Menu boolean  
 * Date:     2017年12月22日
 * @author   ygg 
 * 	 
 */ 

public interface MenuDao {
	/**
	 * 通过menu_id查询menu所有可用对象
	 * @param id 要查询的id
	 * @return Menu 返回查找到的menu对象 
	 * @throws Exception 
	 */
	public Menu getMenuById(Integer menu_id) throws Exception;
	
	/**
	 * 查询所有除指定菜单以外的父类菜单和子类菜单
	 * @param id 要查询的id
	 * @return List<Menu>
	 * @throws Exception
	 */
	public List<Menu> getSelectMenu(String id) throws Exception;
	
	
	/**
	 * 通过menu_name查询menu所有可用对象
	 * @param name 要查询的name
	 * @return Menu 返回查找到的menu对象 
	 * @throws Exception 
	 */
	public Menu getMenuByName(String name) throws Exception;
	
	
	/**
	 * 通过id查找到id相等的menu对象极其子类
	 * @param id  要查找的对象的id
	 * @return  List<Menu> 查找到的所有的子父类集合
	 * @throws Exception 
	 */
	public List<Menu> getAllParentAndChildMenuById(int id) throws Exception;
	
	
	/**
	 * 通过name查找到name相等的menu对象极其子类树状存储用map返回
	 * @param name  要查找的对象的name
	 * @return  List<Menu> 查找到的所有的子父类集合
	 *//*
	public Map<String,Menu> getAllParentAndChildMenuByNameTree(String name);
	*/
	
	/**
	 * 通过id返回该菜单的所有子类id
	 * @param id
	 * @return List<Menu> 
	 * @throws Exception 
	 */
	public List<Menu> getAllChildById(String id) throws Exception;
	
	/**
	 * 判断一个菜单是否为顶层菜单
	 * @param menu 要判断的对象
	 * @return boolean 是否是顶层父类
	 * @throws Exception 
	 */
	public boolean isTopParentMenu(String name) throws Exception;
	
	/**
	 * 删除菜单
	 * @param name 要操作的menu
	 * @return boolean 是否成功
	 * @throws Exception 
	 */
	public boolean deleteMenuByID(String name) throws Exception;
	
	
	/**
	 * 通过name查找到name相等的menu对象极其子类
	 * @param id  要查找的对象的id
	 * @return  List<Menu> 查找到的所有的子父类集合
	 * @throws Exception 
	 */
	public List<Menu> getAllParentAndChildMenuByName(String name) throws Exception;
	
	/**
	 * 查找所有的顶级菜单
	 * 
	 * @return  List<Menu> 查找到的所有的父类集合
	 * @throws Exception 
	 */
	public List<Menu> getAllParents() throws Exception;
	
	/**
	 * 获取所有的菜单
	 * @return List<MenuDAO> 所有菜单的集合
	 * @throws Exception 
	 */
	public List<Menu> getMenus() throws Exception;
	
	

	
	
	/**
	 * 修改名字为指定id的menu对象
	 * @param id 修改的菜单的id
	 * @param m  要修改成的菜单
	 * @return boolean 是否修改成功
	 * @throws Exception 
	 */
	public boolean updateMenuById(String id,Menu m) throws Exception;
	
	
	
	
	
	/**
	 * 添加一个新的menu对象
	 * @param menu 要填加的对象
	 * @return  boolean  是否添加成功
	 * @throws Exception 
	 */
	public boolean addNewMenu(Menu menu) throws Exception;
	
	
	/**
	 * 获取所有记录数
	 * @param String sql 语句
	 * @return int
	 * @throws Exception 
	 */
	public BigInteger getCount() throws Exception;
	
	/**
	 * 分页显示菜单数据
	 * @return PageBean<Menu>
	 */
	public PageBean<Menu> getMenuByPage(int curPage,int pageSize);
	
	/**
	 * 获取同级别的菜单
	 * @return List<Menu>
	 */
	public List<Menu> getELevelMenu(String id);
	
}
