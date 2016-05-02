package org.ysh.controller;

import static org.ysh.constants.UrlConstants.LOGIN_ADMIN_INIT;
import static org.ysh.constants.UrlConstants.LOGIN_ADMIN_SUCCESS;
import static org.ysh.constants.UrlConstants.LOGIN_ADMIN_RELOGIN;
import static org.ysh.constants.SysConstants.CUR_USER;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.ysh.dao.AdminDao;
import org.ysh.dao.impl.AdminDaoImpl;
import org.ysh.domain.Administrator;

/**
 * 管理员登录控制器类
 * @author yshin1992
 */
public class AdminLoginController extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	/**
	 * 用户登录页面
	 */
	@Override
	protected void doGet(HttpServletRequest request,HttpServletResponse response)
			throws ServletException, IOException
	{
		request.getRequestDispatcher(LOGIN_ADMIN_INIT).forward(request, response);
	}

	/**
	 * 用户登录认证
	 */
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException 
	{
		AdminDao adminDao = new AdminDaoImpl();
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		if(null != username && null != password)
		{
			Administrator admin = adminDao.validate(username.trim(), password.trim());
			if(null != admin)
			{
				HttpSession session = req.getSession();
				session.setAttribute(CUR_USER, admin);
				req.getRequestDispatcher(LOGIN_ADMIN_SUCCESS).forward(req, resp);
			}
			else
			{
				req.setAttribute("loginInfo", "user valid incorrect");
				req.getRequestDispatcher(LOGIN_ADMIN_RELOGIN).forward(req, resp);
			}
		}
		else
		{
			req.getRequestDispatcher(LOGIN_ADMIN_RELOGIN).forward(req, resp);
		}
		
	}
	
}
