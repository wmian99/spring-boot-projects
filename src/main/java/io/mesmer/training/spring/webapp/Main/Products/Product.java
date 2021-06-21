package io.mesmer.training.spring.webapp.Main.Products;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.mesmer.training.spring.webapp.Main.Customers.Customer;

import javax.persistence.*;

@Entity
public class Product {
    @Id
    @GeneratedValue
    private int id;
    private String name;
    private String company;
    private int cost;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "cust_id")
    @JsonIgnore
    private Customer customer;


    public Product(){

    }

    public Product(int id, String name, String company, int cost, Customer c) {
        this.id = id;
        this.name = name;
        this.company = company;
        this.cost = cost;
        this.customer = c;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public int getId() {
        return id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public String getName() {
        return name;
    }

    public String getCompany() {
        return company;
    }

    public int getCost() {
        return cost;
    }
}
