package org.ysh.util;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class DaoUtil {
	private DaoUtil(){}
	private static final String CFG_NAME = "/cfg.properties";
	
	private static final Properties prop = new Properties(); 
	
	 static{
		 try{
			 
			 //加载数据库配置文件
			 InputStream is = DaoUtil.class.getResourceAsStream(CFG_NAME);
			 prop.load(is);
			 //加载Mysql驱动
			 Class.forName(prop.getProperty("db.driverClass"));
			 is.close();
		 }catch(Exception e)
		 {
			 e.printStackTrace();
		 }
		 
	 }
	/**
	 * 获取数据库连接
	 * @return
	 */
	public static Connection getConn()
	{
		Connection conn = null;
		try {
			conn =  DriverManager.getConnection(prop.getProperty("db.url"), prop.getProperty("db.username"), prop.getProperty("db.password"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}
	/**
	 * 关闭数据库连接
	 * @param conn
	 */
	public static void closeConn(Connection conn)
	{
		try {
			if(null != conn)
			{
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 关闭Statement
	 */
	public static void closeStmt(Statement stmt)
	{
		try {
			if(null != stmt)
			{
				stmt.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 关闭结果集
	 */
	public static void closeResultSet(ResultSet rs)
	{
		try {
			if(null != rs)
			{
				rs.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}