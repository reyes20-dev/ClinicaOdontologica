package com.clinica.acciones;

import com.clinica.forms.PersonaForm;
import com.clinica.logica.Controladora;
import com.clinica.logica.Persona;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

public class PersonaAction extends Action {
    
    private Controladora control = new Controladora();

    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response) throws Exception {
        
        // Casteamos el formulario para obtener los datos
        PersonaForm f = (PersonaForm) form;
        
        // Mapeamos al objeto de lógica
        Persona per = new Persona();
        per.setDni(f.getDni());
        per.setNombre(f.getNombre());
        per.setApellido(f.getApellido());
        per.setTelefono(f.getTelefono());
        per.setDireccion(f.getDireccion());
        per.setFecha_nac(new java.util.Date()); // Fecha actual por defecto

        // Guardamos usando la controladora que ya tenías
        control.crearPersona(per);
        
        // Indicamos a Struts que todo salió bien (esto se busca en struts-config.xml)
        return mapping.findForward("exito");
    }
}