/**
 * 
 */
package com.clps.bj.mms.common.util.data;

import java.io.File;
import java.io.IOException;

/**
 * @author erwin.wang
 *
 *         2017年12月20日下午1:30:16
 */
public class MyFileIO {

	private boolean isCreate;
	private boolean flag;
	private String pathName;
	private String myFileName;
	private String targetPath;
	private String msg;

	/**
	 * @param isCreate
	 */
	public MyFileIO() {
		this.flag = false;
		this.isCreate = false;
		this.pathName = "D:"; // 在电脑D盘下创建一个文件为HelloWorld.txt文件
		this.myFileName = "HelloWorld.txt";
		this.targetPath = "D:/IOTest";
	}

	/**
	 * 創建文件方法
	 * 
	 * @param file
	 * @return boolean true 為成功 false 創建文件失敗
	 */
	public boolean createFile(File file) {
		try {
			isCreate = file.createNewFile();
			if (isCreate) {
				this.isCreate = true;
			} else {
				this.isCreate = false;
			}
		} catch (IOException e) {
			System.out.println("创建文件失败！");
		}
		return isCreate;
	}

	/**
	 * 将制定的文件移动目标目录中的方法
	 * 
	 * @param src
	 *            原有的目录文件
	 * @param target
	 *            移动至目标目录
	 * @return boolean 移动成功为true 反之 false
	 */
	public boolean renameToDir(File src, File target) {
		if (target.mkdir()) {
			if (src.renameTo(target)) {
				this.flag = true;
			} else {
				this.flag = false;
			}
		} else {
			this.flag = false;
		}

		return flag;
	}

	/**
	 * 判断该文件是目录还是文件
	 * 
	 * @param src
	 * @return boolean true 为文件 false 为目录
	 */
	public boolean checkDirAndFile(File src) {
		if (src.isFile()) {
			this.flag = true;
		} else {
			this.flag = false;
		}

		return flag;
	}

	
}
