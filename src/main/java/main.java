import java.util.Calendar;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import entity.Pessoa;

/**
 * Hello world!
 *
 */
public class main
{
    public static void main(String [] args){
        System.out.println("OlAR");

        Pessoa p= new Pessoa();

        p.setNome("gerivaldo");
        p.setCpf(222222222);
        p.setDtnasc(Calendar.getInstance().getTime());
        p.setEmail("roselvmna@asodk.com");
        p.setRg(2549925);
        p.setTelefone("552525252");

         EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("franquia");
        EntityManager manager = entityManagerFactory.createEntityManager();


        try{
            manager.getTransaction().begin();
            manager.persist(p);
            manager.getTransaction().commit();
            manager.close();

        }catch (Exception e){
            System.out.println(e);
        }
    }
}