package com.clps.bj.mms.bm.vo;

import java.util.List;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.annotation.JSONField;
/**
 *@Description:封装ligerui所需要的参数 
 * @author candy
 * LigeruiPager
 * 2018年2月2日 上午9:50:14
 *@version V1.0
 */
public class LigeruiPager<T> {

	private List<T> Rows;
	
	private Long Total;
	
	
	public LigeruiPager() {
		super();
	}


	public LigeruiPager(List<T> rows, Long total) {
		super();
		this.Rows = rows;
		this.Total = total;
	}

	@JSONField(name ="Rows")
	public List<T> getRows() {
		return Rows;
	}


	public void setRows(List<T> rows) {
		this.Rows = rows;
	}

	@JSONField(name ="Total")
	public Long getTotal() {
		return Total;
	}


	public void setTotal(Long total) {
		this.Total = total;
	}


	@Override
	public String toString() {
		return "LigeruiPager [Rows=" + Rows + ", Total=" + Total + "]";
	}


	public String toJsonString(){
		return JSON.toJSONString(this);
	}

}
