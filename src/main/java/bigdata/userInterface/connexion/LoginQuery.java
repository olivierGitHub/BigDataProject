package bigdata.userInterface.connexion;

import bigdata.userInterface.connexion.entity.Login;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

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


    public void initUser() {
        Login user = new Login();
        user.setUsername("root");
        user.setPassword("root");

        try {
            em.persist(user);
            em.flush();
            if (listLogin().size() > 1)
                em.remove(user);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
                em.close();
            }
        }


    }

}
