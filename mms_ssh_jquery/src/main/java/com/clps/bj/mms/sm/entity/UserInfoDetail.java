package com.clps.bj.mms.sm.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import com.clps.bj.mms.sm.constant.Gender;

/**
 * 
 * @Description: 用户详情信息（非必填项）
 * 
 * @className：UserInfaoDetail
 * @author jiangying
 * @version V1.0.0 2018年1月23日上午11:25:31
 */
@Entity
@Table(name = "userinfo_detail")
public class UserInfoDetail implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer userId; // 用户id
	private Gender userGender; // 枚举类型('0 女 1 男 2 其它 3 保密')
	private String userMobile; // '用户手机'
	private String userPhone; // '用户座机'
	private String userLevel; // 部门级别'0 intern 1 初级....'
	private String userDescritpion;// '用户描述'
	private String userBirth; // '用户生日'
	private String userWeixin; // '微信'
	private String userIcon; // 'f:\图片'
	private String userUpdatedDateTime;// 修改时间
	private Integer userUpdatedName;// 修改人
	private String userDefault1; // 默认字段2
	private String userDefault2; // 默认字段2
    
	//private UserInfoMain userinfo;//对应主表
	
	public UserInfoDetail() {

	}

	
	/**
	 * @return the userId
	 */
	@Id
	/*@GenericGenerator(name="pkGenerator",strategy="foreign",parameters={@Parameter(name="property",value="userinfo")})
	@GeneratedValue(generator = "pkGenerator")//userInfoDetail的表是根据userInfoMain的ID来赋值的
	*/
	 @GenericGenerator(name = "generator", strategy = "assigned")
    @GeneratedValue(generator = "generator") 
	@Column(name = "user_id")
	public Integer getUserId() {
		return userId;
	}

	/**
	 * @param userId
	 *            the userId to set
	 */
	public void setUserId(Integer userId) {
		this.userId = userId;
	}


	/**
	 * @return the userGender
	 */
	
	@Column(name = "user_gender", length = 15)
	public Gender getUserGender() {
		return userGender;
	}

	/**
	 * @param userGender
	 *            the userGender to set
	 */
	public void setUserGender(Gender userGender) {
		this.userGender = userGender;
	}

	/**
	 * @return the userMobile
	 */
	@Column(name = "user_mobile", length = 15, nullable = false, unique = true)
	public String getUserMobile() {
		return userMobile;
	}

	/**
	 * @param userMobile
	 *            the userMobile to set
	 */
	public void setUserMobile(String userMobile) {
		this.userMobile = userMobile;
	}

	/**
	 * @return the userPhone
	 */
	@Column(name = "user_phone", length = 30)
	public String getUserPhone() {
		return userPhone;
	}

	/**
	 * @param userPhone
	 *            the userPhone to set
	 */
	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}

	/**
	 * @return the userLevel
	 */
	@Column(name = "user_level", length = 2)
	public String getUserLevel() {
		return userLevel;
	}

	/**
	 * @param userLevel
	 *            the userLevel to set
	 */
	public void setUserLevel(String userLevel) {
		this.userLevel = userLevel;
	}

	/**
	 * @return the userDescritpion
	 */
	@Column(name = "user_description", length = 200)
	public String getUserDescritpion() {
		return userDescritpion;
	}

	/**
	 * @param userDescritpion
	 *            the userDescritpion to set
	 */
	public void setUserDescritpion(String userDescritpion) {
		this.userDescritpion = userDescritpion;
	}

	/**
	 * @return the userBirth
	 */
	@Column(name = "user_birth", length = 200)
	public String getUserBirth() {
		return userBirth;
	}

	/**
	 * @param userBirth
	 *            the userBirth to set
	 */
	public void setUserBirth(String userBirth) {
		this.userBirth = userBirth;
	}

	/**
	 * @return the userWeixin
	 */
	@Column(name = "user_weixin", length = 30)
	public String getUserWeixin() {
		return userWeixin;
	}

	/**
	 * @param userWeixin
	 *            the userWeixin to set
	 */
	public void setUserWeixin(String userWeixin) {
		this.userWeixin = userWeixin;
	}

	/**
	 * @return the userIcon
	 */
	@Column(name = "user_icon", length = 50, nullable = false)
	public String getUserIcon() {
		return userIcon;
	}

	/**
	 * @param userIcon
	 *            the userIcon to set
	 */
	public void setUserIcon(String userIcon) {
		this.userIcon = userIcon;
	}

	/**
	 * @return the userUpdatedDateTime
	 */
	@Column(name = "user_updated_datetime", length = 50)
	public String getUserUpdatedDateTime() {
		return userUpdatedDateTime;
	}

	/**
	 * @param userUpdatedDateTime
	 *            the userUpdatedDateTime to set
	 */
	public void setUserUpdatedDateTime(String userUpdatedDateTime) {
		this.userUpdatedDateTime = userUpdatedDateTime;
	}

	/**
	 * @return the userUpdatedName
	 */
	@Column(name = "user_updated_name", length = 30)
	public Integer getUserUpdatedName() {
		return userUpdatedName;
	}

	/**
	 * @param userUpdatedName
	 *            the userUpdatedName to set
	 */
	public void setUserUpdatedName(Integer userUpdatedName) {
		this.userUpdatedName = userUpdatedName;
	}


	/**
	 * @return the userDefault1
	 */
	@Column(name = "user_default1", length = 50)
	public String getUserDefault1() {
		return userDefault1;
	}

	/**
	 * @param userDefault1
	 *            the userDefault1 to set
	 */
	public void setUserDefault1(String userDefault1) {
		this.userDefault1 = userDefault1;
	}

	/**
	 * @return the userDefault2
	 */
	@Column(name = "user_default2", length = 50)
	public String getUserDefault2() {
		return userDefault2;
	}

	/**
	 * @param userDefault2
	 *            the userDefault2 to set
	 */
	public void setUserDefault2(String userDefault2) {
		this.userDefault2 = userDefault2;
	}

	
	

	/**
	 * @return the userInfoMain,mappedBy="userInfoDetail"
	 */
//	@OneToOne
//	@PrimaryKeyJoinColumn
	/*public UserInfoMain getUserInfoMain() {
		return userinfo;
	}*/


	/**
	 * @param userInfoMain the userInfoMain to set
	 */
	/*public void setUserInfoMain(UserInfoMain userInfoMain) {
		this.userinfo = userInfoMain;
	}*/


	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "UserInfoDetail [userId=" + userId + ", userGender=" + userGender + ", userMobile=" + userMobile
				+ ", userPhone=" + userPhone + ", userLevel=" + userLevel + ", userDescritpion=" + userDescritpion
				+ ", userBirth=" + userBirth + ", userWeixin=" + userWeixin + ", userIcon=" + userIcon
				+ ", userUpdatedDateTime=" + userUpdatedDateTime + ", userUpdatedName=" + userUpdatedName
				+ ", userDefault1=" + userDefault1 + ", userDefault2=" + userDefault2 + "]";
	}

	
	
}
