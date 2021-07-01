package io.mesmer.training.spring.webapp.Main.Products;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    private ProductsRepository productsRepository;

    public List<Product> allProducts() {
        List<Product> products = new ArrayList<>();
        Iterable<Product> iterable = productsRepository.findAll();
        iterable.forEach(products::add);
        return products;
    }

    public Optional<Product> getProduct(int id) {
        return productsRepository.findById(id);
    }

    public void createProduct(Product product) {
        productsRepository.save(product);
    }

    public void updateProduct(Product product,int id) {

        Optional<Product> prod= productsRepository.findById(id);
        Product product1 = prod.get();
        product1.setName(product.getName());
        product1.setCompany(product.getCompany());
        product1.setCost(product.getCost());
        product1.setCustomer(product.getCustomer());
        productsRepository.save(product1);
    }
}
