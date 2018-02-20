/**
 * 
 */
package com.clps.bj.mms.sm.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PreRemove;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

/**
 * 
 * @Description：实体
 * @className：Position.java
 * @author ygg
 * @version V1.0.0
 * @date 2018年1月23日
 */

@Entity
@Table(name="position")
public class Position implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4853807308128469367L;
	
	
	private Integer positionId;             //职位id
	private String positionName;           //职位
	private String positionLocation;       //职位所在地
	private String positionCreatedDatetime; // 创建时间
	private Integer positionCreatedId; // 创建人名
	private String positionUpdatedDatetime; // 修改时间
	private Integer positionUpdatedId; // 修改人名
	private String positionDefault1; // 默认字段1
	private String positionDefault2; // 默认字段2
	private String positionAbbreviation;                 //职位缩写
	private String positionDescription;       //职位描述
	/**在职位表中需要添加的语句**/
	/**一个类型的职位对应多个用户,把职位表中的id作为用户表的外键**/
	private Set<UserInfoMain> userInfos = new HashSet<>();// 用户
	

	/*@OneToMany(targetEntity=UserInfoMain.class,cascade=CascadeType.ALL)*/
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "positionId")
	@LazyCollection(LazyCollectionOption.EXTRA)
	public Set<UserInfoMain> getUserInfos() {
			return userInfos;
	}
	
	
	
	/**
	 * @return the positionDescription
	 */
	public final String getPositionDescription() {
		return positionDescription;
	}



	/**
	 * @param positionDescription the positionDescription to set
	 */
	public final void setPositionDescription(String positionDescription) {
		this.positionDescription = positionDescription;
	}



	public void setUserInfos(Set<UserInfoMain> userInfos) {
			this.userInfos = userInfos;
	}
	
	
	
	
	/**
	 * @return the positionAbbreviation
	 */
	public final String getPositionAbbreviation() {
		return positionAbbreviation;
	}



	/**
	 * @param positionAbbreviation the positionAbbreviation to set
	 */
	public final void setPositionAbbreviation(String positionAbbreviation) {
		this.positionAbbreviation = positionAbbreviation;
	}



/*private Set<UserDetail> users;               //用户关系
*/	/**
	 * @return the positionId
	 */
	@Id
	@GenericGenerator(name="generator",strategy="increment")
	@GeneratedValue(generator="generator")
	@Column(name="position_id",length=11)
	public final Integer getPositionId() {
		return positionId;
	}
	/**
	 * @param positionId the positionId to set
	 */
	public final void setPositionId(Integer positionId) {
		this.positionId = positionId;
	}
	
	
	
	/**
	 * @return the users
	 */
	/*@OneToMany(mappedBy="position",cascade=CascadeType.ALL,targetEntity=UserDetail.class,inverse=true)
	public final Set<UserDetail> getUsers() {
		return users;
	}
	*//**
	 * @param users the users to set
	 *//*
	
	public final void setUsers(Set<UserDetail> users) {
		this.users = users;
	}*/
	
	/**
	 * @return the positionName
	 */
	@Column(name="position_name",nullable=false,unique=true,length=50)
	public final String getPositionName() {
		return positionName;
	}
	/**
	 * @param positionName the positionName to set
	 */
	public final void setPositionName(String positionName) {
		this.positionName = positionName;
	}
	/**
	 * @return the positionLocation
	 */
	@Column(name="position_location",nullable=true,length=30)
	public final String getPositionLocation() {
		return positionLocation;
	}
	/**
	 * @param positionLocation the positionLocation to set
	 */
	public final void setPositionLocation(String positionLocation) {
		this.positionLocation = positionLocation;
	}
	
	/**
	 * @return the position_created_Datetime
	 */
	@Column(name="position_create_datetime",nullable=false,length=25)
	public final String getPositionCreatedDatetime() {
		return positionCreatedDatetime;
	}
	/**
	 * @param positionCreatedDatetime the position_created_Datetime to set
	 */
	public final void setPositionCreatedDatetime(String positionCreatedDatetime) {
		this.positionCreatedDatetime = positionCreatedDatetime;
	}
	/**
	 * @return the position_created_id
	 */
	@Column(name="position_create_id",nullable=false,length=11)
	public final Integer getPositionCreatedId() {
		return positionCreatedId;
	}
	/**
	 * @param position_created_id the position_created_id to set
	 */
	public final void setPositionCreatedId(Integer position_created_id) {
		this.positionCreatedId = position_created_id;
	}
	/**
	 * @return the position_update_Datetime
	 */
	@Column(name="position_update_datetime",nullable=false,length=25)
	public final String getPositionUpdatedDatetime() {
		return positionUpdatedDatetime;
	}
	/**
	 * @param positionUpdatedDatetime the position_update_Datetime to set
	 */
	
	public final void setPositionUpdatedDatetime(String positionUpdatedDatetime) {
		this.positionUpdatedDatetime = positionUpdatedDatetime;
	}
	/**
	 * @return the position_update_id
	 */
	@Column(name="position_update_id",nullable=false,length=11)
	public final Integer getPositionUpdatedId() {
		return positionUpdatedId;
	}
	/**
	 * @param positionUpdatedId the position_update_id to set
	 */
	public final void setPositionUpdatedId(Integer positionUpdatedId) {
		this.positionUpdatedId = positionUpdatedId;
	}
	/**
	 * @return the position_default1
	 */
	@Column(name="position_default1",length=50)
	public final String getPositionDefault1() {
		return positionDefault1;
	}
	/**
	 * @param positionDefault1 the position_default1 to set
	 */
	public final void setPositionDefault1(String positionDefault1) {
		this.positionDefault1 = positionDefault1;
	}
	/**
	 * @return the position_default2
	 */
	@Column(name="position_default2",length=50)
	public final String getPositionDefault2() {
		return positionDefault2;
	}
	/**
	 * @param positionDefault2 the position_default2 to set
	 */
	public final void setPositionDefault2(String positionDefault2) {
		this.positionDefault2 = positionDefault2;
	}
	
	
}