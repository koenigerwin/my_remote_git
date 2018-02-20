package com.clps.bj.mms.common.util.data.file.dao;

import java.io.File;
import java.util.Map;

/**
 * 文件工具类的接口: 
 *           方法: 1- 文件的移动 2- 文件的创建 3-文件的遍历,并按照树状展开存储
 * 
 * @author yx 日期：2017年12月21日 修改时间:上午12:05:49
 */
public interface IFileUtil {
	/**
	 * 判断文件夹是否存在,不存在则创建 int 返回正数代表文件创建成功,负数则代表失败
	 * 
	 * @param folder:传入一个文件对象
	 * @return IFileUtil.java
	 */
	public int mkDir(File folder);

	/**
	 * 将目标文件移动到指定的文件夹 int 返回正数代表文件创建成功,负数则代表失败
	 * 
	 * @param file:目标文件
	 *            
	 * @param folder:目标文件移动到的文件夹
	 * @return IFileUtil.java
	 */
	public int removeToDir(File file, File folder,String name);

	/**
	 * 遍历该文件夹下的所有文件以树型结构存储 Map<Object,Object> :遍历该文件夹下的所有文件以树型结构存储的关系映射
	 * 
	 * @param file:一个文件对象
	 *            
	 * @param deep:代表当前文件对象所在的层级
	 *            
	 * @return IFileUtil.java
	 */
	public Map<Object, Object> listFileByDeep(File file, int deep);

	/**
	 * 包装listFileByDeep方法 Map<Object,Object>
	 * 
	 * @param file:传入一个文件对象
	 * @return IFileUtil.java
	 */
	public Map<Object, Object> listFile(File file);
}

