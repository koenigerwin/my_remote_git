/**   
* @Title: DeviceCategoryDao.java 
* @Package com.clps.dev.mms.bm.device.dao 
* @Description: (用一句话描述该文件做什么) 
* @author userdwt  
* @date 2018年1月18日 上午10:27:09 
* @version V1.0   
*/
package com.clps.bj.mms.bm.dao;

import java.util.List;

import com.clps.bj.mms.bm.entity.DeviceCategory;


/** 
* @ClassName: DeviceCategoryDao 
* @Description: (这里用一句话描述这个类的作用) 
* @author userdwt
* @date 2018年1月18日 上午10:27:09 
*  
*/
public interface DeviceCategoryDao {
	
	/**
	 * 
	* @Title: selectByParentId 
	* @Description: 查询设备分类
	* @param @param parentId
	* @param @return     
	* @return List<DeviceCategory>    返回类型 
	* @throws
	 */
	public List<DeviceCategory> selectByParentId(int parentId);

}
