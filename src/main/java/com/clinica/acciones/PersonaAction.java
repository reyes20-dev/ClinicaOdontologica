package com.clinica.acciones;

import com.clinica.forms.PersonaForm;
import com.clinica.logica.Controladora;
import com.clinica.logica.Persona;
import java.util.List;
import java.text.SimpleDateFormat;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

public class PersonaAction extends Action {
    
    private Controladora control = new Controladora();
    private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response) throws Exception {
        
        String action = request.getParameter("action");
        PersonaForm f = (PersonaForm) form;
             
        // 1. LISTAR
        if ("listar".equals(action) || action == null) { 
            List<Persona> lista = control.traerPersonas();
            request.setAttribute("listaPersonas", lista); 
            return mapping.findForward("verLista"); 
        }

        // 2. PREPARAR EDICIÓN (Cargar datos antes de mostrar el form)
        if ("prepararEditar".equals(action)) {
            String dni = request.getParameter("dni");
            Persona per = control.traerPersonaPorDni(dni);
            if (per != null) {
                f.setDni(per.getDni());
                f.setNombre(per.getNombre());
                f.setApellido(per.getApellido());
                f.setTelefono(per.getTelefono());
                f.setDireccion(per.getDireccion());
                if (per.getFecha_nac() != null) {
                    f.setFecha_nac(sdf.format(per.getFecha_nac()));
                }
            }
            return mapping.findForward("irAInicio"); 
        }

        // 3. GUARDAR CAMBIOS (Actualizar)
        if ("editar".equals(action)) {
            Persona per = control.traerPersonaPorDni(f.getDni());
            if (per != null) {
                per.setNombre(f.getNombre());
                per.setApellido(f.getApellido());
                per.setTelefono(f.getTelefono());
                per.setDireccion(f.getDireccion());
                try {
                    per.setFecha_nac(sdf.parse(f.getFecha_nac()));
                } catch (Exception e) {
                    per.setFecha_nac(new java.util.Date());
                }
                control.editarPersona(per);
            }
            return mapping.findForward("verLista"); // Volver a la lista tras editar
        }

        // 4. ELIMINAR
        if ("eliminar".equals(action)) {
            String dni = request.getParameter("dni");
            control.borrarPersona(dni);
            List<Persona> lista = control.traerPersonas();
            request.setAttribute("listaPersonas", lista);
            return mapping.findForward("verLista");
        } 

        // 5. REGISTRO NUEVO (Solo si la acción es "crear")
        if ("crear".equals(action)) {
            Persona per = new Persona();
            per.setDni(f.getDni());
            per.setNombre(f.getNombre());
            per.setApellido(f.getApellido());
            per.setTelefono(f.getTelefono());
            per.setDireccion(f.getDireccion());
            try {
                per.setFecha_nac(sdf.parse(f.getFecha_nac()));
            } catch (Exception e) {
                per.setFecha_nac(new java.util.Date());
            }

            control.crearPersona(per);
            return mapping.findForward("verLista");
        }

        return mapping.findForward("irAInicio");
    }
}