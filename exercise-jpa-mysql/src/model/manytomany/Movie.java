package src.model.manytomany;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "movies")
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Double note;

    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(
            name = "Actors_Movies",
            joinColumns = @JoinColumn(name = "movie_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "actor_id", referencedColumnName = "id")
    )
    private List<Actor> actorList;

    public Movie() {
    }

    public Movie(String name, Double note) {
        super();
        this.name = name;
        this.note = note;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getNote() {
        return note;
    }

    public void setNote(Double note) {
        this.note = note;
    }

    public List<Actor> getActorList() {
        if(actorList == null) {
            actorList = new ArrayList<>();
        }
        return actorList;
    }

    public void setActorList(List<Actor> actorList) {
        this.actorList = actorList;
    }

    public void addActor(Actor actor) {
        if(actor != null && !getActorList().contains(actor)){
            getActorList().add(actor);

            if(!actor.getMovieList().contains(this)){
                actor.getMovieList().add(this);
            }

        }

    }
}
