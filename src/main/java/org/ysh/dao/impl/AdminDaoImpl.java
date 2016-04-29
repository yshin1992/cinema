package org.ysh.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.ysh.dao.AdminDao;
import org.ysh.domain.Administrator;
import org.ysh.util.DaoUtil;
import org.ysh.util.MD5Util;

/**
 * 管理员Dao实现
 * @author Administrator
 *
 */
public class AdminDaoImpl implements AdminDao {

	private static final String SQL_ADMIN_CREATE = "insert into administrator(username,password,create_time) values(?,?,?);";
	
	private static final String SQL_ADMIN_UPDATE = "update administrator set username = ? , password = ?";
	
	private static final String SQL_ADMIN_DELETE = "update administrator set valid_flag = 0 where id= ?";
	
	private static final String SQL_ADMIN_QUERY = "select id,create_time,valid_flag from administrator where valid_flag != 0 and username = ? and password = ? ";
	/**
	 * 添加新管理员
	 */
	public void create(Administrator admin) {
		Connection conn = DaoUtil.getConn();
		PreparedStatement pstm = null;
		try {
			pstm = conn.prepareStatement(SQL_ADMIN_CREATE);
			if(null != admin)
			{
				pstm.setString(1, admin.getUserName());
				pstm.setString(2, MD5Util.stringMD5(admin.getPasswd()));
				pstm.setTimestamp(3, new Timestamp(new Date().getTime()));
				pstm.executeUpdate();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DaoUtil.closeStmt(pstm);
			DaoUtil.closeConn(conn);
		}
		
	}
	
	/**
	 * 更新管理员信息
	 */
	public void update(Administrator admin) {
		Connection conn = DaoUtil.getConn();
		PreparedStatement pstm = null;
		try {
			pstm = conn.prepareStatement(SQL_ADMIN_UPDATE);
			if(null != admin)
			{
				pstm.setString(1, admin.getUserName());
				pstm.setString(2, MD5Util.stringMD5(admin.getPasswd()));
				pstm.executeUpdate();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DaoUtil.closeStmt(pstm);
			DaoUtil.closeConn(conn);
		}
	}

	public List<Administrator> reverse(Administrator admin,boolean fuzzy) {
		return null;
	}
	/**
	 * 删除管理员
	 */
	public void delete(Administrator admin) {
		Connection conn = DaoUtil.getConn();
		PreparedStatement pstm = null;
		try {
			pstm = conn.prepareStatement(SQL_ADMIN_DELETE);
			if(null != admin)
			{
				pstm.setInt(1, admin.getId());
				pstm.executeUpdate();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DaoUtil.closeStmt(pstm);
			DaoUtil.closeConn(conn);
		}
	}

	/**
	 * 根据用户名和密码判断当前管理员是否存在
	 */
	public Administrator query(Administrator admin) {
		Connection conn = DaoUtil.getConn();
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try {
			pstm = conn.prepareStatement(SQL_ADMIN_QUERY);
			if(null != admin)
			{
				pstm.setString(1, admin.getUserName());
				pstm.setString(2, MD5Util.stringMD5(admin.getPasswd()));
				rs = pstm.executeQuery();
				while(rs.next())
				{
					admin.setId(rs.getInt(1));
					admin.setCreateTime(rs.getTimestamp(2));
					admin.setValidFlag(rs.getBoolean(3));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DaoUtil.closeStmt(pstm);
			DaoUtil.closeConn(conn);
		}
		return admin.getId() == null ? null : admin;
	}

}
