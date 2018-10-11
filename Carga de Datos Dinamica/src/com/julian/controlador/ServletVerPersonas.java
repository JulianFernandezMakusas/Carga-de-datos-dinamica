package com.julian.controlador;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.julian.modelo.Persona;

@WebServlet("/ServletVerPersonas")
public class ServletVerPersonas extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public ServletVerPersonas() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("verPersonas.jsp");
		PersonaDAOBJDBCImpl metodo = new PersonaDAOBJDBCImpl();
		ArrayList <Persona> listaPersona = metodo.verPersonas();
		request.setAttribute("listaPersona", listaPersona);
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
