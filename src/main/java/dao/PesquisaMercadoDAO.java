package dao;

import entity.PesquisaDeMercado;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

/**
 * Created by harlock on 23/04/17.
 */

public class PesquisaMercadoDAO {
    @PersistenceContext
    protected EntityManager entityManager;

    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }


    public List<PesquisaDeMercado> retornaTodos(){
        String jpql = "SELECT c from PesquisaMercado c order by c.nome";
        Query query = entityManager.createQuery(jpql);
        List<PesquisaDeMercado> pesquisamercados = (List<PesquisaDeMercado>) query.getResultList();
        return pesquisamercados;
    }


    public List<PesquisaDeMercado> retornaTodos(int idFranqueado){
        String jpql = "SELECT c from PesquisaMercado c order by c.nome";
        Query query = entityManager.createQuery(jpql);
        List<PesquisaDeMercado> pesquisamercados = (List<PesquisaDeMercado>) query.getResultList();
        return pesquisamercados;
    }

    public PesquisaDeMercado retornaEspecifico(int id){
        String jpql = "SELECT c from PesquisaMercado c order by c.nome";
        Query query = entityManager.createQuery(jpql);
        PesquisaDeMercado pesquisamercados = (PesquisaDeMercado) query.getSingleResult();
        return pesquisamercados;
    }

    public PesquisaDeMercado inserirPesquisaMercado(PesquisaDeMercado PesquisaMercado){
        entityManager.persist(PesquisaMercado);
        return PesquisaMercado;
    }

    public PesquisaDeMercado updatePesquisaMercado(PesquisaDeMercado PesquisaMercado){
        entityManager.merge(PesquisaMercado);
        return PesquisaMercado;
    }

    public PesquisaDeMercado deletePesquisaMercado(PesquisaDeMercado PesquisaMercado){
        entityManager.remove(PesquisaMercado);
        return PesquisaMercado;
    }
}
