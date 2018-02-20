package com.clps.bj.mms.common.util.sort;

import java.lang.reflect.InvocationTargetException;  
import java.lang.reflect.Method;  
import java.util.Collections;  
import java.util.Comparator;  
import java.util.List;
import java.util.logging.Logger;  
  
/*** 
 * 用户排序 
 * @author huangwei 
 * 2015年7月1日 
 * @param <E> 
 */  
public class SortList<T> {  
	
	private Logger logger = Logger.getAnonymousLogger();
	
    
	public void Sort(List<T> list, final String method, final String sort) {  
    	Collections.sort(list, new Comparator<Object>() {  
            public int compare(Object a, Object b) {  
                int ret = 0;  
                try {  
                    Method m1 = ((T) a).getClass().getMethod(method, null);  
                    Method m2 = ((T) b).getClass().getMethod(method, null);  
                    if (sort != null && "desc".equals(sort))// 倒序  
                        ret = m2.invoke(((T) b)).toString()  
                                .compareTo(m1.invoke(((T) a)).toString());  
                    else  
                        // 正序  
                        ret = m1.invoke(((T) a)).toString()  
                                .compareTo(m2.invoke(((T) b)).toString());  
                } catch (Exception it) {  
                   logger.info(it.getMessage()); 
                }  
                return ret;  
            }  
        });  
    }  
}