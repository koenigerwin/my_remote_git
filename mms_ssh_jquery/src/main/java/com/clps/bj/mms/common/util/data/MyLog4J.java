package com.clps.bj.mms.common.util.data;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.apache.log4j.Appender;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.RollingFileAppender;

import com.clps.bj.mms.common.util.data.file.dao.imp.FileUtil;
import com.clps.bj.mms.common.util.factory.UtilFactory;


/**
 * log4j生成工具类
 * Name:MyLog4J
 * Function: 生成日志 
 * Reason:	 booelan是否成功 
 * Date:     2017年12月26日
 * author   ygg 
 * 	 
 */

public class MyLog4J {
	private Logger logger;      //日志对象
	private boolean isSuc;          //是否成功

	private MyDate myDate;          	//日期工具类
	//private String file  ;            //文件路径


	private final String LOG4J = "log4j.file";             //系统变量的路径名


	private final int KB = 1024;    //容量单位
	private final int MB = 1024*1024;  //容量单位
	private BufferedWriter bfw;         //缓存写入流
	private BufferedReader bfr;           //缓冲读取流
	private FileUtil fileUtil;             //文件操作类
	
	{
		
		myDate = UtilFactory.getInstanceOfDate();
		String customizedPath = "log4j.properties";
	    System.setProperty("log4j.configuration", customizedPath);
	    //String temp = getFilePath();
	    setSysPath( "Z:/log","3KB");
	   // System.setProperty(LOG4J, "C:\\log");
	    logger = LogManager.getLogger(MyLog4J.class);
	    fileUtil = UtilFactory.getInstanceOfFileUtil();
		//setLogProperty( "1024KB", 10);
		
		
	}
	
	
	
	
	/**
	 * 返回log4jfile路径
	 * @return String
	 */
	public String getFilePath(){
		Appender appdener = Logger.getRootLogger().getAppender("logfile");
		RollingFileAppender rFAppender = (RollingFileAppender)appdener;
		String e = rFAppender.getFile();
		
		int index= 0;
		int v1 = e.lastIndexOf("\\");
		int  v2 = e.lastIndexOf("/");
		index = v1>v2?v1:v2;
		return e.substring(0,index);
	}
	
	
	/**
	 * 求最大值
	 * @param v 要比较的数1
	 * @param v2 要比较的数2
	 * @return long
	 */
	public int max(int v,int v2){
		return v>v2?v:v2;
	}
	
	
	
	/**
	 * 获取最新版文件日志编号
	 * @param file 文件日志路径
	 * @return int
	 */
	public int getLastLogFileMax(String fileStr){
		File file = new File(fileStr);
		File[] files = file.listFiles();
		int max = 0;
		String temp = "";
		int index=0;
		for(File f:files){
			
			temp = f.getName();
			if(temp.contains(".log")){
				index = temp.lastIndexOf("_");
				if(index != 3){
					temp = temp.substring(index+1,temp.indexOf("."));
					
					index = Integer.parseInt(temp);
					max = max(max,index);
				}else{
					max = 1;
				}
			}
		}
		return max;
	}
	
