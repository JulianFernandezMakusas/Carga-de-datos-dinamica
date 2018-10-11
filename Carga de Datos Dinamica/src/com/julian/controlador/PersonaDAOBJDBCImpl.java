package com.julian.controlador;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.julian.modelo.Persona;
import com.julian.modelo.PersonaDAO;

public class PersonaDAOBJDBCImpl implements PersonaDAO {

	private Connection con = null;
	private PreparedStatement stmt = null;
	

	@Override
	public Persona crearPersona(Persona people) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/base_de_datos_persona?useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
			con = DriverManager.getConnection(url, "root", "123");
			stmt = con.prepareStatement("INSERT INTO `base_de_datos_persona`(`DNI`, `Nombre`, `Apellido`) VALUES (?, ?, ?)");
			stmt.setString(1, people.getDni());
			stmt.setString(2, people.getNombre());
			stmt.setString(3, people.getApellido());
			stmt.executeUpdate();
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();

		} finally {
			try {
				stmt.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	@Override
	public ArrayList<Persona> verPersonas() {
		ArrayList<Persona> arraylistPersona = new ArrayList <> ();
		Persona persona;
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				String url = "jdbc:mysql://localhost:3306/base_de_datos_persona?useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
				con = DriverManager.getConnection(url, "root", "123");
				stmt =con.prepareStatement("SELECT * FROM `base_de_datos_persona`");
				ResultSet rs = stmt.executeQuery();
					while (rs.next() == true) {
						String dni = rs.getString("DNI");
						String nombre = rs.getString("Nombre");
						String apellido = rs.getString("Apellido");
						persona = new Persona (dni, nombre, apellido);
						arraylistPersona.add(persona);
					}
			} catch (SQLException | ClassNotFoundException e) {
				e.printStackTrace();
			}
		return arraylistPersona;
	}

	@Override
	public Persona borrarPersona() {
		return null;
	}
}
