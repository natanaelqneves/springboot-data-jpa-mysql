package course.exercisesb.controller;

import course.exercisesb.model.Product;
import course.exercisesb.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @RequestMapping(method = {RequestMethod.POST, RequestMethod.PUT})
    public @ResponseBody Product newProduct(@Valid Product product) {
        productRepository.save(product);
        return product;
    }

    /*
    @PostMapping
    public @ResponseBody Product newProduct(@Valid Product product) {
        productRepository.save(product);
        return product;
    }

    @PutMapping
    public Product changeProduct(@Valid Product product) {
        productRepository.save(product);
        return product;
    }
     */

    @GetMapping
    public Iterable<Product> getProducts() {
        return productRepository.findAll();
    }

    @GetMapping(path = "name/{name}")
    public Iterable<Product> getProducsForName(@PathVariable String name) {
        return productRepository.searchByNameLike(name);
        //return productRepository.findByNameContainingIgnoreCase(name);
    }

    @GetMapping(path = "/page/{numberPage}/{numberItens}")
    public Iterable<Product> getProductsForPage(
            @PathVariable int numberPage, @PathVariable int numberItens) {
        if(numberItens >= 5) numberItens = 5;

        Pageable page = PageRequest.of(numberPage, numberItens);
        return productRepository.findAll(page);
    }

    @GetMapping(path = "/{id}")
    public Optional<Product> getProduct(@PathVariable Integer id) {
        return productRepository.findById(id);
    }

    @DeleteMapping(path = "/{id}")//SOFT DELETE
    public void delProduct(@PathVariable Integer id) {
        productRepository.deleteById(id);
    }


}
