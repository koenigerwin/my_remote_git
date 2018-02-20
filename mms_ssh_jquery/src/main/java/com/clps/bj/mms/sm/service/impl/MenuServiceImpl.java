/**
 * 
 */
package com.clps.bj.mms.sm.service.impl;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import com.clps.bj.mms.common.util.data.MyDate;
import com.clps.bj.mms.common.util.factory.UtilFactory;
import com.clps.bj.mms.common.util.pagination.model.PageBean;
import com.clps.bj.mms.constant.TimeFormatConstant;
import com.clps.bj.mms.sm.dao.MenuDao;
import com.clps.bj.mms.sm.dao.MenuPermissionDao;
import com.clps.bj.mms.sm.dao.impl.MenuDaoImpl;
import com.clps.bj.mms.sm.entity.Menu;
import com.clps.bj.mms.sm.entity.MenuPermission;
import com.clps.bj.mms.sm.entity.MenuTest;
import com.clps.bj.mms.sm.entity.Permission;
import com.clps.bj.mms.sm.service.IGrantService;
import com.clps.bj.mms.sm.service.IMenuService;
import com.clps.bj.mms.sm.vo.MenuPermissionInfo;
import com.clps.bj.mms.sm.vo.MenuPermissionMVo;
import com.clps.bj.mms.sm.vo.MyInfo;
import com.clps.bj.mms.sm.vo.MyInfoDetail;
import com.clps.bj.mms.sm.vo.PermissionInfo;
import com.clps.bj.mms.sm.vo.UUIdText;





/**
 * 
 * @description：菜单逻辑业务层接口实现类
 * @className：IMenuService
 * @author ygg
 * @version V1.0.0
 * 2018年1月22日 下午午13:30:52
 */


@Service
public class MenuServiceImpl implements IMenuService{
	@Resource
	private MenuDao menuDao;   //MenuDao实例
	

	private List<Menu> menus;   //要返回的menu集合
	private boolean isTrue;      //boolean返回值
	{
		
		menus = new ArrayList<>();
	}
	
	
	
	

	
	
	/**
	 * 获取==通过id获取指定菜单
	 * @param id 要查找的id
	 * @return Menu
	 * @throws Exception 
	 */
	public Menu getMenuById(Integer id) throws Exception{
		Menu menu= menuDao.getMenuById(id);
		return menu; 
		
	}
	
	/**
	 * 通过name获取指定菜单
	 * @param name 要查找的name
	 * @return Menu
	 * @throws Exception 
	 */
	public Menu getMenuByName(String name) throws Exception{
		Menu menu= menuDao.getMenuByName(name);
		return menu; 
		
	}
	
	/**
	 * 通过id获取菜单父菜单及其所有子菜单
	 * @param i 要查找的id
	 * @return ArrayList<Menu> 要返回的父菜单及子菜单
	 * @throws Exception 
	 */
	public List<Menu> getAllParentAndChildMenuById(int i) throws Exception{
		menus = menuDao.getAllParentAndChildMenuById(i);
		return menus;
	}
	
	/**
	 * 是否为顶层类
	 * @param i 要查找的id
	 * @return boolean 是否为顶层类
	 * @throws Exception 
	 */
	public boolean isTopParentMenu(String name) throws Exception{
		isTrue = menuDao.isTopParentMenu(name);
		//System.out.println(isTrue);
		return isTrue;
	}
	
	/**
	 * 修改Permission
	 * @param texts 要修改的权限
	 * @return boolean 
	 */
	public boolean updatePermission(List<UUIdText> texts){
		boolean isSuc = false;
		
		isSuc =true;
		return isSuc;
	}
	
	/**
	 * 通过名字获取父菜单和相关的所有子菜单
	 * @param name 要查询的name
	 * @return List<Menu> 通过名字获取的父类和相关的所有子类的列表
	 * @throws Exception 
	 */
	public List<MyInfoDetail> getAllParentAndChildMenuByName(String name) throws Exception{
		menus = menuDao.getAllParentAndChildMenuByName(name);
		List<MyInfoDetail> infos = putDataToVo(menus);
		return infos;
	}
	
