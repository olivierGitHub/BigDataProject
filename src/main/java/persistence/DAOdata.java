package persistence;

import data.DataTaux;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 * Created by oliver on 24/01/15.
 */
public class DaoData {

    private EntityManagerFactory emf;

    private static final DaoData instance = new DaoData();
    public static DaoData getInstance(){
        return instance;
    }
    private DaoData(){
        emf = Persistence.createEntityManagerFactory("BigDataProjectPU");
    }

    public int create(DataTaux dataTaux){
        EntityManager em = emf.createEntityManager();
        EntityTransaction t = em.getTransaction();
        int id =0;
        try{
            t.begin();
            em.persist(dataTaux);
            em.flush();
            id = dataTaux.getId();
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

    public DataTaux read(int id){
        EntityManager em = emf.createEntityManager();
        EntityTransaction t = em.getTransaction();
        DataTaux dataTaux = null;
        try{
            t.begin();
            dataTaux = em.find(DataTaux.class,id);
            t.commit();
        }catch(Exception e){
            e.printStackTrace();
        }finally {
            if (t.isActive()){
                t.rollback();
                em.close();
            }
        }
        return dataTaux;
    }

}
