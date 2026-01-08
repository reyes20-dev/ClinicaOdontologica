package com.clinica.logica;

import java.util.List;

import com.clinica.persistencia.*;

public class Controladora {

	ControladoraPersistencia controlPersis = new ControladoraPersistencia();
	
	public void crearPersona(Persona per) {
		controlPersis.crearPersona(per);
	}
	
	public void borrarPersona(String dni) {
	    controlPersis.borrarPersonaPorDni(dni);
	}

	public Persona traerPersona(String dni) {
	    return controlPersis.traerPersonaPorDni(dni);
	}

	public Persona traerPersona(int id) {
	    return controlPersis.traerPersona(id);
	}

	public void editarPersona(Persona per) {
	    controlPersis.editarPersona(per);
	}
	
}

