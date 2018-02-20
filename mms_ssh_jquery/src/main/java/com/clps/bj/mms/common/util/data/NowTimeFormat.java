/**  
 * All rights Reserved, Designed By www.tydic.com
 * @Title:  NowTimeFormat.java   
 * @Package com.clps.bj.mms.common.util.data   
 * @Description:    TODO
 * @author: snow     
 * @date:   2018年1月25日 上午12:15:21   
 * @version V1.0 
 * @Copyright: 2018 clps.com Inc. All rights reserved. 
 */
package com.clps.bj.mms.common.util.data;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import com.clps.bj.mms.constant.TimeFormatConstant;

/**
 * @ClassName: NowTimeFormat
 * @Description:以指定格式输出当前时间
 * @author: snow
 * @date: 2018年1月25日 上午12:15:21
 * @version
 */
public class NowTimeFormat {
	private NowTimeFormat() {
		super();
	}
//单例
	private static class Holder {
		private static final NowTimeFormat TIME_FORMAT = new NowTimeFormat();

		private Holder() {

		}
	}

	public static NowTimeFormat getNowTimeFormat() {
		return Holder.TIME_FORMAT;
	}
    public String getNowTime(){
    	return getNowTime(TimeFormatConstant.Y_M_D_H_M_S);
    }
	public String getNowTime(String format) {
		LocalDateTime now = LocalDateTime.now();
		DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(format);
		String time = now.format(dateTimeFormatter);
		return time;
	}
}
