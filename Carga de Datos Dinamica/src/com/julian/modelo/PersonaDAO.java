package com.julian.modelo;

import java.util.ArrayList;

public interface PersonaDAO {
	public Persona crearPersona(Persona persona);
	public ArrayList<Persona> verPersonas(); 
	public Persona borrarPersona();
}