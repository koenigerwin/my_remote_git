/**
 * 
 */
package com.clps.bj.mms.sm.vo;

import com.clps.bj.mms.sm.constant.Gender;
import com.clps.bj.mms.sm.entity.UserInfoDetail;
import com.clps.bj.mms.sm.entity.UserInfoMain;

/**
 * @Description 封装一些信息
 * @author JiangYing
 * @Since V1.0.0 2018年1月29日下午3:36:36
 */
public class UserInfoVo {
	private Integer userId; // 用户id
	private String userLogon;//用户登录名
	private String userName; // '用户真实姓名'
	private Gender userGender; // 枚举类型('0 女 1 男 2 其它 3 保密')
	private String userMobile; // '用户手机'
	
	private String userPassWord;//用户密码
	
	private String userEmail; // '用户邮箱'
	private String userWeiXin;//'用户微信'
	private Integer userStatus;//'用户状态'
	private String userCreatedDatetime;// 创建日期
	private Integer userCreatedName; // 创建人
	
	private String userUpdatedDateTime;// 修改时间
	private Integer userUpdatedName;// 修改人
	
	private String userIcon; // 'f:\图片'
	private String userPhone; // '用户座机'
	
	private String userBirth;//用户生日
	private String userDescription;//用户描述
	
	
	private Integer roleId;//角色id
	private String roleName;//角色名
	private Integer deptId;//部门id
	private String deptName;//部门名称
	private String deptAB;//部门简称
	private Integer postionId;//职位id
	private String postionName;//职位名


	


	/**
	 * @return the userId
	 */
	public Integer getUserId() {
		return userId;
	}


	/**
	 * @param userId the userId to set
	 */
	public void setUserId(Integer userId) {
		this.userId = userId;
	}


	/**
	 * @return the userLogon
	 */
	public String getUserLogon() {
		return userLogon;
	}


