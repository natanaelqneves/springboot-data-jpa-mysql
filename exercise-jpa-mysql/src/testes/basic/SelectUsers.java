package src.testes.basic;

import src.model.basic.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class SelectUsers {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("provide");

        EntityManager em = emf.createEntityManager();

        /*
        String jpql = "select u from User u";

        TypedQuery<User> query = em.createQuery(jpql, User.class);

        query.setMaxResilts(3);
        */

        for (User user : em
                .createQuery("select u from User u", User.class)
                .setMaxResults(3)
                .getResultList()) {
            System.out.println(user.getId());
            System.out.println(user.getName());
            System.out.println(user.getEmail() + "\n");
        }
        em.close();
        emf.close();
    }
}
