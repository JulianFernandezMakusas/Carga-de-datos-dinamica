package com.julian.controlador;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebFilter("/FiltroLogin")
public class FiltroLogin implements Filter {
	public void init(FilterConfig fConfig) throws ServletException {}
    public FiltroLogin() {}
	public void destroy() {}
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		{
			HttpServletRequest req = (HttpServletRequest) request;
			HttpServletResponse res = (HttpServletResponse) response;
			String uri = req.getRequestURI();
			HttpSession session = req.getSession();
			if (session== null && !uri.endsWith("LoginServlet")) {
			res.sendRedirect("index.html");
			}else {
			chain.doFilter(request, response);
			}

			}
	}

}
