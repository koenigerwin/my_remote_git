/**
* @Description:SpringMVC Spring Hibernate    
* @Title: DataRecordType.java  
* @Package com.clps.bj.mms.constant   
* @author erwin.wang     
* @version V1.0 
*   
*/
package com.clps.bj.mms.constant;

/**
 * @description：主要是用于标明数据库中记录的有效性
 * @className：DataRecordType
 * @author erwin.wang
 * @version V1.0.0
 * 2018年1月22日 上午9:16:09
 */
public enum DataRecordType {

	ENABLE(1,"有效"),DISABLE(0,"无效");
	
	private Integer id;
	
	private String value;
	
	private DataRecordType(){
		
	}
	private DataRecordType(Integer id,String value){
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
