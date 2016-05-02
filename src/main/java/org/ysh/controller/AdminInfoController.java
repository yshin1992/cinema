package org.ysh.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import static org.ysh.constants.UrlConstants.INFO_ADMIN;
/**
 * 管理员信息业务类
 */
public class AdminInfoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    /**
     * 管理员详细信息
     */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher(INFO_ADMIN).forward(request, response);
	}

}
