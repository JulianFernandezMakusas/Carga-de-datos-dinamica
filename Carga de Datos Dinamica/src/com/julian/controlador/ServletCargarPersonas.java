package com.julian.controlador;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.julian.modelo.Persona;

@WebServlet("/ServletCargarPersonas")
public class ServletCargarPersonas extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	public ServletCargarPersonas() {
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("cargarPersonas.jsp");
		String dni = request.getParameter("dni");
		String nombre = request.getParameter("nombre");
		String apellido = request.getParameter("apellido");
		Persona people = new Persona(dni, nombre, apellido);
		people.setDni(dni);
		people.setNombre(nombre);
		people.setApellido(apellido);
		PersonaDAOBJDBCImpl metodo= new PersonaDAOBJDBCImpl();
		metodo.crearPersona(people);
		request.setAttribute("people", people);
		rd.forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
