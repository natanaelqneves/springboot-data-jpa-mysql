package course.exercisesb.repository;

import course.exercisesb.model.Product;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

public interface ProductRepository extends PagingAndSortingRepository<Product, Integer> {

    public Iterable<Product> findByNameContainingIgnoreCase(String name);

/*
    return productRepository.findByNameContaining(name);
    findByNameIsContaining
    findByNameContains
    findByNameStartsWith
    findByNameEndWith
    findByNameNotContaining
*/

    @Query("SELECT p FROM Product p WHERE p.name LIKE %:name%")
    public Iterable<Product> searchByNameLike(@Param("name") String name);

}
