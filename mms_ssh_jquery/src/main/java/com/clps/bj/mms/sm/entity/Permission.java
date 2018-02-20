package com.clps.bj.mms.sm.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.GenericGenerator;

/**
 * 
 * @ClassName: Permission
 * @Description:权限的实体类
 * @author: snow.y
 * @date: 2018年1月22日 下午2:36:20
 * @version V1.0.2
 */
@Entity
@Table(name = "permission")
public class Permission implements Serializable {
	private static final long serialVersionUID = 1L;
	private String pmsnId; // 权限id
	private String pmsnName;// 权限名,必填 长度
	private String pmsnDescription;// 权限描述
	private String pmsnUrl;// 权限url
	private Integer pmsnCreateId;//创建人id
	private String pmsnCreateDatetime;// 创建日期
	private Integer pmsnUimId;// 修改人id
	private String pmsnUpdateTime;// 修改日期
	private Set<MenuPermission> rmpSet = new HashSet<>();
	
	public Permission() {
		super();
	}
	
	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid")
	@Column(name = "pmsn_id", length = 32, unique = true, nullable = false)
	public final String getPmsnId() {
		return pmsnId;
	}

	public final void setPmsnId(String pmsnId) {
		this.pmsnId = pmsnId;
	}

	@Column(name = "pmsn_create_id", length = 11, nullable = false)
	public final Integer getPmsnCreateId() {
		return pmsnCreateId;
	}
	public final void setPmsnCreateId(Integer pmsnCreateId) {
		this.pmsnCreateId = pmsnCreateId;
	}

	@Column(name = "pmsn_name", length = 50, unique = true, nullable = false)
	public final String getPmsnName() {
		return pmsnName;
	}

	public final void setPmsnName(String pmsnName) {
		this.pmsnName = pmsnName;
	}

	@Column(name = "pmsn_description", length = 200)
	public final String getPmsnDescription() {
		return pmsnDescription;
	}

	public final void setPmsnDescription(String pmsnDescription) {
		this.pmsnDescription = pmsnDescription;
	}

	@Column(name = "pmsn_url", length = 1000)
	public final String getPmsnUrl() {
		return pmsnUrl;
	}

	public final void setPmsnUrl(String pmsnUrl) {
		this.pmsnUrl = pmsnUrl;
	}

	@Column(name = "pmsn_create_datetime", length = 50, nullable = false)
	public final String getPmsnCreateDatetime() {
		return pmsnCreateDatetime;
	}

	public final void setPmsnCreateDatetime(String pmsnCreateDatetime) {
		this.pmsnCreateDatetime = pmsnCreateDatetime;
	}

	@Column(name = "pmsn_uim_id")
	public final Integer getPmsnUimId() {
		return pmsnUimId;
	}

	public final void setPmsnUimId(Integer pmsnUimId) {
		this.pmsnUimId = pmsnUimId;
	}

	@Column(name = "pmsn_updatetime", length = 50, nullable = false)
	public final String getPmsnUpdateTime() {
		return pmsnUpdateTime;
	}

	public final void setPmsnUpdateTime(String pmsnUpdateTime) {
		this.pmsnUpdateTime = pmsnUpdateTime;
	}

	@OneToMany(targetEntity = MenuPermission.class,fetch=FetchType.LAZY)
	@Cascade({ org.hibernate.annotations.CascadeType.DELETE})
	@Transient
	public final Set<MenuPermission> getRmpSet() {
		return rmpSet;
	}

	public final void setRmpSet(Set<MenuPermission> rmpSet) {
		this.rmpSet = rmpSet;
	}

	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((pmsnId == null) ? 0 : pmsnId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Permission other = (Permission) obj;
		if (pmsnId == null) {
			if (other.pmsnId != null)
				return false;
		} else if (!pmsnId.equals(other.pmsnId))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Permission [pmsnId=" + pmsnId + ", pmsnName=" + pmsnName + ", pmsnDescription=" + pmsnDescription
				+ ", pmsnUrl=" + pmsnUrl + ", pmsnCreateDatetime=" + pmsnCreateDatetime + ", pmsnUimId=" + pmsnUimId
				+ ", pmsnUpdateTime=" + pmsnUpdateTime + "]";
	}

}
