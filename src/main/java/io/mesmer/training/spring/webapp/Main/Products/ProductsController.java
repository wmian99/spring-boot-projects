package io.mesmer.training.spring.webapp.Main.Products;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ProductsController {
    @Autowired
    private ProductService productService;

    @RequestMapping("/products")
    public List<Product> listProducts(){
        return productService.allProducts();
    }

    @RequestMapping("/products/{id}")
    public Optional<Product> getProduct(@PathVariable int id){
        return productService.getProduct(id);
    }

    @RequestMapping(method = RequestMethod.POST,value = "/products")
    public void buildProduct(@RequestBody Product product){
        productService.createProduct(product);
    }

    @RequestMapping(method = RequestMethod.PUT,value = "/products/{id}")
    public void buildProduct(@RequestBody Product product, @PathVariable int id){
        productService.updateProduct(product,id);
    }
}
