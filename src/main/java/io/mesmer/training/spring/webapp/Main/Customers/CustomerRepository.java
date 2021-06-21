package io.mesmer.training.spring.webapp.Main.Customers;

import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer, Integer > {

}
