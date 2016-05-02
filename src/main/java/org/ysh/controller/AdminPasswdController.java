package org.ysh.controller;

import static org.ysh.constants.SysConstants.CUR_USER;
import static org.ysh.constants.SysConstants.RESULT_OPERATION;
import static org.ysh.constants.UrlConstants.PASSWD_UPDATE_ADMIN;
import static org.ysh.constants.UrlConstants.RESULT_OPERATE;
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
 * 管理员密码修改
 * @author yshin1992
 *
 */
public class AdminPasswdController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    /**
     * 管理员密码修改页   
     */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher(PASSWD_UPDATE_ADMIN).forward(request, response);
	}
	/**
	 * 管理员密码修改业务
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String oldpswd = request.getParameter("oldpasswd");
		String newpswd = request.getParameter("newpasswd");
		if(null != oldpswd && null != newpswd)
		{
			HttpSession session = request.getSession();
			Administrator admin = (Administrator)session.getAttribute(CUR_USER);
			String userName = admin.getUserName();
			AdminDao adminDao = new AdminDaoImpl();
			admin = adminDao.validate(userName, oldpswd.trim());
			if(null != admin){
				admin.setPasswd(newpswd);
				adminDao.update(admin);
				request.setAttribute(RESULT_OPERATION, "密码修改成功");
			}else{
				request.setAttribute(RESULT_OPERATION, "旧密码输入不正确");
			}
		}
		else
		{
			request.setAttribute(RESULT_OPERATION, "密码修改操作异常");
		}
		request.getRequestDispatcher(RESULT_OPERATE).forward(request, response);
	}

}
