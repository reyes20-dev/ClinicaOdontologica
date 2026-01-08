package com.clinica.acciones;

import com.clinica.forms.PersonaForm;
import com.clinica.logica.Controladora;
import com.clinica.logica.Persona;

import java.util.List;

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
        
 
        String action = request.getParameter("action");
        PersonaForm f = (PersonaForm) form;
             
        // LÓGICA PARA LISTAR
        if ("listar".equals(action) || action == null) { 
            List<Persona> lista = control.traerPersonas();
            request.setAttribute("listaPersonas", lista); 
            return mapping.findForward("verLista"); 
        }
        

        // ELIMINAR POR DNI
        if ("eliminar".equals(action)) {
            String dni = request.getParameter("dni");
            control.borrarPersona(dni);
            return mapping.findForward("irAInicio");
        } 

        // EDITAR / ACTUALIZAR
        if ("editar".equals(action)) {
            Persona per = control.traerPersonaPorDni(f.getDni());
            if (per != null) {
                per.setNombre(f.getNombre());
                per.setApellido(f.getApellido());
                per.setTelefono(f.getTelefono());
                per.setDireccion(f.getDireccion());
                control.editarPersona(per);
            }
            return mapping.findForward("exito");
        }

        // REGISTRO (POR DEFECTO)
        Persona per = new Persona();
        per.setDni(f.getDni());
        per.setNombre(f.getNombre());
        per.setApellido(f.getApellido());
        per.setTelefono(f.getTelefono());
        per.setDireccion(f.getDireccion());
        per.setFecha_nac(new java.util.Date()); 

        control.crearPersona(per);
       
        return mapping.findForward("irAInicio");
    }
}