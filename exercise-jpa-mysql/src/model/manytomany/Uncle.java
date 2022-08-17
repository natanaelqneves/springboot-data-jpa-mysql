package src.model.manytomany;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Uncle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToMany(mappedBy = "uncleList")
    private List<Nephew> nephewList = new ArrayList<>();

    public Uncle() {
    }

    public Uncle(String name) {
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

    public List<Nephew> getNephewList() {
        return nephewList;
    }

    public void setNephewList(List<Nephew> nephewList) {
        this.nephewList = nephewList;
    }
}
