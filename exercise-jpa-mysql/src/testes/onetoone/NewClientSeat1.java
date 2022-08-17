package src.testes.onetoone;

import src.infra.DAO;
import src.model.onetoone.Client;
import src.model.onetoone.Seat;

public class NewClientSeat1 {

    public static void main(String[] args) {

        Seat seat = new Seat("41A");

        Client client = new Client("Kinho", seat);

        DAO<Object> dao = new DAO<>();

        dao.abrirT()
                .incluirT(seat)
                .incluirT(client)
                .fecharT()
                .fechar();

    }
}
