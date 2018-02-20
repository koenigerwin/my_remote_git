/**
 * 
 */
package com.clps.bj.mms.common.util.factory;



import com.clps.bj.mms.common.util.data.CompareEmptyUtil;
import com.clps.bj.mms.common.util.data.GrantVOHelper;
import com.clps.bj.mms.common.util.data.MyDate;
import com.clps.bj.mms.common.util.data.MyFileIO;
import com.clps.bj.mms.common.util.data.MyLog4J;
import com.clps.bj.mms.common.util.data.MyRandom;
import com.clps.bj.mms.common.util.data.MyTree;
import com.clps.bj.mms.common.util.data.NowTimeFormat;
import com.clps.bj.mms.common.util.data.StringFormat;
import com.clps.bj.mms.common.util.data.file.dao.imp.FileUtil;
import com.clps.bj.mms.common.util.db.JDBCTemplate;
import com.clps.bj.mms.common.util.pagination.dao.PaginationDao;
import com.clps.bj.mms.common.util.pagination.dao.impl.PaginationDaoImpl;
import com.clps.bj.mms.common.util.sort.SortList;
import com.clps.bj.mms.sm.entity.RoleMenuPermission;




/**
 * @author erwin.wang
 *
 * 2017年12月19日下午5:04:27
 * @param <T>
 */
public class UtilFactory {
	private static UtilFactory utilFactory;        //工具类成员变量
	
	private UtilFactory(){
		
	}
	
	
	/**
	 * 字符串中的格式化：
	 * 			1）判断是否有中文字符  boolean
	 * 			2）判断字符串是否是字母  boolean
	 * 			3） 
	 * 
	 * @return StringFormat
	 */
	public static StringFormat getInstanceOfStringFormat(){
		return new StringFormat();
	}
	/**
	 * 獲取文件的方法
	 * 			1）創建新文件
	 * 			2）創建文件夾
	 * 			3）移動或剪切文件至目標目錄
	 * 
	 * 
	 * @return MyFileIO
	 */
	public static MyFileIO getInstanceOfFile(){
		return new MyFileIO();
	}
	
	/**
	 * 工具类获取工具类对象
	 * @return UtilFactory 返回的工具类
	 */
	public static UtilFactory newInstance(){
		utilFactory = new UtilFactory();
		return utilFactory;
	}
	
	/**
	 * 通过类来获取对应的工具类
	 * @param cs
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public  static JDBCTemplate getInstanceOfJDBC(){
		return new JDBCTemplate<>();
	}
	
	/**
	 * 获取日期工具类
	 * @return DateFactory 日期工具类
	 */
	public static MyDate getInstanceOfDate(){
		return new MyDate();
	}
	
	/**
	 * 获取随机数工具类
	 * @return MyRandom 随机数工具类
	 */
	public static MyRandom getInstanceOfMyRandom(){
		return new MyRandom();
	}
	/**
	 * 获取log4j对象
	 * @return MyLog4j
	 */
	public static MyLog4J getInstanceOfLog4J(){
		return new MyLog4J();
	}

	public static JDBCTemplate<RoleMenuPermission> getInstanceOfItems(){
		return new JDBCTemplate<RoleMenuPermission>();
	}
	/**返回文件遍历和移动功能的工具类
	 *  FileUtil
	 * @return
	   UtilFactory.java
	 */
	public static FileUtil getInstanceOfFileUtil() {
		return new FileUtil();
	}
	
	/**
	 * 获取分页工具类
	 * @return PaginationDao
	 */
	@SuppressWarnings("rawtypes")
	public static PaginationDao getInstanceOfPageInationDao(){
		return new PaginationDaoImpl<>();
	}
	
	/**
	 * 获取排序实例
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public static<T> SortList getInstanceOfMySort(){
		return new SortList<T>();
	}
	
	/**
	 * 返回树工具类
	 * @return  MyTree
	 */
	public static <T> MyTree<T> getInstanceOfMyTree(){
		return new MyTree<T>();
	} 
	
	/**
	 * 
	 * @Description:判断对象是否为空值返回 boolean
	 * @return
	 *
	 */
	public static CompareEmptyUtil getInstanceOfEmptyObject(){
		return new CompareEmptyUtil();
	}
	/**
	 * 
	 * @Description 以指定格式获取当前时间
	 * @param format  时间格式
	 * @return String       
	 *
	 */
    public static NowTimeFormat getInstanceOfNowTimeFormat( ){
    	return NowTimeFormat.getNowTimeFormat();
    }
    /**
     * 
     * @Description 获取grant模块vo封装工具类实例
     * @return GrantVOHelper       
     *
     */
    public static GrantVOHelper getInstanceOfGrantVOHelper(){
    	return new GrantVOHelper();
    }
}
