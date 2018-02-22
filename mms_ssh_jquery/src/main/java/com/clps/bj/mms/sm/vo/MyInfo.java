/**
 * 
 */
package com.clps.bj.mms.sm.vo;

import java.util.ArrayList;
import java.util.List;

/**
 * Name:MyInfo
 * Function: 拥有封装信息 
 * Reason:	 封装后的对象 
 * Date:     2018年1月20日
 * author   ygg 
 * 	 
 */
/**
 * @author ygg
 *
 */
public class MyInfo implements Comparable<MyInfo>{
	public final boolean isIschecked() {
		return ischecked;
	}
	public final void setIschecked(boolean ischecked) {
		this.ischecked = ischecked;
	}
	protected Integer id;   //自己id
	protected String name;   //名字
	protected String url;   //url地址  
	protected Integer pid;     //父类id
	protected String sort;     //等级
	protected String sortNum;     //排序号
	protected boolean ischecked;
	protected List nodes = new ArrayList();
	protected List properties = new ArrayList();
	
	
	
	
	
	/**
	 * @return the properties
	 */
	public final List getProperties() {
		return properties;
	}
	/**
	 * @param properties the properties to set
	 */
	public final void setProperties(List properties) {
		this.properties = properties;
	}
	/**
	 * @return the sortNum
	 */
	public final String getSortNum() {
		return sortNum;
	}
	/**
	 * @param sortNum the sortNum to set
	 */
	public final void setSortNum(String sortNum) {
		this.sortNum = sortNum;
	}
	/**
	 * @return the sort
	 */
	public final String getSort() {
		return sort;
	}
	/**
	 * @param sort the sort to set
	 */
	public final void setSort(String sort) {
		this.sort = sort;
	}
	/**
	 * @return the pid
	 */
	public final Integer getPid() {
		return pid;
	}
	/**
	 * @param pid the pid to set
	 */
	public final void setPid(Integer pid) {
		this.pid = pid;
	}
	/**
	 * @return the url
	 */
	public final String getUrl() {
		return url;
	}
	/**
	 * @param url the url to set
	 */
	public final void setUrl(String url) {
		this.url = url;
	}
	/**
	 * @return the id
	 */
	public final Integer getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public final void setId(Integer id) {
		this.id = id;
	}
	/**
	 * @return the name
	 */
	public final String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public final void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the nodes
	 */
	public final List getNodes() {
		return nodes;
	}
	/**
	 * @param nodes the nodes to set
	 */
	public final void setNodes(List nodes) {
		this.nodes = nodes;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "[\"id\":" + id + ", \"name\":\"" + name + "\", \"url\":\"" + url  + "\"]";
	}
	@Override
	public int compareTo(MyInfo o) {
		int res = this.sort.compareTo(o.getSort());
		if(res == 0){
			res = this.sortNum.compareTo(o.getSort());
		}
		return res;
	}
	
	
	
	
	
}
