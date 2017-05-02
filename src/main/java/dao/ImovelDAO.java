package dao;

import entity.Imovel;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

/**
 * Created by harlock on 23/04/17.
 */

public class ImovelDAO {
    @PersistenceContext
    protected EntityManager entityManager;

    public void setEntityManager(
            EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public List<Imovel> retornaTodos(){
        String jpql = "SELECT c from Imovel c order by c.nome";
        Query query = entityManager.createQuery(jpql);
        List<Imovel> imoveis = (List<Imovel>) query.getResultList();
        return imoveis;
    }


    public List<Imovel> retornaTodos(int idFranqueado){
        String jpql = "SELECT c from Imovel c order by c.nome";
        Query query = entityManager.createQuery(jpql);
        List<Imovel> imoveis = (List<Imovel>) query.getResultList();
        return imoveis;
    }

    public Imovel retornaEspecifico(int id){
        String jpql = "SELECT c from Imovel c order by c.nome";
        Query query = entityManager.createQuery(jpql);
        Imovel imoveis = (Imovel) query.getSingleResult();
        return imoveis;
    }

    public Imovel inserirImovel(Imovel Imovel){
        entityManager.persist(Imovel);
        return Imovel;
    }

    public Imovel updateImovel(Imovel Imovel){
        entityManager.merge(Imovel);
        return Imovel;
    }

    public Imovel deleteImovel(Imovel Imovel){
        entityManager.remove(Imovel);
        return Imovel;
    }
}
