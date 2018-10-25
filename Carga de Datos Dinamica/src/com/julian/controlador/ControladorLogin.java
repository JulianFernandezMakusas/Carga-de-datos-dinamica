package com.julian.controlador;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/ControladorLogin")
public class ControladorLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public ControladorLogin() {
    	
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		HttpSession session = request.getSession();
		
		session.setAttribute("usuario", request.getParameter("user"));
		session.setAttribute("contrasena", request.getParameter("password"));
		
String uri = request.getRequestURI();
		
		
		RequestDispatcher rd = request.getRequestDispatcher("PaginaCargaYVer.jsp");
		RequestDispatcher rd2 = request.getRequestDispatcher("index.jsp");
		

		if(request.getParameter("user").equals("Julian") && request.getParameter("password").equals("123")) {
		
			rd.forward(request, response);
		
		}else { 
		
			session.invalidate();
			rd2.forward(request, response);

			
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
