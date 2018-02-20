package com.clps.bj.mms.sm.dao.impl;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.clps.bj.mms.sm.dao.PermissionDao;
import com.clps.bj.mms.sm.entity.Permission;

/**
 * @ClassName: PermissionDaoImpl
 * @Description:权限实体层接口
 * @author: snow.y
 * @date: 2018年1月25日 上午10:14:23
 * @version V 1.0.3
 */
@Repository
public class PermissionDaoImpl implements PermissionDao {
	@Autowired
	private SessionFactory factory;//hibernate会话工厂
	private Query query;//query对象
	private List<Permission> list;//权限集合
	private String id;//自增id,主键
	private String name;//权限名
	private String description;//权限描述
	private String url;//权限url
	private String updateTime;//修改日期
	private Integer uimId;//操作人id
	private int i = 0;//判断标志
	private Long count = 0L;
	/*
	 * 
	 * @param permossion      
	 * @see com.clps.bj.mms.sm.dao.PermissionDao#addPermission(com.clps.bj.mms.sm.entity.Permission)
	 */
	@Override
	public boolean addPermission(Permission permission) {
		factory.getCurrentSession().save(permission);
		return true;
	}

	/*
	 * 
	 * @param pmsn_id
	 * @return      
	 * @see com.clps.bj.mms.sm.dao.PermissionDao#deletePermission(java.lang.Integer)
	 */
	@Override
	public boolean deletePermission(Permission permission) {
		Session s = factory.getCurrentSession();
		Permission p = (Permission)s.load(Permission.class, permission.getPmsnId());
		s.delete(p);
		return true;
	}

    /*
     * 
     * @param permission
     * @return      
     * @see com.clps.bj.mms.sm.dao.PermissionDao#updatePermission(com.clps.bj.mms.sm.entity.Permission)
     */
	@Override
	public boolean updatePermission(Permission permission) {
		query = factory.getCurrentSession().createQuery(hqlUpdate);
		name = permission.getPmsnName();
		description = permission.getPmsnDescription();
		url = permission.getPmsnUrl();
		updateTime = permission.getPmsnUpdateTime();
		uimId = permission.getPmsnUimId();
		id = permission.getPmsnId();
		query.setParameter(pmsnName, name);
		query.setParameter(pmsnDescription, description);
		query.setParameter(pmsnUrl, url);
		query.setParameter(pmsnUpdatetime, updateTime);
		query.setParameter(pmsnId, id);
	    query.setParameter(pmsnUimId, uimId);
	    i = query.executeUpdate();
		return i>0;
	}

	/*
	 * 
	 * @param pmsn_id
	 * @return      
	 * @see com.clps.bj.mms.sm.dao.PermissionDao#getPermissionByID(java.lang.Integer)
	 */
	@Override
	public Permission getPermissionByID(Permission permission) {
		query = factory.getCurrentSession().createQuery(hqlGetById);
		query.setParameter(pmsnId, permission.getPmsnId());
		return (Permission) query.uniqueResult();
	}

	/*
	 * 
	 * @return      
	 * @see com.clps.bj.mms.sm.dao.PermissionDao#getAllPermission()
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Permission> getAllPermission() {
		query = factory.getCurrentSession().createQuery(hqlGetAll);
		list = query.list();
		return list;
	}

	/* 
	 * @param permission
	 * @return      
	 * @see com.clps.bj.mms.sm.dao.PermissionDao#getPermissionTotal(com.clps.bj.mms.sm.entity.Permission)
	 */
	@Override
	public Long getPermissionTotal() {
		query = factory.getCurrentSession().createQuery(hqlGetCount);
		count  = (Long)query.uniqueResult();
		return count;
	}

	/* 
	 * @param permission
	 * @return      
	 * @see com.clps.bj.mms.sm.dao.PermissionDao#searchPermission(com.clps.bj.mms.sm.entity.Permission)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Permission> getSearchPermission(Permission permission) {
		StringBuffer sb = new StringBuffer(hqlsearch);
		sb.append(" where p.pmsnName=:pmsnName ");
		
		if(permission.getPmsnUrl()!=null){
			sb.append(" and p.pmsnUrl like '%"+permission.getPmsnUrl()+"%' ");
			
		}
		if(permission.getPmsnDescription()!=null){
			sb.append(" and p.pmsnDescription like '%"+permission.getPmsnDescription()+"%' ");
		}
		query = factory.getCurrentSession().createQuery(sb.toString());
		query.setParameter("pmsnName",permission.getPmsnName());
		list = query.list();
		return list;
	}

}
