package com.example.product.repository;
import com.example.product.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

 /*Repository Interface
     To take advantages of Spring Data JPA, create the ProductRepository interface.
     Spring Data JPA will generate implementation code for the most common CRUD operations – we don’t have to write a single query.*/

@Repository

public interface ProductRepository extends JpaRepository<Product, Integer> { //generic type

}