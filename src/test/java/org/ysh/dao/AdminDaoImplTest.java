package org.ysh.dao;

import org.ysh.dao.impl.AdminDaoImpl;
import org.ysh.domain.Administrator;

public class AdminDaoImplTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		create();
//		query();
		delete();
	}

	public static void create()
	{
		Administrator admin = new Administrator();
		admin.setUserName("admin");
		admin.setPasswd("gimis");
		AdminDao adminDao = new AdminDaoImpl();
		adminDao.create(admin);
	}
	
	public static void query()
	{
		AdminDao adminDao = new AdminDaoImpl();
		Administrator admin = adminDao.validate("admin","gimis");
		System.out.println(admin);
	}
	
	public static void delete()
	{
		AdminDao adminDao = new AdminDaoImpl();
		Administrator admin = adminDao.validate("admin","gimis");
		adminDao.delete(admin);
	}
}
