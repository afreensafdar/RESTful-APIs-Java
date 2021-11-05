package com.example.product.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/* Domain Model Class
create the Product class to map with the product table in the database */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity //Jpa automatically maps class to Db table
@Table(name="PRODUCTS") //name of table where record to be stored ,rename table

public class Product {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY) //id should be generated automatically
  private Integer id;
  @Column (name = "Product_Name") // @Column
  private String name;
  @Column (name = "Product_Brand")
  private String brand;
  @Column (name = "Product_Price")
  private float price;
  @Column (name="password")
  private String password;


// Getters and Setters..

  public String getName() { return name; }

  public String getBrand() { return brand; }

  public float getPrice() { return price; }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setBrand(String brand) {
    this.brand = brand;
  }

  public void setPrice(float price) {
    this.price = price;
  }
  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

}