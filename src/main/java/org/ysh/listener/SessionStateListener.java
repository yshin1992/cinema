package org.ysh.listener;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * Session Listener
 * @author yshin1992
 *
 */
public class SessionStateListener implements HttpSessionListener {

	public void sessionCreated(HttpSessionEvent event) {
		System.out.println(event.getSession().getId()+"被创建........");
	}

	public void sessionDestroyed(HttpSessionEvent event) {
		System.out.println(event.getSession().getId()+"被销毁........");
	}

}
