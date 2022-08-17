package src.testes.basic;

import src.model.basic.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class NewUser {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("provide");

        EntityManager em = emf.createEntityManager();

        User user = new User("Julyane", "julyane@gmail.com");

        em.getTransaction().begin();
        em.persist(user);
        em.getTransaction().commit();

        user = new User("Edilane", "edilane@gmail.com");

        em.getTransaction().begin();
        em.persist(user);
        em.getTransaction().commit();

        user = new User("Amora", "amora@gmail.com");

        em.getTransaction().begin();
        em.persist(user);
        em.getTransaction().commit();

        user = new User("Hanna", "hanna@gmail.com");

        em.getTransaction().begin();
        em.persist(user);
        em.getTransaction().commit();

        user = new User("Mel", "mel@gmail.com");

        em.getTransaction().begin();
        em.persist(user);
        em.getTransaction().commit();

        em.close();
        emf.close();
    }
}
