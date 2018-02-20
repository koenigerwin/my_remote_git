/**
 * 
 */
package com.clps.bj.mms.sm.dao.impl;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.clps.bj.mms.common.util.data.MyDate;
import com.clps.bj.mms.common.util.factory.PaginationFactory;
import com.clps.bj.mms.common.util.factory.UtilFactory;
import com.clps.bj.mms.common.util.pagination.dao.PaginationDao;
import com.clps.bj.mms.common.util.pagination.dao.impl.PaginationDaoImpl;
import com.clps.bj.mms.common.util.pagination.model.PageBean;
import com.clps.bj.mms.constant.TimeFormatConstant;
import com.clps.bj.mms.sm.dao.MenuDao;
import com.clps.bj.mms.sm.dao.MenuHql;
import com.clps.bj.mms.sm.entity.Menu;




/**
 * 菜单dao实现类
 * Name:MenudaoImpl
 * Function: 增加菜单，删除菜单，修改菜单，查询菜单
 * Reason:	 Arraylist<Menu>, Menu,boolean 
 * Date:     2017年12月22日
 * @author   ygg 
 * 	 
 */
@Repository
@SuppressWarnings({ "unchecked", "static-access" })
public class MenuDaoImpl implements MenuDao, MenuHql{

	private SessionFactory sessionFactory;      //会话工厂
	private Object[] args;           			//参数列表
	private Menu menu;             				//菜单对象
	private List<Menu> menus;  					//要返回的对象集合
	private boolean isSuc ;    					//是否成功
	private MyDate dateFactory;         		//返回工具的工厂
	private PaginationFactory<Menu> pageFactory;  //分页工厂
	private PaginationDao<Menu> pageMenu;         //分页工具
	private String[] orders = {"menu_id"};                //排序字段
	private Session session;                      //会话
	private Query query;                         //获取查询对象
	private Logger logger ;                     //日志对象
	{
		
		
		dateFactory = UtilFactory.getInstanceOfDate();
		
		logger = Logger.getLogger(MenuDaoImpl.class);
		//myLog4j = UtilFactory.getInstanceOfLog4J();
		pageMenu = pageFactory.getInstanceOfPagination();
		
	}
	
	
	/**
	 * @return the sessionFactory
	 */
	public final SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	/**
	 * @param sessionFactory the sessionFactory to set
	 */
	@Autowired
	public final void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	
	private Session getSession() throws Exception{
		if(sessionFactory==null){
			throw new Exception("获取SessionFactory获取失败");
		}else{
			if(session != null && session.isOpen()){
				
			}else{
				session = sessionFactory.getCurrentSession();
			}
		}
		return session;
	}
	/* (non-Javadoc)
	 * @see com.clps.dev.mms.sm.menu.dao.Menudao#getMenuById(java.lang.Integer)
	 */
	@Override
	public Menu getMenuById(Integer menu_id) throws Exception {
		
		session = getSession();
		args = new Object[]{menu_id};
		
		query = getQuery(session, queryMenuById, args);
		
			
			this.menu = (Menu) query.uniqueResult();
		
			session.flush();
		return this.menu;
				
	}
	
	/**
	 * 获取查询hql对象
	 * @param session 要查询的会话
	 * @param hql hql语句
	 * @param objs 参数填充数组
	 * @return Query
	 */
	private Query getQuery(Session session,String hql,Object[] args){
		
		Query  query = session.createQuery(hql);
		for(int i=0,length=args.length;i<length;i++){
			query.setParameter((i), args[i]);
		}
		
		return query;
	}

	/* (non-Javadoc)
	 * @see com.clps.dev.mms.sm.menu.dao.Menudao#getAllParentAndChildMenuById(java.lang.String)
	 */
	@Override
	public List<Menu> getAllParentAndChildMenuById(int id) throws Exception {
		session = getSession();
		args = new Object[]{id,id};
		
		query = getQuery(session, queryParentAndChildMenuById, args);
		
		menus = query.list();
		
		return menus;
	}
	
	
	

