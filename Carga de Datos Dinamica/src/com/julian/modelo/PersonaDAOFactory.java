package com.julian.modelo;

import com.julian.controlador.PersonaDAOBJDBCImpl;

public class PersonaDAOFactory {
	public PersonaDAO createPersonaDAO() {
		return new PersonaDAOBJDBCImpl();
	}
}