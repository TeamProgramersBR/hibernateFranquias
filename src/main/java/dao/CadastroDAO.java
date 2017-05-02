package dao;

import entity.Cadastro;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

/**
 * Created by harlock on 23/04/17.
 */

public class CadastroDAO {
    @PersistenceContext
    protected EntityManager entityManager;


    public List<Cadastro> retornaTodos(){
        String jpql = " SELECT c from Cadastro c order by c.ID_CADASTRO";
        Query query = entityManager.createQuery(jpql);
        List<Cadastro> cadastros = (List<Cadastro>) query.getResultList();
        return cadastros;
    }

    public List<Cadastro> retornaTodos(int ID_CADASTRO){
        String jpql = " SELECT c from Cadastro c order by c.ID_CADASTRO" +
                "WHERE c.ID_CADASTRO = :ID_CADASTRO";
        Query query = entityManager.createQuery(jpql);
        query.setParameter("ID_CADASTRO", ID_CADASTRO);
        List<Cadastro> cadastro = (List<Cadastro>) query.getResultList();
        return cadastro;
    }

    public Cadastro retornaEspecifico(int id){
        String jpql = " SELECT c from Cadastro c order by c.nome";
        Query query = entityManager.createQuery(jpql);
        Cadastro cadastro = (Cadastro) query.getSingleResult();
        return cadastro;
    }

    public Cadastro inserirCadastro(Cadastro cadastro){
        entityManager.persist(cadastro);
        return cadastro;
    }

    public Cadastro updateCadastro(Cadastro cadastro){
        entityManager.merge(cadastro);
        return cadastro;
    }

    public Cadastro deleteCadastro(Cadastro cadastro){
        entityManager.remove(cadastro);
        return cadastro;
    }

    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
}
