package com.clinica.persistencia;

import com.clinica.logica.Persona;
import org.slf4j.Logger;
import java.util.List;
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
    
    public Persona traerPersonaPorDni(String dni) {
        EntityManager em = emf.createEntityManager();
        try {
            return em.createQuery("SELECT p FROM Persona p WHERE p.dni = :dni", Persona.class)
                     .setParameter("dni", dni)
                     .getSingleResult();
        } catch (Exception e) {
            return null;
        } finally {
            em.close();
        }
    }


    public void borrarPersonaPorDni(String dni) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            
            // Primero obtenemos la persona usando la consulta por DNI
            Persona per = traerPersonaPorDni(dni);
            
            if (per != null) {
                // Es vital usar merge antes de remove si el objeto viene de otro EntityManager
                em.remove(em.merge(per));
            }
            
            em.getTransaction().commit();
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
        } finally {
            em.close();
        }
    }

    public List<Persona> traerPersonas() {
        EntityManager em = emf.createEntityManager();
        try {
            return em.createQuery("SELECT p FROM Persona p", Persona.class).getResultList();
        } finally {
            em.close();
        }
    }

    public void editarPersona(Persona per) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(per);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }
}