package com.clps.bj.mms.bm.constant;

/**
 * 
 * @Description: 用户的会议状态类型
 * @author lcd MeetingStatusType 2018年1月23日 下午12:18:04
 * @version V1.0
 */
public enum MeetingStatusType {

	ISEND(0,"已结束"),NOEND(1,"未结束");
private Integer id;
	
	private String value;
	
	private MeetingStatusType(){
		
	}
	private MeetingStatusType(Integer id,String value){
		this.id =id;
		this.value=value;
	}
	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * @return the value
	 */
	public String getValue() {
		return value;
	}
	/**
	 * @param value the value to set
	 */
	public void setValue(String value) {
		this.value = value;
	}
	
}
