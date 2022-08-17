package src.testes.onetomany;

import src.infra.DAO;
import src.model.basic.Product;
import src.model.onetomany.ItemRequest;
import src.model.onetomany.Request;

public class NewRequest {

    public static void main(String[] args) {

        DAO<Object> dao = new DAO<>();

        Request request = new Request();
        Product product = new Product("Telhas", 75.00);
        ItemRequest itemRequest = new ItemRequest(request, product, 12);

        dao.abrirT()
                .incluirT(product)
                .incluirT(request)
                .incluirT(itemRequest)
                .fecharT()
                .fechar();
    }

}
