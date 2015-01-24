package persistence;

import data.Data;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 * Created by oliver on 24/01/15.
 */
public class DAOdata {

    private EntityManagerFactory emf;

    private static final DAOdata instance = new DAOdata();
    public static DAOdata getInstance(){
        return instance;
    }
    private DAOdata(){
        emf = Persistence.createEntityManagerFactory("BigDataProjectPU");
    }

    public int create(Data data){
        EntityManager em = emf.createEntityManager();
        EntityTransaction t = em.getTransaction();
        int id =0;
        try{
            t.begin();
            em.persist(data);
            em.flush();
            id = data.getId();
            t.commit();
            return id;
        }catch(Exception e){
            e.printStackTrace();
        }finally {
            if (t.isActive()){
                t.rollback();
                em.close();
            }
        }
        return id;
    }

}
