package com.clinica.persistencia;

import com.clinica.logica.Persona;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ControladoraPersistencia {
    
    // El nombre "ClinicaPU" debe coincidir con el <persistence-unit> en tu persistence.xml
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("ClinicaPU");

    public void crearPersona(Persona per) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin(); // Iniciamos la transacción
            em.persist(per);             // Guardamos el objeto directamente
            em.getTransaction().commit(); // Confirmamos los cambios
            System.out.println("Registro exitoso mediante JPA.");
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback(); // Si hay error, volvemos atrás
            }
            System.out.println("Error al insertar con JPA: " + e.getMessage());
        } finally {
            em.close(); // Cerramos el manager para liberar recursos
        }
    }
}