package com.clps.bj.mms.common.util.db;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.clps.bj.mms.common.util.factory.DBFactory;

/**
 * 
 * @author erwin.wang
 *
 *         2017年12月21日下午4:16:51
 */
public class JDBCTemplate<T> {

	private List<T> list;
	private Connection connection = null; 				// 数据库连接对象
	private PreparedStatement pst = null; 				// SQL预编译对象
	private ResultSet rs = null; 						// 数据集对象
	private CallableStatement cs = null; 				// PL/SQL 命令对象

	/**
	 * 
	 */
	public JDBCTemplate() {
		super();
	}

	/**该方法具有增加;删除;修改
	 * boolean
	 * @param sql sql语句
	 * @param args 参数列表
	 * @return     true 操作成功,false 操作失败
	   JDBCTemplate.java
	 */
	public boolean updateData(String sql, Object... args) {
		try {
			try {
				// 获得连接
				connection = DBFactory.getConnection();
				// 创建会话
				pst = connection.prepareStatement(sql);
				// 替换占位符
				for (int i = 0; i < args.length; i++) {
					pst.setObject(i + 1, args[i]);
				}
				pst.executeUpdate();
				return true;
			} finally {
				//DBFactory.flush(cs, rs, pst, connection);
				DBFactory.close(cs, rs, pst, connection);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * 查询结果集 返回全部数据
	 * 
	 * @param sql  sql语句
	 * @param args 参数列表
	 * @param map  处理结果集的对象
	 * @return List<T> 结果集的对象列表
	 */
	public List<T> queryAll(String sql,JDBCIMapper<T> map,Object... args ) {
		list = new ArrayList<T>();
		try {
			try {
				connection = DBFactory.getConnection();
				pst = connection.prepareStatement(sql);
				// 替换占位符
				for (int i = 0; i < args.length; i++) {
					pst.setObject(i + 1, args[i]);
				}
				rs = pst.executeQuery();
				while (rs.next()) {
					T obj = map.map(rs);
					list.add(obj);
				}
			} finally {
				DBFactory.close(cs, rs, pst, connection);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	/**
	 * 按条件查询结果集 返回单条数据
	 * 
	 * @param sql  sql语句
	 * @param args 参数列表
	 * @param map  处理结果集的对象
	 * @return     
	 */
	public T queryUnique(String sql,JDBCIMapper<T> map,Object... args) {
		T obj = null;
		try {
			try {
				connection = DBFactory.getConnection();
				pst = connection.prepareStatement(sql);
				// 替换占位符
				for (int i = 0; i < args.length; i++) {
					pst.setObject(i + 1, args[i]);
				}
				rs = pst.executeQuery();
			       if(rs.next())
					obj = map.map(rs);
		
			} finally {
				
				DBFactory.close(cs, rs, pst, connection);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return obj;
	}
	/**grant 权限模块专用
	 * T     这个对象指定为k-v形式的map
	 * @param sql sql语句
	 * @param map 处理结果集的方法
	 * @param args 参数列表
	 * @return k-v形式的对象
	   JDBCTemplate.java
	 */
	public T queryUniqueMy(String sql,JDBCIMapper<T> map,Object... args) {
		T obj = null;
		try {
			try {
				connection = DBFactory.getConnection();
				pst = connection.prepareStatement(sql);
				// 替换占位符
				for (int i = 0; i < args.length; i++) {
					pst.setObject(i + 1, args[i]);
				}
				rs = pst.executeQuery();
				obj = map.map(rs);
			} finally {
				
				DBFactory.close(cs, rs, pst, connection);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return obj;
	}
}
