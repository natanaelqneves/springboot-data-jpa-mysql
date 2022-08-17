package src.testes.onetomany;

import src.infra.DAO;
import src.model.onetomany.ItemRequest;
import src.model.onetomany.Request;

public class GetRequest {

    public static void main(String[] args) {

        DAO< Request> dao = new DAO<>(Request.class);

        Request request = dao.obterPorId(3L);

        for(ItemRequest itemRequest : request.getItens()) {
            System.out.println(itemRequest.getAmount());
            System.out.println(itemRequest.getProduct().getName());
            System.out.println(itemRequest.getProduct().getPrice());
        }
        dao.fechar();
    }
}
