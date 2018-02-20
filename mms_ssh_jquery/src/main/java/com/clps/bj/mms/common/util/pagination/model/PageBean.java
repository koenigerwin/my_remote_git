package com.clps.bj.mms.common.util.pagination.model;

import java.util.List;
import java.util.logging.Logger;

import com.clps.bj.mms.common.util.pagination.constant.StartEndDefaultMaxNum;



/**
 * 
 * @function 分页模型对象
 * @author LiuLong.Mr
 *
 * 2017年12月26日下午3:40:37
 */
public class PageBean<T> {
	private Logger logger = Logger.getAnonymousLogger();
	//传入
	private int currentPage; //当前页
	private int PageSize;    //页容量 
	private int totalRecord;//总记录数(外部查询)
	
	//计算
	private int totalPage; //总页数  = (总记录+pageSize-1)/pagesize
	private int startIndex;//开始索引 =  (当前页-1)*页容量
	
	private List<T> dataList;//查询结果集
	
	//显示层的页码
	private int start;
	private int end;
	
	
	private PageBean(){}
	
	
	/**
	 * 
	 * @param currentPage	当前页
	 * @param pageSize		页长
	 * @param totalRecord	总记录数
	 */
	public PageBean(int currentPage, int pageSize,int totalRecord) {
		
		super();
		this.currentPage = currentPage;
		
		if(this.currentPage<1){
			this.currentPage=1;
		}
		this.PageSize = pageSize;
		this.totalRecord = totalRecord;
		
		//总页数
		this.totalPage = (this.totalRecord + this.PageSize -1)/this.PageSize;	
		//害怕传入非法值，算是服务端校验吗？
		if(this.currentPage>this.totalPage){
			logger.info("当前页大于总页数，逻辑错误");	
			this.startIndex = -1;
			return ;
		}
		
		//开始索引
		this.startIndex = (this.currentPage-1)*this.PageSize;
		
	
		this.start = 1;
		this.end = StartEndDefaultMaxNum.STARTENDMAXNUM;
		
		//显示页码的计算
		if(this.totalPage<=this.end){
			this.end = this.totalPage;
		}else{
			this.start = this.currentPage - StartEndDefaultMaxNum.PRENUM;
			this.end = this.currentPage + StartEndDefaultMaxNum.AFTERNUM;
			if(this.start<1){
				this.start = 1;
				this.end = StartEndDefaultMaxNum.STARTENDMAXNUM; 
			}
			if(this.end > this.totalPage){
				this.end = this.totalPage;
				this.start = this.end - (StartEndDefaultMaxNum.STARTENDMAXNUM-1);
			}
		}
		
	}
	
	/**
	 * 获取当前页
	 * @return int
	 */
	public int getCurrentPage() {
		return currentPage;
	}
	/**
	 * 获取页容量
	 * @return int
	 */
	public int getPageSize() {
		return PageSize;
	}
	/**
	 * 获取总记录数
	 * @return int
	 */
	public int getTotalRecord() {
		return totalRecord;
	}
	/**
	 * 获取总页数
	 * @return  int
	 */
	public int getTotalPage() {
		return totalPage;
	}
	/**
	 * 获取查询其实索引
	 * @return int
	 */
	public int getStartIndex() {
		return startIndex;
	}
	/**
	 * 获取结果集
	 * @return List<T>
	 */
	public List<T> getDataList() {
		return dataList;
	}
	/**
	 * 获取显示页码起始值
	 * @return int
	 */
	public int getStart() {
		return start;
	}
	/**
	 * 获取显示页码终点值
	 * @return int
	 */
	public int getEnd() {
		return end;
	}	
	
	
	
	
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}


	public void setPageSize(int pageSize) {
		PageSize = pageSize;
	}


	public void setTotalRecord(int totalRecord) {
		this.totalRecord = totalRecord;
	}


	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}


	public void setStartIndex(int startIndex) {
		this.startIndex = startIndex;
	}


	public void setDataList(List<T> dataList) {
		this.dataList = dataList;
	}


	public void setStart(int start) {
		this.start = start;
	}


	public void setEnd(int end) {
		this.end = end;
	}


	@Override
	public String toString() {
		return "PageBean [logger=" + logger + ", currentPage=" + currentPage + ", PageSize=" + PageSize
				+ ", totalRecord=" + totalRecord + ", totalPage=" + totalPage + ", startIndex=" + startIndex
				+ ", start=" + start + ", end=" + end + ", dataList=" + dataList + "]";
	}
	
	

	
}




//第几页/总页数     