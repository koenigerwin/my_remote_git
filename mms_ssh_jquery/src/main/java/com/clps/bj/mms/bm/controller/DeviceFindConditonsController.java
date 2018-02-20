/**   
* @Title: DeviceFindConditons.java 
* @Package com.clps.bj.mms.bm.controller 
* @Description:  
* @author userdwt  
* @date 2018年2月4日 下午5:08:15 
* @version V1.0   
*/
package com.clps.bj.mms.bm.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.clps.bj.mms.bm.vo.DeviceAndRoom;
import com.clps.bj.mms.bm.vo.TaotaoResult;


/** 
* @ClassName: DeviceFindConditons 
* @Description:  
* @author userdwt
* @date 2018年2月4日 下午5:08:15 
*  
*/
@Controller
@RequestMapping("/bm/device")
public class DeviceFindConditonsController {
	
	//此处应该引用IUserInfoMainService. 的  
	//public List<UserInfoMain> getAllUserInfoMain();
	
	//RoomService  public List getAllRoom(); 
	//但是最好别用!!!!!!!!!
	
	@RequestMapping("/find/item/room")
	@ResponseBody
	public TaotaoResult findNames() {
		System.out.println("/find/item/room");
		//在这里调用接口组装vo
		List<DeviceAndRoom> list=new ArrayList<>();
		for(int i=0;i<20;i++) {
			DeviceAndRoom deviceAndRoom=new DeviceAndRoom();
			deviceAndRoom.setRoomName("roomName"+i);
			deviceAndRoom.setUserName("userName"+i);
			list.add(deviceAndRoom);
		}
		return TaotaoResult.build(200, "", list);
		
	}
	

}
