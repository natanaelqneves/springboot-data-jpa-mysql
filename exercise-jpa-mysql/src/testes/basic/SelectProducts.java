package src.testes.basic;

import src.infra.ProductDAO;
import src.model.basic.Product;

import java.util.List;

public class SelectProducts {

    public static void main(String[] args) {

        ProductDAO dao = new ProductDAO();
        List<Product> products = dao.obterTodos();
        for (Product product : products) {
            System.out.println("ID: " + product.getId() + "\n" +
                            "Name: " + product.getName() + "\n" +
                            "Price: " + product.getPrice());
        }

        Double total = products
                .stream()
                .map(p -> p.getPrice())
                .reduce(0.0, (t, p) -> t + p)
                .doubleValue();

        System.out.println("Total é R$ :" + total);

        dao.fechar();
    }
}
