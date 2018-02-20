package com.clps.bj.mms.common.util.data;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Date;


/**
 * 
 * @description：将对象的空值设置为特定值
 * @className：DefaultValue
 * @author LiuLong.Mr
 * @version V1.0.0
 * 2018年1月26日上午10:36:23
 */
public class DefaultValue {
	
	/**
	 * 
	 * @param model		预设对象
	 * @return	boolean 
	 */
	public boolean setDefaultValue(Object model){
		/*  将对象的空值设置为非null,用于比较，实现通用性
		
			1.获取每个类成员变量值，逐一判断，为null则设定为特定值
				1）获取值判断==null
				2）设值
		
		
		 */
		boolean flag = false;
		if(model==null) return flag;
		Field[] fields = model.getClass().getDeclaredFields(); // 获取实体类的所有属性，返回Field数组
		try {
			for(Field temp :fields){
				String fieldName = temp.getName();
				fieldName = fieldName.substring(0,1).toUpperCase()+fieldName.substring(1);
				String type = temp.getGenericType().toString(); 
				if("class java.lang.String".equals(type)){
					Method method = model.getClass().getMethod("get"+fieldName);
					String value = (String) method.invoke(model);
					if(value == null){
						method = model.getClass().getMethod("set"+fieldName,String.class);
						method.invoke(model, "");
					}else{
						continue;
					}
					
				}
				if("class java.lang.Integer".equals(type)){
					Method method = model.getClass().getMethod("get"+fieldName);
					Integer value = (Integer) method.invoke(model);
					if(value == null){
						method = model.getClass().getMethod("set"+fieldName,Integer.class);
						method.invoke(model, 0);
					}else{
						continue;
					}
					
				}
				if("class java.util.Date".equals(type)){
					Method method = model.getClass().getMethod("get"+fieldName);
					Date value =  (Date) method.invoke(model);
					if(value==null){
						method = model.getClass().getMethod("set"+fieldName,Date.class);
						method.invoke(model,new Date());
					}
					
				}
			}
			return !flag;
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		}
		return flag;
	}
//	public static void main(String[] args) {
//		InfoLog a = new InfoLog("lll",null,null,"kkl");
//		new UserInfoLogService().setDefaultValue(a);
//		System.out.println(a);
//		//new UserInfoLogService().setDefaultValue(new InfoLog("lll","Lll",null,"kkl"));
//	}

}
