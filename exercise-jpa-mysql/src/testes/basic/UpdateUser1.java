package src.testes.basic;

import src.model.basic.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class UpdateUser1 {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("provide");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        User user = em.find(User.class, 5L);
        user.setName("Nome alterado");
        user.setEmail("emailalterado@gmail.com");

        em.merge(user);

        em.getTransaction().commit();

        em.close();
        emf.close();
    }
}
