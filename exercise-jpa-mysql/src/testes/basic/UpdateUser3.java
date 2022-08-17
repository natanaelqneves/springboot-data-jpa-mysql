package src.testes.basic;

import src.model.basic.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class UpdateUser3 {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("provide");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin(); //independendo de onde esteja abrindo a transação, a entidade entrará em estado transacional.

        User user = em.find(User.class, 7L);
        user.setName("Outro Nome alterado");
        user.setEmail("outroemailaltera@gmail.com");

        em.detach(user); //retira a entidade do estado transacional independente do posicionamento dentro do código.
        em.merge(user); //Deve ser adicionado para haver a atualização do dado selecionado (ENTIDADE mesmo fora do ESTADO GERENCIADO)

        em.getTransaction().commit();

        em.close();
        emf.close();
    }
}
