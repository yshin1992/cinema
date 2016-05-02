package org.ysh.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import static org.ysh.constants.SysConstants.CUR_USER;
import static org.ysh.constants.UrlConstants.LOGIN_ADMIN_INIT;
import static org.ysh.constants.UrlConstants.LOGIN_ADMIN_SUCCESS;

/**
 * Url访问过滤器
 * @author yshin1992
 *
 */
public class UrlAccessFilter implements Filter {
	
	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest)request;
		String accessUrl = req.getRequestURI();
		if(accessUrl.indexOf("admin") != -1)
		{
			//管理员在未登录时进行除了登录或注册的操作时，返回登录页
			if(accessUrl.indexOf("/admin/login") == -1 &&  accessUrl.indexOf("/admin/regist") == -1){
				if(null == req.getSession().getAttribute(CUR_USER)){
					req.getRequestDispatcher(LOGIN_ADMIN_INIT).forward(request, response);
					return ;
				}
			}
			//管理员在登录之后，再次进入登录页时，返回到登录后的首页
			else
			{
				if(null != req.getSession().getAttribute(CUR_USER)){
					req.getRequestDispatcher(LOGIN_ADMIN_SUCCESS).forward(request, response);
					return ;
				}
			}
		}
		chain.doFilter(request, response);
	}

	public void init(FilterConfig arg0) throws ServletException {
	}

}
