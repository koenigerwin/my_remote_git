package com.clps.bj.mms.bm.vo;
/** 
 *@Description: 会议参与者的vo类
 * @author candy
 * MeetingUserVo
 * 2018年2月1日 下午4:53:44
 *@version V1.0
 */
public class MeetingUserVo {

private Integer userId;
private String  userName;
public MeetingUserVo() {
	super();
}
public MeetingUserVo(Integer userId, String userName) {
	super();
	this.userId = userId;
	this.userName = userName;
}
public MeetingUserVo(Object[] obj) {
	this.userId = (Integer) obj[0];
	this.userName = (String) obj[1];
}
public Integer getUserId() {
	return userId;
}
public void setUserId(Integer userId) {
	this.userId = userId;
}
public String getUserName() {
	return userName;
}
public void setUserName(String userName) {
	this.userName = userName;
}
@Override
public String toString() {
	return "MeetingUserVo [userId=" + userId + ", userName=" + userName + "]";
}

}
