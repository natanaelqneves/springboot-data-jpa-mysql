package src.model.manytomany;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Nephew {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToMany
    private List<Uncle> uncleList = new ArrayList<>();

    public Nephew() {
    }

    public Nephew(String name) {
        super();
        this.name = name;
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

    public List<Uncle> getUncleList() {
        return uncleList;
    }

    public void setUncleList(List<Uncle> uncleList) {
        this.uncleList = uncleList;
    }
}
