/**
 * 
 */
package com.clps.bj.mms.common.util.data;
/**
 * Name:MyJson
 * Function: TODO ADD FUNCTION. 
 * Reason:	 TODO ADD REASON. 
 * Date:     2018年1月18日
 * author   ygg 
 * 	 
 */
/**
 * @author ygg
 *
 */


import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import com.alibaba.fastjson.JSON;
import com.clps.bj.mms.sm.vo.MyInfo;
import com.clps.bj.mms.sm.vo.UserInfoVo;






public class MyJson {
	//private Fastjs json;   //myjson内置类
	/*ArrayList<MyInfo> myinfos;           //要填入的数据
*/	
	/**
	 * 返回树状结构的(包含当前对象)
	 * @param cid  当前id
	 * @param allInfos 所有元素的集合
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public <T extends MyInfo> T resultTree(int cid,List<? extends MyInfo > allInfos){
		MyInfo tempInfo = null;
		T currentInfo = getCurrentInfo(cid,allInfos);  			//获取当前对象
		List<T > childInfos = (List<T>) getChildInfos(cid,allInfos);         //获取子类列表
		//遍历子类菜单
		for(MyInfo myInfo:childInfos){
			tempInfo = resultTree(myInfo.getId(),allInfos);
			//添加子级
			if(currentInfo != null){
				currentInfo.getNodes().add(tempInfo);
			}
		}
		if(childInfos ==null || childInfos.size()<=0){
			childInfos = null;
		}
		return currentInfo;
		
	}
	
	
	
	/**
	 * 返回所有的树状结构字符串
	 * @param cid 当前id
	 * @param allInfos 所有对象的列表
	 * @return String
	 */
	public <T extends MyInfo> String toString(int cid,List<? extends MyInfo> allInfos){
		return JSON.toJSONString(resultTree(cid, allInfos));
	}
	
	/**
	 * 获取多个树根节点的转换为的json的字符串
	 * @param allInfos 要转换的list对象树
	 * @return String
	 */
	public String getListRoot(List<? extends MyInfo> allInfos){
		String resStr = "[";
		HashSet<String> rootSet = getTopParent(allInfos)	;
		System.err.println(rootSet.size());
		for(String id:rootSet){
			System.err.println(id);
			resStr += JSON.toJSONString(resultTree(Integer.parseInt(id), allInfos))+",";
		}
		//去掉多余的","
		resStr = resStr.substring(0,resStr.length()-1);
		resStr += "]";
		
		return resStr;
		
	}
	
	/**
	 * 返回最顶层的父类id
	 * @return HashSet<String>
	 */
	public HashSet<String> getTopParent(List<? extends MyInfo> details){
		HashSet<String> res = new HashSet<String>();
		String idStr = "";
		String sortStr = "";
		String resArr[] = null;
		int length = 0;
		for(MyInfo d:details){  //获取最大的子树
			sortStr = d.getSort();
			
			if(sortStr.startsWith(",")){   //sort_id以,开始
				resArr = sortStr.split(",");
				length = resArr.length;
				if(length <= 2){
					idStr = resArr[length-1];
				}else{
					
					idStr = resArr[2];
				}
			}else{         //sort_id以数字开始
				if(length <= 2){
					idStr = resArr[length-1];
				}else{
					
					idStr = resArr[2];
				}
							
			}
			res.add(idStr);         //获取根节点
		}
		return res;
	}
	
	
	/**
	 * 返回当前的对象的所有对象
	 * @param cid 当前对象id
	 * @param allInfos 所有对象
	 * @return List<MyInfo>
	 */
	private <T> List<? extends MyInfo> getChildInfos(int cid, List<? extends MyInfo> allInfos) {
		ArrayList<MyInfo> myInfos = new ArrayList<>();
		for(MyInfo temp:allInfos){
			if(temp.getPid() != null&& temp.getPid().equals(cid)){
				myInfos.add(temp);
				
			}
		}
		return myInfos;
	}




	/**
	 * 获取当前用户
	 * @return MyInfo
	 */
	@SuppressWarnings("unchecked")
	private <T extends MyInfo> T getCurrentInfo(Integer id,List<?  extends MyInfo> allInfos) {
		for(MyInfo temp:allInfos){
			if(id.equals(temp.getId())){
				return (T) temp;
			}
		}
		return null;
	}





	/**
	 * 通过sortId 返回子菜单的列表
	 * @param sortId 当前菜单的sortid
	 * @param myChildInfos 子菜单列表
	 * @return List<MyInfo>
	 */
	public List<MyInfo> getChild(String id,String sortId,List<MyInfo> myChildInfos){
		Iterator<MyInfo> iterator = myChildInfos.iterator();
		ArrayList<MyInfo> infos = new ArrayList<>();
		/*while(iterator.hasNext()){
			MyInfo myInfo = iterator.next();
			if(sortId.contains(myChildInfos))
		}*/

		boolean isLow = true;   //判断是否最底层
		while(iterator.hasNext()){
			MyInfo myInfo = iterator.next();
			if(myInfo.getPid().equals(id) ){       //代表是子类
				infos.add(myInfo);
				isLow = false;
			}
		}
		return infos;
		
	}
	
	/**
	 * 获取无子父级列表并转换为jsonString
	 * @param infos 要转换的对象
	 * @return String
	 */
	public String getListString(List<? extends MyInfo> infos){
		
		return JSON.toJSONString(infos);
	}
	
	
	/**
	 * 获取无子父级列表并转换为jsonString
	 * @param infos 要转换的对象
	 * @return String
	 */
	public String getStringExportParam(List<? extends MyInfo> infos){
		String res= getListString(infos);
		
		res = res.replaceAll(",\"\\w+\":\\[\\]", "");
		return res;
	}
	/**
	 * 获取无子父级列表并转换为jsonString
	 * @param infos 要转换的对象
	 * @return String
	 */
	public String getStringExportParamDetail(List<UserInfoVo> infos){
		String res= JSON.toJSONString(infos);
		
		res = res.replaceAll(",\"\\w+\":\\[\\]", "");
		return res;
	}
	
	
	
	/**
	 * 返回对应的数据字符串
	 * @param infos 要转换的数组
	 * @return String
	 */
	public String getGridString(List<? extends MyInfo> infos){
		@SuppressWarnings("rawtypes")
		List  list = resultTree(0, infos).getNodes();
		if(list != null){
			return JSON.toJSONString(list);
		}else{
			return "";
		}
	}
	
	/**
	 * 返回下拉树的数据字符串
	 * @param infos 要转换的数组
	 * @return String
	 */
	public String getComboString(List<? extends MyInfo> infos){
		return resultTree(0, infos).toString();
	}
	
	/**
	 * 返回对应的数据字符串
	 * @param infos 要转换的数组
	 * @return String
	 */
	public String getGridString2(List<? extends MyInfo> infos){
		return JSON.toJSONString(resultTree(0, infos));
	}
}