	/* (non-Javadoc)
	 * @see com.clps.dev.mms.sm.menu.dao.Menudao#isTopParentMenu(com.clps.dev.mms.sm.menu.model.Menu)
	 */
	@Override
	public boolean isTopParentMenu(String name) throws Exception {
		
		session = getSession();
		args = new Object[]{name};
		
		query = getQuery(session, queryParentByName, args);
		menu = (Menu) query.uniqueResult();
		
		
		return (menu!=null);
	}

	

	/* (non-Javadoc)
	 * @see com.clps.dev.mms.sm.menu.dao.Menudao#getAllParentAndChildMenuByName(java.lang.String)
	 */
	@Override
	public List<Menu> getAllParentAndChildMenuByName(String name) throws Exception {
		String names = "%"+name+"%";
		args = new Object[]{names,names};
		session = getSession();
		query = getQuery(session, queryParenAndChildMenuByName, args);
		menus = query.list();
		
		return menus;
	}

	/* (non-Javadoc)
	 * @see com.clps.dev.mms.sm.menu.dao.Menudao#getAllParentAndChildMenuById()
	 */
	/* (non-Javadoc)
	 * @see com.clps.dev.mms.sm.menu.dao.impl.PersonServic#getAllParents()
	 */
	@Override
	public List<Menu> getAllParents() throws Exception {
		session = getSession();
		args = new Object[]{};
		query = getQuery(session, queryAllParents, args);
		menus = query.list();
		
		return menus;
	}
	
	/* (non-Javadoc)
	 * @see com.clps.dev.mms.sm.menu.dao.Menudao#getMenus()
	 */
	@Override
	public List<Menu> getMenus() throws Exception {
		session = getSession();
		args = new Object[]{};
		
		query = getQuery(session, queryAllMenus, args);
		menus = query.list();
		
		
		return menus;
	}
	

	

	

	/* (non-Javadoc)
	 * @see com.clps.dev.mms.sm.menu.dao.Menudao#updateMenuByName(java.lang.String)
	 */
	@Override
	public boolean updateMenuById(String id,Menu m) throws Exception  {
		isSuc = false;
		Menu menuTemp = getMenuById(Integer.parseInt(id));
	
		
		menuTemp.setMenuUpdatedDatetime(dateFactory.getNowStr(TimeFormatConstant.Y_M_D_H_M_S));
		menuTemp.setMenuParent(m.getMenuParent());
		menuTemp.setMenuDescription(m.getMenuDescription());
		menuTemp.setMenuName(m.getMenuName());
		menuTemp.setMenuIcon(m.getMenuIcon());
		menuTemp.setMenuUrl(m.getMenuUrl());
		menuTemp.setMenuNlevel(getLevel(m.getMenuParent()));
		menuTemp.setMenuStatus(m.getMenuStatus());
		menuTemp.setMenuSortId(getSortID(m));
		menuTemp.setMenuSortNum(String.valueOf(m.getMenuSortNum()));
		
		
		session = getSession();
		
		session.update(menuTemp);
			
		updateSortIdWhenUpdate(session, menuTemp);
		isSuc = true;

		
		return isSuc;
		
	}
	
	/**
	 * 修改sortId
	 * @param session 会话
	 * @param deleteMenu 删除
	 * @return boolean
	 */
	public boolean updateSortIdWhenUpdateDetail(Session session,Menu deleteMenu){
		boolean isSuc =false;
		String sortId = getSortID(deleteMenu);
		deleteMenu.setMenuSortId(sortId);
		
		session.update(deleteMenu);
		
		
		isSuc =true;
		return isSuc;
	}
	
	/**
	 * 通过id返回该菜单的所有子类id
	 * @param id
	 * @return List<Menu> 
	 * @throws Exception 
	 */
	public List<Menu> getAllChildById(String id) throws Exception{
	
		args = new Object[]{id};
		session = getSession();
		query = getQuery(session, queryAllChildById, args);
		
		List<Menu> menuTemps = query.list();
		
		return menuTemps;
	}
	
