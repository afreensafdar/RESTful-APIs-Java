package com.example.product.repository;
import com.example.product.model.Product;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

 /*Repository Interface
     To take advantages of Spring Data JPA, create the ProductRepository interface.
     Spring Data JPA will generate implementation code for the most common CRUD operations – we don’t have to write a single query.*/

@Repository
@EnableJpaRepositories({"com.example.product.repository.ProductRepository"})

public interface ProductRepository extends JpaRepository<Product, Integer> { //generic type

}