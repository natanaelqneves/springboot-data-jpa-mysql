package src.model.manytomany;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "actors")
public class Actor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToMany(mappedBy = "actorList", cascade = CascadeType.PERSIST)
    private List<Movie> movieList = new ArrayList<>();

    public Actor() {
    }

    public Actor(String name) {
        super();
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Movie> getMovieList() {
        return movieList;
    }

    public void setMovieList(List<Movie> movieList) {
        this.movieList = movieList;
    }
}
