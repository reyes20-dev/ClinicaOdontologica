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

	public Persona traerPersonaPorDni(String dni) {
	    return controlPersis.traerPersonaPorDni(dni);
	}

	public void editarPersona(Persona per) {
	    controlPersis.editarPersona(per);
	}
	
	public List<Persona> traerPersonas() {
        return controlPersis.traerPersonas();
    }
	
}

