/**   
* @Title: DeviceController.java 
* @Package com.clps.bj.mms.bm.controller 
* @Description: 
* @author userdwt  
* @date 2018年1月30日 下午4:04:06 
* @version V1.0   
*/
package com.clps.bj.mms.bm.controller;

import java.text.SimpleDateFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.clps.bj.mms.bm.entity.Device;
import com.clps.bj.mms.bm.entity.DeviceCategory;
import com.clps.bj.mms.bm.service.IDeviceService;
import com.clps.bj.mms.bm.vo.EasyUIDataGridResult;
import com.clps.bj.mms.bm.vo.TaotaoResult;

/** 
* @ClassName: DeviceController 
* @Description: 设备管理的controller
* @author userdwt
* @date 2018年1月30日 下午4:04:06 
*  
*/
@Controller
@RequestMapping("/bm/device")
public class DeviceController {
	
	
	@Autowired
	private IDeviceService iDeviceService;
	
	private static final SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	@RequestMapping("/")
	public String toIndex() {
		System.out.println("index");
		return "device-index";
	}
	
	@RequestMapping("{page}")
	public String toPage(@PathVariable String page) {
		System.out.println("page");
		return page;
		
	}
	
	@RequestMapping("/item/{itemId}")
	@ResponseBody
	public Device findDeviceById(@PathVariable Long itemId) {
		
		int itemId2=itemId.intValue();
		
		Device device=iDeviceService.selectByPrimaryKey(itemId2);
		
		return device;
		
	}
	
	/**
	 * 
	* @Title: findDevicesByPage 
	* @Description: 查询
	* @param @param page
	* @param @param rows
	* @param @param device  这个对象不能为空.
	* @param @return     
	* @return EasyUIDataGridResult    返回类型 
	* @throws
	 */
	@RequestMapping("/item/list")
	@ResponseBody
	public EasyUIDataGridResult findDevicesByPage(Integer page,Integer rows,Device device,
			Long categoryId,String userName,String roomName) {
		
		System.out.println("/item/list..>"+page+".."+rows+".."+categoryId+".."+device);
		System.out.println("userName::"+userName+".."+roomName);
		if(categoryId!=null) {
			DeviceCategory deviceCategory=new DeviceCategory();
			deviceCategory.setDeviceCategoryId(categoryId.intValue());
			device.setDeviceCategory(deviceCategory);
			
		}
		if(userName!=null&&!userName.equals("null")) {
			//此处应该引用IUserInfoMainService. 的  
			//public UserInfoMain getUserInfoMainByName(String userName);
			//得到 deviceUserId封装进入查询条件.
		}
		if(roomName!=null&&!roomName.equals("null")) {
			//引用 根据roomNam得到 一个Room 的接口.
			//并把得到deviceRoomId 封装进入查询条件.
		}
		EasyUIDataGridResult result= iDeviceService.findDevicesByPageAndConditions(page, rows, device);
		System.out.println(result);
		return result;
	}
	
	@RequestMapping("/item/save")
	@ResponseBody
	public TaotaoResult addDevice(Device device,Integer cid,Integer price) {
		
		System.out.println("/item/save--> "+cid+".."+price+".."+device);
		
		DeviceCategory deviceCategory=new DeviceCategory();
		deviceCategory.setDeviceCategoryId(cid==null?1:cid);
		device.setDeviceCategory(deviceCategory);
		
		//当前Subject的id,应当从session或其他地方获取.
		int subjectId=1;
		
		//该填充字段标记为设备价格.
		device.setDeviceDefault1((price==null?"":price).toString());
		
		device.setDeviceStatus(1);
		device.setDeviceRoomId(null);
		device.setDeviceCreated(format.format(System.currentTimeMillis()));
		device.setDeviceUpdated(format.format(System.currentTimeMillis()));
		device.setDeviceCreatedUserId(subjectId);
		device.setDeviceUpdatedUserId(subjectId);
		
		iDeviceService.add(device);
		
		return TaotaoResult.ok();
		
	}
	/**
	 * 
	* @Title: toItemEdit 
	* @Description: 跳转到设备编辑页面. 
	* @param @return     
	* @return String    返回类型 
	* @throws
	 */
	@RequestMapping("/rest/page/item-edit")
	public String toItemEdit() {
		System.out.println("/rest/page/item-edit");
		return "device-edit";
	}
	
	/**
	 * 
	* @Title: updateDevice 
	* @Description: 编辑一个设备
	* @param @param device
	* @param @param cid  设备的分类ID
	* @param @param price 设备的价格,放置在default1字段.
	* @return TaotaoResult    返回类型 
	* @throws
	 */
	@RequestMapping("/rest/item/update")
	@ResponseBody
	public TaotaoResult updateDevice(Device device,Integer cid,Integer price) {
		
		System.out.println("/item/update--> "+cid+".."+price+".."+device);
		
		DeviceCategory deviceCategory=new DeviceCategory();
		deviceCategory.setDeviceCategoryId(cid);
		device.setDeviceCategory(deviceCategory);
		
		//该填充字段标记为设备价格.
		device.setDeviceDefault1((price==null?"":price).toString());
		device.setDeviceUpdated(format.format(System.currentTimeMillis()));
		
		iDeviceService.updateDevice(device);
		return TaotaoResult.ok();
		
	}
	

	@RequestMapping("/rest/item/delete")
	@ResponseBody
	public TaotaoResult deleteDevice(@RequestParam String ids) {
		
		System.out.println("/rest/item/delete"+ids.toString());
		String[] strings=ids.split(",");
		for (String string : strings) {
			iDeviceService.deleteByPrimaryKey(Integer.parseInt(string));
		}
		
		return TaotaoResult.ok();
	}
	
	@RequestMapping("/rest/item/borrow")
	@ResponseBody
	public TaotaoResult borrowDevice(@RequestParam String ids,@RequestParam String roomId) {
		
		System.out.println("/rest/item/borrow"+"-->"+ids+"--->"+roomId);
		
		String[] strings=ids.split(",");
		for (String string : strings) {
			Device device=new Device();
			device.setDeviceId(Integer.parseInt(string));
			device.setDeviceRoomId(Integer.parseInt(roomId));
			iDeviceService.borrowDeviceByDeviceId(device);
		}
		
		return TaotaoResult.ok();
	}
	
	@RequestMapping("/rest/item/restore")
	@ResponseBody
	public TaotaoResult restoreDevice(@RequestParam String ids) {
		
		System.out.println("/rest/item/restore"+"-->"+ids+"--->");
		
		String[] strings=ids.split(",");
		for (String string : strings) {
			Device device=new Device();
			device.setDeviceId(Integer.parseInt(string));
			iDeviceService.restoreDevice(device);
		}
		
		return TaotaoResult.ok();
	}
	
	@RequestMapping("/rest/item/repair")
	@ResponseBody
	public TaotaoResult repairDevice(@RequestParam String ids) {
		
		System.out.println("/rest/item/repair"+"-->"+ids+"--->");
		
		String[] strings=ids.split(",");
		for (String string : strings) {
			Device device=new Device();
			device.setDeviceId(Integer.parseInt(string));
			iDeviceService.repairDevice(device);
		}
		
		return TaotaoResult.ok();
	}
	
	
	
	
	
	
	
}
