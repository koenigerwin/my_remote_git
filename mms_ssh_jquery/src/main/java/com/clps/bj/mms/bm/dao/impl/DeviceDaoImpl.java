/**   
* @Title: DeviceDaoImpl.java 
* @Package com.clps.dev.mms.bm.device.dao.impl 
* @Description: (用一句话描述该文件做什么) 
* @author userdwt  
* @date 2018年1月9日 上午10:22:24 
* @version V1.0   
*/
package com.clps.bj.mms.bm.dao.impl;

import java.math.BigInteger;
import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.clps.bj.mms.bm.dao.DeviceDao;
import com.clps.bj.mms.bm.entity.Device;
import com.clps.bj.mms.bm.entity.DeviceCategory;



/**
 * @ClassName: DeviceDaoImpl
 * @Description: (这里用一句话描述这个类的作用)
 * @author userdwt
 * @date 2018年1月9日 上午10:22:24
 * 
 */
@Repository
public class DeviceDaoImpl implements DeviceDao{
	
	@Resource
	private SessionFactory sessionFactory;


	private static final String  deleteByPrimaryKeySql = "UPDATE Device SET deviceStatus='4' WHERE deviceId=?";



	private static final String updateByPrimaryKeySelectiveSql = "UPDATE Device SET deviceStatus=?,deviceRoomId=? WHERE deviceId=?";

	@SuppressWarnings("unused")
	private static final String updateByPrimaryKeySql = "NULL";

	private static final String selectAllSql = " FROM Device WHERE deviceStatus=1";
	

	private static final String selectByDeviceCidSql = " FROM Device WHERE device_cid=?";
	
	//StringBuffer在Tomcat上只会累加(append).使得SQL出现错误.
	//private static StringBuffer getTotalSql= new StringBuffer("SELECT COUNT(1) FROM DEVICE WHERE 1=1");

	//private  String getTotalSql2= "SELECT COUNT(1) FROM DEVICE WHERE 1=1";
	
	//private static StringBuffer selectDeviceByPageAndConditionsSql=new StringBuffer("SELECT * FROM DEVICE WHERE 1=1");
	
	//private String selectDeviceByPageAndConditionsSql2="SELECT * FROM DEVICE WHERE 1=1";
	
    @SuppressWarnings("unused")
	private Logger logger = Logger.getLogger(DeviceDaoImpl.class);

	Object[] args; // 分页使用

	int totalRecord; // 总数据
	
	int offset; //分页偏移量

	
	

