package com.example.product.service;

import com.example.product.model.Product;
import com.example.product.repository.ProductRepository;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ProductService {


  private ProductRepository repo;

  @Autowired
  public ProductService(ProductRepository repo) {
    this.repo = repo;
  }

  public List<Product> listAll() {
    return repo.findAll();
  }

  public Product get(Integer id) {
    return repo.findById(id).get();
  }

  public void save(Product product) {
    repo.save(product);
  }

  public void delete(Integer id) {
    repo.deleteById(id);
  }


}