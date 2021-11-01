package com.example.product.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="PRODUCTSS")
public class Product {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;
  @Column
  private String name;
  @Column
  private String brand;
  @Column
  private float price;

  public Product() {
  }

  public Product(Integer id, String name,String brand,  float price) {
    this.id = id;
    this.name = name;
    this.brand = brand;
    this.price = price;
  }

  public String getName() {
    return name;
  }

  public String getBrand() {
    return brand;
  }

  public float getPrice() {
    return price;
  }

  public Integer getId() {
    return id;
  }

  // getters and setters..

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

}