package userInterface.connexion;

import userInterface.connexion.entity.Login;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Created by Herve on 18/02/2015.
 */
public class LoginQuery {

    EntityManager em;

    EntityManagerFactory emf;

    public LoginQuery() {

        emf = Persistence.createEntityManagerFactory("BigDataProjectPU");

        em = emf.createEntityManager();

        em.getTransaction().begin();

    }

    public List<Login> listLogin() {
        return em.createNamedQuery("Login.findAll", Login.class).getResultList();
    }

}
