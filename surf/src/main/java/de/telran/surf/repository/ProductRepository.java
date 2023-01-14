package de.telran.surf.repository;

import de.telran.surf.entity.Product;
import org.springframework.data.repository.CrudRepository;
import java.util.List;

public interface ProductRepository extends CrudRepository<Product, String> {

    Product findByName(String name);

//    List<Product> findAllByPrice();

}
