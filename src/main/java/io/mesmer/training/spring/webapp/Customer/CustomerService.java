package io.mesmer.training.spring.webapp.Customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    public List<Customer> getAllCustomers() {
       List<Customer> allCustomers = new ArrayList<>();
       Iterable<Customer> iterable = customerRepository.findAll();
       iterable.forEach(allCustomers::add);
       return allCustomers;
    }

    public Optional<Customer> getCustomer(int id) {
        return customerRepository.findById(id);
    }

    public void createCustomer(Customer customer) {
        customerRepository.save(customer);
    }

    public void updateCustomer(Customer customer) {
        customerRepository.save(customer);
    }

    public void deleteCustomer(int id) {
        customerRepository.deleteById(id);
    }
}
