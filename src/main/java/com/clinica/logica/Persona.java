// Define la ubicación de esta clase dentro de la estructura de carpetas del proyecto
package com.clinica.logica;

// Importa la librería necesaria para manejar fechas en Java
import java.util.Date;

/*Esta clase representa la entidad "Persona" de mi diagrama UML.
  Funciona como un Java Bean (un objeto simple que transporta datos).*/

public class Persona {

    // Atributos de la Clase
    // Son 'private' para aplicar Encapsulamiento: nadie puede verlos o cambiarlos desde fuera sin permiso.
    
    private int id_persona;    // Identificador único (clave primaria en la BD)
    private String dni;         
    private String nombre;     
    private String apellido;   
    private String telefono;    
    private String direccion;   
    private Date fecha_nac;   

    /* Constructor vacío.
     * Es obligatorio para que frameworks como Tomcat o librerías de persistencia 
     * puedan crear una instancia de la clase "en blanco" antes de llenarla de datos(Inicializar).*/
    
    public Persona() {
    }

    /* Constructor con parámetros:
     * Permite crear una Persona y asignarle todos sus valores en una sola línea de código.*/
    
    public Persona(int id_persona, String dni, String nombre, String apellido, String telefono, String direccion, Date fecha_nac) {
        // 'this' hace referencia a los atributos de esta clase para diferenciarlos de los parámetros que entran
        this.id_persona = id_persona;
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.direccion = direccion;
        this.fecha_nac = fecha_nac;
    }

    // --- Getters y Setters ---
    // Son los métodos públicos para interactuar con los atributos privados.
    
    // El 'Getter' sirve para obtener (leer) el valor del atributo
    public int getId_persona() { return id_persona; }
    // El 'Setter' sirve para asignar (escribir) un valor al atributo
    public void setId_persona(int id_persona) { this.id_persona = id_persona; }
    
    public String getDni() { return dni; }
    public void setDni(String dni) { this.dni = dni; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getApellido() { return apellido; }
    public void setApellido(String apellido) { this.apellido = apellido; }

    public String getTelefono() { return telefono; }
    public void setTelefono(String telefono) { this.telefono = telefono; }

    public String getDireccion() { return direccion; }
    public void setDireccion(String direccion) { this.direccion = direccion; }

    public Date getFecha_nac() { return fecha_nac; }
    public void setFecha_nac(Date fecha_nac) { this.fecha_nac = fecha_nac; }
}