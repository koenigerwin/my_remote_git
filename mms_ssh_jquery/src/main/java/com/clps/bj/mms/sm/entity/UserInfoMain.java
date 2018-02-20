package com.clps.bj.mms.sm.entity;

import java.io.Serializable;
import java.util.HashSet;
//import java.util.HashSet;
//import java.util.Set;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import com.clps.bj.mms.bm.entity.Meeting;
import com.clps.bj.mms.bm.entity.MeetingUser;

//import com.clps.bj.mms.bm.entity.Meeting;
//import com.clps.bj.mms.bm.entity.MeetingUser;

/**
 * 
 * @Description: 用户主表 （信息为必填信息）
 * 
 * @className：UserInfoMain
 * @author jiangying
 * @version V1.0.0 2018年1月23日上午11:15:18
 */
@Entity
@Table(name = "userinfo_main")
public class UserInfoMain implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer userId; // 用户id
	private String userLogon; // 用户登录名
	private String userPassword;// DEFAULT 123456 COMMENT 'md5加密'
	private String userName; // '用户真实姓名'
	private String userEmail; // '用户邮箱'
	private Integer userStatus; // '0-未激活状态,1-已激活状态,2-未审核通过'
	private String userIsEnable; // 记录状态 0 是删除数据 1是有效数据，未删除（物理删除业务）
	private String userCreatedDatetime;// 创建日期
	private Integer userCreatedName; // 创建人

	// 多个用户对应一个职位
	private Position positionId;// 职位id
	// 用户角色id 一个角色对应多个用户
	 private Role roleId;
	// 多个用户对应一个部门 ManyToOne
	 private Department deptId;// 部门id
	// 一个用户创建多个会议
	
	// private Set<Meeting> meetings = new HashSet<>();// 会议
		
	// private Set<MeetingUser> mu=new HashSet<>(); // 会议参与者
     
	 
   //  private UserInfoDetail userInfoDetail;//用户主表和详细表是一对一的关系  (基于外键方式)
	 
	public UserInfoMain() {
		super();
	}
	
	/**
	 * 
	 * @param Object[] obj
	 * @param userEmail
	 * 
	 */  
	public UserInfoMain(Object[] obj) {
		this.userId=(Integer) obj[0];
		this.userName=(String) obj[1];
	}
	
	/**
	 * @param userId
	 * @param userName
	 * @param userEmail
	 * @param userCreatedDatetime
	 * @param userCreatedName
	 * @param positionId
	 * @param roleId
	 * @param deptId
	 */                         
	public UserInfoMain(Integer userId, String userName, String userEmail, String userCreatedDatetime,
			Integer userCreatedName, Position positionId, Role roleId, Department deptId) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.userEmail = userEmail;
		this.userCreatedDatetime = userCreatedDatetime;
		this.userCreatedName = userCreatedName;
		this.positionId = positionId;
		this.roleId = roleId;
		this.deptId = deptId;
	}
	
	public UserInfoMain(Integer userId, String userName,String userLogon, Integer userStatus,String userEmail,String userCreatedDatetime,
			Integer userCreatedName) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.userLogon = userLogon;
		this.userStatus = userStatus;
		this.userEmail = userEmail;				
		this.userCreatedDatetime = userCreatedDatetime;
		this.userCreatedName = userCreatedName;
		
	}
	/**
	 * @param userId
	 * @param userName
	 * @param userEmail
	 * @param userCreatedDatetime
	 * @param userCreatedName
	 */                         
	public UserInfoMain(Integer userId, String userName, String userEmail, String userCreatedDatetime,
			Integer userCreatedName) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.userEmail = userEmail;
		this.userCreatedDatetime = userCreatedDatetime;
		this.userCreatedName = userCreatedName;
		
	}


	/**
	 * @return the userId
	 */
	@Id
	@GenericGenerator(name = "generator", strategy = "increment") // 设置主键自增
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
	 * @return the userLogon
	 */
	@Column(name = "user_logon", length = 30, nullable = false, unique = true)
	public String getUserLogon() {
		return userLogon;
	}

	/**
	 * @param userLogon
	 *            the userLogon to set
	 */
	public void setUserLogon(String userLogon) {
		this.userLogon = userLogon;
	}
	
	/**
	 * @return the userPassword
	 */
	@Column(name = "user_password", length = 50, nullable = false)
	public String getUserPassword() {
		return userPassword;
	}

	/**
	 * @param userPassword
	 *            the userPassword to set
	 */
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	/**
	 * @return the userName
	 */
	@Column(name = "user_name", length = 50, nullable = false)
	public String getUserName() {
		return userName;
	}

	/**
	 * @param userName
	 *            the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * @return the userEmail
	 */
	@Column(name = "user_email", length = 30, nullable = false, unique = true)
	public String getUserEmail() {
		return userEmail;
	}

	/**
	 * @param userEmail
	 *            the userEmail to set
	 */
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	/**
	 * @return the userStatus
	 */
	@Column(name = "user_status", length = 10, nullable = false)
	public Integer getUserStatus() {
		return userStatus;
	}

	/**
	 * @param userStatus
	 *            the userStatus to set
	 */
	public void setUserStatus(Integer userStatus) {
		this.userStatus = userStatus;
	}
	
	/**
	 * @return the isEnable
	 */
	@Column(name = "user_isEnable", length = 10)
	public String getUserIsEnable() {
		return userIsEnable;
	}
	/**
	 * @param isEnable
	 *            the isEnable to set
	 */
	public void setUserIsEnable(String userIsEnable) {
		this.userIsEnable = userIsEnable;
	}
	/**
	 * @return the userCreatedDatetime
	 */
	@Column(name = "user_created_datetime", length = 50, nullable = false)
	public String getUserCreatedDatetime() {
		return userCreatedDatetime;
	}

	/**
	 * @param userCreatedDatetime
	 *            the userCreatedDatetime to set
	 */
	public void setUserCreatedDatetime(String userCreatedDatetime) {
		this.userCreatedDatetime = userCreatedDatetime;
	}

	/**
	 * @return the userCreatedName
	 */
	@Column(name = "user_created_name", length = 30, nullable = false)
	public Integer getUserCreatedName() {
		return userCreatedName;
	}

	/**
	 * @param userCreatedName
	 *            the userCreatedName to set
	 */
	public void setUserCreatedName(Integer userCreatedName) {
		this.userCreatedName = userCreatedName;
	}

	/**
	 * @return the deptId
	 */
	 @ManyToOne
	 @JoinColumn(name = "user_dept_id")
	public Department getDeptId() {
		return deptId;
	}
	 /**
	  * @param deptId
	  *        the deptId to set
	  */
	public void setDeptId(Department deptId) {
		this.deptId = deptId;
	}

	
	/**
	 * @return the position
	 */
	@ManyToOne
	@JoinColumn(name = "user_per_id")
	public Position getPositionId() {
		return positionId;
	}

	/**
	 * @param position
	 *            the position to set
	 */
	public void setPositionId(Position positionId) {
		this.positionId = positionId;
	}

	/**
	 * @return the roleId
	 */
	@ManyToOne
	@JoinColumn(name="user_role_id")
	public Role getRoleId() {
		return roleId;
	}
	/**
	 * @param roleId
	 *            the roleId to set
	 */
	public void setRoleId(Role roleId) {
		this.roleId = roleId;
	}
	
	/**
	 * @return the meetings
	 */
	
	/*@OneToMany(mappedBy = "userinfo")
	public Set<Meeting> getMeetings() {
		return meetings;
	}*/
	
	/**
	 * @param meetings
	 *            the meetings to set
	 */
	/*public void setMeetings(Set<Meeting> meetings) {
		this.meetings = meetings;
	}*/

	/*@OneToMany(mappedBy="userinfo")
	@LazyCollection(LazyCollectionOption.EXTRA)
	public Set<MeetingUser> getMu() {
		return mu;
	}
	*/
	/**
	 * @param mu void
	 */
	/*public void setMu(Set<MeetingUser> mu) {
		this.mu = mu;
	}*/
 
	

	/**
	 * @return the userInfoDetail
	 */
//	@OneToOne
//	@PrimaryKeyJoinColumn
	
	/*@OneToOne
	@JoinColumn
	public UserInfoDetail getUserInfoDetail() {
		return userInfoDetail;
	}*/

	/**
	 * @param userInfoDetail the userInfoDetail to set
	 */
	/*public void setUserInfoDetail(UserInfoDetail userInfoDetail) {
		this.userInfoDetail = userInfoDetail;
	}*/

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "UserInfoMain [userId=" + userId + ", userLogon=" + userLogon + ", userPassword=" + userPassword
				+ ", userName=" + userName + ", userEmail=" + userEmail + ", userStatus=" + userStatus
				+ ", userIsEnable=" + userIsEnable + ", userCreatedDatetime=" + userCreatedDatetime
				+ ", userCreatedName=" + userCreatedName + ", positionId=" + positionId + ", roleId=" + roleId
				+ ", deptId=" + deptId + "]";
	}
}
