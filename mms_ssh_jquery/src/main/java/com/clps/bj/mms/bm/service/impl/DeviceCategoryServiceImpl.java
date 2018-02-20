/**   
* @Title: DeviceCategoryImpl.java 
* @Package com.clps.bj.mms.bm.service.impl 
* @Description: (用一句话描述该文件做什么) 
* @author userdwt  
* @date 2018年1月22日 下午5:28:21 
* @version V1.0   
*/
package com.clps.bj.mms.bm.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clps.bj.mms.bm.dao.DeviceCategoryDao;
import com.clps.bj.mms.bm.entity.DeviceCategory;
import com.clps.bj.mms.bm.service.IDeviceCategoryService;
import com.clps.bj.mms.bm.vo.EasyUITreeNode;

/** 
* @ClassName: DeviceCategoryImpl 
* @Description: (这里用一句话描述这个类的作用) 
* @author userdwt
* @date 2018年1月22日 下午5:28:21 
*  
*/
@Service
public class DeviceCategoryServiceImpl implements IDeviceCategoryService {
	
	@Autowired
	private DeviceCategoryDao deviceCategoryDao;

	/* (non-Javadoc)
	 * @see com.clps.bj.mms.bm.service.IDeviceCategoryService#findDeviceCatsByParentId(int)
	 */
	@Override
	public List<EasyUITreeNode> findDeviceCatsByParentId(int parentId) {
		//  Auto-generated method stub


		List<DeviceCategory> list=deviceCategoryDao.selectByParentId(parentId);
		List<EasyUITreeNode> nodes=new ArrayList<>();
		for (DeviceCategory category : list) {
			EasyUITreeNode node=new EasyUITreeNode();
			node.setId(category.getDeviceCategoryId());
			node.setText(category.getDeviceCategoryName());
			node.setState(category.getDeviceCategoryIsParent()>0?"closed":"open");
			nodes.add(node);
		}
		return nodes;
		
	}

}
