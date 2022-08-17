package src.testes.onetoone;

import src.infra.DAO;
import src.model.onetoone.Client;
import src.model.onetoone.Seat;

public class NewClientSeat2 {

    public static void main(String[] args) {

        Seat seat = new Seat("31A");

        Client client = new Client("Julyane", seat);
        DAO<Client> dao = new DAO<>(Client.class);

        dao.abrirT()
                .incluirT(client)
                .fecharT()
                .fechar();

    }
}
