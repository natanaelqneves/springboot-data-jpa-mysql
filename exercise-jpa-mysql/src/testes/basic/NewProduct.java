package src.testes.basic;

import src.infra.DAO;
import src.model.basic.Product;

public class NewProduct {

    public static void main(String[] args) {

        Product product = new Product("Monitor", 957.45);

        DAO<Product> dao = new DAO<>(Product.class);
        dao.incluirAtomico(product).fechar();
        //dao.abrirT().incluirT(product).fecharT().fechar();
    }
}
