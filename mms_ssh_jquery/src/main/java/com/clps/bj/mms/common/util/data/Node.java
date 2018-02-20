package com.clps.bj.mms.common.util.data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.clps.bj.mms.sm.vo.MyInfo;

/**
 * 
 * @description：用于前后台传递树状信息的工具类
 * @className：Node
 * @author gg Yang
 * @version V1.0.0
 * @date 2018年1月24日上午10:17:49
 */
public class Node {
	private static ArrayList<MyInfo> level1 = new ArrayList<>();           //一级子类list
	private static ArrayList<MyInfo> level2 = new ArrayList<>();           //二级子类list
	private static ArrayList<MyInfo> level3 = new ArrayList<>();           //三级子类list
	private static ArrayList<MyInfo> level4 = new ArrayList<>();           //四级子类list
	private static ArrayList<MyInfo> level5 = new ArrayList<>();           //五级子类list
	
	
	/**
	 * 返回分类map
	 * @param id 要分类的id
	 * @return HashMap<String, List<MyInfo>>
	 */
	public HashMap<String, List<MyInfo>> getTreeStruct(List<MyInfo> infos){
		//setLevel(infos);
		HashMap<String, List<MyInfo>> maps = new HashMap<>();
		maps.put("1", level1);
		maps.put("2", level2);
		maps.put("3", level3);
		maps.put("4", level4);
		maps.put("5", level5);
		return maps;
	}
	
	/**
	 * 返回id对应的子级
	 * @return List<MyInfo>
	 */
	/*public List<MyInfo> getTreeStructById(String id,HashMap<String, List<MyInfo>> maps,String height){
		
		List<MyInfo> infosRes = new ArrayList<>();
		List<MyInfo> infos = maps.get(height);
		for(MyInfo info:infos){
			if(info.getSortId().contains(id)){
				infosRes.add(info);
			}
		}
		return infosRes;
	}*/
	
	/**
	 * 将信息分类
	 * @param infos 要分类的list集合
	 * @return boolean 
	 */
	/*public boolean setLevel(List<MyInfo> infos){
		boolean isSuc =false;
		int height = 1;
		String sortId = "";
		for(MyInfo info:infos){
			sortId = info.getSortId();
			if(sortId.startsWith(",")){             //menu对应sortId
				height= sortId.split(",").length-1;
				putDateToLevel(height, info);
			}else{
				height = sortId.split(",").length;
				putDateToLevel(height, info);
			}
		}
		isSuc = true;
		return isSuc;
	}*/
	
	/**
	 * 填充数据到等级集合
	 * @param height 深度
	 * @param info   填充对象
	 * @return  boolean
	 */
	public boolean putDateToLevel(int height,MyInfo info){
		boolean isSuc = false;
		switch (height) {
		case 1:
			level1.add(info);
			break;
		case 2:
			level2.add(info);
			break;
		case 3:
			level3.add(info);
			break;
		case 4:
			level4.add(info);
			break;
		case 5:
			level5.add(info);
			break;
		default:
			break;
		}
		
		isSuc = true;
		return isSuc;
	}
}
