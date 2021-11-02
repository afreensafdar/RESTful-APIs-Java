package com.example.product.controller;
import com.example.product.model.Product;
import com.example.product.service.ProductService;
import java.util.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

/*REST Controller Class
     exposes RESTful APIs for CRUD operations – a Spring controller following REST style.*/
@RestController
// @RestController annotation define controller and enables the handler methods in this controller to be exposed as RESTful APIs,handles routes


@RequestMapping(path="api/products")
public class ProductController {

  private final ProductService service;

  @Autowired //using class to pass args as constructor
  public ProductController(ProductService service) {
    this.service = service;
  }
  /*RESTful API for Create Operation
  @PostMapping annotation, this method handles only HTTP POST request */

  @PostMapping("/products")
  public void add(@RequestBody Product product) {
    service.save(product);
  }


  //=======================================================================================
   /*Handles GET request inside REST controller
  RESTful API is a method that returns a list of product (a kind of retrieval operation) */

  @GetMapping("/products")
  public List<Product> list() {
    return service.listAll();
  }

  // Method for a RESTful API that allows view information about a specific product based on Id.
/*  if a product is found for the given ID, the server sends a response that includes JSON representation of the Product
     object with HTTP status OK (200). Else if no product is found, it returns HTTP status Not Found (404). */

  @GetMapping("/products/{id}")
  public ResponseEntity<Product> get(@PathVariable Integer id) { //PathVariable define url variables for endpoints
    try {
      Product product = service.get(id);
      return new ResponseEntity<Product>(product, HttpStatus.OK); //status 200
    } catch (NoSuchElementException e) {
      return new ResponseEntity<Product>(HttpStatus.NOT_FOUND); //status 404
    }
  }


  //=======================================================================================
  /* RESTful API method for Update operation
  The @PutMapping annotation specifies that this method accepts only HTTP PUT request.
       If a product found with the given ID, it is updated and the server returns HTTP status OK. If no product found,
     the HTTP status Not Found (404) is returned.*/
  @PutMapping("/products/{id}")
  public ResponseEntity<?> update(@RequestBody Product product, @PathVariable Integer id) { //RequestBody defines data transfer object sent in request body
    try {
      Product existProduct = service.get(id);
      service.save(product);
      return new ResponseEntity<>(HttpStatus.OK);
    } catch (NoSuchElementException e) {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }


  //=======================================================================================
 /*RESTful API method for Update operation */
  @DeleteMapping("/products/{id}")
  public void delete(@PathVariable Integer id) {
    service.delete(id);
  }





}
