package com.clps.bj.mms.sm.vo;
/**
 *@Description：idText类
 *@className：IdText
 *@author bai
 *@version
 *@date 2018年2月5日 下午2:37:13
*/
public class IdText {
	private int id;  
	private String text;
	/**
	 * 
	 */
	public IdText() {
		super();
	}
	/**
	 * @param id
	 * @param text
	 */
	public IdText(int id, String text) {
		super();
		this.id = id;
		this.text = text;
	}
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return the text
	 */
	public String getText() {
		return text;
	}
	/**
	 * @param text the text to set
	 */
	public void setText(String text) {
		this.text = text;
	}
	
	
}
