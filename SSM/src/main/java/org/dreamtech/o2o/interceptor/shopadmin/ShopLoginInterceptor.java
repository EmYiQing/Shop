package org.dreamtech.o2o.interceptor.shopadmin;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import org.dreamtech.o2o.entity.PersonInfo;

/**
 * 店家管理系统登录验证拦截器
 * 
 * @author Xu Yiqing
 *
 */
public class ShopLoginInterceptor extends HandlerInterceptorAdapter {

	/**
	 * 事先拦截
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		Object userObj = request.getSession().getAttribute("user");
		if (userObj != null) {
			PersonInfo user = (PersonInfo) userObj;
			if (user != null && user.getUserId() != null && user.getUserId() > 0
					&& user.getEnableStatus() == PersonInfo.ENABLED)
				return true;
		}

		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<script>");
		out.println("window.open ('" + request.getContextPath() + "/local/login?usertype=2','_self')");
		out.println("</script>");
		out.println("</html>");
		
		return false;
	}
}
