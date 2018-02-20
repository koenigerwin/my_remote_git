package com.clps.bj.mms.common.util.factory;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
import org.apache.log4j.Logger;

/**
 * 
 * @author erwin.wang
 *
 * 2017年12月21日下午4:28:28
 */
public class DBFactory {
	
	private static Properties pps=null;            //属性
	private static String driver;                   //连接驱动
	private static String url;                      //连接数据库url
	private static String user;                     //用户名
	private static String password;                //密码
	private static Logger logger ;                 //log4j打印
	/**
	 * 
	 */
	static{
		logger = Logger.getLogger(DBFactory.class);
		pps=new Properties();
		/*String path = DBFactory.class.getResource("/").getPath();
		String websiteURL = (path.replace("/build/classes", "/WebContent/WEB-INF/jdbc")+ "jdbc.properties");
		try {
		InputStream in=new FileInputStream(websiteURL);
			pps.load(in);
			in.close();
		} catch (Exception e) {
			
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}*/
		
		try {
			//InputStream in = new FileInputStream("test/resources/jdbc.properties");
			InputStream in = DBFactory.class.getResourceAsStream("/jdbc.properties");
			pps.load(in);
			in.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			logger.info(e.getMessage());
		}
		
		driver = pps.getProperty("jdbc.driver");
		url = pps.getProperty("jdbc.url");
		user =pps.getProperty("jdbc.username");
		password =pps.getProperty("jdbc.password");
	}
	/**
	 * 
	 * @return
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 */
	public  static Connection getConnection() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
			Class.forName(driver).newInstance();
         return	DriverManager.getConnection(url, user, password);
	}
	/**
	 * 
	 * close:释放资源 
	 * @param rs
	 * @param pstmt
	 * @param conn
	 * @throws SQLException
	 */
	public static void close(CallableStatement cs,ResultSet rs,PreparedStatement pstmt,Connection conn) throws SQLException{
		if (cs!=null) {
			cs.close();
		}
		if (rs!=null) {
			rs.close();
		}
		if (pstmt!=null) {
			pstmt.close();
		}
		if (conn!=null) {
			conn.close();
		}   
		
		
		
		
	}
}

