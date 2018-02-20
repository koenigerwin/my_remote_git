package com.clps.bj.mms.common.util.data;

import java.io.Serializable;
/**
 * 
 * @Description：判断是否为空对象
 * @ClassName：CompareUtil
 * @Author erwin.wang
 * @Version V1.0.0
 * 2018年1月24日 下午1:39:19
 */
public class CompareEmptyUtil implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * 判断对象是否为空
	 * @param obj
	 * @return boolean
	 */
	public static boolean isEmpty(Object obj) {
		if (obj == null)
			return true;
		return false;
	}
	
	/**
	 * 
	 * @Description:判断是空的 true 反之flase
	 * @param obj
	 * @return 
	 *
	 */
	public static boolean isNotEmpty(Object obj) {
		if (obj != null)
			return true;
		return false;
	}

	/**
	 * 判断一个int的包装类型是否为空, 如果为空, 为其默认赋值为0
	 * @param val
	 * @return
	 */
	public static int isEmptyInteger(Integer val) {
		if (val == null)
			return 0;
		return val;
	}

	/**
	 * 
	 * @param val
	 * @return
	 */
	public static long isEmptyLong(Long val) {
		if (val == null)
			return 0;
		return val;
	}

}
