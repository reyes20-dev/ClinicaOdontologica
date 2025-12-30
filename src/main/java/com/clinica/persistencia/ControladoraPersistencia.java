package com.clinica.persistencia;

/*ESTA CLASE ES EL DAO (Data Accesss Object) su funcion es recibir objetos de java 
 * y "traducirlos" a comandos que la base de datos entienda*/

// Importamos la clase Persona para poder recibir sus objetos
import com.clinica.logica.Persona;
// Importamos las herramientas de Java SQL para ejecutar comandos
import java.sql.Connection;
import java.sql.PreparedStatement; // Esta es la más importante para insertar datos de forma segura
import java.sql.SQLException;

/*Clase ControladoraPersistencia: Es la encargada de realizar las operaciones
 * CRUD (Crear, Leer, Actualizar, Borrar) en la BASE DE DATOS.*/

public class ControladoraPersistencia {
    
    // Instanciamos la clase Conexion para poder usar su método 'conectar()'
    Conexion con = new Conexion();

    /* Método crearPersona: Recibe un objeto de tipo Persona y lo guarda en PostgreSQL.
     * @param per Objeto que contiene los datos capturados desde la web.*/
    
    public void crearPersona(Persona per) {
        // Definimos la sentencia SQL. Usamos '?' como marcadores de posición (placeholders)
        // para evitar un ataque llamado "Inyección SQL", (Buena practica profesional).
        String sql = "INSERT INTO persona (dni, nombre, apellido, telefono, direccion, fecha_nac) VALUES (?,?,?,?,?,?)";
        
        // Usamos "Try-with-resources" (paréntesis después del try). 
        // Esto cierra automáticamente la conexión y el PreparedStatement al terminar, 
        // evitando que se desperdicien recursos del servidor.
        try (Connection conexion = con.conectar();
             PreparedStatement ps = conexion.prepareStatement(sql)) {
            
            // Reemplazamos los '?' por los datos reales del objeto 'per'
            // El número indica la posición del signo de interrogación en el String 'sql'
            ps.setString(1, per.getDni());       // 1er '?' -> DNI
            ps.setString(2, per.getNombre());    // 2do '?' -> Nombre
            ps.setString(3, per.getApellido());  // 3er '?' -> Apellido
            ps.setString(4, per.getTelefono());  // 4to '?' -> Telefono
            ps.setString(5, per.getDireccion()); // 5to '?' -> Direccion
            

            // java.util.Date (Java) y java.sql.Date (Base de datos) son diferentes.
            // Debemos convertir la fecha para que PostgreSQL la entienda.
            if (per.getFecha_nac() != null) {
                // Convertimos el tiempo en milisegundos a formato SQL Date
                ps.setDate(6, new java.sql.Date(per.getFecha_nac().getTime()));
            } else {
                // Si no hay fecha, enviamos un valor Nulo a la columna 6
                ps.setNull(6, java.sql.Types.DATE);
            }
            
            // Ejecutamos la sentencia en la base de datos
            ps.executeUpdate();
            
            // Mensaje de confirmación en la consola de Eclipse
            System.out.println("Registro exitoso en la tabla Persona.");
            
        } catch (SQLException e) {
            // Si algo falla usamos esto en el catch para que la ejecucion no se rompa 
        	// y nos muestre un mensaje diferente y mejor al de una pantalla de error
            System.out.println("Error al insertar: " + e.getMessage());
        }
    }
}