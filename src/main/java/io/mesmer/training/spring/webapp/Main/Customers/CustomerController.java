package io.mesmer.training.spring.webapp.Main.Customers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @RequestMapping("")
    public String index(){
        return "Greetings Customers!";
    }

    // List Customers
    @RequestMapping("/customers")
    public List<Customer> getCustomers(){
        return customerService.getAllCustomers();
    }

    // Get A Customer
    @RequestMapping("/customers/{id}")
    public Optional<Customer> getCustomer(@PathVariable int id){
        return customerService.getCustomer(id);
    }


    @RequestMapping(method = RequestMethod.POST,value = "/customers")
    public void createCustomers(@RequestBody Customer customer){
        customerService.createCustomer(customer);
    }

    @RequestMapping(method = RequestMethod.PUT,value="/customers/{id}")
    public void updateCustomers(@RequestBody Customer customer, @PathVariable int id){
        customerService.updateCustomer(customer);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/deleteCustomers/{id}")
    public void deleteCustomer(@PathVariable int id){
        customerService.deleteCustomer(id);
    }

}
