// Define la ubicación del archivo en el paquete de servlets
package com.clinica.servtlets;

// Importaciones necesarias para que Java maneje peticiones web y archivos
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet; // Permite usar la anotación @WebServlet
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest; // Representa lo que el usuario envía (la petición)
import javax.servlet.http.HttpServletResponse; // Representa lo que el servidor responde
import com.clinica.logica.Persona; // Importamos el molde de Persona
import com.clinica.persistencia.ControladoraPersistencia; // Importamos quien guarda en la BD

/**
 * @WebServlet("/SvPersona"): Esta es la "dirección" del Servlet.
 * Cuando el formulario JSP dice action="SvPersona", Tomcat busca esta etiqueta.
 */
@WebServlet("/SvPersona")
public class SvPersona extends HttpServlet {
    
	// Serialización
    // Un identificador único requerido por Java 
	// usamos 1L para decir que es la version 1 de mi clase
	// mientras el numero sea de tipo long (L al final) java lo aceptara
	// si queremos el dia de mañana cambiar la clase en este caso usariamos 2L,
	// para decir que es otra version
    private static final long serialVersionUID = 1L;
       
    public SvPersona() {
        super(); // Llama al constructor de la clase padre(En este caso "Persona") HttpServlet
    }

    /* Método doGet: Se ejecuta cuando alguien entra a la URL directamente
     * o mediante un enlace simple. Por ahora solo muestra un mensaje de texto.*/
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.getWriter().append("Served at: ").append(request.getContextPath());
    }

    /**
     * Método doPost: Es el CORAZÓN del proceso. 
     * Se activa cuando el usuario pulsa el botón "Enviar" en un formulario con method="POST".
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        // request.getParameter extrae el texto que el usuario escribió en el formulario.
        // El nombre dentro de las comillas ("dni", "nombre") debe ser IDÉNTICO al "name" del input en el JSP.
        String dni = request.getParameter("dni");
        String nombre = request.getParameter("nombre");
        String apellido = request.getParameter("apellido");
        String telefono = request.getParameter("telefono");
        String direccion = request.getParameter("direccion");
        
        // Creamos un objeto 'per' (el molde vacío) y le metemos los datos que acabamos de capturar.
        Persona per = new Persona();
        per.setDni(dni);
        per.setNombre(nombre);
        per.setApellido(apellido);
        per.setTelefono(telefono);
        per.setDireccion(direccion);
        
        // Asignamos la fecha actual del sistema para esta prueba inicial
        per.setFecha_nac(new java.util.Date()); 

        // Creamos una instancia de la Controladora que sabe hablar con PostgreSQL.
        ControladoraPersistencia controlPersis = new ControladoraPersistencia();
        
        // Le pasamos el objeto 'per' lleno de datos al método que estudiamos antes.
        controlPersis.crearPersona(per);

        // Una vez guardado, no queremos dejar al usuario en una pantalla blanca.
        // Lo mandamos de vuelta a la página principal (index.jsp).
        response.sendRedirect("index.jsp");
    }
}