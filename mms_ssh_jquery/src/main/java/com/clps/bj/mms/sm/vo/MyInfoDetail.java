package com.clps.bj.mms.sm.vo;
/**
 * 
 * @description 用于返回到前台的菜单数据显示
 * @className：MyInfoDetail
 * @author gg Yang
 * @version V1.0.0
 * @date 2018年1月29日上午11:41:11
 */
public class MyInfoDetail extends MyInfo{
	private String description;   //描述
	private String status;           //状态
	private String icon;              //图标
	private Integer nLevel;           //等级
	
	
	
	
	
	
	/**
	 * @return the nLevel
	 */
	public final Integer getnLevel() {
		return nLevel;
	}
	/**
	 * @param nLevel the nLevel to set
	 */
	public final void setnLevel(Integer nLevel) {
		this.nLevel = nLevel;
	}
	/**
	 * @return the description
	 */
	public final String getDescription() {
		return description;
	}
	/**
	 * @param description the description to set
	 */
	public final void setDescription(String description) {
		this.description = description;
	}
	/**
	 * @return the status
	 */
	public final String getStatus() {
		return status;
	}
	/**
	 * @param status the status to set
	 */
	public final void setStatus(String status) {
		this.status = status;
	}
	/**
	 * @return the icon
	 */
	public final String getIcon() {
		return icon;
	}
	/**
	 * @param icon the icon to set
	 */
	public final void setIcon(String icon) {
		this.icon = icon;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "[\"description\":\"" + description + "\", \"status\":" + status + ", \"icon\":\"" + icon + "\", \"id\":" + id
				+ ",\" name\":\"" + name + "\", \"url\":\"" + url +  "\"]";
	}
	
	
	
}
