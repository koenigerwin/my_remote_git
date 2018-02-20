package com.clps.bj.mms.sm.vo;
/**
 * 
 * @description 用于返回到前台的菜单数据显示
 * @className：MyInfoDetail
 * @author gg Yang
 * @version V1.0.0
 * @date 2018年1月29日上午11:41:11
 */
public class PositionInfo extends MyInfo{
	private String description;   //描述
	private String createName;              //创建人
	private String createDate;           //创建时间
	private String  pAbbreviation;       //缩写
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
	 * @return the createName
	 */
	public final String getCreateName() {
		return createName;
	}
	/**
	 * @param createName the createName to set
	 */
	public final void setCreateName(String createName) {
		this.createName = createName;
	}
	/**
	 * @return the createDate
	 */
	public final String getCreateDate() {
		return createDate;
	}
	/**
	 * @param createDate the createDate to set
	 */
	public final void setCreateDate(String createDate) {
		this.createDate = createDate;
	}
	/**
	 * @return the pAbbreviation
	 */
	public final String getpAbbreviation() {
		return pAbbreviation;
	}
	/**
	 * @param pAbbreviation the pAbbreviation to set
	 */
	public final void setpAbbreviation(String pAbbreviation) {
		this.pAbbreviation = pAbbreviation;
	}
	

	
}
