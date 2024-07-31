package com.example.productmanager.service;

import com.example.productmanager.model.Product;

import java.util.List;

public interface ProductService {
    List<Product> getAll();
    void create(Product product);
    Product findById(int id);
    void update(int id, Product product);
    void delete(int id);
}
