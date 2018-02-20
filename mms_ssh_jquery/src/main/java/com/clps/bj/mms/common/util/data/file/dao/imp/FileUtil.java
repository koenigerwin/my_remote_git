package com.clps.bj.mms.common.util.data.file.dao.imp;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

import com.clps.bj.mms.common.util.data.file.dao.IFileUtil;

	/**
	 * 文件工具类 功能:移动，遍历
	 * 
	 * @author yx 日期：2017年12月20日 修改时间:下午5:09:34
	 */
	public class FileUtil implements IFileUtil {

		public final String REG = "\t";    // 特殊符号 用来控制格式
		public  final Character c_Directory = '+';  //将这个字符加到遍历结果为文件夹的File的名字前
		public final Character c_File='-';          //将这个字符加到遍历结果为文件的File的名字前
		public static Integer Random_Key = 0;       //作为Map的key值
		Map<Object, Object> map;                    //存储映射关系

		public FileUtil() {
			//按照遍历的顺序存储
			map = new LinkedHashMap<>();
		}

		@Override
		/**
		 * 创建文件夹
		 * 
		 */
		public int mkDir(File url) {
			File fnewpath = url;
			if (!fnewpath.exists()) {
				//如果文件不存在则创建
				fnewpath.mkdirs();
				return 1;
			}
			return -1;
		}

		/**
		 * 
		 * 将文件复制到指定的文件夹
		 * param file:目标文件
		 * param folder:移动到的文件夹
		 */
		@Override
		public int removeToDir(File file, File folder,String name) {
			if (!file.isDirectory()) {
				// 检查文件夹是否存在
				mkDir(folder);
				// 用字节输入输出流
				FileInputStream fis = null;
				FileOutputStream fos = null;

				// 获取文件全路径
				String path = file.getAbsolutePath();
			//	String filename = path.substring(path.lastIndexOf("\\") + 1, path.length());
				// 创建一个在指定文件夹下与要复制文件名字相同的空文件
				

				try {
					
					// 如果文件不存在，则进行创建
					
					File file2 = new File(folder,name);
					if(!file2.exists()){
						file2.createNewFile();
						
					}
					fis = new FileInputStream(file);
					fos = new FileOutputStream(file2);
					byte[] buffer = new byte[1024];
					int length;
					// 将源文件读取,并写到目标地址
					while ((length = fis.read(buffer)) != -1) {
						fos.write(buffer, 0, length);
					}
					//删除旧地址的文件
					file.delete();
				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					try {
						fis.close();
						fos.close();
					} catch (IOException e) {

						e.printStackTrace();
					}
				}

				return 1;
			}
			return -1;
		}

		/**
		 * 遍历所有文件 并将文件以某种结构放到HashMap中
		 */
		@Override
		public Map<Object, Object> listFileByDeep(File file, int deep) {
			File flist[] = file.listFiles();
	         //判断这个文件夹下是否有文件
			if (flist == null || flist.length == 0) {
				return map;
			} else {
				for (File f : flist) {
					//拼接文件名的格式
					StringBuffer sb = new StringBuffer(f.getName());
					Random_Key++;
					if (f.isDirectory()) {
	                      //如果为目录,名字前追加
					      sb.insert(0, c_Directory);
						for (int j = 1; j < deep; j++) {
							//拼接制表符
							sb.insert(0, REG);
						}
						map.put(Random_Key, sb.toString());

						listFileByDeep(f, deep + 1);
					} else {
						//如果为文件,名字前追加
						sb.insert(0, c_File);
						for (int i = 1; i < deep; i++) {
							//拼接制表符
							sb.insert(0, REG);
						}
						map.put(Random_Key, sb.toString());
						// 这里将列出所有的文件

					}

				}
				return map;
			}

		}

		@Override
		public Map<Object, Object> listFile(File file) {
			return listFileByDeep(file, 1);
		}

		public static void main(String[] args) {
			File f = new File("D:/HelloWorld.txt");
			File f2 = new File("d:/IOTest");
			System.out.println(f.getName());
			FileUtil fu = new FileUtil();
			//fu.removeToDir(f, f2);
			
		}

}