	/**
	 * 修改sort_id实现方法
	 * @param session session会话
	 * @param deleteMenu 要删除的菜单
	 * @return boolean
	 * @throws Exception 
	 */
	public boolean updateSortIdWhenUpdate(Session session,Menu deleteMenu) throws Exception{
		boolean isSuc = false;
		List<Menu> menuTemps = getAllChildById(String.valueOf(deleteMenu.getMenuId()));
		if(menuTemps != null && !menuTemps.isEmpty()){
			for(Menu m:menuTemps){
				updateSortIdWhenUpdateDetail(session, m);		//修改自己的sortid
				updateSortIdWhenUpdate(session, m);             //有子级菜单递归进行修改子级的sortId			
			}
		}else{
			
			updateSortIdWhenUpdateDetail(session, deleteMenu);		
		}
		
		isSuc = true;
		return isSuc;
	}
	
	/**
	 * 查询所有出自己和父类菜单的菜单列表
	 * @param String id 要查询的菜单id
	 * @return List<Menu> 
	 * @throws Exception 
	 */
	public List<Menu> getSelectMenu(String id) throws Exception{
		session = getSession();
		args = new Object[]{"%"+id+"%"};
		Query query = getQuery(session, queryOtherMenu, args);
		
		List<Menu> menuTemps = query.list();
		
		return menuTemps;
		
	}
	
	
	/**
	 * 获取排序id
	 * @param id 要获取排序号的菜单对象
	 * @return String 
	 */
	public String getSortID(Menu menu){
		String res = "";
		String tempPid= menu.getMenuParent();
		if(tempPid!= null && !tempPid.equals("")){
			Menu m = null;
			try {
				m = getMenuById(Integer.parseInt(tempPid));
			} catch (Exception e) {
				
				e.printStackTrace();
			}
			if(m!= null){
				res = m.getMenuSortId();
			}else{
				res =","+ menu.getMenuId();
			}
			res +=","+ menu.getMenuId();
		}else{
			res =","+ menu.getMenuId();
		}
		
		
		return res;
	}
	
	/**
	 * 获取应该修改的对象的等级
	 * @param m 父类的id
	 * @return int  
	 */
	private int getLevel(String  m){
		int res = 0;
		if(m != null && !m.equals("")){
			
			Menu parentMenu;
			try {
				parentMenu = getMenuById(Integer.parseInt(m));
				
				res =  parentMenu.getMenuNlevel()+1;
			} catch (Exception e) {
				
				e.printStackTrace();
			}
		}
		System.err.println("nLevel"+res);
		return res;
		
	}
	
	
	/* (non-Javadoc)
	 * @see com.clps.dev.mms.sm.menu.dao.Menudao#addNewMenu(com.clps.dev.mms.sm.menu.model.Menu)
	 */
	@Override
	public boolean addNewMenu(Menu m) throws Exception {
		m.setMenuNlevel(getLevel(m.getMenuParent()));
		System.err.println("dw ew"+m.getMenuName());
		m.setMenuName(m.getMenuName());
		m.setMenuSortId("1");
		m.setMenuSortNum("-1");
		m.setMenuUpdatedDatetime(dateFactory.getNowStr(TimeFormatConstant.Y_M_D_H_M_S));
		m.setMenuCreatedDatetime(dateFactory.getNowStr(TimeFormatConstant.Y_M_D_H_M_S));
		m.setMenuStatus("1");
		session = getSession();
		if(session != null){
			

			session.save(m);
			
			
			isSuc = true;
		}else{
			isSuc = false;
			throw new Exception("获取session失败失败");
		}
		if(isSuc){
			m = getMenuByName(m.getMenuName());
			m.setMenuSortId(getSortID(m));
			
			//修改排序号
			if(session != null && !session.isOpen()){
				System.err.println(session.isOpen());

				
			}

			session.update(m);
			
			
		}else{
			
			throw new Exception("添加失败，主键找不到");
		}
		System.err.println("daoImp add"+isSuc);
		return isSuc;
	}
	/**
	 * 通过菜单id设置排序号
	 * @param id 要修改的菜单id
	 * @return String
	 */
	private String getSortNum(String id){
		List<Menu> menusTemp = getELevelMenu(id);
		String sortNum = menus.get(menusTemp.size()-1).getMenuSortNum();
		return String.valueOf(Integer.valueOf(sortNum)+1);
	}

