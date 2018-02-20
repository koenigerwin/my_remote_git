package com.clps.bj.mms.bm.vo;

import java.io.Serializable;
import java.util.List;

//为了符合easyUI的datagrid要求返回的数据的格式而封装的实体类
public class EasyUIDataGridResult implements Serializable {
	
	/** 
	* @Fields serialVersionUID : (用一句话描述这个变量表示什么) 
	*/ 
	private static final long serialVersionUID = 1L;
	private long total;
	private List<?> rows;
	
	public long getTotal() {
		return total;
	}
	public List<?> getRows() {
		return rows;
	}
	public void setTotal(long total) {
		this.total = total;
	}
	public void setRows(List<?> rows) {
		this.rows = rows;
	}
	@Override
	public String toString() {
		return "EasyUIDataGridResult [total=" + total + ", rows=" + rows + "]";
	}
	
	
	

}
