/**
 * 
 */
package com.clps.bj.mms.common.util.data;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * @author erwin.wang
 *
 * Dec 19, 20174:36:52 PM
 * @param <T>
 */
public class MyFile implements Comparator<MyFile>{

	private String name;					//
	private String createdDate;				//
	
	/**
	 * 
	 */
	public MyFile() {
		super();
	}


	/**
	 * @param name
	 * @param createdDate
	 */
	public MyFile(String name, String createdDate) {
		super();
		this.name = name;
		this.createdDate = createdDate;
	}


	/* (non-Javadoc)
	 * @see java.util.Comparator#compare(java.lang.Object, java.lang.Object)
	 */
	/**
	 * @return the name
	 */
	public final String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public final void setName(String name) {
		this.name = name;
	}

	/**
	 * 
	 */
	public int compare(MyFile o1, MyFile o2) {
		if(o1.getName().equals(o2.getName())){
			return -1;
		}
		return 1;
	}


	public static void main(String[] args) {
		ArrayList<MyFile> list =new ArrayList<>();
		MyFile mf1 =new MyFile("","");
		list.add(mf1);
		Collections.sort(list,new MyFile());
		/*Map<Integer,String> g = new HashMap<Integer,String>();  
		g.put(1,"1");  
		g.put(2,"2");  
		for(Map.Entry<Integer, String> entry:g.entrySet()){  
		   System.out.println(entry.getValue());  
		} */
	}

	

	

}
