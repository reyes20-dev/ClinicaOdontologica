package com.clinica.persistencia;

// Importamos las herramientas oficiales de Java para manejar SQL
import java.sql.Connection;     // Para gestionar la sesión de conexión
import java.sql.DriverManager;  // Para gestionar el puente entre el código y el driver
import java.sql.SQLException;   // Para capturar errores específicos de bases de datos

/*Clase Conexion: Su única responsabilidad es establecer el vínculo 
 * entre Java y el servidor PostgreSQL.*/

public class Conexion {
    
    // URL: Indica el protocolo (jdbc), el motor (postgresql), el servidor (localhost), 
    // el puerto (5432) y el nombre de la base de datos (clinica_odontologica).
    private String url = "jdbc:postgresql://localhost:5432/clinica_odontologica";
    
    // Credenciales: Usuario y contraseña configurados en el servidor de PostgreSQL.
    private String usuario = "postgres"; 
    private String clave = "12345Dr_*"; 

    /*Método conectar: Intenta abrir una conexión con los parámetros anteriores.
     * @return Retorna un objeto de tipo Connection si tiene éxito, o null si falla.*/
    
    public Connection conectar() {
        Connection conn = null; // Inicializamos la conexión como nula
        
        try {
            // descargamos el .jar y lo metemos en la carpeta lib de src/main/webapp/WEB-INF/lib
        	// y registramos este driver
            Class.forName("org.postgresql.Driver");
            
            // 2. Intento de Conexión: El DriverManager usa la URL y credenciales para pedir acceso.
            conn = DriverManager.getConnection(url, usuario, clave);
            
            // Si llegamos aquí sin errores, imprimimos el éxito en la consola
            System.out.println("Conexión exitosa a PostgreSQL");
            
        } catch (ClassNotFoundException | SQLException e) {
            // Capturamos dos tipos de errores: 
            // - Que no exista el driver (ClassNotFoundException)
            // - Que la clave, usuario o URL estén mal (SQLException)
            System.out.println("Error al conectar: " + e.getMessage());
        }
        
        return conn; // Devolvemos el puente (la conexión) para ser usado por otras clases
    }
    
    // metodo temporal para prueba.
    public static void main(String[] args) {
        // Creamos una instancia (objeto) de esta clase
        Conexion test = new Conexion();
        // Ejecutamos el método para verificar si los datos son correctos
        test.conectar();
    }
}