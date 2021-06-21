package io.mesmer.training.spring.webapp.Customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    // List Customers
    @RequestMapping("")
    public List<Customer> getCustomers(){
        return customerService.getAllCustomers();
    }

    // Get A Customer
    @RequestMapping("/{id}")
    public Optional<Customer> getCustomer(@PathVariable int id){
        return customerService.getCustomer(id);
    }


    @RequestMapping(method = RequestMethod.POST)
    public void createCustomers(@RequestBody Customer customer){
        customerService.createCustomer(customer);
    }

    @RequestMapping(method = RequestMethod.PUT,value="/{id}")
    public void updateCustomers(@RequestBody Customer customer, @PathVariable int id){
        customerService.updateCustomer(customer);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/delete/{id}")
    public void deleteCustomer(@PathVariable int id){
        customerService.deleteCustomer(id);
    }

}
