package com.pluralsight.NorthwindTradersAPI.controller;

import com.pluralsight.NorthwindTradersAPI.data.ProductDao;
import com.pluralsight.NorthwindTradersAPI.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    ProductDao productDao;

    @RequestMapping(path = "products")
    public List<Product> getAll() {
        List<Product> products = productDao.getAll();
        return products;
    }

    @RequestMapping(path = "products/{id}")
    public Product findById(@PathVariable int id) {
        return productDao.getById(id);
    }

    @RequestMapping(path = "/products", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.CREATED)
    public Product addProduct(@RequestBody Product product) {
        Product newProduct = productDao.insert(product);
        return product;
    }

    @RequestMapping(path = "products/{id}", method = RequestMethod.POST)
    public void updateProduct(@PathVariable int id , @PathVariable Product product) {
        productDao.update(id, product);

    }
}
