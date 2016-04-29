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
			 
			 //�������ݿ������ļ�
			 InputStream is = DaoUtil.class.getResourceAsStream(CFG_NAME);
			 prop.load(is);
			 //����Mysql����
			 Class.forName(prop.getProperty("db.driverClass"));
			 is.close();
		 }catch(Exception e)
		 {
			 e.printStackTrace();
		 }
		 
	 }
	/**
	 * ��ȡ���ݿ�����
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
	 * �ر����ݿ�����
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
	 * �ر�Statement
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
	 * �رս����
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
