package org.ysh.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import static org.ysh.constants.UrlConstants.LOGIN_ADMIN_INIT;

/**
 * 管理员注销业务类
 * @author yshin1992
 *
 */
public class AdminLogoutController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getSession().invalidate();
		request.getRequestDispatcher(LOGIN_ADMIN_INIT).forward(request, response);
	}


}