	/* (non-Javadoc)
	 * @see com.clps.dev.mms.sm.menu.dao.MenuDao#getMenuByName(java.lang.String)
	 */
	@Override
	public Menu getMenuByName(String name) throws Exception {		
		session = getSession();
		args = new Object[]{name};
		query = getQuery(session, queryMenuByName, args);
		menu = (Menu) query.uniqueResult();
		return menu;
	}
	
	/* (non-Javadoc)
	 * @see com.clps.dev.mms.sm.menu.dao.MenuDao#setActiveOrForbidden(java.lang.String, java.lang.String)
	 */
	@Override
	public boolean deleteMenuByID(String id) throws Exception {
		isSuc = false;
		args = new Object[]{id};
		
		//menu.setRoleMenu(null);
		
		menus = getAllParentAndChildMenuById(Integer.valueOf(id));
		//isSuc = deleteChildrenMenu(menus, session, String.valueOf(id));
		boolean isSuc = false;
		for(Menu menuTemp:menus){
			
			
					try {
						session = getSession();
			
						session.delete(menuTemp);
						
					} catch (Exception e) {
						
						e.printStackTrace();
					}
				
				
		}		
		isSuc = true;
		return isSuc;
	}

	


	
	
	/**
	 * 在删除的时候修改sortId
	 * @param menus
	 * @param id
	 * @return
	 */
	public boolean  deleteChildrenMenu(List<Menu> menus,Session session,String id){
		boolean isSuc = false;
		for(Menu menuTemp:menus){
			
			if(menuTemp.getMenuSortId().contains(id)){
				if(session ==null || !session.isOpen()){
					try {
						session = getSession();
			
						session.delete(menuTemp);
						
					} catch (Exception e) {
						
						e.printStackTrace();
					}
				}
				
			}
			
			
		}
		
		isSuc = true;
		return isSuc;
	}
	
	

	/* (non-Javadoc)
	 * @see com.clps.dev.mms.sm.menu.dao.MenuDao#getCount()
	 */
	
	
	@Test
	public void testQueryMenusByPage(){
		try {
			logger.info(getCount());
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}

	/* (non-Javadoc)
	 * @see com.clps.bj.mms.sm.dao.MenuDao#getCount(java.lang.String)
	 */
	
	/* (non-Javadoc)
	 * @see com.clps.bj.mms.sm.dao.MenuDao#getCount()
	 */
	@Override
	public BigInteger getCount() throws Exception {
		args = new Object[]{};
		session = getSession();
		SQLQuery query = session.createSQLQuery(countSizeSql);
		
		BigInteger count = (BigInteger) query.uniqueResult();
		return count;
	}

	

	/* (non-Javadoc)
	 * @see com.clps.dev.mms.sm.menu.dao.MenuDao#getMenuByPage()
	 */
	@Override
	public PageBean<Menu> getMenuByPage(int curPage,int pageSize) {
		int len = 0;
		try {
			len = getCount().intValue();
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		PageBean<Menu> menuPage = new PageBean<Menu>(curPage,pageSize , len);
		pageMenu = new PaginationDaoImpl<>();
		args = new Object[]{};
		pageMenu.getQueryByHibernateHQl(session, queryAllMenus, orders, args, menuPage);		
		return menuPage;
	}

	@Override
	public List<Menu> getELevelMenu(String id) {
		try {
			
			int tempId = Integer.parseInt(id);
			args = new Object[]{tempId};
			session = getSession();
			query = getQuery(session, queryElevelMenuById, args);
			menus  = query.list();
			
			return menus;
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		
		return null;
	}
}