	/**
	 * 获取最新的日志文件
	 * @param file 要获取的路径名
	 * @return File
	 */
	public boolean getLastLogFile(File file){
		File[] files = file.listFiles();
		int max = 0;
		max = files.length;
		String name;
		String tempName;
		File temp = null;
		File temp_last = null;
		String temp_middle = null;
		String path ="";
		if(max>1){
			//File tempFile = files[0];
			path = files[0].getAbsolutePath();
			path =path.substring(0,path.lastIndexOf("\\")+1);
			
			for(File f:files){
				name = f.getName();
				int k = name.substring(0,name.lastIndexOf(".")).indexOf(".");
				
				
				//temp_middle是要变更的.1文件对应的文件编号
				//tempName 是最新的编号文件
				//temp要更改的最新文件
				//temp_last 文件目录
				if(k!=-1){
					
					temp_middle  = name.substring(0,name.lastIndexOf("."));
					max = Integer.parseInt( temp_middle.substring(temp_middle.lastIndexOf("_")+1,temp_middle.lastIndexOf(".")))+1;
					tempName =temp_middle.substring(0,name.lastIndexOf("_")+1)+max+".log";
					
					temp_last = new File(path);
					temp = new File(path+temp_middle);
				
					
		
					//将最新版本更新
					if(fileUtil.removeToDir(temp, temp_last, tempName)==1){
						
						//将.1文件变为原始版本
						if(fileUtil.removeToDir(f, temp_last, temp_middle)==1){
							//删除文件
							
							f.delete();
						}
					}
				
					break;
				}
			}
			
		}
		
	
		
		return true;
	}
	/**
	 * 将输入的字符串换算为大小
	 * @param size 要换算的size
	 * @return double 
	 */
	public double getSize(String size){
		String unit = size.substring(size.length()-2);
		String se =size.substring(0,size.length()-2);
		double count = Double.parseDouble(se);
		
		if(unit.toUpperCase().equals("KB")){
			count = count*KB;
		}else{
			count = count*MB;
			
		}
		return count;
	}
	
	/**
	 * 设置系统变量
	 * @param envPath 设置的参数
	 * @return boolean
	 * @throws IOException 
	 */
	public boolean setSysPath(String envPath,String len) {
		isSuc = true;
		String path  = this.getClass().getResource("/log4j.properties").getPath();
		
		File file = new File(path);
		int index = path.indexOf(".");
		String se = path.substring(0, index)+"1.properties";
		File temp = new File(se);
		file.renameTo(temp);
		 
		try {
			bfw = new BufferedWriter(new FileWriter(path));
			bfr = new BufferedReader(new FileReader(temp));
			String line = "";
			String endPath = myDate.getNowStr("yyyyMMdd")+"_"+getLastLogFileMax(envPath)+".log";
			while((line =bfr.readLine()) != null){
				if(line.contains(".File")){
					bfw.write("log4j.appender.logfile.File="+envPath+"/log_"+endPath);
				}else if(line.contains(".MaxFileSize")){
					bfw.write("log4j.appender.logfile.File="+len);
				}else{
					bfw.write(line);
				}
				bfw.newLine();
			}
			bfw.flush();
			
			
		} catch (IOException e) {
			isSuc = false;
			e.printStackTrace();
		}finally{
			try {
				bfw.close();
				bfr.close();
				if(temp != null){
					
					temp.delete();
				}
			} catch (IOException e) {
				isSuc = false;
				e.printStackTrace();
			}
		}
		
		return isSuc;
		
	}
	
	/**
	 * 设置系统变量
	 * @return boolean
	 */
	public boolean setSysPro(String path){
		this.isSuc = false;
		System.setProperty(LOG4J, path);
		this.isSuc = true;
		return this.isSuc;
	}
	
	
	
	

	
	/**
	 * 打印info信息
	 * @param text
	 * @return boolean 
	 */
	public synchronized boolean info(String text){
		isSuc = false;
		this.logger.info(text);
		
		getLastLogFile(new File(getFilePath()));
		isSuc = true;
		return isSuc;
	}
	
	/**
	 * 打印error信息
	 * @param text
	 * @return boolean 
	 */
	public synchronized boolean error(String text){
		isSuc = false;
		this.logger.error(text);
		getLastLogFile(new File(getFilePath()));
		isSuc = true;
		return isSuc;
	}
	
	/**
	 * 打印warn信息
	 * @param text
	 * @return boolean 
	 */
	public synchronized boolean warn(String text){
		isSuc = false;
		this.logger.warn(text);
		getLastLogFile(new File(getFilePath()));
		isSuc = true;
		return isSuc;
	}
	
	/**
	 * 打印fatal信息
	 * @param text
	 * @return boolean 
	 */
	public synchronized boolean fatal(String text){
		isSuc = false;
		this.logger.fatal(text);
		getLastLogFile(new File(getFilePath()));
		isSuc = true;
		return isSuc;
	}
	
	
}
