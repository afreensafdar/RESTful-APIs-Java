package com.example.product.service;
import com.example.product.model.Product;
import com.example.product.repository.ProductRepository;
import java.util.List;
import javax.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

/*  Service Class
 A class that acts as a middle layer between persistence layer (repository) and controller layer .
 this business/service class simply forwards the calls to an implementation of the ProductRepository interface. */
@Service
@RequiredArgsConstructor//lets Spring to look for new instances
@Transactional

//all the methods are executed in transactions because this class is marked with the @Transactional annotation.
public class ProductService {

  @Autowired
  private ProductRepository repo;


  /*public ProductService(ProductRepository repo) {
    this.repo = repo;
  } */

  public List<Product> listAll() {
    return repo.findAll();
  }


  public Product get(Integer id) {
    return repo.findById(id).get();
  }


  public Product save(Product product) {
    String hashedPassword = Hasher.hash(product.getPassword());
    System.out.println(hashedPassword);
    product.setPassword(hashedPassword);
    return this.repo.save(product);

  }
  public void delete(Integer id) {

    repo.deleteById(id);
  }

}