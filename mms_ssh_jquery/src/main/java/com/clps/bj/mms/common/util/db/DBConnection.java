/**
 * Project Name:study_j2se_20160725
 * File Name:DB.java
 * Package Name:com.clps.training.java.basic.six
 * Date:2016年8月1日下午3:02:26
 * Copyright (c) 2016, erwin@163.com All Rights Reserved.
 *
 */

package com.clps.bj.mms.common.util.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 
 * @author erwin.wang
 *
 * 2017年12月21日下午4:02:17
 */
public class DBConnection {

	public Connection conn = null;
	private static String url = "";
	private static String username;
	private static String password;
	private Statement stmt = null;
	private String driver = "com.mysql.jdbc.Driver";
	private String queryAllCustomerInfo = "select " + "customer_id,"
			+ "customer_name," + "customer_mobile," + "customer_age "
			+ "from customer";
	private ResultSet rs = null;
	private PreparedStatement pstmt = null;
	
	

	static {
		url = "jdbc:mysql://localhost:3306/citi_crm";
		username = "root";
		password = "123";
	}

	public Connection getConnection() throws InstantiationException,
			IllegalAccessException, ClassNotFoundException, SQLException {
		Class.forName(driver).newInstance();
		conn = DriverManager.getConnection(url, username, password);
		return conn;
	}

	public ResultSet getResultBySql(String sql) throws SQLException {

		this.stmt = conn.createStatement();
		rs = stmt.executeQuery(sql);

		return rs;
	}
	
	public ResultSet getPtmtByCustomerId(String mySql,int id)throws SQLException{
		this.pstmt  = conn.prepareStatement(mySql);
		pstmt.setInt(1, id);
		rs = pstmt.executeQuery();
		return rs;
	}
	
	

	public void closeAll() {
		try {
			if (rs != null) {
				rs.close();
			} else if (stmt != null) {
				stmt.close();
			} else if (conn != null) {
				conn.close();
			} else {
				return;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/*public void start() {
		try {
			this.conn = this.getConnection();
		} catch (InstantiationException e) {
			e.printStackTrace();

		} catch (IllegalAccessException e) {
			e.printStackTrace();

		} catch (ClassNotFoundException e) {
			e.printStackTrace();

		} catch (SQLException e) {
			e.printStackTrace();

		}
		System.out.println("db connect success!");
		// ResultSet rs = this.getResultBySql();
		Customer customer = null;
		try {
			while (rs.next()) {
				customer = new Customer();
				customer.setId(rs.getInt("customer_id"));
				customer.setName(rs.getString("customer_name"));
				customer.setMobile(rs.getString("customer_mobile"));
				customer.setAge(rs.getInt("customer_age"));
				System.out.println(customer.toString());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		DBConnection db = new DBConnection();
		db.start();

	}*/
}
