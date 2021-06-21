package io.mesmer.training.spring.webapp.Main.Customers;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.mesmer.training.spring.webapp.Main.Products.Product;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "customer_table")
public class Customer {
    @Id
    @GeneratedValue
    private int id;
    private String name;
    private String country;
    private String email;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="cust_id")
    private List<Product> products = new ArrayList<>();

    public int getCustomer_id() {
        return id;
    }

    public void setCustomer_id(int customer_id) {
        this.id = customer_id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public String getCountry() {
        return country;
    }

    public String getEmail() {
        return email;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public Customer(){

    }

    public Customer(int customer_id, String name, String country, String email, Product p) {
        this.id = customer_id;
        this.name = name;
        this.country = country;
        this.email = email;
        products.add(p);
    }

}
