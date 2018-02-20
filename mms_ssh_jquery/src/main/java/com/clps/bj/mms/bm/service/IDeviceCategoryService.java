/**   
* @Title: IDeviceCategoryService.java 
* @Package com.clps.bj.mms.bm.service 
* @Description: (用一句话描述该文件做什么) 
* @author userdwt  
* @date 2018年1月22日 下午5:27:02 
* @version V1.0   
*/
package com.clps.bj.mms.bm.service;

import java.util.List;

import com.clps.bj.mms.bm.vo.EasyUITreeNode;



/** 
* @ClassName: IDeviceCategoryService 
* @Description: 关于设备分类的service层 
* @author userdwt
* @date 2018年1月22日 下午5:27:02 
*  
*/
public interface IDeviceCategoryService {

	/**
	 * 
	* @Title: findDeviceCatsByParentId 
	* @Description: 显示设备分类的 TreeNode
	* @param @param parentId
	* @param @return     
	* @return List<EasyUITreeNode>    返回类型 
	* @throws
	 */
	public List<EasyUITreeNode> findDeviceCatsByParentId(int parentId) ;
	
}
