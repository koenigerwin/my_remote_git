/**
 * 
 */
package com.clps.bj.mms.sm.service;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import com.clps.bj.mms.common.util.pagination.model.PageBean;
import com.clps.bj.mms.sm.dao.MenuDao;
import com.clps.bj.mms.sm.dao.impl.MenuDaoImpl;
import com.clps.bj.mms.sm.entity.Menu;
import com.clps.bj.mms.sm.vo.MenuPermissionInfo;
import com.clps.bj.mms.sm.vo.MenuPermissionMVo;
import com.clps.bj.mms.sm.vo.MyInfo;
import com.clps.bj.mms.sm.vo.MyInfoDetail;
import com.clps.bj.mms.sm.vo.PermissionInfo;
import com.clps.bj.mms.sm.vo.UUIdText;




/**
 * 
 * @description：菜单逻辑业务层接口
 * @className：IMenuService
 * @author ygg
 * @version V1.0.0
 * 2018年1月22日 下午午13:22:52
 */



public interface IMenuService {
	
	
	
	/**
	 * 返回vo对象
	 * @return 
	 * @throws Exception
	 */
	public List<MyInfo> getMenusByVo() throws Exception;
	
	
	/**
	 * 
	 * @Description:获取==通过id获取指定菜单
	 * @param userId
	 * @return Integer
	 * @throws Exception 
	 *
	 */
	public Menu getMenuById(Integer id) throws Exception;
	
	/**
	 * 查询除指定菜单外的所有子菜单父类菜单
	 * @param id 要查询的菜单id
	 * @return List<Menu>
	 * @throws Exception
	 */
	public List<MyInfoDetail> getSelectMenu(String id) throws Exception;
	
	/**
	 * 获取所有的menu的细节vo
	 * @return  List<Menu> 所有的menu对象的集合
	 * @throws Exception 
	 */
	public List<MyInfoDetail> getMenusByVoDetail() throws Exception;
	
	/**
	 * @Description:通过name获取指定菜单
	 * @param name 要查找的name
	 * @return Menu
	 * @throws Exception 
	 */
	public Menu getMenuByName(String name) throws Exception;
	
	/**
	 * @Description:通过id获取菜单父菜单及其所有子菜单
	 * @param i 要查找的id
	 * @return ArrayList<Menu> 要返回的父菜单及子菜单
	 * @throws Exception 
	 */
	public List<Menu> getAllParentAndChildMenuById(int i) throws Exception;
	
	/**
	 * @param String id 要查找子类的菜单的id
	 * @return List<Menu>
	 * @throws Exception 
	 */
	public List<MyInfoDetail> getAllChildrenById(String id) throws Exception;
	
	
	/**
	 * @Description:是否为顶层类
	 * @param i 要查找的id
	 * @return boolean 是否为顶层类
	 * @throws Exception 
	 */
	public boolean isTopParentMenu(String name) throws Exception;
	
	/**
	 * @Description:通过名字获取父菜单和相关的所有子菜单
	 * @param name 要查询的name
	 * @return List<Menu> 通过名字获取的父类和相关的所有子类的列表
	 * @throws Exception 
	 */
	public List<MyInfoDetail> getAllParentAndChildMenuByName(String name) throws Exception;
	
	
	
	
	/**
	 * @Description:获取所有的父类菜单
	 * @return List<Menu> 获取所有的父类菜单
	 * @throws Exception 
	 */
	public List<Menu> getAllParents() throws Exception;
	
	/**
	 * @Description:获取所有的menu
	 * @return  List<Menu> 所有的menu对象的集合
	 * @throws Exception 
	 */
	public List<Menu> getMenus() throws Exception;
	
	/**
	 * @Description:修改菜单对象
	 * @param id 要被修改的对象的id
	 * @param m 要修改的对象的值
	 * @return boolean 是否修改成功
	 * @throws Exception 
	 */
	public boolean updateMenuById(String id,Menu m) throws Exception;
	
	
	

	
	/**
	 * @Description:添加菜单对象
	 *
	 * @param m 要添加的对象的值
	 * @param sortIds 排好序的菜单id
	 * @return boolean 是否添加成功
	 * @throws Exception 
	 */
	public boolean addNewMenu(Menu m,String sortIds) throws Exception;
	/**
	 * @Description:删除菜单
	 * @param name 要激活或禁用的name
	 * @param isActive 是否激活
	 * @return boolean  激活是否成功
	 * @throws Exception 
	 */
	public boolean deleteMenu(String id) throws Exception;
	
	/**
	 * 返回记录数
	 * @return Integer
	 * @throws Exception
	 */
	public BigInteger getCount() throws Exception;
	
	
	/**
	 * @Description:获取树状图
	 * @param m 要显示的树状图
	 * @return String 
	 */
	public String getTreeMenuString(Menu m);
	
	
	
	/**
	 * @Description:分页查询所有菜单
	 * @return PageBean<Menu>
	 */
	public PageBean<Menu> getMenuByPage(int curPage,int pageSize);

	/**
	 * 获取同级别的菜单
	 * @param id 要查询的id
	 * @return  List<MyInfoDetail>
	 */
	public List<MyInfoDetail> getELevelMenu(String id);
	
	/**
	 * 修改权限
	 * @param texts 传递过来的，修改后的数据
	 * @param grantService 权限业务层
	 * @param mid        菜单id'
	 * @param textNos   不存在权限的数据
	 * @return boolean
	 */
	public boolean updatePermission(List<UUIdText> texts,IGrantService grantService,String mid, List<UUIdText> textNos);

	
	
	/**
	 * 修改排序号
	 * @param sortId 修改后的排序号集合
	 * @return String
	 */
	public boolean updateMenuSortNumDetail(String sortId);
}
