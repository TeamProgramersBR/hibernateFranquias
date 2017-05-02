import java.util.Calendar;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import dao.AcompanhamentoDAO;
import entity.Acompanhamento;
import entity.Pessoa;

/**
 * Hello world!
 *
 */
public class main
{
    public static void main(String [] args){
        System.out.println("OlAR");

        

         EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("franquia");
        EntityManager manager = entityManagerFactory.createEntityManager();
        try{
       String jpql = "SELECT Acompanhamento.descricao "+
				"from Acompanhamento "+
				"INNER JOIN Franquia  Franquia.id = Acompanhamento.franquia_id";
       
        	
        Query query = manager.createQuery(jpql);
        List<Acompanhamento> acompanhamentos = (List<Acompanhamento>) query.getResultList();
        for (Acompanhamento tarefa : acompanhamentos) {
  		  System.out.println(tarefa.getDescricao());
  		}
        }catch(Error e){
        	System.out.println(e);
        }

        		
            
            manager.getTransaction().commit();
            manager.close();
            
        
    }
}