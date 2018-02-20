/**  
 * @Title:  JsonHelper.java   
 * @Package com.clps.bj.mms.common.util.data   
 * @Description:    TODO
 * @author: snow.y     
 * @date:   2018年1月31日 上午11:51:59   
 * @version V1.0 
 * @Copyright: 2018 clps.com Inc. All rights reserved. 
 */  
package com.clps.bj.mms.common.util.data;


import java.util.Map;  
import java.util.Map.Entry;  
import java.util.Set;  
  
import com.alibaba.fastjson.JSON;  
import com.alibaba.fastjson.serializer.JSONSerializer;  
import com.alibaba.fastjson.serializer.PropertyFilter;  
import com.alibaba.fastjson.serializer.SerializeWriter;  
import com.alibaba.fastjson.serializer.SerializerFeature;  
  /**
   * 
   * @ClassName:  JsonHelpler   
   * @Description:fastjson序列化hibernate持久化对象时忽略代理的懒加载对象
   * @author:     snow.y
   * @date:       2018年1月31日 下午12:17:55 
   * @version     V1.0.0
   */
public class JsonHelpler {  
          
        public static String toJSON(Object o){  
            return JSON.toJSONString(o,SerializerFeature.WriteMapNullValue);  
        }  
  
         public static SerializeWriter toJSON(Object obj, final Map<Class<?>, Set<String>> includeMap){  
             PropertyFilter filter = new PropertyFilter() {  
                @Override  
                public boolean apply(Object source, String name, Object value) {  
                    for(Entry<Class<?>, Set<String>> entry : includeMap.entrySet()) {    
                        Class<?> class1 = entry.getKey();    
                        if(source.getClass() == class1){    
                            Set<String> fields = entry.getValue();    
                            for(String field : fields) {    
                                if(field.equals(name)){    
                                    return false;    
                                }    
                            }    
                        }    
                    }  
                    return true;   
                } };  
                SerializeWriter sw = new SerializeWriter();   
                JSONSerializer serializer = new JSONSerializer(sw);  
                serializer.getPropertyFilters().add(filter);  
                serializer.write(obj);  
                return sw;  
         }  
           
}  