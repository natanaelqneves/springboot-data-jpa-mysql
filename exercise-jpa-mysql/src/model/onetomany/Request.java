package src.model.onetomany;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class Request {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Date data;

    @OneToMany(mappedBy = "request", fetch = FetchType.LAZY) // Takes the related values and waits for query by the user (ONLY CHILDREN)
    private List<ItemRequest> itens;


    public Request() {
        this(new Date());
    }

    public Request(Date data) {
        super();
        this.data = data;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public List<ItemRequest> getItens() {
        return itens;
    }

    public void setItens(List<ItemRequest> itens) {
        this.itens = itens;
    }
}
