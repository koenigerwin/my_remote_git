/**   
* @Title: IDeviceService.java 
* @Package com.clps.bj.mms.bm.service 
* @Description: (用一句话描述该文件做什么) 
* @author userdwt  
* @date 2018年1月22日 下午4:43:26 
* @version V1.0   
*/
package com.clps.bj.mms.bm.service;

import java.util.List;

import com.clps.bj.mms.bm.entity.Device;
import com.clps.bj.mms.bm.vo.EasyUIDataGridResult;


/** 
* @ClassName: IDeviceService 
* @Description: (这里用一句话描述这个类的作用) 
* @author userdwt
* @date 2018年1月22日 下午4:43:26 
*  
*/
public interface IDeviceService {
	
	/**
	 * 
	* @Title: deleteByPrimaryKey 
	* @Description: 删除一个设备 
	* @param @param deviceId
	* @return boolean    返回类型 
	* @throws
	 */
	public boolean deleteByPrimaryKey(Integer deviceId);

	/**
	 * 
	* @Title: insert 
	* @Description: 增加一个设备
	* @param @param record
	* @return boolean    返回类型 
	* @throws
	 */
	public boolean add(Device record);

	/**
	 * 
	* @Title: selectByPrimaryKey 
	* @Description: 根据主键查找某一个设备 
	* @param @param deviceId
	* @return Device    返回类型 
	* @throws
	 */
	public Device selectByPrimaryKey(Integer deviceId);

	/**
	 * 
	 * @Title: updateByPrimaryKeySelective
	 * @Description: 这个方法用来根据主键来获取设备  (会议室借用设备)
	 * @param record 必须明确deviceId,deviceStatus,deviceRoomId
	 * @return boolean 返回类型 @throws
	 */
	public boolean borrowDeviceByDeviceId(Device record) ;
	
	/**
	 * 
	* @Title: restoreDevice 
	* @Description: 归还设备. 
	* @param @param record
	* @param @return     
	* @return boolean    返回类型 
	* @throws
	 */
	public boolean restoreDevice(Device record) ;
	// {
	// record.setDeviceStatus(1);
	// record.setDeviceRoomId(null);
	// return deviceDao.updateByPrimaryKeySelective(record);
	// }

	/**
	 * 
	* @Title: repairDevice 
	* @Description: 维修设备.
	* @param @param record
	* @return boolean    返回类型 
	* @throws
	 */
	public boolean repairDevice(Device record);
	
	
	/**
	 * 
	* @Title: updateByPrimaryKey 
	* @Description: 更新设备,这个方法要求device的字段必须完整,此方法暂时不用.
	* @param @param record
	* @return boolean    返回类型 
	* @throws
	 */
	public boolean updateByPrimaryKey(Device record);
//	{
//		return deviceDao.updateByPrimaryKey(record);
//	}

	/**
	 * 
	* @Title: selectAll 
	* @Description: 查询所有设备 
	* @return List<Device>    返回类型 
	* @throws
	 */
	public List<Device> selectAll() ;

	/**
	 * 
	* @Title: selectByDeviceCid 
	* @Description: 根据设备分类id查询设备
	* @param @param deviceCid
	* @return List<Device>    返回类型 
	* @throws
	 */
	public List<Device> selectByDeviceCid(Integer deviceCid) ;
	
	/**
	 * 
	* @Title: findDevicesByPageAndConditions 
	* @Description: 分页 + 条件查询 
	* @param @param page pageNum
	* @param @param rows pageSize
	* @param @param device
	* @return EasyUIDataGridResult    返回类型 
	* @throws
	 */
	public EasyUIDataGridResult findDevicesByPageAndConditions(Integer page,Integer rows,Device device);
//	{
//		
//		List<Device> list = deviceDao.selectDeviceByPageAndConditions(page, rows, device);
//		int total = deviceDao.getTotal(device);
//		EasyUIDataGridResult result = new EasyUIDataGridResult();
//		result.setRows(list);
//		result.setTotal(total);
//		
//		return result;
//		
//	}
	
	/**
	 * 
	* @Title: updateDevice 
	* @Description: 使用session.saveOrUpdated(Object)方法更新设备. 
	* @param @param device
	* @return boolean    返回类型 
	* @throws
	 */
	public boolean updateDevice(Device device);
	

}
