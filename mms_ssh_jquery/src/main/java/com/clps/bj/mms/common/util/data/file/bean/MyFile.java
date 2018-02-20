package com.clps.bj.mms.common.util.data.file.bean;


/**
 * 
 * @description：文件工具类
 * @className：MyFile
 * @author yx
 * @version V1.0.0
 * 2017年12月21日 下午1:47:05
 */

public class MyFile {
private String filename;
private String time;
private String exType;
private String name;

public final String getExType() {
	return exType;
}

public final void setExType(final String exType) {
	this.exType = exType;
}

public final String getName() {
	return name;
}

public final void setName(final String name) {
	this.name = name;
}

public MyFile() {
	super();
}

public final String getFilename() {
	return filename;
}

public final void setFilename(final String filename) {
	this.filename = filename;
}

public final String getTime() {
	return time;
}

public final void setTime(final String time) {
	this.time = time;
}

@Override
public String toString() {
	return "MyFile [filename=" + filename + ", time=" + time + "]";
}


	



}
