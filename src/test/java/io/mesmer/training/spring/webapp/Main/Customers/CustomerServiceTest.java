package io.mesmer.training.spring.webapp.Main.Customers;

import io.mesmer.training.spring.webapp.Main.Products.Product;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatcher;
import org.mockito.ArgumentMatchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(MockitoExtension.class)
class CustomerServiceTest {
    @BeforeEach
    public void setup(){

    }

    @Mock
    private CustomerRepository customerRepository;

    @Test
    @DisplayName("Listing All Customers Test.")
    void sucessfullyGetAllCustomers() {
        CustomerService customerService = new CustomerService();
        Mockito.when(customerRepository.findAll()).
                thenReturn(Stream.of(new Customer(2,"Rimsha","pak","rim@g.com",new Product()),new Customer(1,"Waqas","Pak","waq@g.com",new Product()))
                        .collect(Collectors.toList()));

        assertEquals(2,customerService.getAllCustomers().size());
    }

    @Test
    @DisplayName("Get a Customer Test")
    public void successfulyGetACustomer(){
        CustomerService customerService = new CustomerService();
        Customer customer = new Customer(123,"waq","pak","wm9@g.com",new Product());
        Mockito.when(customerRepository.findById(123)).thenReturn(Optional.of(customer));
        Optional<Customer> actualResponse = customerService.getCustomer(123);

        Assertions.assertThat(actualResponse.get().getName()).isEqualTo(customer.getName());
    }

    @Test
    @DisplayName("Creates A Customer Test")
    public void createACustomer(){
        CustomerService customerService = new CustomerService();
        Customer customer = new Customer(1,"Waq","Pak","wm99@g.com",new Product());
        Mockito.when(customerRepository.save(customer)).thenReturn(customer);
        customerService.createCustomer(customer);
        Mockito.verify(customerRepository,Mockito.times(1)).save(ArgumentMatchers.any(Customer.class));
    }
}