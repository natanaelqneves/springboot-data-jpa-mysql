package src.model.onetomany;

import src.model.basic.Product;

import javax.persistence.*;

@Entity
public class ItemRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Request request;

    @ManyToOne(fetch = FetchType.EAGER) // Get the related value automatically (CHILDREN AND PARENTS ONLY)
    private Product product;

    @Column(nullable = false)
    private int amount;

    @Column(nullable = false)
    private Double price;

    public ItemRequest() {
    }

    public ItemRequest(Request request, Product product, int amount) {
        super();
        this.setRequest(request);
        this.setProduct(product);
        this.setAmount(amount);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Request getRequest() {
        return request;
    }

    public void setRequest(Request request) {
        this.request = request;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;

        if(product != null && this.price == null) {
            this.setPrice(product.getPrice());
        }
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
