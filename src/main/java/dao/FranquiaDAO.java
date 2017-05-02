package dao;


import entity.Franquia;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

/**
 * Created by harlock on 23/04/17.
 */
public class FranquiaDAO {
    @PersistenceContext
    protected EntityManager entityManager;


    public List<Franquia> retornaTodos(){
        String jpql = " SELECT c from Franquia c order by c.ID_FRANQUIA";
        Query query = entityManager.createQuery(jpql);
        List<Franquia> acompanhamentos = (List<Franquia>) query.getResultList();
        return acompanhamentos;
    }


    public List<Franquia> retornaTodos(int idFranqueado){
        String jpql = " SELECT c from Franquia c order by c.ID_FRANQUIA" +
                " WHERE c.ID_FRANQUIA = :ID_FRANQUIA";
        Query query = entityManager.createQuery(jpql);
        query.setParameter("ID_FRANQUIA", idFranqueado);
        List<Franquia> acompanhamentos = (List<Franquia>) query.getResultList();
        return acompanhamentos;
    }

    public Franquia retornaEspecifico(int id){
        String jpql = " SELECT c from Franquia c order by c.nome";
        Query query = entityManager.createQuery(jpql);
        Franquia acompanhamentos = (Franquia) query.getSingleResult();
        return acompanhamentos;
    }

    public Franquia inserirFranquia(Franquia franquia){
        entityManager.persist(franquia);
        return franquia;
    }

    public Franquia updateFranquia(Franquia franquia){
        entityManager.merge(franquia);
        return franquia;
    }

    public Franquia deleteFranquia(Franquia franquia){
        entityManager.remove(franquia);
        return franquia;
    }

    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
}
