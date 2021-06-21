package io.mesmer.training.spring.webapp.Customer;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;

public interface CustomerRepository extends CrudRepository<Customer, Integer > {

}
