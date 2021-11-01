package com.example.product.controller;

import com.example.product.model.Product;
import com.example.product.service.ProductService;
import java.util.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.http.*;

import org.springframework.web.bind.annotation.*;

@RestController
public class ProductController {

  @Autowired
  private ProductService service;

  // RESTful API methods for Retrieval operations

  @GetMapping("/products")
  public List<Product> list() {
    return service.listAll();
  }

  @GetMapping("/products/{id}")
  public ResponseEntity<Product> get(@PathVariable Integer id) {
    try {
      Product product = service.get(id);
      return new ResponseEntity<Product>(product, HttpStatus.OK);
    } catch (NoSuchElementException e) {
      return new ResponseEntity<Product>(HttpStatus.NOT_FOUND);
    }
  }
}
