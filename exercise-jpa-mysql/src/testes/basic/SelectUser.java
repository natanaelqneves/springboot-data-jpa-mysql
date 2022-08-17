package src.testes.basic;

import src.model.basic.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class SelectUser {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("provide");

        EntityManager em = emf.createEntityManager();

        User user =em.find(User.class, 4L);

        System.out.println(user.getName());
        System.out.println(user.getEmail());



        em.close();
        emf.close();
    }
}
