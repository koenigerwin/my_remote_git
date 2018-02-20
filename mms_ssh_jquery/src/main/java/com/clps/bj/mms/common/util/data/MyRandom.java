package com.clps.bj.mms.common.util.data;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

/**
 * name:MyRandom 
 * function:生成随机数工具
 * 
 * @author bai 
 * 2017年12月26日 上午10:28:56
 */
public class MyRandom {
	private Timer t;     //定时器对象
	long middleStr;		//当前时间毫秒值
	String str;			//随机数
	String beforeStr;	
	String afterStr;

	public MyRandom() {
		super();
		this.middleStr = System.currentTimeMillis(); // 13位 当前时间毫秒值
		this.str = Double.toString(Math.random()); // 生成一个随机数
		this.beforeStr = str.substring(2, 18); // 16位    截取16位随机数
		this.afterStr = str.substring(5, 11); // 7位        截取7位随机数
	}

	/**
	 * 生成36位随机数并判定十分钟后失效
	 * @return String 返回0说明已失效  返回36位随机数则为有效
	 */
	public String getRandomNumber() {

		String result = beforeStr + middleStr + afterStr;
		// 创建定时器对象
		t = new Timer();
		// 在10分钟后执行TimerTask类中的run方法
		t.schedule(new TimerTask() {
			@Override
			public void run() {
				middleStr = 0;
			}
		}, 10*60*1000);
		if (middleStr == 0) {
			return "0";
		}else {
			return result;
		}
	}

}