	/**
	 * 获取所有的父类菜单
	 * @return List<Menu> 获取所有的父类菜单
	 * @throws Exception 
	 */
	public List<Menu> getAllParents() throws Exception{
		menus = menuDao.getAllParents();
		return menus;
	}
	
	/**
	 * 获取所有的menu
	 * @return  List<Menu> 所有的menu对象的集合
	 * @throws Exception 
	 */
	public List<Menu> getMenus() throws Exception{
		menus = menuDao.getMenus();
		return menus;
	}
	
	
	
	/**
	 * 获取所有的menu的细节vo
	 * @return  List<Menu> 所有的menu对象的集合
	 * @throws Exception 
	 */
	private List<MyInfoDetail> putDataToVo(List<Menu> infos) throws Exception{		
		List<MyInfoDetail> myinfos = new ArrayList<>();
		MyInfoDetail myInfo = null;
		for(Menu m:infos){
			
			myInfo = new MyInfoDetail();
			myInfo.setSortNum(m.getMenuSortNum());
			myInfo.setnLevel(m.getMenuNlevel());
			myInfo.setId(m.getMenuId());
			myInfo.setName(m.getMenuName());
			myInfo.setUrl(m.getMenuUrl());
			myInfo.setDescription(m.getMenuDescription());
			myInfo.setIcon(m.getMenuIcon());
			myInfo.setStatus(m.getMenuStatus());
			myInfo.setSort(m.getMenuSortId());
			String pid = m.getMenuParent();
			
			
			if(pid == null){
				
				myInfo.setPid(null);
			}else{
				
				myInfo.setPid(Integer.parseInt(pid));
			}
			
			myinfos.add(myInfo);
		}
		
		return myinfos;
	}
	
	
	
	
	/**
	 * 获取所有的menu的细节vo
	 * @return  List<Menu> 所有的menu对象的集合
	 * @throws Exception 
	 */
	public List<MyInfoDetail> getMenusByVoDetail() throws Exception{
		menus = menuDao.getMenus();
		
		List<MyInfoDetail> myinfos = new ArrayList<>();
		MyInfoDetail myInfo = null;
		for(Menu m:menus){
			
			myInfo = new MyInfoDetail();
			myInfo.setSortNum(m.getMenuSortNum());
			myInfo.setId(m.getMenuId());
			myInfo.setName(m.getMenuName());
			myInfo.setUrl(m.getMenuUrl());
			myInfo.setDescription(m.getMenuDescription());
			myInfo.setIcon(m.getMenuIcon());
			myInfo.setStatus(m.getMenuStatus());
			myInfo.setnLevel(m.getMenuNlevel());
			myInfo.setSort(m.getMenuSortId());
			String pid = m.getMenuParent();
			
			
			if(pid == null){
				
				myInfo.setPid(null);
			}else{
				
				myInfo.setPid(Integer.parseInt(pid));
			}
			
			myinfos.add(myInfo);
		}
		
		return myinfos;
	}
	
	
	/**
	 * 获取所有的menu
	 * @return  List<Menu> 所有的menu对象的集合
	 * @throws Exception 
	 */
	public List<MyInfo> getMenusByVo() throws Exception{
		menus = menuDao.getMenus();
		
		List<MyInfo> myinfos = new ArrayList<>();
		MyInfo myInfo = null;
		for(Menu m:menus){
			
			myInfo = new MyInfo();
			myInfo.setSortNum(m.getMenuSortNum());
			myInfo.setId(m.getMenuId());
			myInfo.setName(m.getMenuName());
			myInfo.setUrl(m.getMenuUrl());
			myInfo.setSort(m.getMenuSortId());
			String  pid = m.getMenuParent();
			if(pid == null){
				
				myInfo.setPid(null);
			}else{
				
				myInfo.setPid(Integer.parseInt(pid));
			}
			
			myinfos.add(myInfo);
		}
		
		return myinfos;
	}
	
	/**
	 * 修改菜单对象
	 * @param id 要被修改的对象的id
	 * @param m 要修改的对象的值
	 * @return boolean 是否修改成功
	 * @throws Exception 
	 */
	public boolean updateMenuById(String id,Menu m) throws Exception{
		isTrue = menuDao.updateMenuById(id, m);
		return isTrue;
	}
	
