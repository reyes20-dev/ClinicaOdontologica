package com.clinica.persistencia;

import com.clinica.logica.Persona;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ControladoraPersistencia {
    
    // Declaramos el Logger
    private static final Logger logger = LoggerFactory.getLogger(ControladoraPersistencia.class);
    
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("ClinicaPU");

    public void crearPersona(Persona per) {
        EntityManager em = emf.createEntityManager();
        try {
            logger.info("Iniciando creación de persona: {} {}", per.getNombre(), per.getApellido());
            em.getTransaction().begin();
            em.persist(per);
            em.getTransaction().commit();
            logger.info("Persona guardada exitosamente en la BD.");
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            logger.error("Error crítico al persistir persona: ", e);
        } finally {
            em.close();
        }
    }
}