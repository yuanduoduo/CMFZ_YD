package com.baizhi.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LoginFilter implements Filter{

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req=(HttpServletRequest)request;
		HttpSession session=req.getSession();
		String Login=(String)session.getAttribute("Login");
		if("Login".equals(Login)){
			chain.doFilter(request, response);
		}else{
			HttpServletResponse hsr=(HttpServletResponse)response;
			hsr.sendRedirect("/CMFZ_YD/cmfz/login/login.jsp");
		}
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}
	
}