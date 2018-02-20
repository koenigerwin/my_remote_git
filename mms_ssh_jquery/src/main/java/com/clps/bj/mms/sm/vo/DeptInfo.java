/**
 * 
 */ 
package com.clps.bj.mms.sm.vo; 
/**  
 * Name:DeptInfo
 * @author Kyoma.yu
 * 2018年1月29日 下午3:07:52 
 * 
*/

public class DeptInfo extends MyInfo {
	private String date;
	private Integer createName;
	private String manager;
	/**
	 * @return the date
	 */
	public String getDate() {
		return date;
	}

	/**
	 * @param date the date to set
	 */
	public void setDate(String date) {
		this.date = date;
	}

	/**
	 * @return the createName
	 */
	public Integer getCreateName() {
		return createName;
	}

	/**
	 * @param createName the createName to set
	 */
	public void setCreateName(Integer createName) {
		this.createName = createName;
	}

	/**
	 * @return the manager
	 */
	public String getManager() {
		return manager;
	}

	/**
	 * @param manager the manager to set
	 */
	public void setManager(String manager) {
		this.manager = manager;
	}

	private String ab;

	/**
	 * @return the ab
	 */
	public String getAb() {
		return ab;
	}

	/**
	 * @param ab the ab to set
	 */
	public void setAb(String ab) {
		this.ab = ab;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "{\"text\":\"" + name + "\",\"id\":" + id +",\"children\":" + nodes+"}";
	}


	
	
	
	
	
}
 