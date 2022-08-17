package src.testes.manytomany;

import src.infra.DAO;
import src.model.manytomany.Actor;
import src.model.manytomany.Movie;

public class NemMovieActor {

    public static void main(String[] args) {

        Movie movie1 = new Movie("Dark Season 3", 9.5);
        Movie movie2 = new Movie("Game of Thrones", 8.5);

        Actor actor1 = new Actor("Popo Freitas");
        Actor actor2 = new Actor("July");

        movie1.addActor(actor1);
        movie1.addActor(actor2);

        movie2.addActor(actor1);

        DAO<Movie> dao = new DAO<>();
        dao.incluirAtomico(movie1);
    }
}
