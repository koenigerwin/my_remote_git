/**   
* @Title: DeviceDao.java 
* @Package com.clps.dev.mms.bm.device.dao 
* @Description: (用一句话描述该文件做什么) 
* @author userdwt  
* @date 2018年1月8日 下午4:48:10 
* @version V1.0   
*/
package com.clps.bj.mms.bm.dao;

import java.util.List;

import com.clps.bj.mms.bm.entity.Device;



/**
 * @ClassName: DeviceDao
 * @Description: 提供对device的一系列操作,如crud
 * @author userdwt
 * @date 2018年1月8日 下午4:48:10
 * 
 */
public interface DeviceDao {

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
	* @return boolean    返回类型    大于0增加成功
	* @throws
	 */
	public boolean insert(Device record);

	

	/**
	 * 
	* @Title: selectByPrimaryKey 
	* @Description:  根据主键查找某一个设备 
	* @param @param deviceId
	* @return Device    返回类型 
	* @throws
	 */
	public Device selectByPrimaryKey(Integer deviceId);

	/**
	 * 
	* @Title: updateByPrimaryKeySelective 
	* @Description: 更新设备的状态,这个方法需要设备的id,deviceRoomId 
	* @param @param record
	* @return boolean    返回类型 
	* @throws
	 */
	public boolean updateByPrimaryKeySelective(Device record);

	/**
	 * 
	* @Title: updateByPrimaryKey 
	* @Description: 更新设备,这个方法要求device的字段必须完整,此方法暂时不用.
	* @param @param record
	* @return boolean    返回类型 
	* @throws
	 */
	public boolean updateByPrimaryKey(Device record);
	
	/**
	 * 
	* @Title: updateDevice 
	* @Description: 使用session.saveOrUpdated(Object)方法更新设备. 
	* @param @param device
	* @return boolean    返回类型 
	* @throws
	 */
	public boolean updateDevice(Device device);
	
	/**
	 * 
	* @Title: selectAll 
	* @Description: 查询所有设备
	* @return List<Device>    返回类型 
	* @throws
	 */
	public List<Device> selectAll();

	/**
	 * 
	* @Title: selectByDeviceCid 
	* @Description: 根据设备分类id查询设备
	* @param @param deviceCid  设备分类ID
	* @return List<Device>    返回类型 
	* @throws
	 */
	public List<Device> selectByDeviceCid(Integer deviceCid);
	
	/**
	 * 
	* @Title: getTotal 
	* @Description: 根据条件查询相应的设备总数,可选字段:deviceName,deviceNumber,deviceUserId,deviceRoomId
	* @param @param device
	* @return long    返回类型 
	* @throws
	 */
	public long getTotal(Device device);
	
	//加上分类的getTotal.
	public long getTotal2(Device device);
	
	/**
	 * 
	* @Title: selectDeviceByPageAndConditions 
	* @Description: 条件查询(可选项) + 分页(可选项,也就是page,rows为null)
	* @param @param page pageNum
	* @param @param rows pageSize
	* @param @param device 封装查询条件
	* @return List<Device>    返回类型 
	* @throws
	 */
	List<Device> selectDeviceByPageAndConditions(Integer page,Integer rows,Device device);

}
