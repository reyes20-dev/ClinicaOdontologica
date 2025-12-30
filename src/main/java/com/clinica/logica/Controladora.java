package com.clinica.logica;

import com.clinica.persistencia.*;

public class Controladora {

	ControladoraPersistencia controlPersis = new ControladoraPersistencia();
	
	public void crearPersona(Persona per) {
		controlPersis.crearPersona(per);
	}
	
}