	/**
	 * @param userLogon the userLogon to set
	 */
	public void setUserLogon(String userLogon) {
		this.userLogon = userLogon;
	}


	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}


	/**
	 * @param userName the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}


	/**
	 * @return the userGender
	 */
	public Gender getUserGender() {
		return userGender;
	}


	/**
	 * @param userGender the userGender to set
	 */
	public void setUserGender(Gender userGender) {
		this.userGender = userGender;
	}


	/**
	 * @return the userMobile
	 */
	public String getUserMobile() {
		return userMobile;
	}


	/**
	 * @param userMobile the userMobile to set
	 */
	public void setUserMobile(String userMobile) {
		this.userMobile = userMobile;
	}


	/**
	 * @return the userPassWord
	 */
	public String getUserPassWord() {
		return userPassWord;
	}


	/**
	 * @param userPassWord the userPassWord to set
	 */
	public void setUserPassWord(String userPassWord) {
		this.userPassWord = userPassWord;
	}


	/**
	 * @return the userEmail
	 */
	public String getUserEmail() {
		return userEmail;
	}


	/**
	 * @param userEmail the userEmail to set
	 */
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}


	/**
	 * @return the userWeiXin
	 */
	public String getUserWeiXin() {
		return userWeiXin;
	}


	/**
	 * @param userWeiXin the userWeiXin to set
	 */
	public void setUserWeiXin(String userWeiXin) {
		this.userWeiXin = userWeiXin;
	}


	/**
	 * @return the userStatus
	 */
	public Integer getUserStatus() {
		return userStatus;
	}


	/**
	 * @param userStatus the userStatus to set
	 */
	public void setUserStatus(Integer userStatus) {
		this.userStatus = userStatus;
	}


	/**
	 * @return the userCreatedDatetime
	 */
	public String getUserCreatedDatetime() {
		return userCreatedDatetime;
	}


	/**
	 * @param userCreatedDatetime the userCreatedDatetime to set
	 */
	public void setUserCreatedDatetime(String userCreatedDatetime) {
		this.userCreatedDatetime = userCreatedDatetime;
	}


	/**
	 * @return the userCreatedName
	 */
	public Integer getUserCreatedName() {
		return userCreatedName;
	}


	/**
	 * @param userCreatedName the userCreatedName to set
	 */
	public void setUserCreatedName(Integer userCreatedName) {
		this.userCreatedName = userCreatedName;
	}


	/**
	 * @return the userUpdatedDateTime
	 */
	public String getUserUpdatedDateTime() {
		return userUpdatedDateTime;
	}


	/**
	 * @param userUpdatedDateTime the userUpdatedDateTime to set
	 */
	public void setUserUpdatedDateTime(String userUpdatedDateTime) {
		this.userUpdatedDateTime = userUpdatedDateTime;
	}


	/**
	 * @return the userUpdatedName
	 */
	public Integer getUserUpdatedName() {
		return userUpdatedName;
	}


	/**
	 * @param userUpdatedName the userUpdatedName to set
	 */
	public void setUserUpdatedName(Integer userUpdatedName) {
		this.userUpdatedName = userUpdatedName;
	}


	/**
	 * @return the userIcon
	 */
	public String getUserIcon() {
		return userIcon;
	}


	/**
	 * @param userIcon the userIcon to set
	 */
	public void setUserIcon(String userIcon) {
		this.userIcon = userIcon;
	}


	/**
	 * @return the userPhone
	 */
	public String getUserPhone() {
		return userPhone;
	}


	/**
	 * @param userPhone the userPhone to set
	 */
	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}


	/**
	 * @return the userBirth
	 */
	public String getUserBirth() {
		return userBirth;
	}


	/**
	 * @param userBirth the userBirth to set
	 */
	public void setUserBirth(String userBirth) {
		this.userBirth = userBirth;
	}


	/**
	 * @return the userDescription
	 */
	public String getUserDescription() {
		return userDescription;
	}


	/**
	 * @param userDescription the userDescription to set
	 */
	public void setUserDescription(String userDescription) {
		this.userDescription = userDescription;
	}


	

	/**
	 * @return the roleId
	 */
	public Integer getRoleId() {
		return roleId;
	}


	/**
	 * @param roleId the roleId to set
	 */
	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}


	/**
	 * @return the roleName
	 */
	public String getRoleName() {
		return roleName;
	}


	/**
	 * @param roleName the roleName to set
	 */
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}


	/**
	 * @return the deptId
	 */
	public Integer getDeptId() {
		return deptId;
	}


	/**
	 * @param deptId the deptId to set
	 */
	public void setDeptId(Integer deptId) {
		this.deptId = deptId;
	}


	/**
	 * @return the deptName
	 */
	public String getDeptName() {
		return deptName;
	}


	/**
	 * @param deptName the deptName to set
	 */
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}


	/**
	 * @return the deptAB
	 */
	public String getDeptAB() {
		return deptAB;
	}


	/**
	 * @param deptAB the deptAB to set
	 */
	public void setDeptAB(String deptAB) {
		this.deptAB = deptAB;
	}


	/**
	 * @return the postionId
	 */
	public Integer getPostionId() {
		return postionId;
	}


	/**
	 * @param postionId the postionId to set
	 */
	public void setPostionId(Integer postionId) {
		this.postionId = postionId;
	}


	/**
	 * @return the postionName
	 */
	public String getPostionName() {
		return postionName;
	}


	/**
	 * @param postionName the postionName to set
	 */
	public void setPostionName(String postionName) {
		this.postionName = postionName;
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "UserInfoVo [userId=" + userId + ", userLogon=" + userLogon + ", userName=" + userName + ", userGender="
				+ userGender + ", userMobile=" + userMobile + ", userPassWord=" + userPassWord + ", userEmail="
				+ userEmail + ", userWeiXin=" + userWeiXin + ", userStatus=" + userStatus + ", userCreatedDatetime="
				+ userCreatedDatetime + ", userCreatedName=" + userCreatedName + ", userUpdatedDateTime="
				+ userUpdatedDateTime + ", userUpdatedName=" + userUpdatedName + ", userIcon=" + userIcon
				+ ", userPhone=" + userPhone + ", userBirth=" + userBirth + ", userDescription=" + userDescription
				+ ",  roleId="
				+ roleId + ", roleName=" + roleName + ", deptId=" + deptId + ", deptName=" + deptName + ", deptAB="
				+ deptAB + ", postionId=" + postionId + ", postionName=" + postionName + "]";
	}
	
	
}
