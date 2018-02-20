/**
 * 
 */
package com.clps.bj.mms.sm.service.impl;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.math.BigInteger;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSON;
import com.clps.bj.mms.common.util.data.MyDate;

import com.clps.bj.mms.common.util.data.MyLog4J;
import com.clps.bj.mms.common.util.data.Node;
import com.clps.bj.mms.common.util.factory.PaginationFactory;
import com.clps.bj.mms.common.util.factory.UtilFactory;
import com.clps.bj.mms.common.util.pagination.dao.PaginationDao;
import com.clps.bj.mms.common.util.pagination.model.PageBean;
import com.clps.bj.mms.sm.entity.Menu;
import com.clps.bj.mms.sm.service.IMenuService;
import com.clps.bj.mms.sm.vo.MenuPermissionInfo;
import com.clps.bj.mms.sm.vo.MenuPermissionMVo;
import com.clps.bj.mms.sm.vo.MyInfo;
import com.clps.bj.mms.sm.vo.MyInfoDetail;
import com.clps.bj.mms.sm.vo.PermissionInfo;


/**
 * 测试菜单业务类
 * Name:TestUtilFactoryJDBC
 * Function: 菜单逻辑业务层测试类 
 * Reason:	 菜单逻辑业务层测试类 
 * Date:     2017年12月25日
 * author   ygg 
 * 	 
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:beans.xml"})
@Transactional
public class MenuServiceImplTest {
	@Resource
	private IMenuService menuService;       //菜单业务层
	private Menu menu;                    //要返回的菜单
	private List<Menu> menus ;        //要返回的菜单列表
	private boolean isTrue;           //boolean参数
	private Logger logger;             //log4j日志
	private MyDate dateFactory;        //日期工具类
	@SuppressWarnings("unused")
	private PaginationDao<Menu> menuPage;          //分页工具类
	
	@Before
	public void init(){
		//menuService = new MenuServiceImpl();
		//menus = new ArrayList<>();
		logger = Logger.getLogger(MenuServiceImplTest.class);
		//dateFactory = UtilFactory.getInstanceOfDate();
		//menuPage = PaginationFactory.getInstanceOfPagination();
		//myLog4J.setLogProperty(size, count);
		//myLog4J.setSysPath("Z:\\log");
	}
	
	
	
	/**
	 * 通过id获取所有的子菜单和父菜单
	 */
	@Test
	public void testGetAllParentAndChildMenuById(){
		try {
			menus = menuService.getAllParentAndChildMenuById(1);
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		for(Menu menu:menus){
			logger.info(menu.getMenuId());
			
		}
	}
	
	
	
	/**
	 * 通过name获取所有的子菜单和父菜单
	 */
	@Test
	public void testGetAllParentAndChildMenuByName(){
		try {
			
			List<MyInfoDetail> details = menuService.getAllParentAndChildMenuByName("用户");
			for(MyInfoDetail m:details){
				logger.info(m.getId());
			}
		
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		
	}
	
	
	
	/**
	 * 测试是否为顶层类
	 */
	@Test
	public void testIsTopParentMenu(){
		
		 String se = "用户面板";
		 try {
			isTrue = menuService.isTopParentMenu(se);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		 logger.info(isTrue);
		assertTrue(isTrue);
		se = "用户登录";
		try {
			isTrue = menuService.isTopParentMenu(se);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		logger.info(isTrue);
		assertFalse(isTrue);
		
	}
	
	
	/**
	 * 测试通过id修改菜单
	 */
	@Test
	public void testUpdateMenuById(){
		menu = new Menu();
		menu.setMenuId(2);
		menu.setMenuName("用户登录");
		menu.setMenuUrl("../user/user_index123233233.html");
		menu.setMenuIcon("a.jpg");
		menu.setMenuParent("1");
		menu.setMenuDescription("用户登录");
		//menu.setMenu_sort_id(",1");
		//menu.setMenu_nlevel(0);
		menu.setMenuStatus("1");
		
		//menu.setMenu_parent("1");
		//menu.setMenu_created_Datetime("2017-12-26");
		
		menu.setMenuCreatedId(1);
		menu.setMenuUpdatedId(1);
		try {
			isTrue = menuService.updateMenuById(String.valueOf(menu.getMenuId()), menu);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		if(isTrue){
			
			logger.info(menu.getMenuCreatedDatetime());
		}
		
	}
	
	/**
	 * 测试通过name获取菜单
	 */
	@Test
	public void testGetMenuByName(){
		try {
			menu = menuService.getMenuByName("用户模版");
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		logger.info(menu.getMenuName());
	}
	
	/**
	 * 测试获取所有父类
	 */
	@Test
	public void testGetAllParents(){
		try {
			menus = menuService.getAllParents();
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		for(Menu m:menus){
			if(m != null){
				logger.info(m.getMenuName());
			}
		}
	}
	
	/**
	 * 测试获取所有菜单
	 */
	@Test
	public void testGetMenus(){
		try {
			menus = menuService.getMenus();
			Node n = new Node();
			MyInfo info = null;
			/*List<MyInfo> infos = new ArrayList<>();
			for(Menu m:menus){
				info =new MyInfo();
				info.setId(m.getMenuId());
				info.setName(m.getMenuName());
				info.setSortId(m.getMenuSortId());
				info.setUrl(m.getMenuUrl());
				infos.add(info);
			}
			HashMap<String,List<MyInfo>>  maps= n.getTreeStruct(infos);
			List<MyInfo> newInfos = n.getTreeStructById("2", maps, "3");*/
			logger.info("                gg                   ");
			/*for(MyInfo inf :newInfos){
				logger.info(inf.getId());
			}*/
			
			for(Menu m :menus){
				logger.info(m.getMenuId());
			}
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		/*for(Menu m:menus){
			if(m != null){
				logger.info(m.getMenuName());
			}
		}*/
	}
	
	
	@Test
	public void testGetMenusByVo(){
		try {
			List<MyInfo>  infos= menuService.getMenusByVo();
			Node n = new Node();
			
			logger.info("               ");
			
			for(MyInfo m :infos){
				logger.info(m.getId());
			}
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		/*for(Menu m:menus){
			if(m != null){
				logger.info(m.getMenuName());
			}
		}*/
	}
	
	/**
	 * 测试新加菜单
	 */
	@Test
	public void testAddNewMenu(){
		menu = new Menu();
		//menu.setMenu_parent(nu);
		menu.setMenuName("用户修改信息122");
		menu.setMenuUrl("../user/user_infor_63633.html");
		menu.setMenuIcon("a.jpg");
		menu.setMenuCreatedId(1);
		menu.setMenuUpdatedId(1);
		//menu.setMenuUpdatedId(1);
		//menu.setmenu
		menu.setMenuDescription("用户修改信息1232");
		//menu.setMenu_sort_id(",1,8");
		menu.setMenuNlevel(0);
		//menu.setMenu_is_enable("1");
		
		
		menu.setMenuCreatedId(1);
		menu.setMenuUpdatedId(1);
		boolean isSuc = false;
		try {
			//isSuc = menuService.addNewMenu(menu);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		logger.info(isSuc);
	}
	
	
	
	/**
	 * 测试日期工具类
	 */
	@Test
	public void testDate(){
		try {
			//String se = dateFactory.dateToString(dateFactory.getNowDate(), "YYYY-MM-dd");
			logger.info(dateFactory.StringToDate("2017-12-25", "YYYY-MM-DD"));
		} catch (ParseException e) {
			
			logger.info(e.getMessage());
		}
	}
	/**
	 * 测试删除菜单
	 */
	@Test
	public void testDelete(){
		String id ="2";
		try {
			isTrue = menuService.deleteMenu(id);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		assertTrue(isTrue);
	}
	
	
	/**
	 * 测试获取数据
	 */
	@Test
	public void testCount(){
		try {
			BigInteger i =menuService.getCount();
			logger.info(i);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}
	
	/**
	 * 测试分页查询
	 */
	@Test
	public void testQueryMenusByPage(){
		PageBean<Menu>  pageBean= menuService.getMenuByPage(1, 3);
		menus =  pageBean.getDataList();
		logger.info("                          ");
		for(Menu m:menus){
			logger.info(m.getMenuId());
		}
		
	}
	@Test
	public void testGetOtherMenu(){
		try {
			List<MyInfoDetail> menus = menuService.getSelectMenu("2");
			logger.info("gg");
			logger.info("                        ");
			for(MyInfoDetail m:menus){
				logger.info(m.getId());
			}
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}
	

}