	/**
	 * 修改排序号
	 * @param sortId 修改后的排序号集合
	 * @return String
	 */
	public boolean updateMenuSortNumDetail(String sortId){
			
			boolean isSuc = true;
		 	String[] sortIds = sortId.split(",");
			int length = sortIds.length;
			String str = "";
			System.err.println("elngth "+length);
			//级联更新菜单排序号
			for(int i=0;i<length;i++){
				str = sortIds[i];
				isSuc = isSuc && updateMenuSortNum(str,String.valueOf(i+1));
			}
			return isSuc;
			
	}
	

	
	/**
	 * 添加菜单对象
	 *
	 * @param m 要添加的对象的值
	 * @return boolean 是否添加成功
	 * @throws Exception 
	 */
	public boolean addNewMenu(Menu m,String sortIds) throws Exception{
		isTrue = menuDao.addNewMenu(m); 
		if(sortIds != null && !sortIds.equals("")){
			updateMenuSortNumDetail(sortIds);
			
		}
		System.err.println("service "+isTrue);
		return isTrue;
	}
	/**
	 * 
	 * @param name 要激活或禁用的name
	 * @param isActive 是否激活
	 * @return boolean  激活是否成功
	 * @throws Exception 
	 */
	public boolean deleteMenu(String id) throws Exception{
		isTrue = menuDao.deleteMenuByID(id);
		return isTrue;
	}
	
	
	/**
	 * 获取树状图
	 * @param m 要显示的树状图
	 * @return String 
	 */
	public String getTreeMenuString(Menu m){
		String resStr = "";
		String splitStr = m.getMenuSortId();
		String[] splitStrs = splitStr.split(",");
		int i = 1;
		int len = splitStrs.length;
		System.out.println(len);
		for(;i<len;i++){
			resStr += "\t";
		}
		return resStr;
	}
	
	
	
	/**
	 * 分页查询所有菜单
	 * @return PageBean<Menu>
	 */
	public PageBean<Menu> getMenuByPage(int curPage,int pageSize){
		return menuDao.getMenuByPage(curPage, pageSize);
	}

	/* (non-Javadoc)
	 * @see com.clps.bj.mms.sm.service.IMenuService#getCount()
	 */
	@Override
	public BigInteger getCount() throws Exception {
		
		return menuDao.getCount();
	}

	@Override
	public List<MyInfoDetail> getSelectMenu(String id) throws Exception {
		List<Menu> lists = menuDao.getSelectMenu(id);
		//System.err.println(lists.get(0).getMenuId());
		List<MyInfoDetail> details = putDataToVo(lists);
		System.err.println(details.get(0).getId());
		return details;
	}

	@Override
	public List<MyInfoDetail> getAllChildrenById(String id) throws Exception {
		List<Menu> menusTemp = menuDao.getAllChildById(id);
		List<MyInfoDetail> details = new ArrayList<>();
		for(Menu m:menusTemp){
			MyInfoDetail detail = new MyInfoDetail();
			detail.setId(m.getMenuId());
			detail.setName(m.getMenuName());
			detail.setDescription(m.getMenuDescription());
			detail.setIcon(m.getMenuIcon());
			String  pid = m.getMenuParent();
			if(pid == null){
				
				detail.setPid(null);
			}else{
				
				detail.setPid(Integer.parseInt(pid));
			}
			detail.setStatus(m.getMenuStatus());
			detail.setUrl(m.getMenuUrl());
			detail.setnLevel(m.getMenuNlevel());
			details.add(detail);
		}
		return details;
	}

