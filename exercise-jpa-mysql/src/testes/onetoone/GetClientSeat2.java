package src.testes.onetoone;

import src.infra.DAO;
import src.model.onetoone.Client;
import src.model.onetoone.Seat;

public class GetClientSeat2 {

    public static void main(String[] args) {

        DAO<Client> daoClient = new DAO<>(Client.class);
        DAO<Seat> daoSeat = new DAO<>(Seat.class);

        Client client = daoClient.obterPorId(1L);
        Seat seat = daoSeat.obterPorId(1L);

        System.out.println(client.getId());
        System.out.println(client.getName());
        System.out.println(client.getSeat().getNome());

        System.out.println(seat.getId());
        System.out.println(seat.getNome());
        System.out.println(seat.getClient().getName());

        daoClient.fechar();
        daoSeat.fechar();
    }
}

