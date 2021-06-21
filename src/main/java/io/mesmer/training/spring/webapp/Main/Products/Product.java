package io.mesmer.training.spring.webapp.Main.Products;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Product {
    @Id
    @GeneratedValue
    private int id;
    private String name;
    private String company;
    private int cost;


    public Product(){

    }

    public Product(int id, String name, String company, int cost) {
        this.id = id;
        this.name = name;
        this.company = company;
        this.cost = cost;
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
