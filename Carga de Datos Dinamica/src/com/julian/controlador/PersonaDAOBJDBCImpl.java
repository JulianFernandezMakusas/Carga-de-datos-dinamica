package com.julian.controlador;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.julian.modelo.Persona;
import com.julian.modelo.PersonaDAO;
import com.sun.xml.internal.bind.CycleRecoverable.Context;

public class PersonaDAOBJDBCImpl implements PersonaDAO {

	private Connection con = null;
	private PreparedStatement stmt = null;
	private InitialContext ic;
	private DataSource ds;
	public PersonaDAOBJDBCImpl() {
		try {
		ic = new InitialContext();
		ds = (DataSource)ic.lookup("java:comp/env/jdbc/personaDB");
		} catch (Exception e) {
			System.out.println("Error al hacer lookup"+e.getMessage());
		}
		
	}

	@Override
	public Persona crearPersona(Persona people) {
		try {
			con = ds.getConnection();
			stmt = con.prepareStatement("INSERT INTO `base_de_datos_persona`(`DNI`, `Nombre`, `Apellido`) VALUES (?,?,?)");
			stmt.setString(1, people.getDni());
			stmt.setString(2, people.getNombre());
			stmt.setString(3, people.getApellido());
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();

		}
		return null;
	}

	@Override
	public ArrayList<Persona> verPersonas() {
		ArrayList<Persona> arraylistPersona = new ArrayList <> ();
		Persona persona;
			try {
				ds.getConnection();
				stmt =con.prepareStatement("SELECT * FROM `base_de_datos_persona`");
				ResultSet rs = stmt.executeQuery();
					while (rs.next() == true) {
						String dni = rs.getString("DNI");
						String nombre = rs.getString("Nombre");
						String apellido = rs.getString("Apellido");
						persona = new Persona (dni, nombre, apellido);
						arraylistPersona.add(persona);
					}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		return arraylistPersona;
	}

	@Override
	public Persona borrarPersona() {
		return null;
	}
}
