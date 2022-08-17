package src.infra;

import src.model.basic.Product;

public class ProductDAO  extends DAO<Product>{
    public ProductDAO() {
        super(Product.class);
    }
}
