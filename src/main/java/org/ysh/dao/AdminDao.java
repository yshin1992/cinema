package org.ysh.dao;

import org.ysh.domain.Administrator;

/**
 * 管理员Dao
 * @author Administrator
 *
 */
public interface AdminDao extends AbstractDao<Administrator> {
	public Administrator validate(String username,String password);
}