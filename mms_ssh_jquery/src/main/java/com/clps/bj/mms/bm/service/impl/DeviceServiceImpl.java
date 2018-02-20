/**   
* @Title: DeviceServiceImpl.java 
* @Package com.clps.bj.mms.bm.service.impl 
* @Description: (用一句话描述该文件做什么) 
* @author userdwt  
* @date 2018年1月22日 下午4:51:46 
* @version V1.0   
*/
package com.clps.bj.mms.bm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.clps.bj.mms.bm.dao.DeviceDao;
import com.clps.bj.mms.bm.entity.Device;
import com.clps.bj.mms.bm.service.IDeviceService;
import com.clps.bj.mms.bm.vo.EasyUIDataGridResult;

/** 
* @ClassName: DeviceServiceImpl 
* @Description: (这里用一句话描述这个类的作用) 
* @author userdwt
* @date 2018年1月22日 下午4:51:46 
*  
*/
@Service
@Transactional
public class DeviceServiceImpl implements IDeviceService {
	
	@Autowired
	private DeviceDao deviceDao;

	/* (non-Javadoc)
	 * @see com.clps.bj.mms.bm.service.IDeviceService#deleteByPrimaryKey(java.lang.Integer)
	 */
	@Override
	public boolean deleteByPrimaryKey(Integer deviceId) {
		//  Auto-generated method stub
		return deviceDao.deleteByPrimaryKey(deviceId);
	}

	/* (non-Javadoc)
	 * @see com.clps.bj.mms.bm.service.IDeviceService#add(com.clps.bj.mms.bm.entity.Device)
	 */
	@Override
	public boolean add(Device record) {
		//  Auto-generated method stub
		return deviceDao.insert(record);
	}

	/* (non-Javadoc)
	 * @see com.clps.bj.mms.bm.service.IDeviceService#selectByPrimaryKey(java.lang.Integer)
	 */
	@Override
	public Device selectByPrimaryKey(Integer deviceId) {
		//  Auto-generated method stub
		return deviceDao.selectByPrimaryKey(deviceId);
	}

	/* (non-Javadoc)
	 * @see com.clps.bj.mms.bm.service.IDeviceService#getDeviceByDeviceId(com.clps.bj.mms.bm.entity.Device)
	 */
	@Override
	public boolean borrowDeviceByDeviceId(Device record) {
		//  Auto-generated method stub
		if (record.getDeviceId()==null||record.getDeviceRoomId()==null) {
			return false;
		}
		record.setDeviceStatus(0);
		return deviceDao.updateByPrimaryKeySelective(record);
	}

	/* (non-Javadoc)
	 * @see com.clps.bj.mms.bm.service.IDeviceService#restoreDevice(com.clps.bj.mms.bm.entity.Device)
	 */
	@Override
	public boolean restoreDevice(Device record) {
		//  Auto-generated method stub
		if (record.getDeviceId()==null) {
			return false;
		}
		record.setDeviceStatus(1);
		record.setDeviceRoomId(null);
		return deviceDao.updateByPrimaryKeySelective(record);
	}

	/* (non-Javadoc)
	 * @see com.clps.bj.mms.bm.service.IDeviceService#updateByPrimaryKey(com.clps.bj.mms.bm.entity.Device)
	 */
	@Override
	public boolean updateByPrimaryKey(Device record) {
		//  Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see com.clps.bj.mms.bm.service.IDeviceService#selectAll()
	 */
	@Override
	public List<Device> selectAll() {
		//  Auto-generated method stub
		return deviceDao.selectAll();
	}

	/* (non-Javadoc)
	 * @see com.clps.bj.mms.bm.service.IDeviceService#selectByDeviceCid(java.lang.Integer)
	 */
	@Override
	public List<Device> selectByDeviceCid(Integer deviceCid) {
		//  Auto-generated method stub
		return deviceDao.selectByDeviceCid(deviceCid);
	}

	/* (non-Javadoc)
	 * @see com.clps.bj.mms.bm.service.IDeviceService#findDevicesByPageAndConditions(java.lang.Integer, java.lang.Integer, com.clps.bj.mms.bm.entity.Device)
	 */
	@Override
	public EasyUIDataGridResult findDevicesByPageAndConditions(Integer page, Integer rows, Device device) {
		//  Auto-generated method stub
		
		List<Device> list=deviceDao.selectDeviceByPageAndConditions(page, rows, device);
		for (Device device2 : list) {
			System.out.println(device2);//此时device2的DeviceCategory=null是因为DB中的数据不全.
			device2.getDeviceCategory().setDevices(null);
		}
		//System.out.println("serviceimp;"+list.get(0).toString());
		long total=deviceDao.getTotal2(device);
		EasyUIDataGridResult result=new EasyUIDataGridResult();
		result.setRows(list);
		result.setTotal(total);
		
		
		return result;
	}

	/* (non-Javadoc)
	 * @see com.clps.bj.mms.bm.service.IDeviceService#updateDevice(com.clps.bj.mms.bm.entity.Device)
	 */
	@Override
	public boolean updateDevice(Device device) {
		
		return deviceDao.updateDevice(device);
		
	}

	/* (non-Javadoc)
	 * @see com.clps.bj.mms.bm.service.IDeviceService#repairDevice(com.clps.bj.mms.bm.entity.Device)
	 */
	@Override
	public boolean repairDevice(Device record) {
		// TODO Auto-generated method stub
		if (record.getDeviceId()==null) {
			return false;
		}
		record.setDeviceStatus(2);
		record.setDeviceRoomId(null);
		return deviceDao.updateByPrimaryKeySelective(record);
	}

}
