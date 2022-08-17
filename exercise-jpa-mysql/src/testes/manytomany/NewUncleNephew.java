package src.testes.manytomany;

import src.infra.DAO;
import src.model.manytomany.Nephew;
import src.model.manytomany.Uncle;

public class NewUncleNephew {

    public static void main(String[] args) {
        Uncle uncle1 = new Uncle("Zé");
        Uncle uncle2 = new Uncle("João");

        Nephew nephew1 = new Nephew("Junior");
        Nephew nephew2 = new Nephew("Pedro");

        uncle1.getNephewList().add(nephew1);
        nephew1.getUncleList().add(uncle1);

        uncle2.getNephewList().add(nephew1);
        nephew1.getUncleList().add(uncle2);

        uncle1.getNephewList().add(nephew2);
        nephew2.getUncleList().add(uncle1);

        uncle2.getNephewList().add(nephew2);
        nephew2.getUncleList().add(uncle2);

        DAO<Object> dao = new DAO<>();
        dao.abrirT()
                .incluirT(uncle1)
                .incluirT(uncle2)
                .incluirT(nephew1)
                .incluirT(nephew2)
                .fecharT()
                .fechar();
    }
}
