package io.mesmer.training.spring.webapp.Main.Order;

import io.mesmer.training.spring.webapp.Main.Customers.Customer;
import io.mesmer.training.spring.webapp.Main.Customers.CustomerRepository;
import io.mesmer.training.spring.webapp.Main.Products.Product;
import io.mesmer.training.spring.webapp.Main.Products.ProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class OrderService {
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private ProductsRepository productsRepository;


    public void addCustomerProd(Product product) {
        Optional<Customer> customer = customerRepository.findById(product.getCustomer().getCustomer_id());
        product.setCustomer(customer.get());
        productsRepository.save(product);
    }

    public List<Product> customerProducts(int id) {
        Optional<Customer> customer = customerRepository.findById(id);
        return customer.get().getProducts();
    }
}
