package io.mesmer.training.spring.webapp.Main.Customers;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "customer_table")
public class Customer {
    @Id
    @GeneratedValue
    private int id;
    private String name;
    private String country;
    private String email;

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

    public Customer(){

    }

    public Customer(int customer_id, String name, String country, String email) {
        this.id = customer_id;
        this.name = name;
        this.country = country;
        this.email = email;
    }

}
