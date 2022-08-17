package src.model.basic;

import javax.persistence.*;

@Entity
@Table(name = "tb_products", schema = "users_java")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "prod_nome", length = 200, nullable = false)
    private String name;
    @Column(name = "prod_price", nullable = false, precision = 11, scale = 2)
    private Double price;

    public Product(){

    }

    public Product(String name, Double price) {
        super();
        this.name = name;
        this.price = price;
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

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
