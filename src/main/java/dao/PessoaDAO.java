package dao;

import entity.Pessoa;


import javax.persistence.*;
import java.util.List;

/**
 * Created by harlock on 23/04/17.
 */

public class PessoaDAO {
    @PersistenceContext
    protected EntityManager entityManager;

    public void setEntityManager(
            EntityManager entityManager) {
        //EntityManagerFactory factory = Persistence.createEntityManagerFactory("franquiaPu");
        this.entityManager = entityManager;//= factory.createEntityManager();
    }

    public List<Pessoa> retornaTodos(){
        String jpql = "SELECT c from Pessoa c order by c.nome";
        Query query = entityManager.createQuery(jpql);
        List<Pessoa> pessoas = (List<Pessoa>) query.getResultList();
        return pessoas;
    }


    public List<Pessoa> retornaTodos(int idPessoa){
        String jpql = "SELECT c from Pessoa c order by c.nome";
        Query query = entityManager.createQuery(jpql);
        List<Pessoa> pessoas = (List<Pessoa>) query.getResultList();
        return pessoas;
    }

    public Pessoa retornaEspecifico(int id){
        String jpql = "SELECT c from Pessoa c order by c.nome";
        Query query = entityManager.createQuery(jpql);
        Pessoa pessoas = (Pessoa) query.getSingleResult();
        return pessoas;
    }
 
    public Pessoa inserirPessoa(Pessoa Pessoa){
        entityManager.persist(Pessoa);
        return Pessoa;
    }

    public Pessoa updatePessoa(Pessoa Pessoa){
        entityManager.merge(Pessoa);
        return Pessoa;
    }

    public Pessoa deletePessoa(Pessoa Pessoa){
        entityManager.remove(Pessoa);
        return Pessoa;
    }
}
