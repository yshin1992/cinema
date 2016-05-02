package org.ysh.controller;

import static org.ysh.constants.UrlConstants.REGIST_ADMIN;
import static org.ysh.constants.UrlConstants.RESULT_OPERATE;
import static org.ysh.constants.SysConstants.RESULT_OPERATION;
import static org.ysh.constants.SysConstants.CUR_USER;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.ysh.dao.AdminDao;
import org.ysh.dao.impl.AdminDaoImpl;
import org.ysh.domain.Administrator;

/**
 * 管理员注册业务类
 * @author yshin1992
 *
 */
public class AdminRegistController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	/**
	 * 注册初始页
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher(REGIST_ADMIN).forward(request, response);
	}

	/**
	 * 执行注册业务
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userName = request.getParameter("userName");
		String passwd = request.getParameter("passwd");
		if(null != userName && null != passwd){
			AdminDao adminDao = new AdminDaoImpl();
			Administrator admin = new Administrator();
			admin.setUserName(userName.trim());
			admin.setPasswd(passwd.trim());
			adminDao.create(admin);
			admin = adminDao.validate(userName.trim(), passwd.trim());
			request.getSession().setAttribute(CUR_USER, admin);
			request.setAttribute(RESULT_OPERATION, "用户创建成功");
		}else
		{
			request.setAttribute(RESULT_OPERATION, "用户创建异常");
		}
		request.getRequestDispatcher(RESULT_OPERATE).forward(request,response);
	}

}