	@Override
	public List<MyInfoDetail> getELevelMenu(String id) {
		List<Menu> lists =  menuDao.getELevelMenu(id);
		List<MyInfoDetail> infos = null;
		try {
			infos = putDataToVo(lists);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		return infos;
	}
	
	
	@Override
	public boolean updatePermission(List<UUIdText> texts, IGrantService grantService,String mId,List<UUIdText>textNos) {
		boolean isSuc = true;
		boolean tempSuc = true;
		MyDate myDate = UtilFactory.getInstanceOfDate();
		MenuPermissionInfo menuPermissionInfo = new MenuPermissionInfo();
		menuPermissionInfo.setMenuId(Integer.valueOf(mId));
		//获取name
		
		//获取url
		
		//添加
		tempSuc = updatePermissionDetail(texts, grantService, mId);
		isSuc = isSuc && tempSuc;
		System.err.println("add "+isSuc);
		//删除
		tempSuc = updatePermissionDetail(textNos, grantService, mId);
		isSuc = isSuc && tempSuc;
		System.err.println("delete "+isSuc);
		
		return isSuc;
	}
	
	/**
	 * 修改权限具体方法(包括增加和删除)
	 * @param texts
	 * @param grantService
	 * @param mId
	 * @param textNos
	 * @return boolean 
	 */
	private boolean updatePermissionDetail(List<UUIdText> texts, IGrantService grantService,String mId){
		boolean isSuc = true;
		boolean tempSuc = true;
		MyDate myDate = UtilFactory.getInstanceOfDate();
		MenuPermissionInfo menuPermissionInfo = null;
		//获取当前权限(遍历上传的封装vo获取权限id)
		
		String name = "";
		String url = "";
		
		for(UUIdText text:texts){
			System.err.println(text.getId());
			
			
			//判断是否是新增或者删除还是已经存在
			//是新增或者删除
			if(text.getId().contains("L") ){
				//获取name和url
				name = text.getText().split("-")[0];
				System.err.println("update text "+text.getText());
				url  = text.getText().split("-")[1];
				//放数据到vo层里
				menuPermissionInfo = putDataToMenuPerIn( myDate, mId, text, menuPermissionInfo,name,url);
				//添加操作
				tempSuc = grantService.addMenuPermission(menuPermissionInfo);
				isSuc = tempSuc && isSuc;
		
			}else if(text.getId().contains("R")){
				
				menuPermissionInfo = new MenuPermissionInfo();
				menuPermissionInfo.setMenuId(Integer.valueOf(mId));
				menuPermissionInfo.setPermissionId(text.getId().substring(1));
				//删除操作
				tempSuc = grantService.deleteMenuPermission(menuPermissionInfo);
				isSuc = tempSuc && isSuc;
			}
		}
		return isSuc;
	}

		
	/**
	 * 将数据填充到voMenuPermissionInfo中去
	 * @param myDate 日期工具类
	 * @param mId    菜单id
	 * @param text   获取的vo对象
	 * @return MenuPermissionInfo
	 */
	private MenuPermissionInfo  putDataToMenuPerIn(MyDate myDate,String mId,UUIdText text,MenuPermissionInfo menuPermissionInfo,String permissionName,String permissionUrl){
		menuPermissionInfo = new MenuPermissionInfo();
		menuPermissionInfo .setMenuId(Integer.valueOf(mId));
		String idStr = text.getId();
		int lIndex = idStr.indexOf("L");
		int rIndex = idStr.indexOf("R");
		//判断标致在那个位置，没有返回0
		int index = lIndex>rIndex?(lIndex>0?lIndex:0):(rIndex>0?rIndex:0);
		String id = idStr.substring(index+1);
		System.err.println("gge id "+id);
		menuPermissionInfo.setPermissionId(id);
		//要检查是否删除还是新增的
		menuPermissionInfo.setPermissionName(permissionName);
		menuPermissionInfo.setPermissionUrl(permissionUrl);
		
		//没有的，代表是新增加的
		menuPermissionInfo.setMpCreateDatetime(myDate.getNowStr(TimeFormatConstant.Y_M_D_H_M_S));
		menuPermissionInfo.setMpUpdateTime(myDate.getNowStr(TimeFormatConstant.Y_M_D_H_M_S));
		
		//TODO 需要从登录账户获取用户名id
		menuPermissionInfo.setMpCreateId(1);
		menuPermissionInfo.setMpUpdateUid(1);
		return menuPermissionInfo;
	}

	private boolean updateMenuSortNum(String id,String sortNum) {
		Menu m = null;
		
		boolean isSuc = true;
		try {
			
			m = menuDao.getMenuById(Integer.valueOf(id));
			System.err.println("menuservice update sort id "+id +" sort "+sortNum);
			m.setMenuSortNum(String.valueOf(sortNum));
			isSuc = isSuc && menuDao.updateMenuById(String.valueOf(m.getMenuId()), m);
			
			
		} catch (NumberFormatException e) {
			
			e.printStackTrace();
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		return isSuc;
	}

	
}
