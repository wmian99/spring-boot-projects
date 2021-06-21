package io.mesmer.training.spring.webapp.Main.Products;

import org.springframework.data.repository.CrudRepository;

public interface ProductsRepository extends CrudRepository<Product, Integer> {
}
