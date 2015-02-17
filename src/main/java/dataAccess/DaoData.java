package dataAccess;

import data.DataTaux;
import model.Country;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Created by oliver on 17/02/15.
 */
public class DaoData extends BaseJpa {

    private static final DaoData instance = new DaoData();
    private DaoData(){}
    public static DaoData getInstance(){
        return instance;
    }

    public int create(DataTaux obj) {
        EntityManager em = super.getEntityManagerFactory().createEntityManager();
        EntityTransaction t = em.getTransaction();
        int id = 0;
        try{
            t.begin();
            em.persist(obj);
            em.flush();
            id = obj.getId();
            t.commit();
        }catch(Exception ex){
            System.out.println("SOUCI lors de la persistence des données vers le référentiel");
            ex.printStackTrace();
        }finally {
            if (t.isActive()){
                t.rollback();
                em.close();
            }
        }
        return id;
    }


    public DataTaux read(int id) {
        EntityManager em = super.getEntityManagerFactory().createEntityManager();
        EntityTransaction t = em.getTransaction();
        DataTaux dataTaux = null;

        try{
            t.begin();
            dataTaux = em.find(DataTaux.class, id);
            t.commit();
        }catch(Exception ex){
            System.out.println("SOUCI lors de la lecture du référentiel");
            ex.printStackTrace();
        }finally {
            if (t.isActive()){
                t.rollback();
                em.close();
            }
        }
        return dataTaux;
    }

    public List<DataTaux> readALL() {
        EntityManager em = super.getEntityManagerFactory().createEntityManager();
        EntityTransaction t = em.getTransaction();
        List<DataTaux> listDataTaux = null;

        try{
            t.begin();
            String sql = "select e from DataTaux e";
            TypedQuery<DataTaux> query = em.createQuery(sql, DataTaux.class);
            t.commit();
            listDataTaux = query.getResultList();
        }catch(Exception ex){
            System.out.println("SOUCI lors de la lecture du référentiel");
            ex.printStackTrace();
        }finally {
            if (t.isActive()){
                t.rollback();
                em.close();
            }
        }
        return listDataTaux;
    }


}