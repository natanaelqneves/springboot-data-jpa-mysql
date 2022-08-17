package src.testes.basic;

import src.model.basic.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class UpdateUser2 {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("provide");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin(); //independendo de onde esteja abrindo a transação, a entidade entrará em estado transacional.

        User user = em.find(User.class, 4L);
        user.setName("Nome alterado acima");
        user.setEmail("emailalteradoacima@gmail.com");

        //em.merge(user); Continua sendo alterado pq está em estado transacional (ENTIDADE EM ESTADO GERENCIADO)

        em.getTransaction().commit();

        em.close();
        emf.close();
    }
}
