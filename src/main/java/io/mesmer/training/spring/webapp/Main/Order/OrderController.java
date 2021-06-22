package io.mesmer.training.spring.webapp.Main.Order;

import io.mesmer.training.spring.webapp.Main.Customers.Customer;
import io.mesmer.training.spring.webapp.Main.Products.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OrderController {

    @Autowired
    private OrderService orderService;

    // Add a product to customer
    @RequestMapping(method= RequestMethod.POST,value="/addCustomerProduct")
    public void addCustomerProduct(@RequestBody Product product){
        orderService.addCustomerProd(product);
    }

    // list all products of a customer
    @RequestMapping("customer/{id}/products")
    public List<Product> customerProducts(@PathVariable int id){
        return orderService.customerProducts(id);
    }
}
