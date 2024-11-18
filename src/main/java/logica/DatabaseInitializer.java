package logica;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class DatabaseInitializer {

    public static void main(String[] args) {
        inicializarBaseDeDatos();
    }

    public static void inicializarBaseDeDatos() {
        // Crear una instancia de EntityManagerFactory
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ConsultorioOdontologicoPU");
        
        // Crear una instancia de EntityManager
        EntityManager em = emf.createEntityManager();
        
        // Realizar una operación en la base de datos para forzar la creación de las tablas
        em.getTransaction().begin();
        em.createQuery("SELECT u FROM Usuario u").getResultList();
        em.getTransaction().commit();
        
        // Cerrar EntityManager y EntityManagerFactory
        em.close();
        emf.close();
        
        System.out.println("Tablas de la base de datos creadas.");
    }
}

