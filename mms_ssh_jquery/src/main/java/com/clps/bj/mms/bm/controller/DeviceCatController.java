/**   
* @Title: DeviceCatController.java 
* @Package com.clps.bj.mms.bm.controller 
* @Description: TODO(用一句话描述该文件做什么) 
* @author userdwt  
* @date 2018年1月30日 下午3:57:43 
* @version V1.0   
*/
package com.clps.bj.mms.bm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.clps.bj.mms.bm.service.IDeviceCategoryService;
import com.clps.bj.mms.bm.vo.EasyUITreeNode;

/**
 * @ClassName: DeviceCatController
 * @Description: 设备类目的controller
 * @author userdwt
 * @date 2018年1月30日 下午3:57:43
 * 
 */
@Controller
@RequestMapping("/bm/device")
public class DeviceCatController {

	@Autowired
	private IDeviceCategoryService iDeviceCategoryService;

	@RequestMapping("item/cat/list")
	@ResponseBody
	public List<EasyUITreeNode> findDeviceCat(@RequestParam(name = "id", defaultValue = "0") Long parentId) {

		int parentId2 = parentId.intValue();
		
		List<EasyUITreeNode> nodes = iDeviceCategoryService.findDeviceCatsByParentId(parentId2);

		return nodes;

	}

}