	public DeviceDaoImpl() {
		super();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.clps.dev.mms.bm.device.dao.DeviceDao#deleteByPrimaryKey(java.lang.
	 * Integer)
	 */
	@Override
	public boolean deleteByPrimaryKey(Integer deviceId) {
		// Auto-generated method stub
		// boolean b = template.updateData(deleteByPrimaryKeySql, deviceId);
		// if (b) {
		// logger.info("delete success.");
		// } else {
		// logger.info("delete fail!");
		// }
		// return b;
		
		Query query=sessionFactory.getCurrentSession().createQuery(deleteByPrimaryKeySql);
		query.setParameter(0,deviceId );
		return query.executeUpdate()>0;
		
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.clps.dev.mms.bm.device.dao.DeviceDao#insert(com.clps.dev.mms.bm.device.
	 * model.Device)
	 */
	@Override
	public boolean insert(Device record) {
		// Auto-generated method stub
		// boolean b = template.updateData(insertSql, record.getDeviceId(),
		// record.getDeviceName(), record.getDeviceCid(),
		// record.getDeviceStatus(), record.getdeviceDescription(),
		// record.getDeviceUserId(),
		// record.getDeviceRoomId(), record.getDeviceCreated(),
		// record.getDeviceCreatedUserId(),
		// record.getDeviceUpdated(), record.getDeviceUpdatedUserId(),
		// record.getDeviceDefault1(),
		// record.getDeviceDefault2(), record.getDeviceNumber());
		// if (b) {
		// logger.info("insert success.");
		// } else {
		// logger.info("insert fail.");
		// }
		// return b;
		
		sessionFactory.getCurrentSession().save(record);
		return true;
		
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.clps.dev.mms.bm.device.dao.DeviceDao#selectByPrimaryKey(java.lang.
	 * Integer)
	 */
	@Override
	public Device selectByPrimaryKey(Integer deviceId) {
		//  Auto-generated method stub
		Device device = (Device) sessionFactory.getCurrentSession().get(Device.class, deviceId);

		return device;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.clps.dev.mms.bm.device.dao.DeviceDao#updateByPrimaryKeySelective(com.clps
	 * .dev.mms.bm.device.model.Device)
	 */
	@Override
	public boolean updateByPrimaryKeySelective(Device record) {

		// boolean b = template.updateData(updateByPrimaryKeySelectiveSql,
		// record.getDeviceStatus(),
		// record.getDeviceRoomId(), record.getDeviceId());
		// if (b) {
		// logger.info("updateSelective success");
		// } else {
		// logger.info("updateSelective fail");
		// }
		// return b;
		Query query=sessionFactory.getCurrentSession().createQuery(updateByPrimaryKeySelectiveSql);
		query.setParameter(0, record.getDeviceStatus());
		query.setParameter(1, record.getDeviceRoomId());
		query.setParameter(2, record.getDeviceId());
		return query.executeUpdate()>0;
		

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.clps.dev.mms.bm.device.dao.DeviceDao#updateByPrimaryKey(com.clps.dev.mms.
	 * bm.device.model.Device)
	 */
	@Override
	public boolean updateByPrimaryKey(Device record) {
		//  Auto-generated method stub
		return false;
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see com.clps.dev.mms.bm.device.dao.DeviceDao#selectAll()
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Device> selectAll() {

		// List<Device> list = template.queryAll(selectAllSql, this);
		// if (!list.isEmpty()) {
		// logger.info("查询成功");
		// } else {
		// logger.info("查询失败");
		// }
		// return list;
		Query query=sessionFactory.getCurrentSession().createQuery(selectAllSql);
		return query.list();
		
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.clps.dev.mms.bm.device.dao.DeviceDao#selectByDeviceCid(java.lang.Integer)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Device> selectByDeviceCid(Integer deviceCid) {
		//  Auto-generated method stub
		// List<Device> list = template.queryAll(selectByDeviceCidSql, this, deviceCid);
		// if (!list.isEmpty()) {
		// logger.info("查询成功");
		// } else {
		// logger.info("查询失败");
		// }
		// return list;
		Query query=sessionFactory.getCurrentSession().createQuery(selectByDeviceCidSql);
		query.setParameter(0, deviceCid);
		return query.list();
	}

	

	/* (non-Javadoc)
	 * @see com.clps.dev.mms.bm.device.dao.DeviceDao#getTotal(com.clps.dev.mms.bm.device.model.Device)
	 */
	@Override
	public long getTotal(Device device) {
		String getTotalSql2= "SELECT COUNT(1) FROM DEVICE WHERE 1=1 and device_status!=4";
		
		if (device.getDeviceUserId()!=null) {
			//getTotalSql.append(" and device_user_id="+device.getDeviceUserId());
			getTotalSql2+=" and device_user_id="+device.getDeviceUserId();
		}
		if (device.getDeviceName()!=null) {
			//getTotalSql.append(" and device_name like "+"'%"+device.getDeviceName().trim()+"%'");
			getTotalSql2+=" and device_name like "+"'%"+device.getDeviceName().trim()+"%'";
		}
		if(device.getDeviceNumber()!=null) {
			//getTotalSql.append(" and device_number like "+"'%"+device.getDeviceNumber().trim()+"'%");
			getTotalSql2+=" and device_number like "+"'%"+device.getDeviceNumber().trim()+"%'";
		}
		if (device.getDeviceRoomId()!=null) {
			//getTotalSql.append(" and device_room_id="+device.getDeviceRoomId());
			getTotalSql2+=" and device_room_id="+device.getDeviceRoomId();
		}
		
		// Device device2=template.queryUnique(getTotalSql.toString(), new
		// JDBCIMapper<Device>() {
		//
		// @Override
		// public Device map(ResultSet rs) {
		// //  Auto-generated method stub
		// Device device = new Device();
		// try {
		// device.setDeviceId(rs.getInt(1));
		//
		// } catch (SQLException e) {
		// e.printStackTrace();
		// }
		// return device;
		// }
		// });
		// return device2.getDeviceId();
		SQLQuery query=sessionFactory.getCurrentSession().createSQLQuery(getTotalSql2);
		return ((BigInteger) query.uniqueResult()).longValue();
		
		
		
	}
	

	/* (non-Javadoc)
	 * @see com.clps.dev.mms.bm.device.dao.DeviceDao#selectDeviceByPageAndConditions(java.lang.Integer, java.lang.Integer, com.clps.dev.mms.bm.device.model.Device)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Device> selectDeviceByPageAndConditions(Integer page, Integer rows, Device device) {
		
		String selectDeviceByPageAndConditionsSql2=" FROM Device dev WHERE 1=1 and deviceStatus!=4";
		
		int offset=0;
		
		if (device.getDeviceUserId()!=null) {
			selectDeviceByPageAndConditionsSql2+=" and deviceUserId="+device.getDeviceUserId();
			//selectDeviceByPageAndConditionsSql.append(" and device_user_id="+device.getDeviceUserId());
		}
		if (device.getDeviceName()!=null) {
			selectDeviceByPageAndConditionsSql2+=" and deviceName like "+"'%"+device.getDeviceName().trim()+"%'";
			//selectDeviceByPageAndConditionsSql.append(" and device_name like "+"'%"+device.getDeviceName().trim()+"%'");
		}
		if(device.getDeviceNumber()!=null) {
			
			selectDeviceByPageAndConditionsSql2+=" and deviceNumber like "+"'%"+device.getDeviceNumber().trim()+"%'";
			//selectDeviceByPageAndConditionsSql.append(" and device_number like "+"'%"+device.getDeviceNumber().trim()+"'%");
		}
		if (device.getDeviceRoomId()!=null) {
			selectDeviceByPageAndConditionsSql2+=" and deviceRoomId="+device.getDeviceRoomId();
			//selectDeviceByPageAndConditionsSql.append(" and device_room_id="+device.getDeviceRoomId());
		}
		if(device.getDeviceCategory().getDeviceCategoryId()!=null) {
			selectDeviceByPageAndConditionsSql2+=" and dev.deviceCategory.deviceCategoryId="+device.getDeviceCategory().getDeviceCategoryId();
		}
		
		if (page!=null&&rows!=null) {
			offset=((page<0?1:page)-1)*rows;
			//selectDeviceByPageAndConditionsSql.append(" limit ?,?");
			//selectDeviceByPageAndConditionsSql2+=" limit ?,?";
		}
		
		
		// List<Device>
		// list=template.queryAll(selectDeviceByPageAndConditionsSql.toString(),this,offset,rows);
		//
		// if (!list.isEmpty()) {
		// logger.info("selectDeviceByPageAndConditions查询成功");
		// } else {
		// logger.info("selectDeviceByPageAndConditions查询失败");
		// }
		// return list;	
		//SQLQuery query=sessionFactory.getCurrentSession().createSQLQuery(selectDeviceByPageAndConditionsSql2);
		Query query=sessionFactory.getCurrentSession().createQuery(selectDeviceByPageAndConditionsSql2);
		if (page != null && rows != null) {
			//query.setParameter(0, offset);
			//query.setParameter(1, rows);
			query.setFirstResult(offset);
			query.setMaxResults(rows);
		}
		List<Device> list=query.list();
		for (@SuppressWarnings("unused") Device device2 : list) {
			//device2.getDeviceCategory().setDevices(null);
		}
		return list;
	}

	/* (non-Javadoc)
	 * @see com.clps.bj.mms.bm.dao.DeviceDao#updateDevice(com.clps.bj.mms.bm.entity.Device)
	 */
	@Override
	public boolean updateDevice(Device device) {
		System.out.println("update");
		
		Device savedDevice=(Device) sessionFactory.getCurrentSession().get(Device.class, device.getDeviceId());
		//Integer cid=savedDevice.getDeviceCategory().getDeviceCategoryId();
		Integer newCid=device.getDeviceCategory().getDeviceCategoryId();
		
		//一共修改了七个字段.
		if (newCid!=null) {
			savedDevice.setDeviceCategory((DeviceCategory)sessionFactory.getCurrentSession().get(DeviceCategory.class, newCid));
		}
		//savedDevice.getDeviceCategory().setDeviceCategoryId(newCid==null?cid:newCid);
		savedDevice.setDeviceDefault1(device.getDeviceDefault1());
		savedDevice.setDeviceNumber(device.getDeviceNumber());
		savedDevice.setDeviceName(device.getDeviceName());
		savedDevice.setDeviceDescription(device.getDeviceDescription());
		savedDevice.setDeviceUserId(device.getDeviceUserId());
		savedDevice.setDeviceUpdated(device.getDeviceUpdated());
		
		System.out.println(savedDevice);
		sessionFactory.getCurrentSession().update(savedDevice);
		//没有flush方法则无法更新.
		//就是缓存问题建议在session.update后加一句session.flush（强制缓存中数据与数据库中同步）
		sessionFactory.getCurrentSession().flush();
		
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.clps.bj.mms.bm.dao.DeviceDao#getTotal2(long)
	 */
	@Override
	public long getTotal2(Device device) {

		String selectDeviceByPageAndConditionsSql2 = " FROM Device dev WHERE 1=1 and deviceStatus!=4";

		if (device.getDeviceUserId() != null) {
			selectDeviceByPageAndConditionsSql2 += " and deviceUserId=" + device.getDeviceUserId();
			// selectDeviceByPageAndConditionsSql.append(" and
			// device_user_id="+device.getDeviceUserId());
		}
		if (device.getDeviceName() != null) {
			selectDeviceByPageAndConditionsSql2 += " and deviceName like " + "'%" + device.getDeviceName().trim()
					+ "%'";
			// selectDeviceByPageAndConditionsSql.append(" and device_name like
			// "+"'%"+device.getDeviceName().trim()+"%'");
		}
		if (device.getDeviceNumber() != null) {

			selectDeviceByPageAndConditionsSql2 += " and deviceNumber like " + "'%" + device.getDeviceNumber().trim()
					+ "%'";
			// selectDeviceByPageAndConditionsSql.append(" and device_number like
			// "+"'%"+device.getDeviceNumber().trim()+"'%");
		}
		if (device.getDeviceRoomId() != null) {
			selectDeviceByPageAndConditionsSql2 += " and deviceRoomId=" + device.getDeviceRoomId();
			// selectDeviceByPageAndConditionsSql.append(" and
			// device_room_id="+device.getDeviceRoomId());
		}
		if (device.getDeviceCategory().getDeviceCategoryId() != null) {
			selectDeviceByPageAndConditionsSql2 += " and dev.deviceCategory.deviceCategoryId="
					+ device.getDeviceCategory().getDeviceCategoryId();
		}

		Query query=sessionFactory.getCurrentSession().createQuery(selectDeviceByPageAndConditionsSql2);
		
		return query.list().size();

	}

}
