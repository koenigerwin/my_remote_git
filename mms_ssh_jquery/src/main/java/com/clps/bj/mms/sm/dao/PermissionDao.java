package com.clps.bj.mms.sm.dao;

import java.util.List;

import com.clps.bj.mms.sm.entity.Permission;

/**
 * @ClassName: PermissionDao
 * @Description:权限的功能接口
 * @author: snow.y
 * @date: 2018年1月22日 下午2:42:24
 * @version V1.0.2
 */
public interface PermissionDao {
	public static final String hqlUpdate = "update Permission set pmsnName=:pmsnName,"
			+ "pmsnDescription=:pmsnDescription,pmsnUrl=:pmsnUrl,pmsnUpdateTime=:pmsnUpdateTime,pmsnUimId=:pmsnUimId where pmsnId=:pmsnId";//修改语句
	public static final String hqlGetById = "from Permission  where pmsnId:pmsnId";//单值查询语句
	public static final String hqlsearch = "from Permission p";//模糊查询语句
	public static final String hqlGetCount = "select count(*) from Permission";//统计条数
	public static final String hqlGetAll = "from Permission";//查询所有
	public static final String pmsnId = "pmsnId";//权限表id字段
	public static final String pmsnName = "pmsnName";//权限表名字字段
	public static final String pmsnDescription = "pmsnDescription";//权限表描述字段
	public static final String pmsnUrl = "pmsnUrl";//权限表url字段
	public static final String pmsnUpdatetime = "pmsnUpdateTime";//权限修改时间
	public static final String pmsnUimId ="pmsnUimId";//操作人id
	/**
	 * 
	 * @Description 				增加权限
	 * @param permossion 	    	权限的实体类对象    
	 */
	public boolean addPermission(Permission permission);
    /**
     * 
     * @Description 				删除权限
     * @param  pmsn_id				pmsn_id 权限id      
     * @return boolean 				返回true删除成功;返回false删除失败
     */
	public boolean deletePermission(Permission permission);
    /**
     * 
     * @Description 				修改权限
     * @param permission			权限实体类的对象    
     * @return boolean				返回true修改成功;返回false修改失败
     */
	public boolean updatePermission(Permission permission);
	/**
	 * 
	 * @Description 				查询条数
	 * @return int                  统计条数
	 *
	 */
	public Long getPermissionTotal();
	/**
	 * 
	 * @Description 				查询一个权限信息
	 * @param id                    权限实体类对象
	 * @return Permission           返回权限信息的实体类对象
	 */
	public Permission getPermissionByID(Permission permission);
	/**
	 * 
	 * @Description 				根据条件查询权限
	 * @param permission            权限实体类对象
	 * @return List<Permission>     返回权限信息的实体类对象列表  
	 *
	 */
	public List<Permission> getSearchPermission(Permission permission);
   /**
    * 
    * @Description                   查询所有权限信息
    * @return List<Permission>       返回所有权限信息的列表
    */
	public List<Permission> getAllPermission();
}
