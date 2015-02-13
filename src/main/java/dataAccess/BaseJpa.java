package dataAccess;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Created by Arnaud on 13/02/2015.
 */
public abstract class BaseJpa {

    private EntityManagerFactory emf;

    protected EntityManagerFactory getEntityManagerFactory() {
        if (emf == null) {
            emf = Persistence.createEntityManagerFactory("BigDataProjectPU");
        }
        return emf;
    }
}
